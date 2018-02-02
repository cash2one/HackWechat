package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;

class MenuAppBrandRecentView$1 implements a {
    final /* synthetic */ MenuAppBrandRecentView kfK;

    MenuAppBrandRecentView$1(MenuAppBrandRecentView menuAppBrandRecentView) {
        this.kfK = menuAppBrandRecentView;
    }

    public final boolean a(View view, a aVar, float f, float f2) {
        boolean a;
        if (MenuAppBrandRecentView.a(this.kfK) != null) {
            a = MenuAppBrandRecentView.a(this.kfK).a(view, aVar, f, f2);
        } else {
            a = false;
        }
        if (a) {
            return true;
        }
        if (aVar.type == 2) {
            ((d) g.h(d.class)).cj(this.kfK.getContext());
        } else {
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1090;
            ((c) g.h(c.class)).a(this.kfK.getContext(), aVar.kfb.username, null, aVar.kfb.iKd, -1, null, appBrandStatObject);
        }
        return false;
    }

    public final boolean b(View view, a aVar, float f, float f2) {
        if (MenuAppBrandRecentView.a(this.kfK) != null) {
            return MenuAppBrandRecentView.a(this.kfK).b(view, aVar, f, f2);
        }
        return false;
    }
}
