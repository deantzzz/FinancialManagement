package com.dtz.gjp.controller;
/*
 * 控制器层
 * 接收视图层的数据，数据传递给service层
 * 成员位置 ，创建service对象
 */

import java.util.List;

import com.dtz.gjp.domain.ZhangWu;
import com.dtz.gjp.service.ZhangWuService;

public class ZhangWuController {
	private ZhangWuService service = new ZhangWuService();
	/*
	 * 编辑功能 
	 * 被视图层调用，传递ZhangWu参数
	 * 调用业务层 ，传递ZhangWu参数
	 */
	public void editZhangWu(ZhangWu zw) {
		service.editZhangWu(zw);
	}
	/*
	 * 添加功能
	 * 由视图层调用 参数是一个ZhangWu对象
	 * 调用service层方法 传递ZhangWu对象 返回值添加后的结果集（添加成功行数 ，int）
	 */
	public void addZhangWu(ZhangWu zw) {
		service.addZhangWu(zw);
	}

	/*
	 * 条件查询账务 由视图层调用，传递两个日期字符串 调用service层方法 传递两个日期字符串 获取结果集 结果集返回给视图
	 */
	public List<ZhangWu> select(String startDate, String endDate) {
		return service.select(startDate, endDate);
	}

	/*
	 * 控制层方法 ， 实现查询所有账务数据 方法由视图层调用，方法调用service层
	 */
	public List<ZhangWu> selectAll() {
		return service.selectAll();
	}
	public void deleteZhangWu(int zwid) {
		service.deleteZhangWu(zwid);
	}

}
