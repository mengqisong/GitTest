var app = new Vue({
    el: '#app',
    data: {
        username:"",
        password:""
    },
    methods: {
        handleLoginClick(){
            console.log("login click");
            this.administratorlogin();
        },
        administratorlogin(){
            axios.get('/administrator/login', {
                params: {
                  username: this.username,
                  password: this.password
                }
              })
              .then(function (response) {
                console.log(response);
                var dto = response.data;
                localStorage['jcartToken'] = dto.token;
                localStorage['expireTimestamp'] = dto.expireTimestamp;
                alert("登录成功");
              })
              .catch(function (error) {
                console.log(error);
              })
              .then(function () {
                // always executed
              });  
        }
    }
})