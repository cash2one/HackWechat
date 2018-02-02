package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new Creator<BackStackState>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BackStackState[i];
        }
    };
    final int mIndex;
    final String mName;
    final int[] pV;
    final int pn;
    final int po;
    final int ps;
    final CharSequence pt;
    final int pu;
    final CharSequence pv;
    final ArrayList<String> pw;
    final ArrayList<String> px;

    public BackStackState(e eVar) {
        int i = 0;
        for (a aVar = eVar.pg; aVar != null; aVar = aVar.pI) {
            if (aVar.pQ != null) {
                i += aVar.pQ.size();
            }
        }
        this.pV = new int[(i + (eVar.pi * 7))];
        if (eVar.pp) {
            i = 0;
            for (a aVar2 = eVar.pg; aVar2 != null; aVar2 = aVar2.pI) {
                int i2 = i + 1;
                this.pV[i] = aVar2.pK;
                int i3 = i2 + 1;
                this.pV[i2] = aVar2.pL != null ? aVar2.pL.mIndex : -1;
                int i4 = i3 + 1;
                this.pV[i3] = aVar2.pM;
                i2 = i4 + 1;
                this.pV[i4] = aVar2.pN;
                i4 = i2 + 1;
                this.pV[i2] = aVar2.pO;
                i2 = i4 + 1;
                this.pV[i4] = aVar2.pP;
                if (aVar2.pQ != null) {
                    int size = aVar2.pQ.size();
                    i4 = i2 + 1;
                    this.pV[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.pV[i4] = ((Fragment) aVar2.pQ.get(i2)).mIndex;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.pV[i2] = 0;
                }
            }
            this.pn = eVar.pn;
            this.po = eVar.po;
            this.mName = eVar.mName;
            this.mIndex = eVar.mIndex;
            this.ps = eVar.ps;
            this.pt = eVar.pt;
            this.pu = eVar.pu;
            this.pv = eVar.pv;
            this.pw = eVar.pw;
            this.px = eVar.px;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.pV = parcel.createIntArray();
        this.pn = parcel.readInt();
        this.po = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.ps = parcel.readInt();
        this.pt = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.pu = parcel.readInt();
        this.pv = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.pw = parcel.createStringArrayList();
        this.px = parcel.createStringArrayList();
    }

    public final e a(n nVar) {
        e eVar = new e(nVar);
        int i = 0;
        int i2 = 0;
        while (i2 < this.pV.length) {
            a aVar = new a();
            int i3 = i2 + 1;
            aVar.pK = this.pV[i2];
            if (n.DEBUG) {
                new StringBuilder("Instantiate ").append(eVar).append(" op #").append(i).append(" base fragment #").append(this.pV[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.pV[i3];
            if (i2 >= 0) {
                aVar.pL = (Fragment) nVar.qs.get(i2);
            } else {
                aVar.pL = null;
            }
            i3 = i4 + 1;
            aVar.pM = this.pV[i4];
            i4 = i3 + 1;
            aVar.pN = this.pV[i3];
            i3 = i4 + 1;
            aVar.pO = this.pV[i4];
            int i5 = i3 + 1;
            aVar.pP = this.pV[i3];
            i4 = i5 + 1;
            int i6 = this.pV[i5];
            if (i6 > 0) {
                aVar.pQ = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (n.DEBUG) {
                        new StringBuilder("Instantiate ").append(eVar).append(" set remove fragment #").append(this.pV[i4]);
                    }
                    i5 = i4 + 1;
                    aVar.pQ.add((Fragment) nVar.qs.get(this.pV[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            eVar.pj = aVar.pM;
            eVar.pk = aVar.pN;
            eVar.pl = aVar.pO;
            eVar.pm = aVar.pP;
            eVar.a(aVar);
            i++;
            i2 = i4;
        }
        eVar.pn = this.pn;
        eVar.po = this.po;
        eVar.mName = this.mName;
        eVar.mIndex = this.mIndex;
        eVar.pp = true;
        eVar.ps = this.ps;
        eVar.pt = this.pt;
        eVar.pu = this.pu;
        eVar.pv = this.pv;
        eVar.pw = this.pw;
        eVar.px = this.px;
        eVar.M(1);
        return eVar;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.pV);
        parcel.writeInt(this.pn);
        parcel.writeInt(this.po);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.ps);
        TextUtils.writeToParcel(this.pt, parcel, 0);
        parcel.writeInt(this.pu);
        TextUtils.writeToParcel(this.pv, parcel, 0);
        parcel.writeStringList(this.pw);
        parcel.writeStringList(this.px);
    }
}
