package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.widget.g;

class b$2 implements OnClickListener {
    final /* synthetic */ b jNZ;

    b$2(b bVar) {
        this.jNZ = bVar;
    }

    public final void onClick(View view) {
        if (b.a(this.jNZ) != null) {
            b.a(this.jNZ).akZ();
        }
        g gVar = new g(this.jNZ.getContext(), g.ztp, false);
        gVar.rKC = new 1(this);
        gVar.rKD = new 2(this);
        gVar.bUk();
    }
}
