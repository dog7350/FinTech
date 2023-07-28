const cookieConfig = {
    httpOnly : true,
    maxAge : 50000,
    signed : true
}
const index = (req, res)=>{
    let userCookie = req.signedCookies.myCookie;
    console.log( req.cookies );
    res.cookie("myCookie", "valueCookie", cookieConfig)
    res.render("cookie/cookie01" ,{userCookie});
}
const popup = (req, res)=>{
    res.render("cookie/popup" );
}
const cookie02 = (req, res)=>{
    const userCookie = req.cookies.myCookie;
    res.render( "cookie/cookie02" , {userCookie} );
}
const popup02 = (req, res)=>{
    res.render( "cookie/popup02" );
}
const makeCookie = (req, res)=>{
    res.cookie("myCookie","value", cookieConfig);
    res.send("<script>window.close()</script>");
}
//////////////////////////////////////////////////////////////
const ser = require("../../service/cookie/cookie_service");
const cart = (req, res)=>{
    res.render("cookie/cart", { list: ser.cart() } );
}
const save1 = (req, res)=>{
    console.log("=== save1 ===");
    console.log( "param : "+ req.param("id") );
    console.log( "query : ",req.query );
    console.log( "params : ",req.params );
    res.send("save1 연결");
}
const save2 = (req, res)=>{
    console.log("=== save222 ===");

    let cart_list = req.signedCookies.cart_list;
    if( cart_list === undefined ){
        cart_list = {};
    }

    cart_list = ser.save2(cart_list , req.params.goods );
    res.cookie("cart_list", cart_list, cookieConfig );

    console.log("cart_list : ", cart_list);

    console.log( "param : "+ req.param("goods") );
    console.log( "query : " , req.query );
    console.log( "params : " , req.params );
    const msg = `<script>
                    alert("${req.params.goods} 상품이 등록되었습니다");
                    location.href = "/cookie/cart";
                </script>`;
    res.send( msg );
}
const viewList = (req, res) => {
    let cart_list = req.signedCookies.cart_list;
    if( !cart_list ){ //cart_list === undefined
        const msg = `<script>
                    alert("저장된 목록이 없습니다");
                    location.href = "/cookie/cart";
                </script>`;
        res.send( msg );
    }
    res.render("cookie/view_list", 
                    {list : ser.view_list(cart_list) })
}
module.exports = { viewList , save1, save2, cart , makeCookie, 
    index , popup , cookie02 , popup02 };