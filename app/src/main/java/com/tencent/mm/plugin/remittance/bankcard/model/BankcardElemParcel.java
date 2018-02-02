package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.ez;
import com.tencent.mm.protocal.c.sw;
import java.util.ArrayList;
import java.util.Iterator;

public class BankcardElemParcel implements Parcelable {
    public static final Creator<BankcardElemParcel> CREATOR = new 1();
    public String nBM;
    public String oZz;
    public String pHq;
    public int pHr;
    public int pHs;
    public String pHt;
    public String pHu;
    public String pHv;
    public ArrayList<EnterTimeParcel> pHw;

    public BankcardElemParcel(ez ezVar) {
        this.oZz = ezVar.oZz;
        this.nBM = ezVar.nBM;
        this.pHq = ezVar.pHq;
        this.pHr = ezVar.pHr;
        this.pHs = ezVar.pHs;
        this.pHt = ezVar.pHt;
        this.pHu = ezVar.pHu;
        this.pHv = ezVar.pHv;
        this.pHw = new ArrayList();
        Iterator it = ezVar.vKM.iterator();
        while (it.hasNext()) {
            this.pHw.add(new EnterTimeParcel((sw) it.next()));
        }
    }

    public BankcardElemParcel(Parcel parcel) {
        this.oZz = parcel.readString();
        this.nBM = parcel.readString();
        this.pHq = parcel.readString();
        this.pHr = parcel.readInt();
        this.pHs = parcel.readInt();
        this.pHw = new ArrayList();
        parcel.readTypedList(this.pHw, EnterTimeParcel.CREATOR);
        this.pHt = parcel.readString();
        this.pHu = parcel.readString();
        this.pHv = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.oZz);
        parcel.writeString(this.nBM);
        parcel.writeString(this.pHq);
        parcel.writeInt(this.pHr);
        parcel.writeInt(this.pHs);
        parcel.writeTypedList(this.pHw);
        parcel.writeString(this.pHt);
        parcel.writeString(this.pHu);
        parcel.writeString(this.pHv);
    }

    public int describeContents() {
        return 0;
    }
}
