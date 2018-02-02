package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.h$d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class MMVideoView extends CommonVideoView implements a {
    public int hTA;
    public int hTB;
    private boolean hTC;
    public boolean hTD;
    public int hTE = 0;
    public int hTF;
    private boolean hTG = false;
    private boolean hTH = false;
    private boolean hTI = false;
    public a hTJ;
    private boolean hTK = false;
    private ak hTL = new ak(new 1(this), true);
    public String hTs;
    private b hTt;
    public String hTu;
    private String hTv;
    public h.a hTw;
    public int hTx = 0;
    public int hTy = 0;
    public f hTz;

    public MMVideoView(Context context) {
        super(context);
    }

    public MMVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initView() {
        super.initView();
        this.TAG = "MicroMsg.MMVideoView";
        this.hTz = new f();
        this.hTJ = new a();
        TB();
        reset();
    }

    public void TB() {
        this.hTJ.hTN = 5;
        this.hTJ.hTO = 2;
    }

    private void reset() {
        this.hTB = -1;
        this.hTE = 0;
        this.hTA = 0;
        this.hTy = 0;
        this.hTx = 0;
        this.hTD = false;
        this.hTG = false;
        this.hTH = false;
        if (this.hTJ != null) {
            this.hTF = this.hTJ.hTN;
        }
    }

    public final void a(b bVar) {
        this.hTt = bVar;
        this.hTt.a(this);
    }

    public void b(boolean z, String str, int i) {
        super.b(z, str, i);
        if (!bh.ov(str)) {
            this.hTu = "MMVideo_" + str.hashCode();
            this.hTv = nh(str);
            e.bU(this.hTv);
            x.i(this.TAG, "%s set video path [%s %s]", new Object[]{asN(), this.hTu, this.hTv});
        }
    }

    public String nh(String str) {
        return (!bh.ov(this.hTs) ? this.hTs : com.tencent.mm.compatible.util.e.bnF + "appbrandvideo/") + "MMVideo_" + str.hashCode() + ".mp4";
    }

    private void TC() {
        if (this.kTe != null) {
            this.hTG = true;
            this.kTe.setVideoPath(this.hTv);
        }
    }

    public void TD() {
        super.TD();
        if (this.hTK) {
            this.hTI = true;
            stop();
        }
    }

    public void TE() {
        super.TE();
        x.i(this.TAG, "%s onUIResume stopDownloadByUiPause[%b] currTimeOnUiPause[%d] isPlayOnUiPause[%b]", new Object[]{asN(), Boolean.valueOf(this.hTI), Integer.valueOf(this.viR), Boolean.valueOf(this.viS)});
        if (this.hTI) {
            s(this.viR, this.viS);
        } else if (this.kTe != null && d.fM(24) && (this.kTe instanceof VideoPlayerTextureView)) {
            ((VideoPlayerTextureView) this.kTe).aZM();
        }
    }

    public void start() {
        x.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d]", new Object[]{asN(), this.hTu, Integer.valueOf(this.hTA)});
        if (this.kTe != null) {
            if (bh.ov(this.kTe.Ur())) {
                alw();
                this.hTK = true;
                this.hTA = 0;
                this.hTx = 1;
                this.hTt.o(this.hTu, this.hTv, this.url);
                this.hTt.a(this);
                bzW();
            } else {
                play();
            }
            fv(101);
        }
    }

    public final void vh() {
        this.hTt.ng(this.hTu);
        reset();
        if (this.kTe != null) {
            this.kTe.stop();
        }
        super.vh();
    }

    public final void stop() {
        this.hTt.ng(this.hTu);
        reset();
        super.stop();
    }

    public com.tencent.mm.pluginsdk.ui.tools.f bB(Context context) {
        this.viT = 1;
        com.tencent.mm.pluginsdk.ui.tools.f videoPlayerTextureView = new VideoPlayerTextureView(context);
        videoPlayerTextureView.gz(true);
        return videoPlayerTextureView;
    }

    public final void a(h$d com_tencent_mm_pluginsdk_ui_h_d) {
        if (this.kTe instanceof VideoPlayerTextureView) {
            VideoPlayerTextureView videoPlayerTextureView = (VideoPlayerTextureView) this.kTe;
            videoPlayerTextureView.vys.a(com_tencent_mm_pluginsdk_ui_h_d);
            videoPlayerTextureView.requestLayout();
            fv(114);
        }
    }

    public final boolean iH(int i) {
        int i2;
        boolean z = false;
        if (this.hTB != -1) {
            i2 = this.hTB;
        } else {
            i2 = i;
        }
        x.i(this.TAG, "%s check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s isPrepareVideo[%b]", new Object[]{asN(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.hTE), Integer.valueOf(this.hTA), Integer.valueOf(this.hTy), Integer.valueOf(this.hTx), this.hTu, Boolean.valueOf(this.hTG)});
        switch (this.hTx) {
            case 1:
                boolean z2;
                if (!iI(i2)) {
                    this.hTD = true;
                    if (this.hTE > 0) {
                        x.i(this.TAG, "%s pause by load data cdnMediaId %s, playStatus %d", new Object[]{asN(), this.hTu, Integer.valueOf(this.hTy)});
                        bZR();
                        if (!(this.hTy == 2 || this.hTy == 4)) {
                            this.hTF += this.hTJ.hTN;
                            this.hTF = Math.min(this.hTF, 60);
                            bZT();
                            this.hTy = 4;
                        }
                        TF();
                    } else if (this.hTB == -1) {
                        this.hTy = 1;
                    } else {
                        this.hTy = 2;
                    }
                    z2 = false;
                } else if (this.hTG) {
                    MMVideoView mMVideoView;
                    int i3;
                    mK(i2);
                    if (this.hTD) {
                        bZS();
                        bZU();
                        x.i(this.TAG, "%s resume by data gain cdnMediaId %s", new Object[]{asN(), this.hTu});
                        if (this.hTB != -1) {
                            s(this.hTB, this.hTC);
                            this.hTB = -1;
                            z2 = false;
                            mMVideoView = this;
                        } else if (play()) {
                            z2 = false;
                            mMVideoView = this;
                        } else {
                            z2 = true;
                            mMVideoView = this;
                        }
                        mMVideoView.hTD = z2;
                        i3 = 3;
                        mMVideoView = this;
                    } else {
                        if (this.hTy != 3) {
                            x.i(this.TAG, "%s start to play video playStatus[%d]", new Object[]{asN(), Integer.valueOf(this.hTy)});
                            if (play()) {
                                i3 = 3;
                                mMVideoView = this;
                            } else {
                                i3 = this.hTy;
                                mMVideoView = this;
                            }
                        }
                        z2 = true;
                    }
                    mMVideoView.hTy = i3;
                    z2 = true;
                } else {
                    x.i(this.TAG, "%s prepare cdnMediaId [%s]", new Object[]{asN(), this.hTu});
                    if (this.hTy == 5) {
                        this.hTy = 1;
                    }
                    TC();
                    z2 = true;
                }
                mK(i2);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (!a(i2, pInt, pInt2)) {
                    x.d(this.TAG, "%s can not calc download.", new Object[]{asN()});
                } else if (f(pInt.value, pInt2.value, false)) {
                    this.hTE = Math.max(this.hTE, pInt2.value);
                    return true;
                }
                return z2;
            case 2:
                x.w(this.TAG, "%s download error.", new Object[]{asN()});
                return false;
            case 3:
                if (this.hTG) {
                    if (this.hTD) {
                        MMVideoView mMVideoView2;
                        if (this.hTB != -1) {
                            s(this.hTB, true);
                            this.hTB = -1;
                            mMVideoView2 = this;
                        } else if (play()) {
                            mMVideoView2 = this;
                        } else {
                            z = true;
                            mMVideoView2 = this;
                        }
                        mMVideoView2.hTD = z;
                    }
                    this.hTy = 3;
                    mK(i2);
                    return true;
                }
                if (this.hTy == 5) {
                    this.hTy = 1;
                }
                TC();
                return true;
            default:
                x.w(this.TAG, "%s check time default.", new Object[]{asN()});
                return false;
        }
    }

    public boolean s(int i, boolean z) {
        boolean z2;
        switch (this.hTx) {
            case 0:
                if (!isPrepared()) {
                    if (this.viW) {
                        this.viU = z;
                        this.hTC = z;
                        this.viV = i;
                        this.hTB = i;
                    } else {
                        this.viU = z;
                        this.viV = this.viR;
                    }
                    start();
                    break;
                }
                break;
            case 1:
                this.hTy = 2;
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                a(i, pInt, pInt2);
                if (!f(pInt.value, pInt2.value, true)) {
                    this.hTB = i;
                    this.hTC = z;
                    this.hTD = true;
                    TF();
                    z2 = false;
                    break;
                }
                this.hTB = -1;
                this.hTD = false;
                this.hTE = pInt2.value;
                this.hTy = 3;
                super.s(i, z);
                z2 = true;
                break;
            case 2:
                z2 = true;
                break;
            case 3:
                super.s(i, z);
                z2 = true;
                break;
        }
        z2 = true;
        x.k(this.TAG, "%s seek video time %d, download status %d playStatus %d", new Object[]{asN(), Integer.valueOf(i), Integer.valueOf(this.hTx), Integer.valueOf(this.hTy)});
        return z2;
    }

    public final void bW(boolean z) {
        super.bW(z);
        aUZ();
    }

    public boolean iI(int i) {
        Exception e;
        if (this.hTx == 3) {
            return true;
        }
        if (this.hTE - i <= 1 && this.hTE < this.hTA) {
            return false;
        }
        boolean isVideoDataAvailable;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.hTz.a(i, i + 1, pInt, pInt2)) {
                isVideoDataAvailable = this.hTt.isVideoDataAvailable(this.hTu, pInt.value, pInt2.value);
                if (!isVideoDataAvailable) {
                    try {
                        this.hTE = i;
                    } catch (Exception e2) {
                        e = e2;
                        x.e(this.TAG, "%s check video data error %s ", new Object[]{asN(), e.toString()});
                        return isVideoDataAvailable;
                    }
                }
            }
            isVideoDataAvailable = false;
        } catch (Exception e3) {
            e = e3;
            isVideoDataAvailable = false;
            x.e(this.TAG, "%s check video data error %s ", new Object[]{asN(), e.toString()});
            return isVideoDataAvailable;
        }
        return isVideoDataAvailable;
    }

    public boolean a(int i, PInt pInt, PInt pInt2) {
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
            pInt2.value = ((this.hTF + i) + 1) + this.hTJ.hTO;
        }
        if (pInt2.value >= this.hTA + 1) {
            pInt2.value = this.hTA + 1;
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + this.hTJ.hTO;
            return false;
        }
        x.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[]{asN(), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.hTy), Integer.valueOf(this.hTE), Integer.valueOf(this.hTF), this.hTu});
        return true;
    }

    private void TF() {
        x.i(this.TAG, "%s pauseByDataBlock ", new Object[]{asN()});
        alw();
        pause();
    }

    public final boolean pause() {
        boolean pause = super.pause();
        if (pause) {
            this.hTy = 4;
        }
        return pause;
    }

    public final boolean play() {
        boolean play = super.play();
        if (play) {
            this.hTy = 3;
        }
        return play;
    }

    private boolean f(int i, int i2, boolean z) {
        boolean isVideoDataAvailable;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.hTz.a(i, i2, pInt, pInt2)) {
                isVideoDataAvailable = this.hTt.isVideoDataAvailable(this.hTu, pInt.value, pInt2.value);
                if (isVideoDataAvailable) {
                    String str = this.hTu + "_" + pInt.value + "_" + pInt2.value;
                    if (this.hTH || z) {
                        this.hTH = true;
                        this.hTt.h(this.hTu, pInt.value, pInt2.value);
                    } else {
                        x.d(this.TAG, "%s already request video [%s] isRequestNow[%b] isSeek[%b] ", new Object[]{asN(), str, Boolean.valueOf(this.hTH), Boolean.valueOf(z)});
                    }
                } else {
                    x.d(this.TAG, "%s already had video data.", new Object[]{asN()});
                }
                return isVideoDataAvailable;
            }
        } catch (Exception e) {
            x.e(this.TAG, "%s check video data error[%s] ", new Object[]{asN(), e.toString()});
        }
        isVideoDataAvailable = false;
        if (isVideoDataAvailable) {
            x.d(this.TAG, "%s already had video data.", new Object[]{asN()});
        } else {
            String str2 = this.hTu + "_" + pInt.value + "_" + pInt2.value;
            if (this.hTH) {
            }
            this.hTH = true;
            this.hTt.h(this.hTu, pInt.value, pInt2.value);
        }
        return isVideoDataAvailable;
    }

    public final void iG(int i) {
        x.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s", new Object[]{asN(), Integer.valueOf(i), Integer.valueOf(this.hTA), this.hTu});
        if (this.hTA != 0) {
            x.w(this.TAG, "moov had callback, do nothing.");
            return;
        }
        bZQ();
        try {
            if (this.hTz == null) {
                x.w(this.TAG, "%s parser is null, thread is error.", new Object[]{asN()});
            } else if (this.hTz.r(this.hTv, (long) i)) {
                this.hTA = this.hTz.ifa;
                x.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[]{asN(), Integer.valueOf(this.hTA), this.hTu});
                if (iH(0)) {
                    TC();
                }
                if (this.hTB == -1) {
                    this.hTy = 1;
                } else {
                    this.hTy = 2;
                }
            } else {
                x.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[]{asN(), this.hTu});
                this.hTt.h(this.hTu, 0, -1);
            }
        } catch (Throwable e) {
            x.printErrStackTrace(this.TAG, e, "%s deal moov ready error [%s]", new Object[]{asN(), this.hTu});
        }
    }

    public final void onDataAvailable(String str, int i, int i2) {
        this.hTH = false;
        if (i < 0 || i2 < 0) {
            x.w(this.TAG, "%s deal data available error offset[%d], length[%d]", new Object[]{asN(), Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (bh.fu(this.hTu, str)) {
            try {
                this.hTE = this.hTz.bu(i, i2);
            } catch (Exception e) {
                x.e(this.TAG, "%s deal data available file pos to video time error[%s] ", new Object[]{asN(), e.toString()});
            }
            x.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[]{asN(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.hTE)});
            bX(true);
        }
    }

    public void g(String str, int i, int i2) {
        if (bh.fu(this.hTu, str)) {
            x.d(this.TAG, "%s download  onProgress [%d, %d]", new Object[]{asN(), Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public void K(String str, int i) {
        if (bh.fu(this.hTu, str) && this.hTx != 3) {
            x.i(this.TAG, "%s download finish [%d]", new Object[]{asN(), Integer.valueOf(i)});
            if (i == 0) {
                this.hTx = 3;
            }
            if (this.hTw != null) {
                boolean z;
                h.a aVar = this.hTw;
                String str2 = this.hTv;
                if (this.hTy > 0) {
                    z = true;
                } else {
                    z = false;
                }
                aVar.V(str2, z);
            }
            bX(true);
            this.hTH = false;
        }
    }

    public final void bX(boolean z) {
        x.d(this.TAG, "%s start timer rightNow[%b]", new Object[]{asN(), Boolean.valueOf(z)});
        this.hTL.TG();
        this.hTL.J(500, 500);
    }

    public final void TG() {
        this.hTL.TG();
    }

    public final int TH() {
        if (this.hTx == 3) {
            return ahi();
        }
        return this.hTE;
    }

    public final void TI() {
    }

    public final int TJ() {
        return 100;
    }

    public final String getMediaId() {
        return this.hTu;
    }
}
