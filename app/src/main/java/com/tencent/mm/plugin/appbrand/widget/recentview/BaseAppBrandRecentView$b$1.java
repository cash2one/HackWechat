package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.b;

class BaseAppBrandRecentView$b$1 implements OnClickListener {
    final /* synthetic */ b kfA;
    final /* synthetic */ BaseAppBrandRecentView kfz;

    BaseAppBrandRecentView$b$1(b bVar, BaseAppBrandRecentView baseAppBrandRecentView) {
        this.kfA = bVar;
        this.kfz = baseAppBrandRecentView;
    }

    public final void onClick(View view) {
        a aVar = (a) view.getTag();
        aVar.position = this.kfA.ge();
        if (this.kfA.kfw.kfo != null) {
            this.kfA.kfw.kfo.a(view, aVar, BaseAppBrandRecentView.b(this.kfA.kfw), BaseAppBrandRecentView.c(this.kfA.kfw));
        }
        this.kfA.kfw.fm().UR.notifyChanged();
    }
}
