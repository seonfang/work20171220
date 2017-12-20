package cn.com.taiji.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the dept database table.
 * 
 */
@Entity
@NamedQuery(name="Dept.findAll", query="SELECT d FROM Dept d")
public class Dept implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String creater;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	private String name;

	private String status;

	@Column(name="parent_id")
	private String parentId;

	
	private String updater;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatetime;

	//bi-directional many-to-many association to Worker
	@ManyToMany(mappedBy="depts")
	private List<Worker> workers;

	public Dept() {
	}

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
		return this.parentId;
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

	@Override
	public String toString() {
		return "Dept [id=" + id + ", creater=" + creater + ", createtime=" + createtime + ", name=" + name + ", status="
				+ status + ", parentId=" + parentId + ", updater=" + updater + ", updatetime="
				+ updatetime  + "]";
	}

	
}