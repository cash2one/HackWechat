package com.tencent.mm.plugin.backup.backuppcmodel;

import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.plugin.backup.a.b.a;
import com.tencent.mm.plugin.backup.a.b.c;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.b.a.3;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.aa;
import com.tencent.mm.plugin.backup.h.af;
import com.tencent.mm.plugin.backup.h.ag;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.plugin.backup.h.j;
import com.tencent.mm.plugin.backup.h.n;
import com.tencent.mm.plugin.backup.h.o;
import com.tencent.mm.plugin.backup.h.y;
import com.tencent.mm.plugin.backup.h.z;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.m;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class d implements com.tencent.mm.plugin.backup.a.b.d {
    private static boolean kkZ = false;
    private static boolean knO = false;
    private long fwg = 0;
    private boolean hnr = false;
    private com.tencent.mm.plugin.backup.b.d kkQ;
    LinkedList<String> kkR;
    LinkedList<Long> kkS;
    private HashSet<String> kkW = new HashSet();
    private long kkX = 0;
    private long kkY = 0;
    private boolean kki = false;
    public Set<c> knP = new HashSet();
    public a knQ;
    private long knR = 0;
    private boolean knS = false;
    private final com.tencent.mm.plugin.backup.f.b.d knT = new 1(this);
    private Object lock = new Object();
    private long recvSize = 0;

    static /* synthetic */ void E(byte[] bArr, int i) {
        af afVar = (af) g.a(new af(), bArr);
        if (afVar == null) {
            x.e("MicroMsg.BackupPcRecoverServer", "requestBigFileSvrIdNotify PacketSvrIDRequest parse failed :%d", new Object[]{Integer.valueOf(bh.bx(bArr))});
            return;
        }
        ag agVar = new ag();
        agVar.kuj = afVar.kuj;
        agVar.kul = afVar.kul;
        agVar.kuk = afVar.kuk;
        agVar.ksM = afVar.ksM;
        try {
            x.i("MicroMsg.BackupPcRecoverServer", "requestBigFileSvrIdNotify send SvrID resp");
            b.o(agVar.toByteArray(), 14, i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "PacketSvrIDResponse to buf err.", new Object[0]);
        }
    }

    static /* synthetic */ void a(d dVar) {
        x.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify local disconnect, backupPcState[%d], isRecoverFinish[%b]", new Object[]{Integer.valueOf(b.aps().aol().kiJ), Boolean.valueOf(knO)});
        switch (b.aps().aol().kiJ) {
            case DownloadResult.CODE_URL_ERROR /*-21*/:
            case -13:
            case -5:
                b.aps().aoS().stop();
                return;
            case -4:
                dVar.a(true, false, 0);
                return;
            case 1:
            case 21:
                b.aps().aoS().stop();
                b.aps().aol().kiJ = -100;
                dVar.mz(-100);
                return;
            case 4:
            case 22:
            case 23:
                if (!b.aps().apt().knH || knO) {
                    x.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify not support reconnect, disconnect");
                    dVar.a(true, false, -4);
                    b.aps().aoS().stop();
                    com.tencent.mm.plugin.report.service.g.pQN.a(400, 17, 1, false);
                    dVar.mJ(3);
                    return;
                }
                switch (b.apP()) {
                    case 0:
                    case 2:
                        x.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify startBackupReconnectHandler, reconnectState[%d]", new Object[]{Integer.valueOf(b.apP())});
                        dVar.mJ(19);
                        dVar.knS = true;
                        b.a(b.aps().apt().knM);
                        return;
                    case 1:
                        x.i("MicroMsg.BackupPcRecoverServer", "networkDisconnectNotify already start reconnect, state[%d]", new Object[]{Integer.valueOf(b.apP())});
                        return;
                    default:
                        return;
                }
            case 27:
                b.aps().aoS().stop();
                b.aps().aol().kiJ = -100;
                dVar.mz(-100);
                return;
            default:
                return;
        }
    }

    static /* synthetic */ void a(d dVar, byte[] bArr) {
        x.i("MicroMsg.BackupPcRecoverServer", "finishReqNotify receive finishReq. hasReceiveFinishReq[%b]", new Object[]{Boolean.valueOf(kkZ)});
        if (kkZ) {
            x.e("MicroMsg.BackupPcRecoverServer", "finishReqNotify has receive finishReq, return.");
            return;
        }
        kkZ = true;
        if (g.a(new com.tencent.mm.plugin.backup.h.d(), bArr) == null) {
            x.e("MicroMsg.BackupPcRecoverServer", "finishReqNotify buf to BackupFinishRequest error, buflen[%d]", new Object[]{Integer.valueOf(bh.bx(bArr))});
        }
        ar.Hg();
        com.tencent.mm.z.c.CU().a(w.a.xte, Boolean.valueOf(false));
        b.apK();
        b.apM();
        knO = true;
        b.aps().aol().F(24, dVar.kkW.size(), dVar.kkR.size());
        dVar.mz(24);
        com.tencent.mm.plugin.report.service.g.pQN.a(400, 19, 1, false);
        dVar.knR = bh.Wp();
        com.tencent.mm.plugin.report.service.g.pQN.a(400, 20, (dVar.knR - dVar.kkX) / 1000, false);
        com.tencent.mm.plugin.report.service.g.pQN.a(400, 21, dVar.fwg / 1024, false);
        dVar.mJ(0);
        if (!dVar.knS) {
            dVar.mJ(21);
        }
        x.i("MicroMsg.BackupPcRecoverServer", "finishReqNotify recover success. hasEnterReconnect[%b], recoverCostTime[%d s], recoverStartTime[%d], recoverEndTime[%d], recoverTotalSize[%d kb]", new Object[]{Boolean.valueOf(dVar.knS), Long.valueOf(r10 / 1000), Long.valueOf(dVar.kkX), Long.valueOf(dVar.knR), Long.valueOf(dVar.fwg / 1024)});
    }

    static /* synthetic */ void a(d dVar, byte[] bArr, int i) {
        n nVar = (n) g.a(new n(), bArr);
        if (nVar == null || !b.aps().kiB.equals(nVar.ID)) {
            String str = "MicroMsg.BackupPcRecoverServer";
            String str2 = "startRequestNotify BackupStartRequest parseBuf:%d failed or wrong id[%s,%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(bh.bx(bArr));
            objArr[1] = nVar != null ? nVar.ID : "buf is null";
            objArr[2] = b.aps().kiB;
            x.e(str, str2, objArr);
            c(1, i, 0);
            dVar.a(false, false, -5);
            com.tencent.mm.plugin.report.service.g.pQN.a(400, 121, 1, false);
            return;
        }
        b.aps().aol().kiM = nVar.kte;
        if (nVar.ktj == 3) {
            dVar.kki = true;
            com.tencent.mm.plugin.report.service.g.pQN.a(400, 36, 1, false);
            x.i("MicroMsg.BackupPcRecoverServer", "isQuickBackup!!!");
        }
        long j = nVar.kti;
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        ar.Hg();
        g.a(pLong, pLong2, com.tencent.mm.z.c.FC());
        long j2 = (pLong2.value - ((long) (((double) j) * 0.1d > 5.24288E8d ? 5.24288E8d : ((double) j) * 0.1d))) / 1048576;
        dVar.kkX = bh.Wp();
        x.i("MicroMsg.BackupPcRecoverServer", "startRequestNotify time:%d SessionCount:%d, MsgCount:%d, DataSize:%d validSize:%d", new Object[]{Long.valueOf(dVar.kkX), Long.valueOf(nVar.ktf), Long.valueOf(nVar.ktg), Long.valueOf(j), Long.valueOf(j2)});
        if (j2 >= j) {
            c(0, i, j2);
            b.apJ();
            return;
        }
        x.e("MicroMsg.BackupPcRecoverServer", "startRequestNotify Not Enough Space:%d < dataSize:%d", new Object[]{Long.valueOf(j2), Long.valueOf(j)});
        c(2, i, j2);
        com.tencent.mm.plugin.backup.b.a aoS = b.aps().aoS();
        if (aoS.kiY == null) {
            aoS.stop();
        } else {
            aoS.kiY.postDelayed(new 3(aoS), 10);
        }
        b.aps().aol().kiJ = -13;
        dVar.mz(-13);
        com.tencent.mm.plugin.report.service.g.pQN.a(400, 6, 1, false);
        com.tencent.mm.plugin.report.service.g.pQN.h(13736, new Object[]{Integer.valueOf(5), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(b.aps().apt().knJ)});
    }

    static /* synthetic */ void b(d dVar, byte[] bArr, int i) {
        i iVar = (i) g.a(new i(), bArr);
        if (iVar == null) {
            x.e("MicroMsg.BackupPcRecoverServer", "requestSessionListNotify parseBuf failed:%d", new Object[]{Integer.valueOf(bh.bx(bArr))});
            b.aps().aol().kiJ = -21;
            dVar.mz(-21);
            return;
        }
        dVar.kkR = iVar.ksQ;
        dVar.kkS = iVar.ksR;
        if (dVar.kkS.size() != dVar.kkR.size() * 2) {
            dVar.a(false, false, -21);
            com.tencent.mm.plugin.report.service.g.pQN.a(400, 119, 1, false);
            return;
        }
        b.aps().aol().F(23, 1, dVar.kkR.size());
        dVar.mz(23);
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        ar.Hg().FM().a(dVar.kkR, dVar.kkS, linkedList, linkedList2);
        j jVar = new j();
        jVar.ksQ = linkedList;
        jVar.ksR = linkedList2;
        b.apL();
        try {
            x.i("MicroMsg.BackupPcRecoverServer", "requestSessionListNotify send requestsession resp, SessionName size:%d, TimeInterval size:%d", new Object[]{Integer.valueOf(dVar.kkR.size()), Integer.valueOf(linkedList2.size())});
            b.o(jVar.toByteArray(), 12, i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "BackupRequestSessionResponse to buf err.", new Object[0]);
        }
    }

    static /* synthetic */ void c(d dVar, byte[] bArr, int i) {
        com.tencent.mm.plugin.backup.h.x xVar = (com.tencent.mm.plugin.backup.h.x) g.a(new com.tencent.mm.plugin.backup.h.x(), bArr);
        if (xVar == null) {
            x.e("MicroMsg.BackupPcRecoverServer", "dataPushNotify parseBuf failed:%d", new Object[]{Integer.valueOf(bh.bx(bArr))});
            b("", 0, 0, 0, 1, i);
            return;
        }
        x.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify receive recoverData id:%s, type:%d, start:%d, end:%d, isCancel:%b", new Object[]{xVar.ktR, Integer.valueOf(xVar.ktS), Integer.valueOf(xVar.ktU), Integer.valueOf(xVar.ktV), Boolean.valueOf(dVar.hnr)});
        if (!dVar.hnr) {
            if (!(b.aps().kiH == null || xVar.ksB == null)) {
                xVar.ksB = new com.tencent.mm.bq.b(AesEcb.aesCryptEcb(xVar.ksB.oz, b.aps().kiH, false, xVar.ktV == xVar.ktT));
            }
            if (xVar.ktS == 1 && xVar.ksB != null) {
                x.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify receive datapush text dataid:%s, dir:%s", new Object[]{xVar.ktR, g.vl(xVar.ktR)});
                g.b(r2, xVar);
                dVar.recvSize += (long) xVar.ksB.oz.length;
            }
            if (xVar.ktS == 2) {
                x.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify receive datapush media dataid:%s, dir:%s", new Object[]{xVar.ktR, g.vm(xVar.ktR)});
                g.a(r2, xVar);
                dVar.recvSize += (long) xVar.ksB.oz.length;
            }
            x.i("MicroMsg.BackupPcRecoverServer", "dataPushNotify recvSize/convDataSize: %d, %d", new Object[]{Long.valueOf(dVar.recvSize), Long.valueOf(dVar.fwg)});
            if (dVar.fwg < dVar.recvSize) {
                dVar.fwg = dVar.recvSize;
            }
            b(xVar.ktR, xVar.ktS, xVar.ktU, xVar.ktV, 0, i);
        }
    }

    static /* synthetic */ void d(d dVar, byte[] bArr, int i) {
        z zVar = (z) g.a(new z(), bArr);
        if (zVar == null) {
            x.e("MicroMsg.BackupPcRecoverServer", "SendTagNotify PacketBackupDataTag parse failed:%d", new Object[]{Integer.valueOf(bh.bx(bArr))});
            return;
        }
        x.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify receive tagReq, MsgDataID:%s, BakChatName:%s, StartTime:%d, EndTime:%d,  NickName:%s, isCancel:%b", new Object[]{zVar.kua, zVar.ksM, Long.valueOf(zVar.ktY), Long.valueOf(zVar.ktZ), zVar.kub, Boolean.valueOf(dVar.hnr)});
        if (!dVar.hnr) {
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xte, Boolean.valueOf(true));
            if (ar.Hg().FN().Ws(zVar.kua) != null) {
                x.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify the same tag has received, ignore. MsgDataID:%s", new Object[]{zVar.kua});
            } else {
                com.tencent.mm.sdk.e.c kVar = new k();
                kVar.field_msgListDataId = zVar.kua;
                kVar.field_sessionName = zVar.ksM;
                x.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify insert BackupRecoverMsgListDataIdStorage ret[%b], systemRowid[%d]", new Object[]{Boolean.valueOf(ar.Hg().FN().b(kVar)), Long.valueOf(kVar.xjy)});
                kVar = new m();
                kVar.field_sessionName = zVar.ksM;
                kVar.field_startTime = zVar.ktY;
                kVar.field_endTime = zVar.ktZ;
                x.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify insert BackupTempMoveTimeStorage ret[%b], systemRowid[%d]", new Object[]{Boolean.valueOf(ar.Hg().FM().b(kVar)), Long.valueOf(kVar.xjy)});
            }
            dVar.kkW.add(zVar.ksM);
            b.aps().aol().F(23, dVar.kkW.size() < dVar.kkR.size() ? dVar.kkW.size() : dVar.kkR.size(), dVar.kkR.size());
            dVar.mz(23);
            aa aaVar = new aa();
            aaVar.ksM = zVar.ksM;
            aaVar.ktY = zVar.ktY;
            aaVar.ktZ = zVar.ktZ;
            aaVar.kua = zVar.kua;
            try {
                x.i("MicroMsg.BackupPcRecoverServer", "SendTagNotify send tag resp");
                b.o(aaVar.toByteArray(), 16, i);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "SendTagNotify buf to PacketBackupDataTagResponse err.", new Object[0]);
            }
        }
    }

    public static void apB() {
        knO = true;
    }

    public final void init() {
        x.i("MicroMsg.BackupPcRecoverServer", "init");
        this.knS = false;
        knO = false;
        kkZ = false;
        b.a(this.knT);
        this.fwg = 0;
        this.recvSize = 0;
        this.hnr = false;
        this.kki = false;
        this.kkW.clear();
    }

    public static boolean aoW() {
        return ar.Hg().FN().chN();
    }

    public final void aoX() {
        x.i("MicroMsg.BackupPcRecoverServer", "clearContinueRecoverData");
        this.kkW.clear();
    }

    public final void a(boolean z, boolean z2, int i) {
        int i2 = 0;
        x.i("MicroMsg.BackupPcRecoverServer", "cancel isSelf[%b], needClearContinueRecoverData[%b], caller:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), ai.cfH()});
        knO = true;
        if (!z) {
            b.aps().apt();
            c.apa();
        }
        synchronized (this.lock) {
            this.hnr = true;
            if (this.kkQ != null) {
                this.kkQ.h(z2, i);
                this.kkQ = null;
            } else {
                i2 = 1;
            }
        }
        if (!(i2 == 0 || i == 0)) {
            b.aps().aol().kiJ = i;
            mz(i);
        }
        if (z2) {
            aoX();
        }
        b.apK();
        b.apM();
        b.apO();
    }

    public final void mJ(int i) {
        long j = 0;
        if (this.kkX != 0) {
            j = bh.bz(this.kkX);
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(13737, new Object[]{Integer.valueOf(i), Long.valueOf(this.fwg / 1024), Long.valueOf(j / 1000), Integer.valueOf(2), Integer.valueOf(b.aps().apt().knJ)});
        x.i("MicroMsg.BackupPcRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d kb], recoverCostTime[%d s]", new Object[]{Integer.valueOf(13737), Integer.valueOf(i), Long.valueOf(this.fwg / 1024), Long.valueOf(j / 1000)});
    }

    private static void b(String str, int i, int i2, int i3, int i4, int i5) {
        y yVar = new y();
        yVar.ktR = str;
        yVar.ktS = i;
        yVar.ktU = i2;
        yVar.ktV = i3;
        yVar.ktm = i4;
        try {
            b.o(yVar.toByteArray(), 7, i5);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "sendResp", new Object[0]);
        }
    }

    private static void c(int i, int i2, long j) {
        o oVar = new o();
        oVar.ID = b.aps().kiB;
        oVar.ktm = i;
        oVar.kth = g.bH(j);
        try {
            x.i("MicroMsg.BackupPcRecoverServer", "send start resp, status[%d]", new Object[]{Integer.valueOf(i)});
            b.o(oVar.toByteArray(), 4, i2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPcRecoverServer", e, "buf to BackupStartRequest err.", new Object[0]);
        }
    }

    public final void aoC() {
        synchronized (this.lock) {
            if (this.hnr) {
                x.e("MicroMsg.BackupPcRecoverServer", "startMerge isCancel true.");
            } else if (this.kkQ == null || !this.kkQ.kjZ) {
                int chO;
                if (this.kkQ != null) {
                    this.kkQ.h(false, 0);
                }
                if (this.kkW == null || this.kkW.size() <= 0) {
                    chO = ar.Hg().FN().chO();
                } else {
                    chO = this.kkW.size();
                }
                b.aps().aol().F(26, 1, chO);
                mz(26);
                if (this.kkR == null) {
                    this.kkR = new LinkedList();
                }
                if (this.kkS == null) {
                    this.kkS = new LinkedList();
                }
                this.kkY = bh.Wp();
                this.kkQ = new com.tencent.mm.plugin.backup.b.d(b.aps(), 1, this, chO, this.kki, this.kkR, this.kkS);
                this.kkQ.aoC();
                com.tencent.mm.plugin.report.service.g.pQN.a(400, 24, 1, false);
            } else {
                x.e("MicroMsg.BackupPcRecoverServer", "startMerge hasStartMerge, return.");
            }
        }
    }

    public final void mz(int i) {
        Set hashSet = new HashSet();
        hashSet.addAll(this.knP);
        com.tencent.mm.sdk.platformtools.ag.y(new 3(this, hashSet, i));
        if (this.knQ != null) {
            com.tencent.mm.sdk.platformtools.ag.y(new 4(this, i));
        }
    }

    public final void aok() {
        aoX();
        com.tencent.mm.plugin.report.service.g.pQN.a(400, 27, 1, false);
        com.tencent.mm.plugin.report.service.g.pQN.a(400, 28, bh.bz(this.kkY) / 1000, false);
        b.apK();
        b.apM();
    }
}
