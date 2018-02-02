package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.s;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.f.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class PatchProfile extends e {
    public static final String ffc = (ac.getPackageName() + ":patch");

    public final void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        s sVar = new s(c.aA(this.app.getBaseContext()));
        sVar.ee("PATCH");
        try {
            int intValue = Integer.decode(sVar.getString(".com.tencent.mm.debug.log.setversion")).intValue();
            d.CE(intValue);
            new StringBuilder("set up test protocal version = ").append(Integer.toHexString(intValue));
        } catch (Exception e) {
            x.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            String string = sVar.getString(".com.tencent.mm.debug.log.setapilevel");
            if (!bh.ov(string)) {
                d.DEVICE_TYPE = "android-" + string;
                d.vAu = "android-" + string;
                d.vAw = string;
                b.UI(string);
                new StringBuilder("set up test protocal apilevel = ").append(d.DEVICE_TYPE).append(" ").append(b.ceL());
            }
        } catch (Exception e2) {
            x.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            intValue = Integer.decode(sVar.getString(".com.tencent.mm.debug.log.setuin")).intValue();
            new StringBuilder("set up test protocal uin old: ").append(d.vAy).append(" new: ").append(intValue);
            d.vAy = (long) intValue;
        } catch (Exception e3) {
            x.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        try {
            boolean a = bh.a(sVar.ef(".com.tencent.mm.debug.report.debugmodel"), false);
            boolean a2 = bh.a(sVar.ef(".com.tencent.mm.debug.report.kvstat"), false);
            boolean a3 = bh.a(sVar.ef(".com.tencent.mm.debug.report.clientpref"), false);
            boolean a4 = bh.a(sVar.ef(".com.tencent.mm.debug.report.useraction"), false);
            com.tencent.mm.plugin.report.a.c.a(a, a2, a3, a4);
            new StringBuilder("try control report : debugModel[").append(a).append("],kv[").append(a2).append("], clientPref[").append(a3).append("], useraction[").append(a4).append("]");
        } catch (Exception e4) {
            x.i("MicroMsg.PatchDebugger", "no debugger was got");
        }
        a.ay(ac.getContext());
        i.cq(ffc);
        k.setupBrokenLibraryHandler();
        k.b(com.tencent.mm.sdk.a.xdV, PatchProfile.class.getClassLoader());
        m.tZ();
        x.i("MicroMsg.PatchProfile", "patchsprofile try to init hotpatch plugin");
        com.tencent.mm.bm.d.a("hp", null, null);
        com.tencent.mm.bm.d.Td("hp");
        x.i("MicroMsg.PatchProfile", "start time check patchsprofile use time = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return ffc;
    }
}
