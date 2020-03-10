package io.mqs.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.mqs.jcartadministrationback.dto.in.ReturnSearchInDTO;
import io.mqs.jcartadministrationback.po.Return;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnService {
    Page<Return> search(ReturnSearchInDTO returnSearchInDTO,Integer pageNum);

    Return getById(Integer returnId);

    void update(Return aReturn);
}
