package com.elevateIntership.day6;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Todo_App extends JFrame
{
	private DefaultListModel<String> taskListModel;
	
	private JList<String> taskList;
	
	private JTextField taskField;
	
	private JButton addButton , deleteButton;
	
	public Todo_App() {
		
		setTitle("TO-DO List");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout());
		
		taskField = new JTextField(15);
		addButton = new JButton("Add Task");
		deleteButton = new JButton("Delete Task");
		
		inputPanel.add(taskField);
		inputPanel.add(addButton);
		inputPanel.add(deleteButton);
		
		taskListModel= new DefaultListModel<>();
		taskList= new JList<>(taskListModel);
		JScrollPane scrollPane = new JScrollPane(taskList);
		
		add(inputPanel,BorderLayout.NORTH);
		add(scrollPane,BorderLayout.CENTER);
		
		
		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				String task =taskField.getText().trim();
				
			if(!task.isEmpty()) {
				taskListModel.addElement(task);
				taskField.setText("");
				
			}else {
				JOptionPane.showMessageDialog(null,"selete a task to delete!");
			}
		}
		});
		setVisible(true);
	}
	
	 public static void main(String []args) {
		 
		 SwingUtilities.invokeLater(Todo_App::new);
	 }


}
