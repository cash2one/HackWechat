package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.r;
import com.tencent.mm.plugin.appbrand.m.c;
import com.tencent.mm.plugin.appbrand.m.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.i;

class c$1 implements a {
    final /* synthetic */ c kfE;

    c$1(c cVar) {
        this.kfE = cVar;
    }

    public final boolean a(View view, a aVar, float f, float f2) {
        if (c.a(this.kfE) != null) {
            c.a(this.kfE).a(view, aVar, f, f2);
        }
        if (aVar.type == 0) {
            ((e) g.h(e.class)).w(this.kfE.getContext(), 13);
        } else {
            this.kfE.R(true);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1089;
            ((c) g.h(c.class)).a(this.kfE.getContext(), aVar.kfb.username, null, aVar.kfb.iKd, -1, null, appBrandStatObject);
        }
        return false;
    }

    public final boolean b(View view, final a aVar, float f, float f2) {
        if (c.a(this.kfE) != null) {
            c.a(this.kfE).b(view, aVar, f, f2);
        }
        x.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] x:%s", new Object[]{Float.valueOf(f)});
        if (aVar.type != 0) {
            new i(this.kfE.getContext()).a(view, 0, 0, new 1(this), new d(this) {
                final /* synthetic */ c$1 kfF;

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    if (menuItem.getItemId() == 1 && aVar.position >= 0) {
                        c.b(this.kfF.kfE);
                        x.i("MicroMsg.ConversationAppBrandRecentView", "[onItemLongClick] Delete position:%s", new Object[]{Integer.valueOf(aVar.position)});
                        ((r) g.h(r.class)).am(aVar.kfb.username, aVar.kfb.iKd);
                        this.kfF.kfE.anY().remove(aVar.position);
                        this.kfF.kfE.fm().bl(aVar.position);
                    }
                }
            }, (int) f, (int) f2);
        }
        return false;
    }
}
