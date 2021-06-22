package org.yray.pattern.visitor;

/***
 * 访问者接口
 */
public interface Visitor {

    void view(CallIn in);


    void view(CallOut out);
}
