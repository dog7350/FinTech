const express = require("express");
const DBMember = require("../db/memberDAO");
const app = express();
const router = express.Router();

router.get("/", (req, res) => {
    console.log("DBmember : ", DBMember);
    res.render("index");
} );

router.get("/test1", (req, res) => {
    console.log(member);
    res.render("test1");
} );

router.get("/test2", (req, res) => {
    res.render("test2");
} );

module.exports = router;