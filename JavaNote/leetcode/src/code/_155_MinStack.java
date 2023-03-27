package code;

import java.util.Stack;

/**
 * @author 刘佳俊
 *
 * 最小栈:
 *      设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *
 * 思路:
 *     1. 题目表示我们要通过现有的栈数据结构 来创建一个类 这个类需要 实现栈的功能 并且在栈的功能基础上添加一个获取当前栈内最小值的功能(常数时间内)
 *
 *     2. 我们需要准备两个栈 stackData , statckMin
 *          stackData : 这个栈用于所有元素的push ,pop top 等操作 和原有的栈的功能相同
 *          stackMin : 这个栈用于保存 每次存入和删除数据时 最小值的变化
 *
 *     3. 当我们添加数据 val 的时候 stackData正常添加数据 但是 是否需要加入到 stackMin 我们需要 将 val 与 stackMin 的栈顶元素进行比较
 *          stackMin 为空栈 直接将 val 入 stackMin 栈
 *          val <= stackMin栈顶元素时 证明此时我们 stackData栈内的最小值发生了变化 所以我们要记录这个val值到stackMin中
 *              当我们获取stackData栈中最小值时 获取的是 stackMin 栈的栈顶元素
 *          val > stackMin 栈顶元素 证明最小值没有发生变化 不用记录
 *
 *     4. 当我们删除元素时  因为我们知道 stackMin的栈顶元素保存的就是stackData栈中的最小元素
 *          所以我们只需要判断 stackData 删除的元素 与 stackMin的栈顶元素是否相等 如果相等 那就证明 stackData 删除了此时的最小值
 *          最小值被删除 所以我们需要弹出 stackMin栈顶元素  用于 显示较上次的 最小值
 *
 */
public class _155_MinStack {

    Stack<Integer> stackData = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();



    public void push(int val) {
        stackData.push(val);
        if (stackMin.isEmpty()) {
            stackMin.push(val);
        } else {
            Integer peek = stackMin.peek();
            if(peek>=val){
                stackMin.push(val);
            }
        }
    }

    public void pop() {
        Integer pop = stackData.pop();
        if(pop.equals(stackMin.peek())){
            stackMin.pop();
        }
    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */