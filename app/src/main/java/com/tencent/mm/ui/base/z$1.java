package com.tencent.mm.ui.base;

import android.text.Layout;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.ui.base.z.b;

class z$1 implements OnLongClickListener {
    final /* synthetic */ z yhd;

    z$1(z zVar) {
        this.yhd = zVar;
    }

    public final boolean onLongClick(View view) {
        z zVar = this.yhd;
        int i = this.yhd.ygS;
        int i2 = this.yhd.ygT;
        zVar.cqc();
        zVar.cqd();
        zVar.fJl = false;
        if (zVar.ygM == null) {
            zVar.ygM = new b(zVar, true);
        }
        if (zVar.ygN == null) {
            zVar.ygN = new b(zVar, false);
        }
        Layout layout = zVar.kO.getLayout();
        if (layout != null) {
            i2 = layout.getOffsetForHorizontal(layout.getLineForVertical(i2), (float) i);
            i = ((int) layout.getPrimaryHorizontal(i2)) > i ? layout.getOffsetToLeftOf(i2) : i2;
        } else {
            i = -1;
        }
        int i3 = i + 1;
        if (zVar.kO.getText() instanceof Spannable) {
            zVar.ygQ = (Spannable) zVar.kO.getText();
        }
        if (zVar.ygQ != null && i < zVar.kO.getText().length()) {
            zVar.eU(i, i3);
            zVar.a(zVar.ygM);
            zVar.a(zVar.ygN);
            zVar.cqe();
        }
        return true;
    }
}
