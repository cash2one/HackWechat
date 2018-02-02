package com.tencent.mm.plugin.fav.a;

import android.database.Cursor;
import com.tencent.mm.sdk.e.f;
import com.tencent.mm.sdk.e.i;
import java.util.LinkedList;
import java.util.List;

public interface j extends f {
    public static final String[] gJN = new String[]{i.a(c.gJc, "FavCdnInfo")};

    void a(i iVar);

    boolean a(c cVar, String... strArr);

    void aHS();

    LinkedList<c> aHT();

    Cursor aHU();

    Cursor aHV();

    void b(i iVar);

    boolean b(c cVar);

    boolean b(c cVar, String... strArr);

    List<c> cW(long j);

    List<c> cX(long j);

    void cY(long j);

    boolean cZ(long j);

    void d(f fVar);

    int m(long j, int i);

    c zT(String str);
}
