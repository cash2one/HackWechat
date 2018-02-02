package com.tencent.mm.by;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public final class b {
    static String ckL() {
        BufferedReader bufferedReader;
        String str;
        Exception e;
        Throwable th;
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        String str2 = "";
        String str3 = "";
        String str4 = "";
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/mounts"));
            try {
                String[] split;
                Pattern compile = Pattern.compile("\\s+");
                while (true) {
                    CharSequence readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    split = compile.split(readLine);
                    if (split.length >= 3 && split[1].equals(absolutePath)) {
                        break;
                    }
                    if (new StatFs(absolutePath).getBlockSize() > 0) {
                        str3 = String.format("blockSize: %d, blocks: %d / %d", new Object[]{Integer.valueOf(new StatFs(absolutePath).getBlockSize()), Integer.valueOf(new StatFs(absolutePath).getAvailableBlocks()), Integer.valueOf(new StatFs(absolutePath).getBlockCount())});
                    }
                    bufferedReader.close();
                    return str4 + '\n' + str3 + '\n' + str;
                }
                str2 = split[2];
                if (split.length > 3) {
                    str = split[3];
                    str4 = str2;
                    if (new StatFs(absolutePath).getBlockSize() > 0) {
                        str3 = String.format("blockSize: %d, blocks: %d / %d", new Object[]{Integer.valueOf(new StatFs(absolutePath).getBlockSize()), Integer.valueOf(new StatFs(absolutePath).getAvailableBlocks()), Integer.valueOf(new StatFs(absolutePath).getBlockCount())});
                    }
                    bufferedReader.close();
                    return str4 + '\n' + str3 + '\n' + str;
                }
                str = str4;
                str4 = str2;
                try {
                    if (new StatFs(absolutePath).getBlockSize() > 0) {
                        str3 = String.format("blockSize: %d, blocks: %d / %d", new Object[]{Integer.valueOf(new StatFs(absolutePath).getBlockSize()), Integer.valueOf(new StatFs(absolutePath).getAvailableBlocks()), Integer.valueOf(new StatFs(absolutePath).getBlockCount())});
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.e("MicroMsg.DBUtils", "Cannot gather file system info: " + e.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                            }
                        }
                        return str4 + '\n' + str3 + '\n' + str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e6) {
                Exception exception = e6;
                str = str4;
                str4 = str2;
                e = exception;
                x.e("MicroMsg.DBUtils", "Cannot gather file system info: " + e.getMessage());
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return str4 + '\n' + str3 + '\n' + str;
            }
        } catch (Exception e62) {
            bufferedReader = null;
            String str5 = str4;
            str4 = str2;
            e = e62;
            str = str5;
            x.e("MicroMsg.DBUtils", "Cannot gather file system info: " + e.getMessage());
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return str4 + '\n' + str3 + '\n' + str;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
        return str4 + '\n' + str3 + '\n' + str;
    }
}
