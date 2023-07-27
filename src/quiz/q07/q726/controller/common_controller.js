const main = (req, res) => {
    console.log("MAIN Page");
    res.render("index");
}

module.exports = { main };