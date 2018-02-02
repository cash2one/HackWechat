package com.tencent.mm.z;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.storage.au;
import java.util.List;

public interface am {
    void a(int i, String str, String str2, String str3, String str4, Bundle bundle);

    void a(au auVar);

    Looper getLooper();

    void y(List<au> list);
}
