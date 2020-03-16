const AdministratorCreateRoutePage = {
    template: `
    <div id="app">
    <el-input v-model="username" placeholder="请输用户名"></el-input>
    <el-input v-model="password" placeholder="请输入密码"></el-input>
    <el-input v-model="email" placeholder="请输入邮箱"></el-input>
    <el-input v-model="realName" placeholder="请输入姓名"></el-input>
    <el-upload ref="avatarUrl" action="" :http-request="uploadMainImage" :limit="1" accept="image/*"
            :auto-upload="false" :on-change="handleOnMainChange" :file-list="mainFileList">
            <el-button slot="trigger" size="small" type="primary">请选择头像</el-button>
            <el-button size="small" type="success" @click="handleUploadMainClick">上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件</div>
        </el-upload>
        上传后主图：<el-link type="primary">{{mainPicUrl}}</el-link>

    <el-select v-model="selectStatus" placeholder="请选择状态">
        <el-option
          v-for="item in status"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
      <br>

    <el-button type="primary" @click="handleCreateClick">注册</el-button>


</div>

    `,
    data() {
        return {
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
        }
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
}