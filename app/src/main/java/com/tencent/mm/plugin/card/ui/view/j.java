package com.tencent.mm.plugin.card.ui.view;

import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.pb.common.c.g;

public final class j extends g {
    public final boolean h(b bVar) {
        if (this.kIK == null) {
            x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            return true;
        } else if (bVar == null) {
            x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            return false;
        } else {
            String str = this.kIK.atC().code;
            String str2 = bVar.atC().code;
            if (g.AA(str) || g.AA(str2) || str.equals(str2)) {
                return false;
            }
            x.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
            return true;
        }
    }

    public final String e(c cVar) {
        return this.kIK.atC().code;
    }

    public final ab axb() {
        return new v(this, this.kaY);
    }

    public final ab axc() {
        return new f(this, this.kaY);
    }

    public final ab axd() {
        return new t(this, this.kaY);
    }
}
