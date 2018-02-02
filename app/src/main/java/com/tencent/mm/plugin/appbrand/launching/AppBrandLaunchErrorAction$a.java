package com.tencent.mm.plugin.appbrand.launching;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;

final class AppBrandLaunchErrorAction$a implements Creator<AppBrandLaunchErrorAction> {
    AppBrandLaunchErrorAction$a() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return i(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AppBrandLaunchErrorAction[i];
    }

    private static AppBrandLaunchErrorAction i(Parcel parcel) {
        String readString = parcel.readString();
        if (readString == null) {
            return null;
        }
        try {
            return (AppBrandLaunchErrorAction) Class.forName(readString).getDeclaredConstructor(new Class[]{Parcel.class}).newInstance(new Object[]{parcel});
        } catch (Exception e) {
            return null;
        }
    }

    static AppBrandLaunchErrorAction a(String str, int i, u uVar) {
        if (uVar == null || uVar.field_launchAction == null) {
            return null;
        }
        switch (uVar.field_launchAction.vEe) {
            case 2:
                Intent intent = new Intent();
                intent.putExtra("rawUrl", uVar.field_launchAction.wuL);
                intent.putExtra("forceHideShare", true);
                return new AppBrandLaunchErrorActionStartActivity(str, i, "webview", ".ui.tools.WebViewUI", intent);
            case 3:
                return new AppBrandLaunchErrorActionAlert(str, i, uVar.field_launchAction.wpn, uVar.field_launchAction.wuN);
            default:
                return null;
        }
    }
}
