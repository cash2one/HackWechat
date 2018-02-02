package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.plugin.card.ui.CardListSelectedUI.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class CardListSelectedUI$a extends BaseAdapter {
    final /* synthetic */ CardListSelectedUI kUl;

    CardListSelectedUI$a(CardListSelectedUI cardListSelectedUI) {
        this.kUl = cardListSelectedUI;
    }

    public final /* synthetic */ Object getItem(int i) {
        return nV(i);
    }

    public final int getCount() {
        return this.kUl.kTX.size();
    }

    private a nV(int i) {
        return (a) this.kUl.kTX.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        a nV = nV(i);
        if (view == null) {
            view = View.inflate(this.kUl, R.i.dcA, null);
            dVar = new d(this.kUl);
            dVar.kUs = (ImageView) view.findViewById(R.h.logo);
            dVar.jpW = (TextView) view.findViewById(R.h.title);
            dVar.kUo = (TextView) view.findViewById(R.h.cPA);
            dVar.kUt = (TextView) view.findViewById(R.h.bLA);
            dVar.kEY = (TextView) view.findViewById(R.h.bSw);
            dVar.kUu = view.findViewById(R.h.bNU);
            dVar.kUv = (ImageView) view.findViewById(R.h.bRX);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        if (l.nG(nV.kJO)) {
            int i2;
            dVar.jpW.setText(nV.kJQ);
            if (TextUtils.isEmpty(nV.title)) {
                dVar.kUo.setVisibility(8);
            } else {
                dVar.kUo.setVisibility(0);
                dVar.kUo.setText(nV.title);
            }
            if (TextUtils.isEmpty(nV.kJR)) {
                dVar.kUt.setVisibility(8);
            } else {
                dVar.kUt.setVisibility(0);
                dVar.kUt.setText(nV.kJR);
            }
            TextView textView = dVar.kEY;
            if (bh.ov(nV.kFg)) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            textView.setVisibility(i2);
            dVar.kEY.setText(nV.kFg);
            CardListSelectedUI.a(dVar.kUs, nV.kJP, this.kUl.getBaseContext().getResources().getDimensionPixelSize(R.f.bwF));
            Boolean bool = (Boolean) this.kUl.kTY.get(Integer.valueOf(i));
            if (bool == null || !bool.booleanValue()) {
                dVar.kUv.setImageResource(R.g.bAm);
            } else {
                dVar.kUv.setImageResource(R.g.bAl);
            }
        } else {
            x.i("MicroMsg.CardListSelectedUI", "not support type");
        }
        return view;
    }
}
