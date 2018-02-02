package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.ao.b;

public final class as {
    public String fus;
    public String fzW;
    public boolean rEQ = false;
    public boolean rER = false;
    public int scene;

    public as(String str, String str2, boolean z, boolean z2, int i) {
        this.fzW = str;
        this.rEQ = z;
        this.rER = z2;
        this.scene = i;
        this.fus = str2;
    }

    public final boolean bBp() {
        int i = 2;
        if (this.scene != 1) {
            if (this.scene == 2) {
                i = 4;
            } else {
                i = -1;
            }
        }
        b Kr = ao.Kr(this.fzW);
        if (Kr == null || !Kr.hik || Kr.hlj || (r0 & Kr.fWj) == 0) {
            return false;
        }
        return true;
    }
}
