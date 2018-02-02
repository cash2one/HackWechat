package com.tencent.mm.plugin.webview.fts.a;

import com.tencent.mm.g.b.af;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e extends a<a> {
    public List<a> mOV = Collections.emptyList();

    public e(String str, int i) {
        super(str, Integer.MAX_VALUE);
    }

    public final void ck(List<j> list) {
        this.mOV = new ArrayList(list.size());
        for (j jVar : list) {
            ar.Hg();
            af WO = c.EY().WO(jVar.mLs);
            a aVar = new a();
            aVar.userName = WO.field_username;
            aVar.tnl = jVar.content;
            aVar.bgo = WO.field_nickname;
            aVar.iIj = WO.field_conRemark;
            aVar.gfN = WO.vN();
            aVar.desc = WO.fWy;
            this.mOV.add(aVar);
        }
    }
}
