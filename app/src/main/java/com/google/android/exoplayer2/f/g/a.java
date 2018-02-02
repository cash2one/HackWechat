package com.google.android.exoplayer2.f.g;

import android.text.TextUtils;
import com.google.android.exoplayer2.i.d;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a {
    private static final Pattern azs = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final j azt = new j();
    private final StringBuilder azu = new StringBuilder();

    public final d g(j jVar) {
        String str;
        this.azu.setLength(0);
        int i = jVar.position;
        do {
        } while (!TextUtils.isEmpty(jVar.readLine()));
        this.azt.l(jVar.data, jVar.position);
        this.azt.cR(i);
        j jVar2 = this.azt;
        StringBuilder stringBuilder = this.azu;
        h(jVar2);
        if (jVar2.lF() < 5) {
            str = null;
        } else {
            if ("::cue".equals(jVar2.readString(5))) {
                i = jVar2.position;
                String a = a(jVar2, stringBuilder);
                if (a == null) {
                    str = null;
                } else if ("{".equals(a)) {
                    jVar2.cR(i);
                    str = "";
                } else {
                    str = null;
                    if ("(".equals(a)) {
                        i = jVar2.position;
                        int i2 = jVar2.asN;
                        Object obj = null;
                        while (i < i2 && r1 == null) {
                            int i3 = i + 1;
                            obj = ((char) jVar2.data[i]) == ')' ? 1 : null;
                            i = i3;
                        }
                        str = jVar2.readString((i - 1) - jVar2.position).trim();
                    }
                    a = a(jVar2, stringBuilder);
                    if (!")".equals(a) || a == null) {
                        str = null;
                    }
                }
            } else {
                str = null;
            }
        }
        if (str == null || !"{".equals(a(this.azt, this.azu))) {
            return null;
        }
        int indexOf;
        d dVar = new d();
        if (!"".equals(str)) {
            int indexOf2 = str.indexOf(91);
            if (indexOf2 != -1) {
                Matcher matcher = azs.matcher(str.substring(indexOf2));
                if (matcher.matches()) {
                    dVar.azC = matcher.group(1);
                }
                str = str.substring(0, indexOf2);
            }
            String[] split = str.split("\\.");
            String str2 = split[0];
            indexOf = str2.indexOf(35);
            if (indexOf != -1) {
                dVar.azA = str2.substring(0, indexOf);
                dVar.azz = str2.substring(indexOf + 1);
            } else {
                dVar.azA = str2;
            }
            if (split.length > 1) {
                dVar.azB = Arrays.asList((String[]) Arrays.copyOfRange(split, 1, split.length));
            }
        }
        Object obj2 = null;
        Object obj3 = null;
        while (obj3 == null) {
            indexOf = this.azt.position;
            obj2 = a(this.azt, this.azu);
            obj3 = (obj2 == null || "}".equals(obj2)) ? 1 : null;
            if (obj3 == null) {
                this.azt.cR(indexOf);
                j jVar3 = this.azt;
                StringBuilder stringBuilder2 = this.azu;
                h(jVar3);
                String b = b(jVar3, stringBuilder2);
                if (!"".equals(b) && ":".equals(a(jVar3, stringBuilder2))) {
                    String str3;
                    h(jVar3);
                    StringBuilder stringBuilder3 = new StringBuilder();
                    Object obj4 = null;
                    while (obj4 == null) {
                        int i4 = jVar3.position;
                        String a2 = a(jVar3, stringBuilder2);
                        if (a2 == null) {
                            str3 = null;
                            break;
                        } else if ("}".equals(a2) || ";".equals(a2)) {
                            jVar3.cR(i4);
                            obj4 = 1;
                        } else {
                            stringBuilder3.append(a2);
                        }
                    }
                    str3 = stringBuilder3.toString();
                    if (!(str3 == null || "".equals(str3))) {
                        int i5 = jVar3.position;
                        String a3 = a(jVar3, stringBuilder2);
                        if (!";".equals(a3)) {
                            if ("}".equals(a3)) {
                                jVar3.cR(i5);
                            }
                        }
                        if ("color".equals(b)) {
                            dVar.ayT = d.Y(str3);
                            dVar.ayU = true;
                        } else if ("background-color".equals(b)) {
                            dVar.backgroundColor = d.Y(str3);
                            dVar.ayV = true;
                        } else if ("text-decoration".equals(b)) {
                            if ("underline".equals(str3)) {
                                dVar.ayX = 1;
                            }
                        } else if ("font-family".equals(b)) {
                            dVar.ayS = t.ai(str3);
                        } else if ("font-weight".equals(b)) {
                            if ("bold".equals(str3)) {
                                dVar.ayY = 1;
                            }
                        } else if ("font-style".equals(b) && "italic".equals(str3)) {
                            dVar.ayZ = 1;
                        }
                    }
                }
            }
        }
        return "}".equals(obj2) ? dVar : null;
    }

    private static void h(j jVar) {
        int i = 1;
        while (jVar.lF() > 0 && r0 != 0) {
            switch ((char) jVar.data[jVar.position]) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case ' ':
                    jVar.cV(1);
                    i = 1;
                    break;
                default:
                    i = 0;
                    break;
            }
            if (i == 0) {
                int i2 = jVar.position;
                i = jVar.asN;
                byte[] bArr = jVar.data;
                if (i2 + 2 <= i) {
                    int i3 = i2 + 1;
                    if (bArr[i2] == (byte) 47) {
                        i2 = i3 + 1;
                        if (bArr[i3] == (byte) 42) {
                            i3 = i2;
                            while (i3 + 1 < i) {
                                i2 = i3 + 1;
                                if (((char) bArr[i3]) == '*' && ((char) bArr[i2]) == '/') {
                                    i = i2 + 1;
                                    i2 = i;
                                }
                                i3 = i2;
                            }
                            jVar.cV(i - jVar.position);
                            i = 1;
                            if (i == 0) {
                                i = 0;
                            }
                        }
                    }
                }
                i = 0;
                if (i == 0) {
                    i = 0;
                }
            }
            i = 1;
        }
    }

    private static String a(j jVar, StringBuilder stringBuilder) {
        h(jVar);
        if (jVar.lF() == 0) {
            return null;
        }
        String b = b(jVar, stringBuilder);
        return "".equals(b) ? ((char) jVar.readUnsignedByte()) : b;
    }

    private static String b(j jVar, StringBuilder stringBuilder) {
        int i = 0;
        stringBuilder.setLength(0);
        int i2 = jVar.position;
        int i3 = jVar.asN;
        while (i2 < i3 && r0 == 0) {
            char c = (char) jVar.data[i2];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                i = 1;
            } else {
                i2++;
                stringBuilder.append(c);
            }
        }
        jVar.cV(i2 - jVar.position);
        return stringBuilder.toString();
    }
}
