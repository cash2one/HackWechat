package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import com.google.android.gms.common.api.c;
import com.google.android.gms.wearable.Asset;
import java.util.HashSet;

public interface b {
    byte[] a(Asset asset);

    void bOB();

    c bOC();

    HashSet<String> bOD();

    boolean bOE();

    void bOF();

    void finish();

    boolean h(Uri uri);

    boolean isAvailable();

    a s(String str, byte[] bArr);

    a t(String str, byte[] bArr);
}
