package com.tencent.mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class EmojiGroupInfo$1 implements Creator<EmojiGroupInfo> {
    EmojiGroupInfo$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new EmojiGroupInfo(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new EmojiGroupInfo[i];
    }
}
