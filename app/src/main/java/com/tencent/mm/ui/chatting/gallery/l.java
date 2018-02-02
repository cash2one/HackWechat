package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.k.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class l {
    String filename;
    int hTA;
    int hTB;
    boolean hTD;
    int hTE = 0;
    private int hTF;
    boolean hTG = false;
    boolean hTH = false;
    int hTx = 0;
    int hTy = 0;
    f hTz;
    long htG;
    int iFv;
    String mediaId;
    HashMap<String, Integer> rvq = new HashMap();
    int rvs;
    int rvt = 0;
    long rvu;
    long rvv;
    private long rvw;
    private int rvx;
    i yGT;
    a yGU;

    public l(i iVar) {
        int i;
        this.yGT = iVar;
        reset();
        this.hTz = new f();
        this.yGU = new a((byte) 0);
        String value = g.zY().getValue("AndroidOnlineVideoArgs");
        if (!bh.ov(value)) {
            x.i("MicroMsg.OnlineVideoUIHelper", "online video config : " + value);
            String[] split = value.split(";");
            if (split != null && split.length >= 4) {
                this.yGU.hTN = bh.getInt(split[0], 5);
                this.yGU.hTO = bh.getInt(split[1], 1);
                this.yGU.rvA = bh.getInt(split[2], 75);
                this.yGU.yGW = bh.getInt(split[3], 1) * 1048576;
                i = 1;
                if (i == 0) {
                    this.yGU.hTN = 5;
                    this.yGU.hTO = 1;
                    this.yGU.rvA = 75;
                    this.yGU.yGW = 1048576;
                }
                x.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[]{Integer.valueOf(this.yGU.hTN), Integer.valueOf(this.yGU.hTO), Integer.valueOf(this.yGU.rvA), Integer.valueOf(this.yGU.yGW)});
                this.hTF = this.yGU.hTN;
            }
        }
        boolean z = false;
        if (i == 0) {
            this.yGU.hTN = 5;
            this.yGU.hTO = 1;
            this.yGU.rvA = 75;
            this.yGU.yGW = 1048576;
        }
        x.i("MicroMsg.OnlineVideoUIHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d], minStreamSize[%d]", new Object[]{Integer.valueOf(this.yGU.hTN), Integer.valueOf(this.yGU.hTO), Integer.valueOf(this.yGU.rvA), Integer.valueOf(this.yGU.yGW)});
        this.hTF = this.yGU.hTN;
    }

    public final void reset() {
        String str = "";
        this.mediaId = str;
        this.filename = str;
        this.hTB = -1;
        this.rvs = 0;
        this.iFv = 0;
        this.hTE = 0;
        this.hTA = 0;
        this.rvt = 0;
        this.hTy = 0;
        this.hTx = 0;
        this.hTD = false;
        this.hTG = false;
        this.hTH = false;
        this.rvq.clear();
        if (this.yGU != null) {
            this.hTF = this.yGU.hTN;
        }
        this.rvu = 0;
        this.htG = 0;
        this.rvx = 0;
        this.rvw = 0;
        this.rvv = 0;
    }

    public final void cvn() {
        x.i("MicroMsg.OnlineVideoUIHelper", "stop stream download video.");
        if (this.hTx == 3) {
            int i = 1;
        } else {
            boolean z = false;
        }
        this.hTx = 0;
        if (!bh.ov(this.mediaId)) {
            if (i != 0) {
                cvp();
            } else if (this.rvs >= this.yGU.rvA) {
                x.i("MicroMsg.OnlineVideoUIHelper", "start complete video, downloaded (%d) more than config (%d).", new Object[]{Integer.valueOf(this.rvs), Integer.valueOf(this.yGU.rvA)});
                t.Y(this.filename, 2);
                com.tencent.mm.plugin.report.service.g.pQN.a(354, 10, 1, false);
            }
            o.TV().b(this.mediaId, cvq());
            com.tencent.mm.plugin.report.service.g.pQN.a(354, 2, 1, false);
        }
    }

    public final boolean isStreaming() {
        return !bh.ov(this.mediaId) && (this.hTx == 1 || this.hTx == 3);
    }

    public final boolean LT(String str) {
        return bh.fu(str, this.mediaId);
    }

    final void bzV() {
        x.i("MicroMsg.OnlineVideoUIHelper", "play offline video %s ", new Object[]{this.filename});
        bzW();
        ag.y(new Runnable(this) {
            final /* synthetic */ l yGV;

            {
                this.yGV = r1;
            }

            public final void run() {
                if (this.yGV.yGT != null) {
                    this.yGV.yGT.aI(this.yGV.filename, false);
                }
            }
        });
    }

    public final boolean ai(int i, boolean z) {
        boolean z2;
        switch (this.hTx) {
            case 1:
                this.hTy = 2;
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                a(i, pInt, pInt2);
                if (!f(pInt.value, pInt2.value, true)) {
                    this.hTB = i;
                    this.hTD = true;
                    this.yGT.TF();
                    z2 = false;
                    break;
                }
                this.hTB = -1;
                this.hTD = false;
                this.hTE = pInt2.value;
                this.hTy = 3;
                break;
            case 3:
                break;
        }
        this.yGT.F(i, z);
        z2 = true;
        x.i("MicroMsg.OnlineVideoUIHelper", "seek video time %d, download status %d playStatus %d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.hTx), Integer.valueOf(this.hTy)});
        com.tencent.mm.plugin.report.service.g.pQN.a(354, 4, 1, false);
        return z2;
    }

    public final boolean iH(int i) {
        int i2;
        boolean z = false;
        if (this.hTB != -1) {
            i2 = this.hTB;
        } else {
            i2 = i;
        }
        x.i("MicroMsg.OnlineVideoUIHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d downloadStatus %d firPlayWait{%d} isPrepareVideo[%b]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.hTE), Integer.valueOf(this.hTA), Integer.valueOf(this.hTx), Long.valueOf(this.rvv - this.htG), Boolean.valueOf(this.hTG)});
        switch (this.hTx) {
            case 1:
                boolean z2;
                if (iI(i2)) {
                    if (this.rvt == 0 && this.rvv == 0) {
                        bzW();
                    }
                    if (this.hTG) {
                        l lVar;
                        int i3;
                        this.yGT.Zp(this.filename);
                        if (this.hTD) {
                            if (this.rvt == 0 && this.rvv == 0) {
                                bzW();
                            } else if (this.rvw > 0) {
                                this.rvx = (int) (((long) this.rvx) + bh.bz(this.rvw));
                            }
                            x.i("MicroMsg.OnlineVideoUIHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d", new Object[]{Integer.valueOf(this.rvt), Integer.valueOf(this.rvx)});
                            if (this.hTB != -1) {
                                this.yGT.F(this.hTB, true);
                                this.hTB = -1;
                                z2 = false;
                                lVar = this;
                            } else if (this.yGT.bzM()) {
                                z2 = false;
                                lVar = this;
                            } else {
                                z2 = true;
                                lVar = this;
                            }
                            lVar.hTD = z2;
                            i3 = 3;
                            lVar = this;
                        } else {
                            if (this.hTy != 3) {
                                x.i("MicroMsg.OnlineVideoUIHelper", "start to play video playStatus[%d]", new Object[]{Integer.valueOf(this.hTy)});
                                if (this.yGT.bzM()) {
                                    i3 = 3;
                                    lVar = this;
                                } else {
                                    i3 = this.hTy;
                                    lVar = this;
                                }
                            }
                            z2 = true;
                        }
                        lVar.hTy = i3;
                        z2 = true;
                    } else {
                        x.i("MicroMsg.OnlineVideoUIHelper", "prepare video [%s]", new Object[]{this.filename});
                        this.yGT.aI(this.filename, true);
                        this.hTG = true;
                        z2 = true;
                    }
                } else {
                    this.hTD = true;
                    if (this.hTE > 0) {
                        x.i("MicroMsg.OnlineVideoUIHelper", "pause by load data pauseByLoadDataCount : " + this.rvt + " playStatus : " + this.hTy);
                        this.rvw = bh.Wp();
                        if (!(this.hTy == 2 || this.hTy == 4)) {
                            this.hTF += this.yGU.hTN;
                            this.hTF = Math.min(this.hTF, 60);
                            this.rvt++;
                            this.hTy = 4;
                        }
                        this.yGT.TF();
                    } else if (this.hTB == -1) {
                        this.hTy = 1;
                    } else {
                        this.hTy = 2;
                    }
                    z2 = false;
                }
                this.yGT.Gh(i2);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (!a(i2, pInt, pInt2)) {
                    x.d("MicroMsg.OnlineVideoUIHelper", "can not calc download.");
                } else if (f(pInt.value, pInt2.value, false)) {
                    this.hTE = Math.max(this.hTE, pInt2.value);
                    return true;
                }
                return z2;
            case 3:
                bzW();
                if (this.hTG) {
                    if (this.hTD) {
                        l lVar2;
                        if (this.hTB != -1) {
                            this.yGT.F(this.hTB, true);
                            this.hTB = -1;
                            lVar2 = this;
                        } else if (this.yGT.bzM()) {
                            lVar2 = this;
                        } else {
                            z = true;
                            lVar2 = this;
                        }
                        lVar2.hTD = z;
                    }
                    this.yGT.Gh(i2);
                    return true;
                }
                this.yGT.aI(this.filename, false);
                this.hTG = true;
                return true;
            default:
                return true;
        }
    }

    public final boolean iI(int i) {
        boolean isVideoDataAvailable;
        Throwable e;
        if (this.hTx == 3) {
            return true;
        }
        if (this.hTE - i <= 2 && this.hTE < this.hTA) {
            return false;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.hTz.a(i, i + 2, pInt, pInt2)) {
                isVideoDataAvailable = o.TV().isVideoDataAvailable(this.mediaId, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    try {
                        this.hTE = i;
                    } catch (Exception e2) {
                        e = e2;
                        x.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
                        x.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
                        return isVideoDataAvailable;
                    }
                }
            }
            isVideoDataAvailable = false;
        } catch (Throwable e3) {
            e = e3;
            isVideoDataAvailable = false;
            x.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
            x.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
            return isVideoDataAvailable;
        }
        return isVideoDataAvailable;
    }

    private boolean a(int i, PInt pInt, PInt pInt2) {
        pInt.value = Math.max(i, this.hTE);
        if (this.hTy == 1) {
            pInt.value = i;
            pInt2.value = pInt.value + this.hTF;
        }
        if (this.hTy == 2) {
            pInt.value = i - 8;
            if (pInt.value < 0) {
                pInt.value = 0;
            }
            pInt2.value = (pInt.value + this.hTF) + 8;
        }
        if (this.hTy == 3 || this.hTy == 4) {
            pInt.value = this.hTE;
            pInt2.value = ((this.hTF + i) + 2) + this.yGU.hTO;
        }
        if (pInt2.value >= this.hTA + 1) {
            pInt2.value = this.hTA + 1;
        }
        if (pInt2.value <= pInt.value) {
            pInt2.value = pInt.value + this.yGU.hTO;
            return false;
        }
        x.i("MicroMsg.OnlineVideoUIHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.hTy), Integer.valueOf(this.hTE), Integer.valueOf(this.hTF)});
        return true;
    }

    private boolean f(int i, int i2, boolean z) {
        boolean isVideoDataAvailable;
        String str;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.hTz.a(i, i2, pInt, pInt2)) {
                isVideoDataAvailable = o.TV().isVideoDataAvailable(this.mediaId, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    x.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
                } else if (!this.rvq.containsKey(this.mediaId + 0 + "_-1")) {
                    str = this.mediaId + pInt.value + "_" + pInt2.value;
                    x.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.hTH), Boolean.valueOf(z)});
                    if (!this.rvq.containsKey(str) || (this.hTH && !z)) {
                        x.i("MicroMsg.OnlineVideoUIHelper", "already request video : " + str);
                    } else {
                        this.hTH = true;
                        o.TV();
                        com.tencent.mm.modelcdntran.f.f(this.mediaId, pInt.value, pInt2.value);
                        this.rvq.put(str, Integer.valueOf(i2));
                    }
                }
                return isVideoDataAvailable;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.OnlineVideoUIHelper", e, "", new Object[0]);
            x.e("MicroMsg.OnlineVideoUIHelper", "check video data error: " + e.toString());
        }
        isVideoDataAvailable = false;
        if (!isVideoDataAvailable) {
            x.i("MicroMsg.OnlineVideoUIHelper", "already had video data.");
        } else if (this.rvq.containsKey(this.mediaId + 0 + "_-1")) {
            str = this.mediaId + pInt.value + "_" + pInt2.value;
            x.i("MicroMsg.OnlineVideoUIHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.hTH), Boolean.valueOf(z)});
            if (this.rvq.containsKey(str)) {
            }
            x.i("MicroMsg.OnlineVideoUIHelper", "already request video : " + str);
        }
        return isVideoDataAvailable;
    }

    public final void cvo() {
        String str = this.mediaId + 0 + "_-1";
        if (!this.rvq.containsKey(str)) {
            x.i("MicroMsg.OnlineVideoUIHelper", "request all data. [%s]", new Object[]{this.mediaId});
            o.TV();
            com.tencent.mm.modelcdntran.f.f(this.mediaId, 0, -1);
            this.rvq.put(str, Integer.valueOf(0));
            com.tencent.mm.plugin.report.service.g.pQN.a(354, 24, 1, false);
            x.w("MicroMsg.OnlineVideoUIHelper", "%d rpt request all video %s ", new Object[]{Integer.valueOf(hashCode()), this.filename});
            com.tencent.mm.plugin.report.service.g.pQN.h(13836, new Object[]{Integer.valueOf(303), Long.valueOf(bh.Wo()), ""});
        }
        this.hTy = 5;
    }

    final void cvp() {
        o.TU();
        if (q.no(s.nt(this.filename))) {
            boolean b;
            x.i("MicroMsg.OnlineVideoUIHelper", "download finish and is hevc need complete %s ", new Object[]{this.filename});
            r nF = t.nF(this.filename);
            if (nF != null) {
                nF.videoFormat = 2;
                nF.status = 123;
                nF.hVG = bh.Wo();
                nF.hVF = bh.Wo();
                nF.htL = 19;
                nF.fDt = 268438786;
                b = o.TU().b(nF);
                x.i("MicroMsg.VideoLogic", "set hevc video Completion ret: " + b + " status: " + nF.status);
            } else {
                b = false;
            }
            if (b) {
                com.tencent.mm.plugin.report.service.g.pQN.a(354, 134, 1, false);
            }
        }
    }

    final void bzW() {
        if (this.rvv == 0) {
            this.rvv = bh.Wp();
        }
    }

    final Object[] cvq() {
        Object[] objArr = new Object[7];
        i iVar = this.yGT;
        if (iVar.rvj < 0) {
            iVar.rvj = 0;
        }
        x.i("MicroMsg.Imagegallery.handler.video", "get[%s] play video duration [%d]", new Object[]{iVar.filename, Integer.valueOf(iVar.rvj)});
        objArr[0] = Integer.valueOf(iVar.rvj);
        if (this.rvv <= 0) {
            this.rvv = bh.Wp();
        }
        int i = (int) (this.rvv - this.htG);
        if (i <= 0) {
            i = 0;
        }
        objArr[1] = Integer.valueOf(i);
        if (this.rvu <= 0) {
            this.rvu = bh.Wp();
        }
        i = (int) (this.rvu - this.htG);
        if (i <= 0) {
            i = 0;
        }
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(this.rvt);
        if (this.rvt > 0) {
            if (this.rvx == 0) {
                this.rvx = (int) (((long) this.rvx) + bh.bz(this.rvw));
            }
            objArr[4] = Integer.valueOf(this.rvx / this.rvt);
        } else {
            objArr[4] = Integer.valueOf(0);
        }
        i iVar2 = this.yGT;
        if (iVar2.rvd <= 0 || iVar2.rvc <= 0) {
            i = 0;
        } else {
            i = (int) (iVar2.rvd - iVar2.rvc);
        }
        if (i < 0) {
            i = 0;
        }
        x.i("MicroMsg.Imagegallery.handler.video", "%d filename[%s] get ui stay time[%d %d %d]", new Object[]{Integer.valueOf(iVar2.hashCode()), iVar2.filename, Integer.valueOf(i), Long.valueOf(iVar2.rvd), Long.valueOf(iVar2.rvc)});
        objArr[5] = Integer.valueOf(i);
        objArr[6] = Integer.valueOf(this.yGT.mvC);
        return objArr;
    }
}
