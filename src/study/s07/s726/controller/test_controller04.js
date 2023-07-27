const service = require("../services/test_service04");

const index = (req, res) => {
    const mem = service.index();
    res.render("index", { member : mem });
}

const test1 = (req, res) => {
    console.log("=== test1 컨트롤러 연결 ===");
    res.send("<script>alert('리턴');history.back();</script>");
}

const test2 = (req, res) => {
    res.render("test2");
}

module.exports = {index : index, test1 : test1, test2};