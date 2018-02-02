package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.k;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.plugin.backup.a.b$b;
import com.tencent.mm.plugin.backup.a.f$b;
import com.tencent.mm.plugin.backup.b.b;
import com.tencent.mm.plugin.backup.b.c;
import com.tencent.mm.plugin.backup.f.f$a;
import com.tencent.mm.plugin.backup.f.i.a;
import com.tencent.mm.plugin.backup.h.e;
import com.tencent.mm.plugin.backup.h.f;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.plugin.backup.h.j;
import com.tencent.mm.plugin.backup.h.m;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.plugin.backup.h.v;
import com.tencent.mm.plugin.backup.h.w;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.Iterator;
import java.util.LinkedList;

public final class d implements b$b, com.tencent.mm.plugin.backup.f.b.d {
    public static boolean kki = false;
    public static boolean klH = false;
    public byte[] bitmapData;
    public com.tencent.mm.plugin.backup.a.b.d kkd;
    public LinkedList<String> klA;
    private b klB;
    private c klC;
    public long klD = 0;
    public long klE = 0;
    public boolean klF = false;
    public int klG = 0;
    private int klI;
    private int klJ;
    private int klK = 0;
    public e klL = new e(new 5(this), b.aoR().aol());
    public boolean kle = false;
    public com.tencent.mm.plugin.backup.f.b.c klu = new 2(this);
    private final f$a klv = new 3(this);
    public final a klw = new 4(this);

    public final void al(boolean z) {
        x.e("MicroMsg.BackupMoveServer", "summerbak BackupMoveServer CANCEL, Caller:%s", new Object[]{ai.cfH()});
        if (!z) {
            apa();
        }
        if (this.klC != null) {
            this.klC.cancel();
        }
        if (this.klB != null) {
            this.klB.cancel();
            this.klB = null;
        }
        x.i("MicroMsg.BackupMoveServer", "cancel , notifyall.");
        com.tencent.mm.plugin.backup.f.b.apK();
        com.tencent.mm.plugin.backup.f.b.apM();
    }

