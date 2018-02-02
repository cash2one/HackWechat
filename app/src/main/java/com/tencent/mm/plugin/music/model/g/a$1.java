package com.tencent.mm.plugin.music.model.g;

import com.tencent.mm.sdk.platformtools.aq.a;

class a$1 implements a {
    final /* synthetic */ a oMf;

    a$1(a aVar) {
        this.oMf = aVar;
    }

    public final void fi(int i) {
        switch (i) {
            case 0:
                if (this.oMf.oKA) {
                    this.oMf.oKA = false;
                    this.oMf.resume();
                    return;
                }
                return;
            case 1:
            case 2:
                if (this.oMf.Qq()) {
                    this.oMf.oKA = true;
                    this.oMf.pause();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
