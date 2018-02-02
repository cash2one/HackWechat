package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.model.GameTabData.TabItem;

class GameTabData$TabItem$1 implements Creator<TabItem> {
    GameTabData$TabItem$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new TabItem(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new TabItem[i];
    }
}
