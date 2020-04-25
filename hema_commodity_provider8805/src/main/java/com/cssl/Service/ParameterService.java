package com.cssl.Service;

import com.cssl.entity.Parameter;

public interface ParameterService {
    public int savParameter(Parameter parameter);

    public int delParameter(Integer commid);
}
