public class Main {
    public static void main(String[] args) {
        ArvoreAVL arvoreBB = new ArvoreAVL();
        arvoreBB.inserir(41);
        arvoreBB.inserir(38);
        arvoreBB.inserir(31);
        arvoreBB.inserir(12);
        arvoreBB.inserir(19);
        arvoreBB.inserir(8);
        arvoreBB.inserir(50);
        arvoreBB.imprimirArvore();
        arvoreBB.removerNo(19);


//        arvoreBB.inserir(500);
//        arvoreBB.inserir(430);
//        arvoreBB.inserir(780);
//        arvoreBB.inserir(600);
//        arvoreBB.inserir(800);
//        arvoreBB.inserir(700);




        arvoreBB.preorder();
        arvoreBB.inorder();
        arvoreBB.postorder();
        arvoreBB.fatorBalanceamento();
        arvoreBB.imprimirArvore();

    }
}
