package com.tencent.smtt.sdk;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class a {
    private static int zVl = 0;
    public static int zVm = 600;

    public static int cDO() {
        Throwable th;
        int i = 0;
        if (zVl > 0) {
            return zVl;
        }
        BufferedReader bufferedReader;
        try {
            int indexOf;
            String readLine;
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        indexOf = readLine.indexOf("MemTotal:");
                    }
                    break;
                } catch (IOException e) {
                } catch (Throwable th2) {
                    th = th2;
                }
            } while (-1 == indexOf);
            readLine = readLine.substring(indexOf + 9).trim();
            if (readLine != null && readLine.length() != 0 && readLine.contains("k")) {
                i = Integer.parseInt(readLine.substring(0, readLine.indexOf("k")).trim()) / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
            }
            try {
                bufferedReader.close();
            } catch (IOException e2) {
            }
        } catch (IOException e3) {
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                }
            }
            zVl = i;
            return i;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                }
            }
            throw th;
        }
        zVl = i;
        return i;
    }
}
