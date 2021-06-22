package org.yray.pattern.state;

/**
 * @author lyg
 * @date 2021/6/22 23:29
 */
public class WashingContext implements StateInte{
    public final static CloseState  CLOSE_STATE=new CloseState("关机");
    public final static OpenState  OPEN_STATE=new OpenState("开机");
    public final static WashState  WASH_STATE=new WashState("洗衣");
   private AbstractState currState;

    public AbstractState getCurrState() {
        return currState;
    }

    public WashingContext()
    {
        CLOSE_STATE.setContext(this);
        OPEN_STATE.setContext(this);
        WASH_STATE.setContext(this);
        currState=CLOSE_STATE;
    }
    public void setCurrState(AbstractState currState) {
        this.currState = currState;
    }


    @Override
    public void open() {
        currState.open();
    }

    @Override
    public void close() {
        currState.close();
    }

    @Override
    public void pause() {
        currState.pause();
    }

    @Override
    public void wash() {
        currState.wash();
    }

    @Override
    public void lock() {
        currState.lock();
    }

    @Override
    public void unlock() {
        currState.unlock();
    }

    @Override
    public void start() {
        currState.start();
    }

    @Override
    public void dry() {
        currState.dry();
    }
}
