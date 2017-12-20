package cn.com.taiji.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.taiji.dto.WorkerDto;

@Controller
public class WorkerController {

	
	@GetMapping("/workerlist")
	public String workerList() {
		return "workerList";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public  String doLogin() {
		return "login";
	}
	@GetMapping("/servicelist")
	public String serviceList() {
		return "serviceList";
	}
	
	@GetMapping("/toaddworker")
	public String toAddWorker(Model model) {
		WorkerDto workerDto = new WorkerDto();
		model.addAttribute("u", workerDto);
		return "serviceEdit";
	}
	
}