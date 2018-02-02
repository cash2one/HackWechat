package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.tools.p.b;

class u$10 implements b {
    final /* synthetic */ u yAV;
    private int yAX = 0;

    public u$10(u uVar) {
        this.yAV = uVar;
    }

    public final void oL(String str) {
        if (bh.ov(str)) {
            this.yAX = 0;
            this.yAV.FF(-1);
            return;
        }
        if (str.length() > this.yAX) {
            g.pQN.h(10451, new Object[]{Integer.valueOf(1)});
        }
        this.yAX = str.length();
        g.pQN.h(10456, new Object[]{Integer.valueOf(1)});
        this.yAV.ytQ.CN(str);
    }

    public final void Xr() {
        new af().post(new Runnable(this) {
            final /* synthetic */ u$10 yAY;

            {
                this.yAY = r1;
            }

            public final void run() {
                this.yAY.yAV.fhr.csM();
            }
        });
    }

    public final void Xs() {
    }

    public final boolean oK(String str) {
        return false;
    }

    public final void Xt() {
    }

    public final void Xu() {
    }
}
