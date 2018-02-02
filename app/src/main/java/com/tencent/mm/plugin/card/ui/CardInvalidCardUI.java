package com.tencent.mm.plugin.card.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.card.b.d;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

public class CardInvalidCardUI extends CardBaseUI {
    static /* synthetic */ LinkedList c(CardInvalidCardUI cardInvalidCardUI) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardInvalidCardUI.kIf.getCount(); i++) {
            CardInfo cardInfo = (CardInfo) cardInvalidCardUI.kIl.nD(i);
            if (cardInfo != null) {
                linkedList.add(cardInfo.field_card_id);
            }
        }
        return linkedList;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.initView();
    }

    protected final void initView() {
        super.initView();
    }

    protected final int asT() {
        return a.kLH;
    }

    protected final void asS() {
        setMMTitle(R.l.dOr);
        addTextOptionMenu(0, getString(R.l.dNM), new OnMenuItemClickListener(this) {
            final /* synthetic */ CardInvalidCardUI kTM;

            {
                this.kTM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                d.a(this.kTM, new 2(this.kTM));
                return true;
            }
        });
        if (this.kIf.getCount() > 0) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
    }

    protected final int getLayoutId() {
        return R.i.dch;
    }

    public final void a(int i, int i2, String str, k kVar) {
        super.a(i, i2, str, kVar);
        if (i == 0 && i2 == 0 && (kVar instanceof r)) {
            if (this.kIj) {
                h.bu(this, getResources().getString(R.l.dNO));
            } else {
                h.bu(this, getResources().getString(R.l.dNY));
            }
        }
        this.kIj = false;
    }
}
