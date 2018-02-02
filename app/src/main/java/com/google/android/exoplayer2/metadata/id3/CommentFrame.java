package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.t;

public final class CommentFrame extends Id3Frame {
    public static final Creator<CommentFrame> CREATOR = new 1();
    public final String ael;
    public final String description;
    public final String text;

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.ael = str;
        this.description = str2;
        this.text = str3;
    }

    CommentFrame(Parcel parcel) {
        super("COMM");
        this.ael = parcel.readString();
        this.description = parcel.readString();
        this.text = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CommentFrame commentFrame = (CommentFrame) obj;
        if (t.h(this.description, commentFrame.description) && t.h(this.ael, commentFrame.ael) && t.h(this.text, commentFrame.text)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        if (this.ael != null) {
            hashCode = this.ael.hashCode();
        } else {
            hashCode = 0;
        }
        int i2 = (hashCode + 527) * 31;
        if (this.description != null) {
            hashCode = this.description.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + i2) * 31;
        if (this.text != null) {
            i = this.text.hashCode();
        }
        return hashCode + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.ael);
        parcel.writeString(this.text);
    }
}
