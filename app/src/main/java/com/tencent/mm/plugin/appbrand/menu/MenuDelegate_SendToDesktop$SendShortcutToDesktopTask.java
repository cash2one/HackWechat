package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

class MenuDelegate_SendToDesktop$SendShortcutToDesktopTask extends MainProcessTask {
    public static final Creator<MenuDelegate_SendToDesktop$SendShortcutToDesktopTask> CREATOR = new 2();
    private int fvM;
    private boolean jAB;
    private String mAppId;
    private Context mContext;
    private String username;

    public MenuDelegate_SendToDesktop$SendShortcutToDesktopTask(Context context, String str, String str2, int i) {
        this.mContext = context;
        this.username = str;
        this.mAppId = str2;
        this.fvM = i;
    }

    public MenuDelegate_SendToDesktop$SendShortcutToDesktopTask(Parcel parcel) {
        f(parcel);
    }

    public final void Yr() {
        Context context = ac.getContext();
        String str = this.username;
        int i = this.fvM;
        if (context == null || str == null) {
            x.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
        } else {
            b bqVar = new bq();
            bqVar.fpJ.username = str;
            a.xef.m(bqVar);
            if (bqVar.fpK.fpM == null) {
                x.e("MicroMsg.AppBrandShortcutManager", "no such user");
            } else {
                Intent a = k.a(context, bqVar, i, k.a(context, k.a(bqVar), i), false);
                if (a == null) {
                    x.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
                } else {
                    com.tencent.mm.plugin.base.model.b.p(context, a);
                    x.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", new Object[]{str});
                }
            }
        }
        ag.h(new 1(this, context), 1000);
    }

    public final void Ys() {
        if (this.mContext != null && this.jAB) {
            AppBrandSysConfig oS = com.tencent.mm.plugin.appbrand.a.oS(this.mAppId);
            if (oS != null) {
                SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(this.mContext, "pref_appbrand_" + oS.uin, 4);
                if (!sharedPreferences.contains("has_show_send_to_desktop_tips")) {
                    if (com.tencent.mm.plugin.appbrand.a.oQ(this.mAppId) != null) {
                        Context context = this.mContext;
                        h.b(context, context.getString(j.iyY), context.getString(j.dGO), false);
                    }
                    sharedPreferences.edit().putBoolean("has_show_send_to_desktop_tips", true).commit();
                }
            }
        }
    }

    public final void f(Parcel parcel) {
        this.username = parcel.readString();
        this.fvM = parcel.readInt();
        this.jAB = parcel.readInt() != 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.username);
        parcel.writeInt(this.fvM);
        parcel.writeInt(this.jAB ? 1 : 0);
    }
}
