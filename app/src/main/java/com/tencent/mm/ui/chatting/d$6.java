package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;

class d$6 implements a {
    final /* synthetic */ d yqB;
    final /* synthetic */ boolean yqD;

    d$6(d dVar, boolean z) {
        this.yqB = dVar;
        this.yqD = z;
    }

    public final boolean uF() {
        if (this.yqD) {
            x.i("MicroMsg.AutoPlay", "speaker true");
            this.yqB.cri();
            if (this.yqB.yqo != null) {
                this.yqB.yqq = u.a(this.yqB.yqo.thisActivity(), this.yqB.yqo.getString(R.l.ejc), 2000);
            }
            this.yqB.kCS = true;
            this.yqB.crg();
        } else {
            x.i("MicroMsg.AutoPlay", "speaker off");
            this.yqB.kCS = false;
            d dVar = this.yqB;
            if (dVar.mql.isPlaying()) {
                x.d("MicroMsg.AutoPlay", "deal sensor event, play next");
                dVar.bdr();
            }
        }
        return false;
    }
}
