package com.tencent.mm.pluginsdk.ui.preference;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.b.af;
import com.tencent.mm.l.a;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class NormalUserHeaderPreference$3 implements OnClickListener {
    final /* synthetic */ NormalUserHeaderPreference vtY;

    NormalUserHeaderPreference$3(NormalUserHeaderPreference normalUserHeaderPreference) {
        this.vtY = normalUserHeaderPreference;
    }

    public final void onClick(View view) {
        NormalUserHeaderPreference.c(this.vtY);
        Preference preference = this.vtY;
        ar.Hg();
        af WO = c.EY().WO(preference.jLe.field_username);
        if (!(WO == null || ((int) WO.gJd) == 0 || !WO.field_username.equals(preference.jLe.field_username))) {
            preference.jLe = WO;
        }
        if (a.fZ(preference.jLe.field_type)) {
            Intent intent = new Intent();
            intent.setClassName(preference.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
            intent.putExtra("Contact_Scene", preference.qra);
            intent.putExtra("Contact_User", preference.jLe.field_username);
            intent.putExtra("Contact_RoomNickname", preference.fmM.getIntent().getStringExtra("Contact_RoomNickname"));
            ((Activity) preference.mContext).startActivity(intent);
            return;
        }
        intent = new Intent();
        intent.setClassName(preference.mContext, "com.tencent.mm.ui.contact.ModRemarkNameUI");
        intent.putExtra("Contact_Scene", preference.qra);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", preference.jLe.field_username);
        intent.putExtra("Contact_Nick", preference.jLe.field_nickname);
        intent.putExtra("Contact_RemarkName", preference.jLe.field_conRemark);
        ((Activity) preference.mContext).startActivity(intent);
    }
}
