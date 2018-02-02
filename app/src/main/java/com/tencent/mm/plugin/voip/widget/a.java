package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends BaseSmallView {
    private boolean Ki;
    private OpenGlRender svn;
    private OpenGlView svo;
    private OpenGlRender svp;
    private OpenGlView svq;
    private int[] svr = null;
    private int svs = 0;
    private float svt;
    private Runnable svu = new 1(this);
    private Runnable svv = new 2(this);

    public a(Context context, float f) {
        super(context, null);
        LayoutInflater.from(context).inflate(R.i.dtQ, this);
        this.svt = f;
        this.svo = (OpenGlView) findViewById(R.h.cBB);
        this.svn = new OpenGlRender(this.svo, OpenGlRender.sum);
        this.svo.a(this.svn);
        this.svo.setRenderMode(0);
        this.svq = (OpenGlView) findViewById(R.h.cBA);
        this.svp = new OpenGlRender(this.svq, OpenGlRender.sul);
        this.svq.a(this.svp);
        this.svq.setRenderMode(0);
        this.svq.setZOrderMediaOverlay(true);
        this.svq.setVisibility(4);
        this.lFk.postDelayed(new 3(this), 3000);
        this.lFk.postDelayed(this.svv, 2000);
        this.lFk.postDelayed(this.svu, 5000);
    }

    public final void dU(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) this.svq.getLayoutParams();
        layoutParams.height = i2 / 4;
        layoutParams.width = (int) (this.svt * ((float) layoutParams.height));
        this.svq.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = (WindowManager.LayoutParams) getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new WindowManager.LayoutParams();
        }
        layoutParams2.width = i;
        layoutParams2.height = i2;
        setLayoutParams(layoutParams2);
    }

    private void bIL() {
        if (!this.Ki) {
            this.Ki = true;
            this.svn.stS = true;
            this.svp.stS = true;
        }
    }

    public final void b(int i, int i2, int[] iArr) {
        bIL();
        if (OpenGlRender.suw == 1) {
            this.svn.a(iArr, i, i2, OpenGlRender.suc + OpenGlRender.sui);
        } else {
            this.svn.a(iArr, i, i2, OpenGlRender.suf + OpenGlRender.sui);
        }
    }

    public final void bGZ() {
        if (this.Ki) {
            this.svp.bIF();
            this.svn.bIF();
        }
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5) {
        if (this.svq.getVisibility() == 0) {
            bIL();
            if (OpenGlRender.suw == 1) {
                if (this.svs < i * i2) {
                    this.svr = null;
                }
                if (this.svr == null) {
                    this.svs = i * i2;
                    this.svr = new int[this.svs];
                }
                if (d.bGj().a(bArr, (int) j, i3 & 31, i, i2, this.svr, false) >= 0 && this.svr != null) {
                    this.svp.a(this.svr, i, i2, (OpenGlRender.sud + i4) + i5);
                }
            } else if (OpenGlRender.suw == 2) {
                this.svp.c(bArr, i, i2, (OpenGlRender.suh + i4) + i5);
            }
        }
    }

    public final void uninit() {
        super.uninit();
        setVisibility(4);
        if (this.Ki) {
            this.svn.bIE();
            this.svp.bIE();
        }
        this.lFk.removeCallbacks(this.svu);
    }

    public final void a(CaptureView captureView) {
        x.j("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
        if (this.slO != null) {
            removeView(this.slO);
            this.slO = null;
        }
        if (captureView != null) {
            this.slO = captureView;
            ViewGroup.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
            layoutParams.leftMargin = 20;
            layoutParams.topMargin = 20;
            addView(captureView, layoutParams);
            captureView.setVisibility(0);
            x.d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
        }
    }

    protected final void bIj() {
        this.svq.setVisibility(0);
        this.lFk.removeCallbacks(this.svu);
        this.lFk.postDelayed(this.svu, 3000);
    }

    protected final void bIk() {
        this.svn.bIE();
        this.svp.bIE();
    }

    protected final void onAnimationEnd() {
        this.svn.stS = true;
        this.svp.stS = true;
    }
}
