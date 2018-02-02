package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class j$1 extends a {
    final /* synthetic */ j poK;

    j$1(j jVar) {
        this.poK = jVar;
    }

    public final void onSuccess(String str, Map<String, String> map) {
        j jVar = this.poK;
        int i = bh.getInt((String) map.get(".Response.result.Count"), 0);
        if (i > 0) {
            int i2 = jVar.poF.pnY.size() == 0 ? 1 : 0;
            int i3 = 0;
            while (i3 < i) {
                String str2 = ".Response.result.List.item" + (i3 > 0 ? String.valueOf(i3) : "") + ".";
                String str3 = (String) map.get(str2 + "Del");
                String str4 = (String) map.get(str2 + "Freq");
                String str5 = (String) map.get(str2 + "Name");
                str2 = (String) map.get(str2 + "Addr");
                if (str2 != null && str2.length() != 0) {
                    if (str5 == null || str5.length() == 0) {
                        str5 = str2;
                    }
                    int hashCode = str2.hashCode();
                    if (str3.equals("0")) {
                        List list = jVar.poF.pnY;
                        int i4 = 0;
                        while (i2 == 0 && i4 < list.size() && ((i) list.get(i4)).poA != hashCode) {
                            i4++;
                        }
                        if (i4 >= list.size() || i2 != 0) {
                            i iVar = new i();
                            iVar.poA = hashCode;
                            iVar.name = str5;
                            iVar.nQt = str2;
                            iVar.poB = Integer.parseInt(str4);
                            jVar.poF.a(iVar);
                        }
                    } else {
                        Iterator it = jVar.poF.pnY.iterator();
                        int i5 = 0;
                        while (it.hasNext()) {
                            if (((i) it.next()).poA == hashCode) {
                                jVar.poF.uY(i5);
                                break;
                            }
                            i5++;
                        }
                    }
                }
                i3++;
            }
            jVar.poF.HE((String) map.get(".Response.result.SyncInfo"));
            jVar.save();
        }
        if (((String) map.get(".Response.result.ContinueFlag")).equals("1")) {
            new af().postDelayed(new 1(this), 0);
            return;
        }
        this.poK.poD = bh.Wp();
        for (j.a onComplete : this.poK.gxL) {
            onComplete.onComplete();
        }
    }

    public final void onError(int i, String str) {
        for (j.a onComplete : this.poK.gxL) {
            onComplete.onComplete();
        }
    }

    public final void onComplete() {
        this.poK.status = this.poK.poJ;
    }
}
