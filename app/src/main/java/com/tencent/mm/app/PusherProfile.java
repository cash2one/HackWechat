package com.tencent.mm.app;

import android.content.Context;
import android.content.res.Configuration;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.o;
import com.tencent.mm.booter.q;
import com.tencent.mm.booter.t;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.console.Shell;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.v;

public final class PusherProfile extends e {
    public static final String ffc = (ac.getPackageName() + ":push");
    private Shell ffG = new Shell();

    public final void onCreate() {
        Context context = ac.getContext();
        AppLogic.setCallBack(new AppCallBack(ac.getContext()));
        k.b(a.xdU, PusherProfile.class.getClassLoader());
        SdtLogic.setHttpNetcheckCGI("/mmnetcheck");
        q tVar = new t(c.aA(context));
        tVar.ee("PUSH");
        r.icH = bh.a(tVar.ef(".com.tencent.mm.debug.test.display_errcode"), false);
        r.icI = bh.a(tVar.ef(".com.tencent.mm.debug.test.display_msgstate"), false);
        r.icJ = bh.a(tVar.ef(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        r.icK = bh.a(tVar.ef(".com.tencent.mm.debug.test.network.force_touch"), false);
        r.icL = bh.a(tVar.ef(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        r.icM = bh.a(tVar.ef(".com.tencent.mm.debug.test.crashIsExit"), false);
        r.icQ = bh.a(tVar.ef(".com.tencent.mm.debug.test.album_show_info"), false);
        r.icR = bh.a(tVar.ef(".com.tencent.mm.debug.test.location_help"), false);
        r.icU = bh.a(tVar.ef(".com.tencent.mm.debug.test.force_soso"), false);
        r.icV = bh.a(tVar.ef(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        r.icW = bh.a(tVar.ef(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        r.icX = bh.a(tVar.ef(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        r.ida = bh.a(tVar.ef(".com.tencent.mm.debug.test.filterfpnp"), false);
        r.idb = bh.a(tVar.ef(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bh.a(tVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        r.icY = a;
        if (a != 4 && r.icY > 0) {
            v.xmG = r.icY;
            x.e("MicroMsg.PushDebugger", "cdn thread num " + r.icY);
        }
        r.icZ = bh.a(tVar.ef(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        r.ide = bh.a(tVar.ef(".com.tencent.mm.debug.test.skip_getdns"), false);
        try {
            a = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.CE(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            x.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            String string = tVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bh.ov(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.vAu = "android-" + string;
                d.vAw = string;
                b.UI(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.ceL());
            }
        } catch (Exception e2) {
            x.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.vAy).append(" new: ").append(a);
            d.vAy = (long) a;
        } catch (Exception e3) {
            x.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            tVar.gyS.gyb = Integer.decode(tVar.getString(".com.tencent.mm.debug.log.setchannel")).intValue();
        } catch (Exception e4) {
            x.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        try {
            boolean a2 = bh.a(tVar.ef(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = bh.a(tVar.ef(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = bh.a(tVar.ef(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = bh.a(tVar.ef(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e5) {
            x.i("MicroMsg.PushDebugger", "no debugger was got");
        }
        a.cl(ffc);
        o.onCreate(false);
        com.tencent.mm.bm.d.a("gcm", null, null);
        com.tencent.mm.bm.d.Td("gcm");
        com.tencent.mm.sdk.b.a.xef.b(new 1(this));
        bh.initLanguage(ac.getContext());
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return ffc;
    }
}
