package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.ae.h;
import com.tencent.mm.ae.h.b;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.q;

public final class i implements h, a {
    private static int fmh = 100;
    private k fhJ = null;
    private String fileName = "";
    private int kAG = 0;
    private long myE = 0;
    private a rWA;
    private long rWB = 0;
    private int rWC = 0;
    private ak rWD = new ak(new 1(this), true);
    protected b rWx;
    protected h.a rWy = null;
    private boolean rWz = false;

    public final void er(int i) {
        x.d("MicroMsg.VoiceRemindRecorder", " Recorder onBluetoothHeadsetStateChange :" + i);
        if (!this.rWz) {
            this.rWz = true;
            ar.Hh().b(this);
            this.fhJ = new k();
            AnonymousClass2 anonymousClass2 = new h.a(this) {
                final /* synthetic */ i rWE;

                {
                    this.rWE = r1;
                }

                public final void onError() {
                    x.e("MicroMsg.VoiceRemindRecorder", "Record Failed file:" + this.rWE.fileName);
                    h.nY(this.rWE.fileName);
                    if (this.rWE.rWy != null) {
                        this.rWE.rWy.onError();
                    }
                }
            };
            this.rWA = new a(this);
            e.post(this.rWA, "VoiceRemindRecorder_record");
            this.rWC = 1;
            this.rWD.J(3000, 3000);
            x.d("MicroMsg.VoiceRemindRecorder", "start end time:" + bh.bA(this.rWB));
        }
    }

    public final int getMaxAmplitude() {
        if (this.fhJ == null) {
            return 0;
        }
        int maxAmplitude = this.fhJ.getMaxAmplitude();
        if (maxAmplitude > fmh) {
            fmh = maxAmplitude;
        }
        x.d("getMaxAmplitude", " map: " + maxAmplitude + " max:" + fmh + " per:" + ((maxAmplitude * 100) / fmh));
        return (maxAmplitude * 100) / fmh;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final boolean isRecording() {
        if (this.fhJ != null && this.fhJ.mStatus == 1) {
            return true;
        }
        return false;
    }

    public final boolean cJ(String str) {
        String ns = k.ns(q.FS());
        g gVar = new g();
        gVar.field_filename = ns;
        gVar.field_user = str;
        gVar.field_createtime = System.currentTimeMillis() / 1000;
        gVar.field_clientid = ns;
        gVar.field_lastmodifytime = System.currentTimeMillis() / 1000;
        gVar.field_status = 1;
        gVar.field_human = q.FS();
        gVar.fDt = -1;
        k bEb = d.bEb();
        x.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
        int insert = (int) bEb.gJP.insert("VoiceRemindInfo", "", gVar.vI());
        x.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result" + insert);
        if (insert == -1) {
            ns = null;
        }
        this.fileName = ns;
        ar.Hh().a(this);
        int xI = ar.Hh().xI();
        this.rWz = false;
        if (xI != 0) {
            er(100);
        } else {
            new 3(this).sendEmptyMessageDelayed(0, 50);
        }
        return false;
    }

    public final boolean cancel() {
        x.d("MicroMsg.VoiceRemindRecorder", "cancel Record :" + this.fileName);
        synchronized (this) {
            x.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
            if (this.fhJ != null) {
                this.fhJ.vi();
            }
        }
        String str = this.fileName;
        if (str != null) {
            x.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
            g Mk = h.Mk(str);
            if (Mk != null) {
                Mk.field_status = 8;
                Mk.field_totallen = c.nv(h.aJ(str, false));
                Mk.fDt = 64;
                h.a(Mk);
            }
        }
        d.bEc().run();
        this.fileName = "";
        return true;
    }

    public final boolean vo() {
        boolean z = true;
        boolean z2 = false;
        ar.Hh().xJ();
        x.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fileName);
        synchronized (this) {
            x.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
            if (this.fhJ != null) {
                this.fhJ.vi();
            }
        }
        if (this.rWC != 2) {
            h.nY(this.fileName);
            this.fileName = null;
            x.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by not onPart: " + bh.bA(this.rWB));
        } else {
            this.kAG = (int) vy();
            if (((long) this.kAG) < 800 || ((long) this.kAG) < 1000) {
                x.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by voiceLen: " + this.kAG);
                h.nY(this.fileName);
                this.fileName = "";
                z = false;
            } else {
                String str = this.fileName;
                int i = this.kAG;
                if (str != null) {
                    x.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
                    g Mk = h.Mk(str);
                    if (Mk != null) {
                        if (!(Mk.field_status == 97 || Mk.field_status == 98)) {
                            Mk.field_status = 3;
                        }
                        Mk.field_totallen = c.nv(h.aJ(str, false));
                        if (Mk.field_totallen <= 0) {
                            h.ny(str);
                        } else {
                            Mk.field_lastmodifytime = System.currentTimeMillis() / 1000;
                            Mk.field_voicelenght = i;
                            Mk.fDt = 3424;
                            au auVar = new au();
                            auVar.dS(Mk.field_user);
                            auVar.setType(34);
                            auVar.eR(1);
                            auVar.dT(str);
                            if (Mk.field_status == 97) {
                                auVar.eQ(2);
                                auVar.setContent(f.b(Mk.field_human, (long) Mk.field_voicelenght, false));
                            } else if (Mk.field_status == 98) {
                                auVar.eQ(5);
                                auVar.setContent(f.b(Mk.field_human, -1, true));
                            } else {
                                auVar.eQ(1);
                            }
                            auVar.aq(ba.hR(Mk.field_user));
                            Mk.field_msglocalid = (int) ba.i(auVar);
                            h.a(Mk);
                        }
                    }
                }
                d.bEc().run();
                x.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fileName);
            }
            this.fileName = "";
            z2 = z;
        }
        this.rWC = -1;
        return z2;
    }

    public final long vy() {
        if (this.myE <= 0) {
            return 0;
        }
        return bh.bA(this.myE);
    }

    public final void reset() {
        if (this.fhJ != null) {
            this.fhJ.vi();
            x.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
        }
        this.fileName = "";
        this.rWB = 0;
        this.rWA = null;
        this.rWC = 0;
        this.myE = 0;
    }

    public final int vx() {
        return this.kAG;
    }

    public final void a(h.a aVar) {
        this.rWy = aVar;
    }

    public final void a(b bVar) {
        this.rWx = bVar;
    }

    public final int vA() {
        return 0;
    }
}
