package cn.com.taiji.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cn.com.taiji.domain.Worker;

public class DeptDto  implements Serializable{

	/**
	 * Description:
	 * @author seon
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String creater;

	private Date createtime;

	private String name;

	private String status;


	private String parentId;


	private String updater;


	private Date updatetime;


	private List<Worker> workers;


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreater() {
		return this.creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getUpdater() {
		return this.updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	public Date getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public List<Worker> getWorkers() {
		return this.workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}
}
