package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.ListView;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.i.a;
import com.tencent.mm.plugin.appbrand.widget.input.z;

public final class c {
    final z kaa;
    final e kab;
    public final a kan = new a(this) {
        final /* synthetic */ c kar;

        {
            this.kar = r1;
        }

        public final void amF() {
            this.kar.kap = Integer.MIN_VALUE;
            this.kar.mi(3);
        }

        public final void amG() {
            this.kar.kap = Integer.MIN_VALUE;
            this.kar.mi(3);
        }
    };
    public p kao;
    int kap = Integer.MIN_VALUE;
    boolean kaq = false;

    c(z zVar, e eVar) {
        this.kaa = zVar;
        this.kab = eVar;
    }

    final void mi(int i) {
        ListView listView = this.kab.kau;
        if (listView != null && this.kab.inJ.isShowing()) {
            if (1 == i && this.kaq) {
                this.kap = Integer.MIN_VALUE;
                this.kaq = false;
            }
            listView.getViewTreeObserver().addOnPreDrawListener(new 3(this, listView, i));
        }
    }
}
