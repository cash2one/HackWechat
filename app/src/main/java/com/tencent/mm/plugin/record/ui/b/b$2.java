package com.tencent.mm.plugin.record.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.a.g;
import com.tencent.mm.av.a.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

class b$2 implements OnClickListener {
    final /* synthetic */ b pGP;

    b$2(b bVar) {
        this.pGP = bVar;
    }

    public final void onClick(View view) {
        if (f.ze()) {
            b bVar = (b) view.getTag();
            us usVar = bVar.fve.wdD.wdX;
            if (b.l(bVar.fve)) {
                x.i("MicroMsg.OtherViewWrapper", "same song, do release");
                com.tencent.mm.av.b.Qo();
                if (!this.pGP.pGN) {
                    this.pGP.handler.sendMessageAtFrontOfQueue(this.pGP.handler.obtainMessage(1));
                    return;
                }
                return;
            }
            String absolutePath;
            this.pGP.pGN = true;
            File file = new File(h.f(bVar.fve, bVar.fqm));
            if (file.exists()) {
                absolutePath = file.getAbsolutePath();
            } else if (bVar.fve.fqf == null) {
                absolutePath = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                ar.Hg();
                file = new File(stringBuilder.append(c.Fw()).append("web/").append(g.s(bVar.fve.fqf.getBytes())).toString());
                absolutePath = file.exists() ? file.getAbsolutePath() : "";
            }
            uq uqVar = bVar.fve;
            a aVar = (a) com.tencent.mm.kernel.g.h(a.class);
            String str = uqVar.title;
            String str2 = uqVar.desc;
            String str3 = uqVar.wcQ;
            String str4 = uqVar.wcU;
            String str5 = uqVar.wcS;
            String str6 = uqVar.mvG;
            StringBuilder stringBuilder2 = new StringBuilder();
            ar.Hg();
            com.tencent.mm.av.b.b(aVar.a(6, null, str, str2, str3, str4, str5, str6, stringBuilder2.append(c.Fw()).append("web/").toString(), absolutePath, "", usVar.appId));
            return;
        }
        u.fI(view.getContext());
    }
}
