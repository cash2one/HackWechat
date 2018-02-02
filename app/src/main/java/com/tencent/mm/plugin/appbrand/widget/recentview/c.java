package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.widget.k.d;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;
import java.util.List;

public class c extends BaseAppBrandRecentView {
    private a kfC;
    private boolean kfD = false;

    public c(Context context) {
        super(context);
    }

    public final void a(b bVar, a aVar) {
        super.a(bVar, aVar);
        if (aVar.type == 0) {
            bVar.ihS.setVisibility(4);
            bVar.jCP.setImageResource(d.jVk);
        }
    }

    protected final int anX() {
        return 11;
    }

    protected final String getType() {
        return c.class.getSimpleName();
    }

    public final void af(List<a> list) {
        list.add(new a());
    }

    public final void a(a aVar) {
        this.kfC = aVar;
    }

    protected final void init(Context context) {
        super.init(context);
        super.a(new 1(this));
    }

    protected final boolean anW() {
        boolean z = this.kfD;
        this.kfD = false;
        return z;
    }
}
