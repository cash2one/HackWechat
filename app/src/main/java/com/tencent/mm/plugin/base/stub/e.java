package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class e {
    static /* synthetic */ void l(Activity activity) {
        Intent intent = new Intent();
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClassName(ac.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
        intent.putExtra("showShare", false);
        ac.getContext().startActivity(intent);
        if (activity != null) {
            activity.finish();
        }
    }
}
