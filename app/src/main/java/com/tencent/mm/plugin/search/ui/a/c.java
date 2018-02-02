package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.d;
import com.tencent.mm.plugin.fts.d.e;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.q;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.r;

public final class c extends k {
    public q qcf;
    public CharSequence qdK;
    private a qdL = new a(this);

    public class a extends k$b {
        final /* synthetic */ c qdM;

        public a(c cVar) {
            this.qdM = cVar;
            super(cVar);
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, b bVar, Object... objArr) {
            c cVar = (c) bVar;
            k$a com_tencent_mm_plugin_search_ui_a_k_a = (k$a) aVar;
            cm(com_tencent_mm_plugin_search_ui_a_k_a.contentView);
            if (bh.ov(cVar.iVU.talker)) {
                com.tencent.mm.pluginsdk.ui.a.b.a(com_tencent_mm_plugin_search_ui_a_k_a.iip, cVar.iVU.mLs);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(com_tencent_mm_plugin_search_ui_a_k_a.iip, cVar.iVU.talker);
            }
            e.a(cVar.qdK, com_tencent_mm_plugin_search_ui_a_k_a.kBH);
            e.a(cVar.iim, com_tencent_mm_plugin_search_ui_a_k_a.ldJ);
            e.a(cVar.qeA, com_tencent_mm_plugin_search_ui_a_k_a.ldK);
        }
    }

    public c(int i) {
        super(i);
    }

    public final b.b adp() {
        return this.qdL;
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.b.a aVar, Object... objArr) {
        CharSequence gu;
        super.a(context, aVar, objArr);
        ar.Hg();
        af WO = com.tencent.mm.z.c.EY().WO(this.iVU.talker);
        if (WO == null) {
            gu = r.gu(this.iVU.mLs);
        } else if (!bh.ov(WO.field_conRemark)) {
            gu = WO.field_conRemark;
        } else if (this.qcf != null) {
            gu = this.qcf.gu(this.iVU.talker);
            if (bh.ov(gu)) {
                gu = r.gt(this.iVU.talker);
            }
        } else {
            gu = r.gt(this.iVU.talker);
        }
        if (!bh.ov(gu)) {
            this.qdK = i.d(context, gu, (float) d.b.mOI);
        }
    }
}
