package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;

public final class a implements e {
    Activity fAF;
    r mIl;
    public com.tencent.mm.plugin.profile.a.a plp;
    public ak plq = new ak(new 1(this), false);

    public a(Activity activity) {
        this.fAF = activity;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(g.CTRL_INDEX, this);
        com.tencent.mm.plugin.profile.a.a aVar = (com.tencent.mm.plugin.profile.a.a) kVar;
        if (i == 0 && i2 == 0) {
            HC(aVar.getURL());
            return;
        }
        if (i != 4) {
            x.e("MicroMsg.ViewTWeibo", "view weibo failed: " + i + ", " + i2);
        }
        HC("http://t.qq.com/" + aVar.phe);
    }

    private void HC(String str) {
        this.plq.TG();
        if (this.mIl != null) {
            this.mIl.dismiss();
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.putExtra("title", this.fAF.getString(R.l.dXi));
        intent.putExtra("zoom", true);
        intent.putExtra("vertical_scroll", false);
        d.b(this.fAF, "webview", ".ui.tools.WebViewUI", intent);
    }
}
