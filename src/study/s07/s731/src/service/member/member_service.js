const memberDAO = require("../../database/member/member_dao");

const getList = async () => {
    const result = await memberDAO.getList();
    console.log("service getList : " + result);
    return result.rows;
}

const insert = async (body) => {
    const result = await memberDAO.insert( body );
    
    let msg="", url="";

    if (result == 0) {
        msg = "문제 발생";
        url = "/member/register_form";
    } else {
        msg = "등록 성공";
        url = "/member/list";
    }

    const msgPack = getMessage(msg, url);
    return msgPack;
}

const getMessage = (msg, url) => {
    return `<script>
                alert('${msg}');
                location.href = '${url}';
            </script>`;
}

const getMember = (mId) => { // async, await을 사용하지 않는 경우 promise 형태로 들어오며 결과.rows가 불가능 
                            // DAO에서 미리 처리하여 전송하거나 결과.then으로 처리
    //console.log("service => " + await memberDAO.getMember(mId).rows);
    return memberDAO.getMember(mId);
}

const modify = async (body) => {
    const result = await memberDAO.modify(body);

    let msg = "", url = "";
    if (result == 0) {
        msg = "문제 발생";
        url = "/member/modify_form?id=" + body.id;
    } else {
        msg = "수정 되었습니다.";
        url = "/member/member_view/" + body.id;
    }

    const msgPack = getMessage(msg, url);
    return msgPack;
}

const deleteData = async (mId) => {
    const result = await memberDAO.deleteData(mId);

    let msg = "", url = "";

    if (result == 0) {
        msg = "문제 발생";
        url = "/member/member_view/" + mId;
    } else {
        msg = "삭제 되었습니다.";
        url = "/member/list";
    }

    const msgPack = getMessage(msg, url);
    return msgPack;
}

module.exports = { getList, insert, getMember, modify, deleteData };