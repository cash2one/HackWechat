package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class CommentFrame$1 implements Creator<CommentFrame> {
    CommentFrame$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new CommentFrame(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new CommentFrame[i];
    }
}
