const express = require("express");
const bodyParser = require("body-parser");
const app = express();

let members = [
    {id:"aaa", pwd:"aaa", name:"홍길동", addr:"산골짜기"},
    {id:"bbb", pwd:"bbb", name:"김개똥", addr:"개똥별"},
    {id:"ccc", pwd:"ccc", name:"고길똥", addr:"마포구"},
    {id:"ddd", pwd:"ddd", name:"성룡", addr:"중국"},
    {id:"eee", pwd:"eee", name:"이소룡", addr:"정무문"},
    {id:"fff", pwd:"fff", name:"권상우", addr:"말죽거리"},
    {id:"ggg", pwd:"ggg", name:"마석도", addr:"금천구"},
    {id:"hhh", pwd:"hhh", name:"황정민", addr:"강서구"}
];

app.set("views", __dirname + "/views");
app.set("view engine", "ejs");

app.use(bodyParser.json());

app.get("/", (req, res) => {
    res.render("index");
});

app.get("/get_members", (req, res) => {
    res.json( members );
});

app.post("/register", (req, res) => {
    console.log(req.body);
    members = members.concat(req.body);
    console.log(members);
    res.json(1);
});

app.delete("/delete", (req, res) => {
    console.log(req.body);
    members = members.filter( mem => mem.id != req.body.id );
    res.json(1);
});

app.get("/search", (req, res) => { // "/search/:id"
    console.log(req.query);
    res.json(members.filter( mem => mem.id == req.query.id )); // req.params.id
});
/////////////////////////////////////////
app.get("/register_view", (req, res) => {
    res.render("register_view");
});
app.get("/check_id", (req, res) => {
    res.json(members.filter( mem => mem.id == req.query.fId ));
});

let memberCnt = 3;
app.get("/view_member", (req, res) => {
    memberCnt = 3;
    res.render("view_member");
});
app.get("/read_member", (req, res) => {
    res.json(members.filter( (mem, index) => index < memberCnt ));
    memberCnt += 3;
})

app.listen(3000, () => { console.log("3000 연동") });