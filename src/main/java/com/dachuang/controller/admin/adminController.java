package com.dachuang.controller.admin;
import com.dachuang.entity.admin.DataStatusDTO;
import com.dachuang.service.admin.AdminService;
import com.dachuang.util.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@Slf4j
public class adminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("/change")
    public HttpResult statusChange(@RequestBody DataStatusDTO dataStatusDTO){
        return adminService.statusChange(dataStatusDTO)>0? HttpResult.success("更新成功！"):HttpResult.error();

    }
}
