package com.zzf.ol.content.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class QueryCourseParamsDto {

    //审核状态
    private String auditStatus;
    //课程名称
    private String courseName;
    //发布状态
    private String publishStatus;

}
