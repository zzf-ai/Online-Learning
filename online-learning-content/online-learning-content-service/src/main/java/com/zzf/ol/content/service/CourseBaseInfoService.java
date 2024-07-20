package com.zzf.ol.content.service;

import com.zzf.ol.base.model.PageParams;
import com.zzf.ol.base.model.PageResult;
import com.zzf.ol.content.model.dto.QueryCourseParamsDto;
import com.zzf.ol.content.model.po.CourseBase;

public interface CourseBaseInfoService {

    public PageResult<CourseBase> queryCourseBaseInfoList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto);
}
