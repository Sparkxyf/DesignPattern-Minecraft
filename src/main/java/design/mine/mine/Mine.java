package design.mine.mine;

/**
 * 策略模式环境类
 */
public class Mine {

    private UseToolsService strategy;

    public UseToolsService getStrategy() {
        return strategy;
    }

    public void setStrategy(UseToolsService strategy) {
        this.strategy = strategy;
    }

    public void mineKind(){
        strategy.mineKind();
    }

}
