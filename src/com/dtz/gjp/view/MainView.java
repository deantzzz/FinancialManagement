package com.dtz.gjp.view;
/*
 * ��ͼ��
 * �û������Ͳ����Ľ���
 * ���ݴ��ݸ�controller��ʵ��
 * ��Աλ�ã����� controller����
 */

import java.util.List;
import java.util.Scanner;

import com.dtz.gjp.controller.ZhangWuController;
import com.dtz.gjp.domain.ZhangWu;

public class MainView {
	private ZhangWuController controller = new ZhangWuController();
	private int zwid;
	private String flname;
	private double money;
	private String zhanghu;
	private String createtime;
	private String description;

	/*
	 * ʵ�ֽ���Ч�� �����û�����
	 * 
	 */
	public void run() {
		// ����Scanner����� ������������
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("-------------�ܼ��ż�ͥ�������-------------");
			System.out.println("1.������� 2.�༭���� 3.ɾ������  4.��ѯ���� 5.�˳�ϵͳ");
			System.out.print("�����빦����ţ�");
			// ���ղ˵�ѡ��
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				// ������� ����������񷽷�
				addZhangWu();
				break;
			case 2:
				// �༭����
				editZhangWu();
				break;
			case 3:
				// ɾ������
				deleteZhangWu();
				break;
			case 4:
				// ��ѯ����
				selectZhangWu();
				break;
			case 5:
				// �˳�
				System.exit(0);
				break;
			}
		}
	}
	
	/*
	 * ɾ��
	 * �����û�����id���  ���ÿ��Ʋ�ɾ������ ����id����
	 */
	public void deleteZhangWu() {
		selectAll();
		System.out.println("---------ɾ������----------");
		System.out.println("����Ҫɾ��������ID��");
		Scanner sc = new Scanner(System.in);
		zwid = sc.nextInt();
		//���÷��� 
		controller.deleteZhangWu(zwid);
	
	}	
	/*
	 * �༭����
	 * �����û�������Ϣ ����controller�㷽�� ����ZhangWu����
	 */
	public void editZhangWu() {
		Scanner sc = new Scanner(System.in);
		selectAll();
		System.out.println("-------------�༭����----------------");
		System.out.println("����������ID:");
		zwid = sc.nextInt();
		messageScanner(sc);
		ZhangWu zw = new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
		//����controller��editZhangWu���� ������
		controller.editZhangWu(zw);
		System.out.println("�༭�ɹ���");
		
	}
	/*
	 * ������񷽷�
	 * �����û����� ����controller�㷽�� ��ZhangWu���� 
	 */
	public void addZhangWu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("------------��Ӽ�����---------------");
		messageScanner(sc);
		//����controller�㷽��������
		ZhangWu zw = new ZhangWu(0,flname,money,zhanghu,createtime,description);
		controller.addZhangWu(zw);
		System.out.println("��ӳɹ���");
	}
	/*
	 * �����û���Ϣ���뷽��
	 */
	private void messageScanner(Scanner sc) {
		System.out.println("�������������:");
		flname = sc.next();
		System.out.println("�����");
		money = sc.nextDouble();
		System.out.println("�����˻���");
		zhanghu = sc.next();
		System.out.println("�������ڣ���ʽ��XXXX-XX-XX����");
		createtime = sc.next();
		System.out.println("����������");
		description = sc.next();
	}

	/*
	 * ��ʾ��ѯ��ʽ 1.���в�ѯ 2.������ѯ �����û�ѡ��
	 */
	public void selectZhangWu() {
		System.out.println("-------------��ѯ����ѡ���ѯ��ʽ----------");
		System.out.println("1.��ѯ����  2.������ѯ");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// ��ѯ���� ���÷���
			selectAll();
			break;
		case 2:
			// ������ѯ ���÷���
			select();
			break;
		}
	}


	/*
	 * ��ѯ�������ݷ���
	 */
	public void selectAll() {
		// ���ÿ��Ʋ��з��� ��ѯ������������
		List<ZhangWu> list = controller.selectAll();
		if (list.size() != 0)
			print(list);
		else
			System.out.println("��ѯ���û�����ݣ�");
	}

	/*
	 * ������ѯ���� �ṩ�û��������������� ��ʼ����-�������� ����controller�㷽�� �����������ڲ��� ��ȡ������� ��ӡ����
	 */
	public void select() {
		System.out.println("-----------������ѯ�����ڸ�ʽ��XXXX-XX-XX-----------");
		Scanner sc = new Scanner(System.in);
		System.out.print("�����뿪ʼ���ڣ�");
		String startDate = sc.nextLine();
		System.out.print("������������ڣ�");
		String endDate = sc.nextLine();
		List<ZhangWu> list = controller.select(startDate, endDate);
		if (list.size() != 0)
			print(list);
		else
			System.out.println("��ѯ���û�����ݣ�");
	}

	/*
	 * ��ӡ����
	 */
	private void print(List<ZhangWu> list) {
		System.out.println("ID\t���\t�˻�\t���\tʱ��\t\t˵��");
		for (ZhangWu zw : list) {
			System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t" + zw.getZhanghu() + "\t" + zw.getMoney()
					+ "\t" + zw.getCreatetime() + "\t" + zw.getDescription() + "\t");

		}
	}

}
