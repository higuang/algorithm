package org.yray.pattern.visitor;

public class MainRun {
    public static void main(String[] args) {
        CallAccount callAccount=new CallAccount();
        callAccount.addEle(new CallOut(1,1));
        callAccount.addEle(new CallOut(2,3));
        callAccount.addEle(new CallIn(3,13));
        callAccount.addEle(new CallIn(4,14));
        CallAccountViewer viewer=new CallAccountViewer();
        callAccount.accept(viewer);
        System.out.println(viewer.getSumCallInFee());
        System.out.println(viewer.getSumCallOutFee());
    }
}
