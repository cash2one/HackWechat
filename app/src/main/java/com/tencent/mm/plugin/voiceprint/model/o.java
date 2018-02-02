package com.tencent.mm.plugin.voiceprint.model;

import android.os.Looper;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    public k shd;
    public ak she;
    int shf;
    int shg;

    public o() {
        this.shd = null;
        this.she = null;
        this.shf = 0;
        this.shg = 0;
        this.shd = new k();
        this.she = new ak(Looper.getMainLooper(), new 1(this), true);
    }

    public final void reset() {
        this.shd.vi();
        x.d("MicroMsg.VoicePrintNoiseDetector", "stop record");
        this.she.TG();
        this.shf = 0;
        this.shg = 0;
    }
}
