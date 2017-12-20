package cn.com.taiji.service;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.taiji.domain.Dept;
import cn.com.taiji.dto.DeptDto;
import cn.com.taiji.repository.DeptRepository;

/**
 * 类名称：DeptService   
 * 类描述：   
 * 创建人：seon   
 * 创建时间：2017年12月18日 上午11:13:35 
 * @version
 */
@Service
public class DeptService {

	@Autowired
	DeptRepository deptRepository;
	/**
	 * 
	 * @Description: 添加，修改Dept
	 * @throws
	 * @author seon
	 * @date 2017年12月18日
	 */
	public void updateDept(DeptDto deptDto) {
		Dept dept = new Dept();
		BeanUtils.copyProperties(deptDto, dept);
		deptRepository.findOne(dept.getId());
		
	}
	
	public void findMenu() {
		 deptRepository.findAll();
		 
	}
	
	
}
