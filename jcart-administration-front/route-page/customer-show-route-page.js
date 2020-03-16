const CustomerShowRoutePage = {
    template: `
    <div id="app">
    <el-button type="primary" @click="handleGoBack">返回</el-button>
    <br>
        客户用户名：{{username}} <br>
        客户姓名：{{realName}} <br>
        客户头像：{{avatarUrl}} <br>
        手机：{{mobile}} <br>
        邮箱：{{email}} <br>
        状态：{{statuses[status]}} <br> <br>
        注册时间：{{(new Date(createTimestamp)).toLocaleString()}} <br>
        订阅新闻：<span v-if="newsSubscribed">是</span><span v-else>否</span> <br>
        积分：{{rewordPoints}} <br>
        默认地址：{{defaultAddress}} <br>
        <br>
        <el-button type="primary" @click="handleAddressIndexClick">地址列表</el-button>
    </div>
    `,
    data() {
        return {
            customerId: '',
            username: '',
            realName: '',
            avatarUrl: '',
            mobile: '',
            email: '',
            status: '',
            createTimestamp: '',
            newsSubscribed: '',
            rewordPoints: '',
            defaultAddressId: '',
            defaultAddress: '',
            statuses: ['禁用','启用','不安全']
        }
    },
    mounted() {
        
        this.customerId = this.$route.params.customerId;
        if (!this.customerId) {
            alert('customerId is null');
            return;
        }

        this.getCustomerById();
    },
    methods: {
        handleGoBack() {
            console.log('go back click');
            this.$router.back();
        },
        handleGoBack() {
            console.log('go back click');
            this.$router.back();
        },
        handleAddressIndexClick() {
            this.$router.push('/address/index/' + this.customerId);
        },
        getCustomerById() {
            axios.get('/customer/show', {
                params: {
                    customerId: this.customerId
                }
            })
                .then((response) => {
                    console.log(response);
                    var customer = response.data;
                    this.username = customer.username;
                    this.realName = customer.realName;
                    this.avatarUrl = customer.avatarUrl;
                    this.mobile = customer.mobile;
                    this.email = customer.email;
                    this.status = customer.status;
                    this.createTimestamp = customer.createTime;
                    this.newsSubscribed = customer.newsSubscribed;
                    this.rewordPoints = customer.rewordPoints;
                    this.defaultAddressId = customer.defaultAddressId;
                    this.defaultAddress = customer.defaultAddress;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
}