package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

class BroadCastData implements Parcelable {
    public static final Creator<BroadCastData> CREATOR = new Creator<BroadCastData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BroadCastData(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BroadCastData[i];
        }
    };
    ArrayList<KVReportDataInfo> pQd = new ArrayList();
    ArrayList<StIDKeyDataInfo> pQe = new ArrayList();
    ArrayList<GroupIDKeyDataInfo> pQf = new ArrayList();

    public BroadCastData(BroadCastData broadCastData) {
        if (broadCastData != null) {
            this.pQd = new ArrayList(broadCastData.pQd);
            this.pQe = new ArrayList(broadCastData.pQe);
            this.pQf = new ArrayList(broadCastData.pQf);
        }
    }

    protected BroadCastData(Parcel parcel) {
        parcel.readTypedList(this.pQd, KVReportDataInfo.CREATOR);
        parcel.readTypedList(this.pQe, StIDKeyDataInfo.CREATOR);
        parcel.readTypedList(this.pQf, GroupIDKeyDataInfo.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.pQd);
        parcel.writeTypedList(this.pQe);
        parcel.writeTypedList(this.pQf);
    }
}
