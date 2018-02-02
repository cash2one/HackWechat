package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;

public class MultiTalkGroupMemberData implements Parcelable {
    public static final Creator<MultiTalkGroupMemberData> CREATOR = new 1();
    MultiTalkGroupMember oFN;

    public MultiTalkGroupMemberData(MultiTalkGroupMember multiTalkGroupMember) {
        this.oFN = multiTalkGroupMember;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bh.az(this.oFN.zQv, ""));
        parcel.writeString(bh.az(this.oFN.zQw, ""));
        parcel.writeInt(this.oFN.status);
        parcel.writeInt(this.oFN.aAk);
        parcel.writeInt(this.oFN.zPv);
    }
}
