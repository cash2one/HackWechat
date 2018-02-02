package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;

class c$2 extends DataSetObserver {
    final /* synthetic */ c kar;

    c$2(c cVar) {
        this.kar = cVar;
    }

    public final void onChanged() {
        if (this.kar.kab.inJ.isShowing()) {
            this.kar.mi(1);
        }
    }
}
