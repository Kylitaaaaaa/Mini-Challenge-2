package mc2;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui {
    private ArrayList<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
    private JFrame view1;
    private JTextField txtNewTask;
    private JButton btnAddTask;
    private JButton btnSetDate;
    
    
    private ArrayList <String> taskList = new ArrayList <String> ();
    
    public Gui(){
        txtNewTask = new JTextField();
        btnAddTask = new JButton("Add Task");
        btnSetDate = new JButton("Set Date");

        //x, y, width, height
        txtNewTask.setBounds(60, 50, 300, 40);
        btnSetDate.setBounds(370, 50, 150, 40);
        btnAddTask.setBounds(530, 50, 150, 40);
        
   
        btnAddTask.addActionListener(new btnAddTask_Action()); 
                
        view1 = new JFrame ("View 1");
        view1.setSize(750, 600);
	view1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        view1.setLayout(null);
        view1.add(btnAddTask);
        view1.add(btnSetDate);
        view1.add(txtNewTask); 
        
        view1.setVisible(true);
    }
    
  
    
    class btnAddTask_Action implements ActionListener
        {
		public void actionPerformed (ActionEvent e)
                {
                    JCheckBox checkbox = new JCheckBox(txtNewTask.getText());
                    checkboxes.add(checkbox);
                    txtNewTask.setText("");
                    displayCheckBox();
		}
	}
    
    public void displayCheckBox(){
        for (int i = 0; i < checkboxes.size(); i++) {
            JCheckBox jk = checkboxes.get(i);
            jk.setBounds(60, 100 + ((i+ 1)*20), 300, 40);
            view1.add(jk);
        }
    }
}