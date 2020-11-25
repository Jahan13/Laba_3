package bsu.rfct.java.Laba_3;

import javax.swing.table.AbstractTableModel;
import java.math.BigInteger;

@SuppressWarnings("serial")

public class GornerTableModel extends AbstractTableModel {
    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step,
                            Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }
    public Double getTo() {
        return to;
    }
    public Double getStep() {
        return step;
    }
    public int getColumnCount() {

        return 3;
    }
    public int getRowCount() {

        return new Double(Math.ceil((to-from)/step)).intValue()+1;
    }

    public Object getValueAt(int row, int col) {

        double x = from + step * row;
        if (col == 0) {
            return x;
        } else {
        }
        if (col == 1) {
            Double result = 0.0;
            for (int i = 0; i < coefficients.length; i++) {
                result = result * x + coefficients[i];
            }
            return result;
        } else {
            double result1 = 0;
            for (int i = 0; i < coefficients.length; i++) {
                result1 = result1 * x + coefficients[i];
            }
            Integer integer = (int) result1;
            BigInteger bigInteger = BigInteger.valueOf(integer);
            Boolean probablePrime = bigInteger.isProbablePrime((int) Math.log(integer));
            return (probablePrime);
        }
    }

    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Значение X";
            case 1:
                return "Значение многочлена";
            default:
                return "значение простое";
        }
    }
    public Class<?> getColumnClass(int col) {
        if(col==0)return Double.class;
        if(col==1)return Double.class;
        else return Boolean.class;
    }
}