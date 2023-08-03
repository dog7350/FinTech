const express = require("express");
const app = express();

console.log("dirname : " + __dirname);
console.log("filename : " + __filename);

// app.set("views", "./views");
app.set("views", __dirname + "/views");
app.set("view engine", "ejs");

let cnt = 0;

app.get("/non_fetch", (req, res) => {
    cnt++;
    console.log(cnt + " : non_fetch 서버 연동");
    res.render("non_fetch", { cnt });
});

app.get("/fetch01", (req, res) => { // 페이지를 받는 것이 아닌 데이터만 전송 받음
    cnt++;
    console.log(cnt + " : fetch01 서버 연동");
    res.render("fetch01", { cnt });
});

app.get("/get_count", (req, res) => {
    cnt++;
    console.log(cnt + " : get_count 서버 연동");
    res.json( { cnt : cnt } );
});
app.get("/fetch_count", (req, res) => {
    res.render("fetch_count");
});

app.get("/rest", (req, res) => {
    res.render("rest");
});
app.get("/test", (req, res) => {
    res.json("get 데이터 요청!");
});
app.post("/test", (req, res) => {
    res.json("post 데이터 추가!");
});
app.put("/test", (req, res) => {
    res.json("put 데이터 수정!");
});
app.delete("/test", (req, res) => {
    res.json("delete 데이터 삭제!");
});

app.listen(3000, () => { console.log("3000 연동") });