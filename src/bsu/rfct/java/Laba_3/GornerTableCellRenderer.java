package bsu.rfct.java.Laba_3;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class GornerTableCellRenderer implements TableCellRenderer {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();

    private String needle = null;
    private DecimalFormat formatter =
            (DecimalFormat)NumberFormat.getInstance();
    public GornerTableCellRenderer() {

        formatter.setMaximumFractionDigits(5);

        formatter.setGroupingUsed(false);

        DecimalFormatSymbols dottedDouble =
                formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);

        panel.add(label);

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int col){

        String formattedDouble = formatter.format(value);

        int index = formattedDouble.indexOf('.');
        String str1="1";
        String str3="3";
        String str5="5";
        int index1=formattedDouble.indexOf('1',index);
        int index3=formattedDouble.indexOf('3',index);
        int index5=formattedDouble.indexOf('5',index);

        label.setText(formattedDouble);
        if (col==1 && needle!=null && needle.equals(formattedDouble)) {

            panel.setBackground(Color.RED);
        } else {

            panel.setBackground(Color.WHITE);
        }

        if(index1!=-1 || index3!=-1 || index5!=-1 ) {
            if(str1.indexOf('1',index)==-1 && str3.indexOf('3',index)==-1 && str5.indexOf('5',index)==-1) panel.setBackground(Color.ORANGE);}

        //if(sub.contains("1")||sub.contains("3")||sub.contains("5")){
        //   if(sub!="1" && sub!="3" && sub!="5") panel.setBackground(Color.ORANGE);}
        return panel;
    }
    public void setNeedle(String needle) {
        this.needle = needle;
    }
}

