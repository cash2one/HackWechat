package com.tencent.mm.z;

import com.tencent.mm.ag.d.b;
import com.tencent.mm.ag.d.b.a;
import com.tencent.mm.ag.y;
import com.tencent.mm.api.h;
import java.util.ArrayList;

public final class j implements h {
    public final boolean cc(String str) {
        if (y.Mf().jK(str).KY()) {
            return true;
        }
        return false;
    }

    public final ArrayList<String> cd(String str) {
        try {
            b bI = y.Mf().jK(str).bI(false);
            if (bI.hoX == null && bI.hou != null) {
                bI.hoX = a.jD(bI.hou.optString("AcctTransferInfo"));
            }
            return bI.hoX.hoZ;
        } catch (Exception e) {
            return new ArrayList();
        }
    }
}
