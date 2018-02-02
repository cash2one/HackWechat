package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class FMessageConversationUI$4 implements OnClickListener {
    final /* synthetic */ FMessageConversationUI rXh;

    FMessageConversationUI$4(FMessageConversationUI fMessageConversationUI) {
        this.rXh = fMessageConversationUI;
    }

    public final void onClick(View view) {
        ar.Hg();
        if (bh.ov((String) c.CU().get(6, null))) {
            Intent intent = new Intent(this.rXh.mController.xIM, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 5);
            MMWizardActivity.A(this.rXh, intent);
            return;
        }
        this.rXh.startActivity(new Intent(this.rXh, MobileFriendUI.class));
    }
}
