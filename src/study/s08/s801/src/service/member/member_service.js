const dao = require("../../database/member/member_dao");

const getMessage = (msg, url) => {
    return `<script>
                alert('${msg}');
                location.href = '${url}';
            </script>`
}

const getList = async () => {
    let list = await dao.getList();

    return list;
}

const login = async (body) => {
    let user = await dao.getMember(body.id);

    let msg = "", url = "", str;
    if (user == 0) {
        msg = "등록된 아이디가 없습니다.";
        url = "/member/loginForm";
        str = getMessage(msg, url);
        return { user : 0, str };
    } else if (user.ID != body.id || user.PWD != body.pw) {
        msg = "ID 또는 PW가 틀렸습니다.";
        url = "/member/loginForm";
        str = getMessage(msg, url);
        return { user : 0, str };
    } else {
        msg = "로그인 성공!";
        url = "/";
        str = getMessage(msg, url);
        return { user, str };
    }
}

const join = (body) => {
    let result = dao.join(body);

    let msg = "", url = "", str;

    if (result == 0) {
        msg = "이미 존재하는 아이디 입니다.";
        url = "/joinForm";
        str = getMessage(msg, url);
        return str;
    } else {
        msg = "가입 되었습니다.";
        url = "/";
        str = getMessage(msg, url);
        return str;
    }
}

const info = async (id) => {
    let user = await dao.getMember(id);
    return user;
}

const delMember = async (id) => {
    let result = await dao.delMember(id);

    return result;
}

const upMember = async (body) => {
    let result = await dao.upMember(body);

    let msg = "", url = "", str;

    if (result == 0) {
        msg = "수정 실패";
        url = "/member/info/" + body.id;
        str = getMessage(msg, url);
        return str;
    } else {
        msg = "수정되었습니다.";
        url = "/member/info/" + body.id;
        str = getMessage(msg, url);
        return str;
    }
}

module.exports = { login, getList, join, info, delMember, upMember };