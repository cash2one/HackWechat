package com.tencent.smtt.utils;

import com.tencent.smtt.sdk.WebView;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class d implements Closeable {
    public final RandomAccessFile Aal;
    private final byte[] Aam;
    public boolean Aan;
    private final File iFl;

    private d(File file) {
        this.Aam = new byte[8];
        this.iFl = file;
        this.Aal = new RandomAccessFile(this.iFl, "r");
    }

    public d(String str) {
        this(new File(str));
    }

    public final int a(char[] cArr) {
        byte[] bArr = new byte[cArr.length];
        int read = this.Aal.read(bArr);
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = (char) bArr[i];
        }
        return read;
    }

    public final void close() {
        try {
            this.Aal.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public final int readInt() {
        int readInt = this.Aal.readInt();
        if (!this.Aan) {
            return readInt;
        }
        return ((readInt & WebView.NIGHT_MODE_COLOR) >>> 24) | ((((readInt & 255) << 24) | ((65280 & readInt) << 8)) | ((16711680 & readInt) >>> 8));
    }
}
