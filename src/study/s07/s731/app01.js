const express = require("express");
const app = express();

let con;

app.get("/", (req, res) => {
    console.log("1. 연동전");
    con = connect();
    con.then( ( msg ) => { // 약속(Promise)으로부터 전송된 결과값의 처리
        console.log("3. 연동 완료 후 특정 기능 사용 가능");
        res.send("con => " + msg);
    } );
} )

app.get("/async", async (req, res) => {
    console.log("1. 연동전 async");
    con = await connect(); // await : 비동기 방식의 결과값이 돌아올 때까지 대기
    console.log("3. 연동 완료 후 특정 기능 사용 가능 > async");
    res.send("con => " + con);
} )

const connect = () => {
    let msg;
    return new Promise( (resolve) => setTimeout( () => { // 비동기 방식을 동기 방식으로 처리할 수 있도록 해주는 Promise
        msg = "DB 연동 되었습니다.";
        console.log("2. DB 연동하는 중...");
        resolve( msg ); // then으로 결과 전송 및 실행
    }, 1000 ) );
    // return msg;
}

app.listen(3000, () => { console.log("3000 서버 실행"); } )