package com.tencent.mm.plugin.wenote.model.nativenote.c;

import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;

public final class d {
    public int endPos = -1;
    public int hlq = -1;
    public int startOffset = -1;
    public int tUN = -1;

    public d() {
        set(-1, -1, -1, -1);
    }

    public d(int i, int i2, int i3, int i4) {
        set(i, i2, i3, i4);
    }

    public final void set(int i, int i2, int i3, int i4) {
        this.hlq = i;
        this.startOffset = i2;
        this.endPos = i3;
        this.tUN = i4;
    }

    public final int bXe() {
        if (this.hlq < 0 || this.startOffset < 0 || this.endPos < 0 || this.tUN < 0 || this.hlq > this.endPos || (this.hlq == this.endPos && this.startOffset > this.tUN)) {
            return 0;
        }
        b Bt = c.bWp().Bt(this.hlq);
        b Bt2 = c.bWp().Bt(this.endPos);
        if (Bt == null || Bt2 == null) {
            return 0;
        }
        if (this.hlq == this.endPos && this.startOffset == this.tUN) {
            return 1;
        }
        if (this.hlq == this.endPos && Bt.getType() == 1) {
            return 2;
        }
        return 3;
    }
}
