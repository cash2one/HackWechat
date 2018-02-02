package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.wcdb.database.SQLiteDatabase;

class d$1 implements e {
    final /* synthetic */ String gIT;
    final /* synthetic */ int hLI;
    final /* synthetic */ Context val$context;
    final /* synthetic */ String val$url;
    final /* synthetic */ a vch;

    d$1(Context context, int i, String str, String str2, a aVar) {
        this.val$context = context;
        this.hLI = i;
        this.gIT = str;
        this.val$url = str2;
        this.vch = aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(233, this);
        x.i("MicroMsg.DeepLinkHelper", "[oneliang][doDeepLink][onSceneEnd]:errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        boolean z = false;
        if (kVar != null && (kVar instanceof l)) {
            l lVar = (l) kVar;
            x.d("MicroMsg.DeepLinkHelper", "bitset:" + lVar.RK());
            long RK = lVar.RK();
            String RE = lVar.RE();
            if (d.ae(RE, RK)) {
                try {
                    x.i("MicroMsg.DeepLinkHelper", "[oneliang] uri: %s", new Object[]{RE});
                    z = d.a(this.val$context, lVar.RM(), lVar.RN(), RE);
                    g.pQN.h(11405, new Object[]{RE, Integer.valueOf(1), Integer.valueOf(this.hLI), this.gIT, bh.ou(this.val$url)});
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", new Object[]{""});
                    g.pQN.h(11405, new Object[]{RE, Integer.valueOf(0), Integer.valueOf(this.hLI), this.gIT, bh.ou(this.val$url)});
                }
            } else {
                x.i("MicroMsg.DeepLinkHelper", "[oneliang] no permission");
                Intent intent = new Intent();
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.setClassName(ac.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
                intent.putExtra("geta8key_session_id", lVar.RM());
                intent.putExtra("geta8key_cookie", lVar.RN());
                ac.getContext().startActivity(intent);
                g.pQN.h(11405, new Object[]{RE, Integer.valueOf(0), Integer.valueOf(this.hLI), this.gIT, bh.ou(this.val$url)});
                z = true;
            }
        }
        if (this.vch != null) {
            this.vch.a(i, i2, str, kVar, z);
        }
    }
}
