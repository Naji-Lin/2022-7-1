//将四个模块请求的接口函数统一暴露
import * as ownerTrademark from './product/ownerTradeMark';
import * as ownerAttr from './product/ownerAttr';
import * as ownerSpu from './product/ownerSpu';
import * as ownerSku from './product/ownerSku';

//对外暴露
export default {
  ownerTrademark,
  ownerAttr,
  ownerSku,
  ownerSpu
}
