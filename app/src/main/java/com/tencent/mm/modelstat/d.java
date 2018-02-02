package com.tencent.mm.modelstat;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;

public final class d {
    private static d hQB;
    private HashSet<String> hQA = new HashSet();
    private a hQz = new a();

    static /* synthetic */ void a(d dVar, int i, Activity activity) {
        int hashCode = activity.hashCode();
        String className = activity.getComponentName().getClassName();
        x.v("MicroMsg.ClickFlowStatSender", "callback opCode:%d activity:%s hash:%d ignore:%s %s", new Object[]{Integer.valueOf(i), className, Integer.valueOf(hashCode), Boolean.valueOf(dVar.hQA.contains(className)), bh.cgy()});
        if (!dVar.hQA.contains(className)) {
            b(i, className, hashCode);
        }
    }

    public static void a(Application application) {
        application.registerActivityLifecycleCallbacks(SR().hQz);
    }

    public static boolean SQ() {
        a aVar = SR().hQz;
        return aVar.hQE > aVar.hQF;
    }

    public static void b(int i, String str, int i2) {
        Intent intent = new Intent("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT");
        intent.putExtra("opCode", i);
        intent.putExtra("ui", str);
        intent.putExtra("uiHashCode", i2);
        intent.putExtra("nowMilliSecond", bh.Wp());
        intent.putExtra("elapsedRealtime", SystemClock.elapsedRealtime());
        Context context = ac.getContext();
        if (context == null) {
            return;
        }
        if (ac.cfw()) {
            c.SO().r(intent);
            return;
        }
        x.d("MicroMsg.ClickFlowStatSender", "sendBroadcast, Intent: %s, Extra: %s", new Object[]{intent, intent.getExtras()});
        context.sendBroadcast(intent);
    }

    private d() {
        this.hQA.add("com.tencent.mm.ui.LauncherUI");
        this.hQA.add("com.tencent.mm.plugin.profile.ui.ContactInfoUI");
        this.hQA.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        this.hQA.add("com.tencent.mm.ui.conversation.BizConversationUI");
        this.hQA.add("com.tencent.mm.ui.chatting.ChattingUI");
        this.hQA.add("com.tencent.mm.plugin.label.ui.ContactLabelEditUI");
        this.hQA.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI");
        this.hQA.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI1");
        this.hQA.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI2");
        this.hQA.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI3");
        this.hQA.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI4");
    }

    public static d SR() {
        if (hQB == null) {
            synchronized (d.class) {
                if (hQB == null) {
                    hQB = new d();
                }
            }
        }
        return hQB;
    }

    public static void f(String str, long j, long j2) {
        if (com.tencent.mm.protocal.d.vAC || com.tencent.mm.protocal.d.vAD || com.tencent.mm.protocal.d.vAB) {
            x.i("MicroMsg.ClickFlowStatSender", "kvCheck :%s [%s,%s,%s]", new Object[]{str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j2 - j)});
            com.tencent.mm.plugin.report.d.pPH.k(13393, "99999,0,0," + j + "," + j2 + "," + str);
        }
    }
}
