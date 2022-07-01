import {reqGoodsInfo, reqAddOrUpdateShopCart} from '@/api'
import {getUUID} from '@/utils/uuid_token';

export default {
    namespaced: true,
    //准备actions用于响应组件中的动作
    actions: {
        //获取产品信息的action
        async getGoodInfo({commit}, skuid) {
            let result = await reqGoodsInfo(skuid);
            if (result.code == 200) {
                commit("GETGOODINFO", result.data);
            }
        },
        //加入购物车的||修改某一个产品的个数
        async addOrUpdateShopCart({commit}, {skuId, skuNum}) {
            //发请求:前端带一些参数给服务器【需要存储这些数据】，存储成功了，没有给返回数据
            //不需要在三连环（仓库存储数据了）
            //注意:async函数执行返回的结果一定是一个promise【要么成功，要么失败】
            let result = await reqAddOrUpdateShopCart(skuId, skuNum);
            if (result.code == 200) {
                //返回的是成功的标记
                return "ok";
            } else {
                //返回的是失败的标记
                return Promise.reject(new Error("failed"));
            }
        },
    },
    //准备mutations用于操作数据
    mutations: {
        GETGOODINFO(state, goodInfo) {
            state.goodInfo = goodInfo;
        },
    },
    //准备state用于存储数据
    state: {
        goodInfo: {},
        uuid_token: getUUID()
    },
    //准备getters用于对state数据加工
    getters: {
        categoryView(state) {
            return state.goodInfo.categoryView || {};
        },
        skuInfo(state) {
            return state.goodInfo.skuInfo || {};
        },

        spuSaleAttrList(state) {
            return state.goodInfo.spuSaleAttrList || [];
        },
    }
}
