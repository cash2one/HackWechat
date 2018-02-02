package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.util.Base64;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.a.a.c$a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.q;
import java.io.File;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_BYTE = 274;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "addToEmoticon";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiAddToEmotion", "invoke");
        JSONObject sc = d.sc(str);
        if (sc == null) {
            x.e("MicroMsg.GameJsApiAddToEmotion", "bundle is null");
            aVar.sj(a.e("addToEmoticon:fail_null_data", null));
            return;
        }
        String optString = sc.optString("base64DataString");
        String optString2 = sc.optString("thumbUrl");
        String optString3 = sc.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (!bh.ov(optString)) {
            x.i("MicroMsg.GameJsApiAddToEmotion", "doAddToEmoticon use base64DataString");
            int indexOf = optString.indexOf(";base64,");
            String str2 = "";
            if (indexOf != -1) {
                str2 = optString.substring(indexOf + 8, optString.length());
            }
            try {
                byte[] decode = Base64.decode(str2, 0);
                if (bh.bw(decode)) {
                    aVar.sj(a.e("addToEmoticon:fail", null));
                    return;
                }
                optString = g.s(decode);
                ar.Hg();
                optString3 = EmojiLogic.H(com.tencent.mm.z.c.Fp(), "", optString);
                if (!(e.bO(optString3) && g.bV(optString3).equalsIgnoreCase(optString))) {
                    e.b(optString3, decode, decode.length);
                }
                a(context, optString, optString2, aVar);
            } catch (Exception e) {
                x.e("MicroMsg.GameJsApiAddToEmotion", "doAddToEmoticon error:" + e.getMessage());
                aVar.sj(a.e("addToEmoticon:fail", null));
            }
        } else if (bh.ov(optString3)) {
            x.e("MicroMsg.GameJsApiAddToEmotion", "doAddToEmoticon base64DataString is null and url is null");
            aVar.sj(a.e("addToEmoticon:fail_base64DataString_and_url_is_null", null));
        } else {
            x.i("MicroMsg.GameJsApiAddToEmotion", "doAddToEmoticon use url:%s", new Object[]{optString3});
            File file = new File(context.getCacheDir(), g.s(optString3.getBytes()));
            if (file.exists()) {
                optString = g.i(file);
                ar.Hg();
                optString3 = EmojiLogic.H(com.tencent.mm.z.c.Fp(), "", optString);
                if (!FileOp.bO(optString3)) {
                    FileOp.x(file.getAbsolutePath(), optString3);
                }
                a(context, optString, optString2, aVar);
                return;
            }
            c$a com_tencent_mm_aq_a_a_c_a = new c$a();
            com_tencent_mm_aq_a_a_c_a.hDA = true;
            com_tencent_mm_aq_a_a_c_a.hDC = file.getAbsolutePath();
            com_tencent_mm_aq_a_a_c_a.hEd = new Object[]{file.getAbsolutePath()};
            i.aBe().a(optString3, null, com_tencent_mm_aq_a_a_c_a.PK(), new 1(this, optString3, context, optString2, aVar));
        }
    }

    void a(Context context, String str, String str2, GameJsApiMMTask.a aVar) {
        ar.Hg();
        String H = EmojiLogic.H(com.tencent.mm.z.c.Fp(), "", str);
        EmojiInfo XU = i.aBE().lwL.XU(str);
        if (XU == null && e.bO(H)) {
            int i = p.UR(H) ? EmojiInfo.xAm : EmojiInfo.xAl;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = str;
            emojiInfo.field_catalog = EmojiInfo.xAe;
            emojiInfo.field_type = i;
            emojiInfo.field_size = e.bN(H);
            emojiInfo.field_temp = 1;
            emojiInfo.field_thumbUrl = str2;
            i.aBE().lwL.n(emojiInfo);
            XU = emojiInfo;
        }
        if (XU != null) {
            x.i("MicroMsg.GameJsApiAddToEmotion", "doAddAction %b", new Object[]{Boolean.valueOf(i.aBA().a(context, XU, 18, q.FS()))});
            if (i.aBA().a(context, XU, 18, q.FS())) {
                aVar.sj(a.e("addToEmoticon:ok", null));
                return;
            } else {
                aVar.sj(a.e("addToEmoticon:fail", null));
                return;
            }
        }
        aVar.sj(a.e("addToEmoticon:fail", null));
    }
}
