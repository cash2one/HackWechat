package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.viewitems.b.a;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.y.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

final class c$c extends a {
    public static int[] mxW = new int[]{R.h.bUJ, R.h.bUK, R.h.bUL, R.h.bUM, R.h.bUN};
    protected TextView iiq;
    protected TextView iir;
    protected TextView mxT;
    protected TextView nnC;
    private ArrayList<MMImageView> rvB = new ArrayList();
    protected MMImageView yIL;
    protected ImageView yIM;
    protected ImageView yIN;
    protected TextView yIO;
    protected LinearLayout yIP;
    protected ImageView yIQ;
    protected MMPinProgressBtn yIR;
    protected ImageView yIS;
    protected ImageView yIT;
    protected ImageView yIU;
    protected ImageView yIV;
    protected TextView yIW;
    protected ChattingItemFooter yIX;
    protected ImageView yIY;
    protected LinearLayout yIZ;
    protected ViewGroup yJa;
    protected TextView yJb;
    protected LinearLayout yJc;
    protected RelativeLayout yJd;
    protected FrameLayout yJe;
    protected LinearLayout yJf;
    protected LinearLayout yJg;
    protected ViewStub yJh;
    protected ImageView yJi;
    protected ImageView yJj;
    ImageView yJk;
    protected LinearLayout yJl;
    protected ImageView yJm;
    protected TextView yJn;
    protected TextView yJo;
    protected ImageView yJp;
    protected TextView yJq;
    protected TextView yJr;
    protected LinearLayout yJs;
    protected ImageView yJt;
    protected ImageView yJu;
    protected TextView yJv;
    public int yJw = 0;
    private int yJx = Integer.MAX_VALUE;

    c$c() {
    }

    public final c$c p(View view, boolean z) {
        super.ds(view);
        this.yIL = (MMImageView) view.findViewById(R.h.bTo);
        this.iiq = (TextView) view.findViewById(R.h.bTq);
        this.nnC = (TextView) view.findViewById(R.h.bTr);
        this.iir = (TextView) view.findViewById(R.h.bTc);
        this.mxT = (TextView) view.findViewById(R.h.bTl);
        this.yIM = (ImageView) view.findViewById(R.h.bTi);
        this.yIO = (TextView) view.findViewById(R.h.bTk);
        this.yIN = (ImageView) view.findViewById(R.h.bTj);
        this.yIP = (LinearLayout) view.findViewById(R.h.bTh);
        this.yIQ = (ImageView) view.findViewById(R.h.bTm);
        this.yIR = (MMPinProgressBtn) view.findViewById(R.h.bTU);
        this.yIS = (ImageView) this.mUL.findViewById(R.h.bTT);
        this.yIT = (ImageView) this.mUL.findViewById(R.h.bTM);
        this.yIU = (ImageView) this.mUL.findViewById(R.h.bVe);
        this.yIV = (ImageView) view.findViewById(R.h.bTd);
        this.yIW = (TextView) view.findViewById(R.h.bSZ);
        this.yIY = (ImageView) view.findViewById(R.h.bTg);
        this.mSc = (CheckBox) view.findViewById(R.h.bTC);
        this.jWc = view.findViewById(R.h.bUC);
        this.qhg = (TextView) view.findViewById(R.h.bVk);
        this.yIX = (ChattingItemFooter) view.findViewById(R.h.ciX);
        this.yIZ = (LinearLayout) view.findViewById(R.h.bKD);
        this.yJa = (ViewGroup) view.findViewById(R.h.cub);
        this.yJb = (TextView) view.findViewById(R.h.ctZ);
        this.yJc = (LinearLayout) view.findViewById(R.h.bTs);
        this.yJe = (FrameLayout) view.findViewById(R.h.bTD);
        this.yJf = (LinearLayout) view.findViewById(R.h.bTa);
        this.yJj = (ImageView) view.findViewById(R.h.bTK);
        this.yJd = (RelativeLayout) view.findViewById(R.h.bTn);
        this.yJh = (ViewStub) view.findViewById(R.h.cAT);
        this.yJi = (ImageView) view.findViewById(R.h.bTP);
        if (!z) {
            this.yJk = (ImageView) this.mUL.findViewById(R.h.bVd);
            this.psA = (ProgressBar) this.mUL.findViewById(R.h.cTZ);
        }
        this.yJs = (LinearLayout) view.findViewById(R.h.bSS);
        this.yJt = (ImageView) view.findViewById(R.h.bST);
        this.yJu = (ImageView) view.findViewById(R.h.ceM);
        this.yJv = (TextView) view.findViewById(R.h.bSV);
        this.yJl = (LinearLayout) view.findViewById(R.h.bSR);
        this.yJm = (ImageView) view.findViewById(R.h.bSP);
        this.yJn = (TextView) view.findViewById(R.h.bSQ);
        this.yJo = (TextView) view.findViewById(R.h.bSU);
        this.yJp = (ImageView) view.findViewById(R.h.bSW);
        this.yJq = (TextView) view.findViewById(R.h.bSY);
        this.yJr = (TextView) view.findViewById(R.h.bSX);
        if (this.nnC != null && VERSION.SDK_INT >= 16) {
            this.yJx = this.nnC.getMaxLines();
        }
        this.yJw = b.fO(ac.getContext());
        return this;
    }

