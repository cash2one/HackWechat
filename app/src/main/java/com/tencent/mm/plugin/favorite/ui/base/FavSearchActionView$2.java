package com.tencent.mm.plugin.favorite.ui.base;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.MMTagPanel.d;
import java.util.Iterator;

class FavSearchActionView$2 implements OnClickListener {
    final /* synthetic */ FavSearchActionView mvk;

    FavSearchActionView$2(FavSearchActionView favSearchActionView) {
        this.mvk = favSearchActionView;
    }

    public final void onClick(View view) {
        if (FavSearchActionView.d(this.mvk) != null) {
            d dVar;
            FavTagPanel a = FavSearchActionView.a(this.mvk);
            Iterator it = a.mvo.iterator();
            while (it.hasNext()) {
                dVar = (d) it.next();
                a.removeView(dVar.yed);
                a.a(dVar);
            }
            a.mvo.clear();
            a.cpJ();
            MMTagPanel a2 = FavSearchActionView.a(this.mvk);
            it = a2.wfh.iterator();
            while (it.hasNext()) {
                dVar = (d) it.next();
                a2.removeView(dVar.yed);
                a2.a(dVar);
            }
            a2.wfh.clear();
            a2.cpJ();
            FavSearchActionView.a(this.mvk).cpD();
            FavSearchActionView.e(this.mvk).clear();
            FavSearchActionView.f(this.mvk).clear();
            FavSearchActionView.b(this.mvk).clear();
            FavSearchActionView.d(this.mvk).a(FavSearchActionView.e(this.mvk), FavSearchActionView.f(this.mvk), FavSearchActionView.b(this.mvk), true);
            FavSearchActionView.c(this.mvk);
        }
    }
}
