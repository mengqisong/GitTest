const routes = [
    { path: '/product/search', component: ProductSearchRoutePage },
    { path: '/customer/search', component: CustomerSearchRoutePage },
    { path: '/order/search', component: OrderSearchRoutePage },
    { path: '/return/search', component: ReturnSearchRoutePage },
    { path: '/product/update', component: ProductUpdateRoutePage },
    { path: '/administrator/index', component: AdministratorIndexRoutePage },

    
];

const router = new VueRouter({
    routes: routes
});