const express = require('express');
const bodyParser = require('body-parser');
const nodemailer = require('nodemailer');
const app = express();
const port = 3000;

app.use(bodyParser.json());

// Nodemailer transporter setup
const transporter = nodemailer.createTransport({
    service: 'Gmail',
    auth: {
        user: 'rr200560@rguktrkv.ac.com',
        pass: 'Password@123'
    }
});

// Endpoint to handle sending notifications
app.post('/send-notification', (req, res) => {
    const { message, email } = req.body;

    // Send email
    const mailOptions = {
        from: 'rr200560@rguktrkv.ac.com',
        to: email,
        subject: 'Notification',
        text: message
    };

    transporter.sendMail(mailOptions, (error, info) => {
        if (error) {
            return res.status(500).json({ error: error.toString() });
        }
        res.status(200).json({ message: 'Notification sent successfully!' });
    });

    // Here you can also add code to interact with your database
});

app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}/`);
});
