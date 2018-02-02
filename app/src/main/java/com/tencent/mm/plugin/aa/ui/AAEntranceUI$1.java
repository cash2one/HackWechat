package com.tencent.mm.plugin.aa.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.z.q;

class AAEntranceUI$1 implements OnClickListener {
    final /* synthetic */ AAEntranceUI ihP;

    AAEntranceUI$1(AAEntranceUI aAEntranceUI) {
        this.ihP = aAEntranceUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("key_from_scene", 1);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", false);
        intent.putExtra("mutil_select_is_ret", false);
        intent.putExtra("Select_block_List", q.FS());
        intent.putExtra("recent_remittance_contact_list", h.WJ());
        d.b(this.ihP.mController.xIM, "remittance", ".ui.SelectRemittanceContactUI", intent, 1);
    }
}
