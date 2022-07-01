import {reqSearchInfo} from "@/api";

export default {
    namespaced: true,
    //准备actions用于响应组件中的动作
    actions: {
        async getSearchList({commit}, params = {}) {
            let result = await reqSearchInfo(params)
            if (result.code == 200) {
                commit('GETSEARCHLIST', result.data)
            }
        }
    },
    //准备mutations用于操作数据
    mutations: {
        GETSEARCHLIST(state, searchlist) {
            state.searchList = searchlist
        }
    },
    //准备state用于存储数据
    state: {
        searchList: {}
    },
    //准备getters用于对state数据加工
    getters: {
        //当前形参state，当前仓库中的state，并非大仓库中的那个state
        goodsList(state) {
            //state.searchList.goodsList如果服务器数据回来了，没问题是一个数组
            //假如网络不给力|没有网state.searchList.goodsList应该返回的是undefined
            //计算新的属性的属性值至少给人家来一个数组
            return state.searchList.goodsList || [];
        }
        ,
        trademarkList(state) {
            return state.searchList.trademarkList || [];
        },
        attrsList(state) {
            return state.searchList.attrsList || [];
        }
    }
}
