const express = require("express");
const cookieParser = require("cookie-parser");
const cookieRouter = require("./src/routers/cookie/cookie_router");

const app = express();

app.use(cookieParser());
app.set("views", "./src/views");
app.set("view engine", "ejs");

app.use("/cookie", cookieRouter);

app.listen(3000, () => { console.log("3000 서버 구동"); } );