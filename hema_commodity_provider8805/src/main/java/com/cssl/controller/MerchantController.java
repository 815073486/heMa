package com.cssl.controller;

import com.cssl.Service.MerchantService;
import com.cssl.entity.Merchant;
import com.cssl.entity.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
import java.util.List;

@RestController
public class MerchantController {

    @Autowired
    private MerchantService mService;



    /**
     * 查询所有商家
     * @return
     */
    @RequestMapping("/merchantfall")
    public List<Merchant> fallMerchant(){

        return mService.queryMerchant();
    }

    /**
     * 删除商家
     * @param merchantid
     * @return
     */
    @RequestMapping("/merchantDel")
    public int merchantDel(@RequestParam(name = "merchantid") Integer merchantid){
        return mService.merchantDelete(merchantid);
    }

    /**
     * 添加商家
     * @param merchant
     * @return
     */
    @RequestMapping("/merchant")
    public int savMerchant(@RequestBody Merchant merchant){

        return mService.savMerchant(merchant);
    }

    /**
     * 修改商家
     * @return
     */
    @RequestMapping("/updateMerchant")
    public int updateMerchant(@RequestBody Merchant merchant){
        return mService.updateMerchant(merchant);
    }

}
