package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class NoiseDetectMaskView extends RelativeLayout {
    ProgressBar lpy = null;
    private Context mContext = null;
    TextView shF;
    TextView shG;
    b shH;
    a shI;

    public NoiseDetectMaskView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mContext.getSystemService("layout_inflater");
        LayoutInflater.from(this.mContext).inflate(R.i.dpc, this);
        this.lpy = (ProgressBar) findViewById(R.h.cAB);
        this.shF = (TextView) findViewById(R.h.cAA);
        this.shG = (TextView) findViewById(R.h.cAC);
        this.shG.setOnClickListener(new 1(this));
        findViewById(R.h.csK).setOnClickListener(new 2(this));
    }
}
