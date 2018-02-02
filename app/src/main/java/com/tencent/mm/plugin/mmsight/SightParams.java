package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;

public class SightParams implements Parcelable {
    public static final Creator<SightParams> CREATOR = new 1();
    public int mode = 0;
    public int oqI = 2;
    public VideoTransPara oqJ;
    public String oqK = "";
    public String oqL = "";
    public String oqM = "";
    public String oqN = "";
    public String oqO = "";
    public boolean oqP = true;
    public boolean oqQ = true;
    public int oqR;
    public int scene = -1;

    public SightParams(int i, int i2) {
        if (i == 1) {
            this.oqJ = d.MU().MV();
        } else if (i == 2 || i == 3 || i == 4) {
            this.oqJ = d.MU().MW();
        } else {
            this.oqJ = d.MU().MW();
        }
        this.scene = i;
        this.mode = i2;
        g.Dk();
        this.oqR = ((Integer) g.Dj().CU().get(344066, Integer.valueOf(0))).intValue();
    }

    protected SightParams(Parcel parcel) {
        boolean z = true;
        this.mode = parcel.readInt();
        this.oqJ = (VideoTransPara) parcel.readParcelable(VideoTransPara.class.getClassLoader());
        this.oqK = parcel.readString();
        this.oqL = parcel.readString();
        this.oqM = parcel.readString();
        this.oqN = parcel.readString();
        this.oqR = parcel.readInt();
        this.oqI = parcel.readInt();
        this.oqP = parcel.readInt() > 0;
        this.scene = parcel.readInt();
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.oqQ = z;
    }

    public final SightParams j(String str, String str2, String str3, String str4) {
        this.oqM = str;
        this.oqK = str2;
        this.oqL = str3;
        this.oqN = str4;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b = (byte) 1;
        parcel.writeInt(this.mode);
        parcel.writeParcelable(this.oqJ, i);
        parcel.writeString(this.oqK);
        parcel.writeString(this.oqL);
        parcel.writeString(this.oqM);
        parcel.writeString(this.oqN);
        parcel.writeInt(this.oqR);
        parcel.writeInt(this.oqI);
        parcel.writeInt(this.oqP ? 1 : 0);
        parcel.writeInt(this.scene);
        if (!this.oqQ) {
            b = (byte) 0;
        }
        parcel.writeByte(b);
    }
}
