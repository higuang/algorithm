package org.yray.pattern.state;

/**
 * @author lyg
 * @date 2021/6/22 23:56
 */
public class MainRun {
    public static void main(String[] args) {
        WashingContext courseVideoContext = new WashingContext();
        courseVideoContext.dry();
        courseVideoContext.open();
        courseVideoContext.pause();
        courseVideoContext.unlock();
    }
}
