package com.zzf.ol.content;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzf.ol.base.model.PageParams;
import com.zzf.ol.base.model.PageResult;
import com.zzf.ol.content.mapper.CourseBaseMapper;
import com.zzf.ol.content.model.dto.QueryCourseParamsDto;
import com.zzf.ol.content.model.po.CourseBase;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseBaseInfoServiceTests {

    @Autowired
    CourseBaseMapper courseBaseMapper;

    @Test
    public void testCourseBaseInfoMapper() {
        CourseBase courseBase = courseBaseMapper.selectById(18);
        Assertions.assertNotNull(courseBase);

        QueryCourseParamsDto courseParamsDto = new QueryCourseParamsDto();
        courseParamsDto.setCourseName("java");
        // 拼装查询条件
        LambdaQueryWrapper<CourseBase>  queryWrapper =new LambdaQueryWrapper<>();
        // 根据名称模糊查询
        queryWrapper.like(StringUtils.isNotEmpty(courseParamsDto.getCourseName()), CourseBase::getName, courseParamsDto.getCourseName());
        // 根据课程审核状态查询
        queryWrapper.eq((StringUtils.isNotEmpty(courseParamsDto.getAuditStatus())), CourseBase::getAuditStatus, courseParamsDto.getAuditStatus());
        // 分页参数
        PageParams pageParams = new PageParams();
        pageParams.setPageNo(1L);
        pageParams.setPageSize(2L);

        // 分页参数对象
        Page<CourseBase> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());

        // 分页查询
        Page<CourseBase> pageResult = courseBaseMapper.selectPage(page, queryWrapper);
        // 数据列表
        List<CourseBase> items = pageResult.getRecords();
        // 总记录数
        long total = pageResult.getTotal();

        PageResult<CourseBase> courseBasePageResult = new PageResult<>(items, total, pageParams.getPageNo(), pageParams.getPageSize());
        System.out.println(courseBasePageResult);
    }
}
