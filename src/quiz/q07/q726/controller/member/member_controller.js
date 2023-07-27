const service = require("../../service/member/member_service");

const login = (req, res) => {
    console.log("LOGIN Page");
    res.render("member/login");
}

const login_check = (req, res) => {
    flag = service.login_check(req.param("id"), req.param("name"));
    console.log(flag);

    if (flag == 0) res.send("<script>alert('ID 또는 이름이 일치하지 않습니다.'); history.back();</script>");
    else if (flag == -1) res.send("<script>alert('회원이 존재하지 않습니다.'); history.back();</script>");
    else res.redirect("/member/list");
}

const list = (req, res) => {
    console.log("LIST Page");
    member = service.list();
    res.render("member/list", { member });
}

const info = (req, res) => {
    console.log("INFO Page");
    user = service.user(req.param("id"));
    res.render("member/info", { user });
}

module.exports = { login, login_check, list, info };