package org.yray.pattern.state;

/**
 * @author lyg
 * @date 2021/6/22 23:25
 */
public abstract class AbstractState implements StateInte {

    protected WashingContext context;

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WashingContext getContext() {
        return context;
    }

    public void setContext(WashingContext context) {
        this.context = context;
    }

    //这里我们统统给默认实现，开机，启动，暂停，洗衣，脱水，童锁，解锁，关机
    @Override
    public void open()
    {
        System.out.println("当前状态["+context.getCurrState().getName()+"],不能操作open");
    }
    @Override
    public void close()
    {
        System.out.println("当前状态["+context.getCurrState().getName()+"],不能操作close");
    }
    @Override
    public void pause()
    {
        System.out.println("当前状态["+context.getCurrState().getName()+"],不能操作pause");
    }
    @Override
    public void wash()
    {
        System.out.println("当前状态["+context.getCurrState().getName()+"],不能操作wash");
    }
    @Override
    public void lock()
    {
        System.out.println("当前状态["+context.getCurrState().getName()+"],不能操作lock");
    }
    @Override
    public void unlock()
    {
        System.out.println("当前状态["+context.getCurrState().getName()+"],不能操作unlock");
    }
    @Override
    public void start()
    {
        System.out.println("当前状态["+context.getCurrState().getName()+"],不能操作start");
    }
    @Override
    public void dry()
    {
        System.out.println("当前状态["+context.getCurrState().getName()+"],不能操作dry");
    }
}
