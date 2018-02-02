package com.tencent.mm.plugin.fts.a;

public interface h extends Comparable<h> {
    String bp(String str, int i);

    void create();

    void destroy();

    String getName();

    int getPriority();

    int getType();
}
