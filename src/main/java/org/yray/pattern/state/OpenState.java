package org.yray.pattern.state;

/**
 * @author lyg
 * @date 2021/6/22 23:45
 */
public class OpenState extends AbstractState {
    //这里只重载实现此状态关心的，例如wash，其它的就不写了

    @Override
    public void wash()
    {
        context.setCurrState(WashingContext.WASH_STATE);
        System.out.println("已切换到wash");
    }

    public OpenState(String name)
    {
        this.name=name;
    }
}
