package cn.com.taiji.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.com.taiji.domain.Dept;
/**
 * 
 * 类名称：WorkerDto   
 * 类描述：   
 * 创建人：seon   
 * 创建时间：2017年12月18日 上午11:15:25 
 * @version
 */
public class WorkerDto  implements Serializable {
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

	private Date updatetime;

	private String workCity;

	private List<Dept> depts;


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

}
