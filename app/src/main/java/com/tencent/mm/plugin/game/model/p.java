package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URI;

public final class p {
    public static String a(String str, t tVar) {
        boolean z;
        Uri parse;
        String query;
        String str2;
        if (tVar != null) {
            tVar.aQm();
            if (!bh.ov(tVar.ncA.url)) {
                z = true;
                x.i("MicroMsg.GameFloatUtil", "hasFloatLayer = " + z);
                if (z) {
                    parse = Uri.parse(str);
                    query = parse.getQuery();
                    if (query == null) {
                        str2 = query + "&h5FloatLayer=1";
                    } else {
                        str2 = "h5FloatLayer=1";
                    }
                    try {
                        str = new URI(parse.getScheme(), parse.getAuthority(), parse.getPath(), str2, parse.getFragment()).toString();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.GameFloatUtil", e, "", new Object[0]);
                    }
                }
                x.i("MicroMsg.GameFloatUtil", "abtest, url = %s", new Object[]{str});
                return str;
            }
        }
        z = false;
        x.i("MicroMsg.GameFloatUtil", "hasFloatLayer = " + z);
        if (z) {
            parse = Uri.parse(str);
            query = parse.getQuery();
            if (query == null) {
                str2 = "h5FloatLayer=1";
            } else {
                str2 = query + "&h5FloatLayer=1";
            }
            str = new URI(parse.getScheme(), parse.getAuthority(), parse.getPath(), str2, parse.getFragment()).toString();
        }
        x.i("MicroMsg.GameFloatUtil", "abtest, url = %s", new Object[]{str});
        return str;
    }

    public static void a(Context context, String str, String str2, boolean z, t tVar, int i) {
        if (!bh.ov(str)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("geta8key_scene", 32);
            intent.putExtra("KPublisherId", str2);
            intent.putExtra("game_check_float", z);
            if (z && tVar != null) {
                tVar.aQm();
                if (tVar.ncA.ncX) {
                    intent.putExtra("game_transparent_float_url", tVar.ncA.url);
                }
                intent.putExtra("game_sourceScene", i);
            }
            c.y(intent, context);
        }
    }
}
