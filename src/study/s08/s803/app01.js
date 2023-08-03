const express = require("express");
const bcrypt = require("bcrypt");
const app = express();

app.get("/", (req, res) => {
    pwd = "test";
    chPwd = bcrypt.hashSync(pwd, 10);
    dePwd = bcrypt.compareSync(pwd, chPwd);
    console.log("비밀번호 : " + pwd);
    console.log("암호화 : " + chPwd);
    console.log("비교 : " + dePwd);
    res.send("test");
});

app.listen(3000, () => { console.log("3000 연동") });