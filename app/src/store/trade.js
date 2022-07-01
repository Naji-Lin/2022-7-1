import {reqAddressInfo, reqOrderInfo} from "@/api";

export default {
    namespaced: true,
    //准备actions用于响应组件中的动作
    actions: {
        //获取用户地址信息
        async getUserAddress({commit}) {
            let result = await reqAddressInfo();
            if (result.code == 200) {
                commit("GETUSERADDRESS", result.data);
            }
        },
        //获取商品清单数据
        async getOrderInfo({commit}) {
            let result = await reqOrderInfo();
            if (result.code == 200) {
                commit("GETORDERINFO", result.data);
            }
        },
    },
    //准备mutations用于操作数据
    mutations: {
        GETUSERADDRESS(state, address) {
            state.address = address;
        },
        GETORDERINFO(state, orderInfo) {
            state.orderInfo = orderInfo;
        }
    },
    //准备state用于存储数据
    state: {
        address: [],
        orderInfo: {}
    },
    //准备getters用于对state数据加工
    getters: {}
}
