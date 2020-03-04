var app = new Vue({
    el: '#app',
    data: {
        username:'',
        password:'',
        email:'',
        realName:'',
        avatarUrl:'',
        selectStatus: 1,
        status:[
            { value: 1, label: '启用' },
            { value: 0, label: '禁用' }
        ]
    },
    mounted(){
        console.log('view mounted');
    },
    methods: {
        handleCreateClick(){
            console.log('create click');
            this.createAdministrator();
        },
       createAdministrator(){
        axios.post('/administrator/crate', {
            username: this.username,
            password: this.password,
            email: this.email,
            realName: this.realName,
            avatarUrl: this.avatarUrl,
            status: this.selectStatus
          })
          .then(function (response) {
            console.log(response);
            alert("创建成功");
          })
          .catch(function (error) {
            console.log(error);
          });
       }

    }
})