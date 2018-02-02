package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.protocal.MMProtocalJni;
import java.text.SimpleDateFormat;
import java.util.Date;
import junit.framework.Assert;

public final class h implements a {
    static {
        b.a(new h(), new String[]{"//assert", "//netassert", "//jniassert", "//jnipushassert", "//pushassert"});
    }

    public static void init() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(Context context, String[] strArr) {
        int i;
        String str = strArr[0];
        boolean z;
        switch (str.hashCode()) {
            case -2061874877:
                if (str.equals("//netassert")) {
                    z = true;
                    break;
                }
            case -1869906331:
                if (str.equals("//jnipushassert")) {
                    i = 3;
                    break;
                }
            case -1794206389:
                if (str.equals("//jniassert")) {
                    i = 2;
                    break;
                }
            case 918688960:
                if (str.equals("//pushassert")) {
                    i = 4;
                    break;
                }
            case 1957466406:
                if (str.equals("//assert")) {
                    z = false;
                    break;
                }
            default:
                i = -1;
                break;
        }
        switch (i) {
            case 0:
                Assert.assertTrue("test errlog " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), false);
                return true;
            case 1:
                Assert.assertTrue("NetsceneQueue forbid in ", false);
                return true;
            case 2:
                MMProtocalJni.setClientPackVersion(-1);
                return true;
            case 3:
                WatchDogPushReceiver.iF(2);
                return true;
            case 4:
                WatchDogPushReceiver.iF(1);
                return true;
            default:
                return false;
        }
    }
}
