public class No {
    private int valor;
    private No left;
    private No right;
    private int fb;

    public No(int valor) {
        this.valor = valor;
        this.left = null;
        this.fb = this.fb;
        this.right = null;
    }

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public No getLeft() {
        return this.left;
    }

    public void setLeft(No left) {
        this.left = left;
    }

    public No getRight() {
        return this.right;
    }

    public void setRight(No right) {
        this.right = right;
    }

    public String toString() {
        int valor = this.valor;
        return "No valor=" + valor + ", left=" + String.valueOf(this.left) + ", right=" + String.valueOf(this.right) + ", fb=" + this.fb + "}";
    }

    public int getFb() {
        return this.fb;
    }

    public void setFb(int fb) {
        this.fb = fb;
    }
}
