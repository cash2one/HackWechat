package com.tencent.mm.ui.account.bind;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bh;

class BindMobileUI$2 implements OnClickListener {
    final /* synthetic */ BindMobileUI xTx;

    BindMobileUI$2(BindMobileUI bindMobileUI) {
        this.xTx = bindMobileUI;
    }

    public final void onClick(View view) {
        if (BindMobileUI.a(this.xTx).getText().toString() == null || BindMobileUI.a(this.xTx).getText().toString().length() == 0) {
            Toast.makeText(this.xTx, this.xTx.getString(R.l.dKS), 0).show();
            return;
        }
        BindMobileUI.b(this.xTx, BindMobileUI.b(this.xTx).getText().toString().trim() + bh.Dm(BindMobileUI.a(this.xTx).getText().toString()));
        BindMobileUI.c(this.xTx, BindMobileUI.c(this.xTx));
    }
}
