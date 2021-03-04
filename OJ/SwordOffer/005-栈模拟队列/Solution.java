
/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
 * Date: 2021/3/4
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /*
     * 1.队列先入先出，栈先入后出 2.stack1存压入的值，出队列时，方向和栈相反，所以需要弹出到stack2中，若stack2不为空，则stack2就是
     * 正确的顺序，往stack2.pop() 3. 压入还是往 stack1压入，pop时不断补齐stack2的内容
     */
    public void add(int node) {
        stack1.push(node);
    }

    public int poll() {
        if (stack2.size() <= 0) {
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

class MyStack {
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();

    public void push(int val) {
        
    }

    public void pop() {

    }

}

public class Solution {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.add(2);
        queue.add(3);
        queue.add(4);
        // 2->3->4
        System.out.println("<<" + queue.poll()); // ==2
        queue.add(5);
        // 3->4->5
        System.out.println("<<" + queue.poll()); // 3

        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("<<" + stack.pop()); // 3
        stack.push(4);
        System.out.println("<<" + stack.pop()); // 4
    }
}
