package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.h$a;
import com.tencent.mm.pluginsdk.ui.h$b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.d.a;

public class FtsVideoWrapper extends RelativeLayout implements h, h$a, h$b, c, a {
    private boolean avH;
    private h jtd;
    h$b jte;
    private g jtf;
    private d jtg;
    private boolean jth;
    private float jti;
    private int jtj;
    private boolean jtk;
    private com.tencent.mm.z.d jtl;
    private Context mContext;
    private String url;

    public FtsVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FtsVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jtg = d.vka;
        this.jth = false;
        this.jti = -1.0f;
        this.mContext = context;
        this.jtl = new com.tencent.mm.z.d();
    }

    public final void b(boolean z, String str, int i) {
        int i2;
        this.jtj = i;
        this.avH = z;
        PString pString = new PString();
        pString.value = str;
        bh.ov(pString.value);
        this.jtk = false;
        this.url = pString.value;
        if (this.jtd == null) {
            x.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[]{Integer.valueOf(hashCode())});
            this.jtd = ahf();
            i2 = 1;
        } else if (this.jtd instanceof MMVideoView) {
            this.jtd.stop();
            this.jtd.ahh();
            removeView((View) this.jtd);
            x.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[]{Integer.valueOf(hashCode())});
            this.jtd = ahf();
            i2 = 1;
        } else {
            x.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", new Object[]{Integer.valueOf(hashCode())});
            this.jtd.stop();
            boolean z2 = false;
        }
        a(this.jtg);
        aa(this.jti);
        setMute(this.jth);
        if (i2 != 0) {
            a(this.jtf);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            addView((View) this.jtd, layoutParams);
        }
        this.jtd.b(this.avH, this.url, this.jtj);
    }

    private h ahf() {
        h commonVideoView = new CommonVideoView(this.mContext);
        commonVideoView.tqb = this;
        commonVideoView.jte = this;
        return commonVideoView;
    }

    public final void a(g gVar) {
        this.jtf = gVar;
        if (this.jtd != null) {
            this.jtd.a(this.jtf);
        }
    }

    public final void ahh() {
        if (this.jtd != null) {
            this.jtd.ahh();
        }
    }

    public final boolean kI(int i) {
        if (this.jtd != null) {
            return this.jtd.kI(i);
        }
        return false;
    }

    public final boolean s(int i, boolean z) {
        if (this.jtd != null) {
            return this.jtd.s(i, z);
        }
        return false;
    }

    public final int ahi() {
        if (this.jtd != null) {
            return this.jtd.ahi();
        }
        return this.jtj;
    }

    public final int ahj() {
        if (this.jtd != null) {
            return this.jtd.ahj();
        }
        return 0;
    }

    public final int ahk() {
        if (this.jtd != null) {
            return this.jtd.ahk();
        }
        return 0;
    }

    public final int TH() {
        if (this.jtd != null) {
            return this.jtd.TH();
        }
        return 0;
    }

    public final boolean isPlaying() {
        if (this.jtd != null) {
            return this.jtd.isPlaying();
        }
        return false;
    }

    public final boolean agP() {
        if (this.jtd != null) {
            return this.jtd.agP();
        }
        return false;
    }

    public final void start() {
        if (this.jtd != null) {
            this.jtd.start();
            setKeepScreenOn(true);
            this.jtl.a(this);
        }
    }

    public final void stop() {
        if (this.jtd != null) {
            this.jtd.stop();
            this.jtl.bx(false);
            setKeepScreenOn(false);
        }
    }

    public final boolean pause() {
        if (this.jtd == null) {
            return false;
        }
        setKeepScreenOn(false);
        this.jtl.bx(false);
        return this.jtd.pause();
    }

    public final void setMute(boolean z) {
        this.jth = z;
        if (this.jtd != null) {
            this.jtd.setMute(this.jth);
        }
    }

    public final void TE() {
        if (this.jtd != null) {
            this.jtd.TE();
        }
    }

    public final void TD() {
        if (this.jtd != null) {
            this.jtd.TD();
        }
        this.jtl.bx(false);
        setKeepScreenOn(false);
    }

    public final void ahl() {
        if (this.jtd != null) {
            this.jtd.ahl();
        }
        this.jtl.bx(false);
        setKeepScreenOn(false);
    }

    public final void a(d dVar) {
        this.jtg = dVar;
        if (this.jtd != null) {
            this.jtd.a(this.jtg);
        }
    }

    public final boolean aa(float f) {
        if (f <= 0.0f) {
            return false;
        }
        this.jti = f;
        if (this.jtd != null) {
            return this.jtd.aa(this.jti);
        }
        return false;
    }

    public final void V(String str, boolean z) {
        x.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[]{Integer.valueOf(hashCode()), str, Boolean.valueOf(z)});
        if (!z) {
            int i;
            if (this.jtd instanceof MMVideoView) {
                this.jtd.stop();
                this.jtd.ahh();
                removeView((View) this.jtd);
                x.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", new Object[]{Integer.valueOf(hashCode())});
                this.jtd = ahf();
                i = 1;
            } else {
                i = 0;
            }
            a(this.jtg);
            aa(this.jti);
            setMute(this.jth);
            if (i != 0) {
                a(this.jtf);
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(13);
                addView((View) this.jtd, layoutParams);
                this.jtd.b(this.avH, this.url, this.jtj);
                this.jtd.start();
            }
        }
    }

    public final void c(String str, String str2, String str3, int i, int i2) {
        x.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[]{Integer.valueOf(hashCode()), str3, Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.jte != null) {
            this.jte.c(str, str2, str3, i, i2);
        }
    }

    public final void bk(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", new Object[]{Integer.valueOf(hashCode())});
        if (this.jte != null) {
            this.jte.bk(str, str2);
        }
    }

    public final void bl(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", new Object[]{Integer.valueOf(hashCode())});
        if (this.jte != null) {
            this.jte.bl(str, str2);
        }
    }

    public final void d(String str, String str2, int i, int i2) {
        x.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.jte != null) {
            this.jte.d(str, str2, i, i2);
        }
    }

    public final void bm(String str, String str2) {
        x.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", new Object[]{Integer.valueOf(hashCode())});
        setKeepScreenOn(false);
        this.jtl.bx(false);
        if (this.jte != null) {
            this.jte.bm(str, str2);
        }
    }

    public final void bn(String str, String str2) {
        x.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", new Object[]{Integer.valueOf(hashCode())});
        setKeepScreenOn(true);
        this.jtl.a(this);
        if (this.jte != null) {
            this.jte.bn(str, str2);
        }
    }

    public final void bo(String str, String str2) {
        if (this.jte != null) {
            this.jte.bo(str, str2);
        }
    }

    public final void bp(String str, String str2) {
        if (this.jte != null) {
            this.jte.bp(str, str2);
        }
    }

    public void setKeepScreenOn(boolean z) {
        x.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[]{Boolean.valueOf(z), bh.cgy()});
        super.setKeepScreenOn(z);
    }

    public final void a(long j, long j2, long j3, boolean z) {
        com.tencent.mm.plugin.report.service.g.pQN.a(600, j2, 1, false);
    }

    public final void k(int i, String str) {
        com.tencent.mm.plugin.report.service.g.pQN.k(14349, str);
    }
}
