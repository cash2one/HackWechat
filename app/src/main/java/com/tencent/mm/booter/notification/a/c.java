package com.tencent.mm.booter.notification.a;

import com.tencent.mm.R;
import com.tencent.mm.bl.a;
import com.tencent.mm.k.f;

public final class c {
    public int gAs = -1;

    public final int y(String str, int i) {
        this.gAs = a.bXV();
        if (f.fS(i)) {
            if (f.eR(str)) {
                try {
                    this.gAs = R.g.bHI;
                } catch (Exception e) {
                }
            } else if (f.eS(str)) {
                try {
                    this.gAs = R.g.bHI;
                } catch (Exception e2) {
                }
            }
        }
        if (this.gAs < 0) {
            this.gAs = a.bXV();
        }
        return this.gAs;
    }
}
