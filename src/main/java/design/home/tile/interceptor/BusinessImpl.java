package design.home.tile.interceptor;

import design.auxiliary.HomeInit;
import design.farm.Clock;

public class BusinessImpl implements Business {
    public void doBusiness(){
        Clock.getInstance().updateState(1);
        HomeInit.daily.updateState();
        HomeInit.mission.setDaily();
    }
}
