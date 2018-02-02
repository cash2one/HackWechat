package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.a$a;
import com.tencent.mm.plugin.p.d;

public class NewMyLocationButton extends FrameLayout {
    private Context context;
    private a$a gyF = new 1(this);
    private ImageButton nSJ;
    private LinearLayout nSK;
    private d nSL;
    private boolean nSM = true;

    public NewMyLocationButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    public NewMyLocationButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.context, R.i.doY, this);
        this.nSJ = (ImageButton) inflate.findViewById(R.h.czZ);
        this.nSK = (LinearLayout) inflate.findViewById(R.h.cAb);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.nSJ.setOnClickListener(onClickListener);
    }
}
