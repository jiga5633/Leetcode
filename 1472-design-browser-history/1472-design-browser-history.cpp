class Node{
public:
    string url;
    Node* prev;
    Node* next;

    Node(string url){
        this->url = url;
        prev = NULL;
        next = NULL;
    }
};

class BrowserHistory {
private:
    Node *root;
public:
    BrowserHistory(string homepage) {
        root = new Node(homepage);
    }
    
    void visit(string url) {
        Node* node = new Node(url);
        root->next = node;
        node->prev = root;
        root = root->next;
    }
    
    string back(int steps) {
        for(int i = 0; i<steps && root->prev != NULL; i++){
            root = root->prev;
        }
        return root->url;
    }
    
    string forward(int steps) {
        for(int i = 0; i<steps && root->next != NULL; i++){
            root = root->next;
        }
        return root->url;
    }
};
/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory* obj = new BrowserHistory(homepage);
 * obj->visit(url);
 * string param_2 = obj->back(steps);
 * string param_3 = obj->forward(steps);
 */