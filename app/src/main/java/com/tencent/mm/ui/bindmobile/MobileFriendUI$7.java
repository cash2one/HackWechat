package com.tencent.mm.ui.bindmobile;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.MMWizardActivity;

class MobileFriendUI$7 implements OnClickListener {
    final /* synthetic */ MobileFriendUI ymF;

    MobileFriendUI$7(MobileFriendUI mobileFriendUI) {
        this.ymF = mobileFriendUI;
    }

    public final void onClick(View view) {
        MMWizardActivity.A(this.ymF, new Intent(this.ymF, BindMContactIntroUI.class));
    }
}
