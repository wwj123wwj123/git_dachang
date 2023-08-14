package com.dachuang.entity.admin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class DataStatusDTO {
    /**
     * 数据状态
     */
    private Integer status;
    /**
     * 数据id
     */
    private Long id;
}
