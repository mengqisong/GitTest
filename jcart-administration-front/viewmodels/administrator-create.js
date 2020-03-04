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
        ],
        mainFileList: [],
        selectedMainPic: '',
        mainPicUrl: ''
    },
    mounted(){
        console.log('view mounted');
    },
    methods: {
        handleUploadMainClick(){
            console.log('upload main pic click');
            this.uploadMainImage();
        },
        handleOnMainChange(val) {
            this.selectedMainPic = val.raw;
        },
        uploadMainImage() {
            var formData = new FormData();
            formData.append("image", this.selectedMainPic);

            axios.post('/image/upload', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.mainPicUrl = response.data;
                    alert('上传成功');
                })
                .catch(function (error) {
                    console.log(error);
                    alert('上传失败');
                });
        },
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