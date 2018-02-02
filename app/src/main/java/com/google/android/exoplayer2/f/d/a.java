package com.google.android.exoplayer2.f.d;

import android.text.Html;
import android.text.TextUtils;
import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.j;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends b {
    private static final Pattern ayA = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");
    private final StringBuilder ayB = new StringBuilder();

    protected final /* synthetic */ d a(byte[] bArr, int i, boolean z) {
        return f(bArr, i);
    }

    public a() {
        super("SubripDecoder");
    }

    private b f(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        e eVar = new e();
        j jVar = new j(bArr, i);
        while (true) {
            String readLine = jVar.readLine();
            if (readLine == null) {
                break;
            } else if (readLine.length() != 0) {
                try {
                    Integer.parseInt(readLine);
                    CharSequence readLine2 = jVar.readLine();
                    if (readLine2 == null) {
                        break;
                    }
                    Matcher matcher = ayA.matcher(readLine2);
                    if (matcher.matches()) {
                        int i2;
                        eVar.O(a(matcher, 1));
                        if (TextUtils.isEmpty(matcher.group(6))) {
                            i2 = 0;
                        } else {
                            eVar.O(a(matcher, 6));
                            i2 = 1;
                        }
                        this.ayB.setLength(0);
                        while (true) {
                            Object readLine3 = jVar.readLine();
                            if (TextUtils.isEmpty(readLine3)) {
                                break;
                            }
                            if (this.ayB.length() > 0) {
                                this.ayB.append("<br>");
                            }
                            this.ayB.append(readLine3.trim());
                        }
                        arrayList.add(new com.google.android.exoplayer2.f.a(Html.fromHtml(this.ayB.toString())));
                        if (i2 != 0) {
                            arrayList.add(null);
                        }
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        com.google.android.exoplayer2.f.a[] aVarArr = new com.google.android.exoplayer2.f.a[arrayList.size()];
        arrayList.toArray(aVarArr);
        return new b(aVarArr, eVar.lz());
    }

    private static long a(Matcher matcher, int i) {
        return ((((((Long.parseLong(matcher.group(i + 1)) * 60) * 60) * 1000) + ((Long.parseLong(matcher.group(i + 2)) * 60) * 1000)) + (Long.parseLong(matcher.group(i + 3)) * 1000)) + Long.parseLong(matcher.group(i + 4))) * 1000;
    }
}