    public static void c(int i, long j, long j2, int i2) {
        long j3 = 0;
        x.i("MicroMsg.BackupMoveServer", "setBakupSelectTimeData, timeMode[%d], startTime[%d], endTime[%d], contentType[%d]", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2)});
        if (i == 0) {
            j2 = 0;
        } else {
            j3 = j;
        }
        b.aoR();
        Editor edit = b.aoq().edit();
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", i);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", j3);
        edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", j2);
        edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", i2);
        edit.commit();
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        String str = "MicroMsg.BackupMoveServer";
        String str2 = "summerbak onNotify isLocal:%b type:%d seq:%d buf:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        x.i(str, str2, objArr);
        if (z && bArr != null && CdnLogic.kMediaTypeBeatificFile == i) {
            x.i("MicroMsg.BackupMoveServer", "summerbak local disconnect, backupMoveState:%d", new Object[]{Integer.valueOf(b.aoR().aol().kiJ)});
            switch (b.aoR().aol().kiJ) {
                case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                case -5:
                    b.aoR().aoS().stop();
                    break;
                case -4:
                    al(true);
                    break;
                case 1:
                    b.aoR().aoS().stop();
                    b.aoR().aol().kiJ = -100;
                    mz(-100);
                    break;
                case 12:
                case 14:
                    al(true);
                    b.aoR().aoS().stop();
                    b.aoR().aol().kiJ = -4;
                    mz(-4);
                    g.pQN.a(485, 24, 1, false);
                    if (!(this.klC == null || this.klC.kjr == 0)) {
                        long bz = bh.bz(this.klC.kjr);
                        x.i("MicroMsg.BackupMoveServer", "onNotify backup transfer disconnect, backupDataSize:%d kb, backupCostTime:%d s", new Object[]{Long.valueOf(this.klC.aoy()), Long.valueOf(bz / 1000)});
                        break;
                    }
            }
        }
        if (i == 1) {
            v vVar = (v) com.tencent.mm.plugin.backup.a.g.a(new v(), bArr);
            if (vVar == null) {
                x.e("MicroMsg.BackupMoveServer", "authReq parseBuf failed:%d", new Object[]{Integer.valueOf(bh.bx(bArr))});
                b.aoR().aol().kiJ = -5;
                mz(-5);
                return;
            }
            if (bh.ov(b.aoR().kiB)) {
                b.aoR().kiB = vVar.ID;
            }
            if (vVar.ID.equals(b.aoR().kiB)) {
                x.i("MicroMsg.BackupMoveServer", "authReq info, id:%s, step:%d", new Object[]{vVar.ID, Integer.valueOf(vVar.ktL)});
                if (vVar.ktL == 0) {
                    if (!b.aoR().kiC.equals(new String(k.a(vVar.ksB.oz, com.tencent.mm.plugin.backup.a.d.aop())))) {
                        w wVar = new w();
                        wVar.ktL = 0;
                        wVar.ID = b.aoR().kiB;
                        wVar.ktm = 1;
                        x.e("MicroMsg.BackupMoveServer", "get authReq step 0, but hello failed");
                        try {
                            x.i("MicroMsg.BackupMoveServer", "summerbak send authFailResp.");
                            com.tencent.mm.plugin.backup.f.b.o(wVar.toByteArray(), 2, i2);
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
                        }
                        b.aoR().aol().kiJ = -5;
                        mz(-5);
                    }
                    if (vVar.ktM < com.tencent.mm.plugin.backup.a.c.kit) {
                        x.i("MicroMsg.BackupMoveServer", "summerbak old move, version:%d", new Object[]{Integer.valueOf(vVar.ktM)});
                        g.pQN.a(485, 103, 1, false);
                        b.aoR().aol().kiJ = -12;
                        mz(-12);
                        return;
                    }
                    x.i("MicroMsg.BackupMoveServer", "summerbak start move");
                    this.klJ = i2;
                    if (klH || kki) {
                        if (klH && kki && (vVar.ktO & com.tencent.mm.plugin.backup.a.c.kiy) == 0 && (vVar.ktO & com.tencent.mm.plugin.backup.a.c.kiz) == 0) {
                            b.aoR().aol().kiJ = -31;
                            mz(-31);
                            this.klK = 1;
                            return;
                        } else if (klH && (vVar.ktO & com.tencent.mm.plugin.backup.a.c.kiy) == 0) {
                            b.aoR().aol().kiJ = -32;
                            mz(-32);
                            this.klK = 2;
                            return;
                        } else if (kki && (vVar.ktO & com.tencent.mm.plugin.backup.a.c.kiz) == 0) {
                            b.aoR().aol().kiJ = -33;
                            mz(-33);
                            this.klK = 3;
                            return;
                        }
                    }
                    dF(false);
                    return;
                } else if (vVar.ktL == 1) {
                    if (!b.aoR().kiD.equals(new String(k.a(vVar.ksB.oz, com.tencent.mm.plugin.backup.a.d.aop())))) {
                        x.e("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok failed");
                        b.aoR().aol().kiJ = -5;
                        mz(-5);
                    }
                    x.i("MicroMsg.BackupMoveServer", "get authReq step 1 and validate ok success");
                    b.aoR().aol().kiJ = 2;
                    mz(2);
                    return;
                } else {
                    return;
                }
            }
            x.e("MicroMsg.BackupMoveServer", "id not equel:self:%s, authReq.id:%s", new Object[]{b.aoR().kiB, vVar.ID});
            al(false);
            b.aoR().aol().kiJ = -5;
            mz(-5);
        } else if (i == 3) {
            this.klI = i2;
            if (b.aoR().aoV().kkH) {
                apg();
            } else {
                this.klF = true;
            }
        } else if (i == 9) {
            e eVar = (e) com.tencent.mm.plugin.backup.a.g.a(new e(), bArr);
            if (eVar == null) {
                x.e("MicroMsg.BackupMoveServer", "heartBeatRequest parseBuf failed:%d", new Object[]{Integer.valueOf(bh.bx(bArr))});
                return;
            }
            x.i("MicroMsg.BackupMoveServer", "summerbak receive heartbeatReq,req:%s ack:%d", new Object[]{eVar, Long.valueOf(eVar.kph)});
            f fVar = (f) com.tencent.mm.plugin.backup.a.g.a(new f(), bArr);
            fVar.kph = eVar.kph;
            try {
                x.i("MicroMsg.BackupMoveServer", "summerbak send heartbeatResp");
                com.tencent.mm.plugin.backup.f.b.o(fVar.toByteArray(), 10, i2);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
            }
        } else if (i == 10) {
            try {
                new f().aF(bArr);
            } catch (Throwable e22) {
                x.printErrStackTrace("MicroMsg.BackupMoveServer", e22, "summerbak heartbeatResp parse from buf error.", new Object[0]);
            }
        } else if (i == 5) {
            x.i("MicroMsg.BackupMoveServer", "summerbak receive command cancel");
            al(true);
            b.aoR().aol().kiJ = -100;
            mz(-100);
        } else if (i == 12) {
            j jVar = (j) com.tencent.mm.plugin.backup.a.g.a(new j(), bArr);
            if (jVar == null) {
                x.e("MicroMsg.BackupMoveServer", "requestSessionResp parseBuf failed:%d", new Object[]{Integer.valueOf(bh.bx(bArr))});
                b.aoR().aol().kiJ = -5;
                mz(-5);
                return;
            }
            int i3;
            LinkedList b = b(jVar.ksQ, jVar.ksR);
            str2 = "MicroMsg.BackupMoveServer";
            String str3 = "summerbak backup receive requestsession response. backupSessionList:%d ";
            Object[] objArr2 = new Object[1];
            if (b == null) {
                i3 = -1;
            } else {
                i3 = b.size();
            }
            objArr2[0] = Integer.valueOf(i3);
            x.i(str2, str3, objArr2);
            if (b == null) {
                x.e("MicroMsg.BackupMoveServer", "requestSessionResp sessionName or timeInterval null or requestSessionResp number error.");
                apa();
                b.aoR().aol().kiJ = -21;
                mz(-21);
                return;
            }
            com.tencent.mm.plugin.backup.f.b.a(this.klv);
            com.tencent.mm.plugin.backup.f.b.apJ();
            this.klC = new c(b.aoR(), 2, this);
            this.klC.dC(false);
            this.klC.a(b, b.aoR().aol().kiM, kki);
        }
    }

    public final void dF(boolean z) {
        if (z) {
            switch (this.klK) {
                case 1:
                    klH = false;
                    kki = false;
                    this.klD = 0;
                    this.klE = 0;
                    break;
                case 2:
                    klH = false;
                    this.klD = 0;
                    this.klE = 0;
                    break;
                case 3:
                    kki = false;
                    break;
            }
        }
        w wVar = new w();
        wVar.ktL = 0;
        wVar.ID = b.aoR().kiB;
        wVar.ktM = com.tencent.mm.plugin.backup.a.c.kit;
        wVar.ktm = 0;
        wVar.ktN = this.klG;
        wVar.ksB = new com.tencent.mm.bq.b(k.b(b.aoR().kiD.getBytes(), com.tencent.mm.plugin.backup.a.d.aop()));
        if (bh.getInt(com.tencent.mm.k.g.zY().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
            wVar.ktO |= com.tencent.mm.plugin.backup.a.c.kix;
        }
        wVar.ktO |= com.tencent.mm.plugin.backup.a.c.kiy;
        wVar.ktO |= com.tencent.mm.plugin.backup.a.c.kiz;
        try {
            x.i("MicroMsg.BackupMoveServer", "summerbak send authSuccessResp.");
            com.tencent.mm.plugin.backup.f.b.o(wVar.toByteArray(), 2, this.klJ);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to PACKET_TYPE_AUTHENTICATE_RESPONSE err.", new Object[0]);
        }
    }

    public final void apg() {
        x.i("MicroMsg.BackupMoveServer", "startRequestNotify receive start request.");
        this.klF = false;
        b.aoR().aol().kiJ = 12;
        mz(12);
        com.tencent.mm.plugin.backup.g.d.aqe().aqh();
        if (this.klA != null) {
            long j;
            x.i("MicroMsg.BackupMoveServer", "transfer conversation size:%d", new Object[]{Integer.valueOf(this.klA.size())});
            o oVar = new o();
            oVar.ID = b.aoR().kiB;
            oVar.ktk = (long) this.klA.size();
            a aoV = b.aoR().aoV();
            if (aoV.aoO() == null) {
                j = 0;
            } else {
                Iterator it = aoV.aoO().iterator();
                j = 0;
                while (it.hasNext()) {
                    j = ((f$b) it.next()).kiS + j;
                }
            }
            oVar.ktl = j;
            oVar.ktm = 0;
            oVar.ktn = this.kle ? com.tencent.mm.plugin.backup.a.c.kis : com.tencent.mm.plugin.backup.a.c.kir;
            if (kki) {
                oVar.ktj = 3;
            }
            m mVar = new m();
            mVar.ksX = q.yF();
            mVar.ksY = Build.MANUFACTURER;
            mVar.ksZ = Build.MODEL;
            mVar.kta = "Android";
            mVar.ktb = VERSION.RELEASE;
            mVar.ktc = com.tencent.mm.protocal.d.vAz;
            mVar.ktd = 0;
            x.i("MicroMsg.BackupMoveServer", "startRequestNotify generalinfo wechatversion:%s", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.vAz)});
            oVar.kth = mVar;
            try {
                com.tencent.mm.plugin.backup.f.b.o(oVar.toByteArray(), 4, this.klI);
                x.i("MicroMsg.BackupMoveServer", "backupSendRequestSession sessionName[%d], startTime[%d], endTime[%d]", new Object[]{Integer.valueOf(this.klA.size()), Long.valueOf(this.klD), Long.valueOf(this.klE)});
                i iVar = new i();
                iVar.ksQ = this.klA;
                iVar.ksR = new LinkedList();
                Iterator it2 = this.klA.iterator();
                while (it2.hasNext()) {
                    it2.next();
                    iVar.ksR.add(Long.valueOf(r0));
                    iVar.ksR.add(Long.valueOf(j));
                }
                try {
                    x.i("MicroMsg.BackupMoveServer", "backupSendRequestSession, chooseConvNames size:%d", new Object[]{Integer.valueOf(this.klA.size())});
                    com.tencent.mm.plugin.backup.f.b.F(iVar.toByteArray(), 11);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.BackupMoveServer", e, "backupSendRequestSession BackupRequestSession parse req failed.", new Object[0]);
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.BackupMoveServer", "startRequestNotify prase startResp error!!");
                x.printErrStackTrace("MicroMsg.BackupMoveServer", e2, "", new Object[0]);
            }
        }
    }

    private static void apa() {
        com.tencent.mm.plugin.backup.h.a aVar = new com.tencent.mm.plugin.backup.h.a();
        aVar.ID = b.aoR().kiB;
        try {
            x.i("MicroMsg.BackupMoveServer", "backupSendCancelRequest.");
            com.tencent.mm.plugin.backup.f.b.F(aVar.toByteArray(), 5);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveServer", e, "buf to BackupCancelRequest err.", new Object[0]);
        }
    }

    public static String aph() {
        return com.tencent.mm.plugin.backup.f.b.apN();
    }

    public final void mz(int i) {
        if (this.kkd != null) {
            ag.y(new 1(this, i));
        }
    }

    public final void aoh() {
    }

    public final void aoi() {
        al(false);
    }

    private static LinkedList<com.tencent.mm.plugin.backup.a.f$a> b(LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        long j = 0;
        if (linkedList == null || linkedList2 == null || linkedList.isEmpty() || linkedList.size() * 2 != linkedList2.size()) {
            return null;
        }
        LinkedList<com.tencent.mm.plugin.backup.a.f$a> linkedList3 = new LinkedList();
        Iterator it = linkedList2.iterator();
        long j2 = 0;
        for (int i = 0; i < linkedList.size(); i++) {
            if (it.hasNext()) {
                j2 = ((Long) it.next()).longValue();
                if (it.hasNext()) {
                    j = ((Long) it.next()).longValue();
                }
            }
            linkedList3.add(new com.tencent.mm.plugin.backup.a.f$a(i, (String) linkedList.get(i), j2, j));
        }
        return linkedList3;
    }
}
