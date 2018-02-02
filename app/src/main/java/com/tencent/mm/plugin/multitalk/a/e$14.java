package com.tencent.mm.plugin.multitalk.a;

import android.content.Intent;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.voip.model.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.wcdb.database.SQLiteDatabase;

class e$14 implements Runnable {
    final /* synthetic */ e oGz;

    e$14(e eVar) {
        this.oGz = eVar;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.putExtra("enterMainUiWxGroupId", this.oGz.oGi != null ? this.oGz.oGi.zQs : "");
        intent.setClass(ac.getContext(), MultiTalkMainUI.class);
        intent.putExtra("enterMainUiSource", 1);
        d.bGk().a(intent, new 1(this));
    }
}
