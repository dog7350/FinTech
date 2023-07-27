const express = require("express");
const cc = require("../controller/common_controller");
const router = express.Router();

router.get("/", cc.main );

module.exports = router;