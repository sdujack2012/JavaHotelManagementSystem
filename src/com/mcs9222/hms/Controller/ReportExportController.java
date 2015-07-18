/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcs9222.hms.Controller;

import java.io.File;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kj847
 */
public class ReportExportController extends Controller {
        JTable reportTable;
        JLabel reportSummary;
        public ReportExportController(JTable reportTable,JLabel reportSummary){
            this.reportTable =reportTable ;
            this.reportSummary=reportSummary;
        }
        public void saveFile(){
            JFileChooser jf = new JFileChooser();
            int value = jf.showSaveDialog(null);
            if(value==JFileChooser.APPROVE_OPTION){
                File file = jf.getSelectedFile();
                try{
                    PrintWriter pw = new PrintWriter(file);
                    pw.println(reportSummary.getText());
                    DefaultTableModel tableModel=(DefaultTableModel)reportTable.getModel();
                    for(int i=0;i<tableModel.getColumnCount();i++){
                        pw.print(tableModel.getColumnName(i)+" ");
                    }
                    pw.println();
                    for(int j=0;j<tableModel.getRowCount();j++){
                        for(int i=0;i<tableModel.getColumnCount();i++){
                            pw.print(tableModel.getValueAt(j,i)+" ");
                        }
                        pw.println();
                    }  
                    pw.flush();;
                    pw.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
                
              
            }
            
        }
        public void saveFile(String filename){
            
                File file = new File(filename);
                try{
                    PrintWriter pw = new PrintWriter(file);
                    pw.println(reportSummary.getText());
                    DefaultTableModel tableModel=(DefaultTableModel)reportTable.getModel();
                    for(int i=0;i<tableModel.getColumnCount();i++){
                        pw.print(tableModel.getColumnName(i)+" ");
                    }
                    pw.println();
                    for(int j=0;j<tableModel.getRowCount();j++){
                        for(int i=0;i<tableModel.getColumnCount();i++){
                            pw.print(tableModel.getValueAt(j,i)+" ");
                        }
                        pw.println();
                    }  
                    pw.flush();;
                    pw.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
                
              
           
            
        }
}
