package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;

public class RedirectToChattingByPhoneStubUI extends Activity implements e {
    private r mbx = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getString(R.l.dHc);
        this.mbx = h.a(this, "", false, null);
        ag.h(new 1(this), 500);
        ar.CG().a(106, (e) this);
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(106, (e) this);
        if (this.mbx != null) {
            this.mbx.dismiss();
            this.mbx = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        finish();
    }

    public final boolean hideVKB() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager == null) {
            return false;
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus == null) {
            return false;
        }
        IBinder windowToken = currentFocus.getWindowToken();
        if (windowToken == null) {
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
        x.v("MicroMsg.RedirectToChattingByPhoneStubUI", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
        return hideSoftInputFromWindow;
    }
}
