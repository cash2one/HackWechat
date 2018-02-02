package com.tencent.mm.y;

import com.tencent.mm.ag.j;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.y.g.a;
import java.util.LinkedList;
import java.util.Map;

public class e extends d {
    public LinkedList<j> haX = null;

    public final d EJ() {
        return new e();
    }

    public final void a(StringBuilder stringBuilder, a aVar, String str, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, int i, int i2) {
    }

    public final void a(Map<String, String> map, a aVar) {
        switch (aVar.showType) {
            case 1:
                this.haX = j.q(aVar.haZ);
                return;
            default:
                return;
        }
    }
}
