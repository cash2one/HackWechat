package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.launching.precondition.ClientLaunchEntry.1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandInToolsUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.wcdb.database.SQLiteDatabase;

final class c extends a {
    c() {
    }

    protected final boolean a(Context context, LaunchParcel launchParcel) {
        boolean z = false;
        Intent intent = new Intent(context, AppBrandLaunchProxyUI.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        intent.putExtra("extra_from_mm", false);
        intent.putExtra("extra_launch_parcel", launchParcel);
        intent.putExtra("extra_launch_source_context", context.getClass().getName());
        if ((context instanceof AppBrandUI) && !(context instanceof AppBrandPluginUI) && !(context instanceof AppBrandInToolsUI) && ((launchParcel.iNZ == null || launchParcel.iNZ.iOd != 1) && launchParcel.jyP.scene != 1085)) {
            z = true;
        }
        if (z) {
            intent.putExtra("extra_result_receiver", new 1(this, new Handler(Looper.getMainLooper()), context));
        }
        context.startActivity(intent);
        return true;
    }
}
