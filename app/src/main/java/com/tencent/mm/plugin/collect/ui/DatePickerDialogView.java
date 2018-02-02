package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMSpinnerDatePicker;

public class DatePickerDialogView extends LinearLayout implements OnClickListener {
    MMSpinnerDatePicker lnA;
    TextView lnB;
    TextView lnC;
    int lnD = 0;
    private CollectRadioBtnView lnx;
    private CollectRadioBtnView lny;
    private CollectRadioBtnView lnz;

    public DatePickerDialogView(Context context) {
        super(context);
        init(context);
    }

    public DatePickerDialogView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DatePickerDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        View inflate = v.fv(context).inflate(g.uBq, this);
        this.lnx = (CollectRadioBtnView) inflate.findViewById(f.gWU);
        this.lny = (CollectRadioBtnView) inflate.findViewById(f.gVU);
        this.lnz = (CollectRadioBtnView) inflate.findViewById(f.gVs);
        this.lnB = (TextView) inflate.findViewById(f.uiY);
        this.lnC = (TextView) inflate.findViewById(f.bPo);
        this.lnx.setOnClickListener(this);
        this.lny.setOnClickListener(this);
        this.lnz.setOnClickListener(this);
        this.lnx.xv("年");
        this.lny.xv("月");
        this.lnz.xv("日");
        this.lnA = (MMSpinnerDatePicker) inflate.findViewById(f.ujc);
        this.lnA.Ha(c.transparent);
        MMSpinnerDatePicker mMSpinnerDatePicker = this.lnA;
        int i = d.bvK;
        mMSpinnerDatePicker.a(mMSpinnerDatePicker.zuO, i);
        mMSpinnerDatePicker.a(mMSpinnerDatePicker.zuP, i);
        mMSpinnerDatePicker.a(mMSpinnerDatePicker.zuQ, i);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == f.gWU) {
            this.lnD = 2;
        } else if (id == f.gVU) {
            this.lnD = 1;
        } else if (id == f.gVs) {
            this.lnD = 0;
        } else {
            x.i("MicroMsg.DatePickerDialogView", "unhandled click view: %s", new Object[]{view.getClass().toString()});
        }
        azA();
    }

    final void azA() {
        if (this.lnD == 2) {
            this.lnx.ot(h.dAr);
            this.lny.ot(h.dAq);
            this.lnz.ot(h.dAq);
        } else if (this.lnD == 1) {
            this.lnx.ot(h.dAq);
            this.lny.ot(h.dAr);
            this.lnz.ot(h.dAq);
        } else {
            this.lnx.ot(h.dAq);
            this.lny.ot(h.dAq);
            this.lnz.ot(h.dAr);
        }
        this.lnA.GZ(this.lnD);
    }
}
