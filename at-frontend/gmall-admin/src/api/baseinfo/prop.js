import request from '@/utils/request'

export default {

  // 查找一级分类
  getCatalog1() {
    return request({
      url: 'goods/getCatalog1',
      method: 'post'
    })
  },

  // 查找二级分类
  getCatalog2(catalog1Id) {
    return request({
      url: 'goods/getCatalog2?catalog1Id=' + catalog1Id,
      method: 'post'
    })
  },

  // 查找三级分类
  getCatalog3(catalog2Id) {
    return request({
      url: 'goods/getCatalog3?catalog2Id=' + catalog2Id,
      method: 'post'
    })
  },

  // 根据三级分类id获取属性列表
  getAttrInfoList(catalog3Id) {
    return request({
      url: 'goods/attrInfoList?catalog3Id=' + catalog3Id,
      method: 'get'
    })
  },

  // 根据属性id获取属性值列表
  getAttrValueList(attrId) {
    return request({
      url: 'goods/getAttrValueList?attrId=' + attrId,
      method: 'post'
    })
  },

  // 保存属性
  saveAttrInfo(attrForm) {
    return request({
      url: 'goods/saveAttrInfo',
      method: 'post',
      data: attrForm
    })
  }
}
