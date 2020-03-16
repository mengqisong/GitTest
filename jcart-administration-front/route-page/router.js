const routes = [
    { path: '/product/search', component: ProductSearchRoutePage },
    { path: '/product/update', component: ProductUpdateRoutePage },
    { path: '/product/create', component: ProductCreateRoutePage },

    { path: '/administrator/index', component: AdministratorIndexRoutePage },
    { path: '/administrator/updateprofile', component: AdministratorUpdateProfileRoutePage },
    { path: '/administrator/create', component: AdministratorCreateRoutePage },
    

    { path: '/customer/search', component: CustomerSearchRoutePage },
    { path: '/customer/show/:customerId', component: CustomerShowRoutePage },

    { path: '/address/index/:customerId', component: AddressIndexRoutePage },
    { path: '/address/show/:addressId', component: AddressShowRoutePage },


    { path: '/order/search', component: OrderSearchRoutePage },
    { path: '/order/show/:orderId', component: OrderShowRoutePage },

    { path: '/return/search', component: ReturnSearchRoutePage },
    {
        path: '/return/edit/:returnId',
        component: ReturnEditRoutePage,
        children: [
            {
                path: 'show',
                component: ReturnShowRoutePage
            },
            ,
            {
                path: 'history',
                component: ReturnHistoryIndexRoutePage
            }
        ]
    }


    
];

const router = new VueRouter({
    routes: routes
});