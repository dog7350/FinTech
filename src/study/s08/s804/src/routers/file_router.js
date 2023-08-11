const router = require("express").Router();

const multer = require("multer");
//파일을 저장할 폴더 위치
//const upload = multer({dest: "upload_file"}); //dest : 파일목적지
const stg = multer.diskStorage( {
    destination : (req, file, cb) => { // req , file 파일명 ,cb 목적지(파일저장위치)
        console.log("=== dest ====");
        cb (null,"upload_file"); // (null(고정)(기본값),위치)
    },
    filename : (req, file, cb) => {//저장 파일명 변경
        console.log("=== filename ====");
        console.log(file);
        // cb(null,"test"); //cb(null,"원하는 파일명")
        //cb(null, file.originalname);//원래 이름으로 전송,확장자까지 완벽하게
        cb(null, Date.now() + "-" + file.originalname);//시간초 + 파일명
    }
});

const f_Filter = (req, file, cb) => {
    console.log("=== filter ===");
    const type = file.mimetype.split("/")[0]; // mimetype [0][0] /image
    console.log("type : ", type);
    if (type === "image") { //img파일만 저장
        cb(null,true);
    } else {
        //req = {test : "....."};
        // req.test = "이미지만 저장하세요!!!!";
        req.fileValidation = "이미지만 저장하세요!!!!";
        cb(null,false);
    }
    // cb(null, true); // true : 파일을 저장 false : 저장 X
}

const upload = multer( { storage : stg, fileFilter : f_Filter } );

const filectrl = require("../controller/file_controller");

router.get("/", filectrl.views.index );

router.post("/upload", upload.single("file_name"), //single("파일이름"):단일파일, arr():배열형식으로 여러파일
            filectrl.process.upload);

router.get("/list", filectrl.views.list);

router.get("/download/:fileName", filectrl.views.download);

router.get("/deleteFile/:fileName", filectrl.process.deleteFile);

router.get("/modify_form/:fileName", filectrl.views.modifyForm);

router.post("/modify", upload.single("newFileName"), //single("파일이름"):단일파일, arr():배열형식으로 여러파일
            filectrl.process.modify);

module.exports = router;