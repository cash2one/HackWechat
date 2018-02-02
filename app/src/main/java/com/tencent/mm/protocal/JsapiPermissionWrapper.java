package com.tencent.mm.protocal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public class JsapiPermissionWrapper implements Parcelable {
    public static final Creator<JsapiPermissionWrapper> CREATOR = new 1();
    public static final JsapiPermissionWrapper vAM = new JsapiPermissionWrapper(1);
    public static final JsapiPermissionWrapper vAN = new JsapiPermissionWrapper(2);
    public static final JsapiPermissionWrapper vAO = new JsapiPermissionWrapper(3);
    public static final JsapiPermissionWrapper vAP = new JsapiPermissionWrapper(4);
    public byte[] vAQ;
    private int vAR;
    private Set<Integer> vAS;
    private Set<Integer> vAT;

    public JsapiPermissionWrapper() {
        this.vAQ = null;
        this.vAR = 0;
        this.vAQ = null;
    }

    public JsapiPermissionWrapper(byte[] bArr) {
        this.vAQ = null;
        this.vAR = 0;
        if (bArr == null) {
            this.vAQ = null;
        } else {
            this.vAQ = bArr;
        }
    }

    public JsapiPermissionWrapper(int i) {
        this.vAQ = null;
        this.vAR = 0;
        this.vAR = i;
        this.vAQ = new byte[0];
    }

    public final int CF(int i) {
        int i2;
        if (this.vAT == null || !this.vAT.contains(Integer.valueOf(i))) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i2 != 0) {
            return 1;
        }
        if (this.vAS == null || !this.vAS.contains(Integer.valueOf(i))) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i2 != 0) {
            return 0;
        }
        if (this.vAR == 1) {
            if (i != 34 && i != 75) {
                return 1;
            }
            x.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[]{Integer.valueOf(i)});
            return 0;
        } else if (this.vAR == 2) {
            if (i != -3) {
                return 0;
            }
            return 1;
        } else if (this.vAR == 3) {
            if (i != 34 && i != 75 && i != 23) {
                return 1;
            }
            x.i("MicroMsg.JsapiPermissionWrapper", "on reserved bytes control : %d", new Object[]{Integer.valueOf(i)});
            return 0;
        } else if (this.vAR == 4) {
            if (i != 34 && i != 75) {
                return 1;
            }
            x.i("MicroMsg.JsapiPermissionWrapper", "hy: on reserved bytes control : %d", new Object[]{Integer.valueOf(i)});
            return 0;
        } else if (i == -2 || i == -3) {
            return 1;
        } else {
            if (this.vAQ == null || i < 0 || i >= this.vAQ.length) {
                return 0;
            }
            return this.vAQ[i];
        }
    }

    public final void a(int i, byte b) {
        int i2 = 0;
        if (this.vAQ == null || i < 0 || i >= this.vAQ.length) {
            String str = "MicroMsg.JsapiPermissionWrapper";
            String str2 = "setPermission pos out of range, %s, %s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            if (this.vAQ != null) {
                i2 = this.vAQ.length;
            }
            objArr[1] = Integer.valueOf(i2);
            x.e(str, str2, objArr);
            return;
        }
        this.vAQ[i] = b;
    }

    public final boolean gn(int i) {
        if (CF(i) == 1) {
            return true;
        }
        return false;
    }

    public static boolean cdF() {
        return true;
    }

    public String toString() {
        if (this.vAQ == null) {
            return "null";
        }
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder(180);
        for (byte append : this.vAQ) {
            stringBuilder.append(append);
        }
        String stringBuilder2 = stringBuilder.toString();
        x.d("MicroMsg.JsapiPermissionWrapper", "toString cost %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return stringBuilder2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.vAQ);
        parcel.writeInt(this.vAR);
        parcel.writeIntArray(cdG());
        parcel.writeIntArray(cdH());
    }

    private JsapiPermissionWrapper(Parcel parcel) {
        this.vAQ = null;
        this.vAR = 0;
        this.vAQ = parcel.createByteArray();
        this.vAR = parcel.readInt();
        n(parcel.createIntArray());
        o(parcel.createIntArray());
    }

    public final void toBundle(Bundle bundle) {
        bundle.putByteArray("jsapi_perm_wrapper_bytes", this.vAQ);
        bundle.putInt("jsapi_perm_wrapper_hardcodePermission", this.vAR);
        bundle.putIntArray("jsapi_perm_wrapper_blacklist", cdG());
        bundle.putIntArray("jsapi_perm_wrapper_whitelist", cdH());
    }

    public final void fromBundle(Bundle bundle) {
        this.vAQ = bundle.getByteArray("jsapi_perm_wrapper_bytes");
        this.vAR = bundle.getInt("jsapi_perm_wrapper_hardcodePermission");
        n(bundle.getIntArray("jsapi_perm_wrapper_blacklist"));
        o(bundle.getIntArray("jsapi_perm_wrapper_whitelist"));
    }

    private int[] cdG() {
        if (this.vAS == null) {
            return new int[0];
        }
        int[] iArr = new int[this.vAS.size()];
        int i = 0;
        for (Integer num : this.vAS) {
            int i2 = i + 1;
            iArr[i] = num == null ? 0 : num.intValue();
            i = i2;
        }
        return iArr;
    }

    public final void n(int[] iArr) {
        if (this.vAS == null) {
            this.vAS = new HashSet();
        } else {
            this.vAS.clear();
        }
        if (iArr != null && iArr.length > 0) {
            for (int valueOf : iArr) {
                this.vAS.add(Integer.valueOf(valueOf));
            }
        }
    }

    private int[] cdH() {
        if (this.vAT == null) {
            return new int[0];
        }
        int[] iArr = new int[this.vAT.size()];
        int i = 0;
        for (Integer num : this.vAT) {
            int i2 = i + 1;
            iArr[i] = num == null ? 0 : num.intValue();
            i = i2;
        }
        return iArr;
    }

    public final void o(int[] iArr) {
        if (this.vAT == null) {
            this.vAT = new HashSet();
        } else {
            this.vAT.clear();
        }
        if (iArr != null && iArr.length > 0) {
            for (int valueOf : iArr) {
                this.vAT.add(Integer.valueOf(valueOf));
            }
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JsapiPermissionWrapper)) {
            return false;
        }
        JsapiPermissionWrapper jsapiPermissionWrapper = (JsapiPermissionWrapper) obj;
        if (this.vAQ == jsapiPermissionWrapper.vAQ) {
            return true;
        }
        if (this.vAQ == null || jsapiPermissionWrapper.vAQ == null || this.vAQ.length != jsapiPermissionWrapper.vAQ.length) {
            return false;
        }
        for (int i = 0; i < this.vAQ.length; i++) {
            if (this.vAQ[i] != jsapiPermissionWrapper.vAQ[i]) {
                return false;
            }
        }
        return true;
    }
}
