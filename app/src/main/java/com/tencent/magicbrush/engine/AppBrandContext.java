package com.tencent.magicbrush.engine;

import android.os.Handler;
import android.support.annotation.Keep;
import com.tencent.magicbrush.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class AppBrandContext extends b {
    private Timer bnp = new Timer();
    private int bnq = 0;
    private HashMap<Integer, a> bnr = new HashMap();
    private long bns = nativeCreated(this.bnB);
    private boolean bnt = false;
    private ArrayList<Integer> bnu = new ArrayList();
    private Handler mHandler = new Handler();

    public static native void notifyClearTimer(long j, int i);

    public static native boolean notifyRunTimer(long j, long j2, int i);

    public native long nativeCreated(long j);

    public native void nativeFinalize(long j);

    @Keep
    public int setTimer(int i, boolean z) {
        int i2 = this.bnq + 1;
        this.bnq = i2;
        TimerTask aVar = new a(this, i2, z);
        this.bnr.put(Integer.valueOf(i2), aVar);
        if (z) {
            this.bnp.schedule(aVar, (long) i, (long) i);
        } else {
            this.bnp.schedule(aVar, (long) i);
        }
        return i2;
    }

    @Keep
    public void clearTimer(int i) {
        if (this.bnr.containsKey(Integer.valueOf(i))) {
            ((a) this.bnr.get(Integer.valueOf(i))).cancel();
            this.bnr.remove(Integer.valueOf(i));
        }
    }

    @Keep
    public void onLog(int i, String str) {
        String[] strArr = new String[]{"debug", "log", "info", "warn", "error"};
    }

    public final void dispose() {
        nativeFinalize(this.bns);
    }

    static {
        b.loadLibrary("mmv8");
        b.loadLibrary("magicbrush");
    }
}
