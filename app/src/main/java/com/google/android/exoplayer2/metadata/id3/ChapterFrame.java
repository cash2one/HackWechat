package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;

public final class ChapterFrame extends Id3Frame {
    public static final Creator<ChapterFrame> CREATOR = new 1();
    public final String aqE;
    public final int aqF;
    public final int aqG;
    public final long aqH;
    public final long aqI;
    private final Id3Frame[] aqJ;

    public ChapterFrame(String str, int i, int i2, long j, long j2, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.aqE = str;
        this.aqF = i;
        this.aqG = i2;
        this.aqH = j;
        this.aqI = j2;
        this.aqJ = id3FrameArr;
    }

    ChapterFrame(Parcel parcel) {
        super("CHAP");
        this.aqE = parcel.readString();
        this.aqF = parcel.readInt();
        this.aqG = parcel.readInt();
        this.aqH = parcel.readLong();
        this.aqI = parcel.readLong();
        int readInt = parcel.readInt();
        this.aqJ = new Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.aqJ[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChapterFrame chapterFrame = (ChapterFrame) obj;
        if (this.aqF == chapterFrame.aqF && this.aqG == chapterFrame.aqG && this.aqH == chapterFrame.aqH && this.aqI == chapterFrame.aqI && t.h(this.aqE, chapterFrame.aqE) && Arrays.equals(this.aqJ, chapterFrame.aqJ)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.aqE != null ? this.aqE.hashCode() : 0) + ((((((((this.aqF + 527) * 31) + this.aqG) * 31) + ((int) this.aqH)) * 31) + ((int) this.aqI)) * 31);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.aqE);
        parcel.writeInt(this.aqF);
        parcel.writeInt(this.aqG);
        parcel.writeLong(this.aqH);
        parcel.writeLong(this.aqI);
        parcel.writeInt(this.aqJ.length);
        for (Parcelable writeParcelable : this.aqJ) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public final int describeContents() {
        return 0;
    }
}