    public final void reset() {
        if (this.nnC != null) {
            this.nnC.setMaxLines(this.yJx);
        }
    }

    public static void a(c$c com_tencent_mm_ui_chatting_viewitems_c_c, String str, int i) {
        int RH = l.RH(str);
        if (RH == -1 || RH >= 100 || i <= 0) {
            com_tencent_mm_ui_chatting_viewitems_c_c.yIR.setVisibility(8);
            com_tencent_mm_ui_chatting_viewitems_c_c.yIS.setVisibility(8);
            return;
        }
        com_tencent_mm_ui_chatting_viewitems_c_c.yIR.setVisibility(0);
        com_tencent_mm_ui_chatting_viewitems_c_c.yIS.setVisibility(0);
        com_tencent_mm_ui_chatting_viewitems_c_c.yIR.setProgress(RH);
    }

    public static void a(c$c com_tencent_mm_ui_chatting_viewitems_c_c, Boolean bool, au auVar, String str, String str2) {
        long j = auVar.field_msgId;
        b fo = an.aqd().fo(j);
        if (fo == null) {
            x.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", new Object[]{Long.valueOf(j), str2});
            return;
        }
        if (bool.booleanValue()) {
            if (fo.field_status == 101) {
                com_tencent_mm_ui_chatting_viewitems_c_c.yIU.setVisibility(0);
                com_tencent_mm_ui_chatting_viewitems_c_c.yIR.setVisibility(0);
                com_tencent_mm_ui_chatting_viewitems_c_c.yIS.setVisibility(0);
            } else if (fo.field_status == 102) {
                com_tencent_mm_ui_chatting_viewitems_c_c.yIU.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_c_c.yIR.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_c_c.yIS.setVisibility(8);
            } else {
                com_tencent_mm_ui_chatting_viewitems_c_c.yIU.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_c_c.yIR.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_c_c.yIS.setVisibility(8);
            }
        } else if (fo.field_status == 101) {
            com_tencent_mm_ui_chatting_viewitems_c_c.yIU.setVisibility(0);
            com_tencent_mm_ui_chatting_viewitems_c_c.yIT.setVisibility(8);
        } else if (fo.field_status == 105) {
            com_tencent_mm_ui_chatting_viewitems_c_c.yIU.setVisibility(8);
            com_tencent_mm_ui_chatting_viewitems_c_c.yIT.setVisibility(0);
        } else {
            com_tencent_mm_ui_chatting_viewitems_c_c.yIU.setVisibility(8);
            com_tencent_mm_ui_chatting_viewitems_c_c.yIT.setVisibility(8);
        }
        if (auVar.field_status == 5) {
            com_tencent_mm_ui_chatting_viewitems_c_c.yIU.setVisibility(8);
            com_tencent_mm_ui_chatting_viewitems_c_c.yIT.setVisibility(8);
        }
        com_tencent_mm_ui_chatting_viewitems_c_c.yIU.setOnClickListener(new 1(bool, j, str, str2, auVar));
        com_tencent_mm_ui_chatting_viewitems_c_c.yIT.setOnClickListener(new 2(bool, j, str2, auVar));
    }

