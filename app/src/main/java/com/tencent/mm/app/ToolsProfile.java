package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.w;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.f.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import java.util.Locale;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class ToolsProfile extends e {
    public static final String ffc = (ac.getPackageName() + ":tools");
    private static Locale locale;

    public final void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        ClassLoader classLoader = ToolsProfile.class.getClassLoader();
        a.ay(ac.getContext());
        i.a(new 1(this));
        i.cq(ffc);
        k.setupBrokenLibraryHandler();
        AppLogic.setCallBack(new AppCallBack(ac.getContext()));
        k.b(com.tencent.mm.sdk.a.xdV, ToolsProfile.class.getClassLoader());
        q wVar = new w(c.aA(this.app.getBaseContext()));
        wVar.ee("TOOL");
        r.icH = bh.a(wVar.ef(".com.tencent.mm.debug.test.display_errcode"), false);
        r.icI = bh.a(wVar.ef(".com.tencent.mm.debug.test.display_msgstate"), false);
        r.icJ = bh.a(wVar.ef(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        r.icK = bh.a(wVar.ef(".com.tencent.mm.debug.test.network.force_touch"), false);
        r.icL = bh.a(wVar.ef(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        r.icM = bh.a(wVar.ef(".com.tencent.mm.debug.test.crashIsExit"), false);
        r.icQ = bh.a(wVar.ef(".com.tencent.mm.debug.test.album_show_info"), false);
        r.icR = bh.a(wVar.ef(".com.tencent.mm.debug.test.location_help"), false);
        r.icU = bh.a(wVar.ef(".com.tencent.mm.debug.test.force_soso"), false);
        r.icV = bh.a(wVar.ef(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        r.icW = bh.a(wVar.ef(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        r.icX = bh.a(wVar.ef(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        r.ida = bh.a(wVar.ef(".com.tencent.mm.debug.test.filterfpnp"), false);
        r.idb = bh.a(wVar.ef(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bh.a(wVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        r.icY = a;
        if (a != 4 && r.icY > 0) {
            v.xmG = r.icY;
            x.e("MicroMsg.ToolDebugger", "cdn thread num " + r.icY);
        }
        r.icZ = bh.a(wVar.ef(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            a = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.CE(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            x.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            String string = wVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bh.ov(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.vAu = "android-" + string;
                d.vAw = string;
                b.UI(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.ceL());
            }
        } catch (Exception e2) {
            x.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.vAy).append(" new: ").append(a);
            d.vAy = (long) a;
        } catch (Exception e3) {
            x.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            wVar.gyS.gyb = Integer.decode(wVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            x.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        try {
            boolean a2 = bh.a(wVar.ef(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = bh.a(wVar.ef(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = bh.a(wVar.ef(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = bh.a(wVar.ef(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e5) {
            x.i("MicroMsg.ToolDebugger", "no debugger was got");
        }
        r.ido = bh.az(wVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        x.d("MicroMsg.ToolDebugger", "Test.jsapiPermission = " + r.ido);
        r.idp = bh.az(wVar.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
        x.d("MicroMsg.ToolDebugger", "Test.generalCtrl = " + r.idp);
        r.idq = bh.a(wVar.ef(".com.tencent.mm.debug.skiploadurlcheck"), false);
        x.d("MicroMsg.ToolDebugger", "Test.skipLoadUrlCheck = " + r.idq);
        r.idr = bh.a(wVar.ef(".com.tencent.mm.debug.forcex5webview"), false);
        x.d("MicroMsg.ToolDebugger", "Test.forceX5WebView = " + r.idr);
        a.cl(ffc);
        k.b("wcdb", classLoader);
        k.b("wechatcommon", classLoader);
        k.b(com.tencent.mm.sdk.a.xdX, classLoader);
        k.b("wechatImgTools", classLoader);
        k.b("FFmpeg", classLoader);
        k.b("wechatpack", classLoader);
        int yp = m.yp();
        if ((yp & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            x.i("MicroMsg.ToolsProfile", "load wechatsight_v7a, core number: %d ", Integer.valueOf(yp >> 12));
            k.b("wechatsight_v7a", classLoader);
            if ((yp >> 12) >= 4) {
                com.tencent.mm.plugin.sight.base.b.qsU = 3;
                com.tencent.mm.plugin.sight.base.b.qsW = 3;
                com.tencent.mm.plugin.sight.base.b.qsX = 544000;
            } else {
                com.tencent.mm.plugin.sight.base.b.qsU = 1;
                com.tencent.mm.plugin.sight.base.b.qsW = 1;
                com.tencent.mm.plugin.sight.base.b.qsX = 640000;
            }
        } else {
            x.i("MicroMsg.ToolsProfile", "load wechatsight");
            k.b("wechatsight", classLoader);
            com.tencent.mm.plugin.sight.base.b.qsU = 1;
            com.tencent.mm.plugin.sight.base.b.qsW = 1;
            com.tencent.mm.plugin.sight.base.b.qsX = 640000;
        }
        SightVideoJNI.registerALL();
        locale = MMActivity.initLanguage(this.app.getBaseContext());
        m.tZ();
        if (com.tencent.mm.compatible.util.d.fM(14) && MMApplicationLike.applicationLike != null) {
            MMApplicationLike.applicationLike.getApplication().registerActivityLifecycleCallbacks(new 6(this));
        }
        FileOp.init(false);
        MMBitmapFactory.init();
        x.i("MicroMsg.ToolsProfile", "start time check toolsprofile use time = " + (System.currentTimeMillis() - currentTimeMillis));
        com.tencent.mm.pluginsdk.model.x.a.ef(ac.getContext());
        com.tencent.xweb.util.b anonymousClass2 = new com.tencent.xweb.util.b(this) {
            final /* synthetic */ ToolsProfile ffM;

            {
                this.ffM = r1;
            }

            public final void i(String str, String str2) {
                x.i(str, str2);
            }

            public final void e(String str, String str2) {
                x.e(str, str2);
            }

            public final void w(String str, String str2) {
                x.w(str, str2);
            }

            public final void d(String str, String str2) {
                x.d(str, str2);
            }

            public final void v(String str, String str2) {
                x.v(str, str2);
            }
        };
        com.tencent.xweb.q anonymousClass3 = new com.tencent.xweb.q(this) {
            final /* synthetic */ ToolsProfile ffM;

            {
                this.ffM = r1;
            }

            public final void h(long j, long j2) {
                x.v("MicroMsg.ToolsProfile", "callback: idkeyStat:577" + ", " + j + ", 1");
                g.pQN.a(577, j, 1, true);
            }

            public final void w(int i, int i2, int i3) {
                x.v("MicroMsg.ToolsProfile", "callback: idkeyForPair:577" + ", " + i + ", 1, 577" + ", " + i2 + ", " + i3);
                g.pQN.a(577, 577, i, i2, 1, i3, true);
            }

            public final void k(int i, String str) {
                x.v("MicroMsg.ToolsProfile", "callback: kvStat:" + i + ", " + str);
                g.pQN.k(i, str);
            }

            public final void a(int i, int i2, String str, int i3, int i4, int i5, int i6, int i7) {
                x.v("MicroMsg.ToolsProfile", "callback: kvStat:15003" + ", 17," + i + ",0," + str + "," + i3 + ",-1," + i4 + "," + i5 + "," + i6);
                g.pQN.h(15003, Integer.valueOf(17), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), str, Integer.valueOf(an.getNetType(ac.getContext())), Integer.valueOf(i3), Integer.valueOf(-1), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7));
            }
        };
        WebViewExtensionListener 4 = new 4(this);
        XWalkEnvironment.setTempUpdateConfigUrl(MMWebView.zvE);
        com.tencent.xweb.r.a(ac.getContext(), anonymousClass2, anonymousClass3, 4);
        com.tencent.xweb.b.d.a(com.tencent.mm.plugin.downloader.f.a.aAk());
        WebView.initWebviewCore(ac.getContext(), MMWebView.zvD, "tools", new 5(this));
        com.tencent.mm.sdk.b.a.xef.b(new j(22, 32));
        com.tencent.mm.pluginsdk.model.x.a.bYv();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        Locale initLanguage = MMActivity.initLanguage(this.app.getBaseContext());
        x.d("MicroMsg.ToolsProfile", "onConfigurationChanged, locale = " + locale.toString() + ", n = " + initLanguage.toString());
        if (!initLanguage.equals(locale)) {
            x.w("MicroMsg.ToolsProfile", "language changed, restart process");
            System.exit(-1);
        }
    }

    public final String toString() {
        return ffc;
    }
}
