const oracledb = require("oracledb");
const dbConfig = require("../../config/db_config");
oracledb.outFormat = oracledb.OBJECT;
oracledb.autoCommit = true;

const daoRead = {
    list : async (start, end) => {
        const sql = `SELECT B.* FROM (SELECT rownum rn, A.* FROM (SELECT * FROM paging ORDER BY num DESC) A) B WHERE rn BETWEEN ${start} AND ${end}`;
        const con = await oracledb.getConnection(dbConfig);
        const result = await con.execute(sql);
        return result;
    },
    content : async (num) => {
        const con = await oracledb.getConnection(dbConfig);
        const sql =`SELECT * FROM paging WHERE num='${num}'`;
        const data = await con.execute(sql);

        return data;
    },
    totalContent : async () => {
        const con = await oracledb.getConnection(dbConfig);
        const sql = "SELECT count(*) FROM paging";
        const totalContent = await con.execute( sql );
        return totalContent;
    }
}

const daoInsert = {
    write : async (body) => {
        const con = await oracledb.getConnection(dbConfig);
        const sql = "INSERT INTO paging VALUES(test_num.nextval, :title, sysdate, 0)";
        let result;
        
        try {
            result = await con.execute(sql, body);
        } catch(err) {
            console.log(err)
        }
    }
}

const daoUpdate = {
    upHit : async ( num ) => {
        const con = await oracledb.getConnection(dbConfig);
        const sql = `UPDATE paging SET count=count+1 WHERE num='${num}'`;
        await con.execute(sql);
    }
}

module.exports = { daoRead, daoInsert, daoUpdate };