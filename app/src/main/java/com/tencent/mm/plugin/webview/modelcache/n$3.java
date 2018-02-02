package com.tencent.mm.plugin.webview.modelcache;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bk;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.e.h;

class n$3 extends c<bk> {
    final /* synthetic */ n ttK;

    n$3(n nVar) {
        this.ttK = nVar;
        this.xen = bk.class.getName().hashCode();
    }

    private boolean a(bk bkVar) {
        if (bkVar != null && (bkVar instanceof bk)) {
            if (ac.getContext() != null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(h.xEp, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                ac.getContext().sendBroadcast(intent);
            }
            FileOp.lY(e.gHG);
            FileOp.G(e.gHG, false);
            WebViewCacheDownloadHelper.bRr();
            n.bRn();
        }
        return false;
    }
}
