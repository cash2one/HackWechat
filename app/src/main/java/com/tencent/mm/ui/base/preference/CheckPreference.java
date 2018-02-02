package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class CheckPreference extends Preference {
    private TextView sHZ;
    private int sIa;
    private String sIb;
    private int sIc;
    public boolean tSw;
    private CheckBox yhV;
    public int yhW;

    public CheckPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CheckPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tSw = false;
        this.sIa = -1;
        this.sIb = "";
        this.sIc = 8;
        this.yhW = -1;
        setLayoutResource(h.gXS);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    public final void onBindView(View view) {
        super.onBindView(view);
        this.yhV = (CheckBox) view.findViewById(g.checkbox);
        this.yhV.setChecked(this.tSw);
        this.sHZ = (TextView) view.findViewById(g.gWA);
        String str = this.sIb;
        int i = this.sIa;
        this.sIa = i;
        this.sIb = str;
        if (this.sHZ != null) {
            if (i > 0) {
                this.sHZ.setBackgroundResource(this.sIa);
            }
            if (!TextUtils.isEmpty(this.sIb)) {
                this.sHZ.setText(this.sIb);
            }
        }
        this.sIc = this.sIc;
        if (this.sHZ != null) {
            this.sHZ.setVisibility(this.sIc);
        }
        LayoutParams layoutParams = (LayoutParams) this.yhV.getLayoutParams();
        if (-1 != this.yhW) {
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, this.yhW, layoutParams.bottomMargin);
        }
    }
}
