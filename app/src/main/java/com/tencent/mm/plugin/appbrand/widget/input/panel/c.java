package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.bx.e;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase.a;
import com.tencent.mm.sdk.platformtools.ac;

public class c {
    public Context kaK;
    boolean kbb = false;
    public b kbd;
    public a kbe;
    int kbf;
    int kbg;

    public final a anz() {
        if (this.kbd == null) {
            this.kbd = new b();
            this.kbd.kaK = this.kaK;
            this.kbd.a(this);
        }
        return this.kbd;
    }

    public static int[] akV() {
        r1 = new int[2];
        Display defaultDisplay = ((WindowManager) ac.getContext().getSystemService("window")).getDefaultDisplay();
        r1[0] = defaultDisplay.getWidth();
        r1[1] = defaultDisplay.getHeight();
        return r1;
    }

    public e ank() {
        return e.chc();
    }
}
