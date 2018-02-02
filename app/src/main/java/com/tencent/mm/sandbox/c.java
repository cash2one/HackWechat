package com.tencent.mm.sandbox;

import android.os.Process;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static c xbP = null;
    private static Map<Integer, Boolean> xbQ = new HashMap();

    public static void h(int i, Object obj) {
        x.i("MicroMsg.SandBoxCore", "regLifeCycle, id=" + i + ", class=%s", new Object[]{obj.getClass().getName()});
        xbQ.put(Integer.valueOf(i), Boolean.valueOf(true));
        x.i("MicroMsg.SandBoxCore", "regLifeCycle, map size=" + xbQ.size());
    }

    public static void i(int i, Object obj) {
        x.i("MicroMsg.SandBoxCore", "unregLifeCycle, id=" + i + ", class=%s", new Object[]{obj.getClass().getName()});
        xbQ.remove(Integer.valueOf(i));
        x.i("MicroMsg.SandBoxCore", "unregLifeCycle, map size=" + xbQ.size());
        if (xbQ.size() == 0) {
            Process.killProcess(Process.myPid());
            x.w("MicroMsg.SandBoxCore", "Sandbox exit Now.");
            x.cfl();
        }
    }
}
