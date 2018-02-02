package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.c.c;

public final class bf {
    private String nQA = w.eL(ac.getContext());
    private LinearLayout rMh;
    public TextView rMi;
    public TextView rMj;
    private View rMk;
    private View rMl;
    public b rMm;
    public a rMn;
    private View view;

    public final String bCi() {
        if (this.rMn == null) {
            return "";
        }
        if (this.rMn.qZM == null) {
            return "";
        }
        return this.rMn.qZM;
    }

    public final int[] bCj() {
        int[] iArr = new int[2];
        if (this.rMh != null) {
            this.rMk.getLocationInWindow(iArr);
            iArr[0] = iArr[0] + this.rMk.getMeasuredWidth();
        } else if (this.rMk != null) {
            this.rMk.getLocationInWindow(iArr);
            iArr[0] = iArr[0] + this.rMk.getMeasuredWidth();
        }
        return iArr;
    }

    public bf(View view) {
        this.view = view;
        x.i("MicroMsg.TimeLineAdView", "adView init lan " + this.nQA);
        this.rMi = (TextView) this.view.findViewById(f.qAf);
        this.rMj = (TextView) this.view.findViewById(f.qAi);
        this.rMk = this.view.findViewById(f.qAg);
        this.rMl = this.view.findViewById(f.qAh);
        this.rMh = (LinearLayout) this.view.findViewById(f.qAe);
        this.rMi.setText(" " + this.view.getResources().getString(j.qKa) + " ");
    }

    public final void a(OnClickListener onClickListener, OnClickListener onClickListener2) {
        this.rMj.setOnClickListener(onClickListener);
        this.rMi.setOnClickListener(onClickListener2);
        if (this.rMk != null) {
            this.rMk.setOnClickListener(onClickListener2);
        }
        if (this.rMh != null) {
            this.rMh.setOnClickListener(onClickListener2);
        }
    }

    public final void q(Object obj, Object obj2) {
        this.rMj.setTag(obj);
        this.rMi.setTag(obj2);
        if (this.rMk != null) {
            this.rMk.setTag(obj2);
        }
        if (this.rMh != null) {
            this.rMh.setTag(obj2);
        }
    }

    public final void a(b bVar, a aVar) {
        Object imageSpan;
        this.rMn = aVar;
        this.rMm = bVar;
        String str = "";
        if (bVar != null) {
            if ("zh_CN".equals(this.nQA)) {
                str = bVar.reA;
            } else if ("zh_TW".equals(this.nQA) || "zh_HK".equals(this.nQA)) {
                str = bVar.reC;
            } else {
                str = bVar.reB;
            }
        }
        if (bVar != null && bh.ov(r0)) {
            str = bVar.rey;
        }
        Context context = this.rMj.getContext();
        if (bh.ov(str)) {
            str = context.getString(j.qKe);
        }
        str = str + " ";
        int length = str.length();
        CharSequence spannableString = new SpannableString(str + "ad_");
        Drawable drawable;
        if (aVar == null || !aVar.bwr()) {
            drawable = context.getResources().getDrawable(i.qIz);
            drawable.setBounds(0, 0, (int) (((double) this.rMj.getTextSize()) * 1.3d), (int) (((double) this.rMj.getTextSize()) * 1.3d));
            ImageSpan imageSpan2 = new ImageSpan(drawable, 0);
        } else {
            drawable = context.getResources().getDrawable(i.qIy);
            drawable.setBounds(0, 0, (int) (((double) this.rMj.getTextSize()) * 0.8d), (int) (((double) this.rMj.getTextSize()) * 0.8d));
            imageSpan = new ImageSpan(drawable, 1);
        }
        if (!bh.ov(bVar.rez)) {
            d.a("adId", bVar.rez, false, 41, 0, new 1(this, spannableString, length));
        }
        spannableString.setSpan(imageSpan, length, length + 3, 33);
        this.rMj.setText(spannableString);
        if (aVar == null || bh.ov(aVar.rdT)) {
            this.rMl.setVisibility(8);
        } else {
            this.rMl.setVisibility(0);
        }
        if (bVar != null) {
            CharSequence charSequence;
            if ("zh_CN".equals(this.nQA)) {
                charSequence = bVar.reJ;
            } else if ("zh_TW".equals(this.nQA) || "zh_HK".equals(this.nQA)) {
                charSequence = bVar.reL;
            } else {
                charSequence = bVar.reK;
            }
            if (!bh.ov(charSequence)) {
                this.rMi.setText(charSequence);
            }
        }
    }

    public final void setVisibility(int i) {
        int i2;
        if (this.rMm == null || this.rMm.rex != 1) {
            this.rMj.setVisibility(i);
        } else {
            this.rMj.setVisibility(8);
        }
        com.tencent.mm.storage.a Wo = c.IG().Wo("Sns_CanvasAd_DetailLink_JumpWay");
        if (Wo.isValid()) {
            i2 = bh.getInt(Wo.field_value, -1);
        } else {
            i2 = -1;
        }
        if (i2 != -1 && this.rMm != null && this.rMm.bwt() && e.Lg(this.rMm.fCs)) {
            this.rMj.setVisibility(i);
        }
        this.rMi.setVisibility(i);
        if (this.rMk != null) {
            this.rMk.setVisibility(i);
        }
        if (this.rMh != null) {
            this.rMh.setVisibility(i);
        }
        if (this.rMn == null || bh.ov(this.rMn.rdT)) {
            this.rMl.setVisibility(8);
        } else {
            this.rMl.setVisibility(i);
        }
    }
}
