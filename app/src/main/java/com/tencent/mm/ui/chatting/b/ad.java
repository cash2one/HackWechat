package com.tencent.mm.ui.chatting.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.util.SparseBooleanArray;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.c;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.ab;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.ba;
import com.tencent.mm.z.q;
import java.util.ArrayList;

public final class ad {
    public p fhr;
    private long yCB = -1;
    public SparseBooleanArray yCC = new SparseBooleanArray();

    public ad(p pVar) {
        this.fhr = pVar;
    }

    public final void dn(String str, int i) {
        ar.Dm().F(new 1(this, str, i));
    }

    final void aj(ArrayList<String> arrayList) {
        x.v("MicroMsg.ChattingUI.VideoImp", "send video path: %s", new Object[]{arrayList.toString()});
        Runnable kVar = new k(this.fhr.csq().getContext(), arrayList, null, this.fhr.csi().field_username, 2, new 4(this));
        Context context = this.fhr.csq().getContext();
        this.fhr.csq().getMMString(R.l.dGO);
        this.fhr.b(h.a(context, this.fhr.csq().getMMString(R.l.dHc), true, new 5(this, kVar)));
        e.post(kVar, "ChattingUI_importMultiVideo");
    }

    public final void al(final Intent intent) {
        x.d("MicroMsg.ChattingUI.VideoImp", "sendVedio");
        if (ab.bC(this.fhr.csq().getContext())) {
            Q(intent);
        } else {
            h.a(this.fhr.csq().getContext(), R.l.eSZ, R.l.dGO, new OnClickListener(this) {
                final /* synthetic */ ad yCE;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.yCE.Q(intent);
                }
            }, null);
        }
    }

    final void Q(Intent intent) {
        c cVar = new c();
        cVar.a(this.fhr.csq().getContext(), intent, new 7(this));
        Context context = this.fhr.csq().getContext();
        this.fhr.csq().getMMString(R.l.dGO);
        this.fhr.b(h.a(context, this.fhr.csq().getMMString(R.l.dHc), true, new 8(this, cVar)));
    }

    public final void am(Intent intent) {
        x.d("MicroMsg.ChattingUI.VideoImp", "sendVedioFromCustomRecord");
        if (intent == null) {
            x.e("MicroMsg.ChattingUI.VideoImp", "data == null");
            return;
        }
        String stringExtra = intent.getStringExtra("VideoRecorder_ToUser");
        String stringExtra2 = intent.getStringExtra("VideoRecorder_FileName");
        int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
        x.e("MicroMsg.ChattingUI.VideoImp", "fileName " + stringExtra2 + " length " + intExtra + " user " + stringExtra);
        if (!bh.ov(stringExtra) && !bh.ov(stringExtra2) && intExtra >= 0) {
            if (stringExtra.equals("medianote") && (q.FW() & 16384) == 0) {
                r rVar = new r();
                rVar.fileName = stringExtra2;
                rVar.hVH = intExtra;
                rVar.fDC = stringExtra;
                rVar.hVz = (String) g.Dj().CU().get(2, "");
                rVar.hVE = bh.Wo();
                rVar.hVF = bh.Wo();
                rVar.hVB = intExtra;
                rVar.hUp = intExtra;
                o.TU();
                int nv = s.nv(s.nt(stringExtra2));
                if (nv <= 0) {
                    x.e("MicroMsg.VideoLogic", "get Video size failed :" + stringExtra2);
                    return;
                }
                rVar.hlp = nv;
                o.TU();
                stringExtra = s.nu(stringExtra2);
                intExtra = s.nv(stringExtra);
                if (intExtra <= 0) {
                    x.e("MicroMsg.VideoLogic", "get Thumb size failed :" + stringExtra + " size:" + intExtra);
                    return;
                }
                rVar.hVD = intExtra;
                x.d("MicroMsg.VideoLogic", "init record file:" + stringExtra2 + " thumbsize:" + rVar.hVD + " videosize:" + rVar.hlp);
                rVar.status = 199;
                au auVar = new au();
                auVar.dS(rVar.Ud());
                auVar.setType(43);
                auVar.eR(1);
                auVar.dT(stringExtra2);
                auVar.eQ(2);
                auVar.aq(ba.hR(rVar.Ud()));
                rVar.hVI = (int) ba.i(auVar);
                o.TU().a(rVar);
                return;
            }
            t.b(stringExtra2, intExtra, stringExtra, null);
            t.nA(stringExtra2);
            this.fhr.mM(true);
        }
    }
}
