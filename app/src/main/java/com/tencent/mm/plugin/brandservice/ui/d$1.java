package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a;
import com.tencent.mm.ui.base.sortview.a.b;

class d$1 extends b {
    final /* synthetic */ d kGc;

    d$1(d dVar) {
        this.kGc = dVar;
    }

    public final boolean a(Context context, a aVar, Object... objArr) {
        return true;
    }

    public final View b(Context context, View view) {
        if (view == null) {
            return View.inflate(context, R.i.drt, null);
        }
        return view;
    }

    public final void a(Context context, a.a aVar, a aVar2) {
        if (context == null || aVar == null || aVar2 == null) {
            x.e("MicroMsg.CatalogDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
        } else if (!(aVar instanceof d$a)) {
            x.e("MicroMsg.CatalogDataItem", "The ViewHolder is not a instance of CatalogViewHolder.");
        } else if (aVar2 instanceof d) {
            com.tencent.mm.plugin.brandservice.a.a.b(((d$a) aVar).kEY, ((d) aVar2).kFg);
        } else {
            x.e("MicroMsg.CatalogDataItem", "The DataItem is not a instance of CatalogDataItem.");
        }
    }

    public final void a(View view, a.a aVar) {
        if (view != null && aVar != null && (aVar instanceof d$a)) {
            ((d$a) aVar).kEY = (TextView) view.findViewById(R.h.bSw);
        }
    }
}
