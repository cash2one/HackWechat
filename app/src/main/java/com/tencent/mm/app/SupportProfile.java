package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.v;
import com.tencent.mm.compatible.d.m;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.f.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class SupportProfile extends e {
    protected static String feA = "";

    public final void onCreate() {
        feA = ac.Br();
        ClassLoader classLoader = SupportProfile.class.getClassLoader();
        a.ay(ac.getContext());
        i.a(new 1(this));
        q vVar = new v(c.aA(this.app.getBaseContext()));
        vVar.ee("SUPPORT");
        r.icH = bh.a(vVar.ef(".com.tencent.mm.debug.test.display_errcode"), false);
        r.icI = bh.a(vVar.ef(".com.tencent.mm.debug.test.display_msgstate"), false);
        r.icJ = bh.a(vVar.ef(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        r.icK = bh.a(vVar.ef(".com.tencent.mm.debug.test.network.force_touch"), false);
        r.icL = bh.a(vVar.ef(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        r.icM = bh.a(vVar.ef(".com.tencent.mm.debug.test.crashIsExit"), false);
        r.icQ = bh.a(vVar.ef(".com.tencent.mm.debug.test.album_show_info"), false);
        r.icR = bh.a(vVar.ef(".com.tencent.mm.debug.test.location_help"), false);
        r.icU = bh.a(vVar.ef(".com.tencent.mm.debug.test.force_soso"), false);
        r.icV = bh.a(vVar.ef(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        r.icW = bh.a(vVar.ef(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        r.icX = bh.a(vVar.ef(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        r.ida = bh.a(vVar.ef(".com.tencent.mm.debug.test.filterfpnp"), false);
        r.idb = bh.a(vVar.ef(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bh.a(vVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        r.icY = a;
        if (a != 4 && r.icY > 0) {
            com.tencent.mm.storage.v.xmG = r.icY;
            x.e("SetupSupportDebugger", "cdn thread num " + r.icY);
        }
        r.icZ = bh.a(vVar.ef(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        r.idr = bh.a(vVar.ef(".com.tencent.mm.debug.forcex5webview"), false);
        r.ido = bh.az(vVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        x.d("SetupSupportDebugger", "Test.jsapiPermission = " + r.ido);
        try {
            a = Integer.decode(vVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.CE(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            x.i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            String string = vVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bh.ov(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.vAu = "android-" + string;
                d.vAw = string;
                b.UI(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.ceL());
            }
        } catch (Exception e2) {
            x.i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(vVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.vAy).append(" new: ").append(a);
            d.vAy = (long) a;
        } catch (Exception e3) {
            x.i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            vVar.gyS.gyb = Integer.decode(vVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            x.i("SetupSupportDebugger", "no debugger was got");
        }
        try {
            boolean a2 = bh.a(vVar.ef(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = bh.a(vVar.ef(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = bh.a(vVar.ef(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = bh.a(vVar.ef(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e5) {
            x.i("SetupSupportDebugger", "no debugger was got");
        }
        i.cq(feA);
        a.cl(feA);
        k.b("wcdb", classLoader);
        k.b("wechatcommon", classLoader);
        k.b(com.tencent.mm.sdk.a.xdX, classLoader);
        k.b("FFmpeg", classLoader);
        k.b("wechatpack", classLoader);
        int yp = m.yp();
        if ((yp & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            x.i("MicroMsg.SupportProfile", "load wechatsight_v7a, core number: %d", new Object[]{Integer.valueOf(yp >> 12)});
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
            x.i("MicroMsg.SupportProfile", "load wechatsight");
            k.b("wechatsight", classLoader);
            com.tencent.mm.plugin.sight.base.b.qsU = 1;
            com.tencent.mm.plugin.sight.base.b.qsW = 1;
            com.tencent.mm.plugin.sight.base.b.qsX = 640000;
        }
        a.ay(ac.getContext());
        m.tZ();
        MMActivity.initLanguage(this.app.getBaseContext());
        FileOp.init(false);
        MMBitmapFactory.init();
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onTrimMemory(int i) {
        super.onTrimMemory(i);
        x.v("MicroMsg.SupportProfile", "onTrimMemory(l : %d)", new Object[]{Integer.valueOf(i)});
    }
}
