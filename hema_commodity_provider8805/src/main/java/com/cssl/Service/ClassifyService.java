package com.cssl.Service;

import com.cssl.entity.Classify;

import java.util.List;

public interface ClassifyService {

    public List<Classify> fallClassify();

    public List<Classify> classifyId(Classify classify);
}
