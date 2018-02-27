package com.dtz.gjp.service;
/*
 * 业务层类
 * 接收上一层，控制层controller的数据
 * 经过计算传递给dao层 操作数据库
 * 调用dao层中的类，类成员位置 创建dao类对象
 */

import java.util.List;

import com.dtz.gjp.dao.ZhangWuDao;
import com.dtz.gjp.domain.ZhangWu;

public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();
	/*
	 * 编辑功能
	 * 被控制层调用 调用dao层 参数ZhangWu对象
	 */
	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu(zw);
	}
	/*
	 * 添加账务
	 * controller层传递过来的ZhangWu对象
	 * 调用dao层方法 传递ZhangWu对象
	 */
	public void addZhangWu(ZhangWu zw) {
		dao.addZhangWu(zw);
	}
	/*
	 * 条件查询方法
	 * 由controller层调用 传递两个字符串日期
	 * 调用dao层方法 传递两个字符串日期参数  获取结果集
	 * 结果返回给controller层
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		return dao.select(startDate, endDate);
	}
	/*
	 * 查询所有账务数据方法
	 * 由控制层调用，此方法调用dao层
	 * 返回存储Bean对象的list集合
	 */
	public List<ZhangWu> selectAll() {
		return dao.selectAll();
	}
	public void deleteZhangWu(int zwid) {
		dao.deleteZhangWu(zwid);
	}
			
}
