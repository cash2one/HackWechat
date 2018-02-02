package com.tencent.mm.plugin.welab.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.welab.d.b;
import com.tencent.mm.plugin.welab.ui.WelabMainUI;

public final class c implements com.tencent.mm.plugin.welab.a.a.c {
    public final void u(Context context, Intent intent) {
        intent.setClass(context, WelabMainUI.class);
        String str = "para_from_with_red_point";
        int i = (bVz() || bVA()) ? 1 : 0;
        intent.putExtra(str, i);
        context.startActivity(intent);
    }

    public final boolean bVz() {
        b.bVJ();
        return b.bVL() && !bVA();
    }

    public final boolean bVA() {
        b.bVJ();
        if (!b.bVM()) {
            b.bVJ();
            if (b.bVL()) {
                return true;
            }
        }
        return false;
    }

    public final boolean bVB() {
        return !bVA();
    }
}
