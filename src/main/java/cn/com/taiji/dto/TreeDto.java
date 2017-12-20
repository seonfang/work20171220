package cn.com.taiji.dto;

import java.util.List;
import java.util.Map;

import cn.com.taiji.domain.Dept;

/**
 * 
 * 类名称：TreeDto 
 * 类描述： 树形结构 Dto
 * 创建人：seon 
 * 创建时间：2017年12月19日 上午9:34:24
 * 
 * @version
 */
public class TreeDto {

	private String text;
	private String icon;
	private String selectedIcon;
	private String color;
	private String backColor;
	private String href;
	private String selectable;
	private Map state;
	private String tags;
	private List<TreeDto> nodes;

	public TreeDto(Dept d) {
		// TODO Auto-generated constructor stub
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getSelectedIcon() {
		return selectedIcon;
	}

	public void setSelectedIcon(String selectedIcon) {
		this.selectedIcon = selectedIcon;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBackColor() {
		return backColor;
	}

	public void setBackColor(String backColor) {
		this.backColor = backColor;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getSelectable() {
		return selectable;
	}

	public void setSelectable(String selectable) {
		this.selectable = selectable;
	}

	public Map getState() {
		return state;
	}

	public void setState(Map state) {
		this.state = state;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public List<TreeDto> getNodes() {
		return nodes;
	}

	public void setNodes(List<TreeDto> nodes) {
		this.nodes = nodes;
	}

}
