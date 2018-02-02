package com.tencent.liteav.basic.b;

import com.tencent.liteav.basic.util.TXCTimeUtil;

class a$3 implements Runnable {
    final /* synthetic */ a a;

    a$3(a aVar) {
        this.a = aVar;
    }

    public void run() {
        a.a(this.a, true);
        a.e(this.a, TXCTimeUtil.getTimeTick());
    }
}
