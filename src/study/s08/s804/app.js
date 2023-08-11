const express = require("express");
const app = express();

const bodyParser = require("body-parser");
app.use(bodyParser.urlencoded( { extended : false } ));

const router = require("./src/routers/router")(app);

app.set("views", __dirname + "/src/views");
app.set("view engine", "ejs");

app.use("/", router);
app.use("/static", express.static(__dirname + "/public"));

app.listen("3000", () => { console.log("3000연결성공") });