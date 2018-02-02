package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.storage.x;
import java.util.List;

public interface i {
    x AW(String str);

    boolean AX(String str);

    long AY(String str);

    List<String> AZ(String str);

    Cursor h(String str, String[] strArr);

    Cursor rawQuery(String str, String[] strArr);
}
