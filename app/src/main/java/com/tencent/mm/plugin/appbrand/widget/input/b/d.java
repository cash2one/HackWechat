package com.tencent.mm.plugin.appbrand.widget.input.b;

import com.tencent.mm.sdk.platformtools.bh;

public final class d {
    static <T extends Enum> T h(String str, Class<T> cls) {
        int i;
        if (cls.isEnum()) {
            int i2 = 0;
            for (Object obj : cls.getEnumConstants()) {
                i2 = Math.max(((Enum) obj).name().length(), i2);
            }
            i = i2;
        } else {
            i = 0;
        }
        if (bh.ov(str) || str.length() > r0) {
            return null;
        }
        String toUpperCase = str.toUpperCase();
        for (Enum enumR : (Enum[]) cls.getEnumConstants()) {
            if (toUpperCase.equals(enumR.name())) {
                return enumR;
            }
        }
        return null;
    }

    public static Integer bn(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            try {
                return Integer.valueOf((int) Double.parseDouble((String) obj));
            } catch (NumberFormatException e) {
            }
        }
        return null;
    }
}
