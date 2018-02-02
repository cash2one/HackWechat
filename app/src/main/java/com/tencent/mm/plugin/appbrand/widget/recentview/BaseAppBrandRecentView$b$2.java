package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.b;

class BaseAppBrandRecentView$b$2 implements OnLongClickListener {
    final /* synthetic */ b kfA;
    final /* synthetic */ BaseAppBrandRecentView kfz;

    BaseAppBrandRecentView$b$2(b bVar, BaseAppBrandRecentView baseAppBrandRecentView) {
        this.kfA = bVar;
        this.kfz = baseAppBrandRecentView;
    }

    public final boolean onLongClick(View view) {
        a aVar = (a) view.getTag();
        aVar.position = this.kfA.ge();
        if (this.kfA.kfw.kfo != null) {
            this.kfA.kfw.kfo.b(view, aVar, BaseAppBrandRecentView.b(this.kfA.kfw), BaseAppBrandRecentView.c(this.kfA.kfw));
        }
        BaseAppBrandRecentView.d(this.kfA.kfw);
        return true;
    }
}
