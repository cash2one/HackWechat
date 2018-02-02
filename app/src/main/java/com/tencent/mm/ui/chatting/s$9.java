package com.tencent.mm.ui.chatting;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.p.b;

class s$9 implements b {
    final /* synthetic */ s ytT;

    s$9(s sVar) {
        this.ytT = sVar;
    }

    public final void oL(String str) {
        x.v("MicroMsg.ChattingMoreBtnBarHelper", "on edit change");
        if (!bh.ov(str)) {
            x.v("MicroMsg.ChattingMoreBtnBarHelper", "enter search mode");
            s.d(this.ytT).setVisibility(8);
            s.b(this.ytT).yvY.ctU();
            if (s.j(this.ytT) != null) {
                s.j(this.ytT).CN(str);
            }
        } else if (s.b(this.ytT).yvY.yAQ) {
            if (s.j(this.ytT) != null) {
                s.j(this.ytT).CN("");
            }
            s.b(this.ytT).yvY.FF(-1);
        } else if (s.k(this.ytT)) {
            s.b(this.ytT).yvY.ctV();
            s.d(this.ytT).setVisibility(0);
            s.d(this.ytT).Fu(s.a(this.ytT).ytp.size());
        } else {
            s.b(this.ytT).yvY.ctV();
            s.d(this.ytT).setVisibility(8);
        }
    }

    public final void Xr() {
        x.v("MicroMsg.ChattingMoreBtnBarHelper", "onQuitSearch");
        if (s.a(this.ytT).ytm) {
            s.b(this.ytT).yvY.ctV();
            s.d(this.ytT).setVisibility(0);
            s.d(this.ytT).Fu(s.a(this.ytT).ytp.size());
        }
    }

    public final void Xs() {
        x.v("MicroMsg.ChattingMoreBtnBarHelper", "onEnterSearch");
        g.pQN.a(219, 21, 1, true);
        if (s.a(this.ytT).ytm) {
            s.b(this.ytT).yvY.ctU();
            s.d(this.ytT).setVisibility(8);
        }
    }

    public final boolean oK(String str) {
        return false;
    }

    public final void Xt() {
    }

    public final void Xu() {
    }
}
