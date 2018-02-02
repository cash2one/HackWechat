package com.tencent.d.b.c;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.d.a.c.c;
import com.tencent.d.b.f.f;
import com.tencent.d.b.f.g;
import junit.framework.Assert;

public final class a {
    public CancellationSignal AcF = null;

    static /* synthetic */ void cGc() {
        f cGi = f.cGi();
        synchronized (cGi.Adl) {
            c.i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
            if (f.Adk.size() != 0) {
                for (int i = 0; i < f.Adk.size(); i++) {
                    g.cGk().A(new f$3(cGi, f.Adk.keyAt(i)));
                }
            }
        }
    }

    public a() {
        Assert.assertTrue(VERSION.SDK_INT >= 16);
        cGb();
    }

    @SuppressLint({"NewApi"})
    public final boolean nV(boolean z) {
        c.v("Soter.SoterFingerprintCanceller", "soter: publishing cancellation. should publish: %b", new Object[]{Boolean.valueOf(z)});
        if (this.AcF.isCanceled()) {
            c.i("Soter.SoterFingerprintCanceller", "soter: cancellation signal already expired.", new Object[0]);
            return false;
        } else if (VERSION.SDK_INT < 23) {
            g.cGk().A(new 1(this, z));
            return true;
        } else {
            g.cGk().A(new 2(this));
            g.cGk().k(new 3(this), 350);
            return true;
        }
    }

    @SuppressLint({"NewApi"})
    public final void cGb() {
        this.AcF = new CancellationSignal();
    }
}
