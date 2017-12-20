package cn.com.taiji;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.taiji.repository.DeptRepository;
import cn.com.taiji.repository.WorkerRepository;
import cn.com.taiji.unit.InitExcel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeeklyApplicationTests {

	@Autowired
	WorkerRepository wr;
	@Autowired
	DeptRepository dr;
	@Autowired
	InitExcel ie;
	@Test
	public void contextLoads() {
		String path = "D:\\WeChatFiles\\WeChat Files\\shandonghkf\\Files\\通讯录.xlsx";
		try {
			ie.initDept(ie.print(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(dr.findAll());
	}

}
