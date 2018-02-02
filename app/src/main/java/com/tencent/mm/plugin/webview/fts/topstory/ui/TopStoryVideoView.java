package com.tencent.mm.plugin.webview.fts.topstory.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.webview.fts.topstory.a.e;
import com.tencent.mm.plugin.webview.fts.topstory.ui.widget.TopStoryVideoPlayTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;

public class TopStoryVideoView extends MMVideoView {
    String fqu;

    public TopStoryVideoView(Context context) {
        this(context, null);
    }

    public TopStoryVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopStoryVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fqu = "";
        this.mContext = context;
    }

    protected final void TB() {
        this.hTJ.hTN = 4;
        this.hTJ.hTO = 2;
    }

    protected final f bB(Context context) {
        f topStoryVideoPlayTextureView = new TopStoryVideoPlayTextureView(context);
        topStoryVideoPlayTextureView.vyj = true;
        topStoryVideoPlayTextureView.gz(bPJ());
        topStoryVideoPlayTextureView.gA(true);
        return topStoryVideoPlayTextureView;
    }

    private boolean bPJ() {
        boolean z = false;
        try {
            g.Dk();
            z = g.Dj().CU().getBoolean(a.xtK, false);
        } catch (Throwable e) {
            x.printErrStackTrace(this.TAG, e, "check need reset error", new Object[z]);
        }
        return z;
    }

    public final void b(boolean z, String str, int i) {
        super.b(z, str, i);
    }

    protected final void initView() {
        super.initView();
        this.hTs = e.bPu();
        a(e.bPt().tnW);
        this.TAG = "MicroMsg.TopStoryVideoView";
    }

    public final boolean iI(int i) {
        boolean isVideoDataAvailable;
        Exception e;
        if (this.hTx == 3) {
            return true;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            boolean b;
            int i2;
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            if (i == 0 && this.hTz != null && bPJ()) {
                pInt4.value = 0;
                pInt3.value = 0;
                b = this.hTz.b(i + 1, pInt3, pInt4);
            } else {
                b = false;
            }
            int i3 = i + 1;
            if (b) {
                i2 = pInt4.value;
            } else {
                i2 = i3;
            }
            if (this.hTz == null || !this.hTz.a(i, i2, pInt, pInt2)) {
                return false;
            }
            isVideoDataAvailable = e.bPt().tnW.isVideoDataAvailable(this.hTu, pInt.value, pInt2.value);
            if (!isVideoDataAvailable) {
                return isVideoDataAvailable;
            }
            try {
                this.hTE = i2;
                return isVideoDataAvailable;
            } catch (Exception e2) {
                e = e2;
                x.e(this.TAG, "%s check video data error %s ", new Object[]{asN(), e.toString()});
                return isVideoDataAvailable;
            }
        } catch (Exception e3) {
            e = e3;
            isVideoDataAvailable = false;
            x.e(this.TAG, "%s check video data error %s ", new Object[]{asN(), e.toString()});
            return isVideoDataAvailable;
        }
    }

    public final void g(String str, int i, int i2) {
        if (bh.fu(this.hTu, str)) {
            x.d(this.TAG, "%s download  onProgress [%d, %d]", new Object[]{asN(), Integer.valueOf(i), Integer.valueOf(i2)});
            if (this.hTD && this.hTy == 3) {
                iH(ahk());
            }
        }
    }

    public final boolean s(int i, boolean z) {
        if (this.hTz != null) {
            int Ww = this.hTz.Ww();
            if (i > Ww && Ww > 0) {
                x.i(this.TAG, "%s seek to reset time ori[%d] last key frame[%d]", new Object[]{asN(), Integer.valueOf(i), Integer.valueOf(Ww)});
                i = Ww;
            }
        }
        return super.s(i, z);
    }

    protected final boolean a(int i, PInt pInt, PInt pInt2) {
        boolean z;
        pInt.value = Math.max(i, this.hTE);
        if (this.hTy == 1 || this.hTy == 0) {
            if (this.hTz == null || !bPJ()) {
                z = false;
            } else {
                pInt2.value = 0;
                pInt.value = 0;
                z = this.hTz.b(i + 1, pInt, pInt2);
            }
            if (!z) {
                pInt.value = i;
                pInt2.value = pInt.value + 4;
            }
        } else {
            z = false;
        }
        if (this.hTy == 2) {
            if (this.hTz != null) {
                z = this.hTz.b(i, pInt, pInt2);
                pInt2.value += 4;
            }
            if (!z) {
                pInt.value = i - 8;
                if (pInt.value < 0) {
                    pInt.value = 0;
                }
                pInt2.value = (pInt.value + this.hTF) + 8;
            }
        }
        if (this.hTy == 3 || this.hTy == 4) {
            pInt.value = this.hTE;
            pInt2.value = this.hTA + 1;
        }
        if (pInt2.value >= this.hTA + 1) {
            pInt2.value = this.hTA + 1;
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + 2;
            return false;
        }
        x.d(this.TAG, "%s calcDownloadRange2 range[%d, %d, %b] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[]{asN(), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(this.hTy), Integer.valueOf(this.hTE), Integer.valueOf(this.hTF), this.hTu});
        return true;
    }

    public final void Oh(String str) {
        this.fqu = str;
        start();
    }

    public final void start() {
        super.start();
        com.tencent.mm.plugin.report.service.g.pQN.h(791, 5);
    }

    protected final String nh(String str) {
        return e.Og(str);
    }

    public final boolean isPlaying() {
        boolean z;
        boolean isPlaying = super.isPlaying();
        if (isPlaying && this.hTy == 3) {
            z = true;
        } else {
            z = false;
        }
        x.d(this.TAG, "%s result [%b] is playing[%b] playStatus[%d]", new Object[]{asN(), Boolean.valueOf(z), Boolean.valueOf(isPlaying), Integer.valueOf(this.hTy)});
        return isPlaying;
    }

    public final int ahj() {
        int i = 0;
        if (this.kTe != null) {
            i = this.kTe.getCurrentPosition();
        }
        if (this.hTB > 0) {
            return this.hTB * 1000;
        }
        return i;
    }

    public final int ahk() {
        int i = 0;
        if (this.kTe != null) {
            i = Math.round((((float) this.kTe.getCurrentPosition()) * 1.0f) / 1000.0f);
        }
        if (this.hTB > 0) {
            return this.hTB;
        }
        return i;
    }

    public final void K(String str, int i) {
        super.K(str, i);
        if (i != 0 && this.jte != null) {
            this.jte.c(this.fqu, this.hTu, "download error", i, 0);
        }
    }

    public final void onError(int i, int i2) {
        super.onError(i, i2);
        switch (i2) {
            case -3:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkD);
                return;
            case -2:
                try {
                    g.Dk();
                    g.Dj().CU().a(a.xtK, Boolean.valueOf(true));
                    if (this.kTe instanceof TopStoryVideoPlayTextureView) {
                        ((TopStoryVideoPlayTextureView) this.kTe).gz(true);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace(this.TAG, e, "%s onError [%s]", new Object[]{asN(), e.toString()});
                }
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkC);
                return;
            case -1:
                com.tencent.mm.plugin.aj.a.a.a.pY(com.tencent.mm.plugin.aj.a.a.a.tkB);
                return;
            default:
                return;
        }
    }

    protected final boolean bPK() {
        return false;
    }

    public final void TE() {
        x.i(this.TAG, "%s onUIResume", new Object[]{asN()});
        if (!this.viL) {
            this.viL = true;
            if (this.kTe != null) {
                if (this.viS) {
                    play();
                } else {
                    ((VideoPlayerTextureView) this.kTe).aZM();
                }
            }
            fv(110);
        }
    }

    public final void TD() {
        x.i(this.TAG, "%s onUIPause", new Object[]{asN()});
        if (this.viL) {
            this.viR = ahk();
            this.viS = isPlaying();
            this.viY = 0;
            this.viX = 0;
            pause();
            TG();
            this.viL = false;
            fv(111);
        }
    }

    protected final String bPL() {
        return this.fqu;
    }

    public final void bPM() {
        ((TopStoryVideoPlayTextureView) this.kTe).setAlpha(1.0f);
    }
}
