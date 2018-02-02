package com.tencent.mm.plugin.zero.tasks;

import android.os.Process;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.x.a;
import com.tencent.wcdb.support.Log.LogCallback;
import java.util.HashSet;

class a$1 implements LogCallback {
    private final HashSet<String> vaT = new HashSet();
    final /* synthetic */ a vaU;

    a$1(a aVar) {
        this.vaU = aVar;
    }

    public final void println(int i, String str, String str2) {
        a cfj = x.cfj();
        int myPid = Process.myPid();
        int myTid = Process.myTid();
        switch (i) {
            case 2:
                cfj.logV(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                return;
            case 3:
                cfj.logD(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                return;
            case 4:
                cfj.logI(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                return;
            case 5:
                cfj.logW(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                if (str.equals("WCDB.SQLite") && str2.startsWith("[SQLite ErrCode: 284] automatic index on ")) {
                    boolean add;
                    String substring = str2.substring(41);
                    synchronized (this.vaT) {
                        add = this.vaT.add(substring);
                    }
                    if (!add) {
                        try {
                            d.pPH.c("DBAutoIndex", substring, null);
                            return;
                        } catch (Exception e) {
                            x.e("DBLogger", "Cannot report automatic index: " + e.getMessage());
                            return;
                        }
                    }
                    return;
                }
                return;
            case 6:
                cfj.logE(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                return;
            case 7:
                cfj.logF(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                return;
            default:
                return;
        }
    }
}
