/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kj847
 */
public class ReportSelectController extends Controller{
        JList reportTypesList;
        JTable reportTable;
        JLabel reportSummary;
        DefaultTableModel[] tableModels;
        public ReportSelectController(JTable reportTable, JList reportTypesLis,JLabel reportSummary){
           this.reportTable = reportTable;
           this.reportTypesList = reportTypesLis;
           this.reportSummary=reportSummary;
           this.tableModels = new DefaultTableModel[5];
           String[][] ColumnNames={{"Arrival Time","Customer Name","Room Number"},{"Checkin Time","Customer Name","Room Number"},{"Checkout Time","Customer Name","Room Number"},{"Order Number","Date","Price"},{"Booking time","Customer Name","Room Number"}};
           for(int i=0;i<5;i++){
                tableModels[i] = new DefaultTableModel();
                tableModels[i].setColumnIdentifiers(ColumnNames[i]);
           }
        }
        public void doChangeType(){
            String reportType=(String)reportTypesList.getSelectedValue();
            if(reportType.equals("Expected Arrivals")){
                 reportTable.setModel(tableModels[0]);
            }
            else if(reportType=="Checkin Report"){
                 reportTable.setModel(tableModels[1]);
            }
            else if(reportType=="Checkout Report"){
                 reportTable.setModel(tableModels[2]);
            }
            else if(reportType=="Revenue Summary"){
                reportTable.setModel(tableModels[3]);
            }
            else if(reportType=="Booking Activity"){
                reportTable.setModel(tableModels[4]);
            }
        }
}
