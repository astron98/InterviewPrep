// { Driver Code Starts
#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include<bits/stdc++.h>

using namespace std;
/* Linked list Node */
struct Node {
    int data;
    struct Node* next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

struct Node* addTwoLists(struct Node* first, struct Node* second);

void push(struct Node** head_ref, int new_data) {
    struct Node* new_Node = new Node(new_data);
    new_Node->next = (*head_ref);
    (*head_ref) = new_Node;
}
void printList(struct Node* Node) {
    while (Node != NULL) {
        printf("%d ", Node->data);
        Node = Node->next;
    }
    printf("\n");
}
void freeList(struct Node* Node) {
    struct Node* temp;
    while (Node != NULL) {
        temp = Node;
        Node = Node->next;
        free(temp);
    }
}
int main(void) {
    int t, n, m, i, x;
    cin >> t;
    while (t--) {
        struct Node* res = NULL;
        struct Node* first = NULL;
        struct Node* second = NULL;
        cin >> n;
        for (i = 0; i < n; i++) {
            cin >> x;
            push(&first, x);
        }
        cin >> m;
        for (i = 0; i < m; i++) {
            cin >> x;
            push(&second, x);
        }
        res = addTwoLists(first, second);
        printList(res);
        if (first) freeList(first);
        if (second) freeList(second);
    }
    return 0;
}
// } Driver Code Ends

/*
struct Node {
    int data;
    struct Node* next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};
*/


// write a function returns the resultant linked list
Node* addTwoLists(Node* first, Node* second) {
    // Code here
    Node *h1 = first,*h2=second;
    string p1="",p2="";
    while(h1!=NULL)
    {
        p1+=to_string(h1->data);
        h1=h1->next;
    }
    
    while(h2!=NULL)
    {
        p2+=to_string(h2->data);
        h2=h2->next;
    }

    
    //reverse(str.begin(), str.end());
    reverse(p1.begin(),p1.end());
    reverse(p2.begin(),p2.end());
    
    int res = stoi(p1) + stoi(p2);
    cout<<"result: " <<res<<"\n";
    string str = to_string(res);
    cout<<"string-result: "<<str<<"\n";
    Node *result=NULL,*head=NULL;
    for(int i=str.length()-1;i>=0;i--)
    {
        cout<<"reached1........"<<"\n";
        int x = int(str[i]) - 48;
        Node* curr=new Node(x);
        if(result==NULL)
        {
            result = curr;
            head = result;
        }
        else
        {
            result->next = curr;
            result=result->next;
        }
        delete curr;
    }
    cout<<"reached2........"<<"\n";
    
    return head;
}
