package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.a.b.b;
import com.tencent.mm.plugin.fts.d.e;

public class i$b extends b {
    final /* synthetic */ i qet;

    public i$b(i iVar) {
        this.qet = iVar;
        super(iVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.i.diO, viewGroup, false);
        i$a com_tencent_mm_plugin_search_ui_a_i_a = this.qet.qes;
        com_tencent_mm_plugin_search_ui_a_i_a.iip = (ImageView) inflate.findViewById(R.h.bLL);
        com_tencent_mm_plugin_search_ui_a_i_a.iiq = (TextView) inflate.findViewById(R.h.cSu);
        com_tencent_mm_plugin_search_ui_a_i_a.iir = (TextView) inflate.findViewById(R.h.caS);
        com_tencent_mm_plugin_search_ui_a_i_a.contentView = inflate.findViewById(R.h.cJK);
        inflate.setTag(com_tencent_mm_plugin_search_ui_a_i_a);
        return inflate;
    }

    public final void a(Context context, a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
        i$a com_tencent_mm_plugin_search_ui_a_i_a = (i$a) aVar;
        i iVar = (i) bVar;
        cm(com_tencent_mm_plugin_search_ui_a_i_a.contentView);
        e.a(this.qet.moP, com_tencent_mm_plugin_search_ui_a_i_a.iiq);
        e.a(this.qet.qeo, com_tencent_mm_plugin_search_ui_a_i_a.iir);
        e.a(context, com_tencent_mm_plugin_search_ui_a_i_a.iip, null, iVar.moS, R.k.dyF);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
        i iVar = (i) bVar;
        a(this.qet.mMb.mLA, iVar.iVU);
        if (!((d) g.h(d.class)).tb(iVar.qeq.field_url)) {
            Intent intent;
            if (iVar.qeq.field_actionType == 2) {
                intent = new Intent();
                intent.putExtra("rawUrl", iVar.qeq.field_url);
                com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            } else if (!com.tencent.mm.plugin.search.a.a.K(context, iVar.qeq.field_featureId)) {
                intent = new Intent();
                intent.putExtra("rawUrl", iVar.qeq.field_updateUrl);
                com.tencent.mm.bm.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            }
        }
        return true;
    }
}
