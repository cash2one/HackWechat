package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.j;

class NormalUserFooterPreference$j$1 implements OnClickListener {
    final /* synthetic */ j pkU;

    NormalUserFooterPreference$j$1(j jVar) {
        this.pkU = jVar;
    }

    public final void onClick(View view) {
        NormalUserFooterPreference.b(this.pkU.pkA).getIntent().removeExtra("Accept_NewFriend_FromOutside");
        Intent intent = new Intent(NormalUserFooterPreference.b(this.pkU.pkA), SayHiWithSnsPermissionUI.class);
        intent.putExtra("Contact_User", NormalUserFooterPreference.a(this.pkU.pkA).field_username);
        intent.putExtra("Contact_Nick", NormalUserFooterPreference.a(this.pkU.pkA).field_nickname);
        intent.putExtra("Contact_RemarkName", NormalUserFooterPreference.a(this.pkU.pkA).field_conRemark);
        if (NormalUserFooterPreference.l(this.pkU.pkA) == 14 || NormalUserFooterPreference.l(this.pkU.pkA) == 8) {
            intent.putExtra("Contact_RoomNickname", NormalUserFooterPreference.b(this.pkU.pkA).getIntent().getStringExtra("Contact_RoomNickname"));
        }
        intent.putExtra("Contact_Scene", NormalUserFooterPreference.l(this.pkU.pkA));
        intent.putExtra("Verify_ticket", NormalUserFooterPreference.x(this.pkU.pkA));
        intent.putExtra("sayhi_with_sns_perm_send_verify", false);
        intent.putExtra("sayhi_with_sns_perm_add_remark", true);
        intent.putExtra("sayhi_with_sns_perm_set_label", true);
        NormalUserFooterPreference.b(this.pkU.pkA).startActivity(intent);
    }
}
