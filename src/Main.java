public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvoreBB = new ArvoreAVL();
//        arvoreBB.inserir(12);
//        arvoreBB.inserir(4);
//        arvoreBB.inserir(15);
//        arvoreBB.inserir(3);
//        arvoreBB.inserir(9);
//        arvoreBB.inserir(14);
//        arvoreBB.inserir(18);
//        arvoreBB.inserir(8);
//        arvoreBB.inserir(10);
//        arvoreBB.inserir(16);
//        arvoreBB.inserir(20);
//        arvoreBB.inserir(6);
//        arvoreBB.inserir(17);
//        arvoreBB.inserir(5);
//        arvoreBB.inserir(7);

        arvoreBB.inserir(500);
        arvoreBB.inserir(430);
        arvoreBB.inserir(780);
        arvoreBB.inserir(600);
        arvoreBB.inserir(800);
        arvoreBB.inserir(700);




        arvoreBB.preorder();
        arvoreBB.inorder();
        arvoreBB.postorder();
        arvoreBB.fatorBalanceamento();
        arvoreBB.imprimirArvore();

    }
}
