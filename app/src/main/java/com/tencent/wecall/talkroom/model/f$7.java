package com.tencent.wecall.talkroom.model;

import com.tencent.wecall.talkroom.model.f.f;
import java.util.TimerTask;

class f$7 extends TimerTask {
    final /* synthetic */ f Aog;

    f$7(f fVar) {
        this.Aog = fVar;
    }

    public final void run() {
        if (!this.Aog.Aob) {
            f.a(this.Aog, f.n(this.Aog) + 1);
            if (f.o(this.Aog)) {
                f.b(this.Aog, f.p(this.Aog) + 1);
            }
            if (f.q(this.Aog) == 3 || f.q(this.Aog) == 2) {
                f.c(this.Aog, f.r(this.Aog) + 1);
                this.Aog.AnF.swC = f.r(this.Aog);
            }
            this.Aog.AnF.AoV = f.n(this.Aog) * 1000;
            this.Aog.AnF.swB = f.n(this.Aog);
        }
        if (this.Aog.Anl != null) {
            f fVar = this.Aog.Anl;
            boolean z = this.Aog.Aob;
            f.n(this.Aog);
        }
    }
}
