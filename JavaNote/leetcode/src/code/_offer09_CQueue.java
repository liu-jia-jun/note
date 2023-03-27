package code;

import java.util.Stack;

/**
 * @author 刘佳俊
 *
 *
 * 用两个栈实现队列:
 *          用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 *          分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *
 *  思路:
 *       1. 用两个栈实现一个队列  栈先进后出 队列先进先出
 *       2. 题目明确使用两个栈 我们使用其中一个栈 作为专门添加数据的栈 appendStack 另一个栈 作为专门 删除数据的栈deleteStack
 *       3. 当我们将数据 添加到 appendStack中 再将 appendStack栈中的数据依次 弹出 将弹出的数据再依次的添加到 deleteStack
 *              此时我们可以发现 因为两次的先进后出 变成了数据上的先进先出
 *       4. 添加数据时 只 添加到 appendStack中
 *       5. 删除数据时 只删除 deleteStack中的元素
 *              如果 deleteStack 栈中含有数据 就直接删除数据
 *              如果 deleteStack 栈中未含有数据 就将 appendStack 栈中全部数据数据依次弹出 之后再依次添加到 deleteStack中 再去删除数据
 *
 *       6. 如果删除数据的时候 两个栈都为空 则返回 -1
 *
 *
 */
public class _offer09_CQueue {

    Stack<Integer> appendStack = new Stack<>();
    Stack<Integer> deleteStack = new Stack<>();


    public void appendTail(int value) {
        appendStack.add(value);
    }

    public int deleteHead() {

        // 自己的实现
        if(deleteStack.isEmpty()){
            if(appendStack.isEmpty()){
                return -1;
            }else{
                while(!appendStack.isEmpty()){
                   deleteStack.add(appendStack.pop());
                }
                return deleteStack.pop();
            }
        }else{
            return deleteStack.pop();
        }


        // 书上的实现
//        if (deleteStack.isEmpty() && appendStack.isEmpty()) {
//            return -1;
//        } else if (deleteStack.isEmpty()) {
//            while (!appendStack.isEmpty()) {
//                deleteStack.add(appendStack.pop());
//            }
//        }
//        return deleteStack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */