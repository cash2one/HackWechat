package com.tencent.mm.plugin.multitalk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;

public class MultiTalkGroupData implements Parcelable {
    public static final Creator<MultiTalkGroupData> CREATOR = new 1();
    private MultiTalkGroup oFM;

    public MultiTalkGroupData(MultiTalkGroup multiTalkGroup) {
        this.oFM = multiTalkGroup;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bh.az(this.oFM.zQq, ""));
        parcel.writeString(bh.az(this.oFM.zQr, ""));
        parcel.writeString(bh.az(this.oFM.zQs, ""));
        parcel.writeInt(this.oFM.zMg);
        parcel.writeString(bh.az(this.oFM.zQt, ""));
        parcel.writeInt(this.oFM.zQu.size());
        for (int i2 = 0; i2 < this.oFM.zQu.size(); i2++) {
            parcel.writeParcelable(new MultiTalkGroupMemberData((MultiTalkGroupMember) this.oFM.zQu.get(i2)), i);
        }
    }
}
