package com.tencent.mm.plugin.appbrand.game.d.a;

import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.game.d.a.e.2;
import com.tencent.mm.plugin.appbrand.game.d.a.e.4;
import com.tencent.mm.plugin.appbrand.game.d.a.e.5;
import com.tencent.mm.plugin.appbrand.game.d.a.e.6;
import com.tencent.mm.plugin.appbrand.game.d.a.e.7;
import com.tencent.mm.plugin.appbrand.game.widget.input.a;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.b.b;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.tools.h;

class e$1 implements Runnable {
    final /* synthetic */ int gOK;
    final /* synthetic */ String iZF;
    final /* synthetic */ int iZG;
    final /* synthetic */ boolean iZH;
    final /* synthetic */ boolean iZI;
    final /* synthetic */ b iZJ;
    final /* synthetic */ e iZK;
    final /* synthetic */ j iZy;

    e$1(e eVar, j jVar, String str, int i, boolean z, boolean z2, b bVar, int i2) {
        this.iZK = eVar;
        this.iZy = jVar;
        this.iZF = str;
        this.iZG = i;
        this.iZH = z;
        this.iZI = z2;
        this.iZJ = bVar;
        this.gOK = i2;
    }

    public final void run() {
        e eVar = this.iZK;
        j jVar = this.iZy;
        CharSequence charSequence = this.iZF;
        int i = this.iZG;
        boolean z = this.iZH;
        boolean z2 = this.iZI;
        b bVar = this.iZJ;
        if (jVar.Vx) {
            p b = e.b(jVar);
            if (b != null) {
                u bG = a.bG(b.getContentView());
                EditText aeX = bG.aeX();
                if (bh.ov(charSequence)) {
                    aeX.setText("");
                } else {
                    if (charSequence.length() > i) {
                        charSequence = charSequence.substring(0, i);
                    }
                    aeX.setText(charSequence);
                    aeX.setSelection(aeX.getText().length());
                }
                aeX.setSingleLine(!z);
                aeX.jaC = i;
                c GN = n.a(aeX).GN(i);
                GN.znM = false;
                GN.jXW = h.a.zkT;
                GN.a(new 2(eVar, aeX, jVar));
                aeX.addTextChangedListener(new e$3(eVar, jVar));
                aeX.jaA.jZh = new 4(eVar, aeX, jVar);
                bG.jax = new 5(eVar, aeX, jVar, bG);
                bG.jYy = new 6(eVar, aeX, jVar);
                if (!z) {
                    aeX.setOnEditorActionListener(new 7(eVar, z2, aeX, jVar));
                }
                bG.aeX().setImeOptions((bVar == null ? b.kbr : bVar).kbw);
                bG.aeX().setFocusable(true);
                bG.aeX().setFocusableInTouchMode(true);
                bG.show();
            }
        }
        this.iZy.E(this.gOK, this.iZK.e("ok", null));
    }
}
