package com.tencent.mm.plugin.emoji;

import android.content.Context;
import com.tencent.mm.bx.f;
import com.tencent.mm.bx.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.ui.e.c.a;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PluginEmoji$2 implements a {
    final /* synthetic */ PluginEmoji lte;

    PluginEmoji$2(PluginEmoji pluginEmoji) {
        this.lte = pluginEmoji;
    }

    public final CharSequence a(Context context, CharSequence charSequence, int i) {
        return g.chg().b(context, charSequence, i);
    }

    public final CharSequence c(Context context, CharSequence charSequence, float f) {
        return g.chg().a(context, charSequence, f);
    }

    public final int bb(String str, int i) {
        g.chg();
        f chd = f.chd();
        if (bh.ov(str)) {
            return i;
        }
        int length = str.length();
        if (i == 0 || i == length) {
            return i;
        }
        int i2;
        if (f.xlh == null) {
            StringBuilder stringBuilder = new StringBuilder();
            int length2 = chd.xkX.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(chd.xkX[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            length2 = chd.xkY.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(chd.xkY[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            length2 = chd.xkZ.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(chd.xkZ[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            length2 = chd.xla.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(chd.xla[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            length2 = chd.xlb.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(chd.xlb[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            length2 = chd.xlc.length;
            for (i2 = 0; i2 < length2; i2++) {
                stringBuilder.append(Pattern.quote(chd.xlc[i2]));
                if (i2 != length2 - 1) {
                    stringBuilder.append('|');
                }
            }
            if (!(chd.xld == null || chd.xld.isEmpty())) {
                Iterator it = chd.xld.iterator();
                while (it.hasNext()) {
                    q qVar = (q) it.next();
                    stringBuilder.append(Pattern.quote(qVar.field_key)).append("|");
                    if (!bh.ov(qVar.field_cnValue)) {
                        stringBuilder.append(Pattern.quote(qVar.field_cnValue)).append("|");
                    }
                    if (!bh.ov(qVar.field_enValue)) {
                        stringBuilder.append(Pattern.quote(qVar.field_enValue)).append("|");
                    }
                    if (!bh.ov(qVar.field_qqValue)) {
                        stringBuilder.append(Pattern.quote(qVar.field_qqValue)).append("|");
                    }
                    if (!bh.ov(qVar.field_twValue)) {
                        stringBuilder.append(Pattern.quote(qVar.field_twValue)).append("|");
                    }
                    if (!bh.ov(qVar.field_thValue)) {
                        stringBuilder.append(Pattern.quote(qVar.field_thValue)).append("|");
                    }
                }
            }
            f.xlh = Pattern.compile(stringBuilder.toString());
        }
        Matcher matcher = f.xlh.matcher(str.substring(i < 6 ? 0 : i - 6, i + 6 >= length ? length - 1 : i + 6));
        while (matcher.find()) {
            if (6 > matcher.start() && 6 < matcher.end()) {
                i2 = matcher.start();
                break;
            }
        }
        i2 = 6;
        return i + (i2 + -6 > 0 ? i2 - 6 : 0);
    }
}
