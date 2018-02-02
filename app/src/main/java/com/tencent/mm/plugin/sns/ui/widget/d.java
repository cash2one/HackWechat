package com.tencent.mm.plugin.sns.ui.widget;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static d rRN = new d();
    public int rRJ = 0;
    private a rRO = null;
    private a rRP = null;

    public static d bCF() {
        return rRN;
    }

    public final a bCE() {
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), (int) (15.0f * com.tencent.mm.bv.a.eu(ac.getContext())));
        if (this.rRO == null || ((int) this.rRO.gUh) != fromDPToPix) {
            this.rRO = b.Ek().gF(19).gG(ac.getContext().getResources().getColor(c.btv)).P((float) fromDPToPix).gTR;
        }
        return this.rRO;
    }

    public final a bCG() {
        int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), (int) (15.0f * com.tencent.mm.bv.a.eu(ac.getContext())));
        if (this.rRP == null || ((int) this.rRP.gUh) != fromDPToPix) {
            b P = b.Ek().gF(19).gG(ac.getContext().getResources().getColor(c.btv)).P((float) fromDPToPix);
            P.gTR.maxLines = 6;
            this.rRP = P.gTR;
        }
        return this.rRP;
    }

    public final int bCH() {
        if (this.rRJ <= 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) ac.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int dimension = (int) (ac.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvJ) + ac.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvJ));
            int dimension2 = (int) ac.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.qyM);
            int dimension3 = (int) ac.getResources().getDimension(com.tencent.mm.plugin.sns.i.d.bvJ);
            this.rRJ = (i - dimension2) - dimension;
            x.i("MicroMsg.SnsPostDescPreloadTextViewConfig", "screenWidth " + i + " textViewWidth " + this.rRJ + " padding: " + dimension + " marginLeft: " + dimension2 + " thisviewPadding: " + dimension3);
        }
        return this.rRJ;
    }

    public static float getTextSize() {
        return (float) com.tencent.mm.bv.a.fromDPToPix(ac.getContext(), (int) (15.0f * com.tencent.mm.bv.a.eu(ac.getContext())));
    }
}
