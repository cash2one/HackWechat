package com.tencent.mm.plugin.luckymoney.b;

import android.net.Uri;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.y.g$a;

class ai$1 extends c<tj> {
    final /* synthetic */ ai odM;

    ai$1(ai aiVar) {
        this.odM = aiVar;
        this.xen = tj.class.getName().hashCode();
    }

    private boolean a(tj tjVar) {
        if (tjVar instanceof tj) {
            switch (tjVar.fLO.action) {
                case 1:
                    ai aiVar = this.odM;
                    long j = tjVar.fLO.fpG;
                    if (!aiVar.odH) {
                        aiVar.odH = true;
                        cf dH = ((h) g.h(h.class)).aZi().dH(j);
                        String str = dH.field_content;
                        g$a I = str != null ? g$a.I(str, dH.field_reserved) : null;
                        if (I != null) {
                            String ou = bh.ou(I.hcH);
                            Uri parse = Uri.parse(ou);
                            String queryParameter = parse.getQueryParameter("sendid");
                            int i = bh.getInt(parse.getQueryParameter("channelid"), 1);
                            if (aiVar.odI != null) {
                                g.Dk();
                                g.Di().gPJ.c(aiVar.odI);
                                aiVar.odI = null;
                            }
                            g.Dk();
                            g.Di().gPJ.a(1581, aiVar);
                            aiVar.odI = new af(i, queryParameter, ou, 3, "v1.0");
                            aiVar.odI.talker = dH.field_talker;
                            aiVar.odI.fqm = j;
                            g.Dk();
                            g.Di().gPJ.a(aiVar.odI, 0);
                            break;
                        }
                    }
                    break;
            }
        }
        return false;
    }
}
