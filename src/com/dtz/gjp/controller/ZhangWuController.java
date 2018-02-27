package com.dtz.gjp.controller;
/*
 * ��������
 * ������ͼ������ݣ����ݴ��ݸ�service��
 * ��Աλ�� ������service����
 */

import java.util.List;

import com.dtz.gjp.domain.ZhangWu;
import com.dtz.gjp.service.ZhangWuService;

public class ZhangWuController {
	private ZhangWuService service = new ZhangWuService();
	/*
	 * �༭���� 
	 * ����ͼ����ã�����ZhangWu����
	 * ����ҵ��� ������ZhangWu����
	 */
	public void editZhangWu(ZhangWu zw) {
		service.editZhangWu(zw);
	}
	/*
	 * ��ӹ���
	 * ����ͼ����� ������һ��ZhangWu����
	 * ����service�㷽�� ����ZhangWu���� ����ֵ��Ӻ�Ľ��������ӳɹ����� ��int��
	 */
	public void addZhangWu(ZhangWu zw) {
		service.addZhangWu(zw);
	}

	/*
	 * ������ѯ���� ����ͼ����ã��������������ַ��� ����service�㷽�� �������������ַ��� ��ȡ����� ��������ظ���ͼ
	 */
	public List<ZhangWu> select(String startDate, String endDate) {
		return service.select(startDate, endDate);
	}

	/*
	 * ���Ʋ㷽�� �� ʵ�ֲ�ѯ������������ ��������ͼ����ã���������service��
	 */
	public List<ZhangWu> selectAll() {
		return service.selectAll();
	}
	public void deleteZhangWu(int zwid) {
		service.deleteZhangWu(zwid);
	}

}
