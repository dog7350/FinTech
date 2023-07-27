const member = require("../db/memberDAO");
const index = (req, res) => {
    console.log("=== index 컨트롤러 연결 ===");
    console.log(member);
    res.render("index");
}

const test1 = (req, res) => {
    res.render("test1");
}

const test2 = (req, res) => {
    res.render("test2");
}

module.exports = {index : index, test1 : test1, test2};