package com.tencent.c.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.c.e.a.a.a;

public final class i {
    public static a bF(Context context, String str) {
        a aVar = new a();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            aVar.ffw = str;
            aVar.versionName = packageInfo.versionName;
            aVar.versionCode = packageInfo.versionCode;
        } catch (Throwable th) {
        }
        return aVar;
    }
}
