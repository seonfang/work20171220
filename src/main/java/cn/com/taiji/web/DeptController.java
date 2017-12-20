package cn.com.taiji.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import cn.com.taiji.service.DeptService;

@Controller
public class DeptController {

	@Autowired
	DeptService ds;
	
	@GetMapping(value="depttree")
	public String toUserList() {
		return "DeptTree";
	}
	
}
