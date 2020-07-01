package com.websystique.springmvc.dao;

import java.math.BigDecimal;

public interface AccountDao {
    int getMaxValue();
    BigDecimal sum();
}
