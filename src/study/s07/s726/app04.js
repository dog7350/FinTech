const express = require("express");
const app = express();
const router = require("./routers/test_router04");

app.set("views", "./views");
app.set("view engine", "ejs");

app.use("/", router);

app.listen(3000, () => { console.log("3000 Server") } );