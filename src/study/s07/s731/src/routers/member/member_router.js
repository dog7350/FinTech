const router = require("express").Router();
const member = require("../../controller/member/member_ctrl");

router.get("/", (req, res) => { console.log("/member 연동"); } )

router.get("/list", member.list);

router.post("/register", member.register);
router.get("/register_form", member.registerForm);

router.get("/member_view/:id", member.memberView);

router.post("/modify", member.modify);
router.get("/modify_form", member.modifyForm);

router.get("/delete/:id", member.deleteData);

module.exports = router;