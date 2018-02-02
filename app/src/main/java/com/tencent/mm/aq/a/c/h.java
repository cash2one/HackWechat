package com.tencent.mm.aq.a.c;

import java.util.concurrent.Executor;

public interface h extends Executor {
    void pause();

    void remove(Object obj);

    void resume();

    boolean vg();
}
