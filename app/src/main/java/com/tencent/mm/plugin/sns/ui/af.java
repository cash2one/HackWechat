package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.k.g;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.aq.5;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class af {
    aqr fHC;
    String frH;
    int hTA;
    int hTB;
    boolean hTD;
    int hTE = 0;
    private int hTF;
    boolean hTG = false;
    boolean hTH = false;
    String hTu;
    String hTv;
    int hTx = 0;
    int hTy = 0;
    f hTz;
    long htG;
    int hzW;
    int progress;
    int qhf;
    HashMap<String, Integer> rvq = null;
    a rvr;
    int rvs;
    private int rvt = 0;
    long rvu;
    private long rvv;
    private long rvw;
    private int rvx;
    private b rvy;

    public af(a aVar) {
        this.rvr = aVar;
        this.hTz = new f();
        this.rvq = new HashMap();
        this.rvy = new b((byte) 0);
        this.rvy.hTN = g.zY().getInt("SnsVideoPreloadSec", 5);
        this.rvy.hTO = g.zY().getInt("SnsVideoDownloadSec", 1);
        this.rvy.rvA = g.zY().getInt("SnsVideoFullDownloadPercent", 101);
        x.i("MicroMsg.OnlineVideoViewHelper", "parseConfig preload[%d] downloadSec[%d], needFinish[%d]", new Object[]{Integer.valueOf(this.rvy.hTN), Integer.valueOf(this.rvy.hTO), Integer.valueOf(this.rvy.rvA)});
        reset();
    }

    public final void clear() {
        x.i("MicroMsg.OnlineVideoViewHelper", "clear");
        reset();
        this.rvr = null;
        this.hTz = null;
    }

    private void reset() {
        this.hTu = "";
        this.hTB = -1;
        this.hTE = 0;
        this.hTA = 0;
        this.rvt = 0;
        this.hTy = 0;
        this.hTx = 0;
        this.hTD = false;
        this.hTG = false;
        this.hTH = false;
        this.rvq.clear();
        this.fHC = null;
        this.hzW = 0;
        this.frH = null;
        if (this.rvy != null) {
            this.hTF = this.rvy.hTN;
        }
        this.rvu = 0;
        this.htG = 0;
        this.rvx = 0;
        this.rvw = 0;
        this.rvv = 0;
    }

    public final boolean bzU() {
        if (!bh.ov(this.hTu)) {
            x.i("MicroMsg.OnlineVideoViewHelper", "stop online download video %s isFinish %b percent %d", new Object[]{this.hTu, Boolean.valueOf(this.hTx == 3), Integer.valueOf(this.rvs)});
            aq bvt = ae.bvt();
            String str = this.hTu;
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(this.rvr.bzP());
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
            objArr[5] = Integer.valueOf(this.rvr.bzR());
            objArr[6] = Integer.valueOf(this.rvr.bzQ());
            if (!bh.ov(str)) {
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Dm().F(new 5(bvt, str, objArr));
            }
            if (this.rvs >= this.rvy.rvA && !r0) {
                ae.bvt().a(this.fHC, this.hzW, this.frH, false, false, 36);
            }
            com.tencent.mm.plugin.report.service.g.pQN.a(354, 203, 1, false);
        }
        return true;
    }

    public final boolean LT(String str) {
        return bh.fu(this.hTu, str);
    }

    public final boolean iH(int i) {
        int i2;
        boolean z = false;
        if (this.hTB != -1) {
            i2 = this.hTB;
        } else {
            i2 = i;
        }
        x.i("MicroMsg.OnlineVideoViewHelper", "check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s firPlayWait{%d} isPrepareVideo[%b]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.hTE), Integer.valueOf(this.hTA), Integer.valueOf(this.hTy), Integer.valueOf(this.hTx), this.hTu, Long.valueOf(this.rvv - this.htG), Boolean.valueOf(this.hTG)});
        switch (this.hTx) {
            case 1:
                boolean z2;
                boolean z3;
                if (iI(i2)) {
                    bzW();
                    if (!this.hTG) {
                        x.i("MicroMsg.OnlineVideoViewHelper", "prepare cdnMediaId [%s]", new Object[]{this.hTu});
                        if (this.hTy == 5) {
                            this.hTy = 1;
                        }
                        this.rvr.aI(this.hTv, true);
                        this.hTG = true;
                        z2 = true;
                    } else if (this.hTD) {
                        if (this.rvt == 0 && this.rvv == 0) {
                            bzW();
                        } else if (this.rvw > 0) {
                            this.rvx = (int) (((long) this.rvx) + bh.bz(this.rvw));
                        }
                        x.i("MicroMsg.OnlineVideoViewHelper", "resume by data gain.pauseByLoadDataCount %d pauseAllTime %d cdnMediaId %s", new Object[]{Integer.valueOf(this.rvt), Integer.valueOf(this.rvx), this.hTu});
                        this.hTy = 3;
                        if (this.hTB != -1) {
                            this.rvr.sD(this.hTB);
                            this.hTB = -1;
                            this.hTD = false;
                            z2 = true;
                        } else {
                            this.hTD = !this.rvr.bzM();
                            z2 = true;
                        }
                    } else {
                        if (this.hTy != 3) {
                            x.i("MicroMsg.OnlineVideoViewHelper", "start to play video playStatus[%d]", new Object[]{Integer.valueOf(this.hTy)});
                            this.hTy = this.rvr.bzM() ? 3 : this.hTy;
                        }
                        z2 = true;
                    }
                } else {
                    this.hTD = true;
                    if (this.hTE > 0) {
                        x.i("MicroMsg.OnlineVideoViewHelper", "pause by load data cdnMediaId %s, pauseByLoadDataCount %d, playStatus %d", new Object[]{this.hTu, Integer.valueOf(this.rvt), Integer.valueOf(this.hTy)});
                        this.rvw = bh.Wp();
                        if (!(this.hTy == 2 || this.hTy == 4)) {
                            this.hTF += this.rvy.hTN;
                            this.hTF = Math.min(this.hTF, 60);
                            this.rvt++;
                            this.hTy = 4;
                        }
                        this.rvr.TF();
                    } else if (this.hTB == -1) {
                        this.hTy = 1;
                    } else {
                        this.hTy = 2;
                    }
                    z2 = false;
                }
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                pInt.value = Math.max(i2, this.hTE);
                if (this.hTy == 1) {
                    pInt.value = i2;
                    pInt2.value = pInt.value + this.hTF;
                }
                if (this.hTy == 2) {
                    pInt.value = i2 - 8;
                    if (pInt.value < 0) {
                        pInt.value = 0;
                    }
                    pInt2.value = (pInt.value + this.hTF) + 8;
                }
                if (this.hTy == 3 || this.hTy == 4) {
                    pInt.value = this.hTE;
                    pInt2.value = ((this.hTF + i2) + 1) + this.rvy.hTO;
                }
                if (pInt2.value >= this.hTA + 1) {
                    pInt2.value = this.hTA + 1;
                }
                if (pInt2.value < pInt.value) {
                    pInt2.value = pInt.value + this.rvy.hTO;
                    z3 = false;
                } else {
                    x.i("MicroMsg.OnlineVideoViewHelper", "calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i2), Integer.valueOf(this.hTy), Integer.valueOf(this.hTE), Integer.valueOf(this.hTF)});
                    z3 = true;
                }
                if (!z3) {
                    x.d("MicroMsg.OnlineVideoViewHelper", "can not calc download.");
                    o.TV();
                    com.tencent.mm.modelcdntran.f.f(this.hTu, 0, -1);
                } else if (dC(pInt.value, pInt2.value)) {
                    this.hTE = Math.max(this.hTE, pInt2.value);
                    return true;
                }
                return z2;
            case 2:
                x.w("MicroMsg.OnlineVideoViewHelper", "download error.");
                return true;
            case 3:
                bzW();
                if (this.hTG) {
                    if (this.hTD) {
                        af afVar;
                        if (this.hTB != -1) {
                            this.rvr.sD(this.hTB);
                            this.hTB = -1;
                            afVar = this;
                        } else if (this.rvr.bzM()) {
                            afVar = this;
                        } else {
                            z = true;
                            afVar = this;
                        }
                        afVar.hTD = z;
                    }
                    this.hTy = 3;
                    return true;
                }
                if (this.hTy == 5) {
                    this.hTy = 1;
                }
                this.rvr.aI(this.hTv, false);
                this.hTG = true;
                return true;
            default:
                x.w("MicroMsg.OnlineVideoViewHelper", "check time default.");
                return true;
        }
    }

    private boolean iI(int i) {
        if (this.hTx == 3) {
            return true;
        }
        if (this.hTE - i <= 1 && this.hTE < this.hTA) {
            return false;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (!this.hTz.a(i, i + 1, pInt, pInt2)) {
                return false;
            }
            boolean isVideoDataAvailable = o.TV().isVideoDataAvailable(this.hTu, pInt.value, pInt2.value);
            if (isVideoDataAvailable) {
                return isVideoDataAvailable;
            }
            this.hTE = i;
            return isVideoDataAvailable;
        } catch (Exception e) {
            x.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + e.toString());
            return false;
        }
    }

    private boolean dC(int i, int i2) {
        boolean isVideoDataAvailable;
        String str;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.hTz.a(i, i2, pInt, pInt2)) {
                pInt2.value += 81920;
                isVideoDataAvailable = o.TV().isVideoDataAvailable(this.hTu, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    x.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
                } else if (!this.rvq.containsKey(this.hTu + 0 + "_-1")) {
                    str = this.hTu + pInt.value + "_" + pInt2.value;
                    x.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.hTH), Boolean.valueOf(false)});
                    if (!this.rvq.containsKey(str) || this.hTH) {
                        x.i("MicroMsg.OnlineVideoViewHelper", "already request video : " + str);
                    } else {
                        this.hTH = true;
                        o.TV();
                        com.tencent.mm.modelcdntran.f.f(this.hTu, pInt.value, pInt2.value);
                        this.rvq.put(str, Integer.valueOf(i2));
                    }
                }
                return isVideoDataAvailable;
            }
        } catch (Exception e) {
            x.e("MicroMsg.OnlineVideoViewHelper", "check video data error: " + e.toString());
        }
        isVideoDataAvailable = false;
        if (!isVideoDataAvailable) {
            x.i("MicroMsg.OnlineVideoViewHelper", "already had video data.");
        } else if (this.rvq.containsKey(this.hTu + 0 + "_-1")) {
            str = this.hTu + pInt.value + "_" + pInt2.value;
            x.i("MicroMsg.OnlineVideoViewHelper", "request video data [%d, %d] isRequestNow[%b] isSeek[%b]", new Object[]{Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(this.hTH), Boolean.valueOf(false)});
            if (this.rvq.containsKey(str)) {
            }
            x.i("MicroMsg.OnlineVideoViewHelper", "already request video : " + str);
        }
        return isVideoDataAvailable;
    }

    final void bzV() {
        x.i("MicroMsg.OnlineVideoViewHelper", "play offline video %s ", new Object[]{this.hTu});
        bzW();
        ag.y(new 2(this));
    }

    final void bzW() {
        if (this.rvv == 0) {
            this.rvv = bh.Wp();
        }
    }
}
