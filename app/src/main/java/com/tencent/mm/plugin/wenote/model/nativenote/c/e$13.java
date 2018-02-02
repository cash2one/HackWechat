package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.sdk.platformtools.x;

class e$13 implements OnClickListener {
    final /* synthetic */ e tVw;

    public e$13(e eVar) {
        this.tVw = eVar;
    }

    public final void onClick(View view) {
        x.i("NoteSelectManager", "select all");
        this.tVw.bXl();
        if (e.cq()) {
            int bWz = c.bWp().bWz();
            int bWA = c.bWp().bWA();
            b Bt = c.bWp().Bt(bWz);
            b Bt2 = c.bWp().Bt(bWA);
            if (Bt == null || Bt2 == null) {
                x.e("NoteSelectManager", "select all: item is null");
                e.h(this.tVw);
                return;
            }
            int length;
            if (Bt2.getType() == 1) {
                Spanned QN = a.QN(((h) Bt2).content);
                if (QN == null) {
                    x.e("NoteSelectManager", "select all: spanned is null");
                    e.h(this.tVw);
                    return;
                }
                length = QN.length();
            } else {
                length = 1;
            }
            e.e(this.tVw);
            this.tVw.t(bWz, 0, bWA, length);
            this.tVw.bXn();
            this.tVw.bXl();
            e.j(this.tVw);
            this.tVw.kN(false);
            this.tVw.h(false, 50);
            return;
        }
        x.e("NoteSelectManager", "select all: not init");
    }
}
