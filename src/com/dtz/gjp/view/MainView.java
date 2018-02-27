package com.dtz.gjp.view;
/*
 * 视图层
 * 用户看到和操作的界面
 * 数据传递给controller层实现
 * 成员位置，创建 controller对象
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
	 * 实现界面效果 接收用户输入
	 * 
	 */
	public void run() {
		// 创建Scanner类对象 反复键盘输入
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("-------------管家婆家庭记账软件-------------");
			System.out.println("1.添加账务 2.编辑账务 3.删除掌握  4.查询账务 5.退出系统");
			System.out.print("请输入功能序号：");
			// 接收菜单选择
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				// 添加账务 调用添加账务方法
				addZhangWu();
				break;
			case 2:
				// 编辑账务
				editZhangWu();
				break;
			case 3:
				// 删除账务
				deleteZhangWu();
				break;
			case 4:
				// 查询账务
				selectZhangWu();
				break;
			case 5:
				// 退出
				System.exit(0);
				break;
			}
		}
	}
	
	/*
	 * 删除
	 * 接收用户输入id编号  调用控制层删除方法 传递id参数
	 */
	public void deleteZhangWu() {
		selectAll();
		System.out.println("---------删除账务----------");
		System.out.println("输入要删除的账务ID：");
		Scanner sc = new Scanner(System.in);
		zwid = sc.nextInt();
		//调用方法 
		controller.deleteZhangWu(zwid);
	
	}	
	/*
	 * 编辑账务
	 * 接收用户输入信息 调用controller层方法 传递ZhangWu参数
	 */
	public void editZhangWu() {
		Scanner sc = new Scanner(System.in);
		selectAll();
		System.out.println("-------------编辑账务----------------");
		System.out.println("请输入账务ID:");
		zwid = sc.nextInt();
		messageScanner(sc);
		ZhangWu zw = new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
		//调用controller层editZhangWu方法 传参数
		controller.editZhangWu(zw);
		System.out.println("编辑成功！");
		
	}
	/*
	 * 添加账务方法
	 * 接收用户输入 调用controller层方法 传ZhangWu参数 
	 */
	public void addZhangWu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("------------添加加账务---------------");
		messageScanner(sc);
		//调用controller层方法传参数
		ZhangWu zw = new ZhangWu(0,flname,money,zhanghu,createtime,description);
		controller.addZhangWu(zw);
		System.out.println("添加成功！");
	}
	/*
	 * 接收用户信息输入方法
	 */
	private void messageScanner(Scanner sc) {
		System.out.println("请输入分类名称:");
		flname = sc.next();
		System.out.println("输入金额：");
		money = sc.nextDouble();
		System.out.println("输入账户：");
		zhanghu = sc.next();
		System.out.println("输入日期（格式：XXXX-XX-XX）：");
		createtime = sc.next();
		System.out.println("输入描述：");
		description = sc.next();
	}

	/*
	 * 显示查询方式 1.所有查询 2.条件查询 接收用户选择
	 */
	public void selectZhangWu() {
		System.out.println("-------------查询账务：选择查询方式----------");
		System.out.println("1.查询所有  2.条件查询");
		Scanner sc = new Scanner(System.in);
		int choose = sc.nextInt();
		switch (choose) {
		case 1:
			// 查询所有 调用方法
			selectAll();
			break;
		case 2:
			// 条件查询 调用方法
			select();
			break;
		}
	}


	/*
	 * 查询所有数据方法
	 */
	public void selectAll() {
		// 调用控制层中方法 查询所有账务数据
		List<ZhangWu> list = controller.selectAll();
		if (list.size() != 0)
			print(list);
		else
			System.out.println("查询结果没有数据！");
	}

	/*
	 * 条件查询方法 提供用户的输入日期区间 开始日期-结束日期 调用controller层方法 传递两个日期参数 获取到结果集 打印出来
	 */
	public void select() {
		System.out.println("-----------条件查询：日期格式：XXXX-XX-XX-----------");
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入开始日期：");
		String startDate = sc.nextLine();
		System.out.print("请输入结束日期：");
		String endDate = sc.nextLine();
		List<ZhangWu> list = controller.select(startDate, endDate);
		if (list.size() != 0)
			print(list);
		else
			System.out.println("查询结果没有数据！");
	}

	/*
	 * 打印方法
	 */
	private void print(List<ZhangWu> list) {
		System.out.println("ID\t类别\t账户\t金额\t时间\t\t说明");
		for (ZhangWu zw : list) {
			System.out.println(zw.getZwid() + "\t" + zw.getFlname() + "\t" + zw.getZhanghu() + "\t" + zw.getMoney()
					+ "\t" + zw.getCreatetime() + "\t" + zw.getDescription() + "\t");

		}
	}

}
