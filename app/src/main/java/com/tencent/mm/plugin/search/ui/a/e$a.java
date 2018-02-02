package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.d.a.b.a;
import com.tencent.mm.plugin.fts.d.a.b.b;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.sdk.platformtools.bh;

public class e$a extends b {
    final /* synthetic */ e qdX;

    public e$a(e eVar) {
        this.qdX = eVar;
        super(eVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.i.diQ, viewGroup, false);
        e$b com_tencent_mm_plugin_search_ui_a_e_b = this.qdX.qdW;
        com_tencent_mm_plugin_search_ui_a_e_b.qdY = (TextView) inflate.findViewById(R.h.col);
        com_tencent_mm_plugin_search_ui_a_e_b.qdZ = (ImageView) inflate.findViewById(R.h.bLF);
        com_tencent_mm_plugin_search_ui_a_e_b.qea = (TextView) inflate.findViewById(R.h.com);
        com_tencent_mm_plugin_search_ui_a_e_b.qeb = (ImageView) inflate.findViewById(R.h.bLG);
        com_tencent_mm_plugin_search_ui_a_e_b.mPP = (TextView) inflate.findViewById(R.h.cpO);
        com_tencent_mm_plugin_search_ui_a_e_b.contentView = inflate.findViewById(R.h.cJK);
        com_tencent_mm_plugin_search_ui_a_e_b.mPK = inflate.findViewById(R.h.cCk);
        inflate.setTag(com_tencent_mm_plugin_search_ui_a_e_b);
        return inflate;
    }

    public void a(Context context, a aVar, com.tencent.mm.plugin.fts.d.a.b bVar, Object... objArr) {
        e$b com_tencent_mm_plugin_search_ui_a_e_b = (e$b) aVar;
        e.a(this.qdX.qdQ, com_tencent_mm_plugin_search_ui_a_e_b.qdY);
        com.tencent.mm.pluginsdk.ui.a.b.a(com_tencent_mm_plugin_search_ui_a_e_b.qdZ, this.qdX.qdR);
        e.a(this.qdX.qdS, com_tencent_mm_plugin_search_ui_a_e_b.qea);
        if (bh.ov(this.qdX.qdT)) {
            com_tencent_mm_plugin_search_ui_a_e_b.qeb.setVisibility(8);
        } else {
            com_tencent_mm_plugin_search_ui_a_e_b.qeb.setVisibility(0);
            com.tencent.mm.pluginsdk.ui.a.b.a(com_tencent_mm_plugin_search_ui_a_e_b.qeb, this.qdX.qdT);
        }
        cn(com_tencent_mm_plugin_search_ui_a_e_b.contentView);
        if (this.qdX.position == 0) {
            com_tencent_mm_plugin_search_ui_a_e_b.mPK.setVisibility(8);
        } else {
            com_tencent_mm_plugin_search_ui_a_e_b.mPK.setVisibility(0);
        }
        com_tencent_mm_plugin_search_ui_a_e_b.mPP.setVisibility(0);
    }

    public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.b bVar) {
        return false;
    }
}
