package com.tencent.liteav;

import com.tencent.liteav.videoencoder.b;

class c$7 implements Runnable {
    final /* synthetic */ b a;
    final /* synthetic */ c b;

    c$7(c cVar, b bVar) {
        this.b = cVar;
        this.a = bVar;
    }

    public void run() {
        try {
            if (this.a != null) {
                this.a.a();
                this.a.a(null);
            }
        } catch (Exception e) {
        }
    }
}
