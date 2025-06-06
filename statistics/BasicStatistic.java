package hus.oop.statistics;

import java.math.BigInteger;
import java.util.Arrays;

public class BasicStatistic implements Statistic {
    private DataSet dataSet;

    /**
     * Hàm dựng khởi tạo tập dữ liệu.
     */
    public BasicStatistic() {
        /* TODO */
        this.dataSet = null;
    }

    public void setDataSet(DataSet dataSet) {
        /* TODO */
        this.dataSet = dataSet;
    }

    @Override
    public int size() {
        /* TODO */
        return dataSet.size();
    }

    @Override
    public double max() {
        /* TODO */
        double max = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < dataSet.size(); i++) {
            if (dataSet.elementAt(i) > max) {
                max = dataSet.elementAt(i);
            }
        }
        return max;
    }

    @Override
    public double min() {
        /* TODO */
        double min  = Double.POSITIVE_INFINITY;
        for (int i = 0; i < dataSet.size(); i++) {
            if (dataSet.elementAt(i) < min) {
                min = dataSet.elementAt(i);
            }
        }
        return min;
    }

    @Override
    public double mean() {
        /* TODO */
        int count = dataSet.size();
        double sum = 0.0;
        for (int i = 0; i < dataSet.size(); i++) {
            sum += dataSet.elementAt(i);
        }
        return (double) sum / count;
    }

    @Override
    public double variance() {
        /* TODO */
        double mean = mean();
        int count = dataSet.size();
        double sqDiff = 0;
        for (int i = 0; i < dataSet.size(); i++) {
            sqDiff += (dataSet.elementAt(i) - mean) *
                    (dataSet.elementAt(i) - mean);
        }
        return (double) sqDiff / count;
    }

    @Override
    public double[] rank() {
        /* TODO */
        int n = dataSet.size();
        double[] R = new double[n];
        return R;
    }

    @Override
    public double median() {
        /* TODO */
        int n = dataSet.size();
        double[] copy = new  double[n];
        for (int i = 0; i < n; i++) {
            copy[i] = dataSet.elementAt(i);
        }
        Arrays.sort(copy);
        if (n % 2 == 1) {
            return copy[n / 2];
        } else {
            return (copy[n / 2 - 1] + copy[n / 2]) / 2.0;
        }
    }

    public double norm() {
        double sum = 0.0;
        for (int i = 0; i < dataSet.size(); i++) {
            sum += Math.pow(dataSet.elementAt(i), 2);
        }
        return Math.sqrt(sum);
    }
}
