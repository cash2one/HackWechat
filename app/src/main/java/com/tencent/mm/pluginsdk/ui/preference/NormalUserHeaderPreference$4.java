package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;

class NormalUserHeaderPreference$4 implements OnClickListener {
    final /* synthetic */ NormalUserHeaderPreference vtY;

    NormalUserHeaderPreference$4(NormalUserHeaderPreference normalUserHeaderPreference) {
        this.vtY = normalUserHeaderPreference;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("sns_permission_userName", NormalUserHeaderPreference.b(this.vtY).field_username);
        intent.putExtra("sns_permission_anim", true);
        intent.putExtra("sns_permission_block_scene", 3);
        d.b(NormalUserHeaderPreference.a(this.vtY), "sns", ".ui.SnsPermissionUI", intent);
    }
}
