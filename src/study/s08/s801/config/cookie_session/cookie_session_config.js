const sessionConfig = {
    secret : "암호화 키",
    resave : false,
    saveUninitialized : true,
    //cookie : { maxAge : 5000 },
}

module.exports = { sessionConfig };

/*
    1. resave
        - true : 세션이 저장되어 있는 경우라도 새롭게 세션을 만듬
        - false : 세션이 저장되어 있고, 동일한 세션이라면 새롭게 만들지 않음

    2. saveUninitialized
        - true : 세션의 정보가 수정되던 아니던 무조건 다시 저장
        - false : 세션이 수정되면 저장, 그렇지 않으면 저장
*/