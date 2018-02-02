package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import com.tencent.mm.plugin.qqmail.ui.ReadMailUI.13;
import com.tencent.mm.ui.base.h.c;

class ReadMailUI$13$1 implements c {
    final /* synthetic */ 13 puM;

    ReadMailUI$13$1(13 13) {
        this.puM = 13;
    }

    public final void jl(int i) {
        int i2 = 0;
        if (i == 3) {
            ReadMailUI.J(this.puM.puG);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this.puM.puG, ComposeUI.class);
        intent.putExtra("mailid", ReadMailUI.a(this.puM.puG));
        intent.putExtra("subject", ReadMailUI.K(this.puM.puG));
        String[] a = ReadMailUI.L(this.puM.puG).a(false, ReadMailUI.l(this.puM.puG));
        String[] a2 = ReadMailUI.c(this.puM.puG).a(true, ReadMailUI.l(this.puM.puG));
        String[] a3 = ReadMailUI.d(this.puM.puG).a(true, ReadMailUI.l(this.puM.puG));
        switch (i) {
            case 0:
                intent.putExtra("composeType", 2);
                intent.putExtra("toList", a);
                break;
            case 1:
                int i3;
                intent.putExtra("composeType", 2);
                String[] strArr = new String[(a.length + a2.length)];
                int length = a.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    i3 = i5 + 1;
                    strArr[i5] = a[i4];
                    i4++;
                    i5 = i3;
                }
                i3 = a2.length;
                while (i2 < i3) {
                    i4 = i5 + 1;
                    strArr[i5] = a2[i2];
                    i2++;
                    i5 = i4;
                }
                intent.putExtra("toList", strArr);
                intent.putExtra("ccList", a3);
                break;
            case 2:
                intent.putExtra("composeType", 3);
                break;
            default:
                return;
        }
        this.puM.puG.startActivity(intent);
    }
}
