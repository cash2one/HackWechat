package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class ShakeReportUI$9 implements OnClickListener {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$9(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(this.qsi, ShakeMsgListUI.class);
        intent.putExtra("shake_msg_from", 1);
        intent.putExtra("shake_msg_list_title", this.qsi.getString(R.l.ePc));
        this.qsi.startActivity(intent);
    }
}
