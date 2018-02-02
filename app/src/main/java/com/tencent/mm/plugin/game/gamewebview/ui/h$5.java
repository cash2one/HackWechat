package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.b;

class h$5 implements OnMenuItemClickListener {
    final /* synthetic */ String jvh;
    final /* synthetic */ h mZZ;

    h$5(h hVar, String str) {
        this.mZZ = hVar;
        this.jvh = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        try {
            s.a(h.b(this.mZZ), this.jvh, b.cIj().getCookie(this.jvh), f.ze());
        } catch (Exception e) {
            x.e("MicroMsg.GameWebViewMenuListHelper", "save to sdcard failed : %s", new Object[]{e.getMessage()});
        }
        return true;
    }
}
