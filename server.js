const express = require('express');
const app = express();
const router = express.Router();
const mongoose = require('mongoose')
const bodyParser = require('body-parser');
const passport = require("passport");
const passportLocalMongoose = require("passport-local-mongoose");
const LocalStrategy = require("passport-local");



var User = require("./models/user");

app.use(express.urlencoded({ extended: false }))
app.use(express.json());
mongoose.connect("mongodb+srv://group4:s0ftwar3@bankdata.tomj87l.mongodb.net/?retryWrites=true&w=majority", { useNewUrlParser: true, useUnifiedTopology: true }, connected());

//make sure db connected
function connected() {
    console.log('Connected to DB');
}

//routes
///home
app.get("/", function (req, res) {
    res.sendFile(__dirname + "/views/home.html");
});

//register form
app.get("/register", function (req, res) {
    res.sendFile(__dirname + "/views/register.html");
});

app.post("/register", function (req, res) {


    const user = new User({
        username: req.body.username,
        password : req.body.password
    });

    user.save((err, user) => {
        if (err) {
            res.status(500)
                .send({
                    message: err
                });
            return;
        } else res.sendFile(__dirname + "/views/homepage.html");
    });
});
//login form

app.get('/login', function (req, res) {
    res.sendFile(__dirname + "/views/login.html")
})

//

app.post('/login', function (req, res) {
    var userData = {
        username: req.body.username,
        password: req.body.password
    }
    new User(userData)
})


app.listen(1337)

