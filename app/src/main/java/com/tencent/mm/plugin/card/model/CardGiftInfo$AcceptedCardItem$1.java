package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.card.model.CardGiftInfo.AcceptedCardItem;

class CardGiftInfo$AcceptedCardItem$1 implements Creator<AcceptedCardItem> {
    CardGiftInfo$AcceptedCardItem$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AcceptedCardItem(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AcceptedCardItem[i];
    }
}
