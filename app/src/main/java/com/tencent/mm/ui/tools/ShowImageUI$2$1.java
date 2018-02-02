package com.tencent.mm.ui.tools;

import android.app.Activity;
import com.tencent.mm.g.a.cf;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h$d;
import com.tencent.mm.ui.tools.ShowImageUI.2;

class ShowImageUI$2$1 implements h$d {
    final /* synthetic */ 2 zmZ;

    ShowImageUI$2$1(2 2) {
        this.zmZ = 2;
    }

    public final void cn(int i, int i2) {
        switch (i2) {
            case 0:
                ShowImageUI.b(this.zmZ.zmY);
                return;
            case 1:
                Activity activity = this.zmZ.zmY;
                b cfVar = new cf();
                long longExtra = activity.getIntent().getLongExtra("key_message_id", -1);
                if (-1 == longExtra) {
                    x.w("MicroMsg.ShowImageUI", "msg id error, try fav simple data");
                    f.a(cfVar, activity.getIntent().getIntExtra("key_favorite_source_type", 1), activity.getIntent().getStringExtra("key_image_path"));
                } else {
                    f.a(cfVar, longExtra);
                }
                cfVar.fqp.activity = activity;
                a.xef.m(cfVar);
                return;
            case 2:
                ShowImageUI.c(this.zmZ.zmY);
                return;
            case 3:
                ShowImageUI.d(this.zmZ.zmY);
                return;
            default:
                return;
        }
    }
}
