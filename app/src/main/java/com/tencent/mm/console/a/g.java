package com.tencent.mm.console.a;

import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.tencent.mm.g.a.fe;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;
import java.util.Calendar;

public final class g implements a {
    static {
        b.a(new g(), "//sport");
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        if (x.getLogLevel() > 1) {
            return false;
        }
        if (strArr.length < 2) {
            return true;
        }
        String str = strArr[1];
        Object obj = -1;
        switch (str.hashCode()) {
            case -734972924:
                if (str.equals("setdevicestep")) {
                    obj = null;
                    break;
                }
                break;
            case 94746189:
                if (str.equals("clear")) {
                    obj = 1;
                    break;
                }
                break;
            case 1761741959:
                if (str.equals("setextapistep")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                int intValue = Integer.valueOf(strArr[2]).intValue();
                ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sport.b.b.class)).I(202, bh.cgt() / 10000);
                ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sport.b.b.class)).I(201, (long) intValue);
                Calendar instance = Calendar.getInstance();
                instance.set(11, 0);
                instance.set(12, 0);
                instance.set(13, 0);
                ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sport.b.b.class)).a("", "gh_43f2581f6fd6", (int) (instance.getTimeInMillis() / 1000), (int) (System.currentTimeMillis() / 1000), intValue, be.cjW());
                break;
            case 1:
                ((com.tencent.mm.plugin.sport.b.b) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.sport.b.b.class)).bDe();
                Process.killProcess(Process.myPid());
                break;
            case 2:
                com.tencent.mm.sdk.b.b feVar = new fe();
                feVar.fui.action = 2;
                feVar.fui.ful = (long) Integer.valueOf(strArr[2]).intValue();
                feVar.fui.fum = 1;
                com.tencent.mm.sdk.b.a.xef.a(feVar, Looper.getMainLooper());
                break;
        }
        return true;
    }
}
