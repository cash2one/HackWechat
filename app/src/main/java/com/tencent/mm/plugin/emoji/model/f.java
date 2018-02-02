package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public int lxB;
    public List<com.tencent.mm.plugin.emoji.a.a.f> lxC;
    public sd lxD;
    public List<sd> lxE;
    public List<sf> lxF;
    public List<sf> lxG;

    public final void oL(int i) {
        this.lxB += i;
    }

    public final void aBv() {
        if (this.lxG != null && !this.lxG.isEmpty()) {
            List arrayList = new ArrayList();
            arrayList.addAll(this.lxG);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.lxC.add(0, new com.tencent.mm.plugin.emoji.a.a.f((sf) arrayList.get(size)));
                this.lxB++;
                this.lxG.remove(arrayList.get(size));
            }
        }
    }

    public final void aA(List<com.tencent.mm.plugin.emoji.a.a.f> list) {
        if (this.lxC == null) {
            this.lxC = new ArrayList();
        } else {
            int size = this.lxC.size() - 1;
            if (size >= 0 && size < this.lxC.size()) {
                com.tencent.mm.plugin.emoji.a.a.f fVar = (com.tencent.mm.plugin.emoji.a.a.f) this.lxC.get(size);
                if (!(fVar == null || fVar.luN == null || bh.ov(fVar.luN.vIR) || !fVar.luN.vIR.equals(EmojiGroupInfo.xAb))) {
                    this.lxC.remove(fVar);
                }
            }
        }
        this.lxC.addAll(list);
    }
}
