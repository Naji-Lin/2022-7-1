import {reqCategoryList, reqBannerList, reqFloorList} from '@/api/index'

export default {
    namespaced: true,
    //准备actions用于响应组件中的动作
    actions: {
        async categoryList({commit}) {
            let result = await reqCategoryList();
            if (result.code == 200) {
                commit('CATEGORYLIST', result.data)
            }
        },
        async bannerList({commit}) {
            let result = await reqBannerList();
            if (result.code == 200) {
                commit('BANNERLIST', result.data)
            }
        },
        async floorList({commit}) {
            let result = await reqFloorList();
            if (result.code == 200) {
                commit('FLOORLIST', result.data)
            }
        }
    },
    //准备mutations用于操作数据
    mutations: {
        CATEGORYLIST(state, categoryList) {
            state.categoryList = categoryList
        },
        BANNERLIST(state, bannerList) {
            state.bannerList = bannerList
        },
        FLOORLIST(state, floorList) {
            state.floorList = floorList
        },
    },
    //准备state用于存储数据
    state: {
        categoryList: [],
        bannerList: [],
        floorList: []
    },
    //准备getters用于对state数据加工
    getters: {}
}
