package com.tencent.mm.plugin.game.ui;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.aq.a.c.g;
import com.tencent.mm.aq.a.d.b;
import com.tencent.mm.sdk.platformtools.ag;

class GameInstalledView$1 implements g {
    final /* synthetic */ GameInstalledView nsa;
    final /* synthetic */ View zS;

    GameInstalledView$1(GameInstalledView gameInstalledView, View view) {
        this.nsa = gameInstalledView;
        this.zS = view;
    }

    public final void lC(String str) {
    }

    public final Bitmap a(String str, b bVar) {
        return null;
    }

    public final void a(String str, View view, b bVar) {
        if (bVar.status == 0) {
            ag.y(new 1(this));
        }
    }
}
