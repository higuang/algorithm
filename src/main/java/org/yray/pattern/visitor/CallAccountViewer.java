package org.yray.pattern.visitor;

public class CallAccountViewer implements Visitor {

    private long sumCallInFee;
    private long sumCallOutFee;

    public long getSumCallInFee() {
        return sumCallInFee;
    }

    public void setSumCallInFee(long sumCallInFee) {
        this.sumCallInFee = sumCallInFee;
    }

    public long getSumCallOutFee() {
        return sumCallOutFee;
    }

    public void setSumCallOutFee(long sumCallOutFee) {
        this.sumCallOutFee = sumCallOutFee;
    }

    @Override
    public void view(CallIn in) {

        this.sumCallInFee+=in.getFee();
    }

    @Override
    public void view(CallOut out) {
        this.sumCallOutFee+=out.getFee();
    }
}
