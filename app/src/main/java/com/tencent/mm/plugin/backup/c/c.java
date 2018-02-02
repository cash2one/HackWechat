package com.tencent.mm.plugin.backup.c;

import android.database.Cursor;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.ae.e;
import com.tencent.mm.plugin.backup.a.b.d;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.b.a$a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.h.aa;
import com.tencent.mm.plugin.backup.h.af;
import com.tencent.mm.plugin.backup.h.ag;
import com.tencent.mm.plugin.backup.h.f;
import com.tencent.mm.plugin.backup.h.i;
import com.tencent.mm.plugin.backup.h.y;
import com.tencent.mm.plugin.backup.h.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.j;
import com.tencent.mm.storage.k;
import com.tencent.mm.storage.m;
import com.tencent.mm.storage.n;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class c implements d, b.d {
    private static int hkU = 0;
    private static boolean kkZ = false;
    private static boolean kla = false;
    private static boolean klo = false;
    String ffq;
    private long fwg = 0;
    private boolean hnr = false;
    private com.tencent.mm.plugin.backup.b.d kkQ;
    private LinkedList<String> kkR;
    private LinkedList<Long> kkS;
    private LinkedList<String> kkT;
    private LinkedList<Long> kkU;
    public com.tencent.mm.plugin.backup.a.b.a kkV;
    private HashSet<String> kkW = new HashSet();
    private long kkX = 0;
    private long kkY = 0;
    public d kkd;
    private boolean kki = false;
    private boolean klb = true;
    private HashSet<String> klc = new HashSet();
    private int kld = 0;
    public boolean kle = false;
    private boolean klf = true;
    private boolean klg = true;
    private boolean klh = false;
    private boolean kli = false;
    private int klj;
    public String klk;
    String kll;
    int klm;
    private ak kln;
    final e klp = new 1(this);
    private final e klq = new 6(this);
    private final e klr = new 7(this);
    public long kls;
    private int klt;
    com.tencent.mm.plugin.backup.f.b.c klu = new 11(this);
    private final com.tencent.mm.plugin.backup.f.f.a klv = new 12(this);
    private final com.tencent.mm.plugin.backup.f.i.a klw = new 2(this);
    private Object lock = new Object();
    private long recvSize = 0;

    private class a {
        byte[] buf;
        int hOH;
        boolean jtk = false;
        final /* synthetic */ c klx;
        int type;

        a(c cVar, boolean z, int i, int i2, byte[] bArr) {
            this.klx = cVar;
            this.hOH = i;
            this.type = i2;
            this.buf = (byte[]) bArr.clone();
        }
    }

    static /* synthetic */ void D(byte[] bArr, int i) {
        af afVar = (af) g.a(new af(), bArr);
        if (afVar == null) {
            x.e("MicroMsg.BackupMoveRecoverServer", "requestBigFileSvrIdNotify PacketSvrIDRequest parse failed :%d", Integer.valueOf(bh.bx(bArr)));
            return;
        }
        ag agVar = new ag();
        agVar.kuj = afVar.kuj;
        agVar.kul = afVar.kul;
        agVar.kuk = afVar.kuk;
        agVar.ksM = afVar.ksM;
        try {
            x.i("MicroMsg.BackupMoveRecoverServer", "send SvrID resp");
            b.o(agVar.toByteArray(), 14, i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to PacketSvrIDResponse err.", new Object[0]);
        }
    }

    static /* synthetic */ void a(c cVar, byte[] bArr) {
        x.i("MicroMsg.BackupMoveRecoverServer", "finishReqNotify receive finishReq. hasReceiveFinishReq[%b]", Boolean.valueOf(kkZ));
        if (kkZ) {
            x.e("MicroMsg.BackupMoveRecoverServer", "finishReqNotify has receive finishReq, return.");
            return;
        }
        kkZ = true;
        if (g.a(new com.tencent.mm.plugin.backup.h.d(), bArr) == null) {
            x.e("MicroMsg.BackupMoveRecoverServer", "finishReqNotify buf to BackupFinishRequest error, buflen[%d]", Integer.valueOf(bh.bx(bArr)));
        }
        b.aoR().aoS().kiZ = null;
        ar.Hg();
        com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.valueOf(false));
        b.apK();
        b.apM();
        b.aoR().aol().F(24, cVar.kkW.size(), cVar.kkR.size());
        cVar.mz(24);
        long bz = bh.bz(cVar.kkX);
        long j = bz != 0 ? ((cVar.fwg / 1024) * 1000) / bz : 0;
        com.tencent.mm.plugin.report.service.g.pQN.a(485, 45, 1, false);
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pQN;
        int i = (cVar.kle || cVar.kld == 1) ? 68 : 67;
        gVar.a(485, (long) i, 1, false);
        com.tencent.mm.plugin.report.service.g.pQN.a(485, 61, bz / 1000, false);
        com.tencent.mm.plugin.report.service.g.pQN.a(485, 62, cVar.fwg / 1024, false);
        gVar = com.tencent.mm.plugin.report.service.g.pQN;
        i = (cVar.kle || cVar.kld == 1) ? 70 : 69;
        gVar.a(485, (long) i, j, false);
        cVar.mD(1);
        if (!kla) {
            cVar.mD(2);
        }
        x.i("MicroMsg.BackupMoveRecoverServer", "finishReqNotify recover success. recoverCostTime[%d s], recoverTotalSize[%d kb]", Long.valueOf(bz / 1000), Long.valueOf(cVar.fwg / 1024));
    }

    static /* synthetic */ void a(c cVar, byte[] bArr, int i) {
        if (b.aoR().aol().kiJ == -13) {
            x.e("MicroMsg.BackupMoveRecoverServer", "receive requestSession request, but no enough space for recover, quit.");
            return;
        }
        i iVar = (i) g.a(new i(), bArr);
        if (iVar == null) {
            x.e("MicroMsg.BackupMoveRecoverServer", "requestSessionListNotify parseBuf failed:%d", Integer.valueOf(bh.bx(bArr)));
            b.aoR().aol().kiJ = -21;
            cVar.mz(-21);
            return;
        }
        x.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive requestSession request, SessionName size:%d, TimeInterval size:%d", Integer.valueOf(iVar.ksQ.size()), Integer.valueOf(iVar.ksR.size()));
        cVar.kkR = iVar.ksQ;
        cVar.kkS = iVar.ksR;
        if (cVar.kkS.size() != cVar.kkR.size() * 2) {
            apa();
            b.aoR().aol().kiJ = -21;
            cVar.mz(-21);
            return;
        }
        cVar.klt = i;
        if (cVar.klh) {
            cVar.dD(cVar.kli);
            return;
        }
        long j;
        j FL = ar.Hg().FL();
        String str = "SELECT * FROM BackupMoveTime WHERE deviceId = \"" + cVar.ffq + "\"";
        x.d("MicroMsg.BackupMoveTimeStorage", "getCountByDevice:" + str);
        Cursor rawQuery = FL.gJP.rawQuery(str, null);
        if (rawQuery == null) {
            x.e("MicroMsg.BackupMoveTimeStorage", "getCountByDevice failed, deviceid:%s", r1);
            j = 0;
        } else {
            j = (long) rawQuery.getCount();
            rawQuery.close();
        }
        if (j > 0) {
            b.aoR().aol().kiJ = 52;
            cVar.mz(52);
            return;
        }
        cVar.dD(true);
    }

    static /* synthetic */ void b(c cVar, byte[] bArr, int i) {
        if (cVar.klb) {
            cVar.klb = false;
        }
        com.tencent.mm.plugin.backup.h.x xVar = (com.tencent.mm.plugin.backup.h.x) g.a(new com.tencent.mm.plugin.backup.h.x(), bArr);
        if (xVar == null) {
            x.e("MicroMsg.BackupMoveRecoverServer", "dataPushNotify parseBuf failed:%d", Integer.valueOf(bh.bx(bArr)));
            b("", 0, 0, 0, 1, i);
            return;
        }
        x.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify recoverData id:%s, type:%d, start:%d, end:%d", xVar.ktR, Integer.valueOf(xVar.ktS), Integer.valueOf(xVar.ktU), Integer.valueOf(xVar.ktV));
        if (xVar.ktS == 1 && xVar.ksB != null) {
            x.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify text dataid:%s, dir:%s", xVar.ktR, g.vl(xVar.ktR));
            g.b(r2, xVar);
            cVar.recvSize += (long) xVar.ksB.oz.length;
        }
        if (xVar.ktS == 2) {
            x.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify datapush media dataid:%s, dir:%s", xVar.ktR, g.vm(xVar.ktR));
            g.a(r2, xVar);
            cVar.recvSize += (long) xVar.ksB.oz.length;
            cVar.klc.add(xVar.ktR);
        }
        x.i("MicroMsg.BackupMoveRecoverServer", "dataPushNotify recvSize/convDataSize: %d, %d", Long.valueOf(cVar.recvSize), Long.valueOf(cVar.fwg));
        if (cVar.fwg < cVar.recvSize) {
            cVar.fwg = cVar.recvSize;
        }
        b(xVar.ktR, xVar.ktS, xVar.ktU, xVar.ktV, 0, i);
    }

    static /* synthetic */ void c(c cVar, byte[] bArr, int i) {
        z zVar = (z) g.a(new z(), bArr);
        if (zVar == null) {
            x.e("MicroMsg.BackupMoveRecoverServer", "SendTagNotify PacketBackupDataTag parse failed:%d", Integer.valueOf(bh.bx(bArr)));
            return;
        }
        x.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive tag, MsgDataID:%s, BakChatName:%s, StartTime:%d, EndTime:%d,  NickName:%s", zVar.kua, zVar.ksM, Long.valueOf(zVar.ktY), Long.valueOf(zVar.ktZ), zVar.kub);
        ar.Hg();
        com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.USERINFO_BACKUP_MOVE_RECOVERING_BOOLEAN, Boolean.valueOf(true));
        if (ar.Hg().FN().Ws(zVar.kua) != null) {
            x.i("MicroMsg.BackupMoveRecoverServer", "summerbak the same tag has received, ignore. MsgDataID:%s", zVar.kua);
        } else {
            Object obj;
            com.tencent.mm.sdk.e.c kVar = new k();
            kVar.field_msgListDataId = zVar.kua;
            kVar.field_sessionName = zVar.ksM;
            x.i("MicroMsg.BackupMoveRecoverServer", "tagReqNotify insert BackupRecoverMsgListDataIdStorage ret[%b], systemRowid[%d]", Boolean.valueOf(ar.Hg().FN().b(kVar)), Long.valueOf(kVar.xjy));
            n FM = ar.Hg().FM();
            String str = zVar.ksM;
            String str2 = "SELECT * FROM BackupTempMoveTime WHERE sessionName = \"" + str + "\"  AND startTime = " + zVar.ktY + " AND endTime = " + zVar.ktZ;
            x.d("MicroMsg.BackupTempMoveTimeStorage", "isTempMoveTimeExist:" + str2);
            Cursor rawQuery = FM.gJP.rawQuery(str2, null);
            if (rawQuery == null) {
                x.e("MicroMsg.BackupTempMoveTimeStorage", "isTempMoveTimeExist failed, sessionName[%s], startTime[%d], endTime[%d] ", str, Long.valueOf(r4), Long.valueOf(r6));
                obj = null;
            } else if (rawQuery.moveToNext()) {
                rawQuery.close();
                obj = 1;
            } else {
                rawQuery.close();
                obj = null;
            }
            if (obj == null) {
                kVar = new m();
                kVar.field_sessionName = zVar.ksM;
                kVar.field_startTime = zVar.ktY;
                kVar.field_endTime = zVar.ktZ;
                x.i("MicroMsg.BackupMoveRecoverServer", "tagReqNotify insert BackupTempMoveTimeStorage ret[%b], systemRowid[%d]", Boolean.valueOf(ar.Hg().FM().b(kVar)), Long.valueOf(kVar.xjy));
            }
        }
        cVar.kkW.add(zVar.ksM);
        b.aoR().aol().F(23, cVar.kkW.size() < cVar.kkR.size() ? cVar.kkW.size() : cVar.kkR.size(), cVar.kkR.size());
        cVar.mz(23);
        aa aaVar = new aa();
        aaVar.ksM = zVar.ksM;
        aaVar.ktY = zVar.ktY;
        aaVar.ktZ = zVar.ktZ;
        aaVar.kua = zVar.kua;
        try {
            x.i("MicroMsg.BackupMoveRecoverServer", "SendTagNotify send tag resp");
            b.o(aaVar.toByteArray(), 16, i);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "summerbak buf to PacketBackupDataTagResponse err.", new Object[0]);
        }
    }

    static /* synthetic */ void h(c cVar) {
        x.i("MicroMsg.BackupMoveRecoverServer", "move recover init");
        kkZ = false;
        kla = false;
        cVar.fwg = 0;
        cVar.recvSize = 0;
        cVar.hnr = false;
        cVar.kkW.clear();
        cVar.klb = true;
        cVar.klc.clear();
    }

    public static boolean aoW() {
        return ar.Hg().FN().chN();
    }

    public final void aoX() {
        x.i("MicroMsg.BackupMoveRecoverServer", "recover clearContinueRecoverData");
        this.kkW.clear();
    }

    public final void a(boolean z, boolean z2, int i) {
        int i2 = 0;
        x.i("MicroMsg.BackupMoveRecoverServer", "cancel backupMoveRecoverServer cancel isSelf[%b], needClearContinueRecoverData[%b], updateState[%d], caller:%s", Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), ai.cfH());
        if (!z) {
            apa();
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
            b.aoR().aol().kiJ = i;
            mz(i);
        }
        if (z2) {
            aoX();
        }
        b.apK();
        b.apM();
        b.aoR().aoS().kiZ = null;
    }

    private void aR(String str, int i) {
        boolean z = true;
        b.aoR().aoS().connect(str, i);
        b.a(1, this.klq);
        try {
            if (bh.getInt(com.tencent.mm.k.g.zY().getValue("ChattingRecordsKvstatDisable"), 0) != 0) {
                z = false;
            }
            this.klg = z;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "getInt", new Object[0]);
        }
        com.tencent.mm.plugin.backup.f.a aVar = new com.tencent.mm.plugin.backup.f.a(b.aoR().kiC, b.aoR().kiD, com.tencent.mm.plugin.backup.a.d.aop(), b.aoR().kiB, com.tencent.mm.plugin.backup.a.c.kit, 22);
        aVar.o(this.klg, false);
        aVar.apQ();
        x.i("MicroMsg.BackupMoveRecoverServer", "tryConnect start connect timehandler.");
        if (this.kln == null) {
            this.kln = new ak(new 5(this), false);
        }
        this.kln.J(3000, 3000);
    }

    private void aoY() {
        String str = this.klk;
        String str2 = this.kll;
        String cl = g.cl(ac.getContext());
        x.e("MicroMsg.BackupMoveRecoverServer", "connect failed thisWifi:%s, oldPhoneWifiName:%s, oldPhoneIpAddress:%s, tryCount:%d", cl, str, str2, Integer.valueOf(hkU));
        if (cl == null || cl.equals("")) {
            com.tencent.mm.plugin.report.service.g.pQN.a(485, 1, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.h(11787, Integer.valueOf(1));
            b.aoR().aol().kiJ = -1;
            mz(-1);
        } else if (str == null || !str.equals(cl)) {
            com.tencent.mm.plugin.report.service.g.pQN.a(485, 2, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.h(11787, Integer.valueOf(2));
            b.aoR().aol().kiJ = -2;
            mz(-2);
        } else if (!g.vo(str2)) {
            com.tencent.mm.plugin.report.service.g.pQN.a(485, 3, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.h(11787, Integer.valueOf(3));
            b.aoR().aol().kiJ = -3;
            mz(-3);
        } else if (hkU <= 0) {
            b.aoR().aol().kiJ = -5;
            mz(-5);
            com.tencent.mm.plugin.report.service.g.pQN.a(485, 4, 1, false);
            com.tencent.mm.plugin.report.service.g.pQN.h(11787, Integer.valueOf(6));
        } else {
            hkU--;
            aR(this.kll, this.klm);
        }
    }

    public final void a(boolean z, final int i, final byte[] bArr, final int i2) {
        String str = "MicroMsg.BackupMoveRecoverServer";
        String str2 = "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        x.i(str, str2, objArr);
        if (z && CdnLogic.kMediaTypeBeatificFile == i) {
            x.i("MicroMsg.BackupMoveRecoverServer", "summerbak local disconnect, backupMoveState:%d", Integer.valueOf(b.aoR().aol().kiJ));
            switch (b.aoR().aol().kiJ) {
                case DownloadResult.CODE_URL_ERROR /*-21*/:
                case -13:
                case -5:
                    b.aoR().aoS().stop();
                    return;
                case -4:
                    a(true, false, 0);
                    return;
                case 1:
                    b.aoR().aoS().stop();
                    if (klo) {
                        b.aoR().aol().kiJ = -4;
                        mz(-4);
                        return;
                    }
                    if (this.kln != null) {
                        x.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify stop backupConnectTimerHandler.");
                        this.kln.TG();
                    }
                    aoY();
                    return;
                case 22:
                case 23:
                    a(true, false, -4);
                    b.aoR().aoS().stop();
                    kla = true;
                    com.tencent.mm.plugin.report.service.g.pQN.a(485, 43, 1, false);
                    mD(4);
                    long j = 0;
                    if (this.kkX != 0) {
                        j = bh.bz(this.kkX);
                    }
                    x.i("MicroMsg.BackupMoveRecoverServer", "processNetworkNotify recover transfer disconnect, recoverDataSize:%d, recoverCostTime:%d", Long.valueOf(this.fwg), Long.valueOf(j));
                    return;
                default:
                    return;
            }
        } else if (i == 9) {
            com.tencent.mm.plugin.backup.h.e eVar = (com.tencent.mm.plugin.backup.h.e) g.a(new com.tencent.mm.plugin.backup.h.e(), bArr);
            if (eVar == null) {
                x.e("MicroMsg.BackupMoveRecoverServer", "heartBeatRequest parseBuf failed:%d", Integer.valueOf(bh.bx(bArr)));
                return;
            }
            x.i("MicroMsg.BackupMoveRecoverServer", "summerbak receive heartbeat req, req:%s ack:%d", eVar, Long.valueOf(eVar.kph));
            f fVar = new f();
            fVar.kph = eVar.kph;
            try {
                x.i("MicroMsg.BackupMoveRecoverServer", "summerbak send heartbeat resp");
                b.o(fVar.toByteArray(), 10, i2);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "summerbak buf to BackupHeartBeatResponse err.", new Object[0]);
            }
        } else if (i == 10) {
            f fVar2 = (f) g.a(new f(), bArr);
            str2 = "MicroMsg.BackupMoveRecoverServer";
            String str3 = "summerbak receive heartbeat response, resp:%s ack:%d";
            Object[] objArr2 = new Object[2];
            objArr2[0] = fVar2;
            objArr2[1] = Long.valueOf(fVar2 != null ? fVar2.kph : -1);
            x.i(str2, str3, objArr2);
        } else {
            if (i == 5) {
                com.tencent.mm.plugin.report.service.g.pQN.a(485, 51, 1, false);
                a(true, false, -100);
            }
            ar.Dm().F(new Runnable(this) {
                final /* synthetic */ c klx;

                public final void run() {
                    if (i == 11) {
                        c.a(this.klx, bArr, i2);
                    } else if (i == 6) {
                        c.b(this.klx, bArr, i2);
                    } else if (i == 13) {
                        c.D(bArr, i2);
                    } else if (i == 15) {
                        c.c(this.klx, bArr, i2);
                    } else if (i == 8) {
                        c.a(this.klx, bArr);
                    }
                }
            });
        }
    }

    public final void dD(boolean z) {
        this.kli = z;
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        b.aoR().aoS().kiZ = new a$a(this) {
            final /* synthetic */ c klx;

            public final void a(int i, int i2, byte[] bArr) {
                while (!this.klx.hnr) {
                    try {
                        if (linkedBlockingQueue.offer(new a(this.klx, false, i, i2, bArr), 500, TimeUnit.MILLISECONDS)) {
                            break;
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.BackupMoveRecoverServer", "onBackupMoveRecoverDatapushCallback e:%s", e.getMessage());
                    }
                }
                x.i("MicroMsg.BackupMoveRecoverServer", "summerbak offer datapushQueue, datapushQueue size:%d", Integer.valueOf(linkedBlockingQueue.size()));
            }
        };
        com.tencent.mm.sdk.f.e.b(new 10(this, linkedBlockingQueue), "onNotifyWorker").start();
        this.kkT = new LinkedList();
        this.kkU = new LinkedList();
        ar.Hg().FM().a(this.kkR, this.kkS, this.kkT, this.kkU);
        if (!(this.kki || z)) {
            LinkedList linkedList = this.kkT;
            LinkedList linkedList2 = this.kkU;
            this.kkT = new LinkedList();
            this.kkU = new LinkedList();
            ar.Hg().FL().a(this.ffq, linkedList, linkedList2, this.kkT, this.kkU);
        }
        com.tencent.mm.plugin.backup.h.j jVar = new com.tencent.mm.plugin.backup.h.j();
        jVar.ksQ = this.kkT;
        jVar.ksR = this.kkU;
        try {
            x.i("MicroMsg.BackupMoveRecoverServer", "summerbak send requestsession resp, SessionName size:%d, TimeInterval size:%d", Integer.valueOf(this.kkR.size()), Integer.valueOf(jVar.ksR.size()));
            b.o(jVar.toByteArray(), 12, this.klt);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to BackupRequestSessionResponse err.", new Object[0]);
        }
        b.apL();
        b.aoR().aol().F(23, 1, this.kkR.size());
        mz(23);
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
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "sendResp", new Object[0]);
        }
    }

    public final void mD(int i) {
        long j = 0;
        if (this.kkX != 0) {
            j = bh.bz(this.kkX);
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(11789, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(this.klj), Long.valueOf(this.fwg / 1024), Long.valueOf(j / 1000));
        x.i("MicroMsg.BackupMoveRecoverServer", "backupPcServerKvStat kvNum[%d], errcode[%d], backupDataSize[%d KB], recoverCostTime[%d s]", Integer.valueOf(11789), Integer.valueOf(i), Long.valueOf(this.fwg / 1024), Long.valueOf(j / 1000));
    }

    public final void aoC() {
        synchronized (this.lock) {
            if (this.hnr) {
                x.e("MicroMsg.BackupMoveRecoverServer", "startMerge isCancel true.");
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
                b.aoR().aol().F(26, 1, chO);
                mz(26);
                this.kkY = bh.Wp();
                this.kkQ = new com.tencent.mm.plugin.backup.b.d(b.aoR(), 22, this, chO, false, new LinkedList(), new LinkedList());
                this.kkQ.aoC();
                com.tencent.mm.plugin.report.service.g.pQN.a(485, 46, 1, false);
            } else {
                x.e("MicroMsg.BackupMoveRecoverServer", "startMerge hasStartMerge, return.");
            }
        }
    }

    public static String aoZ() {
        return b.apN();
    }

    private static void apa() {
        com.tencent.mm.plugin.backup.h.a aVar = new com.tencent.mm.plugin.backup.h.a();
        aVar.ID = b.aoR().kiB;
        try {
            x.i("MicroMsg.BackupMoveRecoverServer", "send cancel req.");
            b.F(aVar.toByteArray(), 5);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupMoveRecoverServer", e, "buf to BackupCancelRequest err.", new Object[0]);
        }
    }

    public final void mz(int i) {
        if (this.kkd != null) {
            com.tencent.mm.sdk.platformtools.ag.y(new 3(this, i));
        }
        if (this.kkV != null) {
            com.tencent.mm.sdk.platformtools.ag.y(new 4(this, i));
        }
    }

    public final void aok() {
        com.tencent.mm.plugin.report.service.g.pQN.a(485, 49, 1, false);
        com.tencent.mm.plugin.report.service.g.pQN.a(485, 50, bh.bz(this.kkY) / 1000, false);
        ar.Hg();
        com.tencent.mm.z.c.CU().a(com.tencent.mm.storage.w.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(true));
        x.i("MicroMsg.BackupMoveRecoverServer", "move recover finish, make BACKUP_MOVE_RECORDS.");
        if (!this.kki) {
            n FM = ar.Hg().FM();
            LinkedList linkedList = new LinkedList();
            Cursor Tj = FM.Tj();
            if (Tj == null) {
                x.e("MicroMsg.BackupTempMoveTimeStorage", "getAllData failed.");
            } else {
                while (Tj.moveToNext()) {
                    m mVar = new m();
                    mVar.b(Tj);
                    linkedList.add(mVar);
                }
                Tj.close();
            }
            if (linkedList.size() <= 0) {
                x.e("MicroMsg.BackupMoveRecoverServer", "merge finish and BackupTempMoveTimeStorage is empty!");
            } else {
                x.i("MicroMsg.BackupMoveRecoverServer", "merge finish and start update BackupMoveTimeStorage!");
                ar.Hg().FL().d(this.ffq, linkedList);
            }
        }
        aoX();
        b.apK();
        b.apM();
    }
}
