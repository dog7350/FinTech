const sessionConfig = {
    secret : "암호화 키",
    resave :false ,
    saveUninitialized : true,
    //cookie : { maxAge : 5000 },
}

module.exports = { sessionConfig };