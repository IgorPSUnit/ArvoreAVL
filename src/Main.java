public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvoreBB = new ArvoreAVL();

        arvoreBB.inserir(50);

        arvoreBB.inserir(40);

        arvoreBB.inserir(20);

        arvoreBB.inserir(45);

        arvoreBB.inserir(55);

        arvoreBB.preorder();
        arvoreBB.inorder();
        arvoreBB.postorder();
        arvoreBB.fatorBalanceamento();
        arvoreBB.imprimirArvore();

        arvoreBB.inserir(25);
        arvoreBB.inserir(29);
        arvoreBB.inserir(65);
        arvoreBB.inserir(68);

        arvoreBB.imprimirArvore();

    }
}
