package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.plugin.shake.ui.ShakeItemListUI.1;
import com.tencent.mm.z.ar;

class ShakeItemListUI$1$1 implements OnClickListener {
    final /* synthetic */ 1 qqC;

    ShakeItemListUI$1$1(1 1) {
        this.qqC = 1;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (ShakeItemListUI.a(this.qqC.qqB)) {
            case -12:
            case 11:
                m.brC().wa(11);
                break;
            case -6:
            case 5:
                m.brC().wa(7);
                m.brC().wa(6);
                m.brC().wa(8);
                m.brC().wa(9);
                m.brC().wa(10);
                m.brC().wa(12);
                break;
            case -5:
            case 4:
                ar.Dm().F(new i.1());
                m.brC().wa(4);
                break;
            case -1:
            case 0:
                m.brC().wa(0);
                break;
            case 100:
                m.brC().wa(0);
                m.brC().brt();
                break;
        }
        ShakeItemListUI.b(this.qqC.qqB).Xy();
        ShakeItemListUI.c(this.qqC.qqB).setVisibility(8);
        TextView textView = (TextView) this.qqC.qqB.findViewById(R.h.cyY);
        textView.setText(ShakeItemListUI.wh(ShakeItemListUI.a(this.qqC.qqB)));
        textView.setVisibility(0);
        this.qqC.qqB.enableOptionMenu(false);
    }
}
