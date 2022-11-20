const mongoose = require('mongoose');

const userSchema = new mongoose.Schema({
    userName: {
        type: String,
        required: true
    },

    email: {
        type: String
    },
  
    password: {
        type: String,
        max: 1024,
        min: 6
    },
    //might change to make it less specific
    date: {
        type: Date,
        default: Date.now
    },
    //bank balance 
    checkings: {
        type: int
    },
    savings: {
        type: int
    }



});

module.exports = mongoose.model('User', userSchema);