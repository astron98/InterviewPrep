#include<iostream>
#include<string>
using namespace std;

struct BST {
	 int data;
	 BST* left;
	 BST* right;
};

BST* create_node(int data) {
	 BST* root = new BST();
	 root->data = data;
	 (*root).left = root->right = NULL;
	 return root;
}

BST* insert(BST* root, int data) {
	 if (!root) {
	  root = create_node(data);
	 }
	 else if ((root->data) < data) {
	  root->right = insert(root->right, data);
	 }
	 else {
	  root->left = insert(root->left, data);
	 }
	 return root;
}

int search(BST* root, int data) {
	 if (root == NULL) {
	  return 0;
	 }
	 else if ((root->data) == data) {
	  return 1;
	 }
	 else if (data < root->data) {
	  return search(root->left, data);
	 }
	 else {
	  return search(root->right, data);
	 }
}

int main() {
	 BST* root = new BST();
	 root = insert(root, 10);
	 root = insert(root, 20);
	 root = insert(root, 50);
	 root = insert(root, 40);
	 root = insert(root, 15);
	 cout << search(root, 5);
	 return 1;
}
