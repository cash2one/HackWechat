package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;

class NormalUserFooterPreference$a$13 implements OnClickListener {
    final /* synthetic */ a pkC;

    NormalUserFooterPreference$a$13(a aVar) {
        this.pkC = aVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("sns_permission_userName", NormalUserFooterPreference.a(this.pkC.pkA).field_username);
        intent.putExtra("sns_permission_anim", true);
        intent.putExtra("sns_permission_block_scene", 4);
        d.b(NormalUserFooterPreference.b(this.pkC.pkA), "sns", ".ui.SnsPermissionUI", intent);
    }
}
