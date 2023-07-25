const express = require("express");
const app = express();

// views : 해당 위치에 ejs 파일이 존재한다는 명시
app.set("views", "./");
app.set("view engine", "ejs");

app.get("/", (req, res) => {
    res.end("기본 페이지 연동");
    res.render("index");
} );
app.get("/test", (req, res) => {
    res.end("test 페이지 연동");
} );

app.listen(3000, () => { console.log("3000 Server 연동") } );