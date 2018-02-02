package com.tencent.c.f;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public final class b {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] q(byte[] bArr) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        try {
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.finish();
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
                return toByteArray;
            } catch (IOException e) {
                return toByteArray;
            }
        } catch (Exception e2) {
            h.cu("deflater(), exception: " + e2);
            return null;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
                deflaterOutputStream.close();
            } catch (IOException e3) {
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] bG(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inflaterInputStream.read();
                if (read != -1) {
                    byteArrayOutputStream.write(read);
                } else {
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayInputStream.close();
                        inflaterInputStream.close();
                        byteArrayOutputStream.close();
                        return toByteArray;
                    } catch (IOException e) {
                        return toByteArray;
                    }
                }
            } catch (Exception e2) {
                h.cu("inflater(), exception: " + e2);
                return null;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                    inflaterInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException e3) {
                }
            }
        }
    }
}
