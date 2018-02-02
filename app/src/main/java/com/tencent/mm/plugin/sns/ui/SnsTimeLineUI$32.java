package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.platformtools.bh;

class SnsTimeLineUI$32 implements OnClickListener {
    final /* synthetic */ SnsTimeLineUI rIN;

    SnsTimeLineUI$32(SnsTimeLineUI snsTimeLineUI) {
        this.rIN = snsTimeLineUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.rIN, SnsUserUI.class);
        Intent e = ae.bvl().e(intent, SnsTimeLineUI.D(this.rIN));
        if (e == null) {
            this.rIN.finish();
            return;
        }
        g.Dk();
        int a = bh.a((Integer) g.Dj().CU().get(68388, null), 0);
        g.Dk();
        g.Dj().CU().set(68388, Integer.valueOf(a + 1));
        this.rIN.startActivity(e);
        if ((e.getFlags() & 67108864) != 0) {
            this.rIN.finish();
        }
    }
}
