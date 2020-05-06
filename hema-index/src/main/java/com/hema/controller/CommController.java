package com.hema.controller;

import com.hema.client.CommClient;
import com.hema.client.OrderClient;
import com.hema.client.UserClient;
import com.hema.userconfig.UserConfig;
import com.hemacommodity.*;
import com.hemauser.Address;
import com.hemauser.HemaUser;
import com.order.Order;
import com.order.Order_Comm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName CommController
 * @Description TODO
 * @Author DELL
 * @Date 2020/4/15 18:28
 * @Version 1.0
 **/
@Controller
public class CommController {
    @Autowired
    private CommClient cc;
    @Autowired
    private UserClient uc;
    @Autowired
    private OrderClient oc;
    //用户操作
    /*
    * 添加用户
    * */
    @PostMapping("/adduser")
    @ResponseBody
    public int adduser(HemaUser hemaUser,HttpSession session){
        String y=(String) session.getAttribute("yzm");
        System.out.println("(String) session.getAttribute(\"yzm\"):::::::"+y);
        String a= String.valueOf(hemaUser.getYzm());
        System.out.println("String.valueOf(hemaUser.getYzm()):::"+a);
        if(y.equals(a)){
            if(uc.addUser(hemaUser)>0){
                return 1;
            }else{
                return 0;
            }
        }else{
            return -1;
        }
    }
    /*
     * 注册时进行用户验证
     * */
    @PostMapping("/phoneVerify")
    @ResponseBody
    public boolean phoneVerify(String phone){
        return uc.phoneVerify(phone);
    }

    /*
     * 手机验证码发送
     * */
    @PostMapping("/yzm")
    @ResponseBody
    public String yzm(String phone, HttpSession session){
        if(!uc.phoneVerify(phone)){
            return "手机已注册 发送失败！！！";
        }else{
            UserConfig.duanxin(phone);
            session.setAttribute("yzm",UserConfig.RANDOM_NUM);
            System.out.println("后台发送:"+UserConfig.RANDOM_NUM);
            return "验证码成功发送，注意查收！！！";
        }
    }
    /*
     * 用户登陆
     * */
    @PostMapping("/login")
    @ResponseBody
    public boolean login(HemaUser user,HttpSession session){
        if(uc.login(user)){
            session.setAttribute("uname",user.getLoginname());
            List<Map<String,Object>> carlist=cc.carFadeAll(user.getLoginname());
            session.setAttribute("carlist",carlist);
        }
        return uc.login(user);
    }
    /*
     * 添加收货地址
     * */
    @PostMapping("/insert_Address")
    @ResponseBody
    public int insert_Address(Address add,HttpSession session){
        String uname=(String) session.getAttribute("uname");
        add.setLoginname(uname);
        return uc.insert_Address(add);
    }
    /*
     * 查询所有地址
     * */
    @RequestMapping("/addressFadeAll")
    public String addressFadeAll(HttpSession session,int cid){
            session.setAttribute("carid",cid);
        String username=(String) session.getAttribute("uname");
        session.setAttribute("addresslist",uc.addressFadeAll(username));
        return "checkout.html";
    }

