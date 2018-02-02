package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.pb.common.c.c;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkGroup implements Parcelable {
    public static final Creator<MultiTalkGroup> CREATOR = new Creator<MultiTalkGroup>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroup multiTalkGroup = new MultiTalkGroup();
            multiTalkGroup.zQq = parcel.readString();
            multiTalkGroup.zQr = parcel.readString();
            multiTalkGroup.zQs = parcel.readString();
            multiTalkGroup.zMg = parcel.readInt();
            multiTalkGroup.zQt = parcel.readString();
            int readInt = parcel.readInt();
            multiTalkGroup.zQu = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                MultiTalkGroupMember multiTalkGroupMember = (MultiTalkGroupMember) parcel.readParcelable(MultiTalkGroupMember.class.getClassLoader());
                if (multiTalkGroupMember != null) {
                    multiTalkGroup.zQu.add(multiTalkGroupMember);
                } else {
                    c.d("MultiTalkGroup", new Object[]{"CLTNOT readParcelable member = null"});
                }
            }
            return multiTalkGroup;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroup[i];
        }
    };
    public int zMg;
    public String zQq = "";
    public String zQr = "";
    public String zQs = "";
    public String zQt = "";
    public List<MultiTalkGroupMember> zQu = new ArrayList();

    public String toString() {
        return "MultiTalkGroup [mMultiTalkGroupId=" + this.zQq + ", mMultiTalkClientGroupId=" + this.zQr + ", mWxGroupId=" + this.zQs + ", mRouteId=" + this.zMg + ", mCreatorUsrName=" + this.zQt + ", mMultiTalkGroupMemberList=" + this.zQu + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.zQq == null ? "" : this.zQq);
        parcel.writeString(this.zQr == null ? "" : this.zQr);
        parcel.writeString(this.zQs == null ? "" : this.zQs);
        parcel.writeInt(this.zMg);
        parcel.writeString(this.zQt == null ? "" : this.zQt);
        int size = this.zQu == null ? 0 : this.zQu.size();
        parcel.writeInt(size);
        while (i2 < size) {
            parcel.writeParcelable((MultiTalkGroupMember) this.zQu.get(i2), i);
            i2++;
        }
    }

    public int describeContents() {
        return 0;
    }
}
