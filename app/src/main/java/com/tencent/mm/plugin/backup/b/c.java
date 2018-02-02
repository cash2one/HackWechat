package com.tencent.mm.plugin.backup.b;

import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.g.b.aj;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.e.h;
import com.tencent.mm.plugin.backup.e.h.a;
import com.tencent.mm.plugin.backup.h.u;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;
import com.tencent.mm.z.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import junit.framework.Assert;

public final class c {
    private int kiF;
    boolean kjn = false;
    com.tencent.mm.plugin.backup.a.b.b kjo;
    d kjp;
    long kjq = 0;
    public long kjr = 0;

    private class b {
        String TAG;
        String bgo;
        boolean iQP;
        int kiO;
        long kiQ;
        long kiR;
        a kjA;
        long kjB;
        String kjC;
        Vector<String> kjD;
        Vector<er> kjE;
        HashMap<Long, a> kjF;
        long kjG;
        private final com.tencent.mm.plugin.backup.f.c.b kjH;
        private final Runnable kjI;
        final Runnable kjJ;
        final /* synthetic */ c kjv;
        LinkedBlockingQueue<Runnable> kjz;
        String talker;

        public final String toString() {
            return this.TAG;
        }

        public b(c cVar, a aVar, f.a aVar2) {
            String L;
            this.kjv = cVar;
            this.TAG = "";
            this.kjz = new LinkedBlockingQueue();
            this.kiQ = 0;
            this.kiR = 0;
            this.kjB = 0;
            this.kjC = "";
            this.kjD = new Vector();
            this.kjE = new Vector();
            this.kjF = new HashMap();
            this.kjG = 0;
            this.iQP = false;
            this.kjH = new 1(this);
            this.kjI = new 3(this);
            this.kjJ = new Runnable(this) {
                final /* synthetic */ b kjK;

                {
                    this.kjK = r1;
                }

                public final String toString() {
                    return this.kjK.TAG + ".sendTag";
                }

                public final void run() {
                    Assert.assertTrue(toString() + ", check running. ", this.kjK.iQP);
                    int i;
                    e aol;
                    switch (d.aoo()) {
                        case 1:
                            x.i(this.kjK.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[]{Integer.valueOf(this.kjK.kjv.kjp.aol().kiK), Long.valueOf(this.kjK.kiQ), Long.valueOf(this.kjK.kiR), Integer.valueOf(this.kjK.kjD.size()), this.kjK.bgo, this.kjK.kjC, Long.valueOf(bh.bz(this.kjK.kjG))});
                            if (this.kjK.kjv.kjp.aol().kiK < this.kjK.kiO + 1) {
                                i = this.kjK.kjv.kjp.aol().kiL;
                                aol = this.kjK.kjv.kjp.aol();
                                if (this.kjK.kiO + 1 <= i) {
                                    i = this.kjK.kiO + 1;
                                }
                                aol.kiK = i;
                                this.kjK.kjv.kjo.mz(this.kjK.kjv.kjp.aol().kiJ);
                                break;
                            }
                            break;
                        case 21:
                        case 22:
                            x.i(this.kjK.TAG, "sendTag session:%d time[%d,%d] media:%d nick:%s id:%s timeDiff:%s", new Object[]{Integer.valueOf(this.kjK.kjv.kjp.aol().kiK), Long.valueOf(this.kjK.kiQ), Long.valueOf(this.kjK.kiR), Integer.valueOf(this.kjK.kjD.size()), this.kjK.bgo, this.kjK.kjC, Long.valueOf(bh.bz(this.kjK.kjG))});
                            if (this.kjK.kjv.kjp.aol().kiK < this.kjK.kiO + 1) {
                                i = this.kjK.kjv.kjp.aol().kiL;
                                aol = this.kjK.kjv.kjp.aol();
                                if (this.kjK.kiO + 1 <= i) {
                                    i = this.kjK.kiO + 1;
                                }
                                aol.kiK = i;
                                this.kjK.kjv.kjo.mz(this.kjK.kjv.kjp.aol().kiJ);
                                break;
                            }
                            break;
                    }
                    boolean z = this.kjK.kiO == this.kjK.kjv.kjp.aol().kiL + -1;
                    ad adVar = new ad(!z);
                    new com.tencent.mm.plugin.backup.f.d(this.kjK.talker, this.kjK.kiQ, this.kjK.kiR, this.kjK.kjC, this.kjK.bgo, new LinkedList(this.kjK.kjD), new 1(this, z, adVar)).apQ();
                    if (z) {
                        x.w(this.kjK.TAG, "sendTag last Session :[%d/%d] wait tag resp callback .", new Object[]{Integer.valueOf(this.kjK.kiO), Integer.valueOf(this.kjK.kjv.kjp.aol().kiL - 1)});
                        adVar.block();
                    }
                    this.kjK.iQP = false;
                }
            };
            this.kjG = bh.Wp();
            this.kjA = aVar;
            this.talker = aVar2.kiN;
            this.kiO = aVar2.kiO;
            if (s.eV(this.talker)) {
                L = r.L(this.talker, this.talker);
            } else {
                L = r.gu(this.talker);
            }
            this.bgo = L;
            this.TAG = "MicroMsg.BackupPackAndSend.tag." + (this.iQP ? "S." : "W.") + this.kiO + "." + this.bgo;
            x.i(this.TAG, "initTagNow [%d,%s,%s] [%s]", new Object[]{Integer.valueOf(this.kiO), this.bgo, this.talker, ai.cfH()});
        }

