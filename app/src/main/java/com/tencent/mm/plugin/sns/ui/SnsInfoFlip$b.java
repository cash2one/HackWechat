package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelcontrol.c;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.sns.g.b;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class SnsInfoFlip$b extends BaseAdapter {
    private Context context;
    private String hhA = "";
    private boolean lsK = true;
    final /* synthetic */ SnsInfoFlip rCB;
    private boolean rCH = false;
    Map<String, WeakReference<View>> rCI = new HashMap();
    private String rCJ;
    private int rqr = 0;

    public SnsInfoFlip$b(SnsInfoFlip snsInfoFlip, Context context) {
        this.rCB = snsInfoFlip;
        this.context = context;
        this.rCH = g.coK();
        this.rqr = SnsInfoFlip.j(snsInfoFlip).size();
        c.MR();
        this.lsK = c.MT();
    }

    public final int getCount() {
        return SnsInfoFlip.j(this.rCB) == null ? 0 : SnsInfoFlip.j(this.rCB).size();
    }

    private void xF(int i) {
        aqr com_tencent_mm_protocal_c_aqr = ((b) SnsInfoFlip.j(this.rCB).get(i)).fHC;
        an a = an.a(SnsInfoFlip.k(this.rCB), ((b) SnsInfoFlip.j(this.rCB).get(i)).hzW);
        if (com_tencent_mm_protocal_c_aqr.ktN == 2) {
            boolean LE = u.LE(((b) SnsInfoFlip.j(this.rCB).get(i)).raG);
            ae.bvs();
            LE = com.tencent.mm.plugin.sns.model.g.a(com_tencent_mm_protocal_c_aqr, a, LE);
            if (SnsInfoFlip.l(this.rCB) && !LE) {
                SnsInfoFlip.a(this.rCB, com_tencent_mm_protocal_c_aqr.nGJ);
            }
        }
    }

    public final int getViewTypeCount() {
        return 2;
    }

    public final int getItemViewType(int i) {
        if (((b) SnsInfoFlip.j(this.rCB).get(i)).fHC.ktN == 6) {
            return 0;
        }
        return 1;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (((b) SnsInfoFlip.j(this.rCB).get(i)).fHC.ktN == 6) {
            String str = "MicroMsg.SnsInfoFlip";
            String str2 = "fill view online sight %d convert view is null %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Boolean.valueOf(view == null);
            x.d(str, str2, objArr);
            b bVar = (b) SnsInfoFlip.j(this.rCB).get(i);
            if (bVar == null) {
                x.w("MicroMsg.SnsInfoFlip", "fill online sight view, but flip item is null.");
                return view;
            }
            str2 = bVar.raG;
            if (bh.ov(str2)) {
                x.w("MicroMsg.SnsInfoFlip", "fill online sight view, but sns local id is null.");
                return view;
            }
            View onlineVideoView;
            WeakReference weakReference = (WeakReference) this.rCI.get(str2);
            if (weakReference == null || weakReference.get() == null) {
                onlineVideoView = new OnlineVideoView(this.context);
                this.rCI.put(str2, new WeakReference(onlineVideoView));
            } else {
                onlineVideoView = (OnlineVideoView) weakReference.get();
            }
            if (bh.fu(str2, this.rCJ)) {
                xG(i);
            }
            x.i("MicroMsg.SnsInfoFlip", "return online sight view %d parent id %s", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), bVar.raG});
            return onlineVideoView;
        }
        SnsInfoFlip$d snsInfoFlip$d;
        aqr com_tencent_mm_protocal_c_aqr;
        Bitmap a;
        LayoutParams layoutParams;
        aqr com_tencent_mm_protocal_c_aqr2 = ((b) SnsInfoFlip.j(this.rCB).get(i)).fHC;
        x.d("MicroMsg.SnsInfoFlip", "gallery position " + i + " " + this.rqr + " " + com_tencent_mm_protocal_c_aqr2.nGJ);
        if (i != SnsInfoFlip.m(this.rCB) && (SnsInfoFlip.g(this.rCB) instanceof MMGestureGallery)) {
            ((MMGestureGallery) SnsInfoFlip.g(this.rCB)).zli = false;
        }
        if (view == null) {
            SnsInfoFlip$d snsInfoFlip$d2 = new SnsInfoFlip$d();
            view = View.inflate(this.context, i.g.qHp, null);
            snsInfoFlip$d2.rCK = view.findViewById(f.qBD);
            snsInfoFlip$d2.nrd = (ProgressBar) view.findViewById(f.cEd);
            snsInfoFlip$d2.nWp = (TextView) view.findViewById(f.qEz);
            snsInfoFlip$d2.rCL = (FrameLayout) view.findViewById(f.qBu);
            snsInfoFlip$d2.fyg = (ImageView) view.findViewById(f.image);
            view.setTag(snsInfoFlip$d2);
            snsInfoFlip$d = snsInfoFlip$d2;
        } else {
            snsInfoFlip$d = (SnsInfoFlip$d) view.getTag();
        }
        snsInfoFlip$d.position = i;
        an a2 = an.a(SnsInfoFlip.k(this.rCB), ((b) SnsInfoFlip.j(this.rCB).get(i)).hzW);
        view.setLayoutParams(new Gallery.LayoutParams(-1, -1));
        snsInfoFlip$d.nrd.setVisibility(8);
        snsInfoFlip$d.nWp.setVisibility(8);
        snsInfoFlip$d.rCL.setVisibility(0);
        Object obj = (bh.ov(SnsInfoFlip.n(this.rCB)) || !SnsInfoFlip.n(this.rCB).equals(com_tencent_mm_protocal_c_aqr2.nGJ)) ? null : 1;
        if (com_tencent_mm_protocal_c_aqr2.nGJ.startsWith("Locall_path") && !bh.ov(((b) SnsInfoFlip.j(this.rCB).get(i)).raG)) {
            m mVar = (m) SnsInfoFlip.o(this.rCB).get(((b) SnsInfoFlip.j(this.rCB).get(i)).raG);
            if (mVar == null) {
                m Lm = ae.bvv().Lm(((b) SnsInfoFlip.j(this.rCB).get(i)).raG);
                SnsInfoFlip.o(this.rCB).put(((b) SnsInfoFlip.j(this.rCB).get(i)).raG, Lm);
                mVar = Lm;
            }
            bnp bxV = mVar.bxV();
            if (bxV.wQo.vYd.size() > ((b) SnsInfoFlip.j(this.rCB).get(i)).raH) {
                com_tencent_mm_protocal_c_aqr = (aqr) bxV.wQo.vYd.get(((b) SnsInfoFlip.j(this.rCB).get(i)).raH);
                a = ae.bvs().a(com_tencent_mm_protocal_c_aqr, snsInfoFlip$d.fyg, this.context.hashCode(), obj != null, a2, u.LE(((b) SnsInfoFlip.j(this.rCB).get(i)).raG));
                if (a == null && SnsInfoFlip.l(this.rCB)) {
                    SnsInfoFlip.a(this.rCB, com_tencent_mm_protocal_c_aqr.nGJ);
                }
                layoutParams = snsInfoFlip$d.fyg.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -1;
                snsInfoFlip$d.fyg.setLayoutParams(layoutParams);
                if (a != null && com_tencent_mm_protocal_c_aqr.nGJ != null && !com_tencent_mm_protocal_c_aqr.nGJ.startsWith("pre_temp_extend_pic")) {
                    LayoutParams layoutParams2 = snsInfoFlip$d.fyg.getLayoutParams();
                    BackwardSupportUtil.b.b(this.context, 160.0f);
                    int b = BackwardSupportUtil.b.b(this.context, 200.0f);
                    BackwardSupportUtil.b.b(this.context, 44.0f);
                    com.tencent.mm.plugin.sns.model.g bvs = ae.bvs();
                    String aD = com.tencent.mm.plugin.sns.data.i.aD(1, com_tencent_mm_protocal_c_aqr.nGJ);
                    String str3 = com_tencent_mm_protocal_c_aqr.nGJ;
                    n JZ = bvs.JZ(aD);
                    if (!com.tencent.mm.plugin.sns.data.i.b(JZ)) {
                        JZ = null;
                    }
                    if (JZ != null) {
                        double width = (double) JZ.bitmap.getWidth();
                        double height = (double) JZ.bitmap.getHeight();
                        if (width > 0.0d && height > 0.0d) {
                            Math.min(((double) b) / width, ((double) b) / height);
                        }
                    }
                    snsInfoFlip$d.fyg.setLayoutParams(layoutParams);
                    snsInfoFlip$d.nrd.setVisibility(0);
                    snsInfoFlip$d.fyg.setVisibility(0);
                    ae.bvs().cu(snsInfoFlip$d.fyg);
                    ae.bvs().c(com_tencent_mm_protocal_c_aqr, snsInfoFlip$d.fyg, e.black, this.context.hashCode(), a2);
                    SnsInfoFlip.xD(layoutParams2.width);
                    SnsInfoFlip.xE(layoutParams2.height);
                    if (obj != null) {
                        snsInfoFlip$d.nrd.setVisibility(8);
                    }
                } else if (this.rCH) {
                    snsInfoFlip$d.nrd.setVisibility(8);
                    ae.bvs().a(com_tencent_mm_protocal_c_aqr, snsInfoFlip$d.fyg, this.context.hashCode(), a2, u.LE(((b) SnsInfoFlip.j(this.rCB).get(i)).raG));
                    snsInfoFlip$d.fyg.setImageBitmap(a);
                    snsInfoFlip$d.fyg.setVisibility(0);
                } else {
                    snsInfoFlip$d.nrd.setVisibility(8);
                    if (a != null) {
                        if (!SnsInfoFlip.p(this.rCB)) {
                            return view;
                        }
                        x.i("MicroMsg.SnsInfoFlip", "update view ");
                        View multiTouchImageView = new MultiTouchImageView(this.context, a.getWidth(), a.getHeight(), SnsInfoFlip.q(this.rCB));
                        multiTouchImageView.rCd = SnsInfoFlip.r(this.rCB);
                        multiTouchImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                        ae.bvs().a(com_tencent_mm_protocal_c_aqr, multiTouchImageView, this.context.hashCode(), a2, u.LE(((b) SnsInfoFlip.j(this.rCB).get(i)).raG));
                        multiTouchImageView.setImageBitmap(a);
                        x.d("MicroMsg.SnsInfoFlip", "dancy mediaId: %s, isbigImgLoaded: %s, view: %s", new Object[]{com_tencent_mm_protocal_c_aqr.nGJ, SnsInfoFlip.s(this.rCB).get(com_tencent_mm_protocal_c_aqr.nGJ), Integer.valueOf(multiTouchImageView.getId())});
                        return multiTouchImageView;
                    }
                }
                if (!this.lsK && ab.bC(this.context)) {
                    if (i - 1 >= 0) {
                        xF(i - 1);
                    }
                    if (i + 1 >= SnsInfoFlip.d(this.rCB).getCount()) {
                        return view;
                    }
                    xF(i + 1);
                    return view;
                }
            }
        }
        com_tencent_mm_protocal_c_aqr = com_tencent_mm_protocal_c_aqr2;
        if (obj != null) {
        }
        a = ae.bvs().a(com_tencent_mm_protocal_c_aqr, snsInfoFlip$d.fyg, this.context.hashCode(), obj != null, a2, u.LE(((b) SnsInfoFlip.j(this.rCB).get(i)).raG));
        SnsInfoFlip.a(this.rCB, com_tencent_mm_protocal_c_aqr.nGJ);
        layoutParams = snsInfoFlip$d.fyg.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        snsInfoFlip$d.fyg.setLayoutParams(layoutParams);
        if (a != null) {
        }
        if (this.rCH) {
            snsInfoFlip$d.nrd.setVisibility(8);
            ae.bvs().a(com_tencent_mm_protocal_c_aqr, snsInfoFlip$d.fyg, this.context.hashCode(), a2, u.LE(((b) SnsInfoFlip.j(this.rCB).get(i)).raG));
            snsInfoFlip$d.fyg.setImageBitmap(a);
            snsInfoFlip$d.fyg.setVisibility(0);
        } else {
            snsInfoFlip$d.nrd.setVisibility(8);
            if (a != null) {
                if (!SnsInfoFlip.p(this.rCB)) {
                    return view;
                }
                x.i("MicroMsg.SnsInfoFlip", "update view ");
                View multiTouchImageView2 = new MultiTouchImageView(this.context, a.getWidth(), a.getHeight(), SnsInfoFlip.q(this.rCB));
                multiTouchImageView2.rCd = SnsInfoFlip.r(this.rCB);
                multiTouchImageView2.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                ae.bvs().a(com_tencent_mm_protocal_c_aqr, multiTouchImageView2, this.context.hashCode(), a2, u.LE(((b) SnsInfoFlip.j(this.rCB).get(i)).raG));
                multiTouchImageView2.setImageBitmap(a);
                x.d("MicroMsg.SnsInfoFlip", "dancy mediaId: %s, isbigImgLoaded: %s, view: %s", new Object[]{com_tencent_mm_protocal_c_aqr.nGJ, SnsInfoFlip.s(this.rCB).get(com_tencent_mm_protocal_c_aqr.nGJ), Integer.valueOf(multiTouchImageView2.getId())});
                return multiTouchImageView2;
            }
        }
        return !this.lsK ? view : view;
    }

    public final void clear() {
        x.i("MicroMsg.SnsInfoFlip", "adapter clear.");
        this.rCI.clear();
    }

    public final void xG(int i) {
        b bVar = (b) SnsInfoFlip.j(this.rCB).get(i);
        if (bVar == null) {
            x.w("MicroMsg.SnsInfoFlip", "notify online sight play, but flip item is null.");
            return;
        }
        String str = bVar.raG;
        if (bh.ov(str)) {
            x.w("MicroMsg.SnsInfoFlip", "notify online sight play, but sns local id is null.");
            return;
        }
        x.i("MicroMsg.SnsInfoFlip", "notify online sight play pos %s sns local id %s", new Object[]{Integer.valueOf(i), str});
        WeakReference weakReference = (WeakReference) this.rCI.get(str);
        if (weakReference == null) {
            x.w("MicroMsg.SnsInfoFlip", "notify online sight play, but view cache is null ");
            this.rCJ = str;
            return;
        }
        OnlineVideoView onlineVideoView = (OnlineVideoView) weakReference.get();
        if (onlineVideoView == null) {
            x.w("MicroMsg.SnsInfoFlip", "online sight view is null, do nothing. snsLocalId %s", new Object[]{str});
            this.rCJ = str;
            return;
        }
        x.i("MicroMsg.SnsInfoFlip", "%d notify online sight play video %s", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), str});
        this.rCJ = null;
        x.d("MicroMsg.OnlineVideoView", "%d register sns ui event", new Object[]{Integer.valueOf(onlineVideoView.hashCode())});
        a.xef.b(onlineVideoView.rvh);
        onlineVideoView.a(bVar.fHC, bVar.raG, bVar.hzW);
        com.tencent.mm.sdk.b.b prVar = new pr();
        prVar.fHu.fuL = 1;
        prVar.fHu.fus = str;
        a.xef.m(prVar);
    }

    public final void bBg() {
        x.i("MicroMsg.SnsInfoFlip", "notify online sight stop %s", new Object[]{bh.cgy()});
        this.rCJ = null;
        com.tencent.mm.sdk.b.b prVar = new pr();
        prVar.fHu.fuL = 2;
        a.xef.m(prVar);
    }

    public final Object getItem(int i) {
        if (i >= SnsInfoFlip.j(this.rCB).size() || i < 0) {
            return null;
        }
        return SnsInfoFlip.j(this.rCB).get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final void notifyDataSetChanged() {
        this.rqr = SnsInfoFlip.j(this.rCB).size();
        x.d("MicroMsg.SnsInfoFlip", "items.size:" + SnsInfoFlip.j(this.rCB).size());
        this.rCB.invalidate();
        this.rCB.requestLayout();
        super.notifyDataSetChanged();
        if (SnsInfoFlip.j(this.rCB).size() <= 0 && SnsInfoFlip.t(this.rCB) != null) {
            SnsInfoFlip.t(this.rCB).run();
        }
    }
}