    //订单操作
    /*
     * 添加订单，修改库存，增加销量
     * */
    @RequestMapping("/insertOrder")
    public String insertOrder(int addid,HttpSession session){
        Order order=new Order();
        int cid=(Integer) session.getAttribute("carid");
        String uname=(String) session.getAttribute("uname");
        order.setAddressid(addid);
        order.setLoginname(uname);
        //生成丁单号
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        String str = new SimpleDateFormat("yyMMddHHmmssms").format(new Date());
        order.setOrdernum(machineId+ String.format("%015d", hashCodeV)+str+uname);
        Parameter parameter=new Parameter();
        if(oc.insertOrder(order)>0){
            Order_Comm order_comm=new Order_Comm();
                if(cid!=0){
                    Map<String,Object> order_by_car=cc.carFadeByID(cid);
                    cc.delCar(cid);
                    order_comm.setOrdernum(machineId+ String.format("%015d", hashCodeV)+str+uname);
                    order_comm.setCommid((int)order_by_car.get("commid"));
                    order_comm.setCommname((String)order_by_car.get("commname"));
                    order_comm.setCommimg((String) order_by_car.get("commimg"));
                    order_comm.setOrdercommsum((int)order_by_car.get("commsum"));
                    order_comm.setOdert_comm_summoney((String) order_by_car.get("price"));
                    order_comm.setLoginname(uname);
                    parameter.setParameterid((int)order_by_car.get("parameterid"));
                    parameter.setStocknum((int)order_by_car.get("commsum"));
                    Commodity commodity=new Commodity();
                    commodity.setSales((int)order_by_car.get("commsum"));
                    commodity.setCommid((int)order_by_car.get("commid"));
                    cc.upt_sales(commodity);
                    oc.insert_Order_comm(order_comm);
                    cc.upt_Stocknum(parameter);
                }else{
                    List<Map<String,Object>> order_by_all=cc.carFadeAll(uname);
                    for(Map<String,Object> order_all:order_by_all){
                        cc.delCar((int)order_all.get("mycarid"));
                        order_comm.setOrdernum(machineId+ String.format("%015d", hashCodeV)+str+uname);
                        order_comm.setCommid((int)order_all.get("commid"));
                        order_comm.setCommimg((String) order_all.get("commimg"));
                        order_comm.setCommname((String)order_all.get("commname"));
                        order_comm.setOdert_comm_summoney((String) order_all.get("price"));
                        order_comm.setOrdercommsum((int)order_all.get("commsum"));
                        order_comm.setLoginname(uname);
                        parameter.setParameterid((int)order_all.get("parameterid"));
                       parameter.setStocknum((int)order_all.get("commsum"));
                        Commodity commodity=new Commodity();
                        commodity.setSales((int)order_all.get("commsum"));
                        commodity.setCommid((int)order_all.get("commid"));
                        cc.upt_sales(commodity);
                       oc.insert_Order_comm(order_comm);
                       cc.upt_Stocknum(parameter);
                    }
                }
        }
        List<Order> orderList= oc.order_FadeAll(uname);
        List<Order_Comm> order_commlist=oc.order_Comm_FadeAll(uname);
        session.setAttribute("orderlist",orderList);
        session.setAttribute("order_commlist",order_commlist);
        return "dashboard.html";
    }

    /*
    * 修改订单状态
    * */
    @RequestMapping("/upt_Order_State")
    public String upt_Order_State(HttpSession session,Order order){
        oc.upt_Order_State(order);
        String uname=(String) session.getAttribute("uname");
        List<Order> orderList= oc.order_FadeAll(uname);
        List<Order_Comm> order_commlist=oc.order_Comm_FadeAll(uname);
        session.setAttribute("orderlist",orderList);
        session.setAttribute("order_commlist",order_commlist);
        return "dashboard.html";
    }

    /*
    * 查看所有收货地址
    * */
    @RequestMapping("/order_FadeAll")
    public String order_FadeAll(HttpSession session){
        String loginname=(String) session.getAttribute("uname");
        List<Order> orderList= oc.order_FadeAll(loginname);
        List<Order_Comm> order_commlist=oc.order_Comm_FadeAll(loginname);
        session.setAttribute("orderlist",orderList);
        session.setAttribute("order_commlist",order_commlist);
        return "dashboard.html";

    }

    //商品操作
    /*
     * 网站首页
     * */
    @RequestMapping("/mumeFall")
    public String mumeFall(HttpSession session){
        //导航栏信息
        List<Classify> dh=  cc.mumeFall();
        session.setAttribute("dh",dh);
        //获得前台商品展示数据
        List<Map<String,Object>> index=cc.indexFall();
        session.setAttribute("show",index);
        //前台销量排序商品展示
        List<Map<String,Object>> sales=cc.salesFall();
        session.setAttribute("salesShow",sales);
        String uname=(String) session.getAttribute("uname");
        List<Map<String,Object>> carlist=cc.carFadeAll(uname);
        session.setAttribute("carlist",carlist);
        return "brezza.html";
    }

    @RequestMapping("/comm_Fade_ByName")  //搜索商品
    public String comm_Fade_ByName(String c_name,HttpSession session){
        List<Map<String,Object>> by_name_list=cc.comm_Fade_ByName(c_name);
        session.setAttribute("by_name",by_name_list);
        return "grid.html";
    }

