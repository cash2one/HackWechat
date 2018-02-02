package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.sdk.platformtools.x;

class CardListSelectedUI$3 implements OnItemClickListener {
    final /* synthetic */ CardListSelectedUI kUl;

    CardListSelectedUI$3(CardListSelectedUI cardListSelectedUI) {
        this.kUl = cardListSelectedUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (view.getAlpha() != 1.0f) {
            x.d("MicroMsg.CardListSelectedUI", "item view is gray, cannot click, do nothing return！");
            return;
        }
        if (this.kUl.kTW) {
            this.kUl.kTY.put(Integer.valueOf(i), Boolean.valueOf(!((Boolean) this.kUl.kTY.get(Integer.valueOf(i))).booleanValue()));
        } else {
            for (int i2 = 0; i2 < this.kUl.kTX.size(); i2++) {
                this.kUl.kTY.put(Integer.valueOf(i2), Boolean.valueOf(false));
            }
            this.kUl.kTY.put(Integer.valueOf(i), Boolean.valueOf(true));
            CardListSelectedUI.a(this.kUl, (a) this.kUl.kTX.get(i));
        }
        CardListSelectedUI.c(this.kUl).notifyDataSetChanged();
        CardListSelectedUI.d(this.kUl);
    }
}
