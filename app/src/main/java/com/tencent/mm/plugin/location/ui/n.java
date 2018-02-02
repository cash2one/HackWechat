package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.x;

public final class n implements c {
    public boolean fuf = false;
    public boolean isVisible = true;
    private String nQt;
    public double nQx = 1000000.0d;
    public double nQy = 1000000.0d;
    public String nSB = "";
    private TextView nSw;
    private ProgressBar nSx;
    public boolean nTb = true;
    public View nTc;
    public d nTd;
    public String nTe;
    public ImageView nVH;
    public FrameLayout nVI;
    public View nVJ;
    private TextView nVK;
    public TextView nVL;

    public final void gr(boolean z) {
        if (z && this.isVisible) {
            this.nVI.setVisibility(0);
        } else if ((!z || this.isVisible) && !z && this.isVisible) {
            this.nVI.setVisibility(4);
        }
    }

    public final void b(LocationInfo locationInfo) {
        this.nQx = locationInfo.nQx;
        this.nQy = locationInfo.nQy;
    }

    public final void DN(String str) {
        x.d("ZItemOverlay", "popView " + this.nTc.getWidth() + " " + this.nTc.getHeight());
        this.nSw = (TextView) this.nTc.findViewById(R.h.cue);
        this.nSx = (ProgressBar) this.nTc.findViewById(R.h.ctU);
        this.nVK = (TextView) this.nTc.findViewById(R.h.ctX);
        this.nTc.findViewById(R.h.ctV).setVisibility(0);
        if (str == null || str.equals("")) {
            this.nSx.setVisibility(0);
        } else {
            this.nSx.setVisibility(8);
            this.nSw.setVisibility(0);
            this.nSw.setText(str);
        }
        if (this.nTe == null || this.nTe.equals("")) {
            this.nVK.setText("");
            this.nVK.setVisibility(8);
        } else {
            this.nVK.setVisibility(0);
            this.nVK.setText(this.nTe);
        }
        if (this.nTb) {
            this.nTc.setVisibility(0);
            this.nTd.updateLocaitonPinLayout(this.nTc, this.nQx, this.nQy);
            this.nTc.invalidate();
        }
    }

    public n(d dVar, Context context) {
        View inflate = View.inflate(context, R.i.dmY, null);
        this.nVL = (TextView) inflate.findViewById(R.h.cnJ);
        this.nVL.setVisibility(8);
        inflate.setVisibility(8);
        this.nVH = (ImageView) inflate.findViewById(R.h.ctM);
        this.nVH.setImageResource(R.g.bDr);
        this.nVI = (FrameLayout) inflate.findViewById(R.h.cuU);
        this.nVJ = inflate.findViewById(R.h.ctF);
        this.nTd = dVar;
        this.nTc = inflate;
    }

    public final void setText(String str) {
        this.nQt = str;
        DN(this.nQt);
    }

    public final String aVM() {
        return this.nSB;
    }
}
