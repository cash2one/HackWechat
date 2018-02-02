package com.tencent.mm.plugin.aa.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.aa.a.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;

class LaunchAAUI$5 implements TextWatcher {
    final /* synthetic */ LaunchAAUI ijW;

    LaunchAAUI$5(LaunchAAUI launchAAUI) {
        this.ijW = launchAAUI;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (editable.toString().startsWith(".")) {
            editable.insert(0, "0");
        }
        String obj = editable.toString();
        int indexOf = obj.indexOf(".");
        int length = obj.length();
        if (indexOf >= 0 && length - indexOf > 3) {
            editable.delete(indexOf + 3, length);
        } else if (indexOf > 6) {
            editable.delete(6, indexOf);
        } else if (indexOf == -1 && length > 6) {
            editable.delete(6, length);
        }
        double d = bh.getDouble(editable.toString(), 0.0d);
        if (LaunchAAUI.f(this.ijW) != null && LaunchAAUI.f(this.ijW).size() > 0) {
            d = (d * 100.0d) / ((double) LaunchAAUI.f(this.ijW).size());
            LaunchAAUI.d(this.ijW);
            if (d > ((double) d.WG())) {
                LaunchAAUI.a(this.ijW, true);
                g.pQN.h(13722, new Object[]{Integer.valueOf(2)});
                LaunchAAUI.c(this.ijW);
                LaunchAAUI.g(this.ijW);
                LaunchAAUI.h(this.ijW);
            }
        }
        LaunchAAUI.a(this.ijW, false);
        LaunchAAUI.c(this.ijW);
        LaunchAAUI.g(this.ijW);
        LaunchAAUI.h(this.ijW);
    }
}
