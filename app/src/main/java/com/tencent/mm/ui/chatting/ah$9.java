package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p$d;

class ah$9 implements p$d {
    final /* synthetic */ au heR;
    final /* synthetic */ Context val$context;

    ah$9(au auVar, Context context) {
        this.heR = auVar;
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        String str;
        String str2 = menuItem.getTitle();
        String str3 = aj.Xp(this.heR.field_content).fqR;
        if (str3 == null || str3.endsWith("-1")) {
            str = this.heR.field_imgPath;
        } else {
            str = str3;
        }
        if (str == null) {
            x.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: filePath is null");
            return;
        }
        x.i("MicroMsg.LongClickBrandServiceHelper", "connector click[emoji]: to[%s] filePath[%s]", new Object[]{str2, str});
        if (((c) g.k(c.class)).getEmojiMgr().m(this.val$context, str2, str)) {
            com.tencent.mm.plugin.report.service.g.pQN.h(10424, new Object[]{Integer.valueOf(47), Integer.valueOf(64), str2});
            h.bu(this.val$context, "");
        }
        com.tencent.mm.plugin.report.service.g.pQN.h(10424, new Object[]{Integer.valueOf(47), Integer.valueOf(64), str2});
        h.bu(this.val$context, this.val$context.getString(R.l.dGy));
    }
}
