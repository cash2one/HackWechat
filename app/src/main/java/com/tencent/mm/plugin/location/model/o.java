package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.location.model.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q.p;
import com.tencent.mm.protocal.c.bod;
import com.tencent.mm.protocal.c.brr;
import com.tencent.mm.protocal.c.td;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class o implements e, p {
    private int cRJ;
    public boolean fAs = false;
    public boolean fhN = false;
    public a gyF = new 2(this);
    public c hpO;
    af mHandler = new 1(this, Looper.getMainLooper());
    private String nQv;
    public double nQx = -1000.0d;
    public double nQy = -1000.0d;
    private int nRH = 0;
    private int nRI = 1000;
    public i nRJ;
    public HashSet<WeakReference<b>> nRK = new HashSet();
    public int nRL = 1;
    public brr nRM;
    public LocationInfo nRN = new LocationInfo((byte) 0);
    public boolean nRO = false;
    public boolean nRP = false;
    public int nRQ = this.nRL;
    public String nRR = "";
    boolean nRS = false;
    public a nRT = null;
    public int nRU = -1;
    public boolean nRV = true;
    public long nRW = 0;
    long nRX = 0;
    public i.a nRY = new 3(this);
    public int zoom = -1;

    public final void stop() {
        x.i("MicorMsg.TrackRefreshManager", "stop location");
        if (this.hpO != null) {
            this.hpO.c(this.gyF);
        }
        if (this.nRJ != null) {
            this.nRJ.b(this.nRY);
        }
        ar.CG().b(492, this);
        ar.CG().b(490, this);
        ar.CG().b(491, this);
        this.nRL = 1;
        this.fAs = false;
        this.nRU = -1;
        m aVx = l.aVx();
        x.d("MicroMsg.TrackAvatarCacheService", "clearCache");
        for (String str : aVx.nRG.snapshot().keySet()) {
            Bitmap bitmap = (Bitmap) aVx.nRG.get(str);
            if (!(bitmap == null || bitmap.isRecycled())) {
                bitmap.recycle();
            }
        }
        aVx.nRG.trimToSize(-1);
    }

    public final boolean aVz() {
        return aVF() && this.nRO;
    }

    public final void rM(int i) {
        x.i("MicorMsg.TrackRefreshManager", "track endTrack");
        if (aVF()) {
            String str = this.nQv;
            x.d("MicorMsg.TrackRefreshManager", "exitTrack, scene=%d", new Object[]{Integer.valueOf(i)});
            k aVar = new com.tencent.mm.plugin.location.model.a.a(str);
            ((td) aVar.gJQ.hmg.hmo).rYW = i;
            ar.CG().a(aVar, 0);
            this.nQv = "";
        }
        if (!bh.ov(this.nRR)) {
            com.tencent.mm.plugin.location.a.a DB = l.aVv().DB(this.nRR);
            if (DB != null) {
                DB.fAX.remove(q.FS());
                l.aVv().a(this.nRR, DB.fAX, DB.latitude, DB.longitude, DB.nQt, null, null);
            }
        }
        l.aVv().DD("");
        this.nQv = "";
        this.nRR = "";
        this.nRO = false;
        this.nRP = false;
        this.nQx = -1000.0d;
        this.nQy = -1000.0d;
        this.zoom = -1;
        this.nRU = -1;
    }

    public final void aVA() {
        x.d("MicorMsg.TrackRefreshManager", "resume refresh");
        this.nRS = false;
        x.d("MicorMsg.TrackRefreshManager", "trigerRefresh");
        if (aVF()) {
            x.d("MicorMsg.TrackRefreshManager", "trigerRefresh, joinSuccess");
            this.hpO = c.OP();
            this.hpO.b(this.gyF, true);
            if (this.nRJ == null) {
                this.nRJ = l.aVw();
            }
            this.nRJ.a(this.nRY);
            aVE();
        }
    }

    public final String aVB() {
        return this.nRR;
    }

    public final List<String> aVC() {
        return l.aVv().DA(this.nRR);
    }

    public final void aVD() {
        if (this.nRL == 1) {
            this.nRL = 3;
        } else if (this.nRL == 3) {
            this.nRL = 2;
        }
    }

    public final void aVE() {
        boolean z = true;
        String str;
        if (!this.fAs || !this.nRO || this.nRN == null) {
            str = "MicorMsg.TrackRefreshManager";
            StringBuilder append = new StringBuilder("error to exit refresh isStart: ").append(this.fAs).append(" isShared: ").append(this.nRO).append(" ");
            if (this.nRN != null) {
                z = false;
            }
            x.e(str, append.append(z).toString());
        } else if (this.nRM == null || this.nRM.wTo.vNP == -1000.0d || this.nRM.wTo.vNO == -1000.0d) {
            x.e("MicorMsg.TrackRefreshManager", "error to get my location ");
            this.mHandler.sendEmptyMessageDelayed(1, (long) this.nRI);
        } else {
            String FS = q.FS();
            bod com_tencent_mm_protocal_c_bod = new bod();
            com_tencent_mm_protocal_c_bod.wCR = this.nRN.nQz;
            com_tencent_mm_protocal_c_bod.vNP = this.nRN.nQx;
            com_tencent_mm_protocal_c_bod.vNO = this.nRN.nQy;
            com_tencent_mm_protocal_c_bod.nfp = FS;
            this.nRM.vIy = FS;
            this.nRM.wTo.wEE = l.aVw().aVn();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("refreshLoopImpl, [trackRoomId:" + this.nQv + "]");
            switch (this.nRL) {
                case 0:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomUpload ");
                    break;
                case 1:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomDownload ");
                    break;
                case 2:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomUploadAndDownLoad ");
                    break;
                case 3:
                    stringBuffer.append("track upload_status  MMRefreshTrackRoomFirstUpload ");
                    stringBuffer.append("[ trackItem " + com_tencent_mm_protocal_c_bod.vNP + " " + com_tencent_mm_protocal_c_bod.vNO + " ]");
                    break;
            }
            stringBuffer.append("[ mMyPosiItem " + this.nRM.wTo.vNP + " " + this.nRM.wTo.vNO + " " + this.nRM.wTo.wEE + " ]");
            x.d("MicorMsg.TrackRefreshManager", stringBuffer.toString());
            str = this.nQv;
            int i = this.nRL;
            brr com_tencent_mm_protocal_c_brr = this.nRM;
            int i2 = this.cRJ + 1;
            this.cRJ = i2;
            ar.CG().a(new com.tencent.mm.plugin.location.model.a.c(str, i, com_tencent_mm_protocal_c_brr, i2, com_tencent_mm_protocal_c_bod), 0);
        }
    }

    public final boolean aVF() {
        return !bh.ov(this.nQv);
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicorMsg.TrackRefreshManager", "onSceneEnd scene type %d errType %d errCode %d", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        WeakReference weakReference;
        if (kVar.getType() == 490) {
            Iterator it;
            if (i2 == 0 || i2 >= 1000) {
                this.nQv = ((b) kVar).nQv;
                l.aVv().DD(this.nQv);
                if (aVF()) {
                    x.i("MicorMsg.TrackRefreshManager", "join sucess %s", new Object[]{this.nQv});
                    LinkedList DA = com.tencent.mm.pluginsdk.q.a.vcw.DA(this.nRR);
                    DA.add(q.FS());
                    if (this.nRN != null) {
                        com.tencent.mm.pluginsdk.q.a.vcw.a(this.nRR, DA, this.nRN.nQx, this.nRN.nQy, this.nRN.nQz, "", "");
                    } else {
                        com.tencent.mm.pluginsdk.q.a.vcw.a(this.nRR, DA, -1000.0d, -1000.0d, "", "", "");
                    }
                    if (this.nRK != null) {
                        it = this.nRK.iterator();
                        while (it.hasNext()) {
                            weakReference = (WeakReference) it.next();
                            if (!(weakReference == null || weakReference.get() == null)) {
                                ((b) weakReference.get()).aVH();
                            }
                        }
                    }
                    aVE();
                    return;
                }
                return;
            }
            if (i2 == 17 && this.nRK != null) {
                it = this.nRK.iterator();
                while (it.hasNext()) {
                    weakReference = (WeakReference) it.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((b) weakReference.get()).aVI();
                    }
                }
            }
            if (this.nRK != null) {
                Iterator it2 = this.nRK.iterator();
                while (it2.hasNext()) {
                    weakReference = (WeakReference) it2.next();
                    if (!(weakReference == null || weakReference.get() == null)) {
                        ((b) weakReference.get()).onError(0, ((b) kVar).jcO);
                    }
                }
            }
        } else if (i == 0 && i2 == 0) {
            if (kVar.getType() == 492) {
                r0 = ((com.tencent.mm.plugin.location.model.a.c) kVar).nSi;
                if (!(r0 == null || r0.wJr == null)) {
                    if (r0.wJr.vJU == 12) {
                        this.fhN = true;
                        if (this.nRT != null) {
                            this.nRT.aVG();
                        }
                    } else {
                        this.fhN = false;
                    }
                    x.d("MicorMsg.TrackRefreshManager", "refresh track room, timeout = %b, ret = %d", new Object[]{Boolean.valueOf(this.fhN), Integer.valueOf(r0.wJr.vJU)});
                }
                if (this.nRH > 0) {
                    g.pQN.h(10997, new Object[]{"9", "", Integer.valueOf(this.nRH), Integer.valueOf(0)});
                }
                this.nRH = 0;
                this.nRI = ((com.tencent.mm.plugin.location.model.a.c) kVar).nSf;
                int i3 = ((com.tencent.mm.plugin.location.model.a.c) kVar).nSj;
                if (this.nRK != null && (i3 == 2 || i3 == 1 || i3 == 3)) {
                    Iterator it3 = this.nRK.iterator();
                    while (it3.hasNext()) {
                        weakReference = (WeakReference) it3.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((b) weakReference.get()).a(((com.tencent.mm.plugin.location.model.a.c) kVar).nSi);
                        }
                    }
                }
                if (!(this.nRL == 1)) {
                    aVD();
                }
                this.mHandler.removeMessages(1);
                if (aVF() && !this.nRS && !this.fhN) {
                    this.mHandler.sendEmptyMessageDelayed(1, (long) this.nRI);
                }
            } else if (kVar.getType() == 491) {
                l.aVv().DD("");
            }
        } else if (kVar.getType() == 492) {
            this.nRH++;
            this.mHandler.removeMessages(1);
            if (this.nRH >= 10) {
                this.mHandler.removeMessages(1);
                if (this.nRK != null) {
                    Iterator it4 = this.nRK.iterator();
                    while (it4.hasNext()) {
                        weakReference = (WeakReference) it4.next();
                        if (!(weakReference == null || weakReference.get() == null)) {
                            ((b) weakReference.get()).onError(1, ((com.tencent.mm.plugin.location.model.a.c) kVar).jcO);
                        }
                    }
                }
            } else if (aVF() && !this.nRS) {
                r0 = ((com.tencent.mm.plugin.location.model.a.c) kVar).nSi;
                if (!(r0 == null || r0.wJr == null)) {
                    if (r0.wJr.vJU == 12) {
                        this.fhN = true;
                        if (this.nRT != null) {
                            this.nRT.aVG();
                        }
                    } else {
                        this.fhN = false;
                    }
                    x.d("MicorMsg.TrackRefreshManager", "refresh track room, in error status, timeout = %b, ret = %d", new Object[]{Boolean.valueOf(this.fhN), Integer.valueOf(r0.wJr.vJU)});
                }
                if (!this.fhN) {
                    this.mHandler.sendEmptyMessageDelayed(1, (long) this.nRI);
                }
            }
        }
    }
}
