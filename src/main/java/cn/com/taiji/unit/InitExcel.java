package cn.com.taiji.unit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.taiji.domain.Dept;
import cn.com.taiji.domain.Worker;
import cn.com.taiji.dto.DeptDto;
import cn.com.taiji.dto.WorkerDto;
import cn.com.taiji.repository.WorkerRepository;
import cn.com.taiji.service.WorkerService;

/**
 * 
 * 类名称：将Excel表格转为Map字符串 
 * 
 * 类描述： 
 * 
 * 创建人：seon 
 * 
 * 创建时间：2017年12月18日 下午3:42:29
 * 
 * @version
 */
@Component
public class InitExcel {
	@Autowired
	private WorkerService workerService;
	@Autowired
	WorkerRepository workerRepository;

	static ConverPinYin converPinYin = new ConverPinYin();


	public Map print(String path) throws IOException {
		File file = new File(path);
		XSSFWorkbook xssfWorkbook = null;
		try {
			xssfWorkbook = new XSSFWorkbook(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		// 选择要导的表
		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(5);

		int rowstart = xssfSheet.getFirstRowNum();
		int rowEnd = xssfSheet.getLastRowNum();
		Map deptWorkerMap = new HashMap();
		List depts = new ArrayList();
		Dept dept = new Dept();
		for (int i = rowstart + 1; i <= rowEnd; i++) {
			Worker worker = new Worker();
			XSSFRow row = xssfSheet.getRow(i);
			if (null == row)
				continue;
			int cellStart = row.getFirstCellNum();
			int cellEnd = row.getLastCellNum();
			String deptName = "";
			for (int k = cellStart; k <= cellEnd; k++) {
				XSSFCell cell = row.getCell(k);
				if (null == cell)
					continue;
				String str = "";

				switch (cell.getCellType()) {
				case HSSFCell.CELL_TYPE_NUMERIC: // 数字
					str = cell.getNumericCellValue() + "";
					// System.out.print(cell.getNumericCellValue() + " ");
					break;
				case HSSFCell.CELL_TYPE_STRING: // 字符串\
					str = cell.getStringCellValue() + "";
					// System.out.print(cell.getStringCellValue() + " ");
					break;
				case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
					str = cell.getBooleanCellValue() + "";
					System.out.println(cell.getBooleanCellValue() + "   ");
					break;
				case HSSFCell.CELL_TYPE_FORMULA: // 公式
					str = cell.getCellFormula() + "";
					// System.out.print(cell.getCellFormula() + " ");
					break;
				case HSSFCell.CELL_TYPE_BLANK: // 空值
					// System.out.println(" ");
					break;
				case HSSFCell.CELL_TYPE_ERROR: // 故障
					System.out.println(" ");
					break;
				default:
					// System.out.print("未知类型 ");
					break;
				}
				// System.out.println("Str :"+str);
				if (k == 1) {
					worker.setName(str);
					worker.setLoginName(converPinYin.toHanyuPinyin(str));
					// System.out.println("PinYin : "+converPinYin.toHanyuPinyin(str));
				} else if (k == 0) {
					worker.setId(str);
					// System.out.println("id ： "+str);
				} else if (k == 2) {
					worker.setSex(str);
					// System.out.println(worker.getSex());
				} else if (k == 3) {
					worker.setCategory(str);
				} else if (k == 4) {
					worker.setWorkCity(str);
				} else if (k == 7) {
					worker.setPostSequence(str);
					// System.out.println("7 ："+str);
				} else if (k == 8) {
					worker.setPostLevel(str);
					// System.out.println("8 ："+str);
				} else if (k == 9) {
					worker.setPostName(str);
					// System.out.println("name :"+worker.getPostName());
				} else if (k == 5) {// 部门中文描述
//					dept.setId(UUID.randomUUID().toString().replace("-", ""));
					deptName = str;
//					dept.setName(str);
//					depts.add(dept);
				} else if (k == 6) {// 二级部门中文描述
//					dept.setId(UUID.randomUUID().toString().replace("-", ""));
//					dept.setName(str);
//					depts.add(dept);
					
					String key = deptName + "_" + str;
					// key=str!=null?deptNamestr:deptName;
					List list = new ArrayList();
					// 判断
					if (deptWorkerMap.get(key) != null) {
						list = (List) deptWorkerMap.get(key);
					}
					// list.add(worker.getName());
					worker.setDepts(depts);
					list.add(worker);
					deptWorkerMap.put(key, list);

				}
			}
		}
		depts = removeDuplicate(depts);
		
		// System.out.print(dept.isEmpty());
		System.out.println("deptWorkerMap :" + deptWorkerMap);
		return deptWorkerMap;
	}

	/**
	 * 去掉重复
	 * 
	 * @param list
	 * @return
	 */

	public List<String> removeDuplicate(List<String> list) {
		HashSet<String> h = new HashSet<String>(list);
		list.clear();
		list.addAll(h);
		return list;
	}

	/**
	 * 将Map数据导入到数据库
	 * 
	 * @Description: 方法说明
	 * @param deptWorkerMap
	 *            void
	 * @throws @author
	 *             seon
	 * @date 2017年12月18日
	 */

	public void initDept(Map deptUserMap) {
		Set set = deptUserMap.entrySet();
		Set dset = deptUserMap.keySet();
		Iterator ditem = dset.iterator();
		
		
//		System.out.println("set :" + set);
		Iterator item = set.iterator();
		List<DeptDto> deptList = new ArrayList();
		// 初始化一级目录菜单
		Map parentDept = new HashMap();
		
		while (item.hasNext()) {

			Map.Entry<String, List> entry1 = (Map.Entry<String, List>) item.next();
			
//			System.out.println("Entry :" + entry1);
			 String deptName=entry1.getKey();
			//
			// DeptDto dto=new DeptDto();
			// dto.setName(entry1.getKey());
			// 获取到实体集合
			List list = entry1.getValue();
//			System.out.println("List: " + list);
			Iterator it1 = list.iterator();
			while (it1.hasNext()) {
				// System.out.println(it1);
				Worker w = (Worker) it1.next();
				// w.setId(UUID.randomUUID().toString().replace("-", ""));
				w.setStatus("1");
				Date time = Calendar.getInstance().getTime();
				w.setCreatetime(time);
				w.setUpdatetime(time);
//				System.out.println("W :" + w);
				

			}
		}
	}
}