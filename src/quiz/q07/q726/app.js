const express = require("express");
const Crouter = require("./routes/common_router");
const Mrouter = require("./routes/member/member_router");
const app = express();

app.set("views", "./views");
app.set("view engine", "ejs");

app.use("/", Crouter);

app.use("/member", Mrouter);

app.listen(3000, () => { console.log("Server Starting...") } );