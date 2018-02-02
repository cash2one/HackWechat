package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mars.smc.IDKey;
import java.util.ArrayList;

class GroupIDKeyDataInfo implements Parcelable {
    public static final Creator<GroupIDKeyDataInfo> CREATOR = new Creator<GroupIDKeyDataInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GroupIDKeyDataInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GroupIDKeyDataInfo[i];
        }
    };
    ArrayList<IDKey> pQg = new ArrayList();
    public boolean pQh;

    GroupIDKeyDataInfo(ArrayList<IDKey> arrayList, boolean z) {
        this.pQg = arrayList;
        this.pQh = false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.pQg);
        parcel.writeInt(this.pQh ? 1 : 0);
    }

    protected GroupIDKeyDataInfo(Parcel parcel) {
        boolean z = true;
        parcel.readTypedList(this.pQg, IDKey.CREATOR);
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.pQh = z;
    }
}
