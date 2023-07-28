const express = require("express");
const ctrl = 
        require("../../controller/cookie/cookie_ctrl");
const router = express.Router();

router.get("/", ctrl.index );
router.get("/popup", ctrl.popup );

router.get("/cookie02", ctrl.cookie02 );
router.get("/popup02", ctrl.popup02 );
router.get("/makeCookie", ctrl.makeCookie );

router.get("/cart", ctrl.cart );

router.get("/save1", ctrl.save1 );
router.get("/save2/:goods", ctrl.save2 );

router.get("/view_list", ctrl.viewList );

module.exports = router;












