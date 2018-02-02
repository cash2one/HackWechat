package com.tencent.mm.plugin.fps_lighter.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Debug;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.ViewTreeObserver.OnDrawListener;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.plugin.fps_lighter.b.a.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

@TargetApi(16)
public final class f extends a implements FrameCallback, OnDrawListener, a {
    private boolean ioB;
    private Choreographer jGh = null;
    private boolean mAU = false;
    private long[] mAV = new long[9];
    private long mAW = 0;
    private c<ki> mAX;
    private long mAY = 0;
    long mAZ = 0;
    private c mAl;
    long mBa = 0;
    private long mBb = 0;
    private ArrayList<com.tencent.mm.plugin.fps_lighter.a.c> mListeners = new ArrayList();

    public final /* bridge */ /* synthetic */ void onActivityCreated(Activity activity, Bundle bundle) {
        super.onActivityCreated(activity, bundle);
    }

    public final /* bridge */ /* synthetic */ void onActivityDestroyed(Activity activity) {
        super.onActivityDestroyed(activity);
    }

    public final /* bridge */ /* synthetic */ void onActivityPaused(Activity activity) {
        super.onActivityPaused(activity);
    }

    public final /* bridge */ /* synthetic */ void onActivityResumed(Activity activity) {
        super.onActivityResumed(activity);
    }

