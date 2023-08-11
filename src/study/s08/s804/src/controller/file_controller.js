const fs = require("fs");

const views = {
    index : (req, res) => {
        res.render("file_index");
    },
    list : (req, res) => {
        fs.readdir("./upload_file", (err, files) => {
            console.log("=== 비동기 ===");
            console.log(files);
        });
        const fileList = fs.readdirSync("./upload_file");
        console.log("=== 동기 방식 ===");
        console.log(fileList);
        
        res.render("file_list", { files : fileList });
    },
    download : (req, res) => {
        const filePath = `./upload_file/${req.params.fileName}`;
        res.download(filePath);
    },
    modifyForm : (req, res) => {
        const fileName = req.params.fileName;
        res.render("modify_form", { fileName });
    }
}

const process = {
    upload : (req, res) => {
        console.log("=== ctrl upload ===");
        console.log(req.body);
        console.log("-------------------");
        console.log(req.file);
        console.log("-------------------");
        console.log("req.fileValidation : ", req.fileValidation);
        console.log("-------------------");
        if (req.fileValidation) {
            return res.send(req.fileValidation);
        }
        res.send("upload");
    },
    deleteFile : (req, res) => {
        fs.unlinkSync(`./upload_file/${req.params.fileName}`);
        res.redirect("/file/list");
    },
    modify : (req, res) => {
        console.log("=== modify ===");
        console.log(req.file);

        if (req.file) {
            return res.redirect(`/file/deleteFile/${req.body.originalFileName}`);
        }

        res.redirect("/file/list");
    }
}

module.exports = { views, process };