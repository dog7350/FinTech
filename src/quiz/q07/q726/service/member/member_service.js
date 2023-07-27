const member = require("../../database/memberDAO");

const list = () => {
    return member;
}

const login_check = (id, name) => {
    for (i = 0; i < member.length; i++) {
        if (id == member[i].id) {
            if(name == member[i].name) return 1;
            else return 0;
        }
    }

    return -1;
}

const user = (id) => {
    for (i = 0; i < member.length; i++) {
        if (id == member[i].id) {
            return member[i];
        }
    }
    return 0;
}

module.exports = { login_check, list, user };