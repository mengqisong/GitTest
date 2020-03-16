var app = new Vue({
    el: '#app',
    data: {
        pageInfo:'',
        pageNum: 1,
        productCode: '',
        productName: '',
        price: '',
        stockQuantity: '',
        selectedStatus: '',
        statuses: [
            { value: 0, label: '下架' },
            { value: 1, label: '上架' },
            { value: 2, label: '待审核' }
        ]
    },
    mounted(){
        console.log("view mounted");
        this.searchProduct();
    },
    methods:{
        handleEdit(index,row){
            console.log("product edit click",index, row)
            this.$router.push('/product/update/' + row.productId);
        },
        handleSearchClick(){
            console.log('search click');
            this.pageNum = 1;
            this.searchProduct();
        },
        handlePageChange(val){
            console.log('page change');
            this.pageNum = val;
            this.searchProduct();
        },
        handleClearClick() {
            console.log('clear click');
            this.productCode = '';
            this.productName = '';
            this.price = '';
            this.stockQuantity = '';
            this.selectedStatus = '';
        },
        searchProduct(){
            axios.get('/product/search', {
                params: {
                    productCode: this.productCode,
                    productName: this.productName,
                    price: this.price,
                    stockQuantity: this.stockQuantity,
                    status: this.selectedStatus,
                    pageNum: this.pageNum
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.pageInfo = response.data;
                    console.log(app.pageInfo.list);
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})