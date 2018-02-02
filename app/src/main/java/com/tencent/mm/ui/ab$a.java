package com.tencent.mm.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.ab.c;
import com.tencent.mm.ui.tools.s;

class ab$a extends BaseAdapter {
    final /* synthetic */ ab xMg;

    private ab$a(ab abVar) {
        this.xMg = abVar;
    }

    public final int getCount() {
        return ab.a(this.xMg).size();
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar = (c) ab.a(this.xMg).get(i);
        View inflate = ab.b(this.xMg).inflate(R.i.doh, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.h.title);
        if (!bh.ov(cVar.xMk.xMl)) {
            textView.setText(cVar.xMk.xMl);
        }
        if (cVar.xMk.textColor > 0) {
            textView.setTextColor(a.c(ac.getContext(), cVar.xMk.textColor));
        }
        ImageView imageView = (ImageView) inflate.findViewById(R.h.icon);
        if (cVar.xMk.icon > 0) {
            imageView.setVisibility(0);
            imageView.setImageResource(((c) ab.a(this.xMg).get(i)).xMk.icon);
        } else {
            imageView.setVisibility(8);
        }
        if (!bh.ov(cVar.xMk.xMm)) {
            imageView.setContentDescription(cVar.xMk.xMm);
        }
        View findViewById = inflate.findViewById(R.h.cAc);
        textView = (TextView) inflate.findViewById(R.h.cTL);
        textView.setBackgroundResource(s.gd(ab.c(this.xMg)));
        View findViewById2 = inflate.findViewById(R.h.czm);
        if (cVar.xMi) {
            findViewById.setVisibility(0);
        } else if (cVar.fnm > 0) {
            textView.setVisibility(0);
            if (cVar.fnm > 99) {
                textView.setText(R.l.eRP);
            } else {
                textView.setText(cVar.fnm);
            }
        } else if (cVar.xMj) {
            findViewById2.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
            textView.setVisibility(8);
            findViewById2.setVisibility(8);
        }
        if (i == getCount() - 1) {
            inflate.setBackgroundResource(R.g.bGA);
        } else {
            inflate.setBackgroundResource(R.g.bGz);
        }
        return inflate;
    }
}
