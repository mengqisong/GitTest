package io.mqs.jcartstoreback.service;

import io.mqs.jcartstoreback.po.Return;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnService {
    Integer create(Return aReturn);
}
