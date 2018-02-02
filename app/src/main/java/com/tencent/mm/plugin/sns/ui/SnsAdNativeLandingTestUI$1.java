package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.applet.r;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;

class SnsAdNativeLandingTestUI$1 implements OnClickListener {
    final /* synthetic */ SnsAdNativeLandingTestUI ryI;

    SnsAdNativeLandingTestUI$1(SnsAdNativeLandingTestUI snsAdNativeLandingTestUI) {
        this.ryI = snsAdNativeLandingTestUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 259);
        intent.putExtra("select_is_ret", true);
        d.a(this.ryI, ".ui.transmit.SelectConversationUI", intent, 0, new a(this) {
            final /* synthetic */ SnsAdNativeLandingTestUI$1 ryJ;

            {
                this.ryJ = r1;
            }

            public final void b(int i, int i2, Intent intent) {
                if (i2 == -1) {
                    String str;
                    if (intent == null) {
                        str = null;
                    } else {
                        str = intent.getStringExtra("Select_Conv_User");
                    }
                    if (str == null || str.length() == 0) {
                        x.e("MicroMsg.Sns.SnsAdNativieLandingTestUI", "mmOnActivityResult fail, toUser is null");
                        return;
                    }
                    Context context = this.ryJ.ryI;
                    r.a.voy.a(((MMActivity) context).mController, "test title", "http://mmsns.qpic.cn/mmsns/pUBe8EmICSCsszwvTNz7XO46mx3SDurmV95hHIeQvib0AEVBGYU02Mg/150", "test desc", context.getResources().getString(j.dGA), new 1(this, str, context));
                }
            }
        });
    }
}
