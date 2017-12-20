package cn.com.taiji.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the worker database table.
 * 
 */
@Entity
@NamedQuery(name="Worker.findAll", query="SELECT w FROM Worker w")
public class Worker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String category;

	private String creater;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createtime;

	@Column(name="login_name")
	private String loginName;

	private String name;

	@Column(name="post_level")
	private String postLevel;

	@Column(name="post_name")
	private String postName;

	@Column(name="post_sequence")
	private String postSequence;

	private String sex;

	private String status;

	private String updater;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updatetime;

	@Column(name="work_city")
	private String workCity;

	//bi-directional many-to-many association to Dept
	@ManyToMany
	@JoinTable(
		name="worker_dept"
		, joinColumns={
			@JoinColumn(name="worker_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="dept_id")
			}
		)
	private List<Dept> depts;

	public Worker() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostLevel() {
		return this.postLevel;
	}

	public void setPostLevel(String postLevel) {
		this.postLevel = postLevel;
	}

	public String getPostName() {
		return this.postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostSequence() {
		return this.postSequence;
	}

	public void setPostSequence(String postSequence) {
		this.postSequence = postSequence;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getWorkCity() {
		return this.workCity;
	}

	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}

	public List<Dept> getDepts() {
		return this.depts;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}

	@Override
	public String toString() {
		return "Worker [id=" + id + ", category=" + category + ", creater=" + creater + ", createtime=" + createtime
				+ ", loginName=" + loginName + ", name=" + name + ", postLevel=" + postLevel + ", postName=" + postName
				+ ", postSequence=" + postSequence + ", sex=" + sex + ", status=" + status + ", updater=" + updater
				+ ", updatetime=" + updatetime + ", workCity=" + workCity + ", depts=" + depts + "] \n";
	}

}