package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.d;
import com.tencent.mm.z.d.a;

public class WebVideoWrapper extends RelativeLayout implements h, b, c, a {
    private boolean avH;
    private h jtd;
    private b jte;
    private int jtj;
    private d jtl;
    private Context mContext;
    private String url;

    public WebVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        this.jtl = new d();
        if (this.jtd == null) {
            h commonVideoView = new CommonVideoView(this.mContext);
            commonVideoView.tqb = this;
            commonVideoView.jte = this;
            a(600, 200, 1, false);
            this.jtd = commonVideoView;
        }
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        addView((View) this.jtd, layoutParams);
    }

    public final void b(boolean z, String str, int i) {
        this.jtj = i;
        this.avH = z;
        this.url = str;
        if (this.jtd != null) {
            this.jtd.b(this.avH, this.url, this.jtj);
        }
    }

    public final void a(g gVar) {
        if (this.jtd != null) {
            this.jtd.a(gVar);
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
        if (this.jtd != null) {
            this.jtd.setMute(z);
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

    public final void a(h.d dVar) {
        if (this.jtd != null) {
            this.jtd.a(dVar);
        }
    }

    public final boolean aa(float f) {
        if (f > 0.0f && this.jtd != null) {
            return this.jtd.aa(f);
        }
        return false;
    }

    public final void c(String str, String str2, String str3, int i, int i2) {
        x.w("MicroMsg.WebVideoWrapper", "%d onError[%s %d, %d]", new Object[]{Integer.valueOf(hashCode()), str3, Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.jte != null) {
            this.jte.c(str, str2, str3, i, i2);
        }
    }

    public final void bk(String str, String str2) {
        x.i("MicroMsg.WebVideoWrapper", "%d onPrepared", new Object[]{Integer.valueOf(hashCode())});
        if (this.jte != null) {
            this.jte.bk(str, str2);
        }
    }

    public final void bl(String str, String str2) {
        x.i("MicroMsg.WebVideoWrapper", "%d onVideoEnded", new Object[]{Integer.valueOf(hashCode())});
        if (this.jte != null) {
            this.jte.bl(str, str2);
        }
    }

    public final void d(String str, String str2, int i, int i2) {
        x.i("MicroMsg.WebVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.jte != null) {
            this.jte.d(str, str2, i, i2);
        }
    }

    public final void bm(String str, String str2) {
        x.d("MicroMsg.WebVideoWrapper", "%d onVideoPause", new Object[]{Integer.valueOf(hashCode())});
        setKeepScreenOn(false);
        this.jtl.bx(false);
        if (this.jte != null) {
            this.jte.bm(str, str2);
        }
    }

    public final void bn(String str, String str2) {
        x.d("MicroMsg.WebVideoWrapper", "%d onVideoPlay", new Object[]{Integer.valueOf(hashCode())});
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
        x.d("MicroMsg.WebVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[]{Boolean.valueOf(z), bh.cgy()});
        super.setKeepScreenOn(z);
    }

    public final void a(long j, long j2, long j3, boolean z) {
        com.tencent.mm.plugin.report.service.g.pQN.a(600, j2, 1, false);
    }

    public final void k(int i, String str) {
        com.tencent.mm.plugin.report.service.g.pQN.k(14349, str);
    }
}
