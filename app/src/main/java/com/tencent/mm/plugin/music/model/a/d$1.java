package com.tencent.mm.plugin.music.model.a;

import com.tencent.mm.sdk.platformtools.aq.a;

class d$1 implements a {
    final /* synthetic */ d oKC;

    d$1(d dVar) {
        this.oKC = dVar;
    }

    public final void fi(int i) {
        switch (i) {
            case 0:
                if (this.oKC.oKA) {
                    this.oKC.oKA = false;
                    this.oKC.resume();
                    return;
                }
                return;
            case 1:
            case 2:
                if (this.oKC.Qq()) {
                    this.oKC.oKA = true;
                    this.oKC.pause();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
