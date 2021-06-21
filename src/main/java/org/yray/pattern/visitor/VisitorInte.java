package org.yray.pattern.visitor;

/***
 * 访问者接口
 */
public interface VisitorInte {

    void view(CallIn in);


    void view(CallOut out);
}
