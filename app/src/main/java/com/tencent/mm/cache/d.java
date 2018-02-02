package com.tencent.mm.cache;

import android.graphics.Canvas;

public interface d<T> extends Cloneable {
    void a(Canvas canvas, boolean z);

    void aY(boolean z);

    int aZ(boolean z);

    void add(T t);

    void c(Canvas canvas);

    void onCreate();

    void onDestroy();

    T pop();

    void uP();

    void xv();
}
