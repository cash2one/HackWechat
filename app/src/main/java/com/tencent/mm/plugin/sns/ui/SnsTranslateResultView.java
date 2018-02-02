package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ao.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;

public class SnsTranslateResultView extends LinearLayout {
    private static final int rKN = Color.parseColor("#19000000");
    private Drawable hDS;
    public TextView pYa;
    private TextView rKL;
    public View rKM;
    private int rKO = -1;
    private float rKP = -1.0f;
    private int rKQ = -1;

    public SnsTranslateResultView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(i$g.qIo, this);
        this.rKL = (TextView) findViewById(f.qFB);
        this.pYa = (TextView) findViewById(f.qFC);
        this.rKM = findViewById(f.qFO);
        this.hDS = getResources().getDrawable(e.qzT);
        this.hDS.setBounds(0, 0, (int) (this.pYa.getTextSize() * 0.8f), (int) (this.pYa.getTextSize() * 0.8f));
        this.hDS.setColorFilter(rKN, Mode.SRC_IN);
    }

    public final void xP(int i) {
        this.pYa.setCompoundDrawables(this.hDS, null, null, null);
        this.pYa.setCompoundDrawablePadding(a.fromDPToPix(getContext(), 3));
        this.pYa.setText(j.qMC);
        com.tencent.mm.ui.tools.j.a(this.pYa, null);
        this.rKL.setVisibility(4);
        this.rKO = i;
        this.pYa.setTextSize(0, this.rKL.getTextSize());
        this.pYa.setTextColor(getContext().getResources().getColor(c.qyE));
    }

    public final void ay(float f) {
        this.pYa.setTextSize(1, f);
        this.rKP = f;
        this.rKQ = 1;
    }

    public final void az(float f) {
        this.pYa.setTextSize(0, f);
        this.rKP = f;
        this.rKQ = 0;
    }

    @TargetApi(11)
    public final void a(b bVar, int i, String str, String str2, boolean z) {
        this.rKO = i;
        if (this.rKP != -1.0f || this.rKQ != -1) {
            this.pYa.setTextSize(this.rKQ, this.rKP);
        } else if (this.rKO == 2) {
            this.pYa.setTextSize(1, 14.0f * a.eu(getContext()));
        } else if (this.rKO == 1) {
            this.pYa.setTextSize(1, 15.0f * a.eu(getContext()));
        }
        if (this.rKO == 2) {
            this.pYa.setTextColor(getContext().getResources().getColor(c.qyD));
        } else if (this.rKO == 1) {
            this.pYa.setTextColor(getContext().getResources().getColor(c.qyF));
        }
        if (bh.ov(str)) {
            this.pYa.setText(j.qMA);
        } else {
            this.pYa.setText(str);
            i.f(this.pYa, 2);
        }
        this.pYa.setCompoundDrawables(null, null, null, null);
        if (z && d.fM(11)) {
            com.tencent.mm.ui.tools.j.a(this.pYa, new 1(this, bVar));
        }
        if (bh.ov(str2)) {
            this.rKL.setText(j.dTj);
        } else {
            this.rKL.setText(str2);
        }
        this.rKL.setVisibility(0);
    }
}
