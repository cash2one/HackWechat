package com.tencent.mm.plugin.sight.draft.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelvideo.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.w.a.b;
import com.tencent.mm.w.a.g;

class b$a implements OnClickListener {
    final /* synthetic */ b qvI;

    private b$a(b bVar) {
        this.qvI = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof b$e) {
            b$e com_tencent_mm_plugin_sight_draft_ui_b_e = (b$e) view.getTag();
            if (com_tencent_mm_plugin_sight_draft_ui_b_e.qvP == null) {
                x.i("MicroMsg.SightDraftContainerAdapter", "click draft, but info null, curType %s", new Object[]{b.b(this.qvI)});
                btn();
                b.a(this.qvI, null);
                return;
            }
            if (b.c(this.qvI) != com_tencent_mm_plugin_sight_draft_ui_b_e) {
                btn();
                String nk = k.nk(com_tencent_mm_plugin_sight_draft_ui_b_e.qvP.field_fileName);
                com_tencent_mm_plugin_sight_draft_ui_b_e.qvN.hY(true);
                com_tencent_mm_plugin_sight_draft_ui_b_e.qvN.aA(nk, false);
                com_tencent_mm_plugin_sight_draft_ui_b_e.myd.setBackgroundResource(R.g.bGh);
                View view2 = com_tencent_mm_plugin_sight_draft_ui_b_e.qvM;
                if (!(view2 == null || d.fN(11))) {
                    Animator animator = (Animator) view2.getTag(g.gWc);
                    if (animator != null) {
                        animator.cancel();
                    }
                    AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(view2.getContext(), b.gUu);
                    animatorSet.setTarget(view2);
                    animatorSet.start();
                    view2.setTag(g.gWc, animatorSet);
                }
                b.b(this.qvI, com_tencent_mm_plugin_sight_draft_ui_b_e);
                b.a(this.qvI, com_tencent_mm_plugin_sight_draft_ui_b_e);
            }
            if (b.d(this.qvI) != null) {
                b.d(this.qvI).btl();
            }
        }
    }

    public final boolean btn() {
        if (b.c(this.qvI) == null) {
            return false;
        }
        b.c(this.qvI).jCQ.setVisibility(8);
        b.c(this.qvI).qvN.hY(false);
        b.c(this.qvI).qvN.aA(null, false);
        b.c(this.qvI).qvN.B(b.e(this.qvI).n(b.c(this.qvI).qvP.field_fileName, k.nl(b.c(this.qvI).qvP.field_fileName), true));
        b.c(this.qvI).myd.setBackgroundResource(R.g.bGg);
        j.m(b.c(this.qvI).qvM, 1.0f);
        b.a(this.qvI, null);
        return true;
    }
}
