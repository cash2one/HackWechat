package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

public class FtsWebVideoViewControlBar extends FtsVideoPlayerSeekBar {
    private static int jta = -1;
    private ImageView jsP;
    private ImageView jsS;
    private FrameLayout jsU;
    private ak jsW;
    private ak jsX;
    public boolean jsY;
    private ImageView trg;
    private ImageView trv;
    public RelativeLayout trw;
    public a trx;

    public FtsWebVideoViewControlBar(Context context) {
        super(context);
    }

    public FtsWebVideoViewControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FtsWebVideoViewControlBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onDestroy() {
        if (this.jsX != null) {
            this.jsX.TG();
        }
        if (this.jsW != null) {
            this.jsW.TG();
        }
    }

    public int getLayoutId() {
        return R.i.djm;
    }

    public void init() {
        super.init();
        this.jsP = (ImageView) this.contentView.findViewById(R.h.ckk);
        this.trv = (ImageView) this.contentView.findViewById(R.h.cWi);
        this.jsS = (ImageView) this.contentView.findViewById(R.h.cCN);
        this.jsU = (FrameLayout) this.contentView.findViewById(R.h.cCO);
        this.trw = (RelativeLayout) findViewById(R.h.cIu);
        this.trg = (ImageView) this.contentView.findViewById(R.h.cfH);
        if (jta < 0) {
            jta = getResources().getDimensionPixelSize(R.f.bxu);
        }
    }

    public final void db(boolean z) {
        this.fvG = z;
        agY();
    }

    protected final int bta() {
        return this.qun.getWidth();
    }

    private void agY() {
        if (this.jsY) {
            if (this.fvG) {
                this.quo.setImageResource(R.g.bCs);
            } else {
                this.quo.setImageResource(R.g.bCv);
            }
        } else if (this.fvG) {
            this.quo.setImageResource(R.g.bCs);
        } else {
            this.quo.setImageResource(R.g.bCv);
        }
    }

    public final void At() {
        this.trv.setImageResource(R.g.bCx);
    }

    public final void bQp() {
        this.trv.setImageResource(R.g.bCu);
    }

    public final void k(OnClickListener onClickListener) {
        this.trv.setOnClickListener(onClickListener);
    }

    public final void l(OnClickListener onClickListener) {
        this.jsP.setOnClickListener(onClickListener);
    }

    public final void m(OnClickListener onClickListener) {
        this.trg.setOnClickListener(onClickListener);
    }

    public void ki(boolean z) {
        setVisibility(0);
        if (z) {
            bQu();
        } else {
            bQv();
        }
        if (this.jsW == null) {
            this.jsW = new ak(new 1(this), false);
        }
        this.jsW.TG();
        this.jsW.J(2000, 2000);
    }

    public final void bQq() {
        if (this.jsW != null) {
            this.jsW.TG();
        }
    }

    public final void bQr() {
        if (this.jsW != null) {
            this.jsW.TG();
            this.jsW.J(2000, 2000);
        }
    }

    public final void kn(boolean z) {
        if ((getVisibility() == 0 ? 1 : null) != null) {
            setVisibility(8);
        } else {
            ki(z);
        }
    }

    public void bQi() {
        this.jsY = true;
        ahc();
    }

    public void ags() {
        this.jsY = false;
        ahc();
    }

    private void ahc() {
        LayoutParams layoutParams = this.trw.getLayoutParams();
        if (this.jsY) {
            layoutParams.height = getResources().getDimensionPixelSize(R.f.bxs);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(R.f.bxq);
        }
        this.trw.setLayoutParams(layoutParams);
        if (this.jsY) {
            this.jsP.setImageResource(R.k.dyI);
            this.jsP.setVisibility(8);
            this.trg.setVisibility(0);
        } else {
            this.trg.setVisibility(8);
            this.jsP.setVisibility(0);
            this.jsP.setImageResource(R.g.bCt);
        }
        agY();
        float dimensionPixelSize = this.jsY ? (float) getResources().getDimensionPixelSize(R.f.bxt) : (float) getResources().getDimensionPixelSize(R.f.bxr);
        this.qup.setTextSize(0, dimensionPixelSize);
        this.quq.setTextSize(0, dimensionPixelSize);
    }

    public final void bQs() {
        if (this.jsX == null) {
            this.jsX = new ak(new 2(this), true);
        }
        ahd();
        this.jsX.TG();
        this.jsX.J(500, 500);
    }

    public final void bQt() {
        if (this.jsX != null) {
            this.jsX.TG();
        }
    }

    private boolean ahd() {
        if (this.trx == null) {
            x.i("MicroMsg.FtsWebVideoViewControlBar", "updateMiddleBar mStatePorter null");
            return false;
        }
        int agQ = this.trx.agQ();
        int agR = this.trx.agR();
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

    public final void bQu() {
        this.quo.setVisibility(8);
    }

    public final void bQv() {
        this.quo.setVisibility(0);
    }

    public final void wZ(int i) {
        seek((int) Math.ceil((((double) this.trx.bQb()) * 1.0d) / 1000.0d));
    }
}
