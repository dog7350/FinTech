const express = require("express");
const bodyParser = require("body-parser");
const session = require("express-session");
const sessionConfig = require("./config/cookie_session/cookie_session_config");

const app = express();

app.set("views", "./src/views");
app.set("view engine", "ejs");

app.use(session( sessionConfig.sessionConfig ));
app.use(bodyParser.urlencoded( {extended : true} ));
const router = require("./src/routers/router")(app);

app.use(express.static("public"));
app.use("/", router);

app.listen(3000, () => { console.log("Server Starting...") } );