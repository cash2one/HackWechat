package com.tencent.liteav;

import com.tencent.liteav.audio.f;

class c$6 implements f {
    final /* synthetic */ c a;

    c$6(c cVar) {
        this.a = cVar;
    }

    public void a() {
        if (this.a.c != null) {
            this.a.c.onBGMStart();
        }
    }

    public void a(int i) {
        if (this.a.c != null) {
            this.a.c.onBGMComplete(i);
        }
    }

    public void a(long j, long j2) {
        if (this.a.c != null) {
            this.a.c.onBGMProgress(j, j2);
        }
    }
}
