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
        }
            fatorBalanceamento();
            return ajustarBalanceamento(raiz);
        }

    private No ajustarBalanceamento(No noAtual) {
        if (noAtual.getFb() > 1) {
            if (noAtual.getLeft().getFb() >= 0) {
                return rotacionarDireita(noAtual);
            } else {
                return rotacaoDulpaDireita(noAtual);
            }
        }

        if (noAtual.getFb() < -1) {
            if (noAtual.getRight().getFb() <= 0) {
                return rotacionarEsquerda(noAtual);
            } else {
                return rotacaoDulpaEsquerda(noAtual);
            }
        }

        return noAtual;
    }

    private No rotacionarDireita(No no) {
        No novoRaiz = no.getLeft();
        No subArvoreDireita = novoRaiz.getRight();
        no.setLeft(subArvoreDireita);
        novoRaiz.setRight(no);
        no.setFb(calcularFatorBalanceamento(no));
        novoRaiz.setFb(calcularFatorBalanceamento(novoRaiz));

        return novoRaiz;
    }

    private No rotacionarEsquerda(No no) {
        No novoRaiz = no.getRight();
        No subArvoreEsquerda = novoRaiz.getLeft();
        novoRaiz.setLeft(no);
        no.setRight(subArvoreEsquerda);
        no.setFb(calcularFatorBalanceamento(no));
        novoRaiz.setFb(calcularFatorBalanceamento(novoRaiz));
        return novoRaiz;
    }

    private No rotacaoDulpaDireita(No no){
        no.setLeft(rotacionarEsquerda(no.getLeft()));
        return rotacionarDireita(no);
    }

    private No rotacaoDulpaEsquerda(No no){
        no.setRight(rotacionarDireita(no.getRight()));
        return rotacionarEsquerda(no);
    }

    private int calcularFatorBalanceamento(No no) {
        if (no == null) {
            return 0;
        }
        return calculaAltura(no.getLeft()) - calculaAltura(no.getRight());
    }

    private int calculaAltura(No no) {
        if (no == null) {
            return 0;
        }
        return Math.max(calculaAltura(no.getLeft()), calculaAltura(no.getRight())) + 1;
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

    public void removerNo(int valor) {
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

                No menorDireita = encontrarMin(raiz.getRight());
                raiz.setValor(menorDireita.getValor());
                raiz.setRight(removerRec(raiz.getRight(), menorDireita.getValor()));
            }
            fatorBalanceamento();

            return ajustarBalanceamento(raiz);
        }
    }
    private No encontrarMin(No no) {
        while (no.getLeft() != null) {
            no = no.getLeft();
        }
        return no;
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
            return Math.max(alturaEsquerda, alturaDireita) + 1;
        }
    }

    public void imprimirArvore() {
        this.imprimirArvoreRec(this.raiz, 0);
    }

    private void imprimirArvoreRec(No no, int nivel) {
        if (no != null) {
            for (int i = 0; i < nivel; i++) {
                System.out.print("   ");
            }
            System.out.println(no.getValor() + " nivel: " + nivel + " FB: "+ no.getFb());
            this.imprimirArvoreRec(no.getLeft(), nivel + 1);
            this.imprimirArvoreRec(no.getRight(), nivel + 1);
        }
    }


}
