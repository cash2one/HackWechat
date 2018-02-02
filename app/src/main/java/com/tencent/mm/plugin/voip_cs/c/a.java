package com.tencent.mm.plugin.voip_cs.c;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public ak ikI = new ak(new 1(this), true);
    public TextView kO;
    public int[] sqo;
    public int sqp;
    public int sqq;

    public final void bIg() {
        if (this.ikI != null) {
            this.ikI.TG();
        }
        x.j("MicroMsg.DynamicTextWrap", "stop textview: " + this.kO, new Object[0]);
        this.kO = null;
    }
}
