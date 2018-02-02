package com.tencent.pb.common.b;

import com.tencent.pb.common.c.c;

class d$2 implements Runnable {
    final /* synthetic */ d zMh;
    final /* synthetic */ int zMi;
    final /* synthetic */ int zMj;

    d$2(d dVar, int i, int i2) {
        this.zMh = dVar;
        this.zMi = i;
        this.zMj = i2;
    }

    public final void run() {
        if (this.zMh.kAd) {
            c.d("MicroMsg.Voip", new Object[]{this.zMh.TAG2, "onResp netscene already canceled, cmd:" + this.zMh.zMf});
        } else if (this.zMh.zMc != null) {
            this.zMh.zMc.a(this.zMi, this.zMj, "", this.zMh);
        }
    }
}
