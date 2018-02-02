package com.tencent.mm.plugin.sns.ui;

import android.os.Bundle;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import java.util.LinkedList;
import java.util.List;

public class SnsBlackDetailUI extends SnsTagDetailUI implements e, b {
    public final void bAv() {
        x.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onCreate");
        g.Dk();
        ((h) g.h(h.class)).EY().a(this);
    }

    protected final void bAw() {
        x.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI __onDestroy");
        g.Dk();
        if (g.Dh().Cy()) {
            g.Dk();
            ((h) g.h(h.class)).EY().b(this);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.SnsBlackDetailUI", "SnsBlackDetailUI onCreate");
    }

    public void onDestroy() {
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        g.Dk();
        g.Di().gPJ.b(JsApiDestroyInstanceAudio.CTRL_INDEX, this);
        g.Dk();
        g.Di().gPJ.b(JsApiCreateAudioInstance.CTRL_INDEX, this);
        g.Dk();
        g.Di().gPJ.b(JsApiSetAudioState.CTRL_INDEX, this);
        g.Dk();
        g.Di().gPJ.b(JsApiGetAudioState.CTRL_INDEX, this);
        g.Dk();
        if (g.Dh().Cy()) {
            g.Dk();
            ((h) g.h(h.class)).EY().b(this);
        }
        super.onDestroy();
    }

    protected final void bAx() {
    }

    protected final void aWq() {
        if ((this.rHa + " " + bh.d(this.rGZ, ",")).equals(this.fqR) && this.qUC != 0) {
            finish();
        } else if (ae.bvB().p(this.qUC, this.rHa)) {
            com.tencent.mm.ui.base.h.b(this, getString(j.qMj, new Object[]{this.rHa}), getString(j.dGO), true);
        } else {
            List<String> bAy = bAy();
            List<String> linkedList = new LinkedList();
            List<String> linkedList2 = new LinkedList();
            for (String str : bAy) {
                if (!this.rGZ.contains(str)) {
                    linkedList.add(str);
                }
            }
            for (String str2 : this.rGZ) {
                if (!bAy.contains(str2)) {
                    linkedList2.add(str2);
                }
            }
            for (String str22 : linkedList) {
                s.q(str22, false);
            }
            for (String str222 : linkedList2) {
                s.q(str222, true);
            }
            a.ift.um();
            finish();
        }
    }

    protected final List<String> bAy() {
        List<String> linkedList = new LinkedList();
        if (this.qUC != 4) {
            return linkedList;
        }
        LinkedList linkedList2 = new LinkedList();
        return s.GI();
    }

    protected final void xe(String str) {
        super.xe(str);
    }

    protected final void bW(List<String> list) {
        ar bvj = ae.bvj();
        String FS = q.FS();
        for (String str : list) {
            if (!(this.rGZ.contains(str) || !com.tencent.mm.l.a.fZ(bvj.WO(str).field_type) || FS.equals(str))) {
                this.rGZ.add(str);
            }
        }
        if (this.kZG != null) {
            this.kZG.bb(this.rGZ);
        }
        updateTitle();
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SnsBlackDetailUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
    }
}
