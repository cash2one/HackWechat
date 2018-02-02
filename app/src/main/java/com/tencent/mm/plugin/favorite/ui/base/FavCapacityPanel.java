package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.a.j;

public class FavCapacityPanel extends LinearLayout {
    private OnClickListener mtg = new 1(this);
    private LinearLayout muI = this;
    public long muJ;
    public TextView muK;
    public int muL = 0;
    public long muM;

    public FavCapacityPanel(Context context, AttributeSet attributeSet) {
        long j;
        super(context, attributeSet);
        View inflate = View.inflate(getContext(), R.i.dhM, null);
        inflate.measure(-2, -2);
        View findViewById = inflate.findViewById(R.h.cgk);
        View findViewById2 = inflate.findViewById(R.h.cgl);
        this.muK = (TextView) inflate.findViewById(R.h.cgj);
        LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
        layoutParams.width = inflate.getMeasuredWidth();
        findViewById.setLayoutParams(layoutParams);
        findViewById2.setOnClickListener(this.mtg);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        this.muI.addView(inflate, layoutParams2);
        this.muJ = j.aIK() / 1048576;
        this.muM = j.aIL() / 1048576;
        TextView textView = this.muK;
        Context context2 = this.muK.getContext();
        int i = R.l.eex;
        Object[] objArr = new Object[2];
        if (this.muM - this.muJ > 0) {
            j = this.muM - this.muJ;
        } else {
            j = 0;
        }
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(this.muJ);
        textView.setText(context2.getString(i, objArr));
    }
}
