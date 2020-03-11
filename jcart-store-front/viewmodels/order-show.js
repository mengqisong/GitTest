var app = new Vue({
    el: '#app',
    data: {
        orderId: '',
        status: '',
        totalPrice: '',
        rewordPoints: '',
        createTimestamp: '',
        updateTimestamp: '',
        shipMethod: '',
        shipAddress: '',
        shipPrice: '',
        payMethod: '',
        invoiceAddress: '',
        invoicePrice: '',
        comment: '',
        orderProducts: [],
        orderHistories: [],
        statuses: ['待处理','处理中','待发货','已发货','待签收' ,'已签收' ,'待支付' ,'已支付' ,'取消' ,'拒绝' ,'完成' ,'待评价' , '已评价' ],
        shipMethods: ['EMS' ,'顺丰' ,'圆通','中通','申通' ],
        payMethods: ['货到付款' ,'借记卡' ,'信用卡' ,'微信支付' ,'支付宝' ]
    },
    mounted() {
        console.log('view mounted');

        var url = new URL(location.href);
        this.orderId = url.searchParams.get("orderId");
        if (!this.orderId) {
            alert('orderId is null');
            return;
        }

        this.getOrderById();
    },
    methods: {
        getOrderById() {
            axios.get('/order/getById', {
                params: {
                    orderId: this.orderId
                }
            })
                .then(function (response) {
                    console.log(response);
                    var orderDTO = response.data;
                    app.status = orderDTO.status;
                    app.totalPrice = orderDTO.totalPrice;
                    app.rewordPoints = orderDTO.rewordPoints;
                    app.createTimestamp = orderDTO.createTimestamp;
                    app.updateTimestamp = orderDTO.updateTimestamp;
                    app.shipMethod = orderDTO.shipMethod;
                    app.shipAddress = orderDTO.shipAddress;
                    app.shipPrice = orderDTO.shipPrice;
                    app.payMethod = orderDTO.payMethod;
                    app.invoiceAddress = orderDTO.invoiceAddress;
                    app.invoicePrice = orderDTO.invoicePrice;
                    app.comment = orderDTO.comment;
                    app.orderProducts = orderDTO.orderProducts;
                    app.orderHistories = orderDTO.orderHistories;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})