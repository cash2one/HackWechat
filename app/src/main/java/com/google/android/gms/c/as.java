package com.google.android.gms.c;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.stats.h;

public final class as {
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private final String aPA;
    public final WakeLock aZf;
    private WorkSource aZg;
    private final int aZh;
    private final String aZi;
    private boolean aZj;
    private int aZk;
    private int aZl;
    private final Context mContext;

    private as(Context context, int i, String str) {
        this.aZj = true;
        w.h(str, "Wake lock name can NOT be empty");
        this.aZh = 1;
        this.aPA = str;
        this.aZi = null;
        this.mContext = context.getApplicationContext();
        this.aZf = ((PowerManager) context.getSystemService("power")).newWakeLock(1, str);
        if (ac.R(this.mContext)) {
            String str2;
            if (!ab.aZ(null)) {
                str2 = null;
            } else if (f.aNs && j.isInitialized()) {
                new StringBuilder("callingPackage is not supposed to be empty for wakelock ").append(this.aPA).append("!");
                str2 = "com.google.android.gms";
            } else {
                str2 = context.getPackageName();
            }
            this.aZg = ac.h(context, str2);
            WorkSource workSource = this.aZg;
            if (ac.R(this.mContext) && workSource != null) {
                if (this.aZg != null) {
                    this.aZg.add(workSource);
                } else {
                    this.aZg = workSource;
                }
                this.aZf.setWorkSource(this.aZg);
            }
        }
    }

    public as(Context context, String str) {
        this(context, 1, str);
    }

    private boolean ba(String str) {
        Object obj = null;
        return (TextUtils.isEmpty(obj) || obj.equals(this.aZi)) ? false : true;
    }

    private String i(String str, boolean z) {
        return this.aZj ? z ? null : this.aZi : this.aZi;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void pT() {
        if (!z.ds(14) && this.aZj) {
            Log.wtf(TAG, "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: " + this.aPA);
        }
        boolean ba = ba(null);
        String i = i(null, ba);
        if (DEBUG) {
            new StringBuilder("Acquire:\n mWakeLockName: ").append(this.aPA).append("\n mSecondaryName: ").append(this.aZi).append("\nmReferenceCounted: ").append(this.aZj).append("\nreason: ").append(null).append("\nmOpenEventCount").append(this.aZl).append("\nuseWithReason: ").append(ba).append("\ntrackingName: ").append(i);
        }
        synchronized (this) {
            if (this.aZj) {
                int i2 = this.aZk;
                this.aZk = i2 + 1;
                if (i2 != 0) {
                }
                h.pj();
                h.a(this.mContext, com.google.android.gms.common.stats.f.a(this.aZf, i), 7, this.aPA, i, this.aZh, ac.b(this.aZg));
                this.aZl++;
            }
            if (!this.aZj) {
            }
        }
        this.aZf.acquire(1000);
    }

    public final void pU() {
        this.aZf.setReferenceCounted(false);
        this.aZj = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void release() {
        boolean ba = ba(null);
        String i = i(null, ba);
        if (DEBUG) {
            new StringBuilder("Release:\n mWakeLockName: ").append(this.aPA).append("\n mSecondaryName: ").append(this.aZi).append("\nmReferenceCounted: ").append(this.aZj).append("\nreason: ").append(null).append("\n mOpenEventCount").append(this.aZl).append("\nuseWithReason: ").append(ba).append("\ntrackingName: ").append(i);
        }
        synchronized (this) {
            if (this.aZj) {
                int i2 = this.aZk - 1;
                this.aZk = i2;
                if (i2 != 0) {
                }
                h.pj();
                h.a(this.mContext, com.google.android.gms.common.stats.f.a(this.aZf, i), 8, this.aPA, i, this.aZh, ac.b(this.aZg));
                this.aZl--;
            }
            if (!this.aZj) {
            }
        }
        this.aZf.release();
    }
}
