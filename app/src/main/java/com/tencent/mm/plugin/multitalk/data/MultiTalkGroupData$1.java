package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;

class MultiTalkGroupData$1 implements Creator<MultiTalkGroupData> {
    MultiTalkGroupData$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
        multiTalkGroup.zQq = bh.az(parcel.readString(), "");
        multiTalkGroup.zQr = bh.az(parcel.readString(), "");
        multiTalkGroup.zQs = bh.az(parcel.readString(), "");
        multiTalkGroup.zMg = parcel.readInt();
        multiTalkGroup.zQt = bh.az(parcel.readString(), "");
        int readInt = parcel.readInt();
        multiTalkGroup.zQu = new ArrayList();
        for (int i = 0; i < readInt; i++) {
            multiTalkGroup.zQu.add(((MultiTalkGroupMemberData) parcel.readParcelable(MultiTalkGroupMemberData.class.getClassLoader())).oFN);
        }
        return new MultiTalkGroupData(multiTalkGroup);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MultiTalkGroupData[i];
    }
}
