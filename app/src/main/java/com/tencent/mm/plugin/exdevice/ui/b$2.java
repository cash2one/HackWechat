package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class b$2 implements OnClickListener {
    final /* synthetic */ b lWu;

    b$2(b bVar) {
        this.lWu = bVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
        b.a(this.lWu).zs(this.lWu.pn(((Integer) view.getTag()).intValue()).lZj.field_username);
    }
}
