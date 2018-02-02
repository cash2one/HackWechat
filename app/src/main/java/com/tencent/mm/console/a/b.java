package com.tencent.mm.console.a;

import android.content.Context;
import android.os.Looper;
import com.tencent.mm.g.a.fv;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements a {
    static {
        com.tencent.mm.pluginsdk.cmd.b.a(new b(), new String[]{"//fav"});
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
            case -1938535405:
                if (str.equals("resendfavitem")) {
                    break;
                }
            case -1648140403:
                if (str.equals("uploadfavitem")) {
                    z = true;
                    break;
                }
            default:
                z = true;
                break;
        }
        com.tencent.mm.sdk.b.b fvVar;
        switch (z) {
            case false:
                fvVar = new fv();
                fvVar.fvq.type = 39;
                fvVar.fvq.fvz = strArr[2];
                fvVar.fvq.fvA = strArr[3];
                com.tencent.mm.sdk.b.a.xef.a(fvVar, Looper.getMainLooper());
                break;
            case true:
                fvVar = new fv();
                fvVar.fvq.type = 38;
                fvVar.fvq.fvz = strArr[2];
                com.tencent.mm.sdk.b.a.xef.a(fvVar, Looper.getMainLooper());
                break;
        }
        return true;
    }
}
