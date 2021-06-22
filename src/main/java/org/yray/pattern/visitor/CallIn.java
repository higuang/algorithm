package org.yray.pattern.visitor;

public class CallIn implements VisitedEle {

    private long fee;
    private long feeTime;

    public CallIn(long fee,long feeTime)
    {
        this.fee=fee;
        this.feeTime=feeTime;
    }
    @Override
    public void accept(Visitor visitor) {
            visitor.view(this);
    }

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public long getFeeTime() {
        return feeTime;
    }

    public void setFeeTime(long feeTime) {
        this.feeTime = feeTime;
    }
}
