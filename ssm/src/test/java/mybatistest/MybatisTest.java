package mybatistest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 刘佳俊
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/bean.xml")
public class MybatisTest {
    @Test
    public void test(){
        System.out.println("hello");
    }
}
