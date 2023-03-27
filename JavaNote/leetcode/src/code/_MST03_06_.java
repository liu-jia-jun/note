package code;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 刘佳俊
 *
 * 面试题 03.06. 动物收容所
 *      动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，
 *      收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。
 *      换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，
 *      比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 *      enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 *      dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 *
 * 思路 :
 *
 *       1. 猫狗队列问题 , 题目中说明 需要领养最老的动物 说明是先进先出 属于队列特点
 *       2. 我们创建两个队列 一个猫队列 一个狗队列 注意这里的动物编号 是自增的 所以 这里的动物编号就能判断 哪个先进来
 *
 *       3. 在添加 animal数组时 我们只需要根据 animal[1] 来判断其动物类型 如果是1 则添加到狗队列 如果是 0 则添加到猫队列
 *       4. 在领养任意动物时 需要将 比较 两个队列中 哪个动物最老 则返回 哪个队列的首部元素
 *          如果有为空的队列则直接返回另一个队列的首部 如果两个队列都为空则返回 [-1,-1]
 *       5. 在明确要领养哪类动物时 我们直接返回对应队列的 首部元素 如果该队列为空 那我们直接返回 [-1,-1]
 *
 *
 *
 */
public class _MST03_06_ {

    Queue<int[]> dogQueue = new LinkedList<>();
    Queue<int[]> catQueue = new LinkedList<>();

    public void enqueue(int[] animal) {
        if (animal[1] == 1) {
            dogQueue.add(animal);
        } else {
            catQueue.add(animal);
        }
    }

    public int[] dequeueAny() {


        int[] dog = dogQueue.peek();
        int[] cat = catQueue.peek();


        if (dog == null && cat == null) {
            return new int[]{-1, -1};
        }

        if (dog == null) {
            catQueue.remove();
            return cat;
        }
        if (cat == null) {
            dogQueue.remove();
            return dog;
        }
        if (dog[0] < cat[0]) {
            dogQueue.remove();
            return dog;
        } else {
            catQueue.remove();
            return cat;
        }
    }

    public int[] dequeueDog() {
        if (!dogQueue.isEmpty()) {
            return dogQueue.remove();
        }
        return new int[]{-1, -1};
    }

    public int[] dequeueCat() {
        if (!catQueue.isEmpty()) {
            return catQueue.remove();
        }
        return new int[]{-1, -1};
    }
}
