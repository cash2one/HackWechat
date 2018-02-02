package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class NetStatGroup extends LinearLayout {
    final TextView pBl;
    LinearLayout qhc;

    public NetStatGroup(Context context) {
        this(context, null);
    }

    public NetStatGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R.i.doQ, this);
        this.qhc = (LinearLayout) findViewById(R.h.atY);
        this.pBl = (TextView) findViewById(R.h.can);
        this.pBl.setTextSize(0, (float) context.getResources().getDimensionPixelSize(R.f.bvs));
    }
}
