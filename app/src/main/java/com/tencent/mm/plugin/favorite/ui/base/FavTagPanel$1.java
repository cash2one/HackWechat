package com.tencent.mm.plugin.favorite.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

class FavTagPanel$1 implements OnClickListener {
    final /* synthetic */ FavTagPanel mvr;

    FavTagPanel$1(FavTagPanel favTagPanel) {
        this.mvr = favTagPanel;
    }

    public final void onClick(final View view) {
        if (((Integer) view.getTag()).intValue() == 0) {
            FavTagPanel.a(this.mvr, (TextView) view);
            if (FavTagPanel.a(this.mvr) != null) {
                view.post(new Runnable(this) {
                    final /* synthetic */ FavTagPanel$1 mvs;

                    public final void run() {
                        FavTagPanel.a(this.mvs.mvr);
                        ((TextView) view).getText().toString();
                    }
                });
                return;
            }
            return;
        }
        FavTagPanel.b(this.mvr, (TextView) view);
        if (FavTagPanel.a(this.mvr) != null) {
            view.post(new 2(this, view));
        }
    }
}
