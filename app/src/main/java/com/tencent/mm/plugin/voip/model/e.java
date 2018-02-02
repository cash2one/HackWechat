package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPrivateAddContact;
import com.tencent.mm.plugin.appbrand.jsapi.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.a.k;
import com.tencent.mm.plugin.voip.model.g.3;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.blm;
import com.tencent.mm.protocal.c.buc;
import com.tencent.mm.protocal.c.bud;
import com.tencent.mm.protocal.c.buj;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;

public final class e {
    public boolean fDV;
    public Context kaK;
    af mHandler;
    public int mStatus;
    public boolean sjA;
    public boolean sjB;
    public boolean sjC;
    public boolean sjD;
    public boolean sjE;
    public boolean sjF;
    public boolean sjG;
    public boolean sjH;
    public blm sjI;
    public int sjJ;
    public long sjK;
    public long sjL;
    public int sjM;
    public int sjN;
    public boolean sjO;
    public boolean sjP;
    public boolean sjQ;
    public int sjR;
    int sjS;
    private int sjT;
    int sjU;
    private int sjV;
    int sjW;
    public boolean sjX;
    private boolean sjY;
    private int sjZ;
    private boolean ska;
    private int skb;
    private int skc;
    private int skd;
    public v2protocal ske;
    public p skf;
    public g skg;
    public o skh;
    public byte[] ski;
    public buj skj;
    public boolean skk;
    public boolean skl;
    public int skm;
    public int skn;
    public int sko;
    public int skp;
    public ak skq;
    Timer skr;
    int sks;
    private ak skt;
    private a sku;

