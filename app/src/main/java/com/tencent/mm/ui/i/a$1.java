package com.tencent.mm.ui.i;

import android.content.Context;
import android.os.Message;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.ui.f.a.e;
import com.tencent.mm.ui.i.a.c;

class a$1 extends af {
    final /* synthetic */ a zqb;

    a$1(a aVar) {
        this.zqb = aVar;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1000) {
            String str = (String) message.obj;
            if (str != null) {
                Context context = this.zqb.context;
                b$a com_tencent_mm_ui_i_b_a = this.zqb;
                if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
                    e.C(context, "Error", "Application requires permission to access the Internet");
                } else {
                    new b(context, str, com_tencent_mm_ui_i_b_a).show();
                }
            } else {
                this.zqb.c(c.zqf);
            }
        }
        if (message.what == HardCoderJNI.FUNC_REG_ANR_CALLBACK) {
            c cVar = (c) message.obj;
            a aVar = this.zqb;
            aVar.zpY = false;
            if (cVar == c.zqf) {
                aVar.zpW = null;
                a.a(null);
            }
            if (aVar.zqa != null) {
                aVar.zqa.b(cVar);
            }
        }
    }
}
