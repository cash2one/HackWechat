package com.tencent.mm.plugin.remittance.bankcard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.bom;
import java.util.ArrayList;
import java.util.List;

public class TransferRecordParcel implements Parcelable {
    public static final Creator<TransferRecordParcel> CREATOR = new 1();
    public String nBM;
    public String oZz;
    public String pHK;
    public String pHL;
    public String pHM;
    public String pHN;
    public String pHq;

    private TransferRecordParcel(bom com_tencent_mm_protocal_c_bom) {
        this.pHK = com_tencent_mm_protocal_c_bom.pHK;
        this.pHL = com_tencent_mm_protocal_c_bom.pHL;
        this.pHq = com_tencent_mm_protocal_c_bom.pHq;
        this.nBM = com_tencent_mm_protocal_c_bom.nBM;
        this.oZz = com_tencent_mm_protocal_c_bom.oZz;
        this.pHM = com_tencent_mm_protocal_c_bom.pHM;
        this.pHN = com_tencent_mm_protocal_c_bom.pHN;
    }

    protected TransferRecordParcel(Parcel parcel) {
        this.pHK = parcel.readString();
        this.pHL = parcel.readString();
        this.pHq = parcel.readString();
        this.nBM = parcel.readString();
        this.oZz = parcel.readString();
        this.pHM = parcel.readString();
        this.pHN = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.pHK);
        parcel.writeString(this.pHL);
        parcel.writeString(this.pHq);
        parcel.writeString(this.nBM);
        parcel.writeString(this.oZz);
        parcel.writeString(this.pHM);
        parcel.writeString(this.pHN);
    }

    public static ArrayList<TransferRecordParcel> bx(List<bom> list) {
        if (list == null) {
            return null;
        }
        ArrayList<TransferRecordParcel> arrayList = new ArrayList();
        for (bom transferRecordParcel : list) {
            arrayList.add(new TransferRecordParcel(transferRecordParcel));
        }
        return arrayList;
    }
}
