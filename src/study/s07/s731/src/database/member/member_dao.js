const oracleDB = require("oracledb");
const dbConfig = require("../../../config/database/db_config");
oracleDB.autoCommit = true;

const getList = async () => {
    oracleDB.outFormat = oracleDB.OBJECT;
    let con = await oracleDB.getConnection(dbConfig);
    let result = await con.execute("SELECT * FROM members02");
    await con.close();
    console.log("dao getList : " + result);
    return result;
}

const insert = async (body) => {
    let con = await oracleDB.getConnection(dbConfig);
    const sql = `INSERT INTO members02(id, pwd, name, addr) VALUES(:id, :pwd, :name, :addr)`; // POST name과 같은 key의  값이 들어오는 매핑

    let result = 0;
    try {
        result = await con.execute(sql, body);
        console.log("dao insert : " + result);
    } catch (e) {
        console.log(e);
    }

    return result;
}

const getMember = async (mId) => {
    const sql = `SELECT * FROM members02 WHERE id=:id`;

    let con = await oracleDB.getConnection(dbConfig);
    let result = 0;

    try {
        result = await con.execute(sql, mId);
        console.log("dao getmember : " + result);
    } catch (e) {
        console.log(e);
    }

    return result.rows[0];
}

const modify = async (body) => {
    const sql = `UPDATE members02 SET pwd='${body.pwd}', name='${body.name}', addr='${body.addr}' WHERE id='${body.id}'`;
    
    let con = await oracleDB.getConnection(dbConfig);
    let result = 0;

    try {
        result = await con.execute(sql);
        console.log("dao modify : " + result);
    } catch (e) {
        console.log(e);
    }

    return result;
}

const deleteData = async (mId) => {
    const sql = `DELETE FROM members02 WHERE id=:id`;
    
    let con = await oracleDB.getConnection(dbConfig);
    let result = 0;

    try {
        result = await con.execute(sql, mId);
        console.log("dao delete : " + result);
    } catch (e) {
        console.log(e);
    }

    return result;
}

module.exports = { getList, insert, getMember, modify, deleteData };