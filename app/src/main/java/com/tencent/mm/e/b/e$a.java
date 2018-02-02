package com.tencent.mm.e.b;

import java.util.TimerTask;

class e$a extends TimerTask {
    private int fli = (this.fll.fkV * 2);
    private int flj = this.fll.fkV;
    byte[] flk = new byte[this.fli];
    final /* synthetic */ e fll;

    e$a(e eVar) {
        this.fll = eVar;
    }

    public final void run() {
        if (!this.fll.mIsPause) {
            int vu = (int) (0.8d * ((double) this.fll.vu()));
            if (vu < this.fll.fkV * 8) {
                vu = this.fll.fkV * 8;
            }
            if (this.fll.vv() > vu) {
                vu = 8;
            } else {
                vu = 1;
            }
            for (int i = 0; i < vu; i++) {
                int t = this.fll.t(this.flk, this.flj);
                if (this.fll.flb != null && t == 0) {
                    this.fll.flb.q(this.flk, this.flj);
                }
            }
        }
    }
}
