package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.k.g;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.chatting.ChattingTranslateView;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.widget.MMNeatTextView;
import com.tencent.neattextview.textview.view.NeatTextView;

final class af$e extends a {
    View lWv;
    ChattingTranslateView yJZ;
    ImageView yJk;
    MMNeatTextView yNq;
    private int yNr = 0;

    af$e() {
    }

    public final a q(View view, boolean z) {
        super.ds(view);
        this.ldK = (TextView) view.findViewById(R.h.bVf);
        this.qhg = (TextView) view.findViewById(R.h.bVk);
        this.yNq = (MMNeatTextView) view.findViewById(R.h.bTH);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        this.lWv = view.findViewById(R.h.bTF);
        this.yJZ = (ChattingTranslateView) view.findViewById(R.h.bVi);
        if (!z) {
            this.yJk = (ImageView) view.findViewById(R.h.bVd);
            this.yIz = (ImageView) view.findViewById(R.h.bVb);
            this.psA = (ProgressBar) view.findViewById(R.h.cTZ);
        }
        this.yNr = b.fO(ac.getContext());
        float textSize = this.yNq.gu.getTextSize() * com.tencent.mm.bv.a.eu(this.yNq.getContext());
        NeatTextView neatTextView = this.yNq;
        Context context = neatTextView.getContext();
        neatTextView.ai(TypedValue.applyDimension(0, textSize, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
        this.yNq.setOnTouchListener(new e(this.yNq, new l(this.yNq.getContext())));
        this.yNq.Ec = cvA();
        this.yNq.ztY = new af$c();
        return this;
    }

    private static boolean cvA() {
        try {
            x.i("NeatTextView", "[isOpenNeatTextView] value:%s isNeatTextViewOpen:%s local:%s", g.zY().getValue("CellTextViewEnable"), Integer.valueOf(bh.getInt(g.zY().getValue("CellTextViewEnable"), 1)), Boolean.valueOf(com.tencent.mm.kernel.g.Dj().CU().getBoolean(w.a.USERINFO_CELLTEXTVIEW_CONFIG_BOOLEAN_SYNC, true)));
            if (1 == bh.getInt(g.zY().getValue("CellTextViewEnable"), 1) && r4) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
