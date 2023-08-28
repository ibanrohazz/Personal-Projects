#include <queue>
using namespace std;

class MyStack {
public:

    queue< int > queue;

    MyStack() {
        
    }
    
    void push( int x ) {
        int s = queue.size();
        queue.push( x );
        for( int i=0; i<s; i++ ) {
            queue.push( queue.front() );
            queue.pop();
        }
    }
    
    int pop() {
        if( !queue.empty() ) {
            int x = queue.front();
            queue.pop();
            return x;
        }
        return -1;
    }
    
    int top() {
         if( !queue.empty() ) {
            int x = queue.front();
            return x;
        }
        return -1;
    }
    
    bool empty() {
        if( queue.empty() ) {
            return true;
        }
        else{
            return false;
        }
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */