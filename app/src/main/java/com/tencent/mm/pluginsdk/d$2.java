package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.wcdb.database.SQLiteDatabase;

class d$2 implements e {
    final /* synthetic */ int hLI;
    final /* synthetic */ Bundle tCn;
    final /* synthetic */ Context val$context;
    final /* synthetic */ a vch;
    final /* synthetic */ String vci;

    d$2(Bundle bundle, Context context, int i, String str, a aVar) {
        this.tCn = bundle;
        this.val$context = context;
        this.hLI = i;
        this.vci = str;
        this.vch = aVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ar.CG().b(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, this);
        x.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: errType = %s; errCode = %s; errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        boolean z = false;
        if (kVar != null && (kVar instanceof ak)) {
            String Sp = ((ak) kVar).Sp();
            if (d.Re(Sp)) {
                try {
                    x.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: deepLinkUri = %s", new Object[]{Sp});
                    x.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink gotoUri extraData: %s", new Object[]{this.tCn});
                    z = d.a(this.val$context, Sp, this.hLI, this.tCn, this.vci);
                    g.pQN.h(11405, new Object[]{this.vci, Integer.valueOf(this.hLI), Integer.valueOf(1), Sp});
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", new Object[]{""});
                    g.pQN.h(11405, new Object[]{this.vci, Integer.valueOf(this.hLI), Integer.valueOf(0), Sp});
                }
            } else {
                x.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: translate failed");
                Intent intent = new Intent();
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                intent.setClassName(ac.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
                intent.putExtra("showShare", false);
                x.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink goto WebViewUI extraData: %s", new Object[]{this.tCn});
                if (this.tCn != null) {
                    intent.putExtras(this.tCn);
                }
                ac.getContext().startActivity(intent);
                g.pQN.h(11405, new Object[]{this.vci, Integer.valueOf(this.hLI), Integer.valueOf(0), Sp});
                z = true;
            }
        }
        if (this.vch != null) {
            this.vch.a(i, i2, str, kVar, z);
        }
    }
}
