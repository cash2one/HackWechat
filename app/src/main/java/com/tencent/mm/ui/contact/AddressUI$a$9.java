package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.contact.AddressUI.a;

class AddressUI$a$9 implements Runnable {
    final /* synthetic */ a yQF;

    AddressUI$a$9(a aVar) {
        this.yQF = aVar;
    }

    public final void run() {
        x.i("MicroMsg.AddressUI", "post to first init finish");
        View findViewById = this.yQF.findViewById(R.h.ctC);
        if (findViewById != null) {
            findViewById.setVisibility(8);
            findViewById.startAnimation(AnimationUtils.loadAnimation(this.yQF.getContext(), R.a.bqa));
        }
    }
}
