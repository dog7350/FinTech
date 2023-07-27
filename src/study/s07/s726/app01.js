const express = require("express");
const app = express();

const router = express.Router();
const router2 = express.Router();

const member =require("./db/memberDAO");

app.set("views", "./views");
app.set("view engine", "ejs");

app.use("/", router);
app.use("/board", router2);

/*
app.get("/", (req, res) => {
    res.render("index");
} );
*/

router.get("/test1", (req, res) => {
    console.log(member);
    res.render("test1");
} );

router.get("/test2", (req, res) => {
    res.render("test2");
} );

router.get("/", (req, res) => {
    res.render("index");
} );

router.get("/member/index", (req, res) => {
    res.render("index");
} );

router2.get("/index", (req, res) => {
    res.send("/board/index 연결되었습니다!");
} );

app.listen(3000, () => { console.log("3000 Port Server"); } );