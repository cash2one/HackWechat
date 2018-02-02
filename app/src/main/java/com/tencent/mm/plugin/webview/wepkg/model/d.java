package com.tencent.mm.plugin.webview.wepkg.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgProcessPreloadService;
import com.tencent.mm.plugin.webview.wepkg.utils.a;
import com.tencent.mm.plugin.webview.wepkg.utils.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public class d extends c<kj> {
    private static volatile String fIG;
    private static volatile long tMF;
    private static volatile long tMG;
    private static Set<String> tMH = new HashSet();

    public d() {
        this.xen = kj.class.getName().hashCode();
    }

    private boolean a(kj kjVar) {
        switch (kjVar.fBG.type) {
            case 0:
            case 1:
                String str = "MicroMsg.Wepkg.NotifyGameWebviewOperationListener";
                String str2 = "on NotifyGameWebviewOperationListener operation listener, type:%d, hashcode:%s, event hashcode:%s, threadId:%s, isUIThead:%s";
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(kjVar.fBG.type);
                objArr[1] = Integer.valueOf(hashCode());
                objArr[2] = Integer.valueOf(kjVar.hashCode());
                objArr[3] = Long.valueOf(Thread.currentThread().getId());
                objArr[4] = Boolean.valueOf(Thread.currentThread() == Looper.getMainLooper().getThread());
                x.i(str, str2, objArr);
                String str3 = "";
                try {
                    str3 = kjVar.fBG.intent.getStringExtra("rawUrl");
                } catch (Exception e) {
                }
                synchronized (d.class) {
                    if (!bh.ou(fIG).equalsIgnoreCase(str3)) {
                        fIG = str3;
                        tMF = System.currentTimeMillis();
                        tMG = System.currentTimeMillis();
                        if (ac.cfw()) {
                            b.tNW = g.zZ().zK();
                        }
                        if (!com.tencent.mm.plugin.webview.wepkg.utils.d.Qt(str3)) {
                            x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page. disableWepkg:" + b.tNW);
                            b(kjVar);
                            break;
                        }
                        x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", com.tencent.mm.plugin.webview.wepkg.utils.d.Qq(str3));
                        kjVar.fBG.group = com.tencent.mm.a.g.s(bh.ou(str3).getBytes()) + "_" + System.currentTimeMillis();
                        ag.h(new a(kjVar), 500);
                        c 1 = new 1(this, kjVar);
                        Bundle bundle = new Bundle(1);
                        bundle.putInt("call_cmd_type", 0);
                        bundle.putString("call_raw_url", str3);
                        WepkgProcessPreloadService.a(1, bundle);
                        break;
                    }
                    x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
                    break;
                }
        }
        return false;
    }

    private static synchronized void b(kj kjVar) {
        synchronized (d.class) {
            ag.h(new 2(), 1000);
            if (kjVar != null) {
                String str;
                if (!bh.ov(kjVar.fBG.group)) {
                    if (tMH.contains(kjVar.fBG.group)) {
                        tMH.remove(kjVar.fBG.group);
                    } else {
                        tMH.add(kjVar.fBG.group);
                    }
                }
                Context context = kjVar.fBG.context != null ? kjVar.fBG.context : ac.getContext();
                if (kjVar.fBG.intent == null) {
                    kjVar.fBG.intent = new Intent();
                }
                kjVar.fBG.intent.putExtra("disable_wepkg", b.tNW);
                switch (kjVar.fBG.type) {
                    case 0:
                        com.tencent.mm.plugin.webview.ui.tools.d.a(kjVar.fBG.intent.getExtras(), "webview", ".ui.tools.game.GameWebViewUI", kjVar.fBG.fBH, new 3(context, kjVar));
                        break;
                    case 1:
                        com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.TransparentWebViewUI", kjVar.fBG.intent);
                        break;
                }
                x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", Long.valueOf(System.currentTimeMillis() - tMF));
                String str2 = "";
                try {
                    str2 = kjVar.fBG.intent.getStringExtra("rawUrl");
                    kjVar.fBG.context = null;
                    str = str2;
                } catch (Exception e) {
                    str = str2;
                }
                a.b("preloadWebTime", str, com.tencent.mm.plugin.webview.wepkg.utils.d.Qq(str), null, -1, r6, null);
            }
        }
    }
}
