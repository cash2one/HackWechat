package com.tencent.mm.loader.stub;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class d {
    public static String r(Context context, int i) {
        Throwable e;
        FileInputStream fileInputStream;
        if (context == null || i <= 0) {
            return "";
        }
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i && runningAppProcessInfo.processName != null && !runningAppProcessInfo.processName.equals("")) {
                    return runningAppProcessInfo.processName;
                }
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
        }
        byte[] bArr = new byte[FileUtils.S_IWUSR];
        try {
            fileInputStream = new FileInputStream("/proc/" + i + "/cmdline");
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    int i2 = 0;
                    while (i2 < read) {
                        if (bArr[i2] > Byte.MIN_VALUE || bArr[i2] <= (byte) 0) {
                            read = i2;
                            break;
                        }
                        i2++;
                    }
                    String str = new String(bArr, 0, read);
                    try {
                        fileInputStream.close();
                        return str;
                    } catch (Exception e3) {
                        return str;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                }
                return "";
            } catch (Exception e5) {
                e2 = e5;
                try {
                    x.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    e2 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw e2;
                }
            }
        } catch (Exception e8) {
            e2 = e8;
            fileInputStream = null;
            x.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return "";
        } catch (Throwable th2) {
            e2 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e2;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuilder.append(readLine + "\n");
                } else {
                    try {
                        break;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                    }
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.Util", e3, "", new Object[0]);
                }
            }
        }
        inputStream.close();
        return stringBuilder.toString();
    }
}
