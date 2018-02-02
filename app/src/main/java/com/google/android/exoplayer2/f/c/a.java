package com.google.android.exoplayer2.f.c;

import android.text.TextUtils;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends b {
    private static final Pattern ays = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private final boolean ayt;
    private int ayu;
    private int ayv;
    private int ayw;
    private int ayx;

    protected final /* synthetic */ d a(byte[] bArr, int i, boolean z) {
        List arrayList = new ArrayList();
        e eVar = new e();
        j jVar = new j(bArr, i);
        if (!this.ayt) {
            f(jVar);
        }
        a(jVar, arrayList, eVar);
        com.google.android.exoplayer2.f.a[] aVarArr = new com.google.android.exoplayer2.f.a[arrayList.size()];
        arrayList.toArray(aVarArr);
        return new b(aVarArr, eVar.lz());
    }

    public a() {
        this(null);
    }

    public a(List<byte[]> list) {
        super("SsaDecoder");
        if (list != null) {
            this.ayt = true;
            String str = new String((byte[]) list.get(0));
            com.google.android.exoplayer2.i.a.am(str.startsWith("Format: "));
            S(str);
            f(new j((byte[]) list.get(1)));
            return;
        }
        this.ayt = false;
    }

    private static void f(j jVar) {
        String readLine;
        do {
            readLine = jVar.readLine();
            if (readLine == null) {
                return;
            }
        } while (!readLine.startsWith("[Events]"));
    }

    private void a(j jVar, List<com.google.android.exoplayer2.f.a> list, e eVar) {
        while (true) {
            String readLine = jVar.readLine();
            if (readLine == null) {
                return;
            }
            if (!this.ayt && readLine.startsWith("Format: ")) {
                S(readLine);
            } else if (readLine.startsWith("Dialogue: ") && this.ayu != 0) {
                String[] split = readLine.substring(10).split(",", this.ayu);
                long T = T(split[this.ayv]);
                if (T != -9223372036854775807L) {
                    long j;
                    readLine = split[this.ayw];
                    if (readLine.trim().isEmpty()) {
                        j = -9223372036854775807L;
                    } else {
                        j = T(readLine);
                        if (j == -9223372036854775807L) {
                        }
                    }
                    list.add(new com.google.android.exoplayer2.f.a(split[this.ayx].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
                    eVar.O(T);
                    if (j != -9223372036854775807L) {
                        list.add(null);
                        eVar.O(j);
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void S(String str) {
        String[] split = TextUtils.split(str.substring(8), ",");
        this.ayu = split.length;
        this.ayv = -1;
        this.ayw = -1;
        this.ayx = -1;
        for (int i = 0; i < this.ayu; i++) {
            int i2;
            String ai = t.ai(split[i].trim());
            switch (ai.hashCode()) {
                case 100571:
                    if (ai.equals("end")) {
                        i2 = 1;
                        break;
                    }
                case 3556653:
                    if (ai.equals("text")) {
                        i2 = 2;
                        break;
                    }
                case 109757538:
                    if (ai.equals("start")) {
                        i2 = 0;
                        break;
                    }
                default:
                    i2 = -1;
                    break;
            }
            switch (i2) {
                case 0:
                    this.ayv = i;
                    break;
                case 1:
                    this.ayw = i;
                    break;
                case 2:
                    this.ayx = i;
                    break;
                default:
                    break;
            }
        }
    }

    private static long T(String str) {
        Matcher matcher = ays.matcher(str);
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong(matcher.group(4)) * 10000) + (((((Long.parseLong(matcher.group(1)) * 60) * 60) * 1000000) + ((Long.parseLong(matcher.group(2)) * 60) * 1000000)) + (Long.parseLong(matcher.group(3)) * 1000000));
    }
}
