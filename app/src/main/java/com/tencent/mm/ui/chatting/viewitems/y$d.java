package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.g;
import com.tencent.mm.aq.o;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.g.a.ix;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetSetting;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI$a;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.chatting.viewitems.y.c;

class y$d extends a {
    ImageView yJk;
    LinearLayout yMH;
    TextView yMI;
    ProgressBar yMJ;
    ImageView yMK;
    ProgressBar yML;
    ImageView yMM;
    TextView yMh;

    y$d() {
    }

    public final a q(View view, boolean z) {
        super.ds(view);
        this.ldK = (TextView) view.findViewById(R.h.bVf);
        this.yMh = (TextView) view.findViewById(R.h.bUy);
        this.yMI = (TextView) view.findViewById(R.h.bUA);
        this.yMH = (LinearLayout) view.findViewById(R.h.bUz);
        this.yMJ = (ProgressBar) view.findViewById(R.h.bUv);
        this.yIy = view.findViewById(R.h.bTD);
        this.qhg = (TextView) view.findViewById(R.h.bVk);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        this.yMK = (ImageView) view.findViewById(R.h.bUx);
        this.yML = (ProgressBar) view.findViewById(R.h.bUw);
        this.yMM = (ImageView) view.findViewById(R.h.bTL);
        if (!z) {
            this.yIz = (ImageView) view.findViewById(R.h.bVb);
            this.yJk = (ImageView) view.findViewById(R.h.bVd);
        }
        this.yMI.setTextSize(1, 16.0f);
        this.yMh.setTextSize(1, 12.0f);
        return this;
    }

    public static void a(y$d com_tencent_mm_ui_chatting_viewitems_y_d, au auVar, boolean z, int i, ChattingUI$a chattingUI$a, c cVar, OnLongClickListener onLongClickListener) {
        if (com_tencent_mm_ui_chatting_viewitems_y_d != null) {
            b ixVar;
            Object obj;
            com_tencent_mm_ui_chatting_viewitems_y_d.yMH.setVisibility(8);
            int fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(chattingUI$a.getContext(), JsApiGetSetting.CTRL_INDEX);
            int fromDPToPix2 = com.tencent.mm.bv.a.fromDPToPix(chattingUI$a.getContext(), 90);
            com_tencent_mm_ui_chatting_viewitems_y_d.yMI.setMaxLines(1);
            com_tencent_mm_ui_chatting_viewitems_y_d.yMh.setMaxLines(1);
            com_tencent_mm_ui_chatting_viewitems_y_d.yMh.setText("");
            if (d.OQ("location")) {
                x.d("MicroMsg.LocationItemHolder", "plugin found!");
                ixVar = new ix();
                ixVar.fzx.fzr = 1;
                ixVar.fzx.fnB = auVar;
                com.tencent.mm.sdk.b.a.xef.m(ixVar);
                CharSequence charSequence = ixVar.fzy.fwv;
                CharSequence charSequence2 = ixVar.fzy.fzA;
                if ((charSequence != null || a(charSequence2, chattingUI$a)) && ((charSequence == null || !charSequence.equals("") || a(charSequence2, chattingUI$a)) && (charSequence == null || !charSequence.equals("err_not_started")))) {
                    com_tencent_mm_ui_chatting_viewitems_y_d.yML.setVisibility(8);
                    com_tencent_mm_ui_chatting_viewitems_y_d.yMH.setVisibility(0);
                    x.d("MicroMsg.LocationItemHolder", "location info : " + charSequence);
                    if (a(charSequence2, chattingUI$a)) {
                        com_tencent_mm_ui_chatting_viewitems_y_d.yMI.setVisibility(0);
                        com_tencent_mm_ui_chatting_viewitems_y_d.yMI.setText(charSequence2);
                        if (charSequence == null || charSequence.equals("")) {
                            com_tencent_mm_ui_chatting_viewitems_y_d.yMh.setVisibility(8);
                        } else {
                            com_tencent_mm_ui_chatting_viewitems_y_d.yMh.setVisibility(0);
                            com_tencent_mm_ui_chatting_viewitems_y_d.yMh.setText(charSequence);
                        }
                    } else {
                        com_tencent_mm_ui_chatting_viewitems_y_d.yMI.setMaxLines(2);
                        com_tencent_mm_ui_chatting_viewitems_y_d.yMI.setText(charSequence);
                        com_tencent_mm_ui_chatting_viewitems_y_d.yMh.setVisibility(8);
                    }
                } else {
                    x.d("MicroMsg.LocationItemHolder", "info error or subcore not started!");
                    com_tencent_mm_ui_chatting_viewitems_y_d.yML.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_y_d.yMH.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_y_d.yMI.setText("");
                    com_tencent_mm_ui_chatting_viewitems_y_d.yMh.setText("");
                }
            } else {
                com_tencent_mm_ui_chatting_viewitems_y_d.yMJ.setVisibility(0);
                com_tencent_mm_ui_chatting_viewitems_y_d.yMH.setVisibility(8);
            }
            ImageView imageView = com_tencent_mm_ui_chatting_viewitems_y_d.yMK;
            g Pw = o.Pw();
            int i2 = R.g.bDt;
            int i3 = R.g.bDE;
            if (z) {
                obj = "location_backgroup_key_from";
            } else {
                String str = "location_backgroup_key_tor";
            }
            Bitmap bitmap = (Bitmap) Pw.hAw.get(obj);
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = com.tencent.mm.sdk.platformtools.d.v(i2, i3, fromDPToPix, fromDPToPix2);
                Pw.hAw.l(obj, bitmap);
            }
            imageView.setImageBitmap(bitmap);
            ixVar = new hu();
            ixVar.fye.fnB = auVar;
            ixVar.fye.w = fromDPToPix;
            ixVar.fye.h = fromDPToPix2;
            ixVar.fye.fyj = R.g.bDE;
            ixVar.fye.fyg = com_tencent_mm_ui_chatting_viewitems_y_d.yMK;
            ixVar.fye.fyi = com_tencent_mm_ui_chatting_viewitems_y_d.yMJ;
            ixVar.fye.fyh = com_tencent_mm_ui_chatting_viewitems_y_d.yMM;
            com.tencent.mm.sdk.b.a.xef.m(ixVar);
            com_tencent_mm_ui_chatting_viewitems_y_d.yIy.setTag(new ar(auVar, chattingUI$a.ypn, i, null, (byte) 0));
            com_tencent_mm_ui_chatting_viewitems_y_d.yIy.setOnClickListener(cVar);
            com_tencent_mm_ui_chatting_viewitems_y_d.yIy.setOnLongClickListener(onLongClickListener);
            com_tencent_mm_ui_chatting_viewitems_y_d.yIy.setOnTouchListener(chattingUI$a.ysf.ysV);
        }
    }

    private static boolean a(String str, ChattingUI$a chattingUI$a) {
        return (str == null || str.equals("") || str.equals(chattingUI$a.getString(R.l.eth))) ? false : true;
    }
}
