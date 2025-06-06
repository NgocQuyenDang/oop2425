package hus.oop.mylist;

public abstract class MyAbstractList implements MyList {
    /**
     * Mô tả dữ liệu của list.
     * @return mô tả list theo định dạng [a1] [a2] [a3] ... [an]
     */
    @Override
    public String toString() {
        /* TODO */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            sb.append("[ ").append(this.get(i)).append(" ]");
        }
        return sb.toString();
    }
}
