package com.tencent.mm.plugin.ipcall.a.b;

import com.tencent.mm.plugin.appbrand.jsapi.a.e;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.model.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class a {
    public boolean fAs = false;
    public b nEe = null;
    public final Object nEf = new Object();
    public int nEg = 0;
    public boolean nEh = false;

    public final void fW(boolean z) {
        x.i("MicroMsg.IPCallAudioPlayer", "setSpeakerPhoneOn, old isSpeakerPhoneOn: %b, new isSpeakerPhoneOn: %b", new Object[]{Boolean.valueOf(this.nEh), Boolean.valueOf(z)});
        ar.Hh().bb(z);
        com.tencent.mm.plugin.ipcall.a.c.a aTy = i.aTy();
        if ((z ? aTy.nEG.td(401) : aTy.nEG.td(e.CTRL_INDEX)) < 0) {
            x.e("MicroMsg.IPCallEngineManager", "setSpeakerPhoneOn, failed, ret: %d", new Object[]{Integer.valueOf(z ? aTy.nEG.td(401) : aTy.nEG.td(e.CTRL_INDEX))});
        }
        if (z != this.nEh) {
            this.nEh = z;
            if (this.nEe != null && this.nEe.siI) {
                this.nEe.jd(z);
            }
        }
    }

    public static boolean xQ() {
        return ar.Hh().gCe.isSpeakerphoneOn();
    }
}
