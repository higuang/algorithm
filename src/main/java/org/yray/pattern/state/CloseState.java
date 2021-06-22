package org.yray.pattern.state;

/**
 * @author lyg
 * @date 2021/6/22 23:50
 */
public class CloseState extends AbstractState {

    public CloseState(String name)
    {
        this.name=name;
    }
    @Override
    public void open()
    {
        context.setCurrState(WashingContext.OPEN_STATE);
        System.out.println("已切换到wash");
    }
}
