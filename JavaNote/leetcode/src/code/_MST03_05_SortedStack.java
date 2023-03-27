package code;

import java.util.Stack;

/**
 * @author 刘佳俊
 *
 *
 * 栈排序
 *      栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 *      该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 *
 *  思路:
 *      1. 通过申请一个额外的栈空间来帮助排序 所以有两个栈 一个数据栈 dataStack 一个用于辅助排序栈 helpStack
 *
 *      2. 对于一个栈排序来说 它除了 push 操作 其他的操起与 栈操作并无太大的不同
 *      3. 当我们添加元素的时候 按照题意 需要分成 步  (当前元素 value 栈顶元素 top)
 *          1). 当 value <= top 时 直接入栈
 *          2). 当 value > top 时 先将dataStack栈中的 top 弹出 并添加到 helpStack 栈中 并检查下一个 top 直到 value <= top
 *                  再将 value 入dataStack 之后再将 helpStack 栈中的数据依次弹出并压入到dataStack中
 *
 *     ============================================================================================
 *     优化:
 *          上述步骤中我们可以看出 在加入元素时 当helpStack不为空时 我们需要在每次添加 完数据之后 还要将helpStack栈中数据重新加入到dataStack中
 *          这样效率低下
 *
 *          我们可以在添加数据之后 不直接将helpStack栈中的数据加入到dataStack中 而是在下一次添加数据的时候 将需要入 dataStack栈的数据加入到
 *          dataStack 中 而不是直接将helpStack栈中的数据全部加入到dataStack中
 *
 *          可以理解为 helpStack 与 dataStack 两个栈中都存储数据  在加入数据的时候需要 dataTop >= value >= helpTop 即可加入 dataStack
 *          如果不符合 那我们就将dataStack中的数据弹出并加入到helpstack中 或者 将helpStack中的数据弹出并加入到 dataStack中
 *          以达到上述条件即可将 value 添加到 dataStack中
 *
 *          需要注意的是 我们在执行 peek 或者 pop 操作的时候 我们要将 helpStack中的数据 加入到 dataStack中 这样 dataStack才是一个完整且有序的一个栈了
 *
 *          我们这里主要是减少了两个栈间 元素的添加 和弹出操作 以达到 提升效率的目的
 *
 *          当 dataStack 为空的时候 helpStack 一定为空 因为我们在 pop的时候 是需要将helpStack栈中的数据添加到dataStack栈中
 *
 *
 *
 *
 *
 *
 *
 *
 */

public class _MST03_05_SortedStack {



    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> helpStack = new Stack<>();


    public void push(int val) {

        if (dataStack.isEmpty() || dataStack.peek() >= val) {
            dataStack.push(val);
            return;
        }

        while (!dataStack.isEmpty() && dataStack.peek() < val) {
            Integer pop = dataStack.pop();
            helpStack.push(pop);
        }
        dataStack.push(val);
        while (!helpStack.isEmpty()) {
            Integer pop = helpStack.pop();
            dataStack.push(pop);
        }


    }

    public void pop() {
        if (!dataStack.isEmpty()) {
            dataStack.pop();
        }
    }

    public int peek() {

        if (!dataStack.isEmpty()) {
            return dataStack.peek();
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return dataStack.isEmpty();
    }

    //==============================优化后===================================

    public void push1(int val) {

        if (dataStack.isEmpty()) {
            dataStack.push(val);
            return;
        }


        while (!dataStack.isEmpty() && dataStack.peek() < val) {
            Integer pop = dataStack.pop();
            helpStack.push(pop);
        }

        while (!helpStack.isEmpty() && helpStack.peek() > val) {
            Integer pop = helpStack.pop();
            dataStack.push(pop);
        }
        dataStack.push(val);


    }

    public void pop1() {

        while (!helpStack.isEmpty()) {
            dataStack.push(helpStack.pop());
        }


        if (!dataStack.isEmpty()) {
            dataStack.pop();
        }
    }

    public int peek1() {
        while (!helpStack.isEmpty()) {
            dataStack.push(helpStack.pop());
        }

        if (!dataStack.isEmpty()) {
            return dataStack.peek();
        } else {
            return -1;
        }
    }

    public boolean isEmpty1() {
        return dataStack.isEmpty();
    }

}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */