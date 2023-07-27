const express = require("express");
const ctrl = require("../controller/test_controller04");
const router = express.Router();

router.get("/", ctrl.index );

router.get("/test1", ctrl.test1 );

router.get("/test2", ctrl.test2 );

module.exports = router;