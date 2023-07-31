/*
const oracleDB = require("oracledb");
const dbConfig = require("../../../config/database/db_config");
oracleDB.autoCommit = true;
*/

const ser = require("../../service/member/member_service");

const list = async (req, res) => {
    const list = await ser.getList();
    console.log("controller list : " + list);
    /*
    let con = await oracleDB.getConnection(dbConfig);
    console.log("con : ", con);
    oracleDB.outFormat = oracleDB.OBJECT; // 2차원 배열 형태를 딕셔너리 형태로 변경

    let result = await con.execute("SELECT * FROM members02");
    console.log("result : ", result);
    */

    // res.send( list );
    res.render("member/member_index", {list});
}

const register = async (req,res) => {
    console.log("register : ", req.body);

    let msg = await ser.insert(req.body);

    res.send( msg );
}
const registerForm = (req, res) => {
    res.render("member/register_form");
}

const memberView = async (req, res) => {
    console.log("memberView ctrl : " + req.params);
    const member = await ser.getMember( req.params );
    //res.send("memberView");
    res.render("member/member_view", { member } );
}

const modify = async (req, res) => {
    console.log("ctrl modify : " + req.body);
    const msg = await ser.modify(req.body);
    res.send(msg);
}
const modifyForm = async (req, res) => {
    const member = await ser.getMember(req.query);
    res.render("member/modify_form", { member });
}

const deleteData = async (req, res) => {
    const msg = await ser.deleteData(req.params);
    res.send(msg);
}

module.exports = { list, register, registerForm, memberView, modify, modifyForm, deleteData };