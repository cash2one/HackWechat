package com.tencent.mm.plugin.soter_mp.a;

import android.app.Activity;
import com.tencent.mm.plugin.soter_mp.b.d;
import com.tencent.mm.plugin.soter_mp.b.e;
import com.tencent.mm.plugin.soter_mp.ui.SoterAuthenticationUI;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import java.lang.ref.WeakReference;

public abstract class c {
    protected d rTj = null;
    protected e rTk = null;
    protected WeakReference<Activity> rTl = null;

    public abstract void cR();

    public abstract void onPause();

    public abstract void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public abstract void onResume();

    public c(WeakReference<Activity> weakReference, d dVar, e eVar) {
        this.rTj = dVar;
        this.rTk = eVar;
        this.rTl = weakReference;
    }

    protected static void bCX() {
        if (SoterAuthenticationUI.rTq != null) {
            SoterAuthenticationUI.rTq.obtainMessage(5).sendToTarget();
        } else {
            x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }

    protected final void bCY() {
        if (SoterAuthenticationUI.rTq != null) {
            bCX();
            SoterAuthenticationUI.rTq.obtainMessage(0, this.rTk).sendToTarget();
            return;
        }
        x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    protected final void bCZ() {
        if (SoterAuthenticationUI.rTq != null) {
            bCX();
            SoterAuthenticationUI.rTq.obtainMessage(1, this.rTk).sendToTarget();
            return;
        }
        x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    protected final void bDa() {
        if (SoterAuthenticationUI.rTq != null) {
            bCX();
            SoterAuthenticationUI.rTq.obtainMessage(2, this.rTk).sendToTarget();
            return;
        }
        x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    protected static void a(i iVar) {
        if (iVar == null) {
            x.e("MicroMsg.SoterMpBaseController", "hy: dialog is null.");
        } else if (SoterAuthenticationUI.rTq != null) {
            bCX();
            SoterAuthenticationUI.rTq.obtainMessage(6, iVar).sendToTarget();
        } else {
            x.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }
}
