根据扫描结果，苍穹外卖后端项目提供了以下RESTful API接口，按功能模块分类如下：

## 一、管理端接口 (admin)

### 1. 员工管理 (`/admin/employee`)
- `POST /admin/employee/login` - 员工登录
- `POST /admin/employee/logout` - 员工退出
- `POST /admin/employee` - 新增员工
- `GET /admin/employee/page` - 员工分页查询
- `POST /admin/employee/status/{status}` - 启用/禁用员工
- `GET /admin/employee/{id}` - 根据ID查询员工
- `PUT /admin/employee` - 修改员工信息

### 2. 分类管理 (`/admin/category`)
- `GET /admin/category/page` - 分类分页查询
- `POST /admin/category` - 新增分类
- `POST /admin/category/status/{status}` - 启用/禁用分类
- `PUT /admin/category` - 修改分类
- `DELETE /admin/category/{id}` - 删除分类
- `GET /admin/category/list` - 根据类型查询分类列表

### 3. 菜品管理 (`/admin/dish`)
- `GET /admin/dish/page` - 菜品分页查询
- `POST /admin/dish` - 新增菜品
- `GET /admin/dish/{id}` - 根据ID查询菜品
- `PUT /admin/dish` - 修改菜品
- `POST /admin/dish/status/{status}` - 启用/禁售菜品
- `DELETE /admin/dish/{id}` - 删除菜品
- `GET /admin/dish/list` - 根据分类ID查询菜品列表

### 4. 套餐管理 (`/admin/setmeal`)
- `GET /admin/setmeal/page` - 套餐分页查询
- `POST /admin/setmeal` - 新增套餐
- `GET /admin/setmeal/{id}` - 根据ID查询套餐
- `PUT /admin/setmeal` - 修改套餐
- `POST /admin/setmeal/status/{status}` - 启用/禁售套餐
- `DELETE /admin/setmeal/{id}` - 删除套餐
- `GET /admin/setmeal/list` - 根据分类ID查询套餐列表

### 5. 订单管理 (`/admin/order`)
- `GET /admin/order/conditionSearch` - 订单搜索
- `GET /admin/order/statistics` - 各个状态的订单数量统计
- `GET /admin/order/details/{id}` - 查询订单详情
- `PUT /admin/order/confirm` - 接单
- `PUT /admin/order/rejection` - 拒单
- `PUT /admin/order/cancel` - 取消订单
- `PUT /admin/order/delivery/{id}` - 派送订单
- `PUT /admin/order/complete/{id}` - 完成订单

### 6. 数据统计 (`/admin/report`)
- `GET /admin/report/turnoverStatistics` - 营业额统计
- `GET /admin/report/userStatistics` - 用户统计
- `GET /admin/report/ordersStatistics` - 订单统计
- `GET /admin/report/top10` - 销量排名top10
- `GET /admin/report/export` - 导出Excel报表

### 7. 店铺管理 (`/admin/shop`)
- `PUT /admin/shop/{status}` - 设置营业状态
- `GET /admin/shop/status` - 获取营业状态

### 8. 工作台 (`/admin/workspace`)
- `GET /admin/workspace/businessData` - 今日运营数据
- `GET /admin/workspace/overviewOrders` - 订单管理数据
- `GET /admin/workspace/overviewDishes` - 菜品总览
- `GET /admin/workspace/overviewSetmeals` - 套餐总览

### 9. 通用接口 (`/admin/common`)
- `POST /admin/common/upload` - 文件上传

## 二、用户端接口 (user)

### 1. 用户登录 (`/user/user`)
- `POST /user/user/login` - 微信登录

### 2. 地址簿管理 (`/user/addressBook`)
- `GET /user/addressBook/list` - 获取地址列表
- `POST /user/addressBook` - 新增地址
- `GET /user/addressBook/{id}` - 根据ID获取地址
- `PUT /user/addressBook` - 修改地址
- `PUT /user/addressBook/default` - 设置默认地址
- `GET /user/addressBook/default` - 获取默认地址
- `DELETE /user/addressBook/{id}` - 删除地址

### 3. 分类查询 (`/user/category`)
- `GET /user/category/list` - 根据类型查询分类列表

### 4. 菜品查询 (`/user/dish`)
- `GET /user/dish/list` - 根据分类ID查询菜品列表

### 5. 套餐查询 (`/user/setmeal`)
- `GET /user/setmeal/list` - 根据分类ID查询套餐列表
- `GET /user/setmeal/dish/{id}` - 根据套餐ID查询包含的菜品

### 6. 购物车 (`/user/shoppingCart`)
- `POST /user/shoppingCart/add` - 添加购物车
- `GET /user/shoppingCart/list` - 查看购物车
- `DELETE /user/shoppingCart/clean` - 清空购物车
- `POST /user/shoppingCart/sub` - 减少购物车中商品数量

### 7. 订单 (`/user/order`)
- `POST /user/order/submit` - 提交订单
- `PUT /user/order/payment` - 订单支付
- `GET /user/order/historyOrders` - 历史订单查询
- `GET /user/order/orderDetail/{id}` - 查询订单详情
- `PUT /user/order/cancel/{id}` - 取消订单
- `POST /user/order/repetition/{id}` - 再来一单
- `GET /user/order/reminder/{id}` - 催单

### 8. 店铺状态 (`/user/shop`)
- `GET /user/shop/status` - 获取营业状态

## 三、支付回调接口 (notify)
- `POST /notify/paySuccess` - 支付成功回调

## 接口文档访问
项目已集成Knife4j（Swagger）文档，启动后端服务后可通过以下地址访问：
- **Swagger UI**: http://localhost:8088/doc.html
- **OpenAPI JSON**: http://localhost:8088/v3/api-docs

## 前端联调注意事项
1. **端口配置**: 后端已修改为8088端口（避免与前端8080冲突）
2. **跨域配置**: 项目已配置CORS，支持前端跨域请求
3. **认证机制**: 管理端使用JWT Token（header: `token`），用户端使用JWT Token（header: `authentication`）
4. **数据库连接**: 需要确保MySQL服务运行，并修改`application.yml`中的数据库密码为实际密码

## 快速启动后端服务
```bash
cd sky-server
mvn spring-boot:run
```

启动成功后，前端可基于上述接口进行联调。