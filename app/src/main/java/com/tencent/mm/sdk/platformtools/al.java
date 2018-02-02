package com.tencent.mm.sdk.platformtools;

import android.os.Debug;
import android.os.Handler;
import android.os.Process;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class al implements Runnable {
    private static final String xge;
    private static final String xgf;
    long endTime;
    final Handler handler;
    long hjb;
    long mBy;
    final String mWn;
    int priority;
    boolean started = false;
    final Thread thread;
    final Runnable xfV;
    final Object xfW;
    final a xfX;
    long xfY;
    long xfZ;
    String xfy;
    long xga;
    long xgb;
    long xgc;
    float xgd = -1.0f;

    public interface a {
        void a(Runnable runnable, al alVar);

        void a(Runnable runnable, Thread thread, long j, long j2, float f);
    }

    al(Thread thread, Handler handler, Runnable runnable, Object obj, a aVar) {
        this.thread = thread;
        if (thread != null) {
            this.xfy = thread.getName();
            this.mBy = thread.getId();
            this.priority = thread.getPriority();
        }
        this.handler = handler;
        this.xfV = runnable;
        String name = runnable.getClass().getName();
        String obj2 = runnable.toString();
        if (!bh.ov(obj2)) {
            int indexOf = obj2.indexOf(124);
            if (indexOf > 0) {
                name = name + "_" + obj2.substring(indexOf + 1);
            }
        }
        this.mWn = name;
        this.xfW = obj;
        this.xfX = aVar;
        this.xfY = System.currentTimeMillis();
    }

    public final void run() {
        new StringBuilder("/proc/self/task/").append(Process.myTid()).append("/stat");
        this.hjb = System.currentTimeMillis();
        this.xga = Debug.threadCpuTimeNanos();
        this.xgb = -1;
        this.xgc = -1;
        this.started = true;
        this.xfV.run();
        this.xgb = -1 - this.xgb;
        this.xgc = -1 - this.xgc;
        this.endTime = System.currentTimeMillis();
        this.hjb = this.endTime - this.hjb;
        this.xga = (Debug.threadCpuTimeNanos() - this.xga) / 1000000;
        if (this.xgc != 0) {
            this.xgd = ((float) (100 * this.xgb)) / ((float) this.xgc);
        }
        if (this.xfX != null) {
            this.xfX.a(this.xfV, this);
            this.xfX.a(this, this.thread, this.hjb, this.xga, this.xgd);
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append("|token = %s");
        stringBuilder.append("|handler = %s");
        stringBuilder.append("|threadName = %s");
        stringBuilder.append("|threadId = %d");
        stringBuilder.append("|priority = %d");
        stringBuilder.append("|addTime = %d");
        stringBuilder.append("|delayTime = %d");
        stringBuilder.append("|usedTime = %d");
        stringBuilder.append("|cpuTime = %d");
        stringBuilder.append("|started = %b");
        xge = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("taskName = %s");
        stringBuilder.append(" | addTime = %s");
        stringBuilder.append(" | endTime = %s");
        stringBuilder.append(" | usedTime = %d");
        stringBuilder.append(" | cpuTime = %d");
        stringBuilder.append(" | threadCpuTime = %d");
        stringBuilder.append(" | totalCpuTime = %d");
        stringBuilder.append(" | threadCpuRate = %.1f");
        xgf = stringBuilder.toString();
    }

    public final String dump(boolean z) {
        if (z) {
            return String.format(xge, new Object[]{this.mWn, this.xfW, this.handler, this.xfy, Long.valueOf(this.mBy), Integer.valueOf(this.priority), Long.valueOf(this.xfY), Long.valueOf(this.xfZ), Long.valueOf(this.hjb), Long.valueOf(this.xga), Boolean.valueOf(this.started)});
        }
        return String.format(xgf, new Object[]{this.mWn, new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.xfY)), new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.endTime)), Long.valueOf(this.hjb), Long.valueOf(this.xga), Long.valueOf(this.xgb), Long.valueOf(this.xgc), Float.valueOf(this.xgd)});
    }
}
