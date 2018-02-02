package com.tencent.mm.modelsfs;

import java.util.EnumSet;
import org.xwalk.core.R$styleable;

final class g {

    public enum a {
        NOESCAPE,
        PATHNAME,
        PERIOD,
        LEADING_DIR,
        CASEFOLD
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(String str, int i, String str2, int i2, EnumSet<a> enumSet) {
        while (i < str.length()) {
            int i3 = i + 1;
            char charAt = str.charAt(i);
            switch (charAt) {
                case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                    i = i3;
                    char c = charAt;
                    while (i < str.length()) {
                        c = str.charAt(i);
                        if (c == '*') {
                            i++;
                        } else if (a(str2, i2, enumSet)) {
                            return false;
                        } else {
                            if (i != str.length()) {
                                if (enumSet.contains(a.PATHNAME)) {
                                    return true;
                                }
                                return enumSet.contains(a.LEADING_DIR) || str2.indexOf(47, i2) == -1;
                            } else if (c == '/' || !enumSet.contains(a.PATHNAME)) {
                                while (i2 < str2.length()) {
                                    if (enumSet.contains(a.PERIOD)) {
                                        enumSet = EnumSet.copyOf(enumSet);
                                        enumSet.remove(a.PERIOD);
                                    }
                                    if (a(str, i, str2, i2, enumSet)) {
                                        return true;
                                    }
                                    if (str2.charAt(i2) != '/' && enumSet.contains(a.PATHNAME)) {
                                        return false;
                                    }
                                    i2++;
                                }
                                return false;
                            } else {
                                i2 = str2.indexOf(47, i2);
                                if (i2 == -1) {
                                    return false;
                                }
                                continue;
                            }
                        }
                    }
                    if (a(str2, i2, enumSet)) {
                        return false;
                    }
                    if (i != str.length()) {
                        if (c == '/') {
                            break;
                        }
                        while (i2 < str2.length()) {
                            if (enumSet.contains(a.PERIOD)) {
                                enumSet = EnumSet.copyOf(enumSet);
                                enumSet.remove(a.PERIOD);
                            }
                            if (a(str, i, str2, i2, enumSet)) {
                                return true;
                            }
                            if (str2.charAt(i2) != '/') {
                                break;
                            }
                            i2++;
                        }
                        return false;
                    } else if (enumSet.contains(a.PATHNAME)) {
                        return true;
                    } else {
                        if (!enumSet.contains(a.LEADING_DIR)) {
                            break;
                        }
                    }
                case '?':
                    if (i2 >= str2.length()) {
                        return false;
                    }
                    if (str2.charAt(i2) == '/' && enumSet.contains(a.PATHNAME)) {
                        return false;
                    }
                    if (a(str2, i2, enumSet)) {
                        return false;
                    }
                    i2++;
                    i = i3;
                    continue;
                case '[':
                    if (i2 >= str2.length()) {
                        return false;
                    }
                    if (str2.charAt(i2) == '/' && enumSet.contains(a.PATHNAME)) {
                        return false;
                    }
                    if (a(str2, i2, enumSet)) {
                        return false;
                    }
                    char charAt2 = str2.charAt(i2);
                    if (i3 >= str.length()) {
                        i = -1;
                    } else {
                        int i4;
                        char charAt3 = str.charAt(i3);
                        Object obj = (charAt3 == '!' || charAt3 == '^') ? 1 : null;
                        if (obj != null) {
                            i4 = i3 + 1;
                        } else {
                            i4 = i3;
                        }
                        if (enumSet.contains(a.CASEFOLD)) {
                            charAt2 = Character.toLowerCase(charAt2);
                        }
                        int i5 = i4;
                        Object obj2 = null;
                        while (i5 < str.length()) {
                            i = i5 + 1;
                            char charAt4 = str.charAt(i5);
                            if (charAt4 != ']') {
                                if (charAt4 != '\\' || enumSet.contains(a.NOESCAPE)) {
                                    i5 = i;
                                } else {
                                    i5 = i + 1;
                                    charAt4 = str.charAt(i);
                                }
                                if (charAt4 == '/' && enumSet.contains(a.PATHNAME)) {
                                    i = 0;
                                } else {
                                    if (enumSet.contains(a.CASEFOLD)) {
                                        charAt4 = Character.toLowerCase(charAt4);
                                    }
                                    if (str.charAt(i5) == '-' && i5 + 1 < str.length()) {
                                        char charAt5 = str.charAt(i5 + 1);
                                        if (charAt5 != ']') {
                                            int i6 = i5 + 2;
                                            if (charAt5 != '\\' || enumSet.contains(a.NOESCAPE)) {
                                                i5 = i6;
                                            } else if (i6 >= str.length()) {
                                                i = -1;
                                            } else {
                                                i5 = i6 + 1;
                                                charAt4 = str.charAt(i6);
                                            }
                                            char toLowerCase;
                                            if (enumSet.contains(a.CASEFOLD)) {
                                                toLowerCase = Character.toLowerCase(charAt5);
                                            } else {
                                                toLowerCase = charAt5;
                                            }
                                            if (charAt4 <= charAt2 && charAt2 <= r6) {
                                                obj2 = 1;
                                            }
                                        }
                                    }
                                    if (charAt4 == charAt2) {
                                        obj2 = 1;
                                    }
                                }
                            } else if (obj2 == obj) {
                                i = 0;
                            }
                        }
                        i = -1;
                    }
                    if (i != -1) {
                        if (i == 0) {
                            return false;
                        }
                        i2++;
                        continue;
                    }
                    break;
                case '\\':
                    if (!enumSet.contains(a.NOESCAPE)) {
                        if (i3 < str.length()) {
                            i = i3 + 1;
                            charAt = str.charAt(i3);
                            break;
                        }
                        charAt = '\\';
                        i = i3;
                        break;
                    }
            }
            i = i3;
            if (i2 >= str2.length()) {
                return false;
            }
            if (charAt != str2.charAt(i2) && (!enumSet.contains(a.CASEFOLD) || Character.toLowerCase(charAt) != Character.toLowerCase(str2.charAt(i2)))) {
                return false;
            }
            i2++;
        }
        if (enumSet.contains(a.LEADING_DIR) && str2.charAt(i2) == '/') {
            return true;
        }
        return i2 == str2.length();
    }

    private static boolean a(String str, int i, EnumSet<a> enumSet) {
        if (i > str.length() - 1) {
            return false;
        }
        if ((i == 0 || (enumSet.contains(a.PATHNAME) && str.charAt(i - 1) == '/')) && str.charAt(i) == '.' && enumSet.contains(a.PERIOD)) {
            return true;
        }
        return false;
    }
}
