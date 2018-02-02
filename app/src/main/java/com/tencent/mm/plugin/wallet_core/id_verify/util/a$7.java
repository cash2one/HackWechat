package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.id_verify.model.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.wallet_core.d.c;
import com.tencent.mm.wallet_core.ui.e;

class a$7 implements OnClickListener {
    final /* synthetic */ int sKm;
    final /* synthetic */ a sKo;

    a$7(a aVar, int i) {
        this.sKo = aVar;
        this.sKm = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        e.a(2, bh.Wo(), this.sKm);
        if (this.sKo.sKj != null && this.sKo.sKj.get() != null) {
            g.Dk();
            g.Di().gPJ.a(385, this.sKo);
            ((c) this.sKo.sKj.get()).a(new a(this.sKo.irz), true);
        }
    }
}
