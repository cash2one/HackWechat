package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class d extends h {
    private static HashMap<String, Boolean> pFH = new HashMap();
    public i pFI = new 1(this);

    public d(Context context, a aVar) {
        super(context, aVar);
    }

    public final void a(a aVar) {
        x.i("MicroMsg.FavRecordAdapter", "updateData localId %s,status %s", new Object[]{Long.valueOf(((b) aVar).pFG.field_localId), Integer.valueOf(((b) aVar).pFG.field_itemStatus)});
        this.pGa = aVar;
        this.pFF.clear();
        this.pFF.addAll(aVar.pFF);
        notifyDataSetChanged();
    }

    public final void d(b bVar) {
        x.d("MicroMsg.FavRecordAdapter", "setupRecord %s", new Object[]{Long.valueOf(((b) this.pGa).pFG.field_localId)});
        bVar.bjS = 1;
        bVar.pFG = ((b) this.pGa).pFG;
    }
}
