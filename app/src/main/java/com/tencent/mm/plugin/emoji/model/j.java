package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.z.ar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class j {
    Set<String> lyk;
    Set<String> lyl;
    Set<String> lym;
    c lyn = new 1(this);
    c lyo = new 2(this);

    public j() {
        a.xef.b(this.lyn);
        a.xef.b(this.lyo);
        this.lyk = Collections.synchronizedSet(new HashSet());
        this.lyl = Collections.synchronizedSet(new HashSet());
        this.lym = Collections.synchronizedSet(new HashSet());
    }

    final void aBI() {
        while (!this.lyl.isEmpty()) {
            if (this.lym.isEmpty()) {
                Iterator it = this.lyl.iterator();
                if (it != null) {
                    String str = (String) it.next();
                    this.lyl.remove(str);
                    EmojiGroupInfo bf = i.aBE().lwM.bf(str, true);
                    if (bf == null || (bf.field_flag & 256) <= 0) {
                        x.i("MicroMsg.emoji.WearEmojiLogic", "start to download emoji %s", new Object[]{str});
                        this.lym.add(str);
                        ar.CG().a(new g(str, ""), 0);
                        return;
                    }
                    x.i("MicroMsg.emoji.WearEmojiLogic", "emoji already exist %s", new Object[]{str});
                } else {
                    return;
                }
            }
            x.i("MicroMsg.emoji.WearEmojiLogic", "downloading emoji %s", new Object[]{this.lym.toString()});
            return;
        }
        x.i("MicroMsg.emoji.WearEmojiLogic", "no emoji need download");
    }
}
