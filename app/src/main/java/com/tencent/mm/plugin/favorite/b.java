package com.tencent.mm.plugin.favorite;

import com.tencent.mm.g.a.ca;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends c<ca> {
    public b() {
        this.xen = ca.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        ca caVar = (ca) bVar;
        x.i("MicroMsg.DelFavoriteItemListener", "do delete favitem, localId %d", new Object[]{Long.valueOf(caVar.fqi.fqk)});
        caVar.fqj.fpW = j.a(caVar.fqi.fqk, null);
        return false;
    }
}