    @RequestMapping("/comm_by_classifyid")
    public String comm_by_classifyid(int classifyid,HttpSession session){
        List<Map<String,Object>> by_id_list=cc.comm_by_classifyid(classifyid);
        session.setAttribute("by_name",by_id_list);
        return "grid.html";
    }

    /*
     * 商品详情
     * */
    @RequestMapping("/commDetails")
    public String commDetails(int cid,HttpSession session){
        //商品详情展示
        Map<String,Object> dcomm=cc.Details(cid);
        session.setAttribute("dcomm",dcomm);
        //商品图片展示
        List<Commimg> cimg=cc.imgFall(cid);
        session.setAttribute("cimg",cimg);
        //商品参数展示
        List<Parameter> parlist=cc.parameterFall(cid);
        session.setAttribute("parlist",parlist);
        //商品评论展示
        List<Discuss> dislist=cc.discussFall(cid);
        session.setAttribute("dislist",dislist);
        //根据客户选择的商品推荐类似商品
        List<Map<String,Object>> recolist=cc.recommend(cid);
        session.setAttribute("recolist",recolist);
        return "comm.html";
    }

    @RequestMapping("/parFadeById")
    @ResponseBody
    public Parameter parFadeById(int pid){
        return cc.parFadeById(pid);
    }

    /*
     * 我的喜欢
     * */
    @RequestMapping("/myLove")
    public String myLove(int cid,HttpSession session){
        MyLove love=new MyLove();
        String uname=(String) session.getAttribute("uname");
       if(uname==""||uname==null){
           return "login.html";
       }else{
           if(cid!=0){
               love.setLoginname(uname);
               love.setCommid(cid);
               cc.myLove(love);
           }
            List<Map<String,Object>> lovelist=cc.loveFall(uname);
            session.setAttribute("lovelist",lovelist);
           return "wishlist.html";
       }
    }

    /*
     * 删除我的喜欢
     * */
    @RequestMapping("/delLoveById")
    @ResponseBody
    public int delLoveById(int loveid,HttpSession session){
            return cc.delLoveById(loveid);
    }

    /*
     * 删除所有我的喜欢
     * */
    @RequestMapping("/delLoveFall")
    public String delLoveFall(HttpSession session){
        String loginname=(String) session.getAttribute("uname");
        cc.delLoveFall(loginname);
        List<Map<String,Object>> lovelist=cc.loveFall(loginname);
        session.setAttribute("lovelist",lovelist);
        return "wishlist.html";
    }

    /*
     * 添加购物车
     * */
    @RequestMapping("/insertCar")
    public String insertCar(MyCar car,HttpSession session){
        String uname=(String) session.getAttribute("uname");
        if(uname==""||uname==null){
            return "login.html";
        }else {
            car.setLoginname(uname);
            cc.insertCar(car);
            List<Map<String,Object>> carlist=cc.carFadeAll(uname);
            session.setAttribute("carlist",carlist);
            session.setAttribute("totalMoney",cc.totalMoney(uname));
            return "shop.html";
        }
    }

    /*
     * 查看我的购物车
     * */
    @RequestMapping("/show_Car")
    public String insertCar(HttpSession session){
        String uname=(String) session.getAttribute("uname");
        List<Map<String,Object>> carlist=cc.carFadeAll(uname);
        session.setAttribute("carlist",carlist);
        session.setAttribute("totalMoney",cc.totalMoney(uname));
        return "shop.html";
    }

    /*
     * 删除购物车商品
     * */
    @RequestMapping("/delCar")
    @ResponseBody
    public String delCar(int cid,HttpSession session){
        String uname=(String) session.getAttribute("uname");
        if(cc.delCar(cid)>0){
           return cc.totalMoney(uname);
        }
        return "no";
    }

    /*
     * 购物车修改金额
     * */
    @RequestMapping("/uptCarCommSum")
    @ResponseBody
    public Map<String,Object> uptCarCommSum(MyCar car,HttpSession session){
        String uname=(String) session.getAttribute("uname");
        car.setLoginname(uname);
        return cc.uptCarCommSum(car);
    }


}
