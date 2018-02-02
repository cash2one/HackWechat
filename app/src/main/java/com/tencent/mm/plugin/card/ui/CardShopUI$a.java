package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.protocal.c.kj;

class CardShopUI$a extends BaseAdapter {
    final /* synthetic */ CardShopUI kVo;

    public final /* synthetic */ Object getItem(int i) {
        return nW(i);
    }

    private CardShopUI$a(CardShopUI cardShopUI) {
        this.kVo = cardShopUI;
    }

    public final int getCount() {
        return CardShopUI.a(this.kVo).size();
    }

    private kj nW(int i) {
        return (kj) CardShopUI.a(this.kVo).get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.kVo.mController.xIM, R.i.dcC, null);
            a aVar2 = new a(this);
            aVar2.kVp = (TextView) view.findViewById(R.h.cOa);
            aVar2.kVq = (TextView) view.findViewById(R.h.cNZ);
            aVar2.kVr = (TextView) view.findViewById(R.h.cNY);
            aVar2.kVs = (ImageView) view.findViewById(R.h.cOc);
            aVar2.kVt = view.findViewById(R.h.cOd);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        kj nW = nW(i);
        if (nW == null) {
            aVar.kVp.setText("");
            aVar.kVq.setText("");
            aVar.kVr.setText("");
        } else {
            aVar.kVp.setText(nW.name);
            if (nW.vRw <= 0.0f) {
                aVar.kVq.setVisibility(8);
            } else {
                aVar.kVq.setText(l.f(this.kVo.getBaseContext(), nW.vRw));
                aVar.kVq.setVisibility(0);
            }
            aVar.kVr.setText(nW.fWp + nW.fWq + nW.hxu);
            aVar.kVt.setOnClickListener(CardShopUI.f(this.kVo));
            aVar.kVt.setTag(nW);
        }
        return view;
    }
}
