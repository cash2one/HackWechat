package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.bm.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.b.a;
import com.tencent.mm.plugin.wenote.model.nativenote.b.b;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public final class c implements a, b {
    View ioh;
    String tRm = "";
    LinearLayout tXA;
    LinearLayout tXB;
    LinearLayout tXC;
    LinearLayout tXD;
    public boolean tXE = false;
    c tXF = this;
    boolean tXG = false;
    boolean tXH = false;
    boolean tXI = false;
    boolean tXJ = false;
    ImageButton tXt;
    LinearLayout tXu;
    ImageButton tXv;
    ImageButton tXw;
    ImageButton tXx;
    ImageButton tXy;
    LinearLayout tXz;

    class AnonymousClass13 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.wenote.model.nativenote.b.a tXK;
        final /* synthetic */ c tXL;

        AnonymousClass13(c cVar, com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
            this.tXL = cVar;
            this.tXK = aVar;
        }

        public final void onClick(View view) {
            boolean z = true;
            g.pQN.h(14547, new Object[]{Integer.valueOf(9)});
            this.tXL.tXA.setPressed(false);
            this.tXL.tXD.setPressed(false);
            if (this.tXL.tXH || this.tXL.tXJ) {
                this.tXL.tXI = false;
            }
            c.c(u.tWl, Boolean.valueOf(!this.tXL.tXI));
            c cVar = this.tXL;
            if (this.tXL.tXI) {
                z = false;
            }
            cVar.tXI = z;
            view.postDelayed(new 5(this.tXL, view, this.tXL.tXI), 100);
            c.b(this.tXK);
            this.tXL.tXH = false;
            this.tXL.tXJ = false;
        }
    }

    class AnonymousClass6 implements OnClickListener {
        final /* synthetic */ c tXL;
        final /* synthetic */ Context val$context;

        AnonymousClass6(c cVar, Context context) {
            this.tXL = cVar;
            this.val$context = context;
        }

        public final void onClick(View view) {
            x.i("MicroMsg.WNNoteFootPannel", "go to GalleryEntryUI");
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().W(-1, false);
            Intent intent = new Intent();
            intent.putExtra("max_select_count", 9);
            intent.putExtra("query_source_type", 13);
            intent.putExtra("query_media_type", 3);
            intent.putExtra("show_header_view", true);
            intent.putExtra("send_btn_string", this.val$context.getString(R.l.eeE));
            Parcelable parcelable = (SightParams) intent.getParcelableExtra("KEY_SIGHT_PARAMS");
            if (parcelable == null) {
                parcelable = new SightParams(4, 0);
            }
            String str = "micromsg_" + System.currentTimeMillis();
            String str2 = e.gHu + str + ".mp4";
            String str3 = e.gHu + str + ".jpeg";
            int intExtra = intent.getIntExtra("key_pick_local_media_duration", 60);
            SightParams sightParams = new SightParams(4, 1);
            sightParams.oqI = 2;
            sightParams.mode = 0;
            if (sightParams.oqJ == null) {
                sightParams.oqJ = new VideoTransPara();
            }
            sightParams.oqJ.duration = intExtra;
            sightParams.j(str, str2, str3, e.gHu + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
            intent.putExtra("KEY_SIGHT_PARAMS", parcelable);
            intent.putExtra("record_video_force_sys_camera", false);
            intent.putExtra("record_video_is_sight_capture", true);
            intent.addFlags(67108864);
            intent.putExtra("key_can_select_video_and_pic", true);
            d.b(this.val$context, "gallery", ".ui.GalleryEntryUI", intent, 4097);
        }
    }

    static /* synthetic */ int a(c cVar) {
        if (cVar.ioh == null || cVar.ioh.getVisibility() == 8) {
            return 0;
        }
        return cVar.tXu.getVisibility() == 0 ? 3 : 1;
    }

    static /* synthetic */ void b(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
        aVar.f(true, 50);
        aVar.P(1, 0);
    }

    static /* synthetic */ void c(t tVar, Object obj) {
        if (k.bWZ() != null) {
            k.bWZ().b(tVar, obj);
        }
    }

    public final void bVW() {
        h.a(this.tXy.getContext(), this.tXy.getContext().getString(R.l.eyp), "", true, new 3(this), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ c tXL;

            {
                this.tXL = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public final void bVV() {
        a(null);
    }

    public final void a(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
        this.tXy.setImageResource(R.g.bHY);
        if (this.tXE) {
            this.tXE = false;
            com.tencent.mm.plugin.wenote.model.k bVQ = com.tencent.mm.plugin.wenote.model.k.bVQ();
            if (bVQ.kEo && !bVQ.kEp) {
                bVQ.aJN();
            }
            bVQ = com.tencent.mm.plugin.wenote.model.k.bVQ();
            String str = com.tencent.mm.a.e.bO(bVQ.path) ? bVQ.path : "";
            int i = (int) com.tencent.mm.plugin.wenote.model.k.bVQ().duration;
            int bv = (int) com.tencent.mm.bi.b.bv((long) i);
            int bWu = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().bWu();
            com.tencent.mm.plugin.wenote.model.a.b Bt = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().Bt(bWu);
            if (!com.tencent.mm.a.e.bO(str)) {
                x.e("MicroMsg.WNNoteFootPannel", "voicePath not exist, remove data from datalist and ui");
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().V(bWu, false);
                if (aVar != null) {
                    aVar.Bo(bWu);
                }
                com.tencent.mm.plugin.wenote.model.a.b hVar = new com.tencent.mm.plugin.wenote.model.a.h();
                hVar.content = "";
                hVar.tRt = true;
                hVar.tRz = false;
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().a(bWu, hVar);
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp().er(bWu - 1, bWu + 1);
            } else if (bWu != -1 && Bt != null && Bt.getType() == 4) {
                ((com.tencent.mm.plugin.wenote.model.a.k) Bt).tRH = Boolean.valueOf(false);
                ((com.tencent.mm.plugin.wenote.model.a.k) Bt).type = 4;
                ((com.tencent.mm.plugin.wenote.model.a.k) Bt).tRQ = true;
                ((com.tencent.mm.plugin.wenote.model.a.k) Bt).tSg = "";
                ((com.tencent.mm.plugin.wenote.model.a.k) Bt).length = i;
                ((com.tencent.mm.plugin.wenote.model.a.k) Bt).tSf = com.tencent.mm.bi.b.v(ac.getContext(), bv).toString();
                ((com.tencent.mm.plugin.wenote.model.a.k) Bt).tRN = com.tencent.mm.bi.a.Vg() + "/fav_fileicon_recording.png";
                ((com.tencent.mm.plugin.wenote.model.a.k) Bt).fCa = str;
                com.tencent.mm.plugin.wenote.model.nativenote.manager.c bWp = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bWp();
                if (bWp.tSE != null) {
                    bWp.tSE.Bm(bWu);
                }
            }
        }
    }

    public final void kH(boolean z) {
        this.tXG = z;
        this.tXz.setPressed(z);
    }

    public final void kI(boolean z) {
        this.tXH = z;
        this.tXA.setPressed(z);
    }

    public final void kJ(boolean z) {
        this.tXI = z;
        this.tXB.setPressed(z);
    }

    public final void kK(boolean z) {
        this.tXJ = z;
        this.tXD.setPressed(z);
    }
}
