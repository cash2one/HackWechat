package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.p.d;

public class MyLocationButton extends FrameLayout {
    private Context context;
    public a gyF = new 1(this);
    public ImageButton nSJ;
    public LinearLayout nSK;
    public d nSL;
    public boolean nSM = true;

    public MyLocationButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    public MyLocationButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.context, R.i.doC, this);
        this.nSJ = (ImageButton) inflate.findViewById(R.h.ctK);
        this.nSK = (LinearLayout) inflate.findViewById(R.h.cDY);
    }

    public final void aVN() {
        this.nSJ.setImageResource(R.g.bEG);
    }

    public final void aVO() {
        this.nSJ.setImageResource(R.g.bEH);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.nSJ.setOnClickListener(onClickListener);
    }
}
