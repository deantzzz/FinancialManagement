package com.dtz.gjp.dao;
/*
 * 实现对数据表gjp_zhangwu 数据的增删改查操作
 * 用DBUtils工具类完成， 类成员创建QueryRunner对象 指定数据源
 */

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dtz.gjp.domain.ZhangWu;
import com.dtz.gjp.tools.JDBCUtils;

public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

	/*
	 * 编辑功能 被业务层调用 参数ZhangWu对象 接收ZhangWu对象 修改数据表
	 */
	public void editZhangWu(ZhangWu zw) {
		try {
			String sql = "UPDATE gjp_zhangwu set flname = ?,money=?,zhangHu=?,createtime=?,description=? WHERE zwid = ?";
			Object[] params = { zw.getFlname(), zw.getMoney(), zw.getZhanghu(), zw.getCreatetime(), zw.getDescription(),
					zw.getZwid() };

			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e + "编辑失败 ！");
		}

	}

	/*
	 * 添加账务 service层调用 传递ZhangWu对象 将ZhangWu对象中的数据 添加到数据表
	 */
	public void addZhangWu(ZhangWu zw) {
		try {
			String sql = "INSERT  INTO gjp_zhangwu(flname,money,zhangHu,createtime,description) VALUES (?,?,?,?,?);";
			Object[] params = { zw.getFlname(), zw.getMoney(), zw.getZhanghu(), zw.getCreatetime(),
					zw.getDescription() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e + "添加失败！");
		}
	}

	/*
	 * 条件查询 按条件查询数据 由service层调用 传递两个字符串日期参数 根据日期查询数据库 返回结果集返回service层
	 */
	public List<ZhangWu> select(String startDate, String endDate) {
		try {
			String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
			Object[] params = { startDate, endDate };
			return qr.query(sql, new BeanListHandler<>(ZhangWu.class), params);
		} catch (SQLException e) {
			throw new RuntimeException(e + "查询失败");
		}
	}

	/*
	 * 查询数据库 获取所有的账务数据 此方法由业务层调用 将所有数据存储到Bean对象中 存储到集合中List
	 */
	public List<ZhangWu> selectAll() {
		try {
			String sql = "SELECT * FROM gjp_zhangwu";
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
			return list;
		} catch (SQLException ex) {
			throw new RuntimeException(ex + "查询失败！");
		}
	}

	public void deleteZhangWu(int zwid) {
		try {
			String sql = "DELETE  FROM gjp_zhangwu WHERE zwid = ?";
			qr.update(sql,zwid);
		} catch (SQLException e) {
			throw new RuntimeException(e+"删除失败！");
		}
	}
}
