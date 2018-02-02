package com.tencent.mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class EmojiInfo$1 implements Creator<EmojiInfo> {
    EmojiInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new EmojiInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new EmojiInfo[i];
    }
}
