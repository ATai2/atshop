import axios from 'axios'

// 创建axios实例
const service = axios.create({
  baseURL: process.env.BASE_API, // api 的 base_url
  // baseURL: '"http://localhost:8100"', // api 的 base_url
  timeout: 5000 // 请求超时时间
})

export default service
