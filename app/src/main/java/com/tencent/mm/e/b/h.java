package com.tencent.mm.e.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.mm.compatible.b.b;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.t;
import com.tencent.mm.modelvoice.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

public class h implements com.tencent.mm.ae.h, a {
    long flA = 0;
    public int flB = 0;
    boolean flC = false;
    boolean flD = false;
    int flE = 0;
    private b.a flF = b.a.gCa;
    protected com.tencent.mm.ae.h.b flG;
    protected com.tencent.mm.ae.h.a flH = null;
    private boolean flI = false;
    private ak flJ = new ak(new 1(this), true);
    a flt = null;
    com.tencent.mm.compatible.util.b flu;
    private a flv = null;
    private String flw;
    private boolean flx = false;
    private boolean fly = false;
    long flz;
    String mFileName = "";

    public h(Context context, boolean z) {
        this.flu = new com.tencent.mm.compatible.util.b(context);
        this.flD = z;
        x.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", Boolean.valueOf(z));
    }

    public final void reset() {
        if (this.flt != null) {
            this.flt.vi();
            this.flu.zd();
            x.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
        }
        this.mFileName = "";
        this.flz = 0;
        this.flv = null;
        this.flF = b.a.gCa;
        this.flE = 0;
        this.flA = 0;
    }

