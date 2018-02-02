package com.tencent.mm.plugin.masssend.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$4 implements a {
    final /* synthetic */ b onk;

    b$4(b bVar) {
        this.onk = bVar;
    }

    public final boolean uF() {
        if (this.onk.kEb == -1) {
            this.onk.kEb = bh.Wq();
        }
        long bA = bh.bA(this.onk.kEb);
        if (bA >= 50000 && bA <= 60000) {
            int i;
            if (this.onk.kEc == null) {
                i = (int) ((60000 - bA) / 1000);
                this.onk.kEc = Toast.makeText(this.onk.ond, this.onk.ond.getResources().getQuantityString(R.j.duo, i, new Object[]{Integer.valueOf(i)}), 0);
            } else {
                i = (int) ((60000 - bA) / 1000);
                this.onk.kEc.setText(this.onk.ond.getResources().getQuantityString(R.j.duo, i, new Object[]{Integer.valueOf(i)}));
            }
            this.onk.kEc.show();
        }
        if (bA < 60000) {
            return true;
        }
        x.v("MicroMsg.MassSendFooterEventImpl", "record stop on countdown");
        if (this.onk.onf.vo()) {
            this.onk.aYG();
        }
        this.onk.one.aJO();
        ar.H(this.onk.ond, R.l.eRg);
        return false;
    }
}
