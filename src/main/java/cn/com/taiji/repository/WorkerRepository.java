package cn.com.taiji.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import cn.com.taiji.domain.Worker;
/**
 * 
 * 类名称：WorkerRepository   
 * 类描述：   
 * 创建人：seon   
 * 创建时间：2017年12月18日 上午11:12:23 
 * @version
 */
@Repository
public interface WorkerRepository extends JpaRepository<Worker,String>,JpaSpecificationExecutor<Worker>,PagingAndSortingRepository<Worker, String>{
	
	/**
	 * 
	 * @Description: 对员工Worker进行逻辑删除
	 * 即将status的值改为 0
	 * @param id void  
	 * @throws
	 * @author seon
	 * @date 2017年12月20日
	 */
	@Transactional 
	@Modifying
	@Query("UPDATE Worker w SET w.status = 0 WHERE u.id=?1")
	void deleteWorkerById(String id);
	/**
	 * 
	 * @Description: 根据登录名进行查询Worker 信息 进行登录验证
	 * @param loginName
	 * @return Worker  
	 * @throws
	 * @author seon
	 * @date 2017年12月20日
	 */
	@Query("SELECT w FROM Worker w  WHERE login_name = ?1")
	Worker findByLoginName(String loginName);
	
	
	
}
