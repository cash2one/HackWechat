package com.tencent.b.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.preference.PreferenceManager;

public class i {
    private static i bpt = null;
    static f bpu = null;
    public static volatile long bpv = 0;
    static h bpw = null;
    public static Context mContext = null;
    public static Handler mHandler = null;
    private g bpx = null;

    private i(Context context) {
        HandlerThread handlerThread = new HandlerThread(i.class.getSimpleName());
        handlerThread.start();
        mHandler = new Handler(handlerThread.getLooper());
        Context applicationContext = context.getApplicationContext();
        mContext = applicationContext;
        bpv = PreferenceManager.getDefaultSharedPreferences(applicationContext).getLong("__MID_LAST_CHECK_TIME__", 0);
    }

    public static i X(Context context) {
        if (bpt == null) {
            synchronized (i.class) {
                if (bpt == null) {
                    bpt = new i(context);
                }
            }
        }
        return bpt;
    }

    public static void a(f fVar) {
        bpu = fVar;
    }

    public final String sK() {
        if (this.bpx == null || !s.bK(this.bpx.bpr)) {
            int i;
            this.bpx = r.Z(mContext).sP();
            if (s.bK(this.bpx.bpr)) {
                i = 2;
            } else {
                i = 1;
            }
            if (mHandler != null) {
                mHandler.post(new n(mContext, i));
            }
            new StringBuilder("wx get mid:").append(this.bpx.bpr);
        }
        return this.bpx.bpr;
    }

    public final String sL() {
        if (this.bpx == null || !s.bK(this.bpx.bpr)) {
            this.bpx = r.Z(mContext).sP();
        }
        return this.bpx.bpr;
    }
}
