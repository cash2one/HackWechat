package com.tencent.mm.plugin.game.gamewebview.e;

import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import java.util.ArrayList;
import java.util.List;

public final class c {
    e juR;
    private List<b> naK = new ArrayList();
    long naL;

    public c(d dVar) {
        this.juR = dVar.mYW;
        this.naL = dVar.mYX;
        this.naK.add(new a(this, (byte) 0));
        this.naK.add(new b(this, (byte) 0));
    }

    public final boolean BT(String str) {
        for (b bVar : this.naK) {
            if (bVar.BT(str)) {
                bVar.BU(str);
                return true;
            }
        }
        return false;
    }
}
