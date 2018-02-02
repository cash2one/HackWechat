package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.SnsMsgUI.a;

class SnsMsgUI$a$3 implements OnClickListener {
    final /* synthetic */ String hpU;
    final /* synthetic */ a rDJ;

    SnsMsgUI$a$3(a aVar, String str) {
        this.rDJ = aVar;
        this.hpU = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("Contact_User", this.hpU);
        com.tencent.mm.plugin.sns.c.a.ifs.d(intent, this.rDJ.rDE);
    }
}
