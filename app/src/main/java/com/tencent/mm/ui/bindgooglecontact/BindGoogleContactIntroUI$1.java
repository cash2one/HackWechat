package com.tencent.mm.ui.bindgooglecontact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class BindGoogleContactIntroUI$1 implements OnClickListener {
    final /* synthetic */ BindGoogleContactIntroUI ykv;

    BindGoogleContactIntroUI$1(BindGoogleContactIntroUI bindGoogleContactIntroUI) {
        this.ykv = bindGoogleContactIntroUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.ykv, BindGoogleContactUI.class);
        intent.putExtra("enter_scene", BindGoogleContactIntroUI.a(this.ykv));
        this.ykv.startActivity(intent);
    }
}
