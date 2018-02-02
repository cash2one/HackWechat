package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.b;
import com.tencent.mm.ui.e;

class NormalUserFooterPreference$b$2 implements OnClickListener {
    final /* synthetic */ b pkL;

    NormalUserFooterPreference$b$2(b bVar) {
        this.pkL = bVar;
    }

    public final void onClick(View view) {
        if (this.pkL.pkA.pki && a.bXU()) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", this.pkL.pkA.jLe.field_encryptUsername);
            intent.putExtra("lbs_mode", true);
            intent.putExtra("lbs_ticket", this.pkL.pkA.kvB);
            intent.putExtra("add_scene", this.pkL.pkA.phF);
            com.tencent.mm.plugin.profile.a.ifs.e(intent, this.pkL.pkA.fmM);
            return;
        }
        intent = new Intent();
        intent.putExtra("Contact_User", this.pkL.pkA.jLe.field_username);
        intent.putExtra("Contact_Scene", this.pkL.pkA.phF);
        intent.putExtra(e.a.xEi, this.pkL.pkA.jLe.fWF);
        com.tencent.mm.plugin.profile.a.ifs.a(intent, this.pkL.pkA.mContext);
    }
}
