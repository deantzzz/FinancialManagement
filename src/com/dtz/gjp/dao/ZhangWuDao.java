package com.dtz.gjp.dao;
/*
 * ʵ�ֶ����ݱ�gjp_zhangwu ���ݵ���ɾ�Ĳ����
 * ��DBUtils��������ɣ� ���Ա����QueryRunner���� ָ������Դ
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
	 * �༭���� ��ҵ������ ����ZhangWu���� ����ZhangWu���� �޸����ݱ�
	 */
	public void editZhangWu(ZhangWu zw) {
		try {
			String sql = "UPDATE gjp_zhangwu set flname = ?,money=?,zhangHu=?,createtime=?,description=? WHERE zwid = ?";
			Object[] params = { zw.getFlname(), zw.getMoney(), zw.getZhanghu(), zw.getCreatetime(), zw.getDescription(),
					zw.getZwid() };

			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e + "�༭ʧ�� ��");
		}

	}

	/*
	 * ������� service����� ����ZhangWu���� ��ZhangWu�����е����� ��ӵ����ݱ�
	 */
	public void addZhangWu(ZhangWu zw) {
		try {
			String sql = "INSERT  INTO gjp_zhangwu(flname,money,zhangHu,createtime,description) VALUES (?,?,?,?,?);";
			Object[] params = { zw.getFlname(), zw.getMoney(), zw.getZhanghu(), zw.getCreatetime(),
					zw.getDescription() };
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e + "���ʧ�ܣ�");
		}
	}

	/*
	 * ������ѯ ��������ѯ���� ��service����� ���������ַ������ڲ��� �������ڲ�ѯ���ݿ� ���ؽ��������service��
	 */
	public List<ZhangWu> select(String startDate, String endDate) {
		try {
			String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
			Object[] params = { startDate, endDate };
			return qr.query(sql, new BeanListHandler<>(ZhangWu.class), params);
		} catch (SQLException e) {
			throw new RuntimeException(e + "��ѯʧ��");
		}
	}

	/*
	 * ��ѯ���ݿ� ��ȡ���е��������� �˷�����ҵ������ ���������ݴ洢��Bean������ �洢��������List
	 */
	public List<ZhangWu> selectAll() {
		try {
			String sql = "SELECT * FROM gjp_zhangwu";
			List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
			return list;
		} catch (SQLException ex) {
			throw new RuntimeException(ex + "��ѯʧ�ܣ�");
		}
	}

	public void deleteZhangWu(int zwid) {
		try {
			String sql = "DELETE  FROM gjp_zhangwu WHERE zwid = ?";
			qr.update(sql,zwid);
		} catch (SQLException e) {
			throw new RuntimeException(e+"ɾ��ʧ�ܣ�");
		}
	}
}
