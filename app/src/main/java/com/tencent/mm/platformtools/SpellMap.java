package com.tencent.mm.platformtools;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class SpellMap {
    public static HashMap<String, String> icD = new HashMap();

    public static native String spellGetJni(int i, int i2);

    public static String g(char c) {
        int h = h(c);
        if (h < 65536) {
            return String.valueOf(c);
        }
        int i = h >> 16;
        h &= 255;
        String spellGetJni = (i < 129 || i > 253) ? null : (h < 63 || h > i.CTRL_BYTE) ? null : spellGetJni(i - 129, h - 63);
        if (spellGetJni == null) {
            return null;
        }
        String[] split = spellGetJni.split(",");
        if (split == null || split.length < 2) {
            return spellGetJni;
        }
        return split[0];
    }

    private static int h(char c) {
        if (c <= '') {
            return c;
        }
        try {
            byte[] bytes = String.valueOf(c).getBytes("GBK");
            if (bytes == null || bytes.length > 2 || bytes.length <= 0) {
                return '\u0000';
            }
            if (bytes.length == 1) {
                return bytes[0];
            }
            return bytes.length == 2 ? ((bytes[0] + 256) << 16) + (bytes[1] + 256) : '\u0000';
        } catch (UnsupportedEncodingException e) {
            return '\u0000';
        }
    }
}
