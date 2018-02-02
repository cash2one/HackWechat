package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;

class FMessageConversationUI$6 implements OnItemClickListener {
    final /* synthetic */ FMessageConversationUI rXh;

    FMessageConversationUI$6(FMessageConversationUI fMessageConversationUI) {
        this.rXh = fMessageConversationUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i != 0) {
            return;
        }
        if (m.NN() != a.hwi) {
            Intent intent = new Intent(this.rXh.mController.xIM, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 5);
            MMWizardActivity.A(this.rXh.mController.xIM, intent);
            return;
        }
        this.rXh.startActivity(new Intent(this.rXh.mController.xIM, MobileFriendUI.class));
    }
}
