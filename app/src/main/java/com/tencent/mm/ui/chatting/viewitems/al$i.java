package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI$a;
import com.tencent.mm.ui.chatting.viewitems.al.h;
import com.tencent.mm.ui.chatting.viewitems.b.a;

final class al$i extends a {
    TextView yMh;
    View yOo = null;

    al$i() {
    }

    public final a dB(View view) {
        super.ds(view);
        this.ldK = (TextView) view.findViewById(R.h.bVf);
        this.yMh = (TextView) view.findViewById(R.h.bVD);
        this.yIy = view.findViewById(R.h.bTD);
        this.yOo = view.findViewById(R.h.bVC);
        this.yIz = (ImageView) view.findViewById(R.h.bVb);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        return this;
    }

    public static void a(al$i com_tencent_mm_ui_chatting_viewitems_al_i, au auVar, boolean z, int i, ChattingUI$a chattingUI$a, h hVar, OnLongClickListener onLongClickListener) {
        byte b = (byte) 0;
        if (com_tencent_mm_ui_chatting_viewitems_al_i != null) {
            if (com_tencent_mm_ui_chatting_viewitems_al_i.yIz != null) {
                com_tencent_mm_ui_chatting_viewitems_al_i.yIz.setVisibility(auVar.field_status == 6 ? 8 : 0);
            }
            com_tencent_mm_ui_chatting_viewitems_al_i.yIy.setTag(new ar(auVar, chattingUI$a.ypn, i, null, (byte) 0));
            com_tencent_mm_ui_chatting_viewitems_al_i.yIy.setOnClickListener(hVar);
            com_tencent_mm_ui_chatting_viewitems_al_i.yIy.setOnLongClickListener(onLongClickListener);
            com_tencent_mm_ui_chatting_viewitems_al_i.yIy.setOnTouchListener(chattingUI$a.ysf.ysV);
            CharSequence charSequence = auVar.gjF;
            if (!bh.ov(charSequence)) {
                com_tencent_mm_ui_chatting_viewitems_al_i.yMh.setText(charSequence);
            } else if (z) {
                com_tencent_mm_ui_chatting_viewitems_al_i.yMh.setText(R.l.eUg);
            } else {
                com_tencent_mm_ui_chatting_viewitems_al_i.yMh.setText(R.l.eUh);
            }
            if (com_tencent_mm_ui_chatting_viewitems_al_i.yOo != null) {
                if (!auVar.field_content.equals(au.xzc)) {
                    int i2;
                    String str = auVar.field_content;
                    b spVar = new sp();
                    spVar.fKq.fuL = 1;
                    spVar.fKq.content = str;
                    com.tencent.mm.sdk.b.a.xef.m(spVar);
                    if (spVar.fKr.type == 3) {
                        i2 = 1;
                    } else {
                        byte b2 = (byte) 0;
                    }
                    if (i2 == 0) {
                        if (!auVar.field_content.equals(au.xzd)) {
                            str = auVar.field_content;
                            spVar = new sp();
                            spVar.fKq.fuL = 1;
                            spVar.fKq.content = str;
                            com.tencent.mm.sdk.b.a.xef.m(spVar);
                            if (spVar.fKr.type == 2) {
                                b = (byte) 1;
                            }
                            if (b == (byte) 0) {
                                return;
                            }
                        }
                        if (z) {
                            com_tencent_mm_ui_chatting_viewitems_al_i.yOo.setBackgroundResource(R.k.dBB);
                            return;
                        } else {
                            com_tencent_mm_ui_chatting_viewitems_al_i.yOo.setBackgroundResource(R.k.dBC);
                            return;
                        }
                    }
                }
                if (z) {
                    com_tencent_mm_ui_chatting_viewitems_al_i.yOo.setBackgroundResource(R.k.dBD);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_al_i.yOo.setBackgroundResource(R.k.dBE);
                }
            }
        }
    }
}
