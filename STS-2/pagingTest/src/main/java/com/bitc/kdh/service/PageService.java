package com.bitc.kdh.service;

import com.bitc.kdh.dto.EmployeesDto;
import com.github.pagehelper.Page;

public interface PageService {

	Page<EmployeesDto> selectEmpList(int pageNum) throws Exception;

}
