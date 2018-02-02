package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.e.b.c;
import com.tencent.mm.e.b.c.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

public final class g {
    public static int skM = 0;
    public static int skN = 0;
    public static int skz = 3;
    private a nEA = new 1(this);
    c oFS = null;
    public e siL = null;
    public int skA = 1;
    int skB = 92;
    private long skC = 0;
    private long skD = 0;
    private int skE = 1;
    private int skF = 0;
    private int skG = 1;
    private long skH = 0;
    private int skI = 0;
    private int skJ = 0;
    final Object skK = new Object();
    public int skL = 0;
    b skO;
    b sky = null;

    class b implements Runnable {
        final /* synthetic */ g skP;
        boolean skQ = false;

        b(g gVar) {
            this.skP = gVar;
        }

        public final void run() {
            while (this.skP.skA == 2 && !this.skQ) {
                if (this.skP.siL.bGw() && this.skP.siL.ske.videoDecode(this.skP.siL.ske.soW) == 1) {
                    int i = this.skP.siL.ske.field_remoteImgWidth;
                    int i2 = this.skP.siL.ske.field_remoteImgHeight;
                    int i3 = this.skP.siL.ske.field_remoteImgLength;
                    if (i3 > 0 && this.skP.siL.skf != null) {
                        v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.skP.siL.ske;
                        com_tencent_mm_plugin_voip_model_v2protocal.spt++;
                        this.skP.siL.skf.a(i, i2, i3 / 4, this.skP.siL.ske.soW);
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Voip.VoipDeviceHandler", e, "", new Object[0]);
                }
            }
        }
    }

    static /* synthetic */ void k(g gVar) {
        gVar.oFS = new c(v2protocal.oFK, 1, 1);
        gVar.oFS.et(20);
        gVar.oFS.aP(true);
        gVar.oFS.vq();
        gVar.oFS.fkz = -19;
        gVar.oFS.n(1, false);
        gVar.oFS.aO(true);
        gVar.oFS.fkK = gVar.nEA;
        if (!(gVar.oFS.vr() || gVar.oFS.fkp == 13)) {
            gVar.skL = 1;
        }
        com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip.VoipDeviceHandler", "  VoipDeivceHandler.m_iAudioDevErr:" + gVar.skL);
        gVar.siL.yu(gVar.skL);
        gVar.siL.ske.spH.slb = (byte) 1;
    }

    public g(e eVar) {
        this.siL = eVar;
    }

    public final int bGD() {
        if (this.oFS == null || this.siL.ske.spH.slb != (byte) 1) {
            return 0;
        }
        return this.oFS.fkp;
    }

    public final int bGg() {
        if (this.sky == null || this.siL.ske.spH.slb != (byte) 1) {
            return 0;
        }
        return this.sky.bGg();
    }

    public final synchronized void bGE() {
        int i = 0;
        synchronized (this) {
            x.i("MicroMsg.Voip.VoipDeviceHandler", "stopDev, recorder: %s", new Object[]{this.oFS});
            if (this.skA == skz) {
                com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipDeviceHandler", "devcie stoped already.");
                synchronized (this.skK) {
                    if (this.oFS != null) {
                        x.e("MicroMsg.Voip.VoipDeviceHandler", "status DEV_STOP, but recorder still not null!!");
                        this.oFS.vi();
                        this.oFS = null;
                    }
                }
            } else {
                com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipDeviceHandler", "stop device..");
                this.skA = skz;
                if (this.skO != null) {
                    com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
                    this.skO.skQ = true;
                    e.remove(this.skO);
                    this.skO = null;
                }
                this.skG = 1;
                this.skI = 0;
                this.skB = 92;
                this.skC = 0;
                this.skD = 0;
                this.skE = 1;
                this.skF = 0;
                this.skL = 0;
                this.siL.ske.sor = bGD();
                this.siL.ske.sos = bGg();
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.siL.ske;
                int vt = (this.oFS == null || this.siL.ske.spH.slb != (byte) 1) ? -2 : this.oFS.vt();
                com_tencent_mm_plugin_voip_model_v2protocal.sov = vt;
                v2protocal com_tencent_mm_plugin_voip_model_v2protocal2 = this.siL.ske;
                if (this.sky != null && this.siL.ske.spH.slb == (byte) 1) {
                    i = this.sky.bGh();
                }
                com_tencent_mm_plugin_voip_model_v2protocal2.soC = (int) ((((float) ar.Hh().getStreamVolume(i)) / ((float) ar.Hh().getStreamMaxVolume(i))) * 100.0f);
                synchronized (this.skK) {
                    if (!(this.sky == null || this.oFS == null)) {
                        e.b(new a(this, this.sky, this.oFS), "VoipDeviceHandler_stopDev", 10);
                        x.i("MicroMsg.Voip.VoipDeviceHandler", "do stop record");
                        this.sky = null;
                        this.oFS = null;
                    }
                }
            }
        }
    }
}
