package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.support.annotation.Keep;
import com.tencent.mm.bm.d;
import com.tencent.wcdb.database.SQLiteDatabase;

final class AppBrandLaunchErrorActionStartActivity extends AppBrandLaunchErrorAction {
    final String jwI;
    final String jwJ;
    final Intent jwK;

    AppBrandLaunchErrorActionStartActivity(String str, int i, String str2, String str3, Intent intent) {
        super(str, i);
        this.jwI = str2;
        this.jwJ = str3;
        this.jwK = intent;
    }

    @Keep
    AppBrandLaunchErrorActionStartActivity(Parcel parcel) {
        super(parcel);
        this.jwI = parcel.readString();
        this.jwJ = parcel.readString();
        this.jwK = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.jwI);
        parcel.writeString(this.jwJ);
        parcel.writeParcelable(this.jwK, 0);
    }

    final void ca(Context context) {
        Intent intent = this.jwK;
        if (context instanceof Activity) {
            intent.setFlags(intent.getFlags() & -268435457);
        } else {
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        d.b(context, this.jwI, this.jwJ, intent);
    }
}
