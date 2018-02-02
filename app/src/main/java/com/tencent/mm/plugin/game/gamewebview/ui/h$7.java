package com.tencent.mm.plugin.game.gamewebview.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.game.gamewebview.ipc.CommonActivityTask;
import com.tencent.mm.sdk.platformtools.x;

class h$7 implements OnMenuItemClickListener {
    final /* synthetic */ String jvk;
    final /* synthetic */ h mZZ;

    h$7(h hVar, String str) {
        this.mZZ = hVar;
        this.jvk = str;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        x.i("MicroMsg.GameWebViewMenuListHelper", "onMenuItemClick recognize qbcode");
        CommonActivityTask commonActivityTask = new CommonActivityTask(h.b(this.mZZ));
        commonActivityTask.type = 1;
        commonActivityTask.msB.putString("result", this.jvk);
        commonActivityTask.msB.putString(SlookSmartClipMetaTag.TAG_TYPE_URL, h.c(this.mZZ));
        commonActivityTask.msB.putInt("codeType", this.mZZ.juU);
        commonActivityTask.msB.putInt("codeVersion", this.mZZ.juV);
        commonActivityTask.aKE();
        return false;
    }
}
