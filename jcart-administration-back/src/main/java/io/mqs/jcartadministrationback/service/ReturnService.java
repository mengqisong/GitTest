package io.mqs.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.mqs.jcartadministrationback.po.Return;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnService {
    Page<Return> search(Integer pageNum);
}
