package com.tencent.mm.ui.snackbar;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ui.snackbar.b.c;
import com.tencent.mm.w.a.g;

class SnackContainer$a {
    final TextView nVL;
    final View zfS;
    final TextView zfT;
    final Snack zfU;
    final c zfV;

    private SnackContainer$a(Snack snack, View view, c cVar) {
        this.zfS = view;
        this.nVL = (TextView) view.findViewById(g.gWm);
        this.zfT = (TextView) view.findViewById(g.gWo);
        this.zfU = snack;
        this.zfV = cVar;
    }
}
