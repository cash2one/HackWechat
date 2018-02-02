package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.g.a.lf;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.pluginsdk.wallet.k;
import java.util.Map;

public interface l extends a {
    int a(c cVar, int i, boolean z);

    void a(lf lfVar, int i);

    void a(lf lfVar, int i, String str);

    boolean a(boolean z, boolean z2, Bundle bundle);

    boolean aJW();

    boolean aJX();

    boolean aJY();

    void aKa();

    j aKc();

    boolean aKd();

    boolean aKe();

    void aKf();

    boolean aKh();

    boolean aKi();

    void aKj();

    void aKk();

    void aKl();

    Map<String, String> aKm();

    k aKn();

    Map<String, String> aKo();

    boolean aKp();

    void cB(Context context);

    void cC(Context context);

    void fi(boolean z);

    int type();
}
