import Vue from 'vue'
import App from './App.vue'
import router from '@/router'
import TypeNav from '@/components/TypeNav'
import Carousel from '@/components/Carousel'
import Pagination from '@/components/Pagination'
import store from '@/store/index'
import '@/mock/mockServe'
import 'swiper/css/swiper.css'
import {MessageBox} from 'element-ui';
import VueLazyload from 'vue-lazyload';
import atm from '@/assets/1.gif';
import "@/plugins/validate";

Vue.config.productionTip = false
Vue.component(TypeNav.name, TypeNav)
Vue.component(Carousel.name, Carousel)
Vue.component(Pagination.name, Pagination)
Vue.use(VueLazyload, {
    //懒加载默认的图片
    loading: atm
});

Vue.prototype.$msgbox = MessageBox;
Vue.prototype.$alert = MessageBox.alert;

import * as API from '@/api';

new Vue({
    render: h => h(App),
    router,
    store,
    beforeCreate() {
        Vue.prototype.$bus = this
        Vue.prototype.$API = API;
    }
}).$mount('#app')
