package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class TipSayingWidget extends LinearLayout {
    private Context context;
    private TextView lbS;
    private ImageView nUO;
    private Chronometer nUP;
    private int nUQ = 0;

    public TipSayingWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View inflate = View.inflate(this.context, R.i.dsY, this);
        this.nUO = (ImageView) inflate.findViewById(R.h.cIL);
        this.lbS = (TextView) inflate.findViewById(R.h.cIN);
        this.nUP = (Chronometer) findViewById(R.h.chronometer);
    }
}
