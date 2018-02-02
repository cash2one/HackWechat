package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.xweb.b;

class h$6 implements OnMenuItemClickListener {
    final /* synthetic */ String jvh;
    final /* synthetic */ h mZZ;

    h$6(h hVar, String str) {
        this.mZZ = hVar;
        this.jvh = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        String replaceAll = this.jvh.replaceAll("tp=webp", "");
        s.a(h.b(this.mZZ), replaceAll, b.cIj().getCookie(replaceAll), f.ze(), new 1(this));
        return true;
    }
}
