package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.l.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements OnClickListener {
    final /* synthetic */ k pjC;

    k$1(k kVar) {
        this.pjC = kVar;
    }

    public final void onClick(View view) {
        k kVar = this.pjC;
        if (kVar.jLe == null) {
            x.e("MicroMsg.ContactWidgetNormal", "contact is null");
        } else if (a.fZ(kVar.jLe.field_type)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_Scene", kVar.phF);
            intent.putExtra("Contact_User", kVar.jLe.field_username);
            intent.putExtra("Contact_RoomNickname", kVar.fAF.getIntent().getStringExtra("Contact_RoomNickname"));
            intent.putExtra("view_mode", true);
            intent.putExtra("contact_phone_number_by_md5", kVar.pjA);
            intent.putExtra("contact_phone_number_list", kVar.jLe.fWE);
            com.tencent.mm.plugin.profile.a.ifs.p(intent, kVar.fAF);
        } else if (bh.ov(kVar.jLe.field_encryptUsername)) {
            kVar.HA(kVar.jLe.field_username);
        } else {
            kVar.HA(kVar.jLe.field_encryptUsername);
        }
    }
}
