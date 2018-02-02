package com.tencent.mm.plugin.favorite.ui.b;

import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.ui.b.a.c;
import java.util.Map;

public class a$a {
    public boolean kFT;
    public long lastUpdateTime;
    public String ldh;
    public boolean mup;
    public Map<Long, f> muq;
    public boolean mux;
    public c mxO;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lastUpdateTime:").append(this.lastUpdateTime).append('\n');
        stringBuilder.append("isSearching:").append(this.kFT).append('\n');
        stringBuilder.append("search str:").append(this.ldh).append('\n');
        return stringBuilder.toString();
    }
}
