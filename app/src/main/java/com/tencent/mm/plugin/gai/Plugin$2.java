package com.tencent.mm.plugin.gai;

import android.content.Context;
import com.tencent.mm.plugin.gai.Plugin.a;
import com.tencent.mm.sdk.platformtools.x;

class Plugin$2 implements Runnable {
    final /* synthetic */ Plugin mQl;
    final /* synthetic */ a mQm;
    final /* synthetic */ Context val$context;

    Plugin$2(Plugin plugin, Context context, a aVar) {
        this.mQl = plugin;
        this.val$context = context;
        this.mQm = aVar;
    }

    public final void run() {
        String str = "";
        com.google.android.gms.a.a.a.a aVar = null;
        try {
            aVar = com.google.android.gms.a.a.a.x(this.val$context);
            x.d("MicroMsg.Plugin.gai", "adInfo: %s", new Object[]{aVar});
            if (aVar != null) {
                str = aVar.aEq;
                x.i("MicroMsg.Plugin.gai", "get GoogleAid : [%s]", new Object[]{str});
            }
            if (this.mQm != null) {
                this.mQm.Bq(str);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Plugin.gai", e, "AdMatReport:: get Ad Id info error %s", new Object[]{e.getMessage()});
            x.e("MicroMsg.Plugin.gai", "AdMatReport:: get Ad Id info error %s", new Object[]{e.getMessage()});
            if (this.mQm != null) {
                this.mQm.Bq(str);
            }
        } catch (Throwable th) {
            if (aVar != null) {
                str = aVar.aEq;
                x.i("MicroMsg.Plugin.gai", "get GoogleAid : [%s]", new Object[]{str});
            }
            if (this.mQm != null) {
                this.mQm.Bq(str);
            }
        }
    }
}