    static void a(ChattingUI.a aVar, c$c com_tencent_mm_ui_chatting_viewitems_c_c, g.a aVar2, boolean z) {
        String str;
        com_tencent_mm_ui_chatting_viewitems_c_c.iiq.setVisibility(8);
        if (aVar2.title == null || aVar2.title.trim().length() <= 0) {
            com_tencent_mm_ui_chatting_viewitems_c_c.nnC.setVisibility(8);
            str = null;
        } else {
            str = aVar2.title;
            com_tencent_mm_ui_chatting_viewitems_c_c.nnC.setVisibility(0);
            com_tencent_mm_ui_chatting_viewitems_c_c.nnC.setMaxLines(2);
        }
        com_tencent_mm_ui_chatting_viewitems_c_c.iir.setMaxLines(4);
        com_tencent_mm_ui_chatting_viewitems_c_c.yIV.setVisibility(8);
        com_tencent_mm_ui_chatting_viewitems_c_c.yIQ.setVisibility(4);
        if (z) {
            com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setVisibility(8);
        }
        com.tencent.mm.sdk.b.b mtVar = new mt();
        mtVar.fEE.type = 0;
        mtVar.fEE.fEG = aVar2.hbB;
        com.tencent.mm.sdk.b.a.xef.m(mtVar);
        c cVar = mtVar.fEF.fEO;
        if (cVar != null) {
            com_tencent_mm_ui_chatting_viewitems_c_c.nnC.setText(i.b(com_tencent_mm_ui_chatting_viewitems_c_c.nnC.getContext(), bh.az(cVar.title, aVar2.title), com_tencent_mm_ui_chatting_viewitems_c_c.nnC.getTextSize()));
            String str2 = cVar.desc;
            if (str2 == null) {
                x.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", new Object[]{aVar2.hbB});
            } else {
                str2 = str2.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
            if (str2 != null && str2.length() > 100) {
                str2 = str2.substring(0, 100);
            }
            com_tencent_mm_ui_chatting_viewitems_c_c.iir.setText(i.b(com_tencent_mm_ui_chatting_viewitems_c_c.iir.getContext(), bh.az(str2, aVar2.description), com_tencent_mm_ui_chatting_viewitems_c_c.iir.getTextSize()));
            Iterator it = cVar.hdX.iterator();
            Object obj = null;
            String str3 = null;
            CharSequence charSequence = str;
            int i = 0;
            while (it.hasNext()) {
                uq uqVar = (uq) it.next();
                if (bh.ov(uqVar.wcY) || !uqVar.wcY.equals(".htm") || bh.ov(uqVar.wdL) || !uqVar.wdL.equals("WeNoteHtmlFile")) {
                    if (uqVar.wdD.wdX.wet != null) {
                        charSequence = aVar.getContext().getString(R.l.eCA);
                        i = 1;
                    } else if (uqVar.wdD.wdX.fzO != null) {
                        if (str3 == null) {
                            str3 = uqVar.wdF;
                        } else if (str3 != uqVar.wdF) {
                            obj = uqVar.wdF;
                        }
                    }
                    switch (uqVar.bjS) {
                        case 1:
                            break;
                        case 2:
                            if (!z) {
                                break;
                            }
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setVisibility(0);
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setImageResource(R.g.byV);
                            break;
                        case 3:
                            if (!z) {
                                break;
                            }
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setVisibility(0);
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setImageResource(R.k.dvC);
                            break;
                        case 4:
                            if (z) {
                                com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setVisibility(0);
                                com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setImageResource(R.k.dvA);
                            }
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIV.setVisibility(0);
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIV.setImageResource(R.g.bHf);
                            break;
                        case 5:
                            if (!z) {
                                break;
                            }
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setVisibility(0);
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setImageResource(R.k.dvD);
                            break;
                        case 6:
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setVisibility(0);
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setImageResource(R.k.dvm);
                            break;
                        case 7:
                            if (z) {
                                com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setVisibility(0);
                                com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setImageResource(R.k.dvn);
                            }
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIV.setVisibility(0);
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIV.setImageResource(R.g.bDS);
                            break;
                        case 8:
                            if (!z) {
                                break;
                            }
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setVisibility(0);
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setImageResource(com.tencent.mm.pluginsdk.c.Rd(uqVar.wcY));
                            break;
                        case 10:
                        case 11:
                        case 14:
                            if (!z) {
                                break;
                            }
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setVisibility(0);
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setImageResource(R.k.dvx);
                            break;
                        case 16:
                            if (!z) {
                                break;
                            }
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setVisibility(0);
                            com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setImageResource(R.g.bBB);
                            break;
                        default:
                            break;
                    }
                }
            }
            if (str3 != null && obj == null && r1 == 0) {
                charSequence = aVar.getContext().getString(R.l.egj, new Object[]{str3});
            } else if (!(str3 == null || obj == null || str3.equals(obj) || r1 != 0)) {
                charSequence = aVar.getContext().getString(R.l.egi, new Object[]{str3, obj});
            }
        } else {
            Object obj2 = str;
        }
        if (!bh.ov(charSequence)) {
            com_tencent_mm_ui_chatting_viewitems_c_c.nnC.setText(charSequence);
        }
        com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setVisibility(8);
        com_tencent_mm_ui_chatting_viewitems_c_c.yJd.setVisibility(8);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(ChattingUI.a aVar, c$c com_tencent_mm_ui_chatting_viewitems_c_c, g.a aVar2, au auVar, boolean z) {
        com.tencent.mm.sdk.b.b mtVar = new mt();
        mtVar.fEE.type = 0;
        mtVar.fEE.fEG = aVar2.hbB;
        com.tencent.mm.sdk.b.a.xef.m(mtVar);
        c cVar = mtVar.fEF.fEO;
        com_tencent_mm_ui_chatting_viewitems_c_c.yJd.setVisibility(8);
        String[] strArr = new String[4];
        String[] strArr2 = new String[4];
        int[] iArr = new int[4];
        String[] strArr3 = new String[4];
        String[] strArr4 = new String[4];
        int[] iArr2 = new int[4];
        String[] strArr5 = new String[4];
        if (cVar != null) {
            String str;
            Object obj;
            CharSequence trim;
            Object string;
            String az = bh.az(cVar.desc, aVar2.description);
            Iterator it = cVar.hdX.iterator();
            int i = 0;
            String str2 = null;
            String str3 = az;
            Object obj2 = null;
            while (it.hasNext()) {
                uq uqVar = (uq) it.next();
                if (bh.ov(uqVar.wcY) || !uqVar.wcY.equals(".htm") || bh.ov(uqVar.wdL) || !uqVar.wdL.equals("WeNoteHtmlFile")) {
                    switch (uqVar.bjS) {
                        case 1:
                            if (obj2 == null) {
                                String str4 = uqVar.desc;
                                if (!bh.ov(str4)) {
                                    if (bh.ov(str4.replaceAll("\n", "").trim())) {
                                        str = str2;
                                    } else {
                                        str = uqVar.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                                    }
                                    obj2 = 1;
                                    str2 = str;
                                    continue;
                                }
                            }
                        case 2:
                            if (z) {
                                com_tencent_mm_ui_chatting_viewitems_c_c.yJd.setVisibility(0);
                                com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setVisibility(0);
                                com_tencent_mm_ui_chatting_viewitems_c_c.yIL.setImageResource(R.g.byV);
                            }
                            if (i < 4) {
                                strArr[i] = uqVar.hbj;
                                strArr2[i] = uqVar.wcF;
                                iArr[i] = (int) uqVar.wdp;
                                strArr3[i] = uqVar.wcJ;
                                strArr4[i] = uqVar.wcL;
                                iArr2[i] = (int) uqVar.wde;
                                strArr5[i] = uqVar.mvG;
                            }
                            i++;
                            continue;
                        case 3:
                        case 6:
                            break;
                        case 8:
                            if (bh.ov(str3)) {
                                str = ac.getContext().getString(R.l.dFj) + uqVar.title;
                                break;
                            }
                    }
                    str = str3;
                    str3 = str;
                }
            }
            if (str2 != null) {
                String[] split = str2.split("\n", 2);
                ArrayList arrayList = new ArrayList();
                if (split.length > 0) {
                    for (String str5 : split) {
                        if (str5.length() > 0) {
                            arrayList.add(str5);
                        }
                    }
                }
                if (arrayList.size() == 1) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (arrayList.size() == 1 && cVar.hdX.size() == 2) {
                    str = ac.getContext().getString(R.l.egW);
                } else if (i > 0) {
                    str = (String) arrayList.get(0);
                    if (arrayList.size() > 1) {
                        str2 = (String) arrayList.get(1);
                    } else {
                        str2 = null;
                    }
                } else {
                    str = (String) arrayList.get(0);
                    String[] split2 = str3.split(Pattern.quote(str), 2);
                    str2 = split2[0].trim();
                    if (split2.length > 1) {
                        str2 = new StringBuilder(split2[0].trim()).append("\n").append(split2[1].trim()).toString().trim();
                    }
                }
                trim = str.trim();
            } else {
                obj = null;
                string = ac.getContext().getString(R.l.egW);
                str2 = str3;
            }
            if (trim != null) {
                trim = trim.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
            com_tencent_mm_ui_chatting_viewitems_c_c.nnC.setText(i.c(com_tencent_mm_ui_chatting_viewitems_c_c.nnC.getContext(), trim, (int) com_tencent_mm_ui_chatting_viewitems_c_c.nnC.getTextSize()));
            if (str2 == null || str2.length() <= 100) {
                str = str2;
            } else {
                string = str2.substring(0, 100).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            }
            com_tencent_mm_ui_chatting_viewitems_c_c.iir.setText(i.c(com_tencent_mm_ui_chatting_viewitems_c_c.iir.getContext(), string, (int) com_tencent_mm_ui_chatting_viewitems_c_c.iir.getTextSize()));
            if (i > 0) {
                int i2;
                com_tencent_mm_ui_chatting_viewitems_c_c.yJd.setVisibility(8);
                if (obj != null || obj2 == null || bh.ov(string)) {
                    com_tencent_mm_ui_chatting_viewitems_c_c.iir.setVisibility(8);
                    com_tencent_mm_ui_chatting_viewitems_c_c.nnC.setMaxLines(2);
                } else {
                    com_tencent_mm_ui_chatting_viewitems_c_c.iir.setMaxLines(1);
                    com_tencent_mm_ui_chatting_viewitems_c_c.iir.setVisibility(0);
                    com_tencent_mm_ui_chatting_viewitems_c_c.nnC.setMaxLines(1);
                }
                com_tencent_mm_ui_chatting_viewitems_c_c.yJi.setVisibility(8);
                com_tencent_mm_ui_chatting_viewitems_c_c.yJh.setLayoutResource(R.i.ddI);
                try {
                    com_tencent_mm_ui_chatting_viewitems_c_c.yJg = (LinearLayout) com_tencent_mm_ui_chatting_viewitems_c_c.yJh.inflate();
                } catch (Exception e) {
                    com_tencent_mm_ui_chatting_viewitems_c_c.yJh.setVisibility(0);
                }
                if (i > 4) {
                    i2 = 4;
                } else {
                    i2 = i;
                }
                a(aVar, com_tencent_mm_ui_chatting_viewitems_c_c, i2, strArr5, strArr2, strArr, iArr, strArr4, strArr3, iArr2, auVar.field_talker);
                ImageView imageView = (ImageView) com_tencent_mm_ui_chatting_viewitems_c_c.yJg.findViewById(R.h.bUO);
                TextView textView = (TextView) com_tencent_mm_ui_chatting_viewitems_c_c.yJg.findViewById(R.h.bUI);
                if (textView != null) {
                    textView.setTextSize(0, (float) ac.getContext().getResources().getDimensionPixelSize(R.f.bvS));
                }
                if (i > 4) {
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    if (textView != null) {
                        textView.setText("(" + i + ")");
                        textView.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            }
            com_tencent_mm_ui_chatting_viewitems_c_c.yJh.setVisibility(8);
            com_tencent_mm_ui_chatting_viewitems_c_c.yJi.setVisibility(0);
        }
    }

    private static void a(ChattingUI.a aVar, c$c com_tencent_mm_ui_chatting_viewitems_c_c, int i, String[] strArr, String[] strArr2, String[] strArr3, int[] iArr, String[] strArr4, String[] strArr5, int[] iArr2, String str) {
        for (int i2 = 0; i2 <= 4; i2++) {
            MMImageView mMImageView = (MMImageView) com_tencent_mm_ui_chatting_viewitems_c_c.yJg.findViewById(mxW[i2]);
            if (mMImageView != null) {
                mMImageView.setImageDrawable(null);
                mMImageView.setVisibility(8);
            }
        }
        ImageView imageView = (ImageView) com_tencent_mm_ui_chatting_viewitems_c_c.yJg.findViewById(R.h.bUO);
        TextView textView = (TextView) com_tencent_mm_ui_chatting_viewitems_c_c.yJg.findViewById(R.h.bUI);
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        if (textView != null) {
            textView.setVisibility(8);
        }
        for (int i3 = 0; i3 < i; i3++) {
            MMImageView mMImageView2;
            if (i == 1) {
                mMImageView = (MMImageView) com_tencent_mm_ui_chatting_viewitems_c_c.yJg.findViewById(mxW[i3]);
                mMImageView.setImageResource(R.k.dxJ);
                mMImageView2 = mMImageView;
            } else {
                mMImageView = (MMImageView) com_tencent_mm_ui_chatting_viewitems_c_c.yJg.findViewById(mxW[i3 + 1]);
                mMImageView.setImageResource(R.k.dxI);
                mMImageView2 = mMImageView;
            }
            mMImageView2.setVisibility(0);
            an.bYR().a(aVar.ysf, strArr[i3], bh.Wp(), strArr2[i3], strArr3[i3], iArr[i3], str);
            String m = o.Pw().m("Note_" + strArr[i3], "", "");
            Bitmap a;
            if (FileOp.bO(m)) {
                a = o.Pw().a(m, true, com.tencent.mm.bv.a.getDensity(ac.getContext()), false, true, false, 0, false);
                if (a == null || a.isRecycled()) {
                    mMImageView2.setImageResource(R.k.dxI);
                } else {
                    mMImageView2.setImageBitmap(a);
                }
            } else {
                an.bYR().a(aVar.ysf, strArr[i3], bh.Wp(), strArr4[i3], strArr5[i3], iArr2[i3], str);
                o.Pw().m("Note_" + strArr[i3], "", "");
                com.tencent.mm.bv.a.fromDPToPix(aVar.getContext(), 45);
                if (FileOp.bO(m)) {
                    a = o.Pw().b(m, com.tencent.mm.bv.a.getDensity(ac.getContext()), false);
                    if (a == null || a.isRecycled()) {
                        mMImageView2.setImageResource(R.k.dxI);
                    } else {
                        mMImageView2.setImageBitmap(a);
                    }
                } else {
                    x.i("MicroMsg.AppMsgViewHolder", "thumb file not exist!");
                }
            }
        }
    }
}
