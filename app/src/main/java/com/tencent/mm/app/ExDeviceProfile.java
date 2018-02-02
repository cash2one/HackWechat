package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.r;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.f.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.v;

public class ExDeviceProfile extends e {
    public static final String ffc = (ac.getPackageName() + ":exdevice");

    public final void onCreate() {
        x.i("MicroMsg.ExDeviceProfile", "exdevice profile oncreate");
        c aA = c.aA(this.app.getBaseContext());
        a.ay(ac.getContext());
        i.cq(ffc);
        k.setupBrokenLibraryHandler();
        r rVar = new r(aA);
        rVar.ee("EXDEVICE");
        com.tencent.mm.platformtools.r.icH = bh.a(rVar.ef(".com.tencent.mm.debug.test.display_errcode"), false);
        com.tencent.mm.platformtools.r.icI = bh.a(rVar.ef(".com.tencent.mm.debug.test.display_msgstate"), false);
        com.tencent.mm.platformtools.r.icJ = bh.a(rVar.ef(".com.tencent.mm.debug.test.network.simulate_fault"), false);
        com.tencent.mm.platformtools.r.icK = bh.a(rVar.ef(".com.tencent.mm.debug.test.network.force_touch"), false);
        com.tencent.mm.platformtools.r.icL = bh.a(rVar.ef(".com.tencent.mm.debug.test.outputToSdCardlog"), false);
        com.tencent.mm.platformtools.r.icM = bh.a(rVar.ef(".com.tencent.mm.debug.test.crashIsExit"), false);
        com.tencent.mm.platformtools.r.icQ = bh.a(rVar.ef(".com.tencent.mm.debug.test.album_show_info"), false);
        com.tencent.mm.platformtools.r.icR = bh.a(rVar.ef(".com.tencent.mm.debug.test.location_help"), false);
        com.tencent.mm.platformtools.r.icU = bh.a(rVar.ef(".com.tencent.mm.debug.test.force_soso"), false);
        com.tencent.mm.platformtools.r.icV = bh.a(rVar.ef(".com.tencent.mm.debug.test.simulatePostServerError"), false);
        com.tencent.mm.platformtools.r.icW = bh.a(rVar.ef(".com.tencent.mm.debug.test.simulateUploadServerError"), false);
        com.tencent.mm.platformtools.r.icX = bh.a(rVar.ef(".com.tencent.mm.debug.test.snsNotwirteThumb"), false);
        com.tencent.mm.platformtools.r.ida = bh.a(rVar.ef(".com.tencent.mm.debug.test.filterfpnp"), false);
        com.tencent.mm.platformtools.r.idb = bh.a(rVar.ef(".com.tencent.mm.debug.test.testForPull"), false);
        int a = bh.a(rVar.getInteger(".com.tencent.mm.debug.test.cdnDownloadThread"), 0);
        com.tencent.mm.platformtools.r.icY = a;
        if (a != 4 && com.tencent.mm.platformtools.r.icY > 0) {
            v.xmG = com.tencent.mm.platformtools.r.icY;
            x.e("MicroMsg.ExdDebugger", "cdn thread num " + com.tencent.mm.platformtools.r.icY);
        }
        com.tencent.mm.platformtools.r.icZ = bh.a(rVar.ef(".com.tencent.mm.debug.test.logShowSnsItemXml"), false);
        try {
            a = Integer.decode(rVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.CE(a);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(a));
        } catch (Exception e) {
            x.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            String string = rVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bh.ov(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.vAu = "android-" + string;
                d.vAw = string;
                b.UI(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.ceL());
            }
        } catch (Exception e2) {
            x.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            a = Integer.decode(rVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.vAy).append(" new: ").append(a);
            d.vAy = (long) a;
        } catch (Exception e3) {
            x.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        try {
            boolean a2 = bh.a(rVar.ef(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a3 = bh.a(rVar.ef(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a4 = bh.a(rVar.ef(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a5 = bh.a(rVar.ef(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a2, a3, a4, a5);
            new StringBuilder("try control report : debugModel[").append(a2).append("],kv[").append(a3).append("], clientPref[").append(a4).append("], useraction[").append(a5).append("]");
        } catch (Exception e4) {
            x.i("MicroMsg.ExdDebugger", "no debugger was got");
        }
        com.tencent.mm.platformtools.r.ido = bh.az(rVar.getString(".com.tencent.mm.debug.jsapi.permission"), "");
        x.d("MicroMsg.ExdDebugger", "Test.jsapiPermission = " + com.tencent.mm.platformtools.r.ido);
        com.tencent.mm.platformtools.r.idp = bh.az(rVar.getString(".com.tencent.mm.debug.generalcontrol.permission"), "");
        x.d("MicroMsg.ExdDebugger", "Test.generalCtrl = " + com.tencent.mm.platformtools.r.idp);
        com.tencent.mm.platformtools.r.idq = bh.a(rVar.ef(".com.tencent.mm.debug.skiploadurlcheck"), false);
        x.d("MicroMsg.ExdDebugger", "Test.skipLoadUrlCheck = " + com.tencent.mm.platformtools.r.idq);
        m.tZ();
    }

    public final void onConfigurationChanged(Configuration configuration) {
        x.d("MicroMsg.ExDeviceProfile", "onConfigurationChanged:" + toString());
    }

    public String toString() {
        return ffc;
    }
}
