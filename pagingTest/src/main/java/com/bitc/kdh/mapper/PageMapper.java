package com.bitc.kdh.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.kdh.dto.EmployeesDto;
import com.github.pagehelper.Page;

@Mapper
public interface PageMapper {

	Page<EmployeesDto> selectEmpList() throws Exception;

}
