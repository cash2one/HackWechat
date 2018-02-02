package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mm.ui.v;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;

public class MMDatePickerView extends LinearLayout implements OnClickListener {
    private MMSpinnerDatePicker lnA;
    private Button ztL;
    private Button ztM;
    private Button ztN;

    public MMDatePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MMDatePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = v.fv(context).inflate(h.gXv, this);
        this.ztL = (Button) inflate.findViewById(g.gWU);
        this.ztM = (Button) inflate.findViewById(g.gVU);
        this.ztN = (Button) inflate.findViewById(g.gVs);
        this.lnA = (MMSpinnerDatePicker) inflate.findViewById(g.gVO);
        this.ztL.setOnClickListener(this);
        this.ztM.setOnClickListener(this);
        this.ztN.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == g.gWU) {
            this.lnA.GZ(0);
        } else if (id == g.gVU) {
            this.lnA.GZ(1);
        } else {
            this.lnA.GZ(2);
        }
    }
}
