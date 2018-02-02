package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.plugin.appbrand.widget.k.d;
import com.tencent.mm.plugin.appbrand.widget.k.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.b;

public class MenuAppBrandRecentView extends BaseAppBrandRecentView {
    private a kfC;

    public MenuAppBrandRecentView(Context context) {
        super(context);
    }

    public MenuAppBrandRecentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final String getType() {
        return MenuAppBrandRecentView.class.getSimpleName();
    }

    public final void a(a aVar) {
        this.kfC = aVar;
    }

    protected final void a(b bVar, a aVar) {
        super.a(bVar, aVar);
        bVar.ihS.setTextColor(-1728053248);
        if (aVar.type == 2) {
            bVar.ihS.setVisibility(0);
            bVar.kfx.setVisibility(8);
            bVar.ihS.setText(e.jVm);
            bVar.jCP.setImageResource(d.jVj);
        } else if (aVar.type == -1) {
            bVar.jCP.setImageResource(d.bBB);
        }
    }

    protected final int anX() {
        return 11;
    }

    protected final void init(Context context) {
        super.init(context);
        super.a(new 1(this));
    }
}
