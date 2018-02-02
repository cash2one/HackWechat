package com.tencent.mm.plugin.emoji.e;

import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.m;
import java.util.HashMap;

public final class j {
    public int kFr = 79;
    public boolean lwq = true;
    public long lwr = 863913600000L;
    public int lws = 19;
    public m lwt;
    public HashMap<String, m> lwu = new HashMap();

    public final void aBi() {
        if (this.lwt != null) {
            this.lwt.field_continuCount = 0;
            this.lwu.put(this.lwt.field_prodcutID, this.lwt);
            i.aBE().lwS.a(this.lwt);
            this.lwt = null;
        }
    }

    public final void a(m mVar, boolean z) {
        if (mVar == null) {
            x.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateLastRewardTipInfo failed. reward tip info is null.");
            return;
        }
        int i = (this.lwt == null || this.lwt.field_prodcutID.equalsIgnoreCase(mVar.field_prodcutID)) ? 1 : 0;
        if (i == 0) {
            this.lwt.field_continuCount = 0;
            this.lwu.put(this.lwt.field_prodcutID, this.lwt);
            i.aBE().lwS.a(this.lwt);
        }
        this.lwt = mVar;
        if (z) {
            this.lwt.field_modifyTime = 0;
            this.lwt.field_showTipsTime = System.currentTimeMillis();
            this.lwt.field_totalCount = 0;
            this.lwt.field_continuCount = 0;
        } else {
            if (i != 0) {
                this.lwt.field_continuCount++;
            } else {
                this.lwt.field_continuCount = 1;
            }
            this.lwt.field_totalCount++;
            this.lwt.field_modifyTime = System.currentTimeMillis();
        }
        this.lwu.put(this.lwt.field_prodcutID, this.lwt);
        i.aBE().lwS.a(this.lwt);
    }

    public final void be(String str, int i) {
        if (bh.ov(str)) {
            x.w("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag failed. no such product id.");
        } else if (this.lwu == null || !this.lwu.containsKey(str)) {
            x.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateProductFlag map no contains this product id :%s", new Object[]{str});
        } else {
            ((m) this.lwu.get(str)).field_flag = i;
            ((m) this.lwu.get(str)).field_setFlagTime = System.currentTimeMillis();
        }
    }
}
