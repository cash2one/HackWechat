package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.c;
import com.tencent.mm.pluginsdk.ui.applet.a.b;

class NormalUserFooterPreference$c$4 implements b {
    final /* synthetic */ c pkM;
    final /* synthetic */ String pkN;
    final /* synthetic */ String pkO;

    NormalUserFooterPreference$c$4(c cVar, String str, String str2) {
        this.pkM = cVar;
        this.pkN = str;
        this.pkO = str2;
    }

    public final boolean aUF() {
        String stringExtra = this.pkM.pkA.fmM.getIntent().getStringExtra("room_name");
        Intent intent = new Intent(this.pkM.pkA.fmM, SayHiWithSnsPermissionUI.class);
        intent.putExtra("Contact_User", this.pkM.pkA.jLe.field_username);
        intent.putExtra("Contact_Nick", this.pkM.pkA.jLe.field_nickname);
        intent.putExtra("Contact_RemarkName", this.pkM.pkA.jLe.field_conRemark);
        if (this.pkM.pkA.phF == 14 || this.pkM.pkA.phF == 8) {
            intent.putExtra("Contact_RoomNickname", this.pkM.pkA.fmM.getIntent().getStringExtra("Contact_RoomNickname"));
        }
        intent.putExtra("Contact_Scene", this.pkM.pkA.phF);
        intent.putExtra("room_name", stringExtra);
        intent.putExtra("source_from_user_name", this.pkN);
        intent.putExtra("source_from_nick_name", this.pkO);
        intent.putExtra("sayhi_with_sns_perm_send_verify", true);
        intent.putExtra("sayhi_with_sns_perm_add_remark", true);
        intent.putExtra("sayhi_with_sns_perm_set_label", false);
        this.pkM.pkA.fmM.startActivity(intent);
        return true;
    }
}
