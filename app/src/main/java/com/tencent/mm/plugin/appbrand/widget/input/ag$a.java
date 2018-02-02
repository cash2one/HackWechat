package com.tencent.mm.plugin.appbrand.widget.input;

import android.graphics.drawable.Drawable;
import com.tencent.mm.bx.e;
import com.tencent.mm.plugin.appbrand.q.b;
import com.tencent.mm.sdk.platformtools.ac;

final class ag$a extends e {
    private String[] jZP;

    ag$a() {
        super(new ag$c(ac.getContext()));
        this.jZP = null;
        this.jZP = ac.getContext().getResources().getStringArray(b.isw);
    }

    public final int anl() {
        return 0;
    }

    public final int anm() {
        return this.jZP != null ? this.jZP.length : 0;
    }

    public final Drawable mf(int i) {
        return new ag$b(mg(i), ag.bl(), (byte) 0);
    }

    public final String mg(int i) {
        if (this.jZP == null || i < 0 || i > this.jZP.length - 1) {
            return "";
        }
        String[] split = this.jZP[i].split(" ");
        char[] toChars = Character.toChars(Integer.decode(split[0]).intValue());
        return toChars + Character.toChars(Integer.decode(split[1]).intValue());
    }

    public final String getText(int i) {
        return mg(i);
    }

    public final String mh(int i) {
        return mg(i);
    }
}
