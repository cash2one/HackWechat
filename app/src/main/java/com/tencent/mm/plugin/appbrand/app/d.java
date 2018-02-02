package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes$WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.m.e;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class d implements e {
    public final void a(Context context, String str, String str2, List<WxaAttributes$WxaEntryInfo> list) {
        Intent intent = new Intent(context, BizBindWxaInfoUI.class);
        intent.putParcelableArrayListExtra("extra_wxa_entry_info_list", new ArrayList(list));
        intent.putExtra("extra_username", str);
        intent.putExtra("extra_appid", str2);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        context.startActivity(intent);
    }

    public final void w(Context context, int i) {
        Context context2 = context == null ? ac.getContext() : context;
        context2.startActivity(new Intent(context2, AppBrandLauncherUI.class).putExtra("extra_enter_scene", i).addFlags(context instanceof Activity ? 0 : SQLiteDatabase.CREATE_IF_NECESSARY));
    }
}
