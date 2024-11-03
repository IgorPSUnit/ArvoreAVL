public class ArvoreAVL {
    private No raiz = null;
    private int fatorBal;

    public ArvoreAVL() {
    }

    public void inserir(int valor) {
        this.raiz = this.inserirBRec(this.raiz, valor);
    }

    public No inserirBRec(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        } else {
            if (valor < raiz.getValor()) {
                raiz.setLeft(this.inserirBRec(raiz.getLeft(), valor));
            } else if (valor > raiz.getValor()) {
                raiz.setRight(this.inserirBRec(raiz.getRight(), valor));
            }
            fatorBalanceamento();
            if(raiz.getFb() == 0 || raiz.getFb() == 1 || raiz.getFb() == -1){
                System.out.println("No balançeado");
            }else{
                if(raiz.getFb() > 1){
                    System.out.println("No desbalançeado, Realizar rotação a direita " + "FB: " +raiz.getFb());
                    if(raiz.getLeft().getFb() > 0){
                        System.out.println("FB do no a esquerda: "+ raiz.getLeft().getFb());
                        No raizEsquerda = raiz.getLeft();
                        No raizDirRot = raizEsquerda.getRight();

                        raizEsquerda.setRight(raiz);
                        raiz.setRight(raizDirRot);
                        raiz = raizEsquerda;
                    }else{
                        System.out.println("Algo deu errado!");
                    }

                }else if (raiz.getFb() < -1){
                    System.out.println("No desbalançeado, Realizar rotação a esquerda " + "FB: " +raiz.getFb());
                    if(raiz.getRight().getFb() < 0){
                        System.out.println("FB do no a direita: "+ raiz.getRight().getFb());
                        No raizDireita = raiz.getRight();
                        No raizEsqRot = raizDireita.getLeft();

                        raizDireita.setLeft(raiz);
                        raiz.setRight(raizEsqRot);
                        raiz = raizDireita;
                    }else{
                        System.out.println("Algo deu errado!");
                    }
                }
            }

            return raiz;
        }
    }

    public void preorder() {
        this.preorderRec(this.raiz);
        System.out.println("Arvore preorder");
    }

    private void preorderRec(No raiz) {
        if (raiz != null) {
            System.out.print(raiz.getValor() + " ");
            this.preorderRec(raiz.getLeft());
            this.preorderRec(raiz.getRight());
        }

    }

    public void inorder() {
        this.inorderRec(this.raiz);
        System.out.println("Arvore inorder");
    }

    private void inorderRec(No raiz) {
        if (raiz != null) {
            this.inorderRec(raiz.getLeft());
            System.out.print(raiz.getValor() + " ");
            this.inorderRec(raiz.getRight());
        }

    }

    public void postorder() {
        this.postorderRec(this.raiz);
        System.out.println("Árvore postorder");
    }

    private void postorderRec(No raiz) {
        if (raiz != null) {
            this.postorderRec(raiz.getLeft());
            this.postorderRec(raiz.getRight());
            System.out.print(raiz.getValor() + " ");
        }

    }

    public boolean buscar(int valor) {
        if (this.buscarRec(this.raiz, valor)) {
            System.out.println("O valor " + valor + " está na arvore.");
            return true;
        } else {
            System.out.println("O valor " + valor + " não está na arvore.");
            return false;
        }
    }

    private boolean buscarRec(No raiz, int valor) {
        if (raiz == null) {
            return false;
        } else if (valor == raiz.getValor()) {
            return true;
        } else {
            return valor < raiz.getValor() ? this.buscarRec(raiz.getLeft(), valor) : this.buscarRec(raiz.getRight(), valor);
        }
    }

    private void removerNo(int valor) {
        this.raiz = this.removerRec(this.raiz, valor);
    }

    private No removerRec(No raiz, int valor) {
        if (raiz == null) {
            return null;
        } else {
            if (valor < raiz.getValor()) {
                raiz.setLeft(this.removerRec(raiz.getLeft(), valor));
            } else if (valor > raiz.getValor()) {
                raiz.setRight(this.removerRec(raiz.getRight(), valor));
            } else {
                if (raiz.getLeft() == null) {
                    return raiz.getRight();
                }

                if (raiz.getRight() == null) {
                    return raiz.getLeft();
                }

                if (raiz.getRight() != null && raiz.getLeft() != null && raiz.getLeft().getValor() < raiz.getRight().getValor()) {
                }
            }

            return raiz;
        }
    }

    public void fatorBalanceamento() {
        this.calculaFBRec(this.raiz);
    }

    private int calculaFBRec(No no) {
        if (no == null) {
            return 0;
        } else {
            int alturaEsquerda = this.calculaFBRec(no.getLeft());
            int alturaDireita = this.calculaFBRec(no.getRight());
            int fb = alturaEsquerda - alturaDireita;
            no.setFb(fb);
            return Math.max(alturaEsquerda, alturaDireita) +1;
        }
    }

    public void imprimirArvore() {
        this.imprimirArvoreRec(this.raiz, 0);
    }

    private void imprimirArvoreRec(No no, int nivel) {
        if (no != null) {
            for (int i = 0; i < nivel; i++) {
                System.out.print("   "); // Adiciona os espaços para formatar o nível
            }

            System.out.println(no.getValor() + " nivel: " + nivel + "FB: "+ no.getFb()); // Imprime o valor do nó e seu nível

            this.imprimirArvoreRec(no.getLeft(), nivel + 1);  // Recursão para a subárvore esquerda
            this.imprimirArvoreRec(no.getRight(), nivel + 1); // Recursão para a subárvore direita
        }
    }


}
