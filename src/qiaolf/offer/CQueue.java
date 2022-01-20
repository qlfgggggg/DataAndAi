package qiaolf.offer;

import java.util.Stack;

/**
 * @Description: TODO
 * Author:qiaolf
 * @Date:2021/8/17 10:18
 **/
public class CQueue {
    private Stack<Integer> push;
    private Stack<Integer> pop;
    public CQueue() {
        push = new Stack<>();
        pop = new Stack<>();
    }

    public void appendTail(int value) {
        while (!pop.isEmpty()){
            push.push(pop.pop());
        }
        push.push(value);
    }

    public int deleteHead() {
        while (!push.isEmpty()){
            pop.push(push.pop());
        }
        if (pop.isEmpty()){
            return -1;
        }
        return pop.pop();
    }
}
