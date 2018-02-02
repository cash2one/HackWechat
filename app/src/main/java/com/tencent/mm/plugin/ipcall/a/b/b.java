package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.plugin.ipcall.a.b.c.2;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.z.ar;

public final class b implements a, d.a, HeadsetPlugReceiver.a {
    public MMActivity fmM;
    public com.tencent.mm.compatible.util.b hXN = new com.tencent.mm.compatible.util.b(ac.getContext());
    public a nEk = new a();
    public c nEl = new c();
    public d nEm = new d();
    public HeadsetPlugReceiver nEn = new HeadsetPlugReceiver();
    public j nEo;
    private boolean nEp = false;
    public a nEq;
    public boolean nEr = false;
    public boolean nEs = false;
    public long nEt = 0;

    public final void a(j jVar) {
        this.nEo = jVar;
        if (jVar != null) {
            i.aTC().aSZ();
        }
    }

    public final void aTQ() {
        c cVar = this.nEl;
        if (cVar.fAs) {
            x.d("MicroMsg.IPCallRecorder", "startRecorder, already start");
            return;
        }
        x.i("MicroMsg.IPCallRecorder", "start record");
        cVar.fAs = true;
        cVar.nEw = i.aTA().nEk.nEg;
        if (cVar.nEw <= 10) {
            if (cVar.nEw <= 0) {
                x.e("MicroMsg.IPCallRecorder", "playDelayInMs<=0");
                i.aTz().aTY();
            }
            cVar.nEw = 92;
        }
        synchronized (cVar.nEv) {
            e.post(new 2(cVar), "IPCallRecorder_startRecord");
        }
    }

    public final void fW(boolean z) {
        this.nEk.fW(z);
    }

    public final void fX(boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.IPCallDeviceManager", "onScreenDistanceChange, isClose: %b", new Object[]{Boolean.valueOf(z)});
        if (this.fmM != null) {
            MMActivity mMActivity = this.fmM;
            if (z) {
                z2 = false;
            }
            mMActivity.setScreenEnable(z2);
        }
        if (!i.aTB().aTs()) {
            return;
        }
        if (z) {
            this.nEp = a.xQ();
            this.nEk.fW(false);
            return;
        }
        this.nEk.fW(this.nEp);
    }

    public final void er(int i) {
        x.i("MicroMsg.IPCallDeviceManager", "onAudioStatChange, status: %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.nEr = true;
                if (this.nEq != null && !this.nEs) {
                    this.nEq.ga(true);
                    return;
                }
                return;
            case 2:
            case 4:
                this.nEr = false;
                if (this.nEq != null && !this.nEs) {
                    this.nEq.ga(false);
                    return;
                }
                return;
            case 3:
                ar.Hh().xI();
                if (ar.Hh().xL() && this.nEq != null) {
                    this.nEq.fZ(true);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void fY(boolean z) {
        x.i("MicroMsg.IPCallDeviceManager", "onHeadsetState, on: %b", new Object[]{Boolean.valueOf(z)});
        if (this.nEq != null && z != this.nEs) {
            this.nEs = z;
            if (!this.nEr) {
                this.nEq.fZ(z);
            }
        }
    }

    public final int aTR() {
        a aVar = this.nEk;
        return (aVar.nEe == null || !aVar.fAs) ? -1 : aVar.nEe.bGh();
    }
}
