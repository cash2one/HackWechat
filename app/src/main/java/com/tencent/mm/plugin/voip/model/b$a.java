package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.x;
import java.util.TimerTask;

class b$a extends TimerTask {
    final /* synthetic */ b sjt;

    b$a(b bVar) {
        this.sjt = bVar;
    }

    public final void run() {
        System.currentTimeMillis();
        if (b.a(this.sjt) == 1 && this.sjt.siI) {
            System.currentTimeMillis();
            if (b.b(this.sjt) + this.sjt.hXm < b.c(this.sjt) && b.d(this.sjt) == 0) {
                b.a(this.sjt, 1);
                int L = this.sjt.siT.L(b.e(this.sjt), this.sjt.hXm);
                b.a(this.sjt, 0);
                if (L < 0) {
                    x.d("MicroMsg.Voip.AudioPlayer", "Task AudioPlayer::  pDevCallBack.PlayDevDataCallBack ret :" + L);
                    return;
                }
                synchronized (b.f(this.sjt)) {
                    System.arraycopy(b.e(this.sjt), 0, b.g(this.sjt), b.b(this.sjt), this.sjt.hXm);
                    b.b(this.sjt, b.b(this.sjt) + this.sjt.hXm);
                    b.c(this.sjt, b.h(this.sjt) + (this.sjt.hXm >> 1));
                }
            }
        }
    }
}
