package com.tencent.mm.plugin.card.ui;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.aq.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AccepterItem;
import com.tencent.mm.plugin.card.model.m;

class CardGiftReceiveUI$a extends BaseAdapter {
    final /* synthetic */ CardGiftReceiveUI kSW;

    CardGiftReceiveUI$a(CardGiftReceiveUI cardGiftReceiveUI) {
        this.kSW = cardGiftReceiveUI;
    }

    public final /* synthetic */ Object getItem(int i) {
        return (AccepterItem) CardGiftReceiveUI.b(this.kSW).kKJ.get(i);
    }

    public final int getCount() {
        return CardGiftReceiveUI.b(this.kSW).kKJ.size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        CardGiftReceiveUI$b cardGiftReceiveUI$b;
        AccepterItem accepterItem = (AccepterItem) CardGiftReceiveUI.b(this.kSW).kKJ.get(i);
        if (view == null) {
            view = View.inflate(this.kSW, R.i.dca, null);
            CardGiftReceiveUI$b cardGiftReceiveUI$b2 = new CardGiftReceiveUI$b(this.kSW);
            cardGiftReceiveUI$b2.kSY = (ImageView) view.findViewById(R.h.cpF);
            cardGiftReceiveUI$b2.kSZ = (TextView) view.findViewById(R.h.cSY);
            cardGiftReceiveUI$b2.jpW = (TextView) view.findViewById(R.h.cTa);
            cardGiftReceiveUI$b2.kTa = (TextView) view.findViewById(R.h.cSZ);
            view.setTag(cardGiftReceiveUI$b2);
            cardGiftReceiveUI$b = cardGiftReceiveUI$b2;
        } else {
            cardGiftReceiveUI$b = (CardGiftReceiveUI$b) view.getTag();
        }
        if (accepterItem != null) {
            if (accepterItem.kKR != null) {
                ImageView imageView = cardGiftReceiveUI$b.kSY;
                String str = accepterItem.kKR;
                int i2 = R.g.bDT;
                if (!(imageView == null || TextUtils.isEmpty(str))) {
                    if (TextUtils.isEmpty(str)) {
                        imageView.setImageResource(i2);
                    } else {
                        c$a com_tencent_mm_aq_a_a_c_a = new c$a();
                        com_tencent_mm_aq_a_a_c_a.hDD = e.bnF;
                        o.PB();
                        com_tencent_mm_aq_a_a_c_a.hDW = null;
                        com_tencent_mm_aq_a_a_c_a.hDC = m.wk(str);
                        com_tencent_mm_aq_a_a_c_a.hDA = true;
                        com_tencent_mm_aq_a_a_c_a.hDY = true;
                        com_tencent_mm_aq_a_a_c_a.hDZ = 3.0f;
                        com_tencent_mm_aq_a_a_c_a.hDy = true;
                        com_tencent_mm_aq_a_a_c_a.hDH = 34;
                        com_tencent_mm_aq_a_a_c_a.hDG = 34;
                        com_tencent_mm_aq_a_a_c_a.hDP = i2;
                        o.PA().a(str, imageView, com_tencent_mm_aq_a_a_c_a.PK());
                    }
                }
            }
            cardGiftReceiveUI$b.kSZ.setText(accepterItem.kKQ);
            cardGiftReceiveUI$b.jpW.setText(accepterItem.kKO);
            cardGiftReceiveUI$b.kTa.setText(accepterItem.kKP + this.kSW.mController.xIM.getString(R.l.dOk));
        }
        return view;
    }
}
