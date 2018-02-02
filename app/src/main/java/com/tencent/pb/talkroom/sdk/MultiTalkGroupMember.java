package com.tencent.pb.talkroom.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MultiTalkGroupMember implements Parcelable {
    public static final Creator<MultiTalkGroupMember> CREATOR = new Creator<MultiTalkGroupMember>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            MultiTalkGroupMember multiTalkGroupMember = new MultiTalkGroupMember();
            multiTalkGroupMember.zQv = parcel.readString();
            multiTalkGroupMember.zQw = parcel.readString();
            multiTalkGroupMember.status = parcel.readInt();
            multiTalkGroupMember.aAk = parcel.readInt();
            multiTalkGroupMember.zPv = parcel.readInt();
            return multiTalkGroupMember;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MultiTalkGroupMember[i];
        }
    };
    public int aAk;
    public int status;
    public int zPv;
    public String zQv = "";
    public String zQw = "";

    public String toString() {
        return "MultiTalkGroupMember [usrName=" + this.zQv + ", inviteUsrName=" + this.zQw + ", status=" + this.status + ", reason=" + this.aAk + ", inviteTime=" + this.zPv + "]";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zQv == null ? "" : this.zQv);
        parcel.writeString(this.zQw == null ? "" : this.zQw);
        parcel.writeInt(this.status);
        parcel.writeInt(this.aAk);
        parcel.writeInt(this.zPv);
    }
}
