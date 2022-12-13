
        protected Node(Integer val, Node dir, Node esq) {
            this.val = val;
            this.dir = dir;
            this.esq = esq;
        }

        public void setVal(Integer val) {
            this.val = val;
        }

        public Node setDir(Node dir) {
            this.dir = dir;
            return this.dir;
        }

        public Node setEsq(Node esq) {
            this.esq = esq;
            return this.esq;
        }

        public Node getDir() {
            return dir;
        }

        public Node getEsq() {
            return esq;
        }

        public Integer getVal() {
            return val;
        }
    }

    public Arvore() {
        this.head = null;
    }

    public Arvore(Node head) {
        this.head = head;
    }

    public Node busca(Integer valor) {
        return this.buscaRecursiva(valor, this.head);
    }

    public Node buscaRecursiva(Integer valor, Node curr) {
        if (curr != null && valor == curr.val)
            return curr;
        if (curr != null && curr.esq != null && valor <= curr.esq.val)
            return this.buscaRecursiva(valor, curr.esq);
        if (curr != null && curr.dir != null && valor <= curr.dir.val)
            return this.buscaRecursiva(valor, curr.dir);

        return null;
    }

    public Node insere(Integer valor) {
        Node res = this.busca(valor);
        if (res != null)
            return res;
        return insereRecursivo(valor, this.head);
    }

    public Node insereRecursivo(Integer valor, Node curr) {
        if(this.head == null){
            Node h = new Node(valor);
            this.head = h;
            return this.head;
        }
        if (curr == null)
            return new Node(valor);
        if (curr.val >= valor) {
            return curr.setEsq(this.insereRecursivo(valor, curr.esq));
        } else {
            return curr.setDir(this.insereRecursivo(valor, curr.dir));
        }
    }

}
