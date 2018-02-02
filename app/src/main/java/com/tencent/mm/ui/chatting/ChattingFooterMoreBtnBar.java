package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;

public class ChattingFooterMoreBtnBar extends LinearLayout {
    private ImageButton muU;
    private LayoutParams nrZ;
    private ImageButton yst;
    private ImageButton ysu;
    private ImageButton ysv;
    private ImageButton ysw;

    public ChattingFooterMoreBtnBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(0);
        setGravity(16);
        setBackgroundResource(R.g.bzY);
        this.nrZ = new LayoutParams(0, getResources().getDimensionPixelSize(R.f.bvR), 1.0f);
        this.nrZ.topMargin = a.fromDPToPix(getContext(), 0);
        this.yst = new ImageButton(getContext());
        this.yst.setImageResource(R.g.bAN);
        this.yst.setScaleType(ScaleType.CENTER);
        this.yst.setBackgroundResource(0);
        this.yst.setContentDescription(context.getString(R.l.dSh));
        this.ysw = new ImageButton(getContext());
        this.ysw.setImageResource(R.g.bAL);
        this.ysw.setScaleType(ScaleType.CENTER);
        this.ysw.setBackgroundResource(0);
        this.ysw.setContentDescription(context.getString(R.l.dSg));
        this.muU = new ImageButton(getContext());
        this.muU.setImageResource(R.g.bAJ);
        this.muU.setScaleType(ScaleType.CENTER);
        this.muU.setBackgroundResource(0);
        this.muU.setContentDescription(context.getString(R.l.dSe));
        this.ysv = new ImageButton(getContext());
        this.ysv.setImageResource(R.g.bAM);
        this.ysv.setScaleType(ScaleType.CENTER);
        this.ysv.setBackgroundResource(0);
        this.ysv.setContentDescription(context.getString(R.l.dSd));
        this.ysu = new ImageButton(getContext());
        this.ysu.setImageResource(R.g.bAK);
        this.ysu.setScaleType(ScaleType.CENTER);
        this.ysu.setBackgroundResource(0);
        this.ysu.setContentDescription(context.getString(R.l.dSf));
        crG();
    }

    public final void crG() {
        removeAllViews();
        addView(this.yst, this.nrZ);
        addView(this.ysw, this.nrZ);
        addView(this.muU, this.nrZ);
        if (i.crp().size() > 0) {
            addView(this.ysv, this.nrZ);
        } else {
            addView(this.ysu, this.nrZ);
        }
    }

    public final void Fu(int i) {
        boolean z = i > 0;
        this.yst.setClickable(z);
        this.yst.setEnabled(z);
        if (i.crp().size() > 0) {
            this.ysv.setClickable(z);
            this.ysv.setEnabled(z);
        } else {
            this.ysu.setClickable(z);
            this.ysu.setEnabled(z);
        }
        this.muU.setClickable(z);
        this.muU.setEnabled(z);
        this.ysw.setClickable(z);
        this.ysw.setEnabled(z);
    }

    public final void c(int i, OnClickListener onClickListener) {
        switch (i) {
            case 0:
                this.yst.setOnClickListener(onClickListener);
                return;
            case 1:
                this.ysu.setOnClickListener(onClickListener);
                return;
            case 2:
                this.ysv.setOnClickListener(onClickListener);
                return;
            case 3:
                this.muU.setOnClickListener(onClickListener);
                return;
            case 4:
                this.ysw.setOnClickListener(onClickListener);
                return;
            default:
                x.w("Ashu.ChattingFooterMoreBtnBar", "set button listener error button index %d", Integer.valueOf(i));
                return;
        }
    }
}
