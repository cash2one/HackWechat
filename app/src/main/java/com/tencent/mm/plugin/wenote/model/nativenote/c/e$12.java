package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.sdk.platformtools.x;

class e$12 implements OnClickListener {
    final /* synthetic */ e tVw;

    public e$12(e eVar) {
        this.tVw = eVar;
    }

    public final void onClick(View view) {
        b bVar = null;
        x.i("NoteSelectManager", "select");
        this.tVw.bXl();
        if (!e.cq()) {
            x.e("NoteSelectManager", "select: not init");
        } else if (this.tVw.bXe() != 1) {
            x.e("NoteSelectManager", "select: not insert");
            e.h(this.tVw);
        } else if (c.bWp().Bt(e.i(this.tVw).hlq) == null) {
            x.e("NoteSelectManager", "select: item is null");
            e.h(this.tVw);
        } else {
            RecyclerView a = e.a(this.tVw);
            if (a == null) {
                x.e("NoteSelectManager", "select: recyclerView is null");
                e.h(this.tVw);
                return;
            }
            c cW = f.cW(f.g(a, e.i(this.tVw).hlq));
            if (cW == null) {
                x.e("NoteSelectManager", "select: rteInfo is null");
                e.h(this.tVw);
            } else if (cW.tUK != null) {
                Editable text = cW.tUK.getText();
                if (text == null) {
                    x.e("NoteSelectManager", "select: text is null");
                    e.h(this.tVw);
                } else if (text.length() > 0) {
                    cW.tUK.Y(e.i(this.tVw).startOffset, true);
                } else {
                    b Bt = c.bWp().Bt(e.i(this.tVw).hlq - 1);
                    if (Bt != null && Bt.getType() == -3) {
                        Bt = null;
                    }
                    b Bt2 = c.bWp().Bt(e.i(this.tVw).hlq + 1);
                    if (Bt2 == null || Bt2.getType() != -2) {
                        bVar = Bt2;
                    }
                    if (Bt != null) {
                        if (Bt.getType() == 1) {
                            Spanned QN = a.QN(((h) Bt).content);
                            if (QN == null) {
                                x.e("NoteSelectManager", "select: spanned is null");
                                e.h(this.tVw);
                                return;
                            }
                            this.tVw.t(e.i(this.tVw).hlq - 1, QN.length(), e.i(this.tVw).hlq, 0);
                        } else {
                            this.tVw.t(e.i(this.tVw).hlq - 1, 0, e.i(this.tVw).hlq, 0);
                        }
                    } else if (bVar == null) {
                        x.e("NoteSelectManager", "select: no neighbor");
                        e.h(this.tVw);
                        return;
                    } else if (bVar.getType() == 1) {
                        this.tVw.t(e.i(this.tVw).hlq, 0, e.i(this.tVw).hlq + 1, 0);
                    } else {
                        this.tVw.t(e.i(this.tVw).hlq, 0, e.i(this.tVw).hlq + 1, 1);
                    }
                    e.e(this.tVw);
                    this.tVw.N(true, true);
                }
            } else if (cW.tUL == null || cW.tUM == null) {
                x.e("NoteSelectManager", "select: rteInfo invalid");
                e.h(this.tVw);
            } else {
                e.e(this.tVw);
                this.tVw.t(e.i(this.tVw).hlq, 0, e.i(this.tVw).hlq, 1);
                this.tVw.N(true, true);
            }
        }
    }
}
