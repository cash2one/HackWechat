package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import java.lang.ref.WeakReference;

class b$1 extends a {
    final /* synthetic */ String hpU;
    final /* synthetic */ WeakReference yHX;
    final /* synthetic */ b yHY;

    b$1(b bVar, WeakReference weakReference, String str) {
        this.yHY = bVar;
        this.yHX = weakReference;
        this.hpU = str;
        super(1, null);
    }

    public final void bJ(View view) {
        if (this.yHX != null && this.yHX.get() != null) {
            Context context = (Context) this.yHX.get();
            String str = this.hpU;
            if (context != null && !bh.ov(str)) {
                g.pQN.h(14516, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                Intent putExtra = new Intent().putExtra("Contact_User", str);
                putExtra.putExtra("Contact_Scene", 14);
                d.b(context, "profile", ".ui.ContactInfoUI", putExtra);
            }
        }
    }
}
