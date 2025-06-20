package hus.oop.midterm.students;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1] [a2] [a3] ... [an]
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < this.size(); i++) {
            sb.append(this.get(i));
            if (i != size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
}
