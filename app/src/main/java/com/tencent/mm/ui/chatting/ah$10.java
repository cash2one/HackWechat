package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.wcdb.FileUtils;

class ah$10 implements d {
    final /* synthetic */ au heR;
    final /* synthetic */ String iGf;
    final /* synthetic */ int iGh;
    final /* synthetic */ Context val$context;

    ah$10(au auVar, String str, int i, Context context) {
        this.heR = auVar;
        this.iGf = str;
        this.iGh = i;
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        ah.a(menuItem.getTitle(), this.heR, this.iGf);
        switch (this.iGh) {
            case FileUtils.S_IWUSR /*128*/:
                g.pQN.h(10424, new Object[]{Integer.valueOf(49), Integer.valueOf(FileUtils.S_IWUSR), r0});
                break;
            case 256:
                g.pQN.h(10424, new Object[]{Integer.valueOf(49), Integer.valueOf(256), r0});
                break;
            case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                g.pQN.h(10424, new Object[]{Integer.valueOf(49), Integer.valueOf(WXMediaMessage.TITLE_LENGTH_LIMIT), r0});
                break;
        }
        h.bu(this.val$context, this.val$context.getString(R.l.dGy));
    }
}
