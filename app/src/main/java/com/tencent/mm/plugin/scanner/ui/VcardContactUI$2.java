package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import com.tencent.mm.bm.d;
import com.tencent.mm.ui.base.h$c;

class VcardContactUI$2 implements h$c {
    final /* synthetic */ VcardContactUI pZs;
    final /* synthetic */ String pZt;

    VcardContactUI$2(VcardContactUI vcardContactUI, String str) {
        this.pZs = vcardContactUI;
        this.pZt = str;
    }

    public final void jl(int i) {
        Intent intent;
        switch (i) {
            case 0:
                intent = new Intent();
                String[] strArr = new String[]{this.pZt + " " + this.pZt};
                intent.putExtra("composeType", 4);
                intent.putExtra("toList", strArr);
                d.b(this.pZs, "qqmail", ".ui.ComposeUI", intent);
                return;
            case 1:
                intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.EMAIL", new String[]{this.pZt});
                this.pZs.startActivity(intent);
                return;
            default:
                return;
        }
    }
}
