package com.google.android.gms.tagmanager;

import com.google.android.gms.c.b.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

final class ak {
    private static v<a> a(v<a> vVar) {
        try {
            return new v(ai.an(URLEncoder.encode(ai.b((a) vVar.bbL), "UTF-8").replaceAll("\\+", "%20")), vVar.bbM);
        } catch (UnsupportedEncodingException e) {
            m.qD();
            return vVar;
        }
    }

    static v<a> a(v<a> vVar, int... iArr) {
        int length = iArr.length;
        int i = 0;
        v<a> vVar2 = vVar;
        while (i < length) {
            v<a> a;
            int i2 = iArr[i];
            if (ai.d((a) vVar2.bbL) instanceof String) {
                switch (i2) {
                    case 12:
                        a = a(vVar2);
                        break;
                    default:
                        new StringBuilder("Unsupported Value Escaping: ").append(i2);
                        m.qC();
                        a = vVar2;
                        break;
                }
            }
            m.qC();
            a = vVar2;
            i++;
            vVar2 = a;
        }
        return vVar2;
    }
}
