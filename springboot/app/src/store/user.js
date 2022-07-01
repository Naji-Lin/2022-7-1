import {reqGetCode, reqUserRegister, reqUserLogin, reqUserInfo, reqLogout} from "@/api";
import {setToken, getToken, removeToken} from "@/utils/token";

export default {
    namespaced: true,
    //准备actions用于响应组件中的动作
    actions: {
        //获取验证码
        async getCode({commit}, phone) {
            let result = await reqGetCode(phone);
            if (result.code == 200) {
                commit("GETCODE", result.data);
                return "ok";
            } else {
                return Promise.reject(new Error("failed"));
            }
        },
        //用户注册
        async userRegister({commit}, user) {
            let result = await reqUserRegister(user);
            if (result.code == 200) {
                return "ok";
            } else {
                return Promise.reject(new Error("failed"));
            }
        },
        //登录业务
        async userLogin({commit}, data) {
            let result = await reqUserLogin(data);
            if (result.code == 200) {
                //用户已经登录成功且获取到token
                commit("USERLOGIN", result.data.token);
                //持久化存储token
                setToken(result.data.token);
                return "ok";
            } else {
                return Promise.reject(new Error("failed"));
            }
        },
        //获取用户信息
        async getUserInfo({commit}) {
            let result = await reqUserInfo();
            if (result.code == 200) {
                commit("GETUSERINFO", result.data);
                return 'ok';
            } else {
                return Promise.reject(new Error('failed'));
            }
        },
        //退出登录
        async userLogout({commit}) {
            //只是向服务器发起一次请求，通知服务器清除token
            let result = await reqLogout();
            //action里面不能操作state，提交mutation修改state
            if (result.code == 200) {
                commit("CLEAR");
                return 'ok';
            } else {
                return Promise.reject(new Error('failed'));
            }
        },
    },
    //准备mutations用于操作数据
    mutations: {
        GETCODE(state, code) {
            state.code = code;
        },
        USERLOGIN(state, token) {
            state.token = token;
        },
        GETUSERINFO(state, userInfo) {
            state.userInfo = userInfo;
        },
        //清除本地数据
        CLEAR(state) {
            //帮仓库中先关用户信息清空
            state.token = '';
            state.userInfo = {};
            //本地存储数据清空
            removeToken();
        }
    },
    //准备state用于存储数据
    state: {
        code: "",
        token: getToken(),
        userInfo: {},
    },
    //准备getters用于对state数据加工
    getters: {}
}