    public final int vx() {
        return this.flB;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public final boolean isRecording() {
        if (this.flt != null && this.flt.getStatus() == 1) {
            return true;
        }
        return false;
    }

    public final int getMaxAmplitude() {
        if (this.flt == null) {
            return 0;
        }
        return this.flt.getMaxAmplitude();
    }

    public final boolean cJ(String str) {
        x.i("MicroMsg.SceneVoice.Recorder", "Start Record to  " + str);
        reset();
        this.flw = str;
        this.flz = bh.Wq();
        if (str == null) {
            x.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
            return false;
        }
        this.flx = str.equals("_USER_FOR_THROWBOTTLE_");
        if (str.equals("medianote")) {
            if ((q.FW() & 16384) == 0) {
                this.fly = true;
            } else {
                this.fly = false;
            }
        }
        if (!this.flD) {
            if (this.flx) {
                this.mFileName = u.oe(q.FS());
            } else if (this.fly) {
                this.mFileName = u.oe("medianote");
            }
            if (this.mFileName != null || this.mFileName.length() <= 0) {
                x.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", this.mFileName);
                return false;
            }
            f.xG().a((a) this);
            this.flC = false;
            this.flI = false;
            if (!f.xO() || f.xG().xL()) {
                vz();
            } else {
                this.flI = true;
                f.xG().xI();
                ag.h(new 2(this), 1000);
            }
            return true;
        }
        this.mFileName = com.tencent.mm.modelvoice.q.nV(str);
        if (this.mFileName != null) {
        }
        x.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", this.mFileName);
        return false;
    }

    public final boolean cancel() {
        x.d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
        synchronized (this) {
            x.d("MicroMsg.SceneVoice.Recorder", "stop synchronized Record :" + this.mFileName);
            if (this.flt != null) {
                this.flt.vi();
                this.flu.zd();
            }
        }
        f.xG().b((a) this);
        if (this.flI) {
            f.xG().xJ();
            this.flI = false;
        }
        com.tencent.mm.modelvoice.q.nW(this.mFileName);
        m.UF().run();
        if (!(this.flt == null || bh.ov(this.mFileName) || this.flD)) {
            com.tencent.mm.compatible.g.a aVar = new com.tencent.mm.compatible.g.a();
            aVar.gHg = this.mFileName;
            aVar.gHh = vy();
            aVar.gHi = 1;
            aVar.fqv = this.flt.vj();
            g.pQN.k(10513, aVar.zb());
        }
        this.mFileName = "";
        return true;
    }

    public boolean vo() {
        boolean z = true;
        boolean z2 = false;
        if (this.flJ != null) {
            this.flJ.TG();
            this.flJ.removeCallbacksAndMessages(null);
        }
        f.xG().b((a) this);
        if (this.flI) {
            f.xG().xJ();
            this.flI = false;
        }
        this.flB = (int) vy();
        x.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", this.mFileName, Integer.valueOf(this.flB));
        if (!(this.flt == null || bh.ov(this.mFileName) || this.flD)) {
            com.tencent.mm.compatible.g.a aVar = new com.tencent.mm.compatible.g.a();
            aVar.gHg = this.mFileName;
            aVar.gHh = (long) this.flB;
            aVar.gHi = 2;
            aVar.fqv = this.flt.vj();
            g.pQN.k(10513, aVar.zb());
        }
        synchronized (this) {
            x.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s", this.mFileName, this.flt);
            if (this.flt != null) {
                this.flt.vi();
                this.flu.zd();
            }
        }
        if (this.flE != 2) {
            com.tencent.mm.modelvoice.q.nY(this.mFileName);
            this.mFileName = null;
            x.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + bh.bA(this.flz));
        } else {
            if (((long) this.flB) < 800 || (this.flx && ((long) this.flB) < 1000)) {
                x.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.flB);
                com.tencent.mm.modelvoice.q.nY(this.mFileName);
                this.mFileName = "";
                z = false;
            } else {
                com.tencent.mm.modelvoice.q.aa(this.mFileName, this.flB);
                m.UF().run();
                x.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
            }
            this.mFileName = "";
            z2 = z;
        }
        this.flE = -1;
        return z2;
    }

    public final long vy() {
        if (this.flA == 0) {
            return 0;
        }
        return bh.bA(this.flA);
    }

    public final void er(int i) {
        x.d("MicroMsg.SceneVoice.Recorder", "dkbt Recorder onBluetoothHeadsetStateChange :" + i);
        if (i == 1) {
            vz();
        }
    }

    final void vz() {
        if (!this.flC) {
            this.flC = true;
            if (this.flD) {
                this.flF = b.a.gBZ;
                this.flt = new k();
            } else {
                boolean z;
                SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences(ac.cfs(), 0);
                if (com.tencent.mm.compatible.d.q.gFV.gCO == 1) {
                    z = false;
                } else {
                    z = true;
                }
                if (!sharedPreferences.contains("settings_voicerecorder_mode")) {
                    sharedPreferences.edit().putBoolean("settings_voicerecorder_mode", z).commit();
                }
                x.i("AudioConfig", "getModeByConfig mVoiceRecordMode:%d defValue:%b settings_voicerecorder_mode:%b", Integer.valueOf(com.tencent.mm.compatible.d.q.gFV.gCO), Boolean.valueOf(z), Boolean.valueOf(sharedPreferences.getBoolean("settings_voicerecorder_mode", z)));
                this.flF = sharedPreferences.getBoolean("settings_voicerecorder_mode", z) ? b.a.gBW : b.a.gBX;
                String value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("VoiceFormat");
                String value2 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.h(com.tencent.mm.plugin.zero.b.a.class)).zY().getValue("VoiceFormatToQQ");
                if (this.flF == b.a.gBW) {
                    if (4 == bh.getInt(value, 4) && g$b.vw()) {
                        this.flF = b.a.gBY;
                    }
                    if (this.flw != null && this.flw.endsWith("@qqim")) {
                        this.flF = b.a.gBX;
                    }
                }
                if (this.flF == b.a.gBW) {
                    x.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode, still in pcm mode, force to amr mode");
                    this.flF = b.a.gBX;
                }
                x.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode dynamicFormat:%s dynamicFormatQQ:%s recdMode:%s isSilkSoLoadSuccess:%b", value, value2, this.flF, Boolean.valueOf(g$b.vw()));
                this.flt = new t(this.flF);
            }
            com.tencent.mm.ae.h.a 3 = new 3(this);
            if (this.flt != null) {
                this.flt.a(3);
            }
            this.flv = new a(this);
            e.post(this.flv, "SceneVoiceRecorder_record");
            this.flE = 1;
            this.flJ.J(3000, 3000);
            x.d("MicroMsg.SceneVoice.Recorder", "start end time:" + bh.bA(this.flz));
        }
    }

    public final void a(com.tencent.mm.ae.h.a aVar) {
        this.flH = aVar;
    }

    public final void a(com.tencent.mm.ae.h.b bVar) {
        this.flG = bVar;
    }

    public final int vA() {
        if (this.flD) {
            return 1;
        }
        if (this.flF == b.a.gBW || this.flF == b.a.gBX) {
            return 0;
        }
        if (this.flF == b.a.gBY) {
            return 2;
        }
        return -1;
    }
}
