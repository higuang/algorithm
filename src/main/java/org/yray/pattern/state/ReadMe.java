package org.yray.pattern.state;

/**
 * @author lyg
 * @date 2021/6/22 22:54
 * 一个对象的行为取决于一个或多个动态变化的属性，这样的属性叫做状态，这样的对象叫做有状态的（ stateful）对象，
 * 这样的对象状态是从事先定义好的一系列值中取出的。当一个这样的对象与外部事件产生互动时，其内部状态就会改变，从而使得系统的行为也随之发生变化
 * 允许一个对象在其内部状态改变时改变它的行为，对象看起来似乎修改了它的类。其别名为状态对象（ Objects for States），状态模式是对象行为型模式
 * 状态模式包含如下角色：
 * Context：环境类，也称为上下文，它定义了客户感兴趣的接口，维护一个当前状态，并将与状态相关的操作委托给当前状态对象来处理。
 * State：抽象状态类，定义一个接口，用以封装环境对象中的特定状态所对应的行为。
 * Concretestate：具体状态类，实现抽象状态所对应的行为
 * 关键点，主要应用于当前的状态会影响到到接下来的状态是否可以切换，并把转换规则抽像出来独立封装。
 *
 *
 * 洗衣机为例
 * 可设置的状态有，开机，启动，暂停，洗衣，脱水，童锁，解锁，关机
 * 只有开机了才可以设其它状态
 * 童锁时，只能操作关机
 * 只有启动状态才可以操作洗衣，脱水
 * 只有在洗衣时，才可以操作暂停
 * 。。。等等，各种你能想到的合理需求
 * 试想下，如果不用状态模式维护起来，代码各种if,else充斥满页,直教后来人看得吐血
 */
public class ReadMe {
}
