package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q$e;
import com.tencent.mm.plugin.appbrand.q$g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

public class AppBrandVideoViewControlBar extends VideoPlayerSeekBar {
    private static int jta = -1;
    ImageView jsP;
    ImageView jsQ;
    private LinearLayout jsR;
    private ImageView jsS;
    private TextView jsT;
    private FrameLayout jsU;
    b jsV;
    ak jsW;
    ak jsX;
    boolean jsY;
    boolean jsZ;

    static /* synthetic */ void a(AppBrandVideoViewControlBar appBrandVideoViewControlBar) {
        appBrandVideoViewControlBar.jsZ = !appBrandVideoViewControlBar.jsZ;
        appBrandVideoViewControlBar.agZ();
    }

    public AppBrandVideoViewControlBar(Context context) {
        super(context);
    }

    public AppBrandVideoViewControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppBrandVideoViewControlBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final int getLayoutId() {
        return h.ixw;
    }

    protected final void init() {
        super.init();
        this.jsP = (ImageView) this.contentView.findViewById(q$g.ckk);
        this.jsQ = (ImageView) this.contentView.findViewById(q$g.ivI);
        this.jsS = (ImageView) this.contentView.findViewById(q$g.cCN);
        this.jsU = (FrameLayout) this.contentView.findViewById(q$g.cCO);
        this.jsT = (TextView) findViewById(q$g.ivS);
        this.jsR = (LinearLayout) findViewById(q$g.cIu);
        if (jta < 0) {
            jta = getResources().getDimensionPixelSize(q$e.isU);
        }
    }

    public final void db(boolean z) {
        this.fvG = z;
        agY();
    }

    private void agY() {
        if (this.jsY) {
            if (this.fvG) {
                this.quo.setImageResource(i.iyg);
            } else {
                this.quo.setImageResource(i.iyf);
            }
        } else if (this.fvG) {
            this.quo.setImageResource(i.iyj);
        } else {
            this.quo.setImageResource(i.iyi);
        }
    }

    final void agZ() {
        if (this.jsY) {
            if (this.jsZ) {
                this.jsQ.setImageResource(i.iyd);
            } else {
                this.jsQ.setImageResource(i.iyc);
            }
        } else if (this.jsZ) {
            this.jsQ.setImageResource(i.iyb);
        } else {
            this.jsQ.setImageResource(i.iya);
        }
    }

    public final void aha() {
        setVisibility(0);
        if (this.jsW == null) {
            this.jsW = new ak(new 2(this), false);
        }
        this.jsW.TG();
        this.jsW.J(7000, 7000);
    }

    public final void ahb() {
        if ((getVisibility() == 0 ? 1 : null) != null) {
            setVisibility(8);
        } else {
            aha();
        }
    }

    public final void ags() {
        this.jsY = false;
        ahc();
    }

    final void ahc() {
        LayoutParams layoutParams = this.jsR.getLayoutParams();
        if (this.jsY) {
            layoutParams.height = getResources().getDimensionPixelSize(q$e.isS);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(q$e.isQ);
        }
        this.jsR.setLayoutParams(layoutParams);
        agZ();
        if (this.jsY) {
            this.jsP.setImageResource(i.iye);
        } else {
            this.jsP.setImageResource(i.iyh);
        }
        agY();
        float dimensionPixelSize = this.jsY ? (float) getResources().getDimensionPixelSize(q$e.isT) : (float) getResources().getDimensionPixelSize(q$e.isR);
        this.qup.setTextSize(0, dimensionPixelSize);
        this.quq.setTextSize(0, dimensionPixelSize);
    }

    final boolean ahd() {
        if (this.jsV == null) {
            x.i("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
            return false;
        }
        int agQ = this.jsV.agQ();
        int agR = this.jsV.agR();
        if (agQ < 0 || agR < 0) {
            return false;
        }
        int width = this.jsU.getWidth();
        if (width <= 0) {
            return true;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.jsS.getLayoutParams();
        if (agR != 0) {
            width = (int) (((float) width) * (1.0f - (((float) agQ) / ((float) agR))));
        }
        if (width <= 0) {
            width = 0;
        }
        layoutParams.rightMargin = width + jta;
        this.jsS.setLayoutParams(layoutParams);
        if (agQ < agR || agR == 0) {
            return true;
        }
        return false;
    }

    public final void ahe() {
        if (this.qur != 0 && !this.kog && this.qun != null) {
            this.qup.setText(kG(this.mPosition / 60) + ":" + kG(this.mPosition % 60));
            if (bsY() != 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.qun.getLayoutParams();
                int bsY = bsY();
                layoutParams.leftMargin = eC(this.mPosition, bsY);
                this.qun.setLayoutParams(layoutParams);
                layoutParams = (FrameLayout.LayoutParams) this.qul.getLayoutParams();
                layoutParams.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.qur)) * ((double) bsY));
                this.qul.setLayoutParams(layoutParams);
                requestLayout();
            }
        }
    }

    public final void cR(boolean z) {
        this.jsT.setVisibility(z ? 0 : 8);
    }

    public final void cS(boolean z) {
        int i;
        int i2 = 0;
        FrameLayout frameLayout = this.jsU;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        frameLayout.setVisibility(i);
        TextView textView = this.qup;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        TextView textView2 = this.quq;
        if (!z) {
            i2 = 8;
        }
        textView2.setVisibility(i2);
    }
}
