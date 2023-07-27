const cookieConfig = {
    httpOnly : true,
    maxAge : 5000
}

const index = (req, res) => {
    res.cookie("myCookie", "valueCookie", cookieConfig);
    let userCookie = req.cookies.myCookie;

    res.render("cookie/cookie_01", { userCookie });
}

const popup = (req, res) => {
    res.render("cookie/popup");
}

const quiz = (req, res) => {
    const userCookie = req.cookies.myCookie;
    res.cookie("myCookie", "valueCookie", cookieConfig);
    res.render("cookie/quiz", { userCookie });
}

module.exports = { index, popup, quiz };