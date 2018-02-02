package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class b implements a, HeadsetPlugReceiver.a {
    boolean fAs = false;
    com.tencent.mm.compatible.util.b hXN = new com.tencent.mm.compatible.util.b(ac.getContext());
    com.tencent.mm.plugin.voip.model.b nEe = null;
    final Object nEf = new Object();
    HeadsetPlugReceiver nEn = new HeadsetPlugReceiver();
    boolean nEr = false;
    boolean nEs = false;
    private int oFO;

    public final void fW(boolean z) {
        x.i("MicroMsg.MT.MultiTalkAudioPlayer", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", new Object[]{Boolean.valueOf(z)});
        ar.Hh().bb(z);
        if (this.nEe != null && this.nEe.siI) {
            this.nEe.jd(z);
        }
    }

    public final void fY(boolean z) {
        boolean z2 = false;
        if (this.nEs != z) {
            this.nEs = z;
            x.i("MicroMsg.MT.MultiTalkAudioPlayer", "onHeadsetState: isHeadsetPlugged" + z);
            boolean z3 = o.bcV().nDg.aip() ? !this.nEs : false;
            if (!this.nEr) {
                z2 = z3;
            }
            fW(z2);
            o.bcV().gS(z2);
        }
    }

    public final void er(int i) {
        x.i("MicroMsg.MT.MultiTalkAudioPlayer", "onBluetoothHeadsetStateChange, status: %d", new Object[]{Integer.valueOf(i)});
        boolean bbU;
        switch (i) {
            case 1:
                if (i != this.oFO) {
                    this.nEr = true;
                    fW(false);
                    o.bcV().gS(false);
                    break;
                }
                break;
            case 2:
                if (i != this.oFO) {
                    this.nEr = false;
                    bbU = bbU();
                    fW(bbU);
                    o.bcV().gS(bbU);
                    break;
                }
                break;
            case 3:
                this.nEr = true;
                ar.Hh().xI();
                break;
            case 4:
                if (i != this.oFO) {
                    this.nEr = false;
                    ar.Hh().xJ();
                    bbU = bbU();
                    fW(bbU);
                    o.bcV().gS(bbU);
                    break;
                }
                break;
        }
        this.oFO = i;
    }

    private boolean bbU() {
        return o.bcV().nDg.aip() && !this.nEs;
    }
}
