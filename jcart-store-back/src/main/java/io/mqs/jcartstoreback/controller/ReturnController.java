package io.mqs.jcartstoreback.controller;

import io.mqs.jcartstoreback.dto.in.ReturnApplyInDTO;
import io.mqs.jcartstoreback.dto.out.PageOutDTO;
import io.mqs.jcartstoreback.dto.out.ReturnListOutDTO;
import io.mqs.jcartstoreback.dto.out.ReturnShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
public class ReturnController {

    @PostMapping("/apply")
    public Integer apply(@RequestBody ReturnApplyInDTO returnApplyInDTO,
                         @RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getList")
    public PageOutDTO<ReturnListOutDTO> getList(@RequestAttribute Integer customerId,
                                                @RequestParam Integer pageNum){
        return null;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        return null;
    }

    @PostMapping("/cancel")
    public void cancel(@RequestBody Integer returnId){

    }

}
