package com.tencent.mm.ui.chatting;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class QQMailHistoryExporter$ImageSpanData implements Parcelable {
    public static final Creator<QQMailHistoryExporter$ImageSpanData> CREATOR = new Creator<QQMailHistoryExporter$ImageSpanData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            QQMailHistoryExporter$ImageSpanData qQMailHistoryExporter$ImageSpanData = new QQMailHistoryExporter$ImageSpanData();
            qQMailHistoryExporter$ImageSpanData.hlq = parcel.readInt();
            qQMailHistoryExporter$ImageSpanData.endPos = parcel.readInt();
            qQMailHistoryExporter$ImageSpanData.path = parcel.readString();
            qQMailHistoryExporter$ImageSpanData.thumbnail = parcel.readInt();
            return qQMailHistoryExporter$ImageSpanData;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new QQMailHistoryExporter$ImageSpanData[i];
        }
    };
    int endPos;
    int hlq;
    String path;
    private int thumbnail = 0;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.hlq);
        parcel.writeInt(this.endPos);
        parcel.writeString(this.path);
        parcel.writeInt(this.thumbnail);
    }
}
