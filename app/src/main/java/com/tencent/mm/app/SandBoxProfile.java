package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.u;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class SandBoxProfile extends e {
    public static final String ffc = (ac.getPackageName() + ":sandbox");

    public final void onCreate() {
        c aA = c.aA(ac.getContext());
        k.setupBrokenLibraryHandler();
        k.b(a.xdV, SandBoxProfile.class.getClassLoader());
        k.b("MMProtocalJni", SandBoxProfile.class.getClassLoader());
        k.b(a.xdX, SandBoxProfile.class.getClassLoader());
        MMProtocalJni.setClientPackVersion(d.vAz);
        u uVar = new u(aA);
        try {
            uVar.ee("SANDBOX");
            r.idi = bh.a(uVar.ef(".com.tencent.mm.debug.test.network.simulate_down_fault"), false);
            x.i("MicroMsg.SandboxDebugger", "Test.simulateDownFault = " + r.idi);
        } catch (Error e) {
        }
        m.tZ();
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final String toString() {
        return ffc;
    }
}
