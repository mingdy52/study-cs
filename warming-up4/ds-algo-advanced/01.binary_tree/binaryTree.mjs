class BinaryTree {
    constructor(data, leftTree = null, rightTree = null) {
        this.data = data;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    getData() {
        return this.data;
    }

    setData(data) {
        this.data = data;
    }

    getLeftSubTree() {
        return this.leftTree;
    }

    getRightSubTree() {
        return this.rightTree
    }

    setLeftSubTree(tree) {
        this.leftTree = tree;
    }

    setRightSubTree(tree) {
        this.rightTree = tree;
    }

    preOrderTraversal(tree) {
        // 루트 - 2 - 3

        if(tree == null) return;

        console.log(tree.data);
        this.preOrderTraversal(tree.getLeftSubTree());
        this.preOrderTraversal(tree.getRightSubTree());

    }

    inOrderTraversal(tree) {
        // 2 - 루트 - 3
        if(tree == null) return;

        this.inOrderTraversal(tree.getLeftSubTree());
        console.log(tree.data);
        this.inOrderTraversal(tree.getRightSubTree());

    }

    postOrderTraversal(tree) {
        // 2 - 3 - 루트 

        if(tree == null) return;

        this.postOrderTraversal(tree.getLeftSubTree());
        this.postOrderTraversal(tree.getRightSubTree());
        console.log(tree.data);
    }
}

export { BinaryTree }