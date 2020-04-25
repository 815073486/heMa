package com.cssl.Service;

import com.cssl.entity.Merchant;

import java.util.List;

public interface MerchantService {

    public int savMerchant(Merchant merchant);

    public List<Merchant> queryMerchant();

    public int merchantDelete(Integer merchantid);

    public int updateMerchant(Merchant merchantid);
}
