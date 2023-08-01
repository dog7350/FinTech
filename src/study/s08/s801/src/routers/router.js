module.exports = (app) => {
    const memRouter = require("./member/member_router");
    app.use("/member", memRouter);

    const router = require("express").Router();

    router.get("/", (req, res) => {
        res.render("index", { url: "/", user: req.session.user });
    } );

    return router;
}