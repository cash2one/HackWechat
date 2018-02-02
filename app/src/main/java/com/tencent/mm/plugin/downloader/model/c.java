package com.tencent.mm.plugin.downloader.model;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Vector;

public final class c {
    private static Vector<o> lrM = new Vector();
    private static o lrN;

    c() {
    }

    public static void a(o oVar) {
        if (oVar != null && !lrM.contains(oVar)) {
            lrM.add(oVar);
        }
    }

    public static void b(o oVar) {
        if (oVar != null) {
            lrM.remove(oVar);
        }
    }

    public static void c(o oVar) {
        lrN = oVar;
    }

    public static void aAa() {
        lrN = null;
    }

    public final void i(long j, String str) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskStarted: %d, %s", Long.valueOf(j), str);
        ag.y(new 1(this, j, str));
    }

    public final void j(long j, String str) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskResumed: %d, %s", Long.valueOf(j), str);
        ag.y(new 2(this, j, str));
    }

    public final void cb(final long j) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskRemoved: %d", Long.valueOf(j));
        ag.y(new Runnable(this) {
            final /* synthetic */ c lrO;

            public final void run() {
                for (o onTaskRemoved : ((o[]) c.lrM.toArray(new o[c.lrM.size()]))) {
                    onTaskRemoved.onTaskRemoved(j);
                }
                if (c.lrN != null) {
                    c.lrN.onTaskRemoved(j);
                }
            }
        });
    }

    public final void b(long j, String str, boolean z) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFinished: %d", Long.valueOf(j));
        final long j2 = j;
        final String str2 = str;
        final boolean z2 = z;
        ag.y(new Runnable(this) {
            final /* synthetic */ c lrO;

            public final void run() {
                for (o c : ((o[]) c.lrM.toArray(new o[c.lrM.size()]))) {
                    c.c(j2, str2, z2);
                }
                if (c.lrN != null) {
                    c.lrN.c(j2, str2, z2);
                }
            }
        });
    }

    public final void b(long j, int i, boolean z) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskFailed: %d, errCode : %d", Long.valueOf(j), Integer.valueOf(i));
        final long j2 = j;
        final int i2 = i;
        final boolean z2 = z;
        ag.y(new Runnable(this) {
            final /* synthetic */ c lrO;

            public final void run() {
                for (o c : ((o[]) c.lrM.toArray(new o[c.lrM.size()]))) {
                    c.c(j2, i2, z2);
                }
                if (c.lrN != null) {
                    c.lrN.c(j2, i2, z2);
                }
            }
        });
    }

    public final void cc(long j) {
        x.i("MicroMsg.FileDownloaderCallbackManager", "notifyTaskPaused: %d", Long.valueOf(j));
        ag.y(new 6(this, j));
    }

    public final void cd(long j) {
        ag.y(new 7(this, j));
    }
}