        public final boolean a(er erVar, long j, long j2, LinkedList<u> linkedList, HashMap<Long, a> hashMap) {
            this.kjE.add(erVar);
            this.kjB = (j > 0 ? j : 0) + this.kjB;
            if (this.kiQ == 0) {
                this.kiQ = j2;
            }
            this.kiR = j2;
            this.kjF.putAll(hashMap);
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                u uVar = (u) it.next();
                f(uVar.mediaId, uVar.path, false);
            }
            x.i(this.TAG, "addToTag msgtime[%d,%d] size[%d,%d] baklist:%d media:%d timeDiff:%d", new Object[]{Long.valueOf(this.kiQ), Long.valueOf(this.kiR), Long.valueOf(j), Long.valueOf(this.kjB), Integer.valueOf(this.kjE.size()), Integer.valueOf(linkedList.size()), Long.valueOf(bh.bz(this.kjG))});
            if (this.kjB <= 83886080 && this.kjE.size() <= 80) {
                return false;
            }
            aoA();
            return true;
        }

        public final void aoA() {
            this.kjC = "MSG_" + this.kjE.size() + "_" + this.talker + "_" + bh.Wp();
            x.i(this.TAG, "setTagEnd msgtime[%d,%d], size:%d baklist:%d bigfile:%d id:%s timeDiff:%d", new Object[]{Long.valueOf(this.kiQ), Long.valueOf(this.kiR), Long.valueOf(this.kjB), Integer.valueOf(this.kjE.size()), Integer.valueOf(this.kjF.size()), this.kjC, Long.valueOf(bh.bz(this.kjG))});
            if (this.kjE.size() > 0) {
                f(this.kjC, null, false);
                if (this.kjF.isEmpty()) {
                    this.kjz.offer(this.kjJ);
                    return;
                } else {
                    this.kjz.offer(this.kjI);
                    return;
                }
            }
            x.w(this.TAG, "setTagEnd NoFileSend, Go Send Tag: Direct. baklist:%d media:%d bigFileMap:%d ", new Object[]{Integer.valueOf(this.kjE.size()), Integer.valueOf(this.kjD.size()), Integer.valueOf(this.kjF.size())});
            Assert.assertTrue("cursorEnd NOMsg, chatMsgList should empty", this.kjE.isEmpty());
            Assert.assertTrue("cursorEnd NOMsg, MediaList should empty", this.kjD.isEmpty());
            Assert.assertTrue("cursorEnd NOMsg, BigFileList should empty", this.kjF.isEmpty());
            this.kjz.offer(this.kjJ);
        }

