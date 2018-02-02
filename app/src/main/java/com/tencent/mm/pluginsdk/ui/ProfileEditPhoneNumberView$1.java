package com.tencent.mm.pluginsdk.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ProfileEditPhoneNumberView$1 implements OnClickListener {
    final /* synthetic */ MMPhoneNumberEditText vkO;
    final /* synthetic */ ProfileEditPhoneNumberView vkP;

    ProfileEditPhoneNumberView$1(ProfileEditPhoneNumberView profileEditPhoneNumberView, MMPhoneNumberEditText mMPhoneNumberEditText) {
        this.vkP = profileEditPhoneNumberView;
        this.vkO = mMPhoneNumberEditText;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.vkP.vkI = "";
        this.vkP.vkN.cap();
        ProfileEditPhoneNumberView.a(this.vkP, this.vkO);
        if (!ProfileEditPhoneNumberView.a(this.vkP)) {
            ProfileEditPhoneNumberView.b(this.vkP);
        }
    }
}
