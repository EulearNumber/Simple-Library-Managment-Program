public class Library {
    Books[] L1books = null;
    Books[] L2books = null;

    public void assignL1size(int size)
    {
        this.L1books = new Books[size];
    }
    public void assignL2size(int size)
    {
        this.L2books = new Books[size];
    }
}