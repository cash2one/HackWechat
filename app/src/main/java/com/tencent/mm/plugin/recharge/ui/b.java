package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.v;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    ArrayList<n> pCI = null;
    a pCJ = null;

    public final int getCount() {
        return this.pCI == null ? 0 : this.pCI.size();
    }

    public final Object getItem(int i) {
        return this.pCI.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        n nVar = (n) getItem(i);
        if (view == null) {
            view = v.fv(viewGroup.getContext()).inflate(a$g.uDV, viewGroup, false);
            b bVar2 = new b(this, (byte) 0);
            bVar2.iXX = (TextView) view.findViewById(f.caP);
            bVar2.inw = (TextView) view.findViewById(f.name);
            bVar2.pCM = (TextView) view.findViewById(f.utH);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.inw.setText(nVar.name);
        if (bh.ov(nVar.desc)) {
            bVar.iXX.setVisibility(8);
        } else {
            bVar.iXX.setVisibility(0);
            bVar.iXX.setText(nVar.desc);
        }
        if (bh.ov(nVar.sDN)) {
            bVar.pCM.setVisibility(8);
        } else {
            bVar.pCM.setVisibility(0);
            bVar.pCM.setText(nVar.sDN);
        }
        if (nVar.status == 1) {
            view.setEnabled(true);
            bVar.iXX.setEnabled(true);
            bVar.inw.setEnabled(true);
        } else {
            view.setEnabled(false);
            bVar.iXX.setEnabled(false);
            bVar.inw.setEnabled(false);
        }
        if (nVar.type == 1 && nVar.sDO.equals("1") && !nVar.sDP.equals("0")) {
            Context context = viewGroup.getContext();
            int parseColor = Color.parseColor(nVar.sDP);
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius((float) a.fromDPToPix(context, 2));
            gradientDrawable.setColor(parseColor);
            Drawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius((float) a.fromDPToPix(context, 2));
            gradientDrawable2.setStroke(2, a.c(context, c.ubn));
            Drawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setShape(0);
            gradientDrawable3.setCornerRadius((float) a.fromDPToPix(context, 2));
            gradientDrawable3.setColor(a.c(context, c.ubl));
            gradientDrawable3.setStroke(2, parseColor);
            Drawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, gradientDrawable);
            stateListDrawable.addState(new int[]{-16842910}, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable3);
            Context context2 = viewGroup.getContext();
            int parseColor2 = Color.parseColor(nVar.sDP);
            r6 = new int[3][];
            r6[0] = new int[]{16842919};
            r6[1] = new int[]{-16842910};
            r6[2] = new int[0];
            ColorStateList colorStateList = new ColorStateList(r6, new int[]{a.c(context2, c.white), a.c(context2, c.ubj), parseColor2});
            bVar.iXX.setTextColor(colorStateList);
            bVar.inw.setTextColor(colorStateList);
            view.setBackground(stateListDrawable);
        }
        view.setOnClickListener(new 1(this, nVar));
        return view;
    }
}
