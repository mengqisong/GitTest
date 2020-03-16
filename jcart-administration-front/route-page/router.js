const routes = [
    { path: '/product/search', component: ProductSearchRoutePage },
    { path: '/product/update', component: ProductUpdateRoutePage },
    { path: '/product/create', component: ProductCreateRoutePage },

    { path: '/administrator/index', component: AdministratorIndexRoutePage },
    { path: '/administrator/updateprofile', component: AdministratorUpdateProfileRoutePage },
    { path: '/administrator/create', component: AdministratorCreateRoutePage },
    

    { path: '/customer/search', component: CustomerSearchRoutePage },

    { path: '/order/search', component: OrderSearchRoutePage },

    { path: '/return/search', component: ReturnSearchRoutePage },


    
];

const router = new VueRouter({
    routes: routes
});