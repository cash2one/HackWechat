package com.tencent.mm.plugin.fps_lighter.b;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

class a implements ActivityLifecycleCallbacks {
    private boolean lzK;
    private Activity mAy;
    private Runnable mAz;
    private boolean mIsPaused;
    ArrayList<a> mListeners = new ArrayList();
    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    a() {
    }

    public void b(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public void c(Application application) {
        application.unregisterActivityLifecycleCallbacks(this);
        this.mListeners.clear();
    }

    public void onActivityResumed(Activity activity) {
        this.mIsPaused = false;
        x.i("MicroMsg.BaseFrameBeatCore", "[onActivityResumed] foreground:%s", new Object[]{Boolean.valueOf(this.lzK)});
        boolean z = !this.lzK;
        this.lzK = true;
        if (activity != this.mAy) {
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                try {
                    ((a) it.next()).t(activity);
                } catch (Exception e) {
                    x.e("MicroMsg.BaseFrameBeatCore", "Listener threw exception!", new Object[]{e});
                }
            }
            this.mAy = activity;
        }
        Handler handler = this.mMainHandler;
        Runnable 1 = new 1(this, z, activity);
        this.mAz = 1;
        handler.postDelayed(1, 600);
    }

    public void onActivityPaused(Activity activity) {
        x.i("MicroMsg.BaseFrameBeatCore", "[onActivityPaused] foreground:%s", new Object[]{Boolean.valueOf(this.lzK)});
        this.mIsPaused = true;
        if (this.mAz != null) {
            this.mMainHandler.removeCallbacks(this.mAz);
        }
        Handler handler = this.mMainHandler;
        Runnable 2 = new 2(this, activity);
        this.mAz = 2;
        handler.postDelayed(2, 600);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        x.i("MicroMsg.BaseFrameBeatCore", "Activity:%s", new Object[]{activity.getClass().getSimpleName()});
        this.mAy = activity;
        Iterator it = this.mListeners.iterator();
        while (it.hasNext()) {
            try {
                ((a) it.next()).s(activity);
            } catch (Exception e) {
                x.e("MicroMsg.BaseFrameBeatCore", "Listener threw exception!", new Object[]{e});
            }
        }
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }
}
