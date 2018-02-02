package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public final class b {
    static /* synthetic */ void a(Process process, BufferedReader bufferedReader) {
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.MMTraceRoute", th, "close reader failed", new Object[0]);
            }
        }
        if (process != null) {
            try {
                process.destroy();
            } catch (Throwable th2) {
                x.printErrStackTrace("MicroMsg.MMTraceRoute", th2, "destroy process failed", new Object[0]);
            }
        }
    }

    public static String Mv(String str) {
        x.i("MicroMsg.MMTraceRoute", "output string: " + str);
        if (str == null || str.length() == 0) {
            return null;
        }
        int indexOf = str.indexOf("time=");
        if (indexOf < 0) {
            return null;
        }
        indexOf += 5;
        int indexOf2 = str.indexOf(" ", indexOf);
        if (indexOf2 >= 0) {
            return str.substring(indexOf, indexOf2);
        }
        return null;
    }

    public static int Mw(String str) {
        int indexOf = str.indexOf("ttl=");
        if (indexOf < 0) {
            return -1;
        }
        indexOf += 4;
        int indexOf2 = str.indexOf(" ", indexOf);
        if (indexOf2 >= 0) {
            return bh.getInt(str.substring(indexOf, indexOf2), 0);
        }
        return -1;
    }

    public static List<Object> A(String[] strArr) {
        String str = " ";
        for (int i = 0; i < 4; i++) {
            str = str + strArr[i] + " ";
        }
        x.i("MicroMsg.MMTraceRoute", str);
        List<Object> arrayList = new ArrayList();
        Runnable aVar = new a(strArr, arrayList);
        e.a(aVar, "MMTraceRouteCMDExecutor_watcher");
        try {
            e.U(aVar);
            x.i("MicroMsg.MMTraceRoute", "watcher thread stopped" + str);
        } catch (InterruptedException e) {
            e.Q(aVar);
            x.i("MicroMsg.MMTraceRoute", "interrupt thread" + str);
        }
        return arrayList;
    }
}
