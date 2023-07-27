const member = require("../db/memberDAO");

const index = () => {
    console.log("Service Index 연결");
    return member;
}

module.exports = {index};