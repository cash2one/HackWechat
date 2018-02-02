package com.tencent.mm.plugin.shake.c.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.c.b.a.a;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements OnClickListener {
    final /* synthetic */ a qpf;

    a$2(a aVar) {
        this.qpf = aVar;
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.bPZ) {
            this.qpf.dismiss();
            if (a.a(this.qpf) != null) {
                a.a(this.qpf).brR();
            }
            x.i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
        } else if (view.getId() != R.h.bPp) {
        } else {
            if (a.b(this.qpf) == a.qph) {
                a.a(this.qpf, a.qpi);
                a.b(this.qpf, 0);
                a.c(this.qpf);
                a.d(this.qpf);
            } else if (a.b(this.qpf) == a.qpi) {
            } else {
                if (a.b(this.qpf) == a.qpk) {
                    a.d(this.qpf);
                } else if (a.b(this.qpf) == a.qpj) {
                    com.tencent.mm.sdk.b.a.xef.b(a.e(this.qpf));
                    a.f(this.qpf);
                }
            }
        }
    }
}
