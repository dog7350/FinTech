const express = require("express");
const mc = require("../../controller/member/member_controller");
const router = express.Router();

router.get("/login", mc.login );

router.get("/login_check", mc.login_check );

router.get("/list", mc.list );

router.get("/info", mc.info );

module.exports = router;