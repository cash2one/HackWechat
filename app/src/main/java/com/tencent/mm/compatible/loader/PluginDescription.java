package com.tencent.mm.compatible.loader;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.compatible.util.m;
import java.io.Serializable;

public class PluginDescription implements Parcelable, Serializable {
    public static final Creator<PluginDescription> CREATOR = new 1();
    public final String fqR;
    public final int gGQ;
    public final String name;
    public final int size;
    public final String url;
    public final String version;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.url);
        parcel.writeString(this.fqR);
        parcel.writeString(this.version);
        parcel.writeInt(this.size);
        parcel.writeInt(this.gGQ);
    }

    protected PluginDescription(Parcel parcel) {
        this.name = (String) m.Y(parcel.readString());
        this.url = (String) m.Y(parcel.readString());
        this.fqR = (String) m.Y(parcel.readString());
        this.version = (String) m.Y(parcel.readString());
        this.size = parcel.readInt();
        this.gGQ = parcel.readInt();
    }

    public String toString() {
        return String.format("PluginDescription = [name=%s, url=%s, md5=%s, version=%s, size=%d, downloadType=%d]", new Object[]{this.name, this.url, this.fqR, this.version, Integer.valueOf(this.size), Integer.valueOf(this.gGQ)});
    }
}
