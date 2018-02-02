package com.tencent.mm.ui.base;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.k;

class u$a {
    private static Toast vsq = null;
    public static int yep = 0;

    public static void aj(Context context, int i) {
        Context applicationContext = context.getApplicationContext();
        if (yep != i) {
            vsq = null;
            yep = i;
        }
        if (vsq == null) {
            vsq = Toast.makeText(applicationContext, "", 1);
        }
        View inflate = View.inflate(applicationContext, h.gYb, null);
        if (i == 1) {
            ((TextView) inflate.findViewById(g.gWj)).setText(k.gYC);
        } else if (i == 3) {
            ((TextView) inflate.findViewById(g.gWj)).setText(k.gYD);
        } else {
            ((TextView) inflate.findViewById(g.gWj)).setText(k.gYE);
        }
        vsq.setView(inflate);
        vsq.show();
    }
}
