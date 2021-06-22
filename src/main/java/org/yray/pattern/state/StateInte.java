package org.yray.pattern.state;

/**
 * @author lyg
 * @date 2021/6/23 0:05
 */
public interface StateInte {

    void open();
    void close();
    void pause();
    void wash();

    void lock();

    void unlock();

    void start();
    void dry();
}
