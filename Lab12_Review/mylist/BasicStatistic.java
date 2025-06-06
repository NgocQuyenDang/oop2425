package hus.oop.mylist;

public class BasicStatistic {
    private MyList data;

    /**
     * Khởi tạo dữ liệu cho BasicStatistic.
     */
    public BasicStatistic(MyList data) {
        /* TODO */
        this.data = data;
    }

    /**
     * Lấy giá trị lớn nhất trong list.
     * @return giá trị lớn nhất.
     */
    public double max() {
        /* TODO */
        MyIterator iterator = data.iterator();
        double max = (double) iterator.next();
        while (iterator.hasNext()) {
            double element = (double) iterator.next();
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    /**
     * Lấy giá trị nhỏ nhất trong list.
     * @return giá trị nhỏ nhất.
     */
    public double min() {
        /* TODO */
        MyIterator iterator = data.iterator();
        double min = (double) iterator.next();

        while (iterator.hasNext()) {
            double element = (double) iterator.next();

            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    /**
     * Tính kỳ vọng của mẫu lưu trong list.
     * @return kỳ vọng.
     */
    public double mean() {
        /* TODO */
        MyIterator iterator = data.iterator();

        double sum = 0.0;
        int count = 0;
        while (iterator.hasNext()) {
            sum += (double) iterator.next();
            count++;
        }
        double mean = sum / count;
        return mean;
    }

    /**
     * Tính phương sai của mẫu lưu trong list.
     * @return phương sai.
     */
    public double variance() {
        /* TODO */
        double mean = mean();

        MyIterator iterator = data.iterator();
        double sum = 0.0;
        int count = 0;

        while (iterator.hasNext()) {
            double element = (double)  iterator.next();
            sum += Math.pow(element - mean, 2);
            count++;
        }
        double variance = sum / count;
        return variance;
    }
}
