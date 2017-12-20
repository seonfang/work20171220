package cn.com.taiji.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.taiji.domain.Dept;
import cn.com.taiji.dto.TreeDto;
import cn.com.taiji.repository.DeptRepository;
import cn.com.taiji.service.DeptService;

@Controller
public class DeptController {

	@Autowired
	DeptService ds;
	
	

	@Autowired
	DeptRepository dr;
	@GetMapping(value="depttree")
	public String toUserList() {
		return "DeptTree";
	}
	@RequestMapping(value="/showtree",method=RequestMethod.POST)
	@ResponseBody
	public List<TreeDto> showTree(String data) {
		List<TreeDto> tds = new ArrayList<TreeDto>();
		System.out.println("true");
		Dept d = dr.findDepartmentById("1");
		if(null!=d) {
			
		TreeDto td = new TreeDto(d);
		System.out.println(td);
		tds.add(td);
		return tds;
		}
		return null;
	}
}
