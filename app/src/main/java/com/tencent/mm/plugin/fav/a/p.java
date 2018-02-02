package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.e.i;
import java.util.ArrayList;
import java.util.List;

public interface p extends f {
    public static final String[] gJN = new String[]{i.a(h.gJc, "FavSearchInfo")};

    ArrayList<Long> a(List<String> list, List<String> list2, List<Integer> list3);

    boolean a(h hVar);

    boolean a(h hVar, String... strArr);

    void dd(long j);

    h de(long j);

    boolean zV(String str);
}
