package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ElementQuery implements Parcelable {
    public static final Creator<ElementQuery> CREATOR = new 1();
    public static String sMq = "bind_serial";
    public JSONObject hou;
    public String nBM;
    public String oZA;
    public String oZz;
    public int sIJ;
    public String sKA;
    public String sMA;
    public String sMB;
    public String sMC;
    public String sMD;
    public String sME;
    public String sMF;
    public boolean sMG;
    public boolean sMH;
    public boolean sMI;
    public boolean sMJ;
    public boolean sMK;
    public boolean sML;
    public boolean sMM;
    public boolean sMN;
    public boolean sMO;
    public String sMP;
    private List<Integer> sMQ = null;
    public boolean sMR;
    public boolean sMS = false;
    public String sMr;
    public boolean sMs;
    public boolean sMt;
    public boolean sMu;
    public boolean sMv;
    public String sMw;
    public boolean sMx;
    public int sMy;
    public int sMz;

    public final boolean isError() {
        return "0".equals(bh.az(this.sMB, "").trim());
    }

    public final boolean bLb() {
        return 1 == this.sMz;
    }

    public final List<Integer> bLc() {
        if (this.sMQ != null) {
            return this.sMQ;
        }
        if (bh.ov(this.sMP)) {
            return null;
        }
        this.sMQ = new ArrayList();
        for (String str : this.sMP.split("\\|")) {
            int i = bh.getInt(str, 0);
            if (i > 0) {
                this.sMQ.add(Integer.valueOf(i));
            }
        }
        return this.sMQ;
    }

    public ElementQuery(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.oZA = parcel.readString();
        this.nBM = parcel.readString();
        this.sMr = parcel.readString();
        this.sMs = 1 == parcel.readInt();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.sMt = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.sMu = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.sMv = z;
        this.sMw = parcel.readString();
        this.oZA = parcel.readString();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.sMx = z;
        this.sMy = parcel.readInt();
        this.sMz = parcel.readInt();
        this.oZz = parcel.readString();
        this.sMA = parcel.readString();
        this.sMB = parcel.readString();
        this.sMC = parcel.readString();
        this.sMF = parcel.readString();
        this.sME = parcel.readString();
        this.sMD = parcel.readString();
        this.sMG = 1 == parcel.readInt();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.sMH = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.sMI = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.sMJ = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.sMK = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.sML = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.sMN = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.sMM = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.sMO = z;
        this.sIJ = parcel.readInt();
        this.sMP = parcel.readString();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.sMS = z;
        this.sKA = parcel.readString();
        if (1 != parcel.readInt()) {
            z2 = false;
        }
        this.sMR = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(bh.az(this.oZA, ""));
        parcel.writeString(bh.az(this.nBM, ""));
        parcel.writeString(bh.az(this.sMr, ""));
        parcel.writeInt(this.sMs ? 1 : 0);
        if (this.sMt) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.sMu) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.sMv) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(bh.az(this.sMw, ""));
        parcel.writeString(bh.az(this.oZA, ""));
        if (this.sMx) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.sMy);
        parcel.writeInt(this.sMz);
        parcel.writeString(bh.az(this.oZz, ""));
        parcel.writeString(bh.az(this.sMA, ""));
        parcel.writeString(bh.az(this.sMB, ""));
        parcel.writeString(bh.az(this.sMC, ""));
        parcel.writeString(bh.az(this.sMF, ""));
        parcel.writeString(bh.az(this.sME, ""));
        parcel.writeString(bh.az(this.sMD, ""));
        parcel.writeInt(this.sMG ? 1 : 0);
        if (this.sMH) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.sMI) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.sMJ) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.sMK) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.sML) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.sMN) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.sMM) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.sMO) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.sIJ);
        parcel.writeString(this.sMP);
        if (this.sMS) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.sKA);
        if (!this.sMR) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
