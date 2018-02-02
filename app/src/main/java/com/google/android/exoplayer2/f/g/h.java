package com.google.android.exoplayer2.f.g;

import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.i.j;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h {
    private static final Pattern azQ = Pattern.compile("^NOTE(( |\t).*)?$");
    private static final Pattern azR = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");

    public static void k(j jVar) {
        Object readLine = jVar.readLine();
        if (readLine == null || !azR.matcher(readLine).matches()) {
            throw new f("Expected WEBVTT. Got " + readLine);
        }
    }

    public static long V(String str) {
        int i = 0;
        long j = 0;
        String[] split = str.split("\\.", 2);
        String[] split2 = split[0].split(":");
        while (i < split2.length) {
            j = (j * 60) + Long.parseLong(split2[i]);
            i++;
        }
        return (Long.parseLong(split[1]) + (j * 1000)) * 1000;
    }

    public static float W(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static Matcher l(j jVar) {
        while (true) {
            CharSequence readLine = jVar.readLine();
            if (readLine == null) {
                return null;
            }
            if (azQ.matcher(readLine).matches()) {
                while (true) {
                    String readLine2 = jVar.readLine();
                    if (readLine2 == null || readLine2.isEmpty()) {
                        break;
                    }
                }
            } else {
                Matcher matcher = f.azF.matcher(readLine);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }
}
