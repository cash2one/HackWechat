package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sport.b.d;

class ExdeviceRankInfoUI$6 implements OnClickListener {
    final /* synthetic */ ExdeviceRankInfoUI lXj;

    ExdeviceRankInfoUI$6(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.lXj = exdeviceRankInfoUI;
    }

    public final void onClick(View view) {
        d.pY(24);
        Intent intent = new Intent();
        intent.putExtra("Select_Talker_Name", "gh_43f2581f6fd6");
        intent.putExtra("Select_block_List", "gh_43f2581f6fd6");
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Select_Send_Card", true);
        com.tencent.mm.bm.d.a(this.lXj, ".ui.transmit.SelectConversationUI", intent, 3);
    }
}
