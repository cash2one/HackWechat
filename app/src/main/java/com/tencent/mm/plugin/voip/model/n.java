package com.tencent.mm.plugin.voip.model;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.voip.model.a.b;
import com.tencent.mm.plugin.voip.model.a.i;
import com.tencent.mm.plugin.voip.model.a.l;
import com.tencent.mm.plugin.voip.model.e.a;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public final class n implements a {
    private static int kAw = -1;
    private static int snn = -1;
    static int sno = 20;
    WifiManager bni;
    public e siL = f.bGC();
    private Object snk = new Object();
    h snl;
    int snm = 0;
    public String snp;
    int snq;
    Timer snr = null;
    WifiInfo sns;
    private ak snt = new ak(Looper.getMainLooper(), new 1(this), false);
    private byte[] snu = new byte[500];
    ak snv = new ak(Looper.getMainLooper(), new 2(this), true);
    ak snw = new ak(Looper.getMainLooper(), new 3(this), true);
    ak snx = new ak(Looper.getMainLooper(), new ak.a(this) {
        final /* synthetic */ n sny;

        {
            this.sny = r1;
        }

        public final boolean uF() {
            x.i("MicroMsg.Voip.VoipServiceEx", "voip called out of time,now destroy...");
            if (3 == this.sny.siL.mStatus && this.sny.snm != 0 && this.sny.snm == this.sny.siL.ske.nDx) {
                this.sny.snm = 0;
                this.sny.siL.p(5, -9000, "");
            }
            return false;
        }
    }, true);

    public n() {
        this.siL.a(this);
        this.snl = new h(ac.getContext());
    }

    public final void stop() {
        x.i("MicroMsg.Voip.VoipServiceEx", "stop");
        reset();
        this.siL.a(null);
    }

    protected final void finalize() {
        stop();
        super.finalize();
    }

    public final void reset() {
        x.d("MicroMsg.Voip.VoipServiceEx", "reset");
        this.siL.reset();
        this.snw.TG();
        this.snt.TG();
        this.snv.TG();
        this.snx.TG();
        if (this.snr != null) {
            this.snr.cancel();
            this.snr = null;
        }
        this.snm = 0;
        d.bGj().smq = null;
    }

    public final boolean bHA() {
        return this.siL.ske.nDx != 0;
    }

    public final boolean bGq() {
        if (this.siL.bGq()) {
            return true;
        }
        return false;
    }

    public static boolean bHB() {
        if (((TelephonyManager) ac.getContext().getSystemService("phone")).getCallState() != 0) {
            return true;
        }
        return false;
    }

    public final void bHC() {
        if (this.siL.bGq()) {
            com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "checkStartup failed, stauts = " + this.siL.mStatus);
        }
        com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "checkStartup...devicekey = " + be.cjW());
        this.siL.bGm();
        x.d("MicroMsg.Voip.VoipServiceEx", "reset");
        this.siL.reset();
        this.snw.TG();
        this.snt.TG();
        this.snv.TG();
        this.snx.TG();
        this.snm = 0;
        ar.Hg();
        q.eI(c.CV().cjU());
    }

    public final void p(int i, int i2, String str) {
        x.i("MicroMsg.Voip.VoipServiceEx", "onFinishVoIP finishType: " + i);
        switch (i) {
            case 1:
                bHF();
                this.siL.skf.onError(i2, str);
                return;
            case 4:
                bHF();
                this.siL.skf.onReject();
                return;
            case 5:
                bHF();
                this.siL.skf.bGW();
                return;
            case 6:
                bHF();
                this.siL.skf.bGY();
                return;
            default:
                return;
        }
    }

    public final int cn(String str, int i) {
        x.i("MicroMsg.Voip.VoipServiceEx", "call username:%s, callType:%d, inviteType:%d", new Object[]{str, Integer.valueOf(0), Integer.valueOf(i)});
        if (bh.ov(str)) {
            com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "Failed call without valid username.");
            return -1;
        } else if (this.siL.bGq()) {
            com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "Failed call withing calling.");
            return -1;
        } else {
            this.siL.ske.soc = 1;
            this.siL.ske.nTr = str;
            com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip.VoipServiceEx", g.zh() + "call username:" + str);
            if (this.siL.ske.oxo) {
                com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", g.zh() + "v2protocal already init.");
                this.siL.ske.jl(false);
                this.siL.ske.reset();
            }
            if (this.siL.ske.bEv() < 0) {
                com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "Failed to init v2protocol.");
                return -1;
            }
            this.snw.J(50000, 50000);
            this.siL.ske.nDA = (int) System.currentTimeMillis();
            List arrayList = new ArrayList();
            arrayList.add(str);
            new com.tencent.mm.plugin.voip.model.a.g(arrayList, this.siL.ske.field_peerId, this.siL.ske.field_capInfo, this.siL.ske.netType, 0, i, this.siL.ske.nDA).bHM();
            this.siL.eQ(2);
            this.siL.skg.skA = 1;
            this.snt.J(60000, 60000);
            this.siL.ske.spH.slw = System.currentTimeMillis();
            this.siL.ske.spH.beginTime = System.currentTimeMillis();
            this.siL.ske.spH.slc = i;
            x.d("MicroMsg.Voip.VoipServiceEx", "iRoomType " + this.siL.ske.spH.slc);
            return 0;
        }
    }

    public final int bHD() {
        if (this.siL.bGq()) {
            x.i("MicroMsg.Voip.VoipServiceEx", "cancelCallEx, roomId:%d, msgID:%d, inviteId:%d", new Object[]{Integer.valueOf(this.siL.ske.nDx), Integer.valueOf(this.siL.ske.snZ), Integer.valueOf(this.siL.ske.nDA)});
            synchronized (this.snk) {
                if (this.siL.ske.nDx == 0 && this.siL.ske.nDA == 0) {
                    com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call with roomid = 0 and inviteId = 0 ");
                    return -1;
                }
                String jl = this.siL.ske.jl(true);
                if (jl.length() > 0) {
                    int i = this.siL.ske.nDx;
                    long j = this.siL.ske.nDy;
                    int i2 = this.siL.ske.snZ;
                    new com.tencent.mm.plugin.voip.model.a.c(i, j, this.siL.ske.nTr, jl, this.siL.ske.nDA).bHM();
                }
                h hVar = this.siL.ske.spH;
                hVar.slm = (int) (System.currentTimeMillis() - hVar.slw);
                com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.VoipDailReport", "devin:cancelInvite:" + hVar.slm);
                if (this.siL.ske.sor == 0 && this.siL.ske.sos == 0) {
                    this.siL.bGn();
                }
                this.siL.yv(this.snl.bIH());
                String bHV = v2protocal.bHV();
                String bHW = this.siL.ske.bHW();
                String bHY = this.siL.ske.bHY();
                String bHX = this.siL.ske.bHX();
                jl = this.siL.ske.bHZ();
                if (bHW.length() > 0) {
                    int i3 = this.siL.ske.nDx;
                    long j2 = this.siL.ske.nDy;
                    i3 = this.siL.ske.snZ;
                    String str = this.siL.ske.nTr;
                    new l(bHV, bHW, bHX, bHY, jl).bHM();
                }
                this.siL.bGl();
                reset();
                this.siL.ske.nDx = 0;
                this.siL.ske.nDA = 0;
                return 0;
            }
        }
        com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "Failed to cancel call ,as not in calling.");
        return -1;
    }

    public final int bHE() {
        x.i("MicroMsg.Voip.VoipServiceEx", "reject");
        if (this.siL.bGp()) {
            synchronized (this.snk) {
                if (this.siL.ske.nDx == 0) {
                    com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
                    return -1;
                }
                this.siL.ske.spH.bGF();
                com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip.VoipServiceEx", " reject, status:" + this.siL.mStatus + " roomid:" + this.siL.ske.nDx);
                new b(2, this.siL.ske.netType, this.siL.ske.nDx, new byte[0], new byte[0], this.siL.ske.nDy, false, false).bHM();
                if (this.siL.ske.sor == 0 && this.siL.ske.sos == 0) {
                    this.siL.bGn();
                }
                this.siL.yv(this.snl.bIH());
                this.siL.ske.jl(true);
                String bHV = v2protocal.bHV();
                String bHW = this.siL.ske.bHW();
                String bHY = this.siL.ske.bHY();
                String bHX = this.siL.ske.bHX();
                String bHZ = this.siL.ske.bHZ();
                com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip.VoipServiceEx", "devin: statreport");
                if (bHW.length() > 0) {
                    com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() > 0");
                    int i = this.siL.ske.nDx;
                    long j = this.siL.ske.nDy;
                    i = this.siL.ske.snZ;
                    String str = this.siL.ske.nTr;
                    new l(bHV, bHW, bHX, bHY, bHZ).bHM();
                } else {
                    com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip.VoipServiceEx", "devin: reject() newdialInfo.length() <= 0");
                }
                this.siL.bGl();
                reset();
                this.siL.ske.nDx = 0;
                return 0;
            }
        }
        com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "Failed to reject with calling, status =" + this.siL.mStatus);
        return -1;
    }

    public final int bHF() {
        com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipServiceEx", "hangUp,status:" + this.siL.mStatus + " roomid:" + this.siL.ske.nDx + ",threadid = " + Thread.currentThread().getId());
        this.siL.skg.bGE();
        if (this.siL.ske.spH.slb == (byte) 1) {
            h hVar = this.siL.ske.spH;
            if (hVar.sls == 0) {
                hVar.sll = 0;
            } else {
                hVar.sll = (int) ((System.currentTimeMillis() - hVar.sls) / 1000);
            }
            if (hVar.sll < 0) {
                hVar.sll = 0;
                com.tencent.mm.plugin.voip.b.a.es("MicroMsg.VoipDailReport", "devin:endTalk, iCallTime Err, rest 0");
            }
            com.tencent.mm.plugin.voip.b.a.et("MicroMsg.VoipDailReport", "devin:endTalk:" + hVar.sll);
        }
        synchronized (this.snk) {
            int i = this.siL.ske.spH.sld;
            if (this.siL.ske.nDx != 0 || 8 == i || 9 == i || 10 == i || 11 == i || 12 == i || 99 == i) {
                this.siL.skf.bGZ();
                com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipServiceEx", "steve:hangUp, uninitGLRender before protocalUninit first!!");
                String jl = this.siL.ske.jl(true);
                if (jl.length() > 0) {
                    new i(this.siL.ske.nDx, this.siL.ske.nDy, jl).bHM();
                    com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "devin: shutdown cgi ");
                }
                this.siL.yv(this.snl.bIH());
                String bHV = v2protocal.bHV();
                String bHW = this.siL.ske.bHW();
                String bHY = this.siL.ske.bHY();
                String bHX = this.siL.ske.bHX();
                String bHZ = this.siL.ske.bHZ();
                if (bHW.length() > 0) {
                    int i2 = this.siL.ske.nDx;
                    long j = this.siL.ske.nDy;
                    i2 = this.siL.ske.snZ;
                    String str = this.siL.ske.nTr;
                    new l(bHV, bHW, bHX, bHY, bHZ).bHM();
                    com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "devin: statreport cgi ");
                }
            } else {
                com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "call hangUp roomId == 0 ");
            }
            this.siL.bGl();
            reset();
            this.siL.ske.nDx = 0;
            com.tencent.mm.plugin.voip.b.a.eu("MicroMsg.Voip.VoipServiceEx", "hangUp over");
        }
        return 0;
    }

    public final int bHG() {
        x.i("MicroMsg.Voip.VoipServiceEx", "ignoreInvite");
        if (this.siL.bGp()) {
            synchronized (this.snk) {
                if (this.siL.ske.nDx == 0) {
                    com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "Failed to reject with roomid = 0. ");
                    return -1;
                }
                new b(3, this.siL.ske.netType, this.siL.ske.nDx, new byte[0], new byte[0], this.siL.ske.nDy, false, false).bHM();
                reset();
                this.siL.ske.nDx = 0;
                return 0;
            }
        }
        com.tencent.mm.plugin.voip.b.a.es("MicroMsg.Voip.VoipServiceEx", "Failed to ignore with calling, status =" + this.siL.mStatus);
        return -1;
    }

    public static void a(int i, long j, int i2, byte[] bArr, byte[] bArr2, String str) {
        com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipServiceEx", "doAck roomId " + i + "  roomKey " + j + " status " + i2);
        if (i != 0 && j != 0) {
            new com.tencent.mm.plugin.voip.model.a.a(i, j, i2, bArr, bArr2, str).bHM();
        }
    }

    public final int setNetSignalValue(int i, int i2) {
        return this.siL.ske.setNetSignalValue(i, i2);
    }

    public final void bHH() {
        com.tencent.mm.plugin.voip.b.a.et("MicroMsg.Voip.VoipServiceEx", "devincdai: voip reset timecount");
        this.snt.TG();
        this.snt.J(60000, 60000);
    }
}
