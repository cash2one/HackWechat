package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.x;

public final class e implements a {
    static {
        b.a(new e(), new String[]{"//recovery"});
    }

    public static void init() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Context context, String[] strArr) {
        boolean z = false;
        if (x.getLogLevel() > 1) {
            return false;
        }
        if (strArr.length < 2) {
            return true;
        }
        String str = strArr[1];
        switch (str.hashCode()) {
            case -1421107579:
                if (str.equals("testmmonline")) {
                    z = true;
                    break;
                }
            case -1145939284:
                if (str.equals("testpush")) {
                    break;
                }
            case -877169230:
                if (str.equals("testmm")) {
                    z = true;
                    break;
                }
            case 107332:
                if (str.equals("log")) {
                    z = true;
                    break;
                }
            default:
                z = true;
                break;
        }
        com.tencent.mm.sdk.b.b mvVar;
        switch (z) {
            case false:
                WatchDogPushReceiver.Ti();
                break;
            case true:
                mvVar = new mv();
                mvVar.fET.action = 1;
                com.tencent.mm.sdk.b.a.xef.m(mvVar);
                break;
            case true:
                mvVar = new mv();
                mvVar.fET.action = 3;
                com.tencent.mm.sdk.b.a.xef.m(mvVar);
                break;
            case true:
                mvVar = new mv();
                mvVar.fET.action = 2;
                com.tencent.mm.sdk.b.a.xef.m(mvVar);
                break;
        }
        return true;
    }
}
