package com.tencent.mm.ui.widget.celltextview.a;

import android.graphics.Paint;
import com.tencent.mm.ui.widget.celltextview.c.c;
import com.tencent.mm.ui.widget.celltextview.c.d;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    private static Paint zxb = new Paint();
    public String jUJ;
    public float nxC;
    public ArrayList<d> zwT;
    public ArrayList<c> zwZ;
    public float zxa;

    public a(String str, float f, float f2) {
        this.jUJ = str;
        this.nxC = f;
        this.zxa = f2;
    }

    public final void am(ArrayList<d> arrayList) {
        if (arrayList != null) {
            if (this.zwT == null) {
                this.zwT = new ArrayList(arrayList.size());
            }
            this.zwT.addAll(arrayList);
        }
    }

    public final int hashCode() {
        Iterator it = this.zwT.iterator();
        int i = 0;
        while (it.hasNext()) {
            i = ((d) it.next()).czm() + i;
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        zxb.setTextSize(this.nxC);
        if (this.zxa == aVar.zxa && this.nxC == aVar.nxC && this.jUJ.equals(aVar.jUJ) && ((int) zxb.measureText(this.jUJ)) == ((int) zxb.measureText(aVar.jUJ))) {
            return true;
        }
        return false;
    }
}
