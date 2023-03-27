package nio.buffer;

/**
 * @author 刘佳俊
 */

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 目标：对缓存区Buffer的常用API进行案例实现
 *
 *
 * Buffer clear(）清空缓冲区并返回对缓冲区的引用
 * Buffer flip(）为将缓冲区的界限设置为当前位置，并将当前位置重置为0
 * int capacity(）返回Buffer的capacity大小
 * boolean hasRemaining(）判断缓冲区中是否还有元素
 * int limit(）返回Buffer的界限（limit）的位置
 * Buffer limit(int n）将设置缓冲区界限为n，并返回一个具有新limit的缓冲区对象
 * Buffer mark(）对缓冲区设置标记
 * int position(）返回缓冲区的当前位置position
 * Buffer position(int n）将设置缓冲区的当前位置为n，并返回修改后的Buffer对象
 * int remaining()返回position和limit之间的元素个数
 * Buffer reset(）将位置position转到以前设置的mark所在的位置
 * Buffer rewind();将位置设为为0．取消设置的mark
 * Buffer 所有子类提供了两个用于数据操作的方法：get() put()方法
 * 取获取Buffer中的数据
 * get()：读取单个字节
 * get (byte［〕dst)：批量读取多个字节到dst中
 * get(int index)：读取指定索引位置的字节（不会移动position)
 * 放到 入数据到Buffer中
 * put(byte b):将给定单个字节写入缓冲区的当前位置
 * put (byte[] src):将src中的字节写入缓存区的当前位置
 * put(int index,byte b)L将指定字节写入缓存区的索引位置（不会移动position
 *
 *
 */
public class BufferTest {

    @Test
    public void test01(){
//1.分配一个缓存区，容量设置为10
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());//0
        System.out.println(buffer.limit());//10
        System.out.println(buffer.capacity());//10
        System.out.println("-----------------------");
//put 往缓存区中添加数据
        String name = "itheima";
        buffer.put(name.getBytes());
        System.out.println(buffer.position());//7
        System.out.println(buffer.limit());//10
        System.out.println(buffer.capacity());//10
        System.out.println("-----------------------");
//3.flip() 为 将缓存区的界限设置为当前位置，并将当前位置设置为 0 可读模式
        buffer.flip();
        System.out.println(buffer.position());//0
        System.out.println(buffer.limit());//7
        System.out.println(buffer.capacity());//10
        System.out.println("-----------------------");
//4. get数据的读取
        char ch = (char) buffer.get();
        System.out.println(ch);//i
        System.out.println(buffer.position());//1
        System.out.println(buffer.limit());//7
        System.out.println(buffer.capacity());//10
    }
    @Test
    public void test02(){
//1.分配一个缓存区，容量设置为10
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());//0
        System.out.println(buffer.limit());//10
        System.out.println(buffer.capacity());//10
        System.out.println("-----------------------");
        String name = "itheima";
        buffer.put(name.getBytes());
        System.out.println(buffer.position());//7
        System.out.println(buffer.limit());//10
        System.out.println(buffer.capacity());//10
        System.out.println("-----------------------");
//2.clear 清楚缓存区中的数据

        buffer.clear();
        System.out.println(buffer.position());//0
        System.out.println(buffer.limit());//10
        System.out.println(buffer.capacity());//10

        // i 表明数据并没有清除 只是恢复了position的位置
        System.out.println((char)buffer.get());

        System.out.println("-----------------------");
//3.定义一个缓存区
        ByteBuffer buf = ByteBuffer.allocate(10);
        String n = "itheima";
        buf.put(n.getBytes());
        buf.flip();
//读取数据
        byte[] b = new byte[2];
        buf.get(b);
        String rs = new String(b);
        System.out.println(rs);//it
        System.out.println(buf.position());//2
        System.out.println(buf.limit());//7
        System.out.println(buf.capacity());//10
        System.out.println("-----------------------");
        buf.mark();//标记此刻这个位置：2
        byte[] b2 = new byte[3];
        buf.get(b2);
        System.out.println(new String(b2));//hei
        System.out.println(buf.position());//5
        System.out.println(buf.limit());//7
        System.out.println(buf.capacity());//10
        System.out.println("-----------------------");
        buf.reset();//回到标记位置 2
        if(buf.hasRemaining()){
            System.out.println(buf.remaining());//5
        }
    }
}
