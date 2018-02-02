package com.tencent.mm.plugin.bottle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.q;

class BottlePersonalInfoUI$3 implements OnClickListener {
    final /* synthetic */ BottlePersonalInfoUI kCn;

    BottlePersonalInfoUI$3(BottlePersonalInfoUI bottlePersonalInfoUI) {
        this.kCn = bottlePersonalInfoUI;
    }

    public final void onClick(View view) {
        new f(this.kCn.mController.xIM, x.WD(q.FS())).caa();
    }
}
