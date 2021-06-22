package org.yray.pattern.visitor;

/**
 * （相当于需要被访问的Element的接口）
 */
public interface VisitedEle {
    void accept(Visitor visitor);

}
