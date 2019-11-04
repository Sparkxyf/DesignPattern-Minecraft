package design.farm.Specification;

import design.farm.FarmLand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SpecificationShow {
    private static SpecificationShow instance;

    // 私有构造器
    private SpecificationShow() { }

    public static SpecificationShow getInstance() {
        if (instance == null) {
            // 双重检查锁定
            // 保证了同一时间只能只能有一个对象访问此同步块
            synchronized (SpecificationShow.class) {
                if(instance==null){
                    instance=new SpecificationShow();
                }
            }
        }
        return instance;
    }
}
