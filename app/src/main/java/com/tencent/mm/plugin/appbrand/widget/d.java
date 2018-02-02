package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.MenuAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class d implements com.tencent.mm.plugin.appbrand.widget.recentview.d {
    public final AppBrandRecentView y(Context context, int i) {
        return a(context, i, null);
    }

    public final AppBrandRecentView a(Context context, int i, a aVar) {
        AppBrandRecentView cVar;
        LayoutParams layoutParams;
        if (i == b.kfI) {
            cVar = new c(context);
            cVar.kfd = aVar;
            layoutParams = new FrameLayout.LayoutParams(-1, (int) context.getResources().getDimension(k.a.jVd));
            cVar.setPadding(0, (int) context.getResources().getDimension(k.a.jVe), 0, 0);
            cVar.setLayoutParams(layoutParams);
            return cVar;
        } else if (i != b.kfH) {
            return null;
        } else {
            cVar = new MenuAppBrandRecentView(context);
            cVar.kfd = aVar;
            layoutParams = new FrameLayout.LayoutParams(-1, (int) context.getResources().getDimension(k.a.jVd));
            cVar.setPadding(0, (int) context.getResources().getDimension(k.a.jVe), 0, 0);
            cVar.setLayoutParams(layoutParams);
            return cVar;
        }
    }

    public final void cj(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context, "com.tencent.mm.ui.LauncherUI").addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(67108864).addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        intent.putExtra("isShowHeaderWithAnim", true);
        intent.putExtra("isShowHeader", true);
        intent.putExtra("isScrollFirst", true);
        context.startActivity(intent);
    }

    public final void ami() {
        x.i("MicroMsg.AppBrandRecentViewService", "[hideAppBrandRecentView] delay:%s type:%s", new Object[]{Integer.valueOf(300), Integer.valueOf(8)});
        if (((h) g.Dg().CN()).DS()) {
            com.tencent.mm.sdk.b.b ieVar = new ie();
            ieVar.fyC.delay = 300;
            ieVar.fyC.type = 8;
            com.tencent.mm.sdk.b.a.xef.m(ieVar);
        }
    }

    public final com.tencent.mm.plugin.appbrand.widget.recentview.b amj() {
        return new com.tencent.mm.plugin.appbrand.widget.recentview.b();
    }
}
