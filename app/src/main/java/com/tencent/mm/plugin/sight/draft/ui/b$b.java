package com.tencent.mm.plugin.sight.draft.ui;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.sight.draft.ui.b.e;

class b$b implements OnLongClickListener {
    final /* synthetic */ b qvI;

    private b$b(b bVar) {
        this.qvI = bVar;
    }

    public final boolean onLongClick(View view) {
        if (view.getTag() instanceof e) {
            e eVar = (e) view.getTag();
            if (!(eVar.qvP == null || -1 == eVar.qvP.field_fileStatus)) {
                this.qvI.a(b$d.EDIT, true);
            }
        }
        return true;
    }
}
