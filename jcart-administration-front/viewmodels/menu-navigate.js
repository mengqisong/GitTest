var app = new Vue({
    el: '#app',
    data: {
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
            this.selectMainPage = val.index;
        }
    }

})