package com.wei.ggkt.wechat.controller;


import com.alibaba.fastjson.JSONObject;
import com.wei.ggkt.exception.GgktException;
import com.wei.ggkt.model.wechat.Menu;
import com.wei.ggkt.result.Result;
import com.wei.ggkt.vo.wechat.MenuVo;
import com.wei.ggkt.wechat.service.MenuService;
import com.wei.ggkt.wechat.utils.ConstantPropertiesUtil;
import com.wei.ggkt.wechat.utils.HttpClientUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 订单明细 订单明细 前端控制器
 * </p>
 *
 * @author wei
 * @since 2022-04-30
 */
@RestController
@RequestMapping("/admin/wechat/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    //公众号菜单删除
    @DeleteMapping("removeMenu")
    public Result removeMenu() {
        menuService.removeMenu();
        return Result.ok(null);
    }

    //同步菜单方法
    @GetMapping("syncMenu")
    public Result createMenu() {
        menuService.syncMenu();
        return Result.ok(null);
    }

//    //获取access_token
    //TODO 这个方法是获取token，但其实可有可无，方法syncMenu()中 this.wxMpService.getMenuService().menuCreate(button.toJSONString())会自动获取
//    @GetMapping("getAccessToken")
//    public Result getAccessToken() {
//        //拼接请求地址
//        String buffer = "https://api.weixin.qq.com/cgi-bin/token" +
//                "?grant_type=client_credential" +
//                "&appid=%s" +
//                "&secret=%s";
//        //设置路径参数
//        String url = String.format(buffer,
//                ConstantPropertiesUtil.ACCESS_KEY_ID,
//                ConstantPropertiesUtil.ACCESS_KEY_SECRET);
//        //get请求
//        try {
//            String tokenString = HttpClientUtils.get(url);
//            //获取access_token
//            JSONObject jsonObject = JSONObject.parseObject(tokenString);
//            String access_token = jsonObject.getString("access_token");
//            return Result.ok(access_token);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new GgktException(20001,"获取access_token失败");
//        }
//    }

    //获取所有菜单，按照一级和二级菜单封装
    @GetMapping("findMenuInfo")
    public Result findMenuInfo() {
        List<MenuVo> list = menuService.findMenuInfo();
        return Result.ok(list);
    }

    //获取所有一级菜单
    @GetMapping("findOneMenuInfo")
    public Result findOneMenuInfo() {
        List<Menu> list = menuService.findMenuOneInfo();
        return Result.ok(list);
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Menu menu = menuService.getById(id);
        return Result.ok(menu);
    }

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result save(@RequestBody Menu menu) {
        menuService.save(menu);
        return Result.ok(null);
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result updateById(@RequestBody Menu menu) {
        menuService.updateById(menu);
        return Result.ok(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        menuService.removeById(id);
        return Result.ok(null);
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        menuService.removeByIds(idList);
        return Result.ok(null);
    }
}

