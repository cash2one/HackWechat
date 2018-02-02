package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class p implements com.tencent.mm.compatible.b.f.a {
    public static int fmh = 100;
    public k fhJ = null;
    public String fileName = "";
    public b hXN;
    private int kAG = 0;
    public long myE = 0;
    public int rWC = 0;
    public boolean rWz = false;
    public b shi;
    public String shj;
    public boolean shk = false;
    public a shl = null;

    public interface a {
        void bFI();
    }

    public final void er(int i) {
        x.d("MicroMsg.VoicePrintRecoder", " Recorder onBluetoothHeadsetStateChange :" + i);
        if (!this.rWz) {
            this.rWz = true;
            ar.Hh().b(this);
            this.fhJ = new k();
            this.shi = new b(this);
            this.shi.start();
            this.shk = false;
            this.rWC = 1;
        }
    }

    public final boolean vo() {
        long j = 0;
        ar.Hh().xJ();
        this.shk = false;
        x.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fileName);
        synchronized (this) {
            x.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fileName);
            if (this.fhJ != null) {
                this.fhJ.vi();
            }
        }
        if (this.rWC != 2) {
            this.fileName = null;
            this.shk = false;
            x.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName);
        } else {
            if (this.myE > 0) {
                j = bh.bA(this.myE);
            }
            this.kAG = (int) j;
            if (this.kAG < 1000) {
                x.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName + " by voiceLen: " + this.kAG);
                this.fileName = "";
                this.shk = false;
            } else {
                this.shk = true;
                x.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fileName);
            }
            this.fileName = "";
        }
        this.rWC = -1;
        x.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.shk);
        if (this.hXN != null) {
            this.hXN.zd();
        }
        return this.shk;
    }
}
