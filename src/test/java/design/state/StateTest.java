package design.state;

import design.farm.*;
import org.junit.Test;

public class StateTest {
    @Test
    public void test(){
        System.out.println("StateTest：");
        System.out.println("小麦：刚种下->成熟（2天）");
        System.out.println("鸡：小鸡->成年鸡（4天）");
        Chicken chicken = new Chicken();
        Wheat wheat = new Wheat();
        System.out.println("第一天");
        System.out.println("这是一只"+chicken.stringify());
        System.out.println("这是一个"+wheat.stringify());
        Clock.getInstance().updateState(1);
        System.out.println("第二天");
        System.out.println("这是一只"+chicken.stringify());
        System.out.println("这是一个"+wheat.stringify());
        Clock.getInstance().updateState(1);
        System.out.println("第三天");
        System.out.println("这是一只"+chicken.stringify());
        System.out.println("这是一个"+wheat.stringify());
        Clock.getInstance().updateState(1);
        System.out.println("第四天");
        System.out.println("这是一只"+chicken.stringify());
        System.out.println("这是一个"+wheat.stringify());
        Clock.getInstance().updateState(1);
        System.out.println("第五天");
        System.out.println("这是一只"+chicken.stringify());
        System.out.println("这是一个"+wheat.stringify());
        Clock.getInstance().updateState(1);

    }

}
