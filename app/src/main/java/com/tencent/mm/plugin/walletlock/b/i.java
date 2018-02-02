package com.tencent.mm.plugin.walletlock.b;

import android.app.Activity;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public enum i {
    ;
    
    private boolean tht;
    private boolean thu;
    private Object thv;
    public HashSet<WeakReference<Activity>> thw;

    private i(String str) {
        this.tht = false;
        this.thu = false;
        this.thv = new Object();
        this.thw = new HashSet();
    }

    public final void kb(boolean z) {
        synchronized (this.thv) {
            this.tht = z;
        }
    }

    public final boolean bOn() {
        boolean z;
        synchronized (this.thv) {
            z = this.tht;
        }
        return z;
    }

    public final void kc(boolean z) {
        synchronized (this.thv) {
            this.thu = z;
        }
    }

    public final boolean bOo() {
        boolean z;
        synchronized (this.thv) {
            z = this.thu;
        }
        return z;
    }

    public final void bOp() {
        synchronized (this.thv) {
            this.thu = true;
        }
    }

    public final void b(WeakReference<Activity> weakReference) {
        if (this.thw != null) {
            if (weakReference.get() != null) {
                x.v("MicroMsg.WalletLockStatusManager", "alvinluo addProtectActivity %s", new Object[]{((Activity) weakReference.get()).getClass().getName()});
            }
            this.thw.add(weakReference);
        }
    }

    public final void bOq() {
        Iterator it = this.thw.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) ((WeakReference) it.next()).get();
            if (!(activity == null || activity.isFinishing())) {
                x.v("MicroMsg.WalletLockStatusManager", "alvinluo finish %s", new Object[]{activity.getClass().getName()});
                activity.finish();
            }
            it.remove();
        }
    }
}
