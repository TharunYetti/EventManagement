package com.tremendoustrio.EventManagement.service;

import com.tremendoustrio.EventManagement.entity.EventCard;
import com.tremendoustrio.EventManagement.entity.RegistrationCard;
import com.tremendoustrio.EventManagement.entity.Student;
import com.tremendoustrio.EventManagement.model.StudentRequest;
import com.tremendoustrio.EventManagement.repository.EventRepository;
import com.tremendoustrio.EventManagement.repository.RegistrationRepository;
import com.tremendoustrio.EventManagement.repository.StudentRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ReminderService {
    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private SpringTemplateEngine templateEngine;

    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Scheduled(cron = "0 20 12 * * ?") // daily at 9AM
    public void sendEventReminders(){
        LocalDate tomorrow = LocalDate.now().plusDays(1);

        List<EventCard> upcomingEvents = eventRepository.findUpcomingEvents(tomorrow.format(dateFormatter));

        for (EventCard event : upcomingEvents) {
            List<RegistrationCard> attendees = registrationRepository.findAttendeesByEventName(event.getEventName());
            for (RegistrationCard user : attendees) {
                try {
                    sendReminderEmail(user, event);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    private void sendReminderEmail(RegistrationCard user, EventCard event) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        Context context = new Context();
        context.setVariable("name", user.getName());
        context.setVariable("eventName", event.getEventName());
        context.setVariable("eventDate", event.getDate());
        context.setVariable("eventLocation", event.getVenue());

        String html = templateEngine.process("reminder-email-template", context);

        helper.setTo( studentRepository.getEmailByUsername(user.getUsername()) );
        helper.setSubject("Reminder: Upcoming Event " + event.getEventName());
        helper.setText(html, true);

        mailSender.send(message);
    }


}
