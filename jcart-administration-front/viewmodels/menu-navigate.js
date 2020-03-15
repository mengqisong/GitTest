var app = new Vue({
    router :  router,
    el: '#app',
    data: {
        jcProductId:'',
        selectMainPage:''
    },
    methods:{
        handleOpen(){
            console.log("click handleOpen")
        },
        handleClose(){
            console.log("click handleClose");
        },
        handleMenuItemClick(val){
            console.log('menu item click', val.index);
            switch(val.index){
                case '1-1':
                    router.push("product/search");break;
                case '2-1':
                    this.$router.push("customer/search");break;
            }
        }
    }

})