package com.tencent.mm.compatible.loader;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class f$1 extends bc<String> {
    final /* synthetic */ f gGX;

    public f$1(f fVar) {
        this.gGX = fVar;
        super(2000, null);
    }

    protected final /* synthetic */ Object run() {
        return yX();
    }

    private static String yX() {
        while (true) {
            String r = bh.r(ac.getContext(), Process.myPid());
            if (r != null) {
                return r;
            }
            try {
                Thread.sleep(100);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.ProfileFactoryImpl", e, "", new Object[0]);
            }
        }
    }
}
