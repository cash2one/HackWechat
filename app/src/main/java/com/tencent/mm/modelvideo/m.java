package com.tencent.mm.modelvideo;

import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelvideo.s.a.b;
import com.tencent.mm.modelvideo.s.a.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.s;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class m {
    private static int flV = 0;
    private boolean flR = false;
    private boolean flS = false;
    int flT = 0;
    private a flX = new a();
    private ak flY = new ak(g.Dm().oAt.getLooper(), new ak.a(this) {
        final /* synthetic */ m hUT;

        {
            this.hUT = r1;
        }

        public final boolean uF() {
            m.h(this.hUT);
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);
    private LinkedList<Long> hUN = new LinkedList();
    private Map<Long, a> hUO = new HashMap();
    private Map<Long, String> hUP = new HashMap();
    private Object hUQ = new Object();
    String hUR;

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ long hUS;
        final /* synthetic */ m hUT;

        public AnonymousClass5(m mVar, long j) {
            this.hUT = mVar;
            this.hUS = j;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            synchronized (this.hUT.hUQ) {
                String str = (String) this.hUT.hUP.get(Long.valueOf(this.hUS));
                x.i("MicroMsg.SightMassSendService", "cancel item, massSendId %d, cdnClientId %s", new Object[]{Long.valueOf(this.hUS), str});
                if ("done_upload_cdn_client_id".equals(str)) {
                    x.w("MicroMsg.SightMassSendService", "doing mass send cgi, ignore cancel!");
                    return;
                }
                if (!bh.ov(str)) {
                    this.hUT.hUP.put(Long.valueOf(this.hUS), "");
                    com.tencent.mm.modelcdntran.g.MJ().kH(str);
                    this.hUT.d(this.hUS, 0, 0);
                }
                s TU = o.TU();
                long j = this.hUS;
                if (TU.hhp.delete("videoinfo2", "masssendid= ?", new String[]{String.valueOf(j)}) > 0) {
                    TU.hkZ.ca(new s.a.a("DELETE_" + j, b.hWa, c.hWd, 3, j));
                    TU.hkZ.doNotify();
                }
            }
        }
    }

    static /* synthetic */ int TQ() {
        int i = flV;
        flV = i + 1;
        return i;
    }

    static /* synthetic */ int TR() {
        int i = flV;
        flV = i - 1;
        return i;
    }

    static /* synthetic */ void h(m mVar) {
        if (!mVar.flR && mVar.hUN.isEmpty()) {
            List<r> Ul = o.TU().Ul();
            if (Ul.isEmpty()) {
                x.d("MicroMsg.SightMassSendService", "unfinish massinfo count 0");
            } else {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                for (r rVar : Ul) {
                    if (mVar.hUO.containsKey(Long.valueOf(rVar.hUa))) {
                        x.d("MicroMsg.SightMassSendService", "Mass Send File is Already running %s, massSendId %d", new Object[]{rVar.getFileName(), Long.valueOf(rVar.hUa)});
                    } else {
                        x.d("MicroMsg.SightMassSendService", "Get file:" + rVar.getFileName() + " status:" + rVar.status + " user" + rVar.Ud() + " human:" + rVar.Ue() + " massSendId:" + rVar.hUa + " massSendList:" + rVar.hVP + " create:" + bh.fJ(rVar.hVE) + " last:" + bh.fJ(rVar.hVF) + " now:" + bh.fJ(currentTimeMillis) + " " + (currentTimeMillis - rVar.hVF));
                        if (rVar.status == 200) {
                            mVar.hUN.offer(Long.valueOf(rVar.hUa));
                            mVar.hUO.put(Long.valueOf(rVar.hUa), null);
                        }
                    }
                }
                x.d("MicroMsg.SightMassSendService", "GetNeedRun procing:" + mVar.hUO.size() + " [send:" + mVar.hUN.size() + "]");
                mVar.hUN.size();
            }
        }
        if (!mVar.flR && mVar.hUN.isEmpty()) {
            mVar.vB();
            x.d("MicroMsg.SightMassSendService", "No Data Any More , Stop Service");
        } else if (!mVar.flR && mVar.hUN.size() > 0) {
            Long l = (Long) mVar.hUN.poll();
            x.d("MicroMsg.SightMassSendService", "Start Mass Send, ID: %s", new Object[]{l});
            if (l != null) {
                mVar.hUO.put(l, new a());
                mVar.flR = true;
                mVar.hUR = mVar.bs(l.longValue());
                if (mVar.hUR == null) {
                    mVar.flR = false;
                    mVar.flY.J(10, 10);
                    return;
                }
                mVar.hUP.put(l, mVar.hUR);
            }
        }
    }

    public static void V(List<r> list) {
        if (list != null && !list.isEmpty()) {
            for (r fileName : list) {
                t.ny(fileName.getFileName());
            }
        }
    }

    public static void W(List<r> list) {
        if (list != null && !list.isEmpty()) {
            for (r fileName : list) {
                t.nz(fileName.getFileName());
            }
        }
    }

    private String bs(long j) {
        List<r> bt = o.TU().bt(j);
        if (bt.isEmpty()) {
            x.e("MicroMsg.SightMassSendService", "check use cdn fail: mass send video list empty");
            return null;
        }
        for (r rVar : bt) {
            r rVar2;
            if (s.ho(rVar2.Ud())) {
                x.w("MicroMsg.SightMassSendService", "cdntra not use cdn user:%s, list %s, massSendId %d", new Object[]{rVar2.Ud(), rVar2.hVP, Long.valueOf(j)});
                return null;
            }
            com.tencent.mm.modelcdntran.g.MJ();
            if (!com.tencent.mm.modelcdntran.c.hu(2) && rVar2.hVM != 1) {
                r5 = new Object[4];
                com.tencent.mm.modelcdntran.g.MJ();
                r5[0] = Boolean.valueOf(com.tencent.mm.modelcdntran.c.hu(2));
                r5[1] = Integer.valueOf(rVar2.hVM);
                r5[2] = rVar2.hVP;
                r5[3] = Long.valueOf(j);
                x.w("MicroMsg.SightMassSendService", "cdntra not use cdn flag:%b getCdnInfo:%d, list %s, massSendId %d", r5);
                return null;
            }
        }
        if (bt == null || bt.isEmpty()) {
            rVar2 = null;
        } else {
            for (int i = 0; i < bt.size(); i++) {
                r nF = t.nF(((r) bt.get(i)).getFileName());
                if (nF != null) {
                    x.i("MicroMsg.SightMassSendService", "check %s ok, index %d, size %d, massSendId %d, massSendList %s", new Object[]{rVar2.getFileName(), Integer.valueOf(i), Integer.valueOf(bt.size()), Long.valueOf(j), rVar2.hVP});
                    bt.remove(i);
                    bt.add(i, nF);
                    rVar2 = nF;
                    break;
                }
                x.w("MicroMsg.SightMassSendService", "check %s fail, index %d, size %d, massSendId %d, massSendList %s", new Object[]{rVar2.getFileName(), Integer.valueOf(i), Integer.valueOf(bt.size()), Long.valueOf(j), rVar2.hVP});
            }
            rVar2 = null;
        }
        if (rVar2 == null) {
            x.w("MicroMsg.SightMassSendService", "check use cdn fail: no valid info");
            return null;
        }
        String a = d.a("upvideo", rVar2.hVE, rVar2.hVP, rVar2.getFileName());
        if (bh.ov(a)) {
            x.w("MicroMsg.SightMassSendService", "cdntra genClientId failed not use cdn file:%s, massSendId %d, massSendList %s", new Object[]{rVar2.getFileName(), Long.valueOf(rVar2.hUa), rVar2.hVP});
            return null;
        }
        String fileName = rVar2.getFileName();
        o.TU();
        String nu = s.nu(fileName);
        o.TU();
        fileName = s.nt(fileName);
        i.a aVar = new a(this, (byte) 0);
        aVar.hiw = bt;
        aVar.hUa = j;
        aVar.hUU = a;
        aVar.startTime = bh.Wp();
        aVar.hUb = rVar2;
        i iVar = new i();
        iVar.htt = aVar;
        iVar.field_mediaId = a;
        iVar.field_fullpath = fileName;
        iVar.field_thumbpath = nu;
        iVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_VIDEO;
        iVar.field_smallVideoFlag = 1;
        iVar.field_talker = rVar2.hVP;
        iVar.field_priority = com.tencent.mm.modelcdntran.b.hrK;
        iVar.field_needStorage = false;
        iVar.field_isStreamMedia = false;
        Map y = bi.y(rVar2.Ug(), "msg");
        if (y != null) {
            iVar.field_fileId = (String) y.get(".msg.videomsg.$cdnvideourl");
            iVar.field_aesKey = (String) y.get(".msg.videomsg.$aeskey");
        } else {
            x.i("MicroMsg.SightMassSendService", "cdntra parse video recv xml failed");
        }
        if (com.tencent.mm.modelcdntran.g.MJ().c(iVar)) {
            for (r rVar22 : bt) {
                if (rVar22.hVM != 1) {
                    rVar22.hVM = 1;
                    rVar22.fDt = SQLiteGlobal.journalSizeLimit;
                    boolean e = t.e(rVar22);
                    x.i("MicroMsg.SightMassSendService", "update %s useCDN, result %B", new Object[]{rVar22.getFileName(), Boolean.valueOf(e)});
                }
            }
            return a;
        }
        x.e("MicroMsg.SightMassSendService", "cdntra addSendTask failed.");
        return null;
    }

    public final void d(long j, int i, int i2) {
        g.Dm().F(new 2(this, j, i, i2));
    }

    private void vB() {
        this.hUP.clear();
        this.hUO.clear();
        this.hUN.clear();
        this.flR = false;
        this.flS = false;
        x.d("MicroMsg.SightMassSendService", "Finish service use time(ms):" + this.flX.zi());
    }
}
