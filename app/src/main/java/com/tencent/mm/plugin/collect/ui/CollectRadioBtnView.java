package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.v;

public class CollectRadioBtnView extends LinearLayout {
    private TextView jJn;
    private ImageView lnw;

    public CollectRadioBtnView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CollectRadioBtnView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = v.fv(context).inflate(g.uBx, this);
        this.lnw = (ImageView) inflate.findViewById(f.uuy);
        this.jJn = (TextView) inflate.findViewById(f.cSu);
    }

    public final void xv(String str) {
        this.jJn.setText(str);
    }

    public final void ot(int i) {
        this.lnw.setImageResource(i);
    }
}
