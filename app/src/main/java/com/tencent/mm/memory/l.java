package com.tencent.mm.memory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public abstract class l {
    private static j haa = new j();
    private static m hab = new m();
    private static int hac = -1;

    public abstract Bitmap a(String str, Options options, DecodeResultLogger decodeResultLogger);

    public abstract Bitmap a(String str, Rect rect, Options options, DecodeResultLogger decodeResultLogger);

    public abstract void h(Bitmap bitmap);

    public static l EA() {
        if (hac == -1) {
            if (EB()) {
                hac = 1;
            } else {
                hac = 2;
            }
        }
        switch (hac) {
            case 1:
                return haa;
            case 2:
                return hab;
            default:
                return hab;
        }
    }

    public static boolean EB() {
        boolean fM = d.fM(19);
        boolean cgA = bh.cgA();
        x.i("MicroMsg.PlatformBitmapFactory", "canUseInBitmapFactory, isVersionMatch: %b, isART: %b, result: %s", new Object[]{Boolean.valueOf(fM), Boolean.valueOf(cgA), Boolean.valueOf(fM)});
        return fM;
    }

    protected static void e(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            if (inputStream instanceof FileInputStream) {
                inputStream = new j((FileInputStream) inputStream);
            } else {
                inputStream = new BufferedInputStream(inputStream, 65536);
            }
        }
        try {
            inputStream.reset();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.PlatformBitmapFactory", e, "reset stream error: %s", new Object[]{e.getMessage()});
        }
    }
}
