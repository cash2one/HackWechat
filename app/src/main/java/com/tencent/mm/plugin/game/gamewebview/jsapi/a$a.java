package com.tencent.mm.plugin.game.gamewebview.jsapi;

import com.tencent.mm.plugin.game.gamewebview.ui.d;

public class a$a {
    private int jcN;
    private d mWb;

    public a$a(d dVar, int i) {
        this.mWb = dVar;
        this.jcN = i;
    }

    public final void sj(String str) {
        if (this.mWb != null) {
            this.mWb.E(this.jcN, str);
        }
        this.mWb = null;
    }
}
