package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.p.d;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;

class k$4 implements d {
    final /* synthetic */ Context val$context;

    public k$4(Context context) {
        this.val$context = context;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(menuItem.getTitle().toString().replace(" ", "").replace("(", "").replace(")", "").replace("-", "")).toString()));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (bh.k(this.val$context, intent)) {
            this.val$context.startActivity(intent);
        }
    }
}
