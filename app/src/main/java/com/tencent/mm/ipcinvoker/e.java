package com.tencent.mm.ipcinvoker;

import android.content.Context;
import android.os.Process;
import com.tencent.mm.loader.stub.d;
import junit.framework.Assert;

public final class e {
    public static Context gMy;
    private static String gMz;

    public static Context getContext() {
        Assert.assertNotNull("IPCInvoker not initialize.", gMy);
        return gMy;
    }

    public static boolean fh(String str) {
        return str != null && str.equals(Bu());
    }

    public static String Bu() {
        if (gMz == null || gMz.length() == 0) {
            gMz = d.r(gMy, Process.myPid());
        }
        return gMz;
    }
}