    public final /* bridge */ /* synthetic */ void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        super.onActivitySaveInstanceState(activity, bundle);
    }

    public final /* bridge */ /* synthetic */ void onActivityStarted(Activity activity) {
        super.onActivityStarted(activity);
    }

    public final /* bridge */ /* synthetic */ void onActivityStopped(Activity activity) {
        super.onActivityStopped(activity);
    }

    f(c cVar) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            throw new IllegalThreadStateException("not in main thread");
        }
        this.mAl = cVar;
        this.jGh = Choreographer.getInstance();
    }

    public final void b(Application application) {
        super.b(application);
        x.i("MicroMsg.FrameBeatCore", "[setUp]");
        if (!this.mListeners.contains(this)) {
            this.mListeners.add(this);
        }
        if (this.mAX == null) {
            this.mAX = new 1(this);
        }
        this.mAX.ceO();
    }

    public final void c(Application application) {
        super.c(application);
        x.i("MicroMsg.FrameBeatCore", "[setOff]");
        this.mListeners.remove(this);
        if (this.mAX != null) {
            this.mAX.dead();
            this.mAX = null;
        }
        this.mListeners.clear();
        this.mAl.mAK = false;
        this.jGh.removeFrameCallback(this);
    }

    public final void q(Activity activity) {
        boolean z;
        Iterator it;
        x.i("MicroMsg.FrameBeatCore", "[onBecameForeground]:%s", new Object[]{activity.getClass().getSimpleName()});
        c cVar = this.mAl;
        if (cVar.mAP != 0) {
            if (cVar.mAP == 100) {
                cVar.mAK = true;
            } else if (1 == new Random().nextInt(100 / cVar.mAP)) {
                cVar.mAK = true;
            }
            if (cVar.mAK) {
                x.i("MicroMsg.FPSConfig", "you are so lucky! rand:%s", new Object[]{Integer.valueOf(cVar.mAP)});
            }
            z = cVar.mAK;
            if (this.mAl.mAK) {
                it = this.mListeners.iterator();
                while (it.hasNext()) {
                    ((com.tencent.mm.plugin.fps_lighter.a.c) it.next()).D(Integer.MAX_VALUE, true);
                }
                this.jGh.removeFrameCallback(this);
                this.jGh.postFrameCallback(this);
            }
        }
        cVar.mAK = false;
        if (cVar.mAK) {
            x.i("MicroMsg.FPSConfig", "you are so lucky! rand:%s", new Object[]{Integer.valueOf(cVar.mAP)});
        }
        z = cVar.mAK;
        if (this.mAl.mAK) {
            it = this.mListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.plugin.fps_lighter.a.c) it.next()).D(Integer.MAX_VALUE, true);
            }
            this.jGh.removeFrameCallback(this);
            this.jGh.postFrameCallback(this);
        }
    }

    public final void r(Activity activity) {
        x.i("MicroMsg.FrameBeatCore", "[onBecameBackground]:%s", new Object[]{activity.getClass().getSimpleName()});
        this.mAl.mAK = false;
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.plugin.fps_lighter.a.c) it.next()).D(Integer.MAX_VALUE, false);
        }
    }

    public final void s(Activity activity) {
        x.i("MicroMsg.FrameBeatCore", "[onBegin]:%s", new Object[]{activity.getClass().getSimpleName()});
        this.mAl.u(activity);
        this.mAU = true;
    }

    public final void t(Activity activity) {
        x.i("MicroMsg.FrameBeatCore", "[onChangeActivity] now Activity:%s", new Object[]{activity.getClass().getSimpleName()});
        this.mAl.u(activity);
        activity.getWindow().getDecorView().post(new 2(this, activity));
    }

    public final void doFrame(long j) {
        Object obj;
        long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
        Object obj2 = 1;
        if (!this.mAl.mAK) {
            x.e("MicroMsg.FrameBeatCore", "[doFrame] unEnable!");
            obj2 = null;
        }
        if (this.mListeners.size() <= 0) {
            x.e("MicroMsg.FrameBeatCore", "has not any listener!");
            obj = null;
        } else {
            obj = obj2;
        }
        if (obj == null) {
            this.mAW = 0;
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.plugin.fps_lighter.a.c) it.next()).D(Integer.MAX_VALUE, false);
            }
            Choreographer.getInstance().removeFrameCallback(this);
        }
        if (obj != null) {
            int intValue;
            long threadCpuTimeNanos2;
            long nanoTime;
            long j2;
            long j3;
            Iterator it2;
            c cVar = this.mAl;
            String str = this.mAl.mAO;
            if (bh.ov(str)) {
                x.i("MicroMsg.FPSConfig", "null == activityName");
            } else {
                Integer num;
                if (c.mAM.containsKey(str)) {
                    num = (Integer) c.mAM.get(str);
                    intValue = num != null ? num.intValue() : -1;
                } else if (c.mAM.containsKey(cVar.mAN) && cVar.mAO.equalsIgnoreCase("LauncherUI")) {
                    num = (Integer) c.mAM.get(cVar.mAN);
                    intValue = num != null ? num.intValue() : -1;
                }
                threadCpuTimeNanos2 = Debug.threadCpuTimeNanos();
                nanoTime = System.nanoTime();
                if (this.mBa != 0 || this.mAZ == 0) {
                    j2 = 0;
                } else {
                    j2 = (long) Math.round(((((float) (threadCpuTimeNanos2 - this.mBa)) * 1.0f) / ((float) (nanoTime - this.mAZ))) * 100.0f);
                }
                this.mBa = threadCpuTimeNanos2;
                this.mAZ = nanoTime;
                j3 = j - this.mAW;
                if (0 == this.mAW && intValue != -1 && this.ioB) {
                    int b = com.tencent.mm.plugin.fps_lighter.e.a.b(j3, this.mAl.mAF);
                    Iterator it3 = this.mListeners.iterator();
                    while (it3.hasNext()) {
                        ((com.tencent.mm.plugin.fps_lighter.a.c) it3.next()).a(intValue, this.mAW / 1000000, j / 1000000, b, (int) j2, this.mAU, this.mAY / 1000000, this.ioB);
                    }
                } else {
                    it2 = this.mListeners.iterator();
                    while (it2.hasNext()) {
                        ((com.tencent.mm.plugin.fps_lighter.a.c) it2.next()).D(-1, false);
                    }
                }
                this.mAU = false;
                this.ioB = false;
                this.mAW = j;
                this.jGh.postFrameCallback(this);
                this.mAY = Debug.threadCpuTimeNanos() - threadCpuTimeNanos;
            }
            intValue = -1;
            threadCpuTimeNanos2 = Debug.threadCpuTimeNanos();
            nanoTime = System.nanoTime();
            if (this.mBa != 0) {
            }
            j2 = 0;
            this.mBa = threadCpuTimeNanos2;
            this.mAZ = nanoTime;
            j3 = j - this.mAW;
            if (0 == this.mAW) {
            }
            it2 = this.mListeners.iterator();
            while (it2.hasNext()) {
                ((com.tencent.mm.plugin.fps_lighter.a.c) it2.next()).D(-1, false);
            }
            this.mAU = false;
            this.ioB = false;
            this.mAW = j;
            this.jGh.postFrameCallback(this);
            this.mAY = Debug.threadCpuTimeNanos() - threadCpuTimeNanos;
        }
    }

    public final void a(com.tencent.mm.plugin.fps_lighter.a.c cVar) {
        if (!this.mListeners.contains(cVar)) {
            this.mListeners.add(cVar);
        }
    }

    public final void onDraw() {
        this.ioB = true;
    }
}
