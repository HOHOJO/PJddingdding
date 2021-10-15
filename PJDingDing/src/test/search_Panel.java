package test;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
// 조회용 패널

class search_Panel extends JPanel {
	JFrame mainframe;
	private Connection connection;
	private DBM queries;
	JScrollPane graphScroll;

	public search_Panel(JFrame mainframe, CardLayout cLayout, Connection conn, DBM queries) {
		
		this.mainframe= mainframe; 
		this.connection = conn;
		this.queries = queries;
		
		JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		
		JButton btnBack = new JButton("뒤로가기");
		btnBack.addActionListener(e -> cLayout.first(mainframe.getContentPane()));
		
		setLayout(new BorderLayout());
		//////////////////////////////////////////
		// NORTH: menu 메뉴바 테스트 샘플
		Menu menu = new Menu();
		menu.addMenu("User");
		menu.getMenu().setMnemonic(KeyEvent.VK_1);
		menu.addMenuItem("나가기", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("강의실", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("도서실", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("식당", KeyEvent.VK_E, new UserPanelListener());
		menu.addMenuItem("조회", KeyEvent.VK_E, new UserPanelListener());
		menu.finishAddItem();
		add(menu, BorderLayout.NORTH);
		
		buttonPanel.add(btnBack);
		southPanel.add(buttonPanel);
		
		add(menu, BorderLayout.NORTH);
		add(southPanel, BorderLayout.SOUTH);
	}
	
	private class UserPanelListener implements ActionListener { //버튼 리스너
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
