import { BinaryTree } from "../01.binary_tree/binaryTree.mjs"

class BinarySearchTree {
    constructor(rootNode = null){
        this.root = rootNode;
    }

    insert(data){
        // 루트가 비었을 때
        if(this.root == null) {
            this.root = new BinaryTree(data);
            return;
        }

        let currentNode = this.root;
        let parentNode = null;

        while (currentNode != null) {
            parentNode = currentNode;
                
            // data와 현재 노드비교
            if(data > currentNode.getData()) {
                currentNode = currentNode.getRightSubTree();
            }else if(data < currentNode.getData()) {
                currentNode = currentNode.getLeftSubTree();
            } else {
                return;
            }

        }

        let newNode = new BinaryTree(data);
        // 부모와 비교
        if(data > parentNode.getData()) {
            parentNode.setRightSubTree(newNode);
        } else {
            parentNode.setLeftSubTree(newNode);
        }
    }


    search(targetData){
        let currentNode = this.root;

        while(currentNode != null) {
            // data와 현재 노드비교
            if(targetData == currentNode.getData()) {
                return currentNode;
            }else if(targetData < currentNode.getData()) {
                currentNode = currentNode.getLeftSubTree();
            } else {
                currentNode = currentNode.getRightSubTree();
            }
        }

    }

    remove(targetData){
        let fakeParentRootNode = new BinaryTree(0);
        let parentNode = fakeParentRootNode;
        let currentNode = this.root;
        let deletingNode = null;

        fakeParentRootNode.setRightSubTree(this.root);

        while(currentNode != null && currentNode.getData() != targetData) {
            parentNode = currentNode;

            if(targetData < currentNode.getData()) {
                currentNode = currentNode.getLeftSubTree();
            } else {
                currentNode = currentNode.getRightSubTree();
            }
        }

        if(currentNode == null){
            return;
        }

        deletingNode = currentNode;

        if(deletingNode.getLeftSubTree() == null
            && deletingNode.getRightSubTree() == null){
            
            if(deletingNode == parentNode.getLeftSubTree()) {
                parentNode.removeLeftSubTree()
            } else {
                parentNode.removeRightSubTree();
            }

        } else if (deletingNode.getLeftSubTree() == null
            || deletingNode.getRightSubTree() == null) {
            
            let deletingNodeChild;

            if(deletingNode.getLeftSubTree() != null) {
                deletingNodeChild = deletingNode.getLeftSubTree();
            } else {
                deletingNodeChild = deletingNode.getRightSubTree();
            }

            if(deletingNode == parentNode.getLeftSubTree()) {
                parentNode.setLeftSubTree(deletingNodeChild);
            } else {
                parentNode.setRightSubTree(deletingNodeChild);
            }
        } else {
            let replacingNode = deletingNode.getLeftSubTree();
            let replacingNodeParent = deletingNode;

            while(replacingNode.getRightSubTree() != null){
                replacingNodeParent = replacingNode;
                replacingNode = replacingNode.getRightSubTree();
            }

            let deletingNodeData = deletingNode.getData();
            deletingNode.setData(replacingNode.getData());

            if(replacingNodeParent.getLeftSubTree() == replacingNode){
                replacingNodeParent.setLeftSubTree(replacingNode.getLeftSubTree());

            }else{
                replacingNodeParent.setRightSubTree(replacingNode.getLeftSubTree());
            }

            deletingNode = replacingNode;
            deletingNode.setData(deletingNodeData);
        }

        if(fakeParentRootNode.getRightSubTree() != this.root){
            this.root = fakeParentRootNode.getRightSubTree();
        }

        return deletingNode;
    }
}


let binarySearchTree = new BinarySearchTree();
binarySearchTree.insert(18);
binarySearchTree.insert(15);
binarySearchTree.insert(10);
binarySearchTree.insert(6);
binarySearchTree.insert(3);
binarySearchTree.insert(8);
binarySearchTree.insert(12);
binarySearchTree.insert(11);
binarySearchTree.insert(31);
binarySearchTree.insert(27);
binarySearchTree.insert(24);
binarySearchTree.insert(20);
binarySearchTree.insert(33);
binarySearchTree.insert(35);
binarySearchTree.insert(37);
binarySearchTree.root.inOrderTraversal(binarySearchTree.root);

console.log("========== Search 6 ==========");
console.log(binarySearchTree.search(6));


console.log("========== Search 1 ==========");
console.log(binarySearchTree.search(1));

binarySearchTree.remove(10);
binarySearchTree.root.inOrderTraversal(binarySearchTree.root);