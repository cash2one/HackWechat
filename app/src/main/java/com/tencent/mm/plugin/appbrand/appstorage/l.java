package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.p.h;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public interface l {
    j a(String str, FileStructStat fileStructStat);

    j a(String str, h<ByteBuffer> hVar);

    j a(String str, File file, boolean z);

    j b(String str, h<List<h>> hVar);

    boolean bE(String str);

    j d(String str, InputStream inputStream);

    void initialize();

    j pP(String str);

    File pQ(String str);

    j pU(String str);

    j pV(String str);

    j pW(String str);

    j pX(String str);

    void release();
}
