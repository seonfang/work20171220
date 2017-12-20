package cn.com.taiji.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.taiji.repository.WorkerRepository;

/**
 * 
 * 类名称：WorkerService   
 * 类描述：   
 * 创建人：seon   
 * 创建时间：2017年12月18日 上午11:14:14 
 * @version
 */
@Service
public class WorkerService {

	@Autowired
	WorkerRepository workerRepository;
	private void test() {
//		workerRepository.save();

	}
	
}
