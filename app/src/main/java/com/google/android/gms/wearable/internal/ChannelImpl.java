package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.Channel;

public class ChannelImpl implements SafeParcelable, Channel {
    public static final Creator<ChannelImpl> CREATOR = new bb();
    final String bdo;
    final String ben;
    final String beo;
    final int mVersionCode;

    ChannelImpl(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.ben = (String) w.ag(str);
        this.bdo = (String) w.ag(str2);
        this.beo = (String) w.ag(str3);
    }

    public final e<Status> a(c cVar, Uri uri) {
        w.i(cVar, "client is null");
        w.i(uri, "uri is null");
        return cVar.b(new 1(this, cVar, uri, false));
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) obj;
        return this.ben.equals(channelImpl.ben) && v.b(channelImpl.bdo, this.bdo) && v.b(channelImpl.beo, this.beo) && channelImpl.mVersionCode == this.mVersionCode;
    }

    public final String getPath() {
        return this.beo;
    }

    public int hashCode() {
        return this.ben.hashCode();
    }

    public final String ro() {
        return this.bdo;
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.ben + '\'' + ", nodeId='" + this.bdo + '\'' + ", path='" + this.beo + '\'' + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        bb.a(this, parcel);
    }
}
