import {reqCartList, reqDeleteCartById, reqUpdateCheckedByid} from "@/api";

export default {
    namespaced: true,
    //准备actions用于响应组件中的动作
    actions: {
        async getCartList({commit}) {
            let result = await reqCartList();
            if (result.code == 200) {
                commit("GETCARTLIST", result.data);
            }
        },
        async deleteCartListBySkuId({commit}, skuId) {
            let result = await reqDeleteCartById(skuId);
            if (result.code == 200) {
                return "ok";
            } else {
                return Promise.reject(new Error("failed"));
            }
        },
        async updateCheckedById({commit}, {skuId, isChecked}) {
            let result = await reqUpdateCheckedByid(skuId, isChecked);
            if (result.code == 200) {
                return "ok";
            } else {
                return Promise.reject(new Error("failed"));
            }
        },
        deleteAllCheckedCart({dispatch, getters}) {
            //context:小仓库，commit【提交mutations修改state】 getters【计算属性】 dispatch【派发action】 state【当前仓库数据】
            //获取购物车中全部的产品（是一个数组）
            let PromiseAll = [];
            getters.cartList.cartInfoList.forEach((item) => {
                let promise = item.isChecked == 1 ? dispatch("deleteCartListBySkuId", item.skuId) : "";
                //将每一次返回的Promise添加到数组当中
                PromiseAll.push(promise);
            });
            //只要全部的p1|p2....都成功，返回结果即为成功
            //如果有一个失败，返回即为失败结果
            return Promise.all(PromiseAll);
        },
        //修改全部产品的状态
        updateAllCartIsChecked({dispatch, state}, isChecked) {
            //数组
            let promiseAll = [];
            state.cartList[0].cartInfoList.forEach((item) => {
                let promise = dispatch("updateCheckedById", {skuId: item.skuId, isChecked});
                promiseAll.push(promise);
            });
            //最终返回结果
            return Promise.all(promiseAll);
        },
    },
    //准备mutations用于操作数据
    mutations: {
        GETCARTLIST(state, cartList) {
            state.cartList = cartList;
        },
    },
    //准备state用于存储数据
    state: {
        cartList: [],
    },
    //准备getters用于对state数据加工
    getters: {
        //当前形参state，当前仓库中的state，并非大仓库中的那个state
        cartList(state) {
            return state.cartList[0] || {};
        },
    }
}
