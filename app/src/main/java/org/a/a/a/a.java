package org.a.a.a;

import java.io.File;

public final class a {
    public static final String Aye = Character.toString('.');
    private static final char Ayf;
    private static final char Ayg;

    static {
        char c = File.separatorChar;
        Ayf = c;
        if ((c == '\\' ? 1 : null) != null) {
            Ayg = '/';
        } else {
            Ayg = '\\';
        }
    }

    private static boolean isSeparator(char c) {
        return c == '/' || c == '\\';
    }

    private static String acz(String str) {
        char c = Ayf;
        if (str == null) {
            return null;
        }
        acB(str);
        int length = str.length();
        if (length == 0) {
            return str;
        }
        int acA = acA(str);
        if (acA < 0) {
            return null;
        }
        int i;
        int i2;
        Object obj = new char[(length + 2)];
        str.getChars(0, str.length(), obj, 0);
        char c2 = c == Ayf ? Ayg : Ayf;
        for (i = 0; i < obj.length; i++) {
            if (obj[i] == c2) {
                obj[i] = c;
            }
        }
        if (obj[length - 1] != c) {
            i2 = length + 1;
            obj[length] = c;
            i = i2;
            i2 = 0;
        } else {
            i2 = 1;
            i = length;
        }
        length = acA + 1;
        while (length < i) {
            if (obj[length] == c && obj[length - 1] == c) {
                System.arraycopy(obj, length, obj, length - 1, i - length);
                i--;
                length--;
            }
            length++;
        }
        length = acA + 1;
        while (length < i) {
            if (obj[length] == c && obj[length - 1] == '.' && (length == acA + 1 || obj[length - 2] == c)) {
                if (length == i - 1) {
                    i2 = 1;
                }
                System.arraycopy(obj, length + 1, obj, length - 1, i - length);
                i -= 2;
                length--;
            }
            length++;
        }
        length = acA + 2;
        while (length < i) {
            if (obj[length] == c && obj[length - 1] == '.' && obj[length - 2] == '.' && (length == acA + 2 || obj[length - 3] == c)) {
                if (length == acA + 2) {
                    return null;
                }
                if (length == i - 1) {
                    i2 = 1;
                }
                for (int i3 = length - 4; i3 >= acA; i3--) {
                    if (obj[i3] == c) {
                        System.arraycopy(obj, length + 1, obj, i3 + 1, i - length);
                        i -= length - i3;
                        length = i3 + 1;
                        break;
                    }
                }
                System.arraycopy(obj, length + 1, obj, acA, i - length);
                i -= (length + 1) - acA;
                length = acA + 1;
            }
            length++;
        }
        if (i <= 0) {
            return "";
        }
        if (i <= acA) {
            return new String(obj, 0, i);
        }
        return i2 != 0 ? new String(obj, 0, i) : new String(obj, 0, i - 1);
    }

    public static String gl(String str, String str2) {
        int acA = acA(str2);
        if (acA < 0) {
            return null;
        }
        if (acA > 0) {
            return acz(str2);
        }
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length == 0) {
            return acz(str2);
        }
        if (isSeparator(str.charAt(length - 1))) {
            return acz(str + str2);
        }
        return acz(str + '/' + str2);
    }

    private static int acA(String str) {
        if (str == null) {
            return -1;
        }
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        char charAt = str.charAt(0);
        if (charAt == ':') {
            return -1;
        }
        if (length == 1) {
            if (charAt == '~') {
                return 2;
            }
            if (isSeparator(charAt)) {
                return 1;
            }
            return 0;
        } else if (charAt == '~') {
            r1 = str.indexOf(47, 1);
            r0 = str.indexOf(92, 1);
            if (r1 == -1 && r0 == -1) {
                return length + 1;
            }
            if (r1 == -1) {
                r1 = r0;
            }
            if (r0 == -1) {
                r0 = r1;
            }
            return Math.min(r1, r0) + 1;
        } else {
            char charAt2 = str.charAt(1);
            if (charAt2 == ':') {
                char toUpperCase = Character.toUpperCase(charAt);
                if (toUpperCase < 'A' || toUpperCase > 'Z') {
                    if (toUpperCase == '/') {
                        return 1;
                    }
                    return -1;
                } else if (length == 2 || !isSeparator(str.charAt(2))) {
                    return 2;
                } else {
                    return 3;
                }
            } else if (isSeparator(charAt) && isSeparator(charAt2)) {
                int indexOf = str.indexOf(47, 2);
                r0 = str.indexOf(92, 2);
                if ((indexOf == -1 && r0 == -1) || indexOf == 2 || r0 == 2) {
                    return -1;
                }
                if (indexOf == -1) {
                    r1 = r0;
                } else {
                    r1 = indexOf;
                }
                if (r0 == -1) {
                    r0 = r1;
                }
                return Math.min(r1, r0) + 1;
            } else if (isSeparator(charAt)) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        acB(str);
        return str.substring((str == null ? -1 : Math.max(str.lastIndexOf(47), str.lastIndexOf(92))) + 1);
    }

    private static void acB(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == '\u0000') {
                throw new IllegalArgumentException("Null byte present in file/path name. There are no known legitimate use cases for such data, but several injection attacks may use it");
            }
        }
    }
}
