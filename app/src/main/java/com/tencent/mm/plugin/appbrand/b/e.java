package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import java.lang.ref.WeakReference;

public abstract class e {
    final WeakReference<Activity> iHl;
    public final BroadcastReceiver iHp = new 1(this);

    public abstract void aax();

    public e(Activity activity) {
        this.iHl = new WeakReference(activity);
    }
}