    public final void a(com.tencent.mm.protocal.c.bth r5, com.tencent.mm.protocal.c.bth r6, com.tencent.mm.protocal.c.bth r7) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1444)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1466)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r3 = 0;
        r0 = android.net.Proxy.getDefaultHost();
        r1 = android.net.Proxy.getDefaultPort();
        if (r0 == 0) goto L_0x0070;
    L_0x000b:
        r2 = r0.length();
        if (r2 <= 0) goto L_0x0070;
    L_0x0011:
        if (r1 <= 0) goto L_0x0070;
    L_0x0013:
        r2 = new com.tencent.mm.protocal.c.buq;
        r2.<init>();
        r3 = 1;
        r2.wWd = r3;	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r2.wWe = r1;	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r1 = 0;	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r2.wWf = r1;	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r1 = "";	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r2.userName = r1;	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r1 = "";	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r2.mBX = r1;	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r0 = java.net.InetAddress.getByName(r0);	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r0 = r0.getHostAddress();	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r0 = com.tencent.mm.plugin.voip.b.a.Dl(r0);	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r2.wWe = r0;	 Catch:{ UnknownHostException -> 0x004a, all -> 0x005d }
        r0 = r4.ske;
        r0 = r0.a(r5, r6, r7, r2);
        if (r0 == 0) goto L_0x0049;
    L_0x0040:
        r0 = "MicroMsg.Voip.VoipContext";
        r1 = "setIp fail!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
    L_0x0049:
        return;
    L_0x004a:
        r0 = move-exception;
        r0 = r4.ske;
        r0 = r0.a(r5, r6, r7, r2);
        if (r0 == 0) goto L_0x0049;
    L_0x0053:
        r0 = "MicroMsg.Voip.VoipContext";
        r1 = "setIp fail!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x0049;
    L_0x005d:
        r0 = move-exception;
        r1 = r4.ske;
        r1 = r1.a(r5, r6, r7, r2);
        if (r1 == 0) goto L_0x006f;
    L_0x0066:
        r1 = "MicroMsg.Voip.VoipContext";
        r2 = "setIp fail!";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
    L_0x006f:
        throw r0;
    L_0x0070:
        r0 = new com.tencent.mm.protocal.c.buq;
        r0.<init>();
        r0.wWd = r3;
        r0.wWe = r3;
        r0.wWf = r3;
        r1 = "";
        r0.userName = r1;
        r1 = "";
        r0.mBX = r1;
        r1 = r4.ske;
        r0 = r1.a(r5, r6, r7, r0);
        if (r0 == 0) goto L_0x0049;
    L_0x008d:
        r0 = "MicroMsg.Voip.VoipContext";
        r1 = "setIp fail!";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x0049;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voip.model.e.a(com.tencent.mm.protocal.c.bth, com.tencent.mm.protocal.c.bth, com.tencent.mm.protocal.c.bth):void");
    }

    protected e() {
        this.mStatus = 1;
        this.sjA = false;
        this.sjB = false;
        this.sjC = false;
        this.sjD = false;
        this.fDV = false;
        this.sjE = false;
        this.sjF = false;
        this.sjG = false;
        this.sjH = false;
        this.sjI = new blm();
        this.sjJ = 0;
        this.sjK = 0;
        this.sjL = 0;
        this.sjM = 0;
        this.sjN = 0;
        this.sjO = false;
        this.sjP = false;
        this.sjQ = false;
        this.sjR = 10;
        this.sjS = -1;
        this.sjT = -1;
        this.sjU = -1;
        this.sjV = -1;
        this.sjW = -1;
        this.sjX = false;
        this.sjY = false;
        this.sjZ = 1;
        this.ska = false;
        this.skb = 1;
        this.skc = -1;
        this.skd = -1;
        this.kaK = null;
        this.skf = p.snF;
        this.ski = null;
        this.skj = null;
        this.skk = false;
        this.skl = false;
        this.skm = 0;
        this.skn = 0;
        this.sko = 0;
        this.skp = 0;
        this.skq = new ak(Looper.getMainLooper(), new 1(this), true);
        this.mHandler = new 3(this, Looper.getMainLooper());
        this.skr = null;
        this.sks = 0;
        this.skt = new ak(Looper.getMainLooper(), new 6(this), false);
        this.sku = null;
        this.ske = new v2protocal(this.mHandler);
        this.skg = new g(this);
        this.skh = new o(this);
        this.sko = 0;
    }

    public final void reset() {
        x.i("MicroMsg.Voip.VoipContext", "reset");
        this.skf.bGZ();
        if (this.ske.oxo) {
            this.ske.jl(false);
        }
        this.ske.reset();
        this.sjS = -1;
        this.sjT = -1;
        this.sjU = -1;
        this.sjV = -1;
        this.sjW = -1;
        this.skg.bGE();
        this.ske.sov = 0;
        this.skt.TG();
        this.skh.bHI();
        this.skq.TG();
        this.sjA = false;
        this.sjC = false;
        this.sjB = false;
        this.sjD = false;
        this.fDV = false;
        this.sjE = false;
        this.ski = null;
        this.skj = null;
        this.sjO = false;
        this.sjP = false;
        this.sjQ = false;
        this.sjX = false;
        this.sjY = false;
        this.ska = false;
        this.sjZ = 1;
        this.skb = 1;
        this.skk = false;
        this.skc = -1;
        this.skd = -1;
        this.sjF = false;
        this.sjG = false;
        this.sjE = false;
        this.sjA = false;
        this.sjH = false;
        this.sjR = 10;
        this.mStatus = 1;
        this.sko = 0;
        this.skp = 0;
    }

    public final void bGl() {
        int i = 0;
        if (this.sjA && this.sjJ == 0) {
            this.sjJ = 1;
            if (this.ske.field_speedTestInfoLength < 8) {
                a.es("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! bufsize=" + this.ske.field_speedTestInfoLength);
                return;
            }
            int i2 = this.ske.spF[1];
            if (i2 + 2 > this.ske.field_speedTestInfoLength) {
                a.es("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i2 + ", bufsize=" + this.ske.field_speedTestInfoLength);
                return;
            }
            int i3 = this.ske.spF[(i2 + 2) + 1];
            if ((i2 + 6) + i3 != this.ske.field_speedTestInfoLength) {
                a.es("MicroMsg.Voip.VoipContext", "Herohe StartVoipSpeedTest failed! C2CRttCnt=" + i2 + ", C2SRttCnt=" + i3 + ", bufsize=" + this.ske.field_speedTestInfoLength);
                return;
            }
            this.sjK = this.ske.nDy;
            this.sjM = this.ske.netType;
            this.sjN = this.ske.nDx;
            this.sjI.wbh = this.ske.nDx;
            this.sjI.wOO = this.ske.soo;
            this.sjI.vWK = this.ske.netType;
            this.sjI.wOP = this.sjA ? 1 : 0;
            blm com_tencent_mm_protocal_c_blm = this.sjI;
            if (this.sjC) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            com_tencent_mm_protocal_c_blm.wOQ = i2;
            this.sjI.wOR = this.ske.spF[0];
            this.sjI.wOS = this.ske.spF[1];
            int i4 = 2;
            i2 = 0;
            while (i2 < this.sjI.wOS) {
                i3 = i4 + 1;
                this.sjI.wOT.add(Integer.valueOf(this.ske.spF[i4]));
                i2++;
                i4 = i3;
            }
            int i5 = i4 + 1;
            this.sjI.wOU = this.ske.spF[i4];
            i2 = i5 + 1;
            this.sjI.wOV = this.ske.spF[i5];
            while (i < this.sjI.wOV) {
                i4 = i2 + 1;
                this.sjI.wOW.add(Integer.valueOf(this.ske.spF[i2]));
                i++;
                i2 = i4;
            }
            i3 = i2 + 1;
            this.sjI.wOX = this.ske.spF[i2];
            this.sjI.wOY = this.ske.spF[i3];
            new k(this.sjI).bHM();
            return;
        }
        a.es("MicroMsg.Voip.VoipContext", "StartVoipSpeedTest fail for status is wrong: isChannelStartConnect=" + this.sjA + " ,mSpeedTestStatus=" + this.sjJ);
    }

    public final void bGm() {
        if (this.sjJ != 0) {
            if (this.sjJ == 1) {
                this.sjJ = 0;
                this.ske.spn = 0;
                return;
            }
            this.sjJ = 0;
            v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.ske;
            a.et("MicroMsg.Voip", "v2protocal StopVoipSpeedTest!");
            com_tencent_mm_plugin_voip_model_v2protocal.StopSpeedTest();
            com_tencent_mm_plugin_voip_model_v2protocal.spn = 0;
        }
    }

    public final void yu(int i) {
        this.ske.soq = Math.abs(i);
    }

    public final void bGn() {
        this.ske.sor = this.skg.bGD();
        this.ske.sos = this.skg.bGg();
    }

    public final void yv(int i) {
        this.ske.sot = i;
    }

    public final void shutdown() {
        bGB();
        this.mHandler.post(new Runnable(this) {
            final /* synthetic */ e skv;

            {
                this.skv = r1;
            }

            public final void run() {
                if (this.skv.skf != null) {
                    this.skv.skf.bGY();
                }
            }
        });
    }

    public final void eQ(int i) {
        if (i != this.mStatus) {
            if (i == 4) {
                this.skt.J(60000, 60000);
            }
            this.mStatus = i;
        }
    }

    public final int bGo() {
        if (this.mStatus == 1) {
            return 0;
        }
        if (this.mStatus == 2 || this.mStatus == 3) {
            return 1;
        }
        if (this.mStatus != 4) {
            return 3;
        }
        return 2;
    }

    public final boolean bGp() {
        if (this.mStatus == 3) {
            return true;
        }
        return false;
    }

    public final boolean bGq() {
        x.d("MicroMsg.Voip.VoipContext", "isWorking, status: %d", new Object[]{Integer.valueOf(this.mStatus)});
        if (this.mStatus == 1) {
            return false;
        }
        return true;
    }

    public final void yw(int i) {
        if (8 == i || 9 == i) {
            this.sjV = i;
        } else {
            this.sjS = i;
            this.sjT = i;
        }
        o oVar = this.skh;
        byte[] yM = a.yM(i);
        bdn com_tencent_mm_protocal_c_bdn = new bdn();
        com_tencent_mm_protocal_c_bdn.bj(yM);
        bdn com_tencent_mm_protocal_c_bdn2 = new bdn();
        try {
            com_tencent_mm_protocal_c_bdn2.bj(com_tencent_mm_protocal_c_bdn.toByteArray());
            buc com_tencent_mm_protocal_c_buc = new buc();
            com_tencent_mm_protocal_c_buc.vXp = 3;
            com_tencent_mm_protocal_c_buc.vXq = com_tencent_mm_protocal_c_bdn2;
            com_tencent_mm_protocal_c_buc.nkp = q.FS();
            bud com_tencent_mm_protocal_c_bud = new bud();
            com_tencent_mm_protocal_c_bud.ksO = 1;
            com_tencent_mm_protocal_c_bud.ksP.add(com_tencent_mm_protocal_c_buc);
            oVar.a(com_tencent_mm_protocal_c_bud, false, 4);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
        }
    }

    public final boolean bGr() {
        if (this.sjQ) {
            return false;
        }
        switch (this.sjS) {
            case -1:
                return true;
            case 0:
                if (4 != this.sjT) {
                    return false;
                }
                break;
            case 1:
            case 2:
            case 3:
                return false;
            case 4:
                if (!(4 == this.sjT || -1 == this.sjT)) {
                    return false;
                }
            case 5:
            case 6:
            case 7:
                if (5 == this.sjT || 6 == this.sjT) {
                    return false;
                }
                if (7 == this.sjT) {
                    return false;
                }
                break;
        }
        return true;
    }

    public final boolean bGs() {
        if (this.sjQ) {
            return false;
        }
        switch (this.sjS) {
            case -1:
                return true;
            case 0:
                if (4 != this.sjT) {
                    return false;
                }
                break;
            case 1:
            case 2:
            case 3:
                return false;
            case 4:
                if (!(4 == this.sjU || this.sjU == 0 || -1 == this.sjU)) {
                    return false;
                }
            case 5:
            case 6:
            case 7:
                if (5 == this.sjU || 6 == this.sjU) {
                    return false;
                }
                if (7 == this.sjU) {
                    return false;
                }
                break;
        }
        return true;
    }

    private void bGt() {
        a.eu("MicroMsg.Voip.VoipContext", "DeviceInfo.mAudioInfo.aecMode:" + com.tencent.mm.compatible.d.q.gFV.gDq);
        if (com.tencent.mm.compatible.d.q.gFV.gCS == 1) {
            this.ske.td(JsApiBatchGetContact.CTRL_INDEX);
        }
        byte[] bArr = new byte[2];
        if (com.tencent.mm.compatible.d.q.gFV.gDq >= 0) {
            bArr[0] = (byte) com.tencent.mm.compatible.d.q.gFV.gDq;
            this.ske.setAppCmd(au.CTRL_INDEX, bArr, 1);
        } else if (com.tencent.mm.compatible.d.q.gFV.gDq == -2) {
            this.ske.td(JsApiPrivateAddContact.CTRL_INDEX);
        }
        if (com.tencent.mm.compatible.d.q.gFV.gDr >= 0) {
            bArr[0] = (byte) com.tencent.mm.compatible.d.q.gFV.gDr;
            this.ske.setAppCmd(av.CTRL_INDEX, bArr, 1);
        } else if (com.tencent.mm.compatible.d.q.gFV.gDr == -2) {
            this.ske.td(409);
        }
        if (com.tencent.mm.compatible.d.q.gFV.gDt >= 0) {
            byte[] bArr2 = new byte[5];
            if (com.tencent.mm.compatible.d.q.gFV.gDu >= 0 && com.tencent.mm.compatible.d.q.gFV.gDv >= 0) {
                bArr2[0] = (byte) com.tencent.mm.compatible.d.q.gFV.gDu;
                bArr2[1] = (byte) com.tencent.mm.compatible.d.q.gFV.gDv;
                if (com.tencent.mm.compatible.d.q.gFV.gDw >= 0) {
                    bArr2[2] = (byte) com.tencent.mm.compatible.d.q.gFV.gDw;
                    bArr2[3] = (byte) com.tencent.mm.compatible.d.q.gFV.gDt;
                    bArr2[4] = (byte) com.tencent.mm.compatible.d.q.gFV.gDx;
                    this.ske.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr2, 5);
                } else {
                    this.ske.setAppCmd(TencentLocation.ERROR_UNKNOWN, bArr2, 2);
                }
            }
        } else if (com.tencent.mm.compatible.d.q.gFV.gDt == -2) {
            this.ske.td(405);
        }
        if (com.tencent.mm.compatible.d.q.gFV.gCT >= 0 || com.tencent.mm.compatible.d.q.gFV.gCV >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (com.tencent.mm.compatible.d.q.gFV.gCT >= 0) {
                bArr[0] = (byte) com.tencent.mm.compatible.d.q.gFV.gCT;
            }
            if (com.tencent.mm.compatible.d.q.gFV.gCV >= 0) {
                bArr[1] = (byte) com.tencent.mm.compatible.d.q.gFV.gCV;
            }
            this.ske.setAppCmd(com.tencent.mm.plugin.appbrand.jsapi.contact.e.CTRL_INDEX, bArr, 2);
        }
        if (com.tencent.mm.compatible.d.q.gFV.gCU >= 0 || com.tencent.mm.compatible.d.q.gFV.gCW >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (com.tencent.mm.compatible.d.q.gFV.gCU >= 0) {
                bArr[0] = (byte) com.tencent.mm.compatible.d.q.gFV.gCU;
            }
            if (com.tencent.mm.compatible.d.q.gFV.gCW >= 0) {
                bArr[1] = (byte) com.tencent.mm.compatible.d.q.gFV.gCW;
            }
            this.ske.setAppCmd(415, bArr, 2);
        }
        if (com.tencent.mm.compatible.d.q.gFV.gCX >= 0 || com.tencent.mm.compatible.d.q.gFV.gCY >= 0) {
            bArr[0] = (byte) -1;
            bArr[1] = (byte) -1;
            if (com.tencent.mm.compatible.d.q.gFV.gCX >= 0) {
                bArr[0] = (byte) com.tencent.mm.compatible.d.q.gFV.gCX;
            }
            if (com.tencent.mm.compatible.d.q.gFV.gCY >= 0) {
                bArr[1] = (byte) com.tencent.mm.compatible.d.q.gFV.gCY;
            }
            this.ske.setAppCmd(422, bArr, 2);
        }
        if (com.tencent.mm.compatible.d.q.gFV.gCZ >= 0) {
            bArr[0] = (byte) com.tencent.mm.compatible.d.q.gFV.gCZ;
            this.ske.setAppCmd(416, bArr, 1);
        }
        if (com.tencent.mm.compatible.d.q.gFV.gDd >= 0) {
            bArr[0] = (byte) com.tencent.mm.compatible.d.q.gFV.gDd;
            this.ske.setAppCmd(d.CTRL_INDEX, bArr, 4);
        }
        if (com.tencent.mm.compatible.d.q.gFV.gDa >= 0 && !(this.ske.soO == 0 && com.tencent.mm.compatible.d.q.gFV.gDa == 5)) {
            bArr[0] = (byte) com.tencent.mm.compatible.d.q.gFV.gDa;
            this.ske.setAppCmd(417, bArr, 1);
        }
        if (com.tencent.mm.compatible.d.q.gFV.gDb >= 0 && !(this.ske.soO == 0 && com.tencent.mm.compatible.d.q.gFV.gDb == 5)) {
            bArr[0] = (byte) com.tencent.mm.compatible.d.q.gFV.gDb;
            this.ske.setAppCmd(418, bArr, 1);
        }
        if (com.tencent.mm.compatible.d.q.gFV.gDc >= 0) {
            bArr[0] = (byte) com.tencent.mm.compatible.d.q.gFV.gDc;
            this.ske.setAppCmd(419, bArr, 1);
        }
        if (this.ske.soO == 1 && (com.tencent.mm.compatible.d.q.gFV.gDa == 5 || com.tencent.mm.compatible.d.q.gFV.gDb == 5)) {
            this.ske.soB = 5;
        }
        if (1 == com.tencent.mm.compatible.d.q.gFV.gDA) {
            byte[] bArr3 = new byte[30];
            for (int i = 0; i < 15; i++) {
                bArr3[i * 2] = (byte) (com.tencent.mm.compatible.d.q.gFV.gDB[i] & 255);
                bArr3[(i * 2) + 1] = (byte) ((com.tencent.mm.compatible.d.q.gFV.gDB[i] >> 8) & 255);
            }
            this.ske.setAppCmd(420, bArr3, 30);
        }
        if (com.tencent.mm.compatible.d.q.gFV.gDA == 0) {
            this.ske.td(421);
        }
        if (com.tencent.mm.compatible.d.q.gFV.gDC[0] > (short) 0 || com.tencent.mm.compatible.d.q.gFV.gDC[1] > (short) 0) {
            bArr[0] = (byte) 0;
            bArr[1] = (byte) 0;
            if (com.tencent.mm.compatible.d.q.gFV.gDC[0] > (short) 0 && com.tencent.mm.compatible.d.q.gFV.gDC[0] < (short) 10000) {
                bArr[0] = (byte) com.tencent.mm.compatible.d.q.gFV.gDC[0];
            }
            if (com.tencent.mm.compatible.d.q.gFV.gDC[1] > (short) 0 && com.tencent.mm.compatible.d.q.gFV.gDC[1] < (short) 10000) {
                bArr[1] = (byte) com.tencent.mm.compatible.d.q.gFV.gDC[1];
            }
            this.ske.setAppCmd(423, bArr, 2);
        }
        if (com.tencent.mm.compatible.d.q.gFV.gDE > 0) {
            bArr[0] = (byte) com.tencent.mm.compatible.d.q.gFV.gDE;
            this.ske.setAppCmd(424, bArr, 1);
        }
        if (com.tencent.mm.compatible.d.q.gFV.gDM >= 0) {
            this.ske.setAppCmd(426, new byte[]{(byte) com.tencent.mm.compatible.d.q.gFV.gDM, (byte) com.tencent.mm.compatible.d.q.gFV.gDN, (byte) com.tencent.mm.compatible.d.q.gFV.gDO, (byte) com.tencent.mm.compatible.d.q.gFV.gDP}, 4);
        }
    }

    public final void bGu() {
        a.et("MicroMsg.Voip.VoipContext", "tryStartTalk: try start talk");
        if (this.sjE && this.sjC) {
            a.et("MicroMsg.Voip.VoipContext", "Voip tryStartTalk, channel setActive");
            this.ske.setActive();
            if (this.sjH) {
                a.et("MicroMsg.Voip.VoipContext", "tryStartTalk: engine already started, isEngineStarted " + this.sjH);
                return;
            }
            if (this.ske.startEngine() == 0) {
                this.ske.spH.slr = 0;
            } else {
                this.sjH = false;
                this.ske.spH.slr = 1;
            }
            bGt();
            if (!bGr() && !bGs()) {
                bGx();
            } else if (this.skr != null) {
                bGx();
            } else {
                this.skr = new Timer();
                this.sks = 0;
                this.skr.schedule(new 5(this), 200, 200);
            }
            this.skf.bHa();
            g gVar = this.skg;
            if (gVar.skA == 2) {
                a.es("MicroMsg.Voip.VoipDeviceHandler", "dev start already...");
            } else {
                a.et("MicroMsg.Voip.VoipDeviceHandler", "start device......");
                gVar.skA = 2;
                if (gVar.skO != null) {
                    a.eu("MicroMsg.Voip.VoipDeviceHandler", "stop videodecode thread..");
                    gVar.skO.skQ = true;
                    com.tencent.mm.sdk.f.e.remove(gVar.skO);
                    gVar.skO = null;
                }
                gVar.skO = new b(gVar);
                com.tencent.mm.sdk.f.e.post(gVar.skO, "VoipDeviceHandler_decode");
                a.eu("MicroMsg.Voip.VoipDeviceHandler", "start video decode thread..");
                com.tencent.mm.compatible.d.q.gFV.dump();
                gVar.sky = new b();
                gVar.sky.Y(v2protocal.oFK, 20, 0);
                gVar.skB = gVar.sky.l(gVar.siL.kaK, true);
                byte[] bArr = new byte[1];
                bArr[0] = (byte) (gVar.sky.siK ? 1 : 0);
                gVar.siL.ske.setAppCmd(502, bArr, 1);
                if (gVar.skB <= 10) {
                    if (gVar.skB <= 0) {
                        gVar.skL = 1;
                    }
                    gVar.skB = 92;
                }
                gVar.sky.siT = new a(gVar) {
                    final /* synthetic */ g skP;

                    {
                        this.skP = r1;
                    }

                    public final int L(byte[] bArr, int i) {
                        if (this.skP.skA != 2) {
                            return -1;
                        }
                        int playCallback = this.skP.siL.ske.playCallback(bArr, i);
                        if (playCallback < 0) {
                            a.es("MicroMsg.Voip.VoipDeviceHandler", com.tencent.mm.compatible.util.g.zh() + "protocal.playcallback ret:" + playCallback);
                            return -1;
                        }
                        g.skM++;
                        return 0;
                    }
                };
                if (gVar.sky.bGd() <= 0) {
                    gVar.skL = 1;
                }
                synchronized (gVar.skK) {
                    com.tencent.mm.sdk.f.e.b(new 3(gVar), "voip_start_record", 10);
                }
            }
            h hVar = this.ske.spH;
            if (hVar.beginTime == 0) {
                hVar.slk = 0;
            } else {
                hVar.slk = (int) (System.currentTimeMillis() - hVar.beginTime);
            }
            a.et("MicroMsg.VoipDailReport", "devin:beginTime:" + hVar.beginTime + ", CurrentTime: " + System.currentTimeMillis());
            a.et("MicroMsg.VoipDailReport", "devin:endNewDial:" + hVar.slk);
            this.skf.onConnected();
            this.mStatus = 5;
            hVar = this.ske.spH;
            hVar.sls = System.currentTimeMillis();
            a.et("MicroMsg.VoipDailReport", "devin:beginTalk:" + hVar.sls);
            this.ske.setSvrConfig(202, this.ske.soH, this.ske.soI, 0, 0, 0, 0);
            this.ske.setSvrConfig(203, 0, 0, this.ske.soM, 0, 0, 0);
            this.ske.setSvrConfig(b.CTRL_INDEX, 0, 0, this.ske.soP, 0, 0, 0);
            this.ske.setSvrConfig(103, this.ske.soJ, this.ske.soK, this.ske.soL, this.ske.soN, 0, 0);
            this.ske.setSvrConfig(g.CTRL_INDEX, 0, 0, this.ske.spd, 0, 0, 0);
            a.et("MicroMsg.Voip.VoipContext", "bothSideGeneralSwitch" + this.ske.spd);
            int i = (this.ske.soQ >> 2) & 3;
            int i2 = this.ske.soQ & 3;
            int i3 = this.ske.nDF == 0 ? (i << 2) + i2 : (i2 << 2) + i;
            this.ske.setSvrConfig(502, 0, 0, i3, 0, 0, 0);
            this.ske.setSvrConfig(503, 0, 0, this.ske.soR, this.ske.soS, this.ske.soT, this.ske.soU);
            if (!(this.ske.spi == null || this.ske.spj == null)) {
                this.ske.setSvrConfig(504, 0, 0, this.ske.sph, 0, 0, 0);
                this.ske.setSvrConfig(505, 0, 0, this.ske.spi[0], this.ske.spi[1], this.ske.spi[2], this.ske.spi[3]);
                this.ske.setSvrConfig(506, 0, 0, this.ske.spj[0], this.ske.spj[1], 0, 0);
                a.et("MicroMsg.Voip.VoipContext", "FECSvrCtr = " + this.ske.sph + ",FECKeyPara1 = " + this.ske.spi[0] + "," + this.ske.spi[1] + "," + this.ske.spi[2] + "," + this.ske.spi[3] + ",FECKeyPara2 = " + this.ske.spj[0] + "," + this.ske.spj[1]);
            }
            this.ske.setSvrConfig(507, 0, 0, (this.ske.soV & 4) >> 2, (this.ske.soV & 2) >> 1, this.ske.soV & 1, 0);
            this.ske.setjbmbitraterssvrparam();
            a.et("MicroMsg.Voip.VoipContext", "zhengxue[Logic] setSvrConfig brefore onStartTalk: audioTsdfBeyond3G = " + this.ske.soH + ",audioTsdEdge = " + this.ske.soI + ",passthroughQosAlgorithm = " + this.ske.soJ + ",fastPlayRepair = " + this.ske.soK + ", audioDTX = " + this.ske.soM + ", mARQFlag = " + i3 + ", mQosStrategy = " + this.ske.soV + ", mSvrCfgListV = " + this.ske.soL + ", maxBRForRelay = " + this.ske.soN);
            byte[] bArr2 = new byte[]{(byte) com.tencent.mm.compatible.d.q.gFU.gEs, (byte) -1};
            a.eu("MicroMsg.Voip.VoipContext", "steve: Model Name: " + Build.MODEL);
            a.eu("MicroMsg.Voip.VoipContext", "steve: Image Enhancement for Android Capture!!, mode: " + bArr2[0]);
            this.ske.setAppCmd(15, bArr2, 1);
            a.eu("MicroMsg.Voip.VoipContext", "anlin: ClientVersion: " + com.tencent.mm.protocal.d.vAz);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            allocate.order(ByteOrder.LITTLE_ENDIAN).putInt(com.tencent.mm.protocal.d.vAz);
            this.ske.setAppCmd(505, allocate.array(), 4);
            this.sjH = true;
            return;
        }
        a.et("MicroMsg.Voip.VoipContext", "tryStartTalk: fail isCanSendData " + this.sjE + ", isChannelConnectedSuccess " + this.sjC);
    }

    public final boolean bGv() {
        boolean bGr = bGr();
        int i = 0;
        if (bGr) {
            i = 1;
        }
        if (this.skc == -1 || this.skc != i) {
            this.skc = i;
            if (bGr) {
                a.eu("MicroMsg.Voip.VoipContext", "setAppCmd: set start video Out.......!");
                this.ske.td(203);
            } else {
                a.eu("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video Out.......!");
                this.ske.td(202);
            }
        }
        return bGr;
    }

    public final boolean bGw() {
        boolean bGs = bGs();
        int i = 0;
        if (bGs) {
            i = 1;
        }
        if (this.skd == -1 || this.skd != i) {
            this.skd = i;
            if (bGs) {
                a.eu("MicroMsg.Voip.VoipContext", "setAppCmd: set start video In.......!");
                this.ske.td(201);
            } else {
                a.eu("MicroMsg.Voip.VoipContext", "setAppCmd: set stop video In.......!");
                this.ske.td(200);
            }
        }
        return bGs;
    }

    final void bGx() {
        if (this.mStatus == 5) {
            eQ(6);
            h hVar = this.ske.spH;
            if (hVar.beginTime == 0) {
                hVar.skU = 0;
            } else {
                hVar.skU = (int) (System.currentTimeMillis() - hVar.beginTime);
            }
            a.et("MicroMsg.VoipDailReport", "devin:beginTime:" + hVar.beginTime + ", CurrentTime: " + System.currentTimeMillis());
            a.et("MicroMsg.VoipDailReport", "devin:endDial:" + hVar.skU);
            a.et("MicroMsg.Voip.VoipContext", "talking  now .......!");
            this.mHandler.post(new 4(this));
        }
    }

    private void bGy() {
        if (this.mStatus != 2 && this.mStatus != 3 && this.mStatus != 4) {
            a.et("MicroMsg.Voip.VoipContext", "startConnectRelay status fail, status:" + this.mStatus);
        } else if (this.sjA) {
            a.et("MicroMsg.Voip.VoipContext", "can not startConnectRelay again");
        } else {
            int i;
            a.et("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel relay");
            int i2 = ((((this.ske.soQ >> 2) & 3) >> 1) & 1) & (((this.ske.soQ & 3) >> 1) & 1);
            v2protocal com_tencent_mm_plugin_voip_model_v2protocal = this.ske;
            int i3 = this.ske.soc;
            long j = (long) this.ske.nDx;
            int i4 = this.ske.nDF;
            long j2 = this.ske.nDy;
            byte[] bArr = this.ske.soe;
            int i5 = this.ske.channelStrategy;
            int i6 = this.ske.soj;
            int i7 = this.ske.sok;
            int i8 = this.ske.soh;
            if (this.ske.soi == null) {
                i = 0;
            } else {
                i = this.ske.soi.length;
            }
            int configInfo = com_tencent_mm_plugin_voip_model_v2protocal.setConfigInfo(i3, j, i4, j2, bArr, i5, i6, i7, i8, i, this.ske.soi, this.ske.sol, i2, this.ske.sob, this.ske.spa, this.ske.spb, this.ske.spc, this.ske.som);
            if (configInfo == 0) {
                configInfo = this.ske.connectToPeerRelay();
            }
            a.et("MicroMsg.Voip.VoipContext", "zhengxue[Logic], mARQFlag: " + i2 + ",  NetType: " + this.ske.sob + ", EncryptStrategy: " + this.ske.spa);
            if (configInfo < 0) {
                a.es("MicroMsg.Voip.VoipContext", "v2protocal setConfigInfo or connectToPeerRelay failed, ret:" + configInfo);
                this.ske.spH.skR = 14;
                p(1, -9002, "");
                return;
            }
            this.sjA = true;
            this.ske.spH.skY = (byte) 1;
            this.ske.spH.slg = 1;
        }
    }

    public final void bGz() {
        boolean z = !bh.bw(this.ske.soe);
        a.et("MicroMsg.Voip.VoipContext", "channel:try start connect, hasRemotePid:" + z + ",mStatus:" + this.mStatus + ",isPreConnect:" + this.sjG + ",isRemoteAccepted:" + this.sjD + ",isLocalAccept:" + this.fDV);
        this.ske.spH.sld = 7;
        if (!z) {
            return;
        }
        if (this.mStatus != 4 && this.mStatus != 5 && this.mStatus != 6 && ((this.mStatus != 2 || !this.sjG) && (this.mStatus != 3 || !this.sjG))) {
            return;
        }
        if (this.mStatus != 2 && this.mStatus != 3 && this.mStatus != 4 && this.mStatus != 5 && this.mStatus != 6) {
            a.et("MicroMsg.Voip.VoipContext", "startConnect status fail, status:" + this.mStatus);
        } else if (this.sjD || this.fDV) {
            if (!this.sjA) {
                bGy();
            }
            if (this.mStatus != 4 && this.mStatus != 5 && this.mStatus != 6) {
                a.et("MicroMsg.Voip.VoipContext", "startConnectDirect status fail, status:" + this.mStatus);
            } else if (this.sjB) {
                a.et("MicroMsg.Voip.VoipContext", "can not startConnectDirect again");
            } else {
                this.sjB = true;
                a.et("MicroMsg.Voip.VoipContext", "v2protocal StartConnectChannel direct");
                int connectToPeerDirect = this.ske.connectToPeerDirect();
                if (connectToPeerDirect < 0) {
                    a.es("MicroMsg.Voip.VoipContext", "v2protocal connectToPeerDirect failed, ret:" + connectToPeerDirect);
                    this.ske.spH.skR = 14;
                    p(1, -9002, "");
                    return;
                }
                bGA();
            }
        } else if (this.sjG && !this.sjA) {
            bGy();
        }
    }

    public final void bGA() {
        if (this.sjB && !bh.bw(this.ske.sog)) {
            int handleCommand = this.ske.handleCommand(this.ske.sog, this.ske.sog.length);
            if (handleCommand < 0) {
                a.es("MicroMsg.Voip.VoipContext", "v2protocal handlecommand failed ret:" + handleCommand);
            }
            this.ske.sog = null;
        }
    }

    public final void aL(byte[] bArr) {
        x.i("MicroMsg.Voip.VoipContext", "updateRemotePid");
        this.ske.spH.skW = (byte) 1;
        this.ske.spH.skV = (byte) 1;
        this.ske.soe = bArr;
    }

    public final void b(int i, byte[] bArr, byte[] bArr2) {
        this.ske.sph = i;
        this.ske.spi = bArr;
        this.ske.spj = bArr2;
    }

    public final void a(byte[] bArr, int i, int i2, byte[] bArr2) {
        this.ske.soh = i;
        this.ske.soi = bArr;
        this.ske.spa = i2;
        this.ske.spb = bArr2;
    }

    public final void yx(int i) {
        this.ske.spc = i;
    }

    public final void i(int i, int i2, int i3, int i4, int i5) {
        this.ske.soQ = i;
        this.ske.soR = i2;
        this.ske.soS = i3;
        this.ske.soT = i4;
        this.ske.soU = i5;
    }

    public final void yy(int i) {
        this.ske.soV = i;
    }

    public final void aM(byte[] bArr) {
        x.i("MicroMsg.Voip.VoipContext", "updateRemoteCapInfo, isGotCapInfo: %s", new Object[]{Byte.valueOf(this.ske.spH.sla)});
        if (this.ske.spH.sla != (byte) 1 && bArr != null) {
            this.ske.spH.sla = (byte) 1;
            this.ske.sof = bArr;
            int exchangeCabInfo = this.ske.exchangeCabInfo(this.ske.sof, this.ske.sof.length);
            if (exchangeCabInfo < 0) {
                a.es("MicroMsg.Voip.VoipContext", "protocal exchangecabinfo failed ret:" + exchangeCabInfo);
                this.ske.spH.skR = 15;
                p(1, -9003, "");
            }
        }
    }

    public final void yz(int i) {
        this.ske.spH.skX = (byte) 1;
        this.ske.channelStrategy = i;
    }

    public final void yA(int i) {
        this.ske.sol = i;
    }

    public final void bGB() {
        x.i("MicroMsg.Voip.VoipContext", "stop repeat voip sync");
        this.skq.TG();
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.sku = aVar;
        }
    }

    public final void p(int i, int i2, String str) {
        bGB();
        if (this.sku != null) {
            this.sku.p(i, i2, str);
        }
    }
}
