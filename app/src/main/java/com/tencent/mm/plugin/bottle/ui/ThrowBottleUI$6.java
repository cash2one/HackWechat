package com.tencent.mm.plugin.bottle.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ThrowBottleUI$6 implements a {
    int count = 0;
    final /* synthetic */ ThrowBottleUI kEz;

    ThrowBottleUI$6(ThrowBottleUI throwBottleUI) {
        this.kEz = throwBottleUI;
    }

    public final boolean uF() {
        if (ThrowBottleUI.t(this.kEz) == -1) {
            ThrowBottleUI.a(this.kEz, bh.Wq());
        }
        if (this.count % 3 == 2) {
            ThrowBottleUI.u(this.kEz).setWidth(ThrowBottleUI.u(this.kEz).getWidth() + 1);
        }
        this.count++;
        this.count %= 3;
        long bA = bh.bA(ThrowBottleUI.t(this.kEz));
        if (bA >= 50000 && bA <= 60000) {
            int i;
            if (ThrowBottleUI.v(this.kEz) == null) {
                i = (int) ((60000 - bA) / 1000);
                ThrowBottleUI.a(this.kEz, Toast.makeText(ThrowBottleUI.h(this.kEz), ThrowBottleUI.h(this.kEz).getResources().getQuantityString(R.j.duo, i, new Object[]{Integer.valueOf(i)}), 0));
            } else {
                i = (int) ((60000 - bA) / 1000);
                ThrowBottleUI.v(this.kEz).setText(ThrowBottleUI.h(this.kEz).getResources().getQuantityString(R.j.duo, i, new Object[]{Integer.valueOf(i)}));
            }
            ThrowBottleUI.v(this.kEz).show();
        }
        if (bA < 60000) {
            return true;
        }
        x.v("MM.Bottle.ThrowBottleUI", "bottle record stop on countdown");
        ThrowBottleUI.w(this.kEz);
        this.kEz.asf();
        ThrowBottleUI.x(this.kEz);
        ar.H(ThrowBottleUI.h(this.kEz), R.l.eRg);
        return false;
    }
}
