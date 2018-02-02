package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class k$1 implements OnKeyListener {
    final /* synthetic */ k tUt;

    k$1(k kVar) {
        this.tUt = kVar;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 67 || c.bWp().size() == 0) {
            return false;
        }
        WXRTEditText bWY = this.tUt.bWY();
        if (bWY == null) {
            return false;
        }
        int bWO = bWY.bWO();
        x.i("MicroMsg.Note.WXRTManager", "current focus pos: %d", new Object[]{Integer.valueOf(bWO)});
        b Bt = c.bWp().Bt(bWO);
        if (Bt == null) {
            x.w("MicroMsg.Note.WXRTManager", "get current item is null %d", new Object[]{Integer.valueOf(bWO)});
            return false;
        }
        b Bt2 = c.bWp().Bt(bWO - 1);
        if (Bt2 == null) {
            x.i("MicroMsg.Note.WXRTManager", "get preItem is null %d", new Object[]{Integer.valueOf(bWO)});
            return false;
        }
        h hVar;
        switch (bWY.tTw) {
            case 0:
                x.i("MicroMsg.Note.WXRTManager", "Handle Editor Type EDITTEXT");
                int selectionStart = bWY.getSelectionStart();
                if (selectionStart == bWY.getSelectionEnd()) {
                    if (selectionStart == bWY.bWU().Ww) {
                        bWY.tTH = true;
                        this.tUt.b(u.tWk, Boolean.valueOf(false));
                        this.tUt.b(u.tWl, Boolean.valueOf(false));
                        this.tUt.b(u.tWj, Boolean.valueOf(false));
                        k.a(this.tUt).kI(false);
                        k.a(this.tUt).kJ(false);
                        k.a(this.tUt).kK(false);
                        bWY.tTH = false;
                    }
                    if (selectionStart == 0 && bWO != 0) {
                        boolean V;
                        String a = bWY.a(i.tTX);
                        c.bWp().bWs();
                        if (Bt2.getType() == 1) {
                            V = c.bWp().V(bWO, true);
                            hVar = (h) Bt2;
                            int length = hVar.tRy.getText().toString().length();
                            hVar.content += a;
                            hVar.tRv = length;
                            hVar.tRt = true;
                            hVar.tRz = false;
                        } else {
                            if (bh.ov(a)) {
                                V = c.bWp().V(bWO, true);
                            } else {
                                V = false;
                            }
                            Bt2.tRx.setSelection(0);
                            Bt2.tRt = true;
                            Bt2.tRz = false;
                        }
                        if (!V) {
                            k.b(this.tUt).bXJ().eo(bWO - 1, 2);
                            break;
                        }
                        k.b(this.tUt).bXJ().Bm(bWO - 1);
                        break;
                    }
                    return false;
                }
                return false;
            case 1:
                x.i("MicroMsg.Note.WXRTManager", "Handle Editor Type PREBUTTON");
                c.bWp().bWs();
                if (Bt2.getType() == 1) {
                    hVar = (h) Bt2;
                    if (bh.ov(hVar.content)) {
                        Bt.tRw.setSelection(0);
                        Bt.tRt = true;
                        Bt.tRz = true;
                        c.bWp().V(bWO - 1, true);
                        return true;
                    }
                    if (hVar.content.endsWith("<br/>")) {
                        hVar.content = hVar.content.substring(0, hVar.content.length() - 5);
                    }
                    hVar.tRv = -1;
                    hVar.tRt = true;
                    hVar.tRz = false;
                } else {
                    Bt2.tRx.setSelection(0);
                    Bt2.tRt = true;
                    Bt2.tRz = false;
                }
                k.b(this.tUt).bXJ().eo(bWO - 1, 2);
                break;
            case 2:
                x.i("MicroMsg.Note.WXRTManager", "Handle Editor Type NEXTBTTTON");
                if (Bt.getType() == 4 && ((k) Bt).tRH.booleanValue()) {
                    x.i("MicroMsg.Note.WXRTManager", "Current Item is Voice and Recording");
                    return false;
                } else if (Bt.tRA || Bt.getType() == -1) {
                    c.bWp().bWs();
                    c.bWp().V(bWO, false);
                    k.b(this.tUt).bXJ().Bo(bWO);
                    Bt2 = new h();
                    Bt2.tRt = true;
                    Bt2.tRz = false;
                    Bt2.content = "";
                    Bt2.tRv = 0;
                    c.bWp().a(bWO, Bt2);
                    c.bWp().er(bWO - 1, bWO + 1);
                    k.b(this.tUt).bXH().be(bWO);
                    break;
                } else {
                    c.bWp().W(bWO, true);
                    return true;
                }
                break;
        }
        return true;
    }
}
