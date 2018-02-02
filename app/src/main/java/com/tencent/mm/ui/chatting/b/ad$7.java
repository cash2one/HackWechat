package com.tencent.mm.ui.chatting.b;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.c.a;
import com.tencent.mm.modelvideo.t;

class ad$7 implements a {
    final /* synthetic */ ad yCE;

    ad$7(ad adVar) {
        this.yCE = adVar;
    }

    public final void b(int i, String str, String str2, int i2) {
        if (i == -50002) {
            Toast.makeText(this.yCE.fhr.csq().getContext(), this.yCE.fhr.csq().getContext().getString(R.l.eSY), 0).show();
        } else if (i < 0) {
            Toast.makeText(this.yCE.fhr.csq().getContext(), this.yCE.fhr.csq().getContext().getString(R.l.eSX), 0).show();
        } else {
            t.b(str, i2, this.yCE.fhr.csi().field_username, str2);
            t.nA(str);
        }
        this.yCE.fhr.dismissDialog();
    }
}
