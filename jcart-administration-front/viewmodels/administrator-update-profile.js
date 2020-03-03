var app = new Vue({
    el: '#app',
    data: {
        administratorId:'',
        username:'',
        realName:'',
        email:'',
        avatarUrl:'',
        createTimestamp:''
    },
    mounted(){
        console.log("view mounted");
        this.getMyProfile();
    },
    methods:{
        handleUpdateClick(){
            console.log("update click");
            this.updateMyProfile();
        },

        getMyProfile(){
            axios.get('/administrator/getProfile')
                .then(function (response) {
                    // handle success
                    console.log(response);
                    var me = response.data;
                    app.administratorId = me.administratorId;
                    app.username = me.username;
                    app.realName = me.realname;
                    app.email = me.email;
                    app.createTimestamp = me.createTimestamp;
                    app.avatarUrl = me.avatarUrl;
                })
                .catch(function (error) {
                    // handle error
                    console.log(error);
                })
                .then(function () {
                    // always executed
                });
        },
        updateMyProfile(){
            axios.post('/administrator/updateProfile', {
                administratorId: this.administratorId,
                username: this.username,
                realName: this.realName,
                email: this.email,
                avatarUrl: this.avatarUrl,
                createTimestamp: this.createTimestamp
              })
              .then(function (response) {
                console.log(response);
                alert("更新成功");
              })
              .catch(function (error) {
                console.log(error);
              });
        }
    }
})