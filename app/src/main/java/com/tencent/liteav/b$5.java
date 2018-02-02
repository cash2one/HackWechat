package com.tencent.liteav;

import com.tencent.liteav.basic.util.a;

class b$5 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ b c;

    b$5(b bVar, int i, String str) {
        this.c = bVar;
        this.a = i;
        this.b = str;
    }

    public void run() {
        a.a(this.c.a, this.a, this.b);
    }
}
