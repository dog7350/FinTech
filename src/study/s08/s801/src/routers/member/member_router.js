const ctrl = require("../../controller/member/member_ctrl");
const router = require("express").Router();

router.get("/loginForm", ctrl.loginForm);
router.post("/login", ctrl.login);

router.get("/logout", ctrl.logout);

router.get("/memberList", ctrl.memberList);

router.get("/joinForm", ctrl.joinForm);
router.post("/join", ctrl.join);

router.get("/info/:id", ctrl.info);

router.get("/delete/:id", ctrl.delMember);

router.get("/modifyForm/:id", ctrl.modifyForm);
router.post("/modify", ctrl.modify);

module.exports = router;