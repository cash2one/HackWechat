package com.tencent.mm.sdk.f;

import android.os.Debug;
import com.tencent.mm.sdk.f.e.b;
import junit.framework.Assert;

final class g implements Comparable<g>, Runnable {
    private static final String hSf;
    private static int xkk = 1000;
    long hjb;
    final String mWn;
    final int priority;
    boolean started = false;
    final Runnable xfV;
    long xfY;
    long xga;
    final boolean xkl;
    b xkm;

    public final /* synthetic */ int compareTo(Object obj) {
        g gVar = (g) obj;
        int abs = (int) (Math.abs(System.currentTimeMillis() - this.xfY) / ((long) xkk));
        int i = this.priority;
        if (abs > 0) {
            i += abs;
        }
        return gVar.priority - i;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append("|priority = %d");
        stringBuilder.append("|pooled = %b");
        stringBuilder.append("|addTime = %d");
        stringBuilder.append("|usedTime = %d");
        stringBuilder.append("|cpuTime = %d");
        stringBuilder.append("|started = %b");
        hSf = stringBuilder.toString();
    }

    g(Runnable runnable, String str, int i, boolean z, b bVar) {
        Assert.assertNotNull("ThreadTask arg task is null!", runnable);
        Assert.assertNotNull("ThreadTask arg name is null!", str);
        this.xfV = runnable;
        this.mWn = str;
        this.priority = i;
        this.xkl = z;
        this.xfY = System.currentTimeMillis();
        this.xkm = bVar;
    }

    public final void run() {
        this.hjb = System.currentTimeMillis();
        this.xga = Debug.threadCpuTimeNanos();
        this.started = true;
        this.xfV.run();
        this.hjb = System.currentTimeMillis() - this.hjb;
        this.xga = Debug.threadCpuTimeNanos() - this.xga;
    }

    public final String toString() {
        return String.format(hSf, new Object[]{this.mWn, Integer.valueOf(this.priority), Boolean.valueOf(this.xkl), Long.valueOf(this.xfY), Long.valueOf(this.hjb), Long.valueOf(this.xga), Boolean.valueOf(this.started)});
    }
}
