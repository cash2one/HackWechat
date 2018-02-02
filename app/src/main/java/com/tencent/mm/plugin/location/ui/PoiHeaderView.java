package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class PoiHeaderView extends RelativeLayout {
    private Context context;
    public TextView lbS;
    public String nTk = "";
    public String nTl = "";
    public SimpleImageView nTm;

    public PoiHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        View inflate = View.inflate(this.context, R.i.dpm, this);
        this.lbS = (TextView) inflate.findViewById(R.h.cow);
        this.nTm = (SimpleImageView) inflate.findViewById(R.h.cor);
        this.lbS.setVisibility(8);
        this.nTm.setVisibility(8);
        setVisibility(8);
        setOnClickListener(new 1(this));
    }
}
