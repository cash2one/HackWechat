package com.tencent.mm.e.b;

import com.tencent.mm.compatible.b.b.a;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class j {
    public static int fmh = 100;
    String fileName = "";
    private b fme = new b(ac.getContext());
    public b fmf = new b(a.gBX);
    public a fmg = null;
    public int status = 0;

    public final boolean cK(String str) {
        g.a aVar = new g.a();
        if (this.fileName.length() > 0) {
            x.e("MicroMsg.SimpleVoiceRecorder", "Duplicate Call startRecord , maybe Stop Fail Before");
            return false;
        }
        this.fileName = str;
        try {
            this.fme.requestFocus();
            this.fmf.a(new 1(this));
            this.fmf.vl();
            this.fmf.vm();
            this.fmf.vk();
            this.fmf.setOutputFile(this.fileName);
            this.fmf.setMaxDuration(3600010);
            this.fmf.prepare();
            this.fmf.start();
            x.d("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] start time:" + aVar.zi());
            this.status = 1;
            return true;
        } catch (Exception e) {
            this.fme.zd();
            x.e("MicroMsg.SimpleVoiceRecorder", "StartRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }

    public final boolean vi() {
        this.fme.zd();
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
            x.e("MicroMsg.SimpleVoiceRecorder", "StopRecord File[" + this.fileName + "] ErrMsg[" + e.getMessage() + "]");
            this.status = -1;
            return false;
        }
    }
}
