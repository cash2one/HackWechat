package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class h$b extends a {
    public static Map<String, WeakReference<h$b>> yKl = new HashMap();
    ProgressBar psA;
    ImageView yJk;
    RTChattingEmojiView yKg;
    ImageView yKh;
    ProgressBar yKi;
    ImageView yKj;
    TextView yKk;

    public final a q(View view, boolean z) {
        super.ds(view);
        this.ldK = (TextView) view.findViewById(R.h.bVf);
        this.yKg = (RTChattingEmojiView) view.findViewById(R.h.bTI);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        this.yKi = (ProgressBar) view.findViewById(R.h.bTQ);
        this.yKj = (ImageView) view.findViewById(R.h.bVc);
        this.yKk = (TextView) view.findViewById(R.h.bUZ);
        if (!z) {
            this.psA = (ProgressBar) view.findViewById(R.h.cTZ);
            this.yIz = (ImageView) view.findViewById(R.h.bVb);
            this.yJk = (ImageView) view.findViewById(R.h.bVd);
        }
        if (this.yKh != null) {
            ((ViewGroup) this.yKh.getParent()).setBackgroundDrawable(null);
        }
        this.qhg = (TextView) view.findViewById(R.h.bVk);
        return this;
    }

    public static void j(String str, int i, int i2) {
        if (yKl.containsKey(str)) {
            h$b com_tencent_mm_ui_chatting_viewitems_h_b = (h$b) ((WeakReference) yKl.get(str)).get();
            if (com_tencent_mm_ui_chatting_viewitems_h_b != null) {
                switch (i2) {
                    case 0:
                        com_tencent_mm_ui_chatting_viewitems_h_b.yKi.setVisibility(0);
                        com_tencent_mm_ui_chatting_viewitems_h_b.yKk.setVisibility(8);
                        com_tencent_mm_ui_chatting_viewitems_h_b.yKj.setVisibility(8);
                        com_tencent_mm_ui_chatting_viewitems_h_b.yKi.setProgress(0);
                        return;
                    case 1:
                        com_tencent_mm_ui_chatting_viewitems_h_b.yKi.setVisibility(8);
                        com_tencent_mm_ui_chatting_viewitems_h_b.yKk.setVisibility(8);
                        com_tencent_mm_ui_chatting_viewitems_h_b.yKj.setVisibility(8);
                        return;
                    case 2:
                        com_tencent_mm_ui_chatting_viewitems_h_b.yKi.setVisibility(8);
                        com_tencent_mm_ui_chatting_viewitems_h_b.yKk.setVisibility(8);
                        com_tencent_mm_ui_chatting_viewitems_h_b.yKj.setVisibility(0);
                        com_tencent_mm_ui_chatting_viewitems_h_b.yKi.setProgress(i);
                        com_tencent_mm_ui_chatting_viewitems_h_b.yKj.setImageResource(R.g.bBQ);
                        return;
                    default:
                        return;
                }
            }
            return;
        }
        x.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
    }
}
