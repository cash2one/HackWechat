package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;

public final class ChapterTocFrame extends Id3Frame {
    public static final Creator<ChapterTocFrame> CREATOR = new Creator<ChapterTocFrame>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ChapterTocFrame[i];
        }
    };
    private final Id3Frame[] aqJ;
    public final String aqK;
    public final boolean aqL;
    public final boolean aqM;
    public final String[] aqN;

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.aqK = str;
        this.aqL = z;
        this.aqM = z2;
        this.aqN = strArr;
        this.aqJ = id3FrameArr;
    }

    ChapterTocFrame(Parcel parcel) {
        boolean z = true;
        int i = 0;
        super("CTOC");
        this.aqK = parcel.readString();
        this.aqL = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.aqM = z;
        this.aqN = parcel.createStringArray();
        int readInt = parcel.readInt();
        this.aqJ = new Id3Frame[readInt];
        while (i < readInt) {
            this.aqJ[i] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
        if (this.aqL == chapterTocFrame.aqL && this.aqM == chapterTocFrame.aqM && t.h(this.aqK, chapterTocFrame.aqK) && Arrays.equals(this.aqN, chapterTocFrame.aqN) && Arrays.equals(this.aqJ, chapterTocFrame.aqJ)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2 = 1;
        int i3 = 0;
        if (this.aqL) {
            i = 1;
        } else {
            i = 0;
        }
        i = (i + 527) * 31;
        if (!this.aqM) {
            i2 = 0;
        }
        i = (i + i2) * 31;
        if (this.aqK != null) {
            i3 = this.aqK.hashCode();
        }
        return i + i3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.aqK);
        if (this.aqL) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.aqM) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeStringArray(this.aqN);
        parcel.writeInt(this.aqJ.length);
        for (Parcelable writeParcelable : this.aqJ) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
