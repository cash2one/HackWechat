package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.u;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;
import org.json.JSONObject;

public final class ax extends a {
    public static final int CTRL_BYTE = 275;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "shareEmoticon";

    public final void a(Context context, String str, GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiShareEmotion", "invoke");
        JSONObject sc = d.sc(str);
        if (sc == null) {
            x.e("MicroMsg.GameJsApiShareEmotion", "data is null");
            aVar.sj(a.e("shareEmoticon:fail_null_data", null));
            return;
        }
        String optString = sc.optString("base64DataString");
        String optString2 = sc.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        String H;
        if (bh.ov(optString)) {
            x.i("MicroMsg.GameJsApiShareEmotion", "doShareEmoticon use url:%s", new Object[]{optString2});
            File file = new File(context.getCacheDir(), g.s(optString2.getBytes()));
            if (file.exists()) {
                optString2 = g.i(file);
                ar.Hg();
                H = EmojiLogic.H(c.Fp(), "", optString2);
                if (!FileOp.bO(H)) {
                    FileOp.x(file.getAbsolutePath(), H);
                }
                b(context, optString2, aVar);
                return;
            }
            com.tencent.mm.aq.a.a.c.a aVar2 = new com.tencent.mm.aq.a.a.c.a();
            aVar2.hDA = true;
            aVar2.hDC = file.getAbsolutePath();
            aVar2.hEd = new Object[]{file.getAbsolutePath()};
            i.aBe().a(optString2, null, aVar2.PK(), new 1(this, optString2, context, aVar));
            return;
        }
        x.i("MicroMsg.GameJsApiShareEmotion", "use base64DataString");
        int indexOf = optString.indexOf(";base64,");
        optString2 = "";
        if (indexOf != -1) {
            optString2 = optString.substring(indexOf + 8, optString.length());
        }
        try {
            byte[] decode = Base64.decode(optString2, 0);
            if (bh.bw(decode)) {
                aVar.sj(a.e("shareEmoticon:fail", null));
                return;
            }
            optString = g.s(decode);
            ar.Hg();
            H = EmojiLogic.H(c.Fp(), "", optString);
            if (!(e.bO(H) && g.bV(H).equalsIgnoreCase(optString))) {
                e.b(H, decode, decode.length);
            }
            b(context, optString, aVar);
        } catch (Exception e) {
            x.e("MicroMsg.GameJsApiShareEmotion", "doShareEmoticon error:" + e.getMessage());
            aVar.sj(a.e("shareEmoticon:fail_base64_decode_fail", null));
        }
    }

    final void b(Context context, String str, GameJsApiMMTask.a aVar) {
        Intent intent = new Intent();
        intent.putExtra("scene_from", 4);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Msg_thumb_path", str);
        intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
        if (context instanceof MMActivity) {
            ((MMActivity) context).jwN = new 2(this, aVar);
            com.tencent.mm.bm.d.a(context, ".ui.transmit.SelectConversationUI", intent, hashCode() & 65535);
        }
    }
}
