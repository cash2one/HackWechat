package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class e$2 implements OnClickListener {
    final /* synthetic */ e tVw;

    public e$2(e eVar) {
        this.tVw = eVar;
    }

    public final void onClick(View view) {
        x.i("NoteSelectManager", "delete");
        if (!e.cq() || !e.k(this.tVw)) {
            x.e("NoteSelectManager", "delete: not init or not editable");
            this.tVw.bXl();
        } else if (e.l(this.tVw)) {
            if (e.m(this.tVw) != null) {
                e.m(this.tVw).bWb();
            }
        } else if (e.m(this.tVw) != null) {
            e.m(this.tVw).bWc();
        } else {
            this.tVw.bXs();
        }
    }
}
