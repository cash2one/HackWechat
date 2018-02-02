package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class s implements e {
    Context context;
    r mIl;
    l pZz;
    private ak plq = new ak(new 1(this), false);
    private String voz;

    public s(Context context) {
        this.context = context;
    }

    public final void Su(String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.ViewQZone", "go fail, qqNum is null");
            return;
        }
        this.voz = str;
        ar.Hg();
        String str2 = (String) c.CU().get(46, null);
        ar.Hg();
        x.i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", new Object[]{str2, bh.ou((String) c.CU().get(72, null))});
        if (bh.ov(str2) && bh.ov(r1)) {
            Sv(str);
            return;
        }
        ar.CG().a(233, this);
        this.pZz = new l(o.bY(str), (int) System.currentTimeMillis());
        ar.CG().a(this.pZz, 0);
        this.plq.J(3000, 3000);
    }

    private void Sv(String str) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.context.getString(R.l.dVY, new Object[]{str}));
        intent.putExtra("useJs", true);
        intent.putExtra("vertical_scroll", true);
        intent.putExtra("neverGetA8Key", true);
        d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.plq.TG();
        if (this.mIl != null) {
            this.mIl.dismiss();
        }
        ar.CG().b(233, this);
        if (i == 0 && i2 == 0) {
            l lVar = (l) kVar;
            String RE = lVar.RE();
            if (RE == null || RE.length() == 0) {
                Sv(this.voz);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", RE);
            intent.putExtra("useJs", true);
            intent.putExtra("vertical_scroll", true);
            intent.putExtra("neverGetA8Key", true);
            intent.putExtra("geta8key_session_id", lVar.RM());
            d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", intent);
            return;
        }
        x.e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + i + ", errCode = " + i2);
        Sv(this.voz);
    }
}
