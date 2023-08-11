const router = require("express").Router();
const pageCtrl = require("../controller/page_controller");

router.get("/", pageCtrl.views.index);
router.get("/list", pageCtrl.views.list);
router.get("/write_form", pageCtrl.views.writeForm);
router.get("/content/:num", pageCtrl.views.content);

router.post("/write", pageCtrl.process.write);

module.exports = router;