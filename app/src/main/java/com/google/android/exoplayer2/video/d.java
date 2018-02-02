package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.WindowManager;

@TargetApi(16)
public final class d {
    final a aDK;
    final boolean aDL;
    final long aDM;
    final long aDN;
    long aDO;
    long aDP;
    long aDQ;
    boolean aDR;
    long aDS;
    long aDT;
    long aDU;

    public d() {
        this(-1.0d);
    }

    public d(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this(windowManager.getDefaultDisplay() != null ? (double) windowManager.getDefaultDisplay().getRefreshRate() : -1.0d);
    }

    private d(double d) {
        this.aDL = d != -1.0d;
        if (this.aDL) {
            this.aDK = a.lZ();
            this.aDM = (long) (1.0E9d / d);
            this.aDN = (this.aDM * 80) / 100;
            return;
        }
        this.aDK = null;
        this.aDM = -1;
        this.aDN = -1;
    }

    final boolean e(long j, long j2) {
        return Math.abs((j2 - this.aDS) - (j - this.aDT)) > 20000000;
    }
}
