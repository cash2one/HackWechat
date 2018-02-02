package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import java.lang.ref.WeakReference;

public abstract class d {
    private final WeakReference<Activity> iHl;
    public final BroadcastReceiver tP = new 1(this);

    public abstract void aaw();

    public d(Activity activity) {
        this.iHl = new WeakReference(activity);
    }
}
