package com.tencent.mm.hardcoder;

import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class f {

    public interface a {
        boolean fd(String str);
    }

    public static void a(InputStream inputStream, a aVar) {
        BufferedReader bufferedReader;
        Exception e;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String readLine;
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                    }
                    break;
                } catch (Exception e2) {
                    e = e2;
                }
            } while (aVar.fd(readLine));
            try {
                bufferedReader.close();
            } catch (Exception e3) {
                x.e("MicroMsg.HardCoderUtil", "exception:" + e3.getMessage());
            }
        } catch (Exception e4) {
            e3 = e4;
            bufferedReader = null;
            try {
                x.e("MicroMsg.HardCoderUtil", "exception:" + e3.getMessage());
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e32) {
                        x.e("MicroMsg.HardCoderUtil", "exception:" + e32.getMessage());
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e5) {
                        x.e("MicroMsg.HardCoderUtil", "exception:" + e5.getMessage());
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }
}
