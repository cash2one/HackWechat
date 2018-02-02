package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.tencent.mm.pluginsdk.model.v.a;

public abstract class u {
    public abstract boolean Rq(String str);

    public abstract String Wg();

    public abstract String bYk();

    public abstract a bYl();

    public abstract boolean ec(Context context);

    public boolean w(Context context, Intent intent) {
        return false;
    }

    public String a(Context context, ResolveInfo resolveInfo) {
        return resolveInfo.activityInfo.loadLabel(context.getPackageManager()).toString();
    }
}