        final void f(String str, String str2, boolean z) {
            boolean z2 = true;
            com.tencent.mm.plugin.backup.f.c.c 2 = new 2(this);
            x.i(this.TAG, "postSendFile isBigFile[%b], baklst:%d Id:%s path:%s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.kjE.size()), str, str2});
            if (TextUtils.isEmpty(str2)) {
                String str3 = "chatMsgList should not empty";
                if (this.kjE.isEmpty()) {
                    z2 = false;
                }
                Assert.assertTrue(str3, z2);
                if (str != null) {
                    com.tencent.mm.plugin.backup.f.c.a(this.kjH, 2, str, new LinkedList(this.kjE), this.kjv.kjp.kiH);
                    return;
                }
                return;
            }
            this.kjD.add(str);
            if (str != null) {
                com.tencent.mm.plugin.backup.f.c.a(this.kjH, 2, str, str2, this.kjv.kjp.kiH);
            }
        }
    }

    public c(d dVar, int i, com.tencent.mm.plugin.backup.a.b.b bVar) {
        this.kjp = dVar;
        this.kiF = i;
        this.kjo = bVar;
        this.kjn = false;
    }

    public final void cancel() {
        x.e("MicroMsg.BackupPackAndSend", "cancel, caller:%s", new Object[]{ai.cfH()});
        this.kjn = true;
    }

    public final long aoy() {
        return this.kjq / 1024;
    }

