package com.tencent.mm.ui.chatting.gallery;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ag.f;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.g$a;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Map;

public final class c extends o<au> implements OnClickListener {
    private static Map<String, Integer> tRc;
    private static Map<String, Integer> yDE;
    private LayoutInflater DF;
    public boolean hKW = false;
    String jRw;
    protected com.tencent.mm.aq.a.a.c lcT = null;
    Context mContext;
    boolean vnK;
    private boolean vzn;
    private final ImageGalleryGridUI yDC;
    boolean yDD = false;
    long yyg;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        au auVar = new au();
        auVar.b(cursor);
        return auVar;
    }

    public c(Context context, au auVar, String str) {
        super(context, auVar);
        this.yDC = (ImageGalleryGridUI) context;
        this.jRw = str;
        this.vnK = f.eE(this.jRw);
        if (this.vnK) {
            this.yyg = auVar.field_bizChatId;
        }
        ar.Hg();
        this.vzn = com.tencent.mm.z.c.isSDCardAvailable();
        this.DF = LayoutInflater.from(context);
        a aVar = new a();
        aVar.hDF = 1;
        aVar.hEa = true;
        aVar.hDH = com.tencent.mm.bv.a.eA(context) / 3;
        aVar.hDG = com.tencent.mm.bv.a.eA(context) / 3;
        aVar.hDT = R.e.btx;
        this.lcT = aVar.PK();
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final void Xy() {
        if (this.vnK) {
            ar.Hg();
            setCursor(com.tencent.mm.z.c.Fb().al(this.jRw, this.yyg));
            return;
        }
        ar.Hg();
        setCursor(com.tencent.mm.z.c.Fa().EB(this.jRw));
    }

    protected final void Xz() {
        if (this.vnK) {
            ar.Hg();
            setCursor(com.tencent.mm.z.c.Fb().al(this.jRw, this.yyg));
            return;
        }
        ar.Hg();
        setCursor(com.tencent.mm.z.c.Fa().EB(this.jRw));
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.DF.inflate(R.i.dlD, viewGroup, false);
            aVar = new a();
            aVar.qqc = (ImageView) view.findViewById(R.h.cnS);
            aVar.yyo = view.findViewById(R.h.cVA);
            aVar.yDI = (TextView) view.findViewById(R.h.chN);
            aVar.yDI.setVisibility(8);
            aVar.yDH = (ImageView) view.findViewById(R.h.chG);
            aVar.yyp = (TextView) view.findViewById(R.h.cVx);
            aVar.yyo.setVisibility(8);
            aVar.yyr = view.findViewById(R.h.cOt);
            aVar.yyr.setVisibility(8);
            aVar.yDJ = view.findViewById(R.h.chR);
            aVar.yDJ.setVisibility(8);
            aVar.yyq = (ImageView) view.findViewById(R.h.cnV);
            aVar.mSc = (CheckBox) view.findViewById(R.h.cvv);
            aVar.mSd = view.findViewById(R.h.cvw);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.yyr.setVisibility(8);
        aVar.yyo.setVisibility(8);
        aVar.yDJ.setVisibility(8);
        aVar.yDI.setVisibility(8);
        au auVar = (au) getItem(i);
        if (auVar != null) {
            if (!this.vzn) {
                aVar.qqc.setImageResource(R.g.bEi);
            } else if (this.yDC instanceof ImageGalleryGridUI) {
                String str = auVar.field_content;
                g$a com_tencent_mm_y_g_a = null;
                if (str != null) {
                    com_tencent_mm_y_g_a = g$a.I(str, auVar.field_reserved);
                }
                if (this.yDC.yDK == i) {
                    aVar.yyq.setVisibility(0);
                    if (!b.aZ(auVar) || com_tencent_mm_y_g_a == null || com_tencent_mm_y_g_a.type == 3) {
                        if (com_tencent_mm_y_g_a != null && com_tencent_mm_y_g_a.type == 3) {
                            aVar.yDH.setImageDrawable(this.yDC.getResources().getDrawable(f(com_tencent_mm_y_g_a)));
                        }
                        com.tencent.mm.aq.o.PA().a(bh(auVar), aVar.qqc, this.lcT, new 1(this));
                    } else {
                        aVar.yDH.setImageDrawable(this.yDC.getResources().getDrawable(f(com_tencent_mm_y_g_a)));
                        aVar.qqc.setImageResource(g(com_tencent_mm_y_g_a));
                    }
                } else {
                    aVar.yyq.setVisibility(0);
                    aVar.yyq.setBackgroundResource(R.e.bsQ);
                    if (!b.aZ(auVar) || com_tencent_mm_y_g_a == null || com_tencent_mm_y_g_a.type == 3) {
                        if (com_tencent_mm_y_g_a != null && com_tencent_mm_y_g_a.type == 3) {
                            aVar.yDH.setImageDrawable(this.yDC.getResources().getDrawable(f(com_tencent_mm_y_g_a)));
                        }
                        com.tencent.mm.aq.o.PA().a(bh(auVar), aVar.qqc, this.lcT);
                    } else {
                        aVar.yDH.setImageDrawable(this.yDC.getResources().getDrawable(f(com_tencent_mm_y_g_a)));
                        aVar.qqc.setImageResource(g(com_tencent_mm_y_g_a));
                    }
                }
                aVar.qqc.setPadding(0, 0, 0, 0);
                int measuredWidth = aVar.qqc.getMeasuredWidth();
                int measuredHeight = aVar.qqc.getMeasuredHeight();
                if (measuredWidth > 0 && measuredHeight > 0) {
                    LayoutParams layoutParams = aVar.yyq.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = measuredHeight;
                    aVar.yyq.setLayoutParams(layoutParams);
                }
                if (b.aX(auVar)) {
                    if (aVar != null) {
                        aVar.yyo.setVisibility(0);
                        r bq = i.bq(auVar);
                        if (bq != null) {
                            aVar.yyp.setText(t.iW(bq.hVH));
                        }
                    }
                } else if (b.aY(auVar)) {
                    aVar.yyr.setVisibility(0);
                } else if (b.aZ(auVar) && aVar != null) {
                    aVar.yDJ.setVisibility(0);
                    aVar.yDI.setVisibility(0);
                    if (com_tencent_mm_y_g_a != null) {
                        x.i("MicroMsg.ImageGalleryGridAdapter", "initFileName--->content:%s", new Object[]{t.ou(com_tencent_mm_y_g_a.title)});
                        if (com_tencent_mm_y_g_a.type != 24) {
                            aVar.yDI.setText(i.b(this.mContext, t.ou(com_tencent_mm_y_g_a.title), aVar.yDI.getTextSize()));
                        } else {
                            aVar.yDI.setText(i.b(aVar.yDI.getContext(), aVar.yDI.getContext().getString(R.l.egW), aVar.yDI.getTextSize()));
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("the context should be ImageGalleryGridUI");
            }
            aVar.mSc.setChecked(g.a.cuF().bo(auVar));
            aVar.mSc.setTag(auVar);
            aVar.mSd.setTag(aVar);
            aVar.mSd.setOnClickListener(this);
            if (g.a.cuF().yEF) {
                aVar.mSc.setVisibility(0);
                aVar.mSd.setVisibility(0);
                aVar.yyq.setVisibility(0);
            } else {
                aVar.mSc.setVisibility(8);
                aVar.mSd.setVisibility(8);
                aVar.yyq.setVisibility(8);
            }
        }
        return view;
    }

    private static int f(g$a com_tencent_mm_y_g_a) {
        if (com_tencent_mm_y_g_a == null) {
            x.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + R.k.dvx);
            return R.k.dvy;
        } else if (com_tencent_mm_y_g_a.type == 5 || com_tencent_mm_y_g_a.type == 7 || com_tencent_mm_y_g_a.type == 15) {
            return R.k.dvz;
        } else {
            if (com_tencent_mm_y_g_a.type == 3) {
                return R.k.dvo;
            }
            if (com_tencent_mm_y_g_a.type != 6 || !tRc.containsKey(t.ou(com_tencent_mm_y_g_a.hbc))) {
                return R.k.dvy;
            }
            x.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + tRc.get(t.ou(com_tencent_mm_y_g_a.hbc)));
            return ((Integer) tRc.get(t.ou(com_tencent_mm_y_g_a.hbc))).intValue();
        }
    }

    private static int g(g$a com_tencent_mm_y_g_a) {
        if (com_tencent_mm_y_g_a == null) {
            x.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + R.e.brr);
            return R.e.brr;
        } else if (com_tencent_mm_y_g_a.type == 5 || com_tencent_mm_y_g_a.type == 7 || com_tencent_mm_y_g_a.type == 15) {
            return R.e.brs;
        } else {
            if (com_tencent_mm_y_g_a.type != 6 || !yDE.containsKey(t.ou(com_tencent_mm_y_g_a.hbc))) {
                return R.e.brr;
            }
            x.i("MicroMsg.ImageGalleryGridAdapter", "getIconId:" + yDE.get(t.ou(com_tencent_mm_y_g_a.hbc)));
            return ((Integer) yDE.get(t.ou(com_tencent_mm_y_g_a.hbc))).intValue();
        }
    }

    private static String bh(au auVar) {
        String nu;
        if (auVar.cjh() || auVar.cji()) {
            com.tencent.mm.modelvideo.o.TU();
            nu = s.nu(auVar.field_imgPath);
        } else {
            nu = com.tencent.mm.aq.o.Pw().b(auVar.field_imgPath, false, false);
            if (!(t.ov(nu) || nu.endsWith("hd") || !FileOp.bO(nu + "hd"))) {
                nu = nu + "hd";
            }
        }
        x.i("MicroMsg.ImageGalleryGridAdapter", "MsgInfoForMonetUri imgPath : %s", new Object[]{nu});
        if (!auVar.cjm()) {
            return nu;
        }
        g$a fT = g$a.fT(auVar.field_content);
        String str = null;
        if (!(fT == null || fT.fny == null || fT.fny.length() <= 0)) {
            b Rz = an.aqd().Rz(fT.fny);
            if (Rz != null) {
                str = Rz.field_fileFullPath;
            }
        }
        if (str != null) {
            return str;
        }
        return nu;
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.yDD = false;
    }

    public final void onClick(View view) {
        a aVar = (a) view.getTag();
        if (aVar.mSc != null) {
            au auVar = (au) aVar.mSc.getTag();
            if (auVar != null) {
                g cuF = g.a.cuF();
                if (cuF.bo(auVar)) {
                    cuF.bn(auVar);
                } else {
                    cuF.bm(auVar);
                }
                if (g.a.cuF().bo(auVar)) {
                    aVar.mSc.setChecked(true);
                    aVar.yyq.setBackgroundResource(R.e.bsK);
                } else {
                    aVar.mSc.setChecked(false);
                    aVar.yyq.setBackgroundResource(R.e.bsQ);
                }
                if (!this.hKW && g.a.cuF().yDd.size() > 1) {
                    g.pQN.a(219, 20, 1, true);
                    this.hKW = true;
                }
            }
        }
    }

    static {
        Map hashMap = new HashMap();
        tRc = hashMap;
        hashMap.put("avi", Integer.valueOf(R.k.dvB));
        tRc.put("m4v", Integer.valueOf(R.k.dvB));
        tRc.put("vob", Integer.valueOf(R.k.dvB));
        tRc.put("mpeg", Integer.valueOf(R.k.dvB));
        tRc.put("mpe", Integer.valueOf(R.k.dvB));
        tRc.put("asx", Integer.valueOf(R.k.dvB));
        tRc.put("asf", Integer.valueOf(R.k.dvB));
        tRc.put("f4v", Integer.valueOf(R.k.dvB));
        tRc.put("flv", Integer.valueOf(R.k.dvB));
        tRc.put("mkv", Integer.valueOf(R.k.dvB));
        tRc.put("wmv", Integer.valueOf(R.k.dvB));
        tRc.put("wm", Integer.valueOf(R.k.dvB));
        tRc.put("3gp", Integer.valueOf(R.k.dvB));
        tRc.put("mp4", Integer.valueOf(R.k.dvB));
        tRc.put("rmvb", Integer.valueOf(R.k.dvB));
        tRc.put("rm", Integer.valueOf(R.k.dvB));
        tRc.put("ra", Integer.valueOf(R.k.dvB));
        tRc.put("ram", Integer.valueOf(R.k.dvB));
        tRc.put("mp3pro", Integer.valueOf(R.k.dvo));
        tRc.put("vqf", Integer.valueOf(R.k.dvo));
        tRc.put("cd", Integer.valueOf(R.k.dvo));
        tRc.put("md", Integer.valueOf(R.k.dvo));
        tRc.put("mod", Integer.valueOf(R.k.dvo));
        tRc.put("vorbis", Integer.valueOf(R.k.dvo));
        tRc.put("au", Integer.valueOf(R.k.dvo));
        tRc.put("amr", Integer.valueOf(R.k.dvo));
        tRc.put("silk", Integer.valueOf(R.k.dvo));
        tRc.put("wma", Integer.valueOf(R.k.dvo));
        tRc.put("mmf", Integer.valueOf(R.k.dvo));
        tRc.put("mid", Integer.valueOf(R.k.dvo));
        tRc.put("midi", Integer.valueOf(R.k.dvo));
        tRc.put("mp3", Integer.valueOf(R.k.dvo));
        tRc.put("aac", Integer.valueOf(R.k.dvo));
        tRc.put("ape", Integer.valueOf(R.k.dvo));
        tRc.put("aiff", Integer.valueOf(R.k.dvo));
        tRc.put("aif", Integer.valueOf(R.k.dvo));
        tRc.put("doc", Integer.valueOf(R.k.dvF));
        tRc.put("docx", Integer.valueOf(R.k.dvF));
        tRc.put("ppt", Integer.valueOf(R.k.dvu));
        tRc.put("pptx", Integer.valueOf(R.k.dvu));
        tRc.put("xls", Integer.valueOf(R.k.dvi));
        tRc.put("xlsx", Integer.valueOf(R.k.dvi));
        tRc.put("pdf", Integer.valueOf(R.k.dvs));
        tRc.put("unknown", Integer.valueOf(R.k.dvy));
        hashMap = new HashMap();
        yDE = hashMap;
        hashMap.put("doc", Integer.valueOf(R.e.brn));
        yDE.put("docx", Integer.valueOf(R.e.brn));
        yDE.put("ppt", Integer.valueOf(R.e.brq));
        yDE.put("pptx", Integer.valueOf(R.e.brq));
        yDE.put("xls", Integer.valueOf(R.e.brt));
        yDE.put("xlsx", Integer.valueOf(R.e.brt));
        yDE.put("pdf", Integer.valueOf(R.e.brp));
        yDE.put("unknown", Integer.valueOf(R.e.brr));
        yDE.put("mp3pro", Integer.valueOf(R.e.bro));
        yDE.put("vqf", Integer.valueOf(R.e.bro));
        yDE.put("cd", Integer.valueOf(R.e.bro));
        yDE.put("md", Integer.valueOf(R.e.bro));
        yDE.put("mod", Integer.valueOf(R.e.bro));
        yDE.put("vorbis", Integer.valueOf(R.e.bro));
        yDE.put("au", Integer.valueOf(R.e.bro));
        yDE.put("amr", Integer.valueOf(R.e.bro));
        yDE.put("silk", Integer.valueOf(R.e.bro));
        yDE.put("wma", Integer.valueOf(R.e.bro));
        yDE.put("mmf", Integer.valueOf(R.e.bro));
        yDE.put("mid", Integer.valueOf(R.e.bro));
        yDE.put("midi", Integer.valueOf(R.e.bro));
        yDE.put("mp3", Integer.valueOf(R.e.bro));
        yDE.put("aac", Integer.valueOf(R.e.bro));
        yDE.put("ape", Integer.valueOf(R.e.bro));
        yDE.put("aiff", Integer.valueOf(R.e.bro));
        yDE.put("aif", Integer.valueOf(R.e.bro));
    }
}
