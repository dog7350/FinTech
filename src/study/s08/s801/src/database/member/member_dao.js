const db = require("oracledb");
const config = require("../../../config/database/db_config");
db.autoCommit = true;
db.outFormat = db.OBJECT;

const getList = async () => {
    const sql = `SELECT * FROM members02`;

    let con = await db.getConnection(config);
    let result = 0;

    try {
        result = await con.execute(sql);
    } catch (e) {
        console.log(e);
    }

    return result.rows;
}

const getMember = async (id) => {
    const sql = `SELECT * FROM members02 WHERE id='${id}'`;

    let con = await db.getConnection(config);
    let result = 0;

    try {
        result = await con.execute(sql);
    } catch (e) {
        console.log(e);
    }

    return result.rows[0];
}

const join = async (body) => {
    const sql = `INSERT INTO members02(id, pwd, name, addr) VALUES(:id, :pw, :name, :addr)`;

    let con = await db.getConnection(config);
    let result = 0;

    try {
        result = await con.execute(sql, body);
    } catch (e) {
        console.log(e);
    }

    return result;
}

const delMember = async (id) => {
    const sql = `DELETE FROM members02 WHERE id='${id}'`;

    let con = await db.getConnection(config);
    let result = 0;

    try {
        result = await con.execute(sql);
    } catch (e) {
        console.log(e);
    }

    return result;
}

const upMember = async (body) => {
    const sql = `UPDATE members02 SET pwd=:pw, name=:name, addr=:addr WHERE id=:id`;

    let con = await db.getConnection(config);
    let result = 0;

    try {
        result = await con.execute(sql, body);
    } catch (e) {
        console.log(e);
    }

    return result;
}

module.exports = { getMember, getList, join, delMember, upMember };