package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.ah.a$e;
import com.tencent.mm.plugin.ah.a$f;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f$b;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.d$a;

public class VideoPlayView extends RelativeLayout implements f, d$a {
    private int duration = 0;
    public String hDC;
    private af hae = new af();
    public View jWc;
    private boolean kTc = false;
    public f kTe = null;
    private ProgressBar lpy;
    private int quY = 320;
    private int quZ = 240;
    private boolean qva = true;
    public a qvb;
    private ViewGroup qvc;
    public a qvd;
    private double qve = 0.0d;
    public TextView qvf;
    public String qvg = "";
    public View qvh;
    public View qvi;
    public boolean qvj = true;
    private int qvk = 0;
    private int qvl = 0;
    private boolean qvm = false;
    private boolean qvn = false;
    private long qvo = 0;
    private Animation qvp = new AlphaAnimation(1.0f, 0.0f);
    private Animation qvq = new AlphaAnimation(0.0f, 1.0f);
    private Runnable qvr = new 4(this);
    public int qvs = 0;

    static /* synthetic */ void m(VideoPlayView videoPlayView) {
        if (videoPlayView.qvh.getVisibility() == 0) {
            videoPlayView.btf();
        } else {
            videoPlayView.bte();
        }
    }

    public final void setVideoPath(String str) {
        this.hDC = str;
        x.i("MicroMsg.VideoPlayView", "videoPath  %s", new Object[]{this.hDC});
        this.kTe.setVideoPath(this.hDC);
    }

