package com.tencent.mm.z.b;

import android.content.SharedPreferences;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public abstract class a implements e {
    protected com.tencent.mm.z.b.e.a hin;
    protected String hio = Il();
    protected String[] hip = Ik();

    public abstract String Il();

    public final boolean ik(String str) {
        ar.Hg();
        SharedPreferences fL = c.fL("banner");
        if (fL == null || !fL.getBoolean(this.hio + str, false)) {
            return false;
        }
        return true;
    }

    public final void a(String str, boolean z, String[] strArr) {
        ar.Hg();
        SharedPreferences fL = c.fL("banner");
        if (fL != null) {
            fL.edit().putBoolean(this.hio + str, z).commit();
            if (!(this.hip == null || strArr == null || this.hip.length != strArr.length)) {
                int i = 0;
                for (String str2 : this.hip) {
                    if (str2 != null) {
                        fL.edit().putString(this.hio + str2 + str, strArr[i] != null ? strArr[i] : "").commit();
                    }
                    i++;
                }
            }
            if (this.hin != null) {
                this.hin.Ix();
            }
        }
    }

    public final String W(String str, String str2) {
        ar.Hg();
        SharedPreferences fL = c.fL("banner");
        if (fL == null) {
            return null;
        }
        return fL.getString(this.hio + str2 + str, null);
    }

    public final void il(String str) {
        ar.Hg();
        SharedPreferences fL = c.fL("banner");
        if (fL != null) {
            fL.edit().remove(this.hio + str).commit();
            if (this.hip != null) {
                for (String str2 : this.hip) {
                    if (str2 != null) {
                        fL.edit().remove(this.hio + str2 + str).commit();
                    }
                }
            }
            if (this.hin != null) {
                this.hin.Iy();
            }
        }
    }

    public final void a(com.tencent.mm.z.b.e.a aVar) {
        this.hin = aVar;
    }

    protected String[] Ik() {
        return null;
    }
}