    public final void dC(boolean z) {
        x.i("MicroMsg.BackupPackAndSend", "clearContinueBackupData.");
        if (this.kiF == 1) {
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xtd, Boolean.valueOf(false));
        } else if (this.kiF == 2) {
            ar.Hg();
            com.tencent.mm.z.c.CU().a(w.a.xtg, Boolean.valueOf(false));
        }
        Editor edit = d.aoq().edit();
        edit.putString("BACKUP_PC_CHOOSE_SESSION", null);
        if (z) {
            if (this.kiF == 1) {
                edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
                edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
                edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
                edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
            } else if (this.kiF == 2) {
                edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
                edit.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
                edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0);
                edit.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0);
            }
        }
        edit.commit();
    }

    public final void aoz() {
        x.i("MicroMsg.BackupPackAndSend", "backupSendFinishRequest.");
        com.tencent.mm.plugin.backup.h.d dVar = new com.tencent.mm.plugin.backup.h.d();
        dVar.ID = this.kjp.kiB;
        try {
            com.tencent.mm.plugin.backup.f.b.F(dVar.toByteArray(), 8);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "BackupFinishRequest to buf err.", new Object[0]);
        }
    }

    public final void a(LinkedList<f.a> linkedList, long j, boolean z) {
        String str = "MicroMsg.BackupPackAndSend";
        String str2 = "startBackup, backupSessionList size[%d], bigFileSize[%d], isOnlyText[%b]";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
        objArr[1] = Long.valueOf(j);
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        com.tencent.mm.sdk.f.e.d(new 1(this, linkedList, j, z), "backupPackThread", 10).start();
    }

    final boolean a(f.a aVar, c cVar, String str, long j, boolean z) {
        int i;
        long Wp;
        er a;
        Throwable e;
        String str2;
        String str3;
        Object[] objArr;
        int i2;
        long Wp2;
        LinkedBlockingQueue linkedBlockingQueue;
        b bVar;
        aj WY = com.tencent.mm.plugin.backup.g.d.aqe().aqf().Fd().WY(aVar.kiN);
        x.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg index[%d], sessionName[%s], startTime[%d], endTime[%d], unReadCount[%d]", new Object[]{Integer.valueOf(aVar.kiO), aVar.kiN, Long.valueOf(aVar.startTime), Long.valueOf(aVar.endTime), Integer.valueOf(WY != null ? WY.field_unReadCount : 0)});
        long Wp3 = bh.Wp();
        long j2 = 0;
        long j3 = 0;
        int i3 = 0;
        int i4 = r2;
        long j4 = 0;
        while (true) {
            LinkedList linkedList = new LinkedList();
            long Wp4 = j4 - bh.Wp();
            Cursor b = com.tencent.mm.plugin.backup.g.d.aqe().aqf().Fa().b(aVar.kiN, aVar.startTime, aVar.endTime, i3);
            i = i3;
            while (b.moveToNext()) {
                i++;
                if (this.kjn) {
                    b.close();
                    return false;
                }
                au auVar = new au();
                auVar.b(b);
                if (!z || auVar.getType() == 1) {
                    linkedList.add(auVar);
                }
            }
            b.close();
            Wp = Wp4 + bh.Wp();
            if (linkedList.size() == 0) {
                break;
            }
            int i5 = 0;
            int i6 = i4;
            long j5 = j3;
            j3 = j2;
            while (i5 < linkedList.size()) {
                long Wp5;
                au auVar2 = (au) linkedList.get(i5);
                PLong pLong = new PLong();
                LinkedList linkedList2 = new LinkedList();
                HashMap hashMap = new HashMap();
                try {
                    Wp5 = j5 - bh.Wp();
                    try {
                        a = h.a(auVar2, false, str, pLong, linkedList2, hashMap, i6 > 0, false, j);
                    } catch (Exception e2) {
                        e = e2;
                        a = null;
                        j2 = Wp5;
                        x.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "backupPackSessionMsg packedMsg", new Object[0]);
                        Wp5 = j2;
                        str2 = "MicroMsg.BackupPackAndSend";
                        str3 = "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]";
                        objArr = new Object[8];
                        objArr[0] = Boolean.valueOf(a == null);
                        objArr[1] = Integer.valueOf(linkedList2.size());
                        objArr[2] = Long.valueOf(pLong.value);
                        objArr[3] = Integer.valueOf(hashMap.size());
                        objArr[4] = Long.valueOf(auVar2.field_msgSvrId);
                        objArr[5] = Integer.valueOf(auVar2.getType());
                        objArr[6] = Long.valueOf(auVar2.field_createTime);
                        objArr[7] = auVar2.field_talker;
                        x.i(str2, str3, objArr);
                        if (a == null) {
                            i2 = i6 - 1;
                            Wp2 = j3 - bh.Wp();
                            j2 = pLong.value;
                            j3 = auVar2.field_createTime;
                            if (cVar.kjW == null) {
                                linkedBlockingQueue = cVar.kjU;
                                bVar = new b(cVar.kjv, cVar.kjA, aVar);
                                cVar.kjW = bVar;
                                linkedBlockingQueue.offer(bVar);
                            }
                            if (cVar.kjW.a(a, j2, j3, linkedList2, hashMap)) {
                                cVar.kjW = null;
                            }
                            j3 = Wp2 + bh.Wp();
                            i6 = i2;
                        }
                        i5++;
                        j5 = Wp5;
                    }
                    try {
                        Wp5 = bh.Wp() + Wp5;
                    } catch (Exception e3) {
                        e = e3;
                        j2 = Wp5;
                        x.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "backupPackSessionMsg packedMsg", new Object[0]);
                        Wp5 = j2;
                        str2 = "MicroMsg.BackupPackAndSend";
                        str3 = "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]";
                        objArr = new Object[8];
                        if (a == null) {
                        }
                        objArr[0] = Boolean.valueOf(a == null);
                        objArr[1] = Integer.valueOf(linkedList2.size());
                        objArr[2] = Long.valueOf(pLong.value);
                        objArr[3] = Integer.valueOf(hashMap.size());
                        objArr[4] = Long.valueOf(auVar2.field_msgSvrId);
                        objArr[5] = Integer.valueOf(auVar2.getType());
                        objArr[6] = Long.valueOf(auVar2.field_createTime);
                        objArr[7] = auVar2.field_talker;
                        x.i(str2, str3, objArr);
                        if (a == null) {
                            i2 = i6 - 1;
                            Wp2 = j3 - bh.Wp();
                            j2 = pLong.value;
                            j3 = auVar2.field_createTime;
                            if (cVar.kjW == null) {
                                linkedBlockingQueue = cVar.kjU;
                                bVar = new b(cVar.kjv, cVar.kjA, aVar);
                                cVar.kjW = bVar;
                                linkedBlockingQueue.offer(bVar);
                            }
                            if (cVar.kjW.a(a, j2, j3, linkedList2, hashMap)) {
                                cVar.kjW = null;
                            }
                            j3 = Wp2 + bh.Wp();
                            i6 = i2;
                        }
                        i5++;
                        j5 = Wp5;
                    }
                } catch (Exception e4) {
                    e = e4;
                    j2 = j5;
                    a = null;
                    x.printErrStackTrace("MicroMsg.BackupPackAndSend", e, "backupPackSessionMsg packedMsg", new Object[0]);
                    Wp5 = j2;
                    str2 = "MicroMsg.BackupPackAndSend";
                    str3 = "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]";
                    objArr = new Object[8];
                    if (a == null) {
                    }
                    objArr[0] = Boolean.valueOf(a == null);
                    objArr[1] = Integer.valueOf(linkedList2.size());
                    objArr[2] = Long.valueOf(pLong.value);
                    objArr[3] = Integer.valueOf(hashMap.size());
                    objArr[4] = Long.valueOf(auVar2.field_msgSvrId);
                    objArr[5] = Integer.valueOf(auVar2.getType());
                    objArr[6] = Long.valueOf(auVar2.field_createTime);
                    objArr[7] = auVar2.field_talker;
                    x.i(str2, str3, objArr);
                    if (a == null) {
                        i2 = i6 - 1;
                        Wp2 = j3 - bh.Wp();
                        j2 = pLong.value;
                        j3 = auVar2.field_createTime;
                        if (cVar.kjW == null) {
                            linkedBlockingQueue = cVar.kjU;
                            bVar = new b(cVar.kjv, cVar.kjA, aVar);
                            cVar.kjW = bVar;
                            linkedBlockingQueue.offer(bVar);
                        }
                        if (cVar.kjW.a(a, j2, j3, linkedList2, hashMap)) {
                            cVar.kjW = null;
                        }
                        j3 = Wp2 + bh.Wp();
                        i6 = i2;
                    }
                    i5++;
                    j5 = Wp5;
                }
                str2 = "MicroMsg.BackupPackAndSend";
                str3 = "backupPackSessionMsg, bakitem null[%b], addupMediaList[%d], addupSize[%d], bigFile[%d], msgSvrId[%d], type[%d], createTime[%d], talker[%s]";
                objArr = new Object[8];
                if (a == null) {
                }
                objArr[0] = Boolean.valueOf(a == null);
                objArr[1] = Integer.valueOf(linkedList2.size());
                objArr[2] = Long.valueOf(pLong.value);
                objArr[3] = Integer.valueOf(hashMap.size());
                objArr[4] = Long.valueOf(auVar2.field_msgSvrId);
                objArr[5] = Integer.valueOf(auVar2.getType());
                objArr[6] = Long.valueOf(auVar2.field_createTime);
                objArr[7] = auVar2.field_talker;
                x.i(str2, str3, objArr);
                if (a == null) {
                    i2 = i6 - 1;
                    Wp2 = j3 - bh.Wp();
                    j2 = pLong.value;
                    j3 = auVar2.field_createTime;
                    if (cVar.kjW == null) {
                        linkedBlockingQueue = cVar.kjU;
                        bVar = new b(cVar.kjv, cVar.kjA, aVar);
                        cVar.kjW = bVar;
                        linkedBlockingQueue.offer(bVar);
                    }
                    if (cVar.kjW.a(a, j2, j3, linkedList2, hashMap)) {
                        cVar.kjW = null;
                    }
                    j3 = Wp2 + bh.Wp();
                    i6 = i2;
                }
                i5++;
                j5 = Wp5;
            }
            j2 = j3;
            j4 = Wp;
            j3 = j5;
            i3 = i;
            i4 = i6;
        }
        j4 = j2 - bh.Wp();
        if (cVar.kjW == null) {
            LinkedBlockingQueue linkedBlockingQueue2 = cVar.kjU;
            b bVar2 = new b(cVar.kjv, cVar.kjA, aVar);
            cVar.kjW = bVar2;
            linkedBlockingQueue2.offer(bVar2);
        }
        cVar.kjW.aoA();
        cVar.kjW = null;
        j4 += bh.Wp();
        x.i("MicroMsg.BackupPackAndSend", "backupPackSessionMsg finish Cursor Session[%d], convName[%s], msgCnt[%d], time[%d], [%d,%d,%d]", new Object[]{Integer.valueOf(aVar.kiO), aVar.kiN, Integer.valueOf(i), Long.valueOf(bh.bz(Wp3)), Long.valueOf(Wp), Long.valueOf(j3), Long.valueOf(j4)});
        return true;
    }
}
