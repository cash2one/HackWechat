package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.is;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;

public final class q {
    public p fhr;
    public String kvB = null;
    public f yAv;
    boolean yAw = false;
    public Runnable yAx = new 1(this);
    public Runnable yAy = new Runnable(this) {
        final /* synthetic */ q yAA;

        {
            this.yAA = r1;
        }

        public final void run() {
            this.yAA.fhr.csG();
            this.yAA.fhr.csB().vqi = false;
            this.yAA.fhr.csB().vqo = false;
            this.yAA.fhr.csB().cbo();
            ChatFooter csB = this.yAA.fhr.csB();
            if (csB.vpY != null) {
                csB.vpY.setVisibility(0);
            }
            csB = this.yAA.fhr.csB();
            if (csB.vpW != null) {
                csB.vpW.setVisibility(0);
            }
        }
    };
    public c yAz = new c<is>(this) {
        final /* synthetic */ q yAA;

        {
            this.yAA = r2;
            this.xen = is.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            is isVar = (is) bVar;
            if ((isVar instanceof is) && this.yAA.fhr.csl() && (isVar.fzh.fzi == null || isVar.fzh.fzi.equals(this.yAA.fhr.vS()))) {
                if (isVar.fzh.type == 1) {
                    ag.y(this.yAA.yAx);
                } else if (isVar.fzh.type == 2) {
                    this.yAA.fhr.mI(false);
                    ag.y(this.yAA.yAy);
                }
            }
            return false;
        }
    };

    public q(p pVar) {
        this.fhr = pVar;
    }
}
