package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;

class AddrEditView$4 implements OnClickListener {
    final /* synthetic */ AddrEditView ine;

    AddrEditView$4(AddrEditView addrEditView) {
        this.ine = addrEditView;
    }

    public final void onClick(View view) {
        if (AddrEditView.f(this.ine).getVisibility() != 0) {
            return;
        }
        if (this.ine.imW && AddrEditView.d(this.ine) != 2 && !bh.ov(this.ine.getText())) {
            this.ine.imQ.setText("");
            AddrEditView.b(this.ine, AddrEditView.e(this.ine).isFocused());
        } else if (AddrEditView.g(this.ine) != null) {
            AddrEditView.g(this.ine).onClick();
        }
    }
}
