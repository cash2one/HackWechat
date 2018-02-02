package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.e.i;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public interface o extends f {
    public static final String[] gJN = new String[]{i.a(f.gJc, "FavItemInfo")};

    ArrayList<f> a(List<Long> list, List<f> list2, Set<Integer> set, n nVar);

    List<f> a(int i, int i2, Set<Integer> set, n nVar);

    List<f> a(long j, int i, Set<Integer> set, n nVar);

    boolean a(f fVar, String... strArr);

    e aHY();

    int aHZ();

    List<f> aIa();

    List<f> aIb();

    List<f> aIc();

    List<f> aId();

    List<f> aIe();

    List<f> aIf();

    List<Long> aIg();

    void aIh();

    List<Long> aIi();

    boolean b(f fVar, String... strArr);

    f db(long j);

    f dc(long j);

    long f(long j, int i, int i2);

    boolean f(f fVar);

    long g(long j, int i, int i2);

    void g(f fVar);

    int getCount();

    boolean p(long j, int i);

    LinkedList<Integer> q(long j, int i);

    void t(int i, long j);

    f zU(String str);
}
