package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class ax$2 implements a {
    final /* synthetic */ GameJsApiMMTask.a mWu;
    final /* synthetic */ ax mXk;

    ax$2(ax axVar, GameJsApiMMTask.a aVar) {
        this.mXk = axVar;
        this.mWu = aVar;
    }

    public final void b(int i, int i2, Intent intent) {
        x.i("MicroMsg.GameJsApiShareEmotion", "mmOnActivityResult, %d", new Object[]{Integer.valueOf(i)});
        if (i == (this.mXk.hashCode() & 65535)) {
            x.i("MicroMsg.GameJsApiShareEmotion", "share emmotion resultCode: %d", new Object[]{Integer.valueOf(i2)});
            GameJsApiMMTask.a aVar;
            ax axVar;
            switch (i2) {
                case -1:
                    EmojiInfo b;
                    String az = bh.az(intent.getStringExtra("Select_Conv_User"), "");
                    String az2 = bh.az(intent.getStringExtra("emoji_thumb_path"), "");
                    EmojiInfo XU = i.aBE().lwL.XU(az2);
                    if (XU == null) {
                        ar.Hg();
                        String H = EmojiLogic.H(c.Fp(), "", az2);
                        if (e.bO(H)) {
                            b = i.aBE().lwL.b(az2, "", EmojiInfo.xAe, p.UR(H) ? EmojiInfo.xAm : EmojiInfo.xAl, e.bN(H), "");
                            for (String str : bh.F(bh.az(az, "").split(","))) {
                                if (b != null) {
                                    i.aBA().a(str, b, null);
                                }
                            }
                            aVar = this.mWu;
                            axVar = this.mXk;
                            aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("shareEmoticon:ok", null));
                            return;
                        }
                    }
                    b = XU;
                    for (String str2 : bh.F(bh.az(az, "").split(","))) {
                        if (b != null) {
                            i.aBA().a(str2, b, null);
                        }
                    }
                    aVar = this.mWu;
                    axVar = this.mXk;
                    aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("shareEmoticon:ok", null));
                    return;
                case 0:
                    aVar = this.mWu;
                    axVar = this.mXk;
                    aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("shareEmoticon:ok", null));
                    return;
                default:
                    aVar = this.mWu;
                    axVar = this.mXk;
                    aVar.sj(com.tencent.mm.plugin.game.gamewebview.jsapi.a.e("shareEmoticon:ok", null));
                    return;
            }
        }
    }
}
