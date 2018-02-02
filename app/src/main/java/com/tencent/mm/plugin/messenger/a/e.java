package com.tencent.mm.plugin.messenger.a;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mm.kernel.c.a;
import java.lang.ref.WeakReference;

public interface e extends a {
    void Eo(String str);

    void Ep(String str);

    CharSequence Eq(String str);

    CharSequence a(String str, Bundle bundle, WeakReference<Context> weakReference, WeakReference<TextView> weakReference2);

    void a(String str, a aVar);

    void a(String str, b bVar);
}
