package com.tencent.mm.modelvoice;

import com.tencent.mm.ae.h;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.b.a;
import com.tencent.mm.e.b.b;
import com.tencent.mm.sdk.platformtools.x;

public final class t implements a {
    private static int fmh = 100;
    String fileName = "";
    private b fmf;
    private h.a hXP = null;
    private int status = 0;

    public final int getStatus() {
        return this.status;
    }

    public final int vj() {
        b bVar = this.fmf;
        return ((bVar.fkc == com.tencent.mm.compatible.b.b.a.gBW || bVar.fkc == com.tencent.mm.compatible.b.b.a.gBY) && bVar.fkb != null) ? bVar.fkb.fkP : 1;
    }

    public final void a(h.a aVar) {
        this.hXP = aVar;
    }

    public t(com.tencent.mm.compatible.b.b.a aVar) {
        this.fmf = new b(aVar);
    }

    public final boolean cI(String str) {
        g.a aVar = new g.a();
        if (this.fileName.length() > 0) {
            x.e("VoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            return false;
        }
        this.fileName = str;
        try {
            this.fmf.a(new 1(this));
            this.fmf.vl();
            this.fmf.vm();
            this.fmf.vk();
            this.fmf.setOutputFile(this.fileName);
            this.fmf.setMaxDuration(70000);
            this.fmf.prepare();
            this.fmf.start();
            x.d("VoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + aVar.zi());
            this.status = 1;
            return true;
        } catch (Exception e) {
            x.e("VoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }

    public final boolean vi() {
        if (this.fmf == null) {
            return true;
        }
        try {
            this.fmf.vo();
            this.fmf.release();
            this.fileName = "";
            this.status = 0;
            return true;
        } catch (Exception e) {
            x.e("VoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }

    public final int getMaxAmplitude() {
        if (this.status != 1) {
            return 0;
        }
        int maxAmplitude = this.fmf.getMaxAmplitude();
        if (maxAmplitude > fmh) {
            fmh = maxAmplitude;
        }
        return (maxAmplitude * 100) / fmh;
    }
}
