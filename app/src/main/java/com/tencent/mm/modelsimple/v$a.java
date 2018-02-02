package com.tencent.mm.modelsimple;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bh;

public class v$a {
    public String frP;
    public String fyY;
    public String hNH;
    public Bundle hNI;
    public int type;
    public String username;

    public final String toString() {
        return String.format("AuthBioInfo hash[%d], type[%d]. username[%s], ticket[%s], helpUrlp[%s], wording[%s], extra[%s]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.type), this.username, bh.VT(this.frP), this.hNH, this.fyY, this.hNI});
    }
}
