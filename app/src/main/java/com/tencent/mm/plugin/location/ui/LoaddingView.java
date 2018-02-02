package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;

public class LoaddingView extends LinearLayout implements c {
    private boolean nSA = false;
    private String nSB = "";
    private TextView nSw;
    private ProgressBar nSx;
    private Animation nSy;
    private View nSz;

    @TargetApi(11)
    public LoaddingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public LoaddingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.nSy = AnimationUtils.loadAnimation(context, R.a.bqH);
        View inflate = LayoutInflater.from(context).inflate(R.i.dmK, this, true);
        this.nSx = (ProgressBar) inflate.findViewById(R.h.ctU);
        this.nSw = (TextView) inflate.findViewById(R.h.cue);
        this.nSz = inflate.findViewById(R.h.ctM);
        this.nSw.setText("");
        this.nSw.setVisibility(0);
        this.nSx.setVisibility(0);
    }

    public final void setText(String str) {
        if (this.nSw != null && this.nSx != null && !this.nSA) {
            if (bh.ov(str)) {
                this.nSw.setText("");
                this.nSw.setVisibility(0);
                this.nSx.setVisibility(0);
                return;
            }
            this.nSw.setText(str);
            this.nSx.setVisibility(8);
            this.nSw.setVisibility(0);
        }
    }

    public final String aVM() {
        return this.nSB;
    }
}
