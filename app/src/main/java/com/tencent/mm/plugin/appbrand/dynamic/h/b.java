package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.wx_extension.b.b.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static final ak iUD = new ak(new 1(), true);

    public static void adf() {
        if (e.fh("com.tencent.mm:support")) {
            if (a.BF().size() != 0) {
                x.i("MicroMsg.DynamicProcessPerformance", "try to exit process, but has many tasks(%d) running. Abort it.", new Object[]{Integer.valueOf(a.BF().size())});
                return;
            }
            x.i("MicroMsg.DynamicProcessPerformance", "post delayed(60s) to kill the support process.");
            iUD.J(60000, 60000);
            return;
        }
        x.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
    }

    public static void adg() {
        if (e.fh("com.tencent.mm:support")) {
            x.i("MicroMsg.DynamicProcessPerformance", "kill support process");
            iUD.postDelayed(new 2(), 500);
            return;
        }
        x.i("MicroMsg.DynamicProcessPerformance", "try to kill process failed, current process is not the support process.");
    }

    public static void adh() {
        x.i("MicroMsg.DynamicProcessPerformance", "killAllProcess");
        if (g.fk("com.tencent.mm:tools")) {
            f.a("com.tencent.mm:tools", null, c.class, new 3());
        }
        if (g.fk("com.tencent.mm:support")) {
            f.a("com.tencent.mm:support", null, c.class, new 4());
        }
    }
}
