package com.tencent.mm.plugin.aa.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.sdk.platformtools.bh;

protected class LaunchAAByPersonAmountSelectUI$c implements TextWatcher {
    final /* synthetic */ LaunchAAByPersonAmountSelectUI ijj;
    String username;

    public LaunchAAByPersonAmountSelectUI$c(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI, String str) {
        this.ijj = launchAAByPersonAmountSelectUI;
        this.username = str;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        try {
            if (editable.toString().startsWith(".")) {
                editable.insert(0, "0");
            }
            String obj = editable.toString();
            int indexOf = obj.indexOf(".");
            int length = obj.length();
            if (indexOf >= 0 && length - indexOf > 2) {
                editable.delete(indexOf + 3, length);
            }
            int lastIndexOf = obj.lastIndexOf(".");
            if (lastIndexOf != indexOf && lastIndexOf > 0 && length > lastIndexOf) {
                editable.delete(lastIndexOf, length);
            }
        } catch (Exception e) {
        }
        if (bh.M(editable) || bh.getDouble(editable.toString(), 0.0d) <= 0.0d) {
            LaunchAAByPersonAmountSelectUI.c(this.ijj).remove(this.username);
        } else {
            LaunchAAByPersonAmountSelectUI.c(this.ijj).put(this.username, editable.toString());
        }
        LaunchAAByPersonAmountSelectUI.j(this.ijj).removeCallbacks(LaunchAAByPersonAmountSelectUI.i(this.ijj));
        LaunchAAByPersonAmountSelectUI.j(this.ijj).postDelayed(LaunchAAByPersonAmountSelectUI.i(this.ijj), 50);
    }
}
