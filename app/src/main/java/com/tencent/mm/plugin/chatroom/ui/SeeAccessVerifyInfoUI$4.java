package com.tencent.mm.plugin.chatroom.ui;

import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;

class SeeAccessVerifyInfoUI$4 implements Runnable {
    final /* synthetic */ SeeAccessVerifyInfoUI lcQ;

    SeeAccessVerifyInfoUI$4(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI) {
        this.lcQ = seeAccessVerifyInfoUI;
    }

    public final void run() {
        int i = 0;
        if (SeeAccessVerifyInfoUI.d(this.lcQ) != null) {
            i = (int) ((((float) SeeAccessVerifyInfoUI.d(this.lcQ).getHeight()) + this.lcQ.getResources().getDimension(R.f.bur)) + this.lcQ.getResources().getDimension(R.f.bvD));
        }
        if (SeeAccessVerifyInfoUI.e(this.lcQ).getCount() / 4 > 0) {
            i *= (SeeAccessVerifyInfoUI.e(this.lcQ).getCount() / 4) + 1;
        }
        SeeAccessVerifyInfoUI.f(this.lcQ).setLayoutParams(new LayoutParams(SeeAccessVerifyInfoUI.f(this.lcQ).getWidth(), i));
    }
}
