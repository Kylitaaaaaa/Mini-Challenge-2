package mc2;

import javax.swing.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calendarGUI {
    private JFrame calendar = new JFrame("Calendar");
    private JComboBox cmbDay;
    private JComboBox cmbMonth;
    private JComboBox cmbYear;
    private int intCmbDay;
    private int intCmbMonth;
    private int intCmbYear;
    private JLabel lblCal;
    private GregorianCalendar calNow = new GregorianCalendar();
    
    public calendarGUI(){
        cmbDay = new JComboBox();
        cmbMonth = new JComboBox();
        cmbYear = new JComboBox();
        
        lblCal = new JLabel("Enter Date");
        
        intCmbDay = calNow.get(GregorianCalendar.DAY_OF_MONTH);
        intCmbMonth = calNow.get(GregorianCalendar.MONTH);
        intCmbYear = calNow.get(GregorianCalendar.YEAR);
        populateDate();
                
        calendar.setSize(670, 180);
        calendar.setLayout(null);
        calendar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calendar.setVisible(true);

        cmbYear.setBounds(50, 70, 160, 40);
        cmbMonth.setBounds(250, 70, 160, 40);
        cmbDay.setBounds(450, 70, 160, 40);
        lblCal.setBounds(300, 20, 160, 40);
        
        cmbDay.addActionListener(new cmbDay_Action());
        cmbMonth.addActionListener(new cmbMonth_Action());

        calendar.add(cmbYear);
        calendar.add(cmbMonth);
        calendar.add(cmbDay);
        calendar.add(lblCal);
    }
    
    class cmbDay_Action implements ActionListener{
	public void actionPerformed (ActionEvent e){
            if (cmbYear.getSelectedItem() != null){
                if(cmbDay.getSelectedItem() != null){
                    String b = cmbDay.getSelectedItem().toString();
                    intCmbDay = Integer.parseInt(b);
                }		
            }
        }
    }
    
    class cmbMonth_Action implements ActionListener{
	public void actionPerformed (ActionEvent e){
            if (cmbMonth.getSelectedItem() != null){
		String b = cmbMonth.getSelectedItem().toString();
		intCmbMonth = Integer.parseInt(b)-1;
                         			
		GregorianCalendar cal = new GregorianCalendar(intCmbYear, intCmbMonth, 1);
                int lastDate = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
              
                cmbDay.removeAllItems();
                 
                for(int i=1; i<=lastDate; i++)
                    cmbDay.addItem(String.valueOf(i));
            }
        }
    }
    
    public void populateDate(){
        GregorianCalendar cal = new GregorianCalendar(intCmbYear, intCmbMonth, 1);
        int lastDate = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        for(int i=1; i<=lastDate; i++)
            cmbDay.addItem(String.valueOf(i));
        
        for(int i=1; i<=12; i++)
            cmbMonth.addItem(String.valueOf(i));
        
        for(int i=intCmbYear - 10; i<=intCmbYear + 10; i++)
            cmbYear.addItem(String.valueOf(i));
        
        cmbDay.setSelectedItem(intCmbDay);
        cmbMonth.setSelectedItem(intCmbMonth);
        cmbYear.setSelectedItem(intCmbYear);
    }
    
}
