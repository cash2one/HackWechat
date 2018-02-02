package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.wcdb.database.SQLiteDatabase;

class AppBrand404PageUI$1 implements Runnable {
    final /* synthetic */ String jKh = null;
    final /* synthetic */ String jha;

    AppBrand404PageUI$1(String str, String str2) {
        this.jha = str;
    }

    public final void run() {
        ac.getContext().startActivity(new Intent(ac.getContext(), AppBrand404PageUI.class).putExtra("key_wording", this.jha).putExtra("key_icon_url", this.jKh).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
    }
}
