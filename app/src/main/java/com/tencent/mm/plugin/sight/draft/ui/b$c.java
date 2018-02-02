package com.tencent.mm.plugin.sight.draft.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.draft.ui.b.e;
import com.tencent.mm.sdk.platformtools.x;

class b$c implements OnClickListener {
    final /* synthetic */ b qvI;

    private b$c(b bVar) {
        this.qvI = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof e) {
            b.f(this.qvI).btn();
            e eVar = (e) view.getTag();
            if (eVar.qvP == null) {
                x.e("MicroMsg.SightDraftContainerAdapter", "draftInfo is NULL");
                return;
            }
            eVar.qvP.field_fileStatus = 6;
            o.TY().c(eVar.qvP, new String[]{"localId"});
            this.qvI.a(null, null);
        }
    }
}
