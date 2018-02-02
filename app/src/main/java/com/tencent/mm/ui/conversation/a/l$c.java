package com.tencent.mm.ui.conversation.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.m.5;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.conversation.a.l$b.1;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class l$c implements Runnable {
    WeakReference<l> zaX;
    List<r> zbg;
    List<r> zbh;

    private l$c() {
    }

    private static int a(String str, l lVar, List<r> list, int i, int i2, int i3) {
        for (r rVar : list) {
            lVar.zaV.put(rVar.getFileName(), Long.valueOf(rVar.hUa));
            if (lVar.zaW.containsKey(Long.valueOf(rVar.hUa))) {
                x.d("MicroMsg.MassSightBanner", "%s: has contains massSendId %d, file %s", new Object[]{str, Long.valueOf(rVar.hUa), rVar.getFileName()});
            } else {
                View view;
                l$b com_tencent_mm_ui_conversation_a_l_b;
                View inflate;
                if (i < i2) {
                    x.d("MicroMsg.MassSightBanner", "%s: refresh view(%d/%d, hashCode %d) with massSendId %d", new Object[]{str, Integer.valueOf(i + 1), Integer.valueOf(i2), Integer.valueOf(lVar.mContainer.getChildAt(i).hashCode()), Long.valueOf(rVar.hUa)});
                    i = r2;
                    view = inflate;
                } else {
                    inflate = LayoutInflater.from(lVar.mContainer.getContext()).inflate(R.i.dnh, lVar.mContainer, false);
                    lVar.mContainer.addView(inflate);
                    x.d("MicroMsg.MassSightBanner", "%s: new view(%d/%d, hashCode %d) with massSendId %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(inflate.hashCode()), Long.valueOf(rVar.hUa)});
                    view = inflate;
                }
                l$b com_tencent_mm_ui_conversation_a_l_b2 = (l$b) view.getTag();
                if (com_tencent_mm_ui_conversation_a_l_b2 == null) {
                    com_tencent_mm_ui_conversation_a_l_b = new l$b();
                } else {
                    com_tencent_mm_ui_conversation_a_l_b = com_tencent_mm_ui_conversation_a_l_b2;
                }
                if (com_tencent_mm_ui_conversation_a_l_b.zaY != rVar.hUa) {
                    x.d("MicroMsg.MassSightBanner", "ashutest::mass send id not match! %d -> %d, totalCount %d", new Object[]{Long.valueOf(com_tencent_mm_ui_conversation_a_l_b.zaY), Long.valueOf(rVar.hUa), Integer.valueOf(i3)});
                    com_tencent_mm_ui_conversation_a_l_b.zaY = rVar.hUa;
                    com_tencent_mm_ui_conversation_a_l_b.zba = view;
                    com_tencent_mm_ui_conversation_a_l_b.zbb = (a) view.findViewById(R.h.cpA);
                    com_tencent_mm_ui_conversation_a_l_b.zbc = (ImageView) view.findViewById(R.h.cPr);
                    com_tencent_mm_ui_conversation_a_l_b.lpy = (ProgressBar) view.findViewById(R.h.progress);
                    com_tencent_mm_ui_conversation_a_l_b.zbe = (ImageButton) view.findViewById(R.h.bPo);
                    com_tencent_mm_ui_conversation_a_l_b.zbd = (TextView) view.findViewById(R.h.cpO);
                    com_tencent_mm_ui_conversation_a_l_b.zbb.wj(view.getResources().getDimensionPixelSize(R.f.bvD));
                    com_tencent_mm_ui_conversation_a_l_b.zba.setTag(com_tencent_mm_ui_conversation_a_l_b);
                    com_tencent_mm_ui_conversation_a_l_b.zbe.setTag(Long.valueOf(com_tencent_mm_ui_conversation_a_l_b.zaY));
                    com_tencent_mm_ui_conversation_a_l_b.zba.setOnClickListener(new 1(com_tencent_mm_ui_conversation_a_l_b));
                    com_tencent_mm_ui_conversation_a_l_b.zbe.setOnClickListener(new OnClickListener(com_tencent_mm_ui_conversation_a_l_b) {
                        final /* synthetic */ l$b zbf;

                        {
                            this.zbf = r1;
                        }

                        public final void onClick(View view) {
                            x.i("MicroMsg.MassSightBanner", "on click cancel, massSendId %d", new Object[]{Long.valueOf(((Long) view.getTag()).longValue())});
                            g.Dm().F(new 5(o.Ua(), r0));
                        }
                    });
                } else {
                    x.d("MicroMsg.MassSightBanner", "ashutest::mass send id match! %d, totalCount %d", new Object[]{Long.valueOf(com_tencent_mm_ui_conversation_a_l_b.zaY), Integer.valueOf(i3)});
                }
                o.TU();
                String nt = s.nt(rVar.getFileName());
                o.TU();
                com_tencent_mm_ui_conversation_a_l_b.zbb.B(com.tencent.mm.aq.o.Pw().a(s.nu(rVar.getFileName()), com.tencent.mm.bv.a.getDensity(view.getContext()), view.getContext()));
                if (i3 > 3) {
                    com_tencent_mm_ui_conversation_a_l_b.zbb.clear();
                    com_tencent_mm_ui_conversation_a_l_b.zbc.setVisibility(0);
                } else {
                    com_tencent_mm_ui_conversation_a_l_b.zbb.aA(nt, false);
                    com_tencent_mm_ui_conversation_a_l_b.zbc.setVisibility(8);
                }
                a(com_tencent_mm_ui_conversation_a_l_b, rVar);
                lVar.zaW.put(Long.valueOf(rVar.hUa), com_tencent_mm_ui_conversation_a_l_b);
            }
        }
        return i;
    }

    public static void a(l$b com_tencent_mm_ui_conversation_a_l_b, r rVar) {
        boolean z = true;
        x.v("MicroMsg.MassSightBanner", "info status %d", new Object[]{Integer.valueOf(rVar.status)});
        if (rVar.status == bc.CTRL_INDEX || rVar.status == 197 || rVar.status == 196) {
            com_tencent_mm_ui_conversation_a_l_b.lpy.setVisibility(4);
            com_tencent_mm_ui_conversation_a_l_b.zbd.setVisibility(0);
            com_tencent_mm_ui_conversation_a_l_b.zbe.setEnabled(true);
            com_tencent_mm_ui_conversation_a_l_b.zaZ = true;
            return;
        }
        float f = ((float) rVar.hUp) / ((float) rVar.hlp);
        com_tencent_mm_ui_conversation_a_l_b.lpy.setVisibility(0);
        com_tencent_mm_ui_conversation_a_l_b.zbd.setVisibility(4);
        com_tencent_mm_ui_conversation_a_l_b.lpy.setProgress((int) (((float) com_tencent_mm_ui_conversation_a_l_b.lpy.getMax()) * f));
        ImageButton imageButton = com_tencent_mm_ui_conversation_a_l_b.zbe;
        if (Float.compare(0.99f, f) <= 0) {
            z = false;
        }
        imageButton.setEnabled(z);
        com_tencent_mm_ui_conversation_a_l_b.zaZ = false;
    }

    public final void run() {
        l lVar = (l) this.zaX.get();
        if (lVar == null) {
            x.w("MicroMsg.MassSightBanner", "try to refresh, but banner ref is null");
            return;
        }
        int childCount = lVar.mContainer.getChildCount();
        lVar.zaW.clear();
        Set hashSet = new HashSet();
        for (r rVar : this.zbg) {
            hashSet.add(Long.valueOf(rVar.hUa));
        }
        for (r rVar2 : this.zbh) {
            hashSet.add(Long.valueOf(rVar2.hUa));
        }
        int size = hashSet.size();
        int a = a("update fail", lVar, this.zbh, a("update unfinish", lVar, this.zbg, 0, childCount, size), childCount, size);
        for (int i = a; i < childCount; i++) {
            lVar.mContainer.removeViewAt(a);
        }
    }
}
