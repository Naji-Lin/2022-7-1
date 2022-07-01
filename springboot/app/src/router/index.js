import Vue from "vue";
import VueRouter from "vue-router";
import store from "@/store";

Vue.use(VueRouter)

import Home from '@/pages/Home'
import Login from '@/pages/Login'
import Register from '@/pages/Register'
import Search from '@/pages/Search'
import Detail from '@/pages/Detail'
import AddCartSuccess from '@/pages/AddCartSuccess'
import ShopCart from '@/pages/ShopCart'
import Trade from '@/pages/Trade'
import Pay from '@/pages/Pay'
import PaySuccess from '@/pages/PaySuccess'
import Center from '@/pages/Center'
import MyOrder from '@/pages/Center/myOrder'
import GroupOrder from '@/pages/Center/groupOrder'

let originPush = VueRouter.prototype.push
VueRouter.prototype.push = function (location, resolve, reject) {
    if (reject && resolve) {
        originPush.call(this, location, resolve, reject)
    } else {
        originPush.call(this, location, () => {
        }, () => {
        })
    }
}

let originReplace = VueRouter.prototype.replace
VueRouter.prototype.replace = function (location, resolve, reject) {
    if (reject && resolve) {
        originReplace.call(this, location, resolve, reject)
    } else {
        originReplace.call(this, location, () => {
        }, () => {
        })
    }
}


let router = new VueRouter({
    routes: [
        {
            path: '/center',
            component: Center,
            children: [
                {
                    // path: '/center/myorder',
                    path: 'myorder',
                    component: MyOrder,
                },
                {
                    path: 'grouporder',
                    component: GroupOrder,
                },

                {
                    path: '',
                    redirect: 'myorder'
                }
            ]
        },

        {
            path: '/paysuccess',
            component: PaySuccess,
            meta: {isShow: true},
            /* 只有从支付界面, 才能跳转到支付成功的界面 */
            beforeEnter(to, from, next) {
                if (from.path === '/pay') {
                    next()
                } else {
                    next('/pay')
                }
            }
        },
        {
            path: '/pay',
            component: Pay,
            meta: {isShow: true},
            // 将query参数映射成props传递给路由组件
            props: route => ({orderId: route.query.orderId}),
            /* 只能从交易界面, 才能跳转到支付界面 */
            beforeEnter(to, from, next) {
                if (from.path === '/trade') {
                    next()
                } else {
                    next('/trade')
                }
            }
        },
        {
            path: '/trade',
            component: Trade,
            meta: {isShow: true},
            /* 只能从购物车界面, 才能跳转到交易界面 */
            beforeEnter(to, from, next) {
                if (from.path === '/shopcart') {
                    next()
                } else {
                    next('/shopcart')
                }
            }
        },
        {
            path: '/shopcart',
            component: ShopCart,
            meta: {isShow: true}
        },
        {
            path: '/addcartsuccess',
            name: 'addcartsuccess',
            component: AddCartSuccess,
            meta: {isShow: true},
            /* 只有从支付界面, 才能跳转到支付成功的界面 */
            beforeEnter(to, from, next) {
                if (from.path === '/pay') {
                    next()
                } else {
                    next('/pay')
                }
            }
        },
        {
            path: '/detail/:skuid',
            component: Detail,
            meta: {isShow: true}
        },
        {
            path: '/home',
            component: Home,
            meta: {isShow: true}
        },
        {
            path: '/login',
            component: Login,
            meta: {isShow: false}
        },
        {
            path: '/register',
            component: Register,
            meta: {isShow: false}
        },
        {
            path: '/search/:keyword?',
            name: 'search',
            component: Search,
            meta: {isShow: true},
            props: route => ({keyword3: route.params.keyword, keyword4: route.query.keyword2})
        },
        {
            path: '*',
            redirect: '/home'
        }
    ],
    scrollBehavior(to, from, savedPosition) {
        //返回的这个y=0，代表的滚动条在最上方
        return {y: 0};
    },
})

//全局守卫：前置守卫（在路由跳转之间进行判断）
router.beforeEach(async (to, from, next) => {
    //获取仓库中的token-----可以确定用户是登录了
    let token = store.state.user.token;
    let name = store.state.user.userInfo.name;
    //用户登录了
    if (token) {
        //已经登录而且还想去登录------不行
        if (to.path == "/login" || to.path == '/register') {
            next('/');
        } else {
            //已经登陆了,访问的是非登录与注册
            //登录了且拥有用户信息放行
            if (name) {
                next();
            } else {
                //登陆了且没有用户信息
                //在路由跳转之前获取用户信息且放行
                try {
                    await store.dispatch('user/getUserInfo');
                    next();
                } catch (error) {
                    //token失效从新登录
                    await store.dispatch('user/userLogout');
                    next('/login')
                }
            }
        }
    } else {
        //未登录：不能去交易相关、不能去支付相关【pay|paysuccess】、不能去个人中心
        let toPath = to.path;
        if (toPath.indexOf('/trade') != -1 || toPath.indexOf('/pay') != -1 || toPath.indexOf('/center') != -1) {
            //把未登录的时候向去而没有去成的信息，存储于地址栏中【路由】
            next('/login?redirect=' + toPath);
        } else {
            //去的不是上面这些路由（home|search|shopCart）---放行
            next();
        }
    }
});

export default router;
