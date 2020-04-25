package com.cssl.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.Service.CommodityService;
import com.cssl.Service.MerchantService;
import com.cssl.dao.CommodityDao;
import com.cssl.dao.MerchantDao;
import com.cssl.entity.Commodity;
import com.cssl.entity.Merchant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AutoConfigureAfter({MerchantDao.class})
public class MerchantServiceImpl extends ServiceImpl<MerchantDao, Merchant> implements MerchantService {

    @Autowired
    private MerchantDao mDao;

    @Autowired
    private CommodityDao cDao;

    /**
     * 添加商家
     * @param merchant
     * @return
     */
    @Override
    public int savMerchant(Merchant merchant) {

        return mDao.insert(merchant);
    }

    /**
     * 查询所有商家
     * @return
     */
    @Override
    public List<Merchant> queryMerchant() {
        QueryWrapper<Merchant> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("merchantid");

        return mDao.selectList(wrapper);
    }

    /**
     * 删除商家
     * @param merchantid
     * @return
     */
    @Override
    public int merchantDelete(Integer merchantid) {
        QueryWrapper<Commodity> wrapper=new QueryWrapper<>();
        wrapper.eq("merchantid",merchantid);
        if(cDao.selectList(wrapper).size()>0){
            return 0;
        }else{
            QueryWrapper<Merchant> wrapper1=new QueryWrapper<>();
            wrapper1.eq("merchantid",merchantid);
            return mDao.delete(wrapper1);
        }
    }

    /**
     * 修改商家
     * @param merchantid
     * @return
     */
    @Override
    public int updateMerchant(Merchant merchantid) {
        QueryWrapper<Merchant> wrapper=new QueryWrapper<>();
        wrapper.eq("merchantid",merchantid.getMerchantid());
        merchantid.setMerchantid(null);
        return mDao.update(merchantid,wrapper);
    }


}
