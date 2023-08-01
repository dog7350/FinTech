const ser = require("../../service/member/member_service");

const loginForm = (req, res) => {
    res.render("index", { url: "/loginForm", user: req.session.user })
}
const login = async (req, res) => {
    let result = await ser.login(req.body);

    if (result.user != 0) req.session.user = result.user;

    res.send(result.str);
}

const logout = (req, res) => {
    req.session.destroy();
    res.redirect("/");
}

const memberList = async (req, res) => {
    if (req.session.user == undefined) {
        return res.send(`<script>
                            alert("로그인하세요 ㅡㅡ");
                            location.href = "/member/loginForm";
                        </script>`);
    }

    let list = await ser.getList();

    res.render("index", { url: "/list", user: req.session.user, list });
}

const joinForm = (req, res) => {
    res.render("index", { url: "/joinForm", user: req.session.user });
}
const join = async (req, res) => {
    let result = await ser.join(req.body);

    res.send(result);
}

const info = async (req, res) => {
    let result = await ser.info(req.param("id"));

    res.render("index", { url: "/info", user: req.session.user, info: result })
}

const delMember = async (req, res) => {
    id = req.param("id");
    let result = await ser.delMember(id);

    if (id == req.session.user.ID) {
        req.session.destroy();
        res.send(`<script>
                    alert("탈퇴 되었습니다.);
                    location.href = "/";
                  </script>`);
    } else {
        res.send(`<script>
                    alert("삭제 되었습니다");
                    location.href = "/member/memberList";
                  </script>`);
    }
}

const modifyForm = async (req, res) => {
    let result = await ser.info(req.param("id"));

    res.render("index", { url: "/modify", user: req.session.user, info: result });
}

const modify = async (req, res) => {
    let result = await ser.upMember(req.body);

    res.send(result);
}

module.exports = { loginForm, login, logout, memberList, joinForm, join, info, delMember, modifyForm, modify };