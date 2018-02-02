package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.protocal.c.uw;
import com.tencent.mm.protocal.c.vh;
import java.util.List;

public interface r extends d {
    void checkFavItem(vh vhVar);

    void checkFavItem(List<uw> list);

    j getFavCdnStorage();

    k getFavConfigStorage();

    l getFavEditInfoStorage();

    o getFavItemInfoStorage();

    p getFavSearchStorage();
}