    public VideoPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public VideoPlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.qvp.setDuration(200);
        this.qvq.setDuration(200);
        View.inflate(getContext(), a$f.qGd, this);
        this.qvh = findViewById(a$e.sdx);
        this.qvi = findViewById(a$e.sdw);
        this.lpy = (ProgressBar) findViewById(a$e.cEd);
        this.qvc = (ViewGroup) findViewById(a$e.cUI);
        this.kTe = n.er(getContext());
        this.kTe.cP(false);
        this.qvc.addView((View) this.kTe, 0, new LayoutParams(-1, -1));
        this.qvf = (TextView) findViewById(a$e.cOg);
        this.jWc = this.qvf;
        this.kTe.a(new 1(this));
        if (this.kTe instanceof VideoSightView) {
            ((VideoSightView) this.kTe).rmu = false;
        }
        setOnTouchListener(new 2(this));
        btf();
        ((View) this.kTe).post(new 3(this));
    }

    public final void ib(boolean z) {
        this.qvm = z;
        if (this.kTe != null && (this.kTe instanceof VideoSightView)) {
            VideoSightView videoSightView = (VideoSightView) this.kTe;
            if (videoSightView.quA != null) {
                videoSightView.quA.qtF = !z;
            }
        }
    }

    public final void btd() {
        this.lpy.setVisibility(0);
    }

    private void bte() {
        ((View) this.qvd).setVisibility(0);
        this.qvh.setVisibility(0);
        if (this.qvj) {
            this.qvi.setVisibility(0);
        }
        int i = this.qvs == 2 ? 0 : bh.ov(this.qvg) ? 0 : 1;
        if (i != 0) {
            this.jWc.setVisibility(0);
        }
        this.hae.removeCallbacks(this.qvr);
        this.hae.postDelayed(this.qvr, 3000);
    }

    public final void btf() {
        if (this.qvd != null) {
            ((View) this.qvd).setVisibility(4);
        }
        this.qvh.setVisibility(8);
        this.qvi.setVisibility(8);
        this.jWc.setVisibility(8);
    }

    public final boolean start() {
        ic(true);
        return true;
    }

    public final void pause() {
        wm(-1);
    }

    private void ic(boolean z) {
        this.kTe.q(this.qve);
        this.kTe.start();
        x.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.qve);
        if (this.qvb != null) {
            this.qvb.ie(z);
        }
    }

    private void wm(int i) {
        this.qve = i >= 0 ? (double) i : this.kTe.btg();
        x.i("MicroMsg.VideoPlayView", "pause play " + this.qve + " lastTime: " + i + " last " + this.kTe.btg());
        this.kTe.pause();
        this.hae.post(new 7(this));
        if (this.qvb != null) {
            this.qvb.bti();
        }
    }

    public final boolean isPlaying() {
        return this.kTe.isPlaying();
    }

    public final String Ur() {
        return this.hDC;
    }

    public final boolean k(Context context, boolean z) {
        return this.kTe.k(context, z);
    }

    public final void stop() {
        this.kTe.stop();
    }

    public final void onDetach() {
        this.kTe.onDetach();
    }

    public final void cP(boolean z) {
        this.kTe.cP(z);
    }

    public final double btg() {
        return Math.max(this.qve, this.kTe.btg());
    }

    public final void a(a aVar) {
        this.kTe.a(aVar);
    }

    public final int getCurrentPosition() {
        return this.kTe.getCurrentPosition();
    }

    public final int getDuration() {
        if (this.duration == 0) {
            return this.kTe.getDuration();
        }
        return this.duration;
    }

    public final void q(double d) {
        this.kTe.q(d);
        this.qvd.seek((int) d);
    }

    public final void id(boolean z) {
        this.kTe.id(z);
    }

    public final void update(int i) {
        ViewGroup.LayoutParams layoutParams;
        this.qvn = true;
        if (this.qvl == 0 || this.qvk == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.qvl = displayMetrics.heightPixels;
            this.qvk = displayMetrics.widthPixels;
            if (this.qvl < this.qvk) {
                this.qvl = displayMetrics.widthPixels;
                this.qvk = displayMetrics.heightPixels;
            }
            x.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.qvl + " screen_width:" + this.qvk);
        }
        ViewGroup.LayoutParams layoutParams2 = this.qvc.getLayoutParams();
        if (this.qvd == null) {
            layoutParams = null;
        } else {
            layoutParams = (LayoutParams) ((View) this.qvd).getLayoutParams();
        }
        ViewGroup.LayoutParams layoutParams3 = new LayoutParams(-1, -1);
        if (i == 1) {
            layoutParams3.width = this.qvk;
            layoutParams3.height = (int) (((((double) this.qvk) * 1.0d) * ((double) this.quZ)) / ((double) this.quY));
            if (this.qvd != null) {
                layoutParams.bottomMargin = b.b(getContext(), 0.0f);
            }
        } else {
            layoutParams3.height = this.qvk;
            layoutParams3.width = (int) (((((double) this.qvk) * 1.0d) * ((double) this.quY)) / ((double) this.quZ));
            if (this.qvd != null) {
                layoutParams.bottomMargin = b.b(getContext(), 0.0f);
            }
        }
        if (this.qvd != null) {
            this.qvd.bsZ();
            ((View) this.qvd).setLayoutParams(layoutParams);
            if (this.qvd instanceof AdVideoPlayerLoadingBar) {
                this.hae.postDelayed(new 8(this), 500);
            }
        }
        x.i("MicroMsg.VideoPlayView", "orientation " + i + " " + layoutParams3.width + " " + layoutParams3.height);
        ((View) this.kTe).setLayoutParams(layoutParams3);
        if (this.kTe instanceof com.tencent.mm.plugin.sight.decode.a.a) {
            ((com.tencent.mm.plugin.sight.decode.a.a) this.kTe).dt(layoutParams3.width, layoutParams3.height);
        }
        layoutParams2.height = layoutParams3.height;
        layoutParams2.width = layoutParams3.width;
        this.qvc.setLayoutParams(layoutParams2);
        ((View) this.kTe).requestLayout();
    }

    public final long bth() {
        return 0;
    }

    public final void setMute(boolean z) {
        this.kTc = z;
    }

    public final void c(double d, boolean z) {
        q(d);
    }

    public final void a(e eVar) {
    }

    public final void a(c cVar) {
    }

    public final void a(f$b com_tencent_mm_pluginsdk_ui_tools_f_b) {
    }

    public final void a(d dVar) {
    }
}
