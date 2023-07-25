const http = require('http'); //import
const fs = require("fs");

const app = http.createServer( (request, response) => {
    console.log("Server Create");
    response.writeHead(200, {'Content-Type':'text/html; charset=utf-8'} );
    console.log(request.url);

    if (request.url == "/") {
        response.end("Default Page");
    } else if (request.url == "/test") {
        fs.readFile("./test.html", (err, data) => {
            // err 없으면 null, err 발생 시 err 내용
            if (err) {
                throw err;
            }
        });
        response.end("Test Page");
    }
} );
app.listen(3000);