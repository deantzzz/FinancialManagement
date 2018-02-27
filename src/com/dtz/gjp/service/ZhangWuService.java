package com.dtz.gjp.service;
/*
 * ҵ�����
 * ������һ�㣬���Ʋ�controller������
 * �������㴫�ݸ�dao�� �������ݿ�
 * ����dao���е��࣬���Աλ�� ����dao�����
 */

import java.util.List;

import com.dtz.gjp.dao.ZhangWuDao;
import com.dtz.gjp.domain.ZhangWu;

public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();
	/*
	 * �༭����
	 * �����Ʋ���� ����dao�� ����ZhangWu����
	 */
	public void editZhangWu(ZhangWu zw) {
		dao.editZhangWu(zw);
	}
	/*
	 * �������
	 * controller�㴫�ݹ�����ZhangWu����
	 * ����dao�㷽�� ����ZhangWu����
	 */
	public void addZhangWu(ZhangWu zw) {
		dao.addZhangWu(zw);
	}
	/*
	 * ������ѯ����
	 * ��controller����� ���������ַ�������
	 * ����dao�㷽�� ���������ַ������ڲ���  ��ȡ�����
	 * ������ظ�controller��
	 */
	public List<ZhangWu> select(String startDate,String endDate){
		return dao.select(startDate, endDate);
	}
	/*
	 * ��ѯ�����������ݷ���
	 * �ɿ��Ʋ���ã��˷�������dao��
	 * ���ش洢Bean�����list����
	 */
	public List<ZhangWu> selectAll() {
		return dao.selectAll();
	}
	public void deleteZhangWu(int zwid) {
		dao.deleteZhangWu(zwid);
	}
			
}
