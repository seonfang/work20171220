package cn.com.taiji.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import cn.com.taiji.domain.Dept;

/**
 * 
 * 类名称：DeptRepository   
 * 类描述：   
 * 创建人：seon   
 * 创建时间：2017年12月18日 上午11:12:29 
 * @version
 */
@Repository
public interface DeptRepository extends JpaRepository<Dept,String>,JpaSpecificationExecutor<Dept>,PagingAndSortingRepository<Dept, String>{
	
}