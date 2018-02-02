package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;

class MultiTalkGroupMemberData$1 implements Creator<MultiTalkGroupMemberData> {
    MultiTalkGroupMemberData$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
        multiTalkGroupMember.zQv = bh.az(parcel.readString(), "");
        multiTalkGroupMember.zQw = bh.az(parcel.readString(), "");
        multiTalkGroupMember.status = parcel.readInt();
        multiTalkGroupMember.aAk = parcel.readInt();
        multiTalkGroupMember.zPv = parcel.readInt();
        return new MultiTalkGroupMemberData(multiTalkGroupMember);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new MultiTalkGroupMemberData[i];
    }
}
