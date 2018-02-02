package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.s$a;
import com.tencent.mm.modelvideo.s$a.b;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.viewitems.ag.e;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class ag$d extends a {
    private static Map<String, WeakReference<ag$d>> yKl = new HashMap();
    private static SparseArray<String> yNz = new SparseArray();
    TextView prT;
    ImageView rkR;
    ImageView yIT;
    ImageView yIU;
    TextView yIW;
    ImageView yJk;
    ImageView yKh;
    ImageView yME;
    TextView yNu;
    MMPinProgressBtn yNv;
    View yNw;
    ProgressBar yNx;
    View yNy;

    public static boolean b(s$a.a aVar) {
        if (aVar.hVX != b.hWb) {
            return false;
        }
        r nF = t.nF(aVar.fileName);
        if (nF == null) {
            x.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", new Object[]{aVar.fileName});
            return false;
        } else if (nF.status != MMGIFException.D_GIF_ERR_IMAGE_DEFECT && nF.status != 104 && nF.status != 103) {
            return false;
        } else {
            ag.y(new 1(nF));
            return true;
        }
    }

    public final a q(View view, boolean z) {
        ImageView imageView;
        ProgressBar progressBar;
        View view2 = null;
        super.ds(view);
        this.ldK = (TextView) view.findViewById(R.h.bVf);
        this.yKh = (ImageView) view.findViewById(R.h.bTI);
        this.qhg = (TextView) view.findViewById(R.h.bVk);
        this.prT = (TextView) view.findViewById(R.h.bUZ);
        this.yNu = (TextView) view.findViewById(R.h.bUu);
        this.rkR = (ImageView) view.findViewById(R.h.bVc);
        this.yIT = (ImageView) view.findViewById(R.h.bTM);
        this.yIU = (ImageView) view.findViewById(R.h.bVe);
        this.yNv = (MMPinProgressBtn) view.findViewById(R.h.bTQ);
        this.yNw = view.findViewById(R.h.bVm);
        this.yIy = view.findViewById(R.h.bTD);
        this.yIW = (TextView) view.findViewById(R.h.bSZ);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        this.yME = (ImageView) view.findViewById(R.h.bTK);
        if (z) {
            imageView = null;
        } else {
            imageView = (ImageView) view.findViewById(R.h.bVd);
        }
        this.yJk = imageView;
        if (z) {
            progressBar = null;
        } else {
            progressBar = (ProgressBar) view.findViewById(R.h.bVn);
        }
        this.yNx = progressBar;
        if (!z) {
            view2 = view.findViewById(R.h.cUb);
        }
        this.yNy = view2;
        return this;
    }

    public static void a(ag$d com_tencent_mm_ui_chatting_viewitems_ag_d, au auVar, boolean z, int i, ChattingUI.a aVar, int i2, OnClickListener onClickListener, OnLongClickListener onLongClickListener) {
        int fromDPToPix;
        String str = (String) yNz.get(com_tencent_mm_ui_chatting_viewitems_ag_d.hashCode());
        if (str != null) {
            yKl.remove(str);
        }
        yNz.put(com_tencent_mm_ui_chatting_viewitems_ag_d.hashCode(), auVar.field_imgPath);
        yKl.put(auVar.field_imgPath, new WeakReference(com_tencent_mm_ui_chatting_viewitems_ag_d));
        r nF = t.nF(auVar.field_imgPath);
        if (nF == null) {
            nF = new r();
        }
        o.TU();
        Bitmap a = com.tencent.mm.aq.o.Pw().a(s.nu(auVar.field_imgPath), com.tencent.mm.bv.a.getDensity(aVar.getContext()), aVar.getContext(), i2);
        com_tencent_mm_ui_chatting_viewitems_ag_d.yME.setLayoutParams(new LayoutParams(0, 0));
        if (a == null) {
            fromDPToPix = com.tencent.mm.bv.a.fromDPToPix(aVar.getContext(), 85);
            int aa = com.tencent.mm.bv.a.aa(aVar.getContext(), R.f.buw);
            Bitmap a2 = d.a(d.ag(aVar.getContext().getResources().getColor(R.e.bsI), fromDPToPix, aa), i2, fromDPToPix, aa);
            ar.Hg();
            if (c.isSDCardAvailable()) {
                com_tencent_mm_ui_chatting_viewitems_ag_d.yKh.setImageBitmap(d.a(a2, i2, fromDPToPix, aa));
            } else {
                com_tencent_mm_ui_chatting_viewitems_ag_d.yKh.setImageDrawable(com.tencent.mm.bv.a.b(aVar.getContext(), R.k.dBw));
                com_tencent_mm_ui_chatting_viewitems_ag_d.yKh.setBackground(new BitmapDrawable(a2));
            }
            ViewGroup.LayoutParams layoutParams = new LayoutParams(fromDPToPix, aa);
            com_tencent_mm_ui_chatting_viewitems_ag_d.yME.setLayoutParams(layoutParams);
            if (com_tencent_mm_ui_chatting_viewitems_ag_d.yNy != null) {
                com_tencent_mm_ui_chatting_viewitems_ag_d.yNy.setLayoutParams(layoutParams);
            }
        } else {
            com_tencent_mm_ui_chatting_viewitems_ag_d.yKh.setImageBitmap(a);
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(a.getWidth(), a.getHeight());
            com_tencent_mm_ui_chatting_viewitems_ag_d.yME.setLayoutParams(layoutParams2);
            if (com_tencent_mm_ui_chatting_viewitems_ag_d.yNy != null) {
                com_tencent_mm_ui_chatting_viewitems_ag_d.yNy.setLayoutParams(layoutParams2);
            }
        }
        if (z) {
            com_tencent_mm_ui_chatting_viewitems_ag_d.prT.setText(com.tencent.mm.platformtools.t.bx((long) nF.hlp));
            com_tencent_mm_ui_chatting_viewitems_ag_d.yNu.setText(com.tencent.mm.platformtools.t.iW(nF.hVH));
            fromDPToPix = nF.status;
            x.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + fromDPToPix + " info : " + nF.getFileName());
            if (fromDPToPix == 199) {
                com_tencent_mm_ui_chatting_viewitems_ag_d.rkR.setImageDrawable(com.tencent.mm.bv.a.b(aVar.getContext(), R.k.dAI));
            } else {
                com_tencent_mm_ui_chatting_viewitems_ag_d.rkR.setImageDrawable(com.tencent.mm.bv.a.b(aVar.getContext(), R.k.dAI));
                com_tencent_mm_ui_chatting_viewitems_ag_d.prT.setVisibility(8);
            }
            if (fromDPToPix == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || fromDPToPix == 122 || fromDPToPix == 120) {
                com_tencent_mm_ui_chatting_viewitems_ag_d.yIT.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_ag_d.rkR.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_ag_d.yNv.setVisibility(0);
                com_tencent_mm_ui_chatting_viewitems_ag_d.yNv.setProgress(t.f(nF));
                x.v("MicroMsg.VideoItemHoder", "status begin");
                com_tencent_mm_ui_chatting_viewitems_ag_d.yNv.invalidate();
            } else if (fromDPToPix == 113 || fromDPToPix == bc.CTRL_INDEX || nF.Uh()) {
                com_tencent_mm_ui_chatting_viewitems_ag_d.yIT.setVisibility(0);
                com_tencent_mm_ui_chatting_viewitems_ag_d.yIU.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_ag_d.yNv.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_ag_d.rkR.setVisibility(0);
                x.v("MicroMsg.VideoItemHoder", "status pause");
            } else {
                com_tencent_mm_ui_chatting_viewitems_ag_d.yIU.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_ag_d.yIT.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_ag_d.yNv.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_ag_d.rkR.setVisibility(0);
                x.v("MicroMsg.VideoItemHoder", "status gone");
            }
        } else {
            com_tencent_mm_ui_chatting_viewitems_ag_d.prT.setText(com.tencent.mm.platformtools.t.bx((long) nF.hlp));
            com_tencent_mm_ui_chatting_viewitems_ag_d.yNu.setText(com.tencent.mm.platformtools.t.iW(nF.hVH));
            fromDPToPix = nF.status;
            com_tencent_mm_ui_chatting_viewitems_ag_d.rkR.setImageDrawable(com.tencent.mm.bv.a.b(aVar.getContext(), R.k.dAI));
            if (com_tencent_mm_ui_chatting_viewitems_ag_d.yNx != null) {
                com_tencent_mm_ui_chatting_viewitems_ag_d.yNx.setVisibility(8);
            }
            if (com_tencent_mm_ui_chatting_viewitems_ag_d.yNy != null) {
                com_tencent_mm_ui_chatting_viewitems_ag_d.yNy.setVisibility(8);
            }
            x.v("MicroMsg.VideoItemHoder", "video status %d", new Object[]{Integer.valueOf(fromDPToPix)});
            if (fromDPToPix == 104 || fromDPToPix == 103) {
                if (com.tencent.mm.plugin.mmsight.c.sH(nF.hVI)) {
                    if (com_tencent_mm_ui_chatting_viewitems_ag_d.yNx != null) {
                        com_tencent_mm_ui_chatting_viewitems_ag_d.yNx.setVisibility(0);
                    }
                    if (com_tencent_mm_ui_chatting_viewitems_ag_d.yNy != null) {
                        com_tencent_mm_ui_chatting_viewitems_ag_d.yNy.setVisibility(0);
                    }
                    com_tencent_mm_ui_chatting_viewitems_ag_d.yNu.setText(null);
                    com_tencent_mm_ui_chatting_viewitems_ag_d.prT.setText(null);
                    com_tencent_mm_ui_chatting_viewitems_ag_d.rkR.setImageDrawable(null);
                    com_tencent_mm_ui_chatting_viewitems_ag_d.yIU.setVisibility(8);
                    com_tencent_mm_ui_chatting_viewitems_ag_d.yIT.setVisibility(8);
                    com_tencent_mm_ui_chatting_viewitems_ag_d.yNv.setVisibility(8);
                } else {
                    if (com_tencent_mm_ui_chatting_viewitems_ag_d.yNx != null) {
                        com_tencent_mm_ui_chatting_viewitems_ag_d.yNx.setVisibility(8);
                    }
                    if (com_tencent_mm_ui_chatting_viewitems_ag_d.yNy != null) {
                        com_tencent_mm_ui_chatting_viewitems_ag_d.yNy.setVisibility(8);
                    }
                    com_tencent_mm_ui_chatting_viewitems_ag_d.yIT.setVisibility(8);
                    com_tencent_mm_ui_chatting_viewitems_ag_d.rkR.setVisibility(8);
                    com_tencent_mm_ui_chatting_viewitems_ag_d.yNv.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_ag_d.yNv.setProgress(t.g(nF));
                }
                x.v("MicroMsg.VideoItemHoder", "status begin");
            } else if (fromDPToPix == 105 || fromDPToPix == bc.CTRL_INDEX || nF.Uh()) {
                com_tencent_mm_ui_chatting_viewitems_ag_d.yIT.setVisibility(0);
                com_tencent_mm_ui_chatting_viewitems_ag_d.yIU.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_ag_d.yNv.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_ag_d.rkR.setVisibility(0);
                x.v("MicroMsg.VideoItemHoder", "status pause");
            } else if (fromDPToPix != 106) {
                com_tencent_mm_ui_chatting_viewitems_ag_d.yIU.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_ag_d.yIT.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_ag_d.yNv.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_ag_d.rkR.setVisibility(0);
                x.v("MicroMsg.VideoItemHoder", "status gone");
            } else if (k.Rv(auVar.field_imgPath)) {
                if (com_tencent_mm_ui_chatting_viewitems_ag_d.yNx != null) {
                    com_tencent_mm_ui_chatting_viewitems_ag_d.yNx.setVisibility(0);
                }
                if (com_tencent_mm_ui_chatting_viewitems_ag_d.yNy != null) {
                    com_tencent_mm_ui_chatting_viewitems_ag_d.yNy.setVisibility(0);
                }
                com_tencent_mm_ui_chatting_viewitems_ag_d.yNu.setText(null);
                com_tencent_mm_ui_chatting_viewitems_ag_d.prT.setText(null);
                com_tencent_mm_ui_chatting_viewitems_ag_d.rkR.setImageDrawable(null);
                com_tencent_mm_ui_chatting_viewitems_ag_d.yIU.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_ag_d.yIT.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_ag_d.yNv.setVisibility(8);
            } else {
                t.ny(auVar.field_imgPath);
            }
        }
        ImageView imageView = com_tencent_mm_ui_chatting_viewitems_ag_d.yIU;
        e eVar = new e(auVar, aVar.ypn, i, auVar.field_talker);
        eVar.kTK = 4;
        imageView.setTag(eVar);
        com_tencent_mm_ui_chatting_viewitems_ag_d.yIU.setOnClickListener(onClickListener);
        imageView = com_tencent_mm_ui_chatting_viewitems_ag_d.yIT;
        eVar = new e(auVar, aVar.ypn, i, auVar.field_talker);
        eVar.kTK = 3;
        imageView.setTag(eVar);
        com_tencent_mm_ui_chatting_viewitems_ag_d.yIT.setOnClickListener(onClickListener);
        View view = com_tencent_mm_ui_chatting_viewitems_ag_d.yIy;
        eVar = new e(auVar, aVar.ypn, i, auVar.field_talker);
        eVar.kTK = 2;
        view.setTag(eVar);
        com_tencent_mm_ui_chatting_viewitems_ag_d.yIy.setOnClickListener(onClickListener);
        com_tencent_mm_ui_chatting_viewitems_ag_d.yIy.setOnLongClickListener(onLongClickListener);
        com_tencent_mm_ui_chatting_viewitems_ag_d.yIy.setOnTouchListener(aVar.ysf.ysV);
    }
}
