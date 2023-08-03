const ser = require("../../service/member/member_service");

const ejsViewRender = (req, res, url, obj) => {
    res.render("index", { url, user: req.session.user, obj });
}

const loginForm = (req, res) => {
    ejsViewRender(req, res, "/loginForm", null);
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

    ejsViewRender(req, res, "/list", list);
}

const joinForm = (req, res) => {
    ejsViewRender(req, res, "/joinForm", null);
}
const join = async (req, res) => {
    let result = await ser.join(req.body);

    res.send(result);
}

const info = async (req, res) => {
    let result = await ser.info(req.param("id"));

    ejsViewRender(req, res, "/info", result);
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

    ejsViewRender(req, res, "/modify", result);
}

const modify = async (req, res) => {
    let result = await ser.upMember(req.body);

    res.send(result);
}

module.exports = { loginForm, login, logout, memberList, joinForm, join, info, delMember, modifyForm, modify };