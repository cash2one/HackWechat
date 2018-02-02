package com.tencent.mm.ui.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.account.mobile.MobileInputUI;

class WelcomeSelectView$2 implements OnClickListener {
    final /* synthetic */ Context val$context;
    final /* synthetic */ WelcomeSelectView xST;

    WelcomeSelectView$2(WelcomeSelectView welcomeSelectView, Context context) {
        this.xST = welcomeSelectView;
        this.val$context = context;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.val$context, MobileInputUI.class);
        intent.putExtra("mobile_input_purpose", 1);
        this.val$context.startActivity(intent);
    }
}
