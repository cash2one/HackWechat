package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;

public class AppbrandMapLocationPoint extends LinearLayout {
    ImageView jlO;
    double jlP = -1.0d;
    double jlQ = -1.0d;
    double jlR = -1.0d;
    double jlS = -1.0d;
    private Context mContext;

    public AppbrandMapLocationPoint(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public AppbrandMapLocationPoint(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        this.jlO = (ImageView) View.inflate(this.mContext, h.iwZ, this).findViewById(g.iwC);
        this.jlO.requestFocus();
    }
}
