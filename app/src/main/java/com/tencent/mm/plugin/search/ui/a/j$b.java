package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.gm;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.a.b.b;
import com.tencent.mm.plugin.fts.d.e;

public class j$b extends b {
    final /* synthetic */ j qey;

    public j$b(j jVar) {
        this.qey = jVar;
        super(jVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.i.diV, viewGroup, false);
        j$a com_tencent_mm_plugin_search_ui_a_j_a = this.qey.qex;
        com_tencent_mm_plugin_search_ui_a_j_a.iip = (ImageView) inflate.findViewById(R.h.bLL);
        com_tencent_mm_plugin_search_ui_a_j_a.iiq = (TextView) inflate.findViewById(R.h.cSu);
        com_tencent_mm_plugin_search_ui_a_j_a.iir = (TextView) inflate.findViewById(R.h.caS);
        com_tencent_mm_plugin_search_ui_a_j_a.contentView = inflate.findViewById(R.h.cJK);
        inflate.setTag(com_tencent_mm_plugin_search_ui_a_j_a);
        return inflate;
    }

    public final void a(Context context, a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
        j jVar = (j) bVar;
        j$a com_tencent_mm_plugin_search_ui_a_j_a = (j$a) aVar;
        com_tencent_mm_plugin_search_ui_a_j_a.iiq.setText(this.qey.qeu);
        e.a(this.qey.qev, com_tencent_mm_plugin_search_ui_a_j_a.iir);
        e.a(context, com_tencent_mm_plugin_search_ui_a_j_a.iip, jVar.jiK, jVar.moS, R.k.dyF, 0, 0);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
        j jVar = (j) bVar;
        com.tencent.mm.sdk.b.b gmVar = new gm();
        gmVar.fwC.context = context;
        gmVar.fwC.actionCode = 2;
        gmVar.fwC.appId = jVar.nlG.field_appId;
        gmVar.fwC.extMsg = "search_src=40";
        gmVar.fwC.scene = 4;
        com.tencent.mm.sdk.b.a.xef.m(gmVar);
        return true;
    }
}
