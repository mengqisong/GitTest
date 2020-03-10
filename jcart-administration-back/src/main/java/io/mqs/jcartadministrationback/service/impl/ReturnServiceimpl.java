package io.mqs.jcartadministrationback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.mqs.jcartadministrationback.dao.ReturnMapper;
import io.mqs.jcartadministrationback.dto.in.ReturnSearchInDTO;
import io.mqs.jcartadministrationback.po.Return;
import io.mqs.jcartadministrationback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReturnServiceimpl implements ReturnService {
    @Autowired
    ReturnMapper returnMapper;

    @Override
    public Page<Return> search(ReturnSearchInDTO returnSearchInDTO,Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        return returnMapper.search(
                returnSearchInDTO.getReturnId(),
                returnSearchInDTO.getOrderId(),
                returnSearchInDTO.getStartTimestamp() == null ? null : new Date(returnSearchInDTO.getStartTimestamp()),
                returnSearchInDTO.getEndTimestamp() == null ? null : new Date(returnSearchInDTO.getEndTimestamp()),
                returnSearchInDTO.getStatus(),
                returnSearchInDTO.getProductCode(),
                returnSearchInDTO.getCustomerName(),
                returnSearchInDTO.getProductName());
    }

    @Override
    public Return getById(Integer returnId) {
        return returnMapper.selectByPrimaryKey(returnId);
    }

    @Override
    public void update(Return aReturn) {
        returnMapper.updateByPrimaryKeySelective(aReturn);
    }
}
