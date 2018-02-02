package android.support.a.a;

import android.graphics.Path;
import java.util.ArrayList;
import org.xwalk.core.R$styleable;

final class c {

    private static class a {
        int mj;
        boolean mk;

        private a() {
        }
    }

    public static class b {
        char ml;
        float[] mm;

        private b(char c, float[] fArr) {
            this.ml = c;
            this.mm = fArr;
        }

        private b(b bVar) {
            this.ml = bVar.ml;
            this.mm = c.copyOfRange(bVar.mm, 0, bVar.mm.length);
        }

        static void a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double toRadians;
            double cos;
            double sin;
            double d;
            double d2;
            double d3;
            double d4;
            double d5;
            double d6;
            double d7;
            double d8;
            double d9;
            Path path2 = path;
            while (true) {
                toRadians = Math.toRadians((double) f7);
                cos = Math.cos(toRadians);
                sin = Math.sin(toRadians);
                d = ((((double) f) * cos) + (((double) f2) * sin)) / ((double) f5);
                d2 = ((((double) (-f)) * sin) + (((double) f2) * cos)) / ((double) f6);
                d3 = ((((double) f3) * cos) + (((double) f4) * sin)) / ((double) f5);
                d4 = ((((double) (-f3)) * sin) + (((double) f4) * cos)) / ((double) f6);
                d5 = d - d3;
                d6 = d2 - d4;
                d7 = (d + d3) / 2.0d;
                double d10 = (d2 + d4) / 2.0d;
                d8 = (d5 * d5) + (d6 * d6);
                if (d8 != 0.0d) {
                    d9 = (1.0d / d8) - 0.25d;
                    if (d9 >= 0.0d) {
                        break;
                    }
                    float sqrt = (float) (Math.sqrt(d8) / 1.99999d);
                    f5 *= sqrt;
                    f6 *= sqrt;
                } else {
                    return;
                }
            }
            d8 = Math.sqrt(d9);
            d5 *= d8;
            d6 *= d8;
            if (z == z2) {
                d6 = d7 - d6;
                d5 += d10;
            } else {
                d6 += d7;
                d5 = d10 - d5;
            }
            d7 = Math.atan2(d2 - d5, d - d6);
            d3 = Math.atan2(d4 - d5, d3 - d6) - d7;
            if (z2 != (d3 >= 0.0d)) {
                if (d3 > 0.0d) {
                    d3 -= 6.283185307179586d;
                } else {
                    d3 += 6.283185307179586d;
                }
            }
            d6 *= (double) f5;
            d = ((double) f6) * d5;
            a(path2, (d6 * cos) - (d * sin), (d6 * sin) + (cos * d), (double) f5, (double) f6, (double) f, (double) f2, toRadians, d7, d3);
        }

        private static void a(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            int ceil = (int) Math.ceil(Math.abs((4.0d * d9) / 3.141592653589793d));
            double cos = Math.cos(d7);
            double sin = Math.sin(d7);
            double cos2 = Math.cos(d8);
            double sin2 = Math.sin(d8);
            double d10 = (((-d3) * cos) * sin2) - ((d4 * sin) * cos2);
            cos2 = (cos2 * (d4 * cos)) + (sin2 * ((-d3) * sin));
            double d11 = d9 / ((double) ceil);
            int i = 0;
            while (i < ceil) {
                double d12 = d8 + d11;
                sin2 = Math.sin(d12);
                double cos3 = Math.cos(d12);
                double d13 = (((d3 * cos) * cos3) + d) - ((d4 * sin) * sin2);
                double d14 = ((d4 * cos) * sin2) + (((d3 * sin) * cos3) + d2);
                double d15 = (((-d3) * cos) * sin2) - ((d4 * sin) * cos3);
                cos3 = (cos3 * (d4 * cos)) + (sin2 * ((-d3) * sin));
                sin2 = Math.tan((d12 - d8) / 2.0d);
                sin2 = ((Math.sqrt((sin2 * (3.0d * sin2)) + 4.0d) - 1.0d) * Math.sin(d12 - d8)) / 3.0d;
                Path path2 = path;
                path2.cubicTo((float) ((d10 * sin2) + d5), (float) (d6 + (cos2 * sin2)), (float) (d13 - (sin2 * d15)), (float) (d14 - (sin2 * cos3)), (float) d13, (float) d14);
                d10 = d15;
                d8 = d12;
                i++;
                d6 = d14;
                d5 = d13;
                cos2 = cos3;
            }
        }
    }

    static float[] copyOfRange(float[] fArr, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 + 0;
        length = Math.min(i3, length + 0);
        Object obj = new float[i3];
        System.arraycopy(fArr, 0, obj, 0, length);
        return obj;
    }

    public static b[] h(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int f = f(str, i);
            String trim = str.substring(i2, f).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), i(trim));
            }
            i = f + 1;
            i2 = f;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    public static b[] a(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr2[i] = new b(bVarArr[i]);
        }
        return bVarArr2;
    }

    private static int f(String str, int i) {
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (((charAt - 65) * (charAt - 90) <= 0 || (charAt - 97) * (charAt - 122) <= 0) && charAt != 'e' && charAt != 'E') {
                break;
            }
            i++;
        }
        return i;
    }

    private static void a(ArrayList<b> arrayList, char c, float[] fArr) {
        arrayList.add(new b(c, fArr));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static float[] i(String str) {
        if (((str.charAt(0) == 'z' ? 1 : 0) | (str.charAt(0) == 'Z' ? 1 : 0)) != 0) {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                aVar.mk = false;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = i;
                while (i6 < str.length()) {
                    switch (str.charAt(i6)) {
                        case ' ':
                        case R$styleable.AppCompatTheme_listDividerAlertDialog /*44*/:
                            i5 = i4;
                            i3 = 1;
                            i4 = 0;
                            break;
                        case R$styleable.AppCompatTheme_actionDropDownStyle /*45*/:
                            if (i6 != i && r5 == 0) {
                                aVar.mk = true;
                                i5 = i4;
                                i3 = 1;
                                i4 = 0;
                                break;
                            }
                        case '.':
                            if (i4 != 0) {
                                aVar.mk = true;
                                i5 = i4;
                                i3 = 1;
                                i4 = 0;
                                break;
                            }
                            i4 = 0;
                            i3 = i5;
                            i5 = 1;
                            break;
                        case 'E':
                        case 'e':
                            i3 = i5;
                            i5 = i4;
                            i4 = 1;
                            break;
                        default:
                            i3 = i5;
                            i5 = i4;
                            i4 = 0;
                            break;
                    }
                    if (i3 == 0) {
                        i6++;
                        int i7 = i4;
                        i4 = i5;
                        i5 = i3;
                        i3 = i7;
                    } else {
                        aVar.mj = i6;
                        i5 = aVar.mj;
                        if (i >= i5) {
                            i4 = i2 + 1;
                            fArr[i2] = Float.parseFloat(str.substring(i, i5));
                        } else {
                            i4 = i2;
                        }
                        if (aVar.mk) {
                            i = i5 + 1;
                            i2 = i4;
                        } else {
                            i = i5;
                            i2 = i4;
                        }
                    }
                }
                aVar.mj = i6;
                i5 = aVar.mj;
                if (i >= i5) {
                    i4 = i2;
                } else {
                    i4 = i2 + 1;
                    fArr[i2] = Float.parseFloat(str.substring(i, i5));
                }
                if (aVar.mk) {
                    i = i5 + 1;
                    i2 = i4;
                } else {
                    i = i5;
                    i2 = i4;
                }
            }
            return copyOfRange(fArr, 0, i2);
        } catch (Throwable e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }
}
