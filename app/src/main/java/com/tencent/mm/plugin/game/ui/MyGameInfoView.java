package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.an;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e$a;
import com.tencent.mm.plugin.game.model.ai.a;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.model.n.b;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.widget.TextProgressBar;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class MyGameInfoView extends LinearLayout {
    static Map<String, View> nwi = new HashMap();
    private Context mContext;
    private LinearLayout muI;
    private a ndH;
    private int ndn;
    private l nlW;
    private int nnA;
    private LayoutInflater nny;
    b noH = new b(this) {
        final /* synthetic */ MyGameInfoView nwj;

        {
            this.nwj = r1;
        }

        public final void h(int i, String str, boolean z) {
            if (z && !bh.ov(str)) {
                String[] strArr = new String[this.nwj.nwh.keySet().size()];
                this.nwj.nwh.keySet().toArray(strArr);
                for (Object obj : strArr) {
                    o oVar = (o) this.nwj.nwh.get(obj);
                    if (!(oVar == null || oVar.nbT == null || (!oVar.nbT.field_appId.equals(str) && !oVar.nbT.field_packageName.equals(str)))) {
                        oVar.cP(this.nwj.mContext);
                        oVar.aQj();
                        View view = (View) MyGameInfoView.nwi.get(oVar.nbT.field_appId);
                        if (view != null) {
                            a aVar = (a) view.getTag();
                            this.nwj.noI.a(aVar.nsP, aVar.nsO, oVar.nbT, (o) this.nwj.nwh.get(oVar.nbT.field_appId));
                        }
                    }
                }
            }
        }
    };
    e noI;
    private OnClickListener npt = new 3(this);
    Map<String, o> nwh;

    static /* synthetic */ void a(MyGameInfoView myGameInfoView, d dVar) {
        if (dVar != null) {
            o oVar = (o) myGameInfoView.nwh.get(dVar.field_appId);
            if (oVar == null) {
                oVar = new o(dVar);
                myGameInfoView.nwh.put(dVar.field_appId, oVar);
            }
            oVar.cP(myGameInfoView.mContext);
            oVar.aQj();
        }
    }

    public MyGameInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.nny = (LayoutInflater) getContext().getSystemService("layout_inflater");
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.muI = (LinearLayout) findViewById(R.h.ckS);
        this.nlW = new l();
        this.noI = new e(this.mContext);
        this.nwh = new HashMap();
        n.a(this.noH);
        x.i("MicroMsg.MyGameInfoView", "initView finished");
    }

    public final void a(a aVar, int i, int i2) {
        if (aVar == null) {
            setVisibility(8);
            return;
        }
        this.ndn = i;
        this.nnA = i2;
        this.nlW.qO(this.ndn);
        setVisibility(0);
        if (this.nnA == 2) {
            ap.a(this.mContext, 10, 1002, 0, null, this.ndn, null);
        }
        this.ndH = aVar;
        LinkedList linkedList = new LinkedList();
        Iterator it = this.ndH.ndI.iterator();
        while (it.hasNext()) {
            linkedList.add(((a.a) it.next()).ndK);
        }
        ar.Dm().F(new 2(this, linkedList));
        a(aVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(a aVar) {
        Object obj;
        View inflate;
        this.muI.removeAllViews();
        if (bh.cA(aVar.ndI)) {
            obj = null;
        } else {
            Iterator it = aVar.ndI.iterator();
            obj = null;
            while (it.hasNext()) {
                a.a aVar2 = (a.a) it.next();
                if (!(aVar2.ndK == null || bh.ov(aVar2.ndK.field_appId) || bh.ov(aVar2.ndK.field_appName))) {
                    f fVar = aVar2.ndK;
                    g(this.muI);
                    a aVar3 = new a((byte) 0);
                    View inflate2 = this.nny.inflate(R.i.dkA, this.muI, false);
                    aVar3.nlZ = (ViewGroup) inflate2.findViewById(R.h.cuR);
                    aVar3.nlL = (ImageView) inflate2.findViewById(R.h.cml);
                    aVar3.nlM = (TextView) inflate2.findViewById(R.h.cmV);
                    aVar3.nma = (TextView) inflate2.findViewById(R.h.ckT);
                    aVar3.nsO = (Button) inflate2.findViewById(R.h.clX);
                    aVar3.nsP = (TextProgressBar) inflate2.findViewById(R.h.clZ);
                    aVar3.nsP.rd(14);
                    aVar3.nsO.setOnClickListener(this.npt);
                    aVar3.nsP.setOnClickListener(this.npt);
                    aVar3.nwk = (TextView) inflate2.findViewById(R.h.cmA);
                    if (!fVar.aPT() || g.a(this.mContext, fVar)) {
                        e.aRV().a(aVar3.nlL, fVar.field_appId, com.tencent.mm.bv.a.getDensity(this.mContext));
                        aVar3.nlM.setText(fVar.field_appName);
                    } else {
                        if (bh.ov(fVar.nbl.nja)) {
                            e.aRV().a(aVar3.nlL, fVar.field_appId, com.tencent.mm.bv.a.getDensity(this.mContext));
                        } else {
                            e.aRV().h(aVar3.nlL, fVar.nbl.nja);
                        }
                        if (bh.ov(fVar.nbl.niZ)) {
                            aVar3.nlM.setText(fVar.field_appName);
                        } else {
                            aVar3.nlM.setText(fVar.nbl.niZ);
                        }
                        if (fVar.nbl.nfB != null) {
                            aVar3.nwk.setVisibility(0);
                            aVar3.nwk.setText(fVar.nbl.nfB.nfp);
                            try {
                                int parseColor = Color.parseColor(fVar.nbl.nfB.njt);
                                aVar3.nwk.setTextColor(parseColor);
                                Drawable background = aVar3.nwk.getBackground();
                                if (background != null && (background instanceof GradientDrawable)) {
                                    ((GradientDrawable) background).setStroke(1, parseColor);
                                }
                            } catch (Exception e) {
                                x.e("MicroMsg.MyGameInfoView", e.getMessage());
                                aVar3.nwk.setVisibility(8);
                            }
                        }
                    }
                    if (bh.ov(fVar.naQ)) {
                        aVar3.nma.setVisibility(8);
                    } else {
                        aVar3.nma.setText(fVar.nbf);
                        aVar3.nma.setVisibility(0);
                    }
                    aVar3.nsO.setTag(fVar);
                    aVar3.nsP.setTag(fVar);
                    o oVar = (o) this.nwh.get(fVar.field_appId);
                    if (oVar == null) {
                        oVar = new o(fVar);
                    }
                    this.noI.a(aVar3.nsP, aVar3.nsO, fVar, oVar);
                    aVar3.nlZ.setOnClickListener(this.nlW);
                    aVar3.nlZ.setTag(fVar);
                    inflate2.setTag(aVar3);
                    nwi.put(fVar.field_appId, inflate2);
                    this.muI.addView(inflate2);
                    Object obj2 = aVar2.ndL;
                    if (!bh.cA(obj2)) {
                        Iterator it2 = obj2.iterator();
                        while (it2.hasNext()) {
                            an anVar = (an) it2.next();
                            if (anVar != null) {
                                LayoutParams layoutParams;
                                switch (anVar.nfS) {
                                    case 1:
                                        if (!(bh.ov(anVar.nfO) || anVar.ngY == null || bh.ov(anVar.ngY.fon))) {
                                            inflate = this.nny.inflate(R.i.dkX, null);
                                            MyGameTextStyleView myGameTextStyleView = (MyGameTextStyleView) inflate.findViewById(R.h.cnp);
                                            myGameTextStyleView.ndn = this.ndn;
                                            myGameTextStyleView.appId = aVar2.ndK.field_appId;
                                            if (anVar == null || bh.ov(anVar.nfO) || anVar.ngY == null || bh.ov(anVar.ngY.fon)) {
                                                myGameTextStyleView.setVisibility(8);
                                            } else {
                                                myGameTextStyleView.setVisibility(0);
                                                if (anVar.nfO.length() > 4) {
                                                    myGameTextStyleView.nwl.setText(anVar.nfO.substring(0, 4));
                                                } else {
                                                    myGameTextStyleView.nwl.setText(anVar.nfO);
                                                }
                                                if (!bh.ov(anVar.ngW)) {
                                                    myGameTextStyleView.nwm.setText(anVar.ngW);
                                                    myGameTextStyleView.nwm.setVisibility(0);
                                                }
                                                myGameTextStyleView.jpW.setText(i.b(myGameTextStyleView.mContext, anVar.ngY.fon, myGameTextStyleView.jpW.getTextSize()));
                                                boolean z = anVar.ngY.njj;
                                                if (!bh.ov(anVar.ngY.nfe)) {
                                                    myGameTextStyleView.nwo.setText(i.b(myGameTextStyleView.mContext, anVar.ngY.nfe, myGameTextStyleView.nwo.getTextSize()));
                                                    myGameTextStyleView.nwo.setVisibility(0);
                                                }
                                                if (!bh.ov(anVar.ngY.nff)) {
                                                    e$a.a aVar4 = new e$a.a();
                                                    switch (anVar.ngY.njh) {
                                                        case 0:
                                                        case 3:
                                                            if (!z) {
                                                                myGameTextStyleView.nwp.setVisibility(0);
                                                                aVar4.nxt = true;
                                                                aVar4.nxw = R.g.bCE;
                                                                e.aRV().a(myGameTextStyleView.nwr, anVar.ngY.nff, aVar4.aRW());
                                                                MyGameTextStyleView.g(myGameTextStyleView.nws, anVar.ngY.nji);
                                                                break;
                                                            }
                                                            myGameTextStyleView.nwv.setVisibility(0);
                                                            layoutParams = (LayoutParams) myGameTextStyleView.nww.getLayoutParams();
                                                            if (myGameTextStyleView.nwo.getLineCount() < 2) {
                                                                layoutParams.addRule(15);
                                                            } else {
                                                                layoutParams.addRule(12);
                                                            }
                                                            myGameTextStyleView.nww.setLayoutParams(layoutParams);
                                                            aVar4.nxt = true;
                                                            e.aRV().a(myGameTextStyleView.nwx, anVar.ngY.nff, aVar4.aRW());
                                                            MyGameTextStyleView.g(myGameTextStyleView.nwy, anVar.ngY.nji);
                                                            break;
                                                        case 1:
                                                            break;
                                                        case 2:
                                                            myGameTextStyleView.nwq.setVisibility(0);
                                                            break;
                                                        case 4:
                                                            myGameTextStyleView.nwt.setVisibility(0);
                                                            e.aRV().a(myGameTextStyleView.nwu, anVar.ngY.nff, aVar4.aRW());
                                                            break;
                                                    }
                                                    myGameTextStyleView.nwp.setVisibility(0);
                                                    aVar4.hDY = true;
                                                    aVar4.nxw = R.g.bCD;
                                                    e.aRV().a(myGameTextStyleView.nwr, anVar.ngY.nff, aVar4.aRW());
                                                }
                                                myGameTextStyleView.setTag(anVar);
                                                myGameTextStyleView.setOnClickListener(myGameTextStyleView);
                                            }
                                            if (myGameTextStyleView.getVisibility() == 0) {
                                                e(this.muI);
                                                this.muI.addView(inflate);
                                            }
                                        }
                                        break;
                                    case 2:
                                        if (!(bh.ov(anVar.nfO) || anVar.ngZ == null || bh.ov(anVar.ngZ.nff))) {
                                            inflate = this.nny.inflate(R.i.dkW, null);
                                            MyGamePicStyleView myGamePicStyleView = (MyGamePicStyleView) inflate.findViewById(R.h.cmY);
                                            myGamePicStyleView.ndn = this.ndn;
                                            myGamePicStyleView.appId = aVar2.ndK.field_appId;
                                            if (anVar == null || bh.ov(anVar.nfO) || anVar.ngZ == null || bh.ov(anVar.ngZ.nff)) {
                                                myGamePicStyleView.setVisibility(8);
                                            } else {
                                                myGamePicStyleView.setVisibility(0);
                                                if (anVar.nfO.length() > 4) {
                                                    myGamePicStyleView.nwl.setText(anVar.nfO.substring(0, 4));
                                                } else {
                                                    myGamePicStyleView.nwl.setText(anVar.nfO);
                                                }
                                                if (!bh.ov(anVar.ngW)) {
                                                    myGamePicStyleView.nwm.setText(anVar.ngW);
                                                    myGamePicStyleView.nwm.setVisibility(0);
                                                }
                                                e$a.a aVar5 = new e$a.a();
                                                aVar5.nxw = R.g.bCB;
                                                e.aRV().a(myGamePicStyleView.nwn, anVar.ngZ.nff, aVar5.aRW());
                                                layoutParams = (LayoutParams) myGamePicStyleView.nwn.getLayoutParams();
                                                layoutParams.height = Math.round((((float) ((c.getScreenWidth(myGamePicStyleView.mContext) - myGamePicStyleView.getPaddingLeft()) - myGamePicStyleView.getPaddingRight())) / 690.0f) * 80.0f);
                                                myGamePicStyleView.nwn.setLayoutParams(layoutParams);
                                                myGamePicStyleView.setTag(anVar);
                                                myGamePicStyleView.setOnClickListener(myGamePicStyleView);
                                            }
                                            if (myGamePicStyleView.getVisibility() == 0) {
                                                e(this.muI);
                                                this.muI.addView(inflate);
                                            }
                                        }
                                        break;
                                    case 7:
                                        if (!(bh.ov(anVar.nfO) || anVar.nhb == null || bh.ov(anVar.nhb.fon))) {
                                            View inflate3 = this.nny.inflate(R.i.dkY, null);
                                            MyGameVideoRecomStyleView myGameVideoRecomStyleView = (MyGameVideoRecomStyleView) inflate3.findViewById(R.h.cyw);
                                            myGameVideoRecomStyleView.ndn = this.ndn;
                                            myGameVideoRecomStyleView.mAppId = aVar2.ndK.field_appId;
                                            if (anVar == null || bh.ov(anVar.nfO) || anVar.nhb == null || bh.ov(anVar.nhb.fon)) {
                                                myGameVideoRecomStyleView.setVisibility(8);
                                            } else {
                                                myGameVideoRecomStyleView.setVisibility(0);
                                                if (anVar.nfO.length() > 4) {
                                                    myGameVideoRecomStyleView.nwz.setText(anVar.nfO.substring(0, 4));
                                                } else {
                                                    myGameVideoRecomStyleView.nwz.setText(anVar.nfO);
                                                }
                                                if (bh.ov(anVar.ngW)) {
                                                    myGameVideoRecomStyleView.setVisibility(8);
                                                } else {
                                                    myGameVideoRecomStyleView.nwA.setText(anVar.ngW);
                                                    myGameVideoRecomStyleView.nwA.setVisibility(0);
                                                }
                                                myGameVideoRecomStyleView.lVg.setText(i.b(myGameVideoRecomStyleView.mContext, anVar.nhb.fon, myGameVideoRecomStyleView.lVg.getTextSize()));
                                                if (bh.ov(anVar.nhb.nks)) {
                                                    myGameVideoRecomStyleView.nwB.setVisibility(8);
                                                } else {
                                                    myGameVideoRecomStyleView.nwB.setText(anVar.nhb.nks);
                                                    myGameVideoRecomStyleView.nwB.setVisibility(0);
                                                }
                                                if (bh.ov(anVar.nhb.nkw)) {
                                                    myGameVideoRecomStyleView.nwC.setVisibility(8);
                                                } else {
                                                    myGameVideoRecomStyleView.nwC.setText(anVar.nhb.nkw);
                                                    myGameVideoRecomStyleView.nwC.setVisibility(0);
                                                }
                                                if (bh.ov(anVar.nhb.njl)) {
                                                    myGameVideoRecomStyleView.nwD.setVisibility(8);
                                                } else {
                                                    myGameVideoRecomStyleView.nwD.setText(anVar.nhb.njl);
                                                    myGameVideoRecomStyleView.nwD.setVisibility(0);
                                                }
                                                if (bh.ov(anVar.nhb.nff)) {
                                                    myGameVideoRecomStyleView.nwE.setVisibility(8);
                                                } else {
                                                    myGameVideoRecomStyleView.nwE.setVisibility(0);
                                                    e$a.a aVar6 = new e$a.a();
                                                    aVar6.nxt = true;
                                                    e.aRV().a(myGameVideoRecomStyleView.jKx, anVar.nhb.nff, aVar6.aRW());
                                                    if (bh.ov(anVar.nhb.nji)) {
                                                        myGameVideoRecomStyleView.nwG.setVisibility(8);
                                                    } else {
                                                        e.aRV().h(myGameVideoRecomStyleView.nwG, anVar.nhb.nji);
                                                        myGameVideoRecomStyleView.nwG.setVisibility(0);
                                                    }
                                                }
                                                myGameVideoRecomStyleView.setTag(anVar);
                                                myGameVideoRecomStyleView.setOnClickListener(myGameVideoRecomStyleView);
                                            }
                                            if (myGameVideoRecomStyleView.getVisibility() == 0) {
                                                e(this.muI);
                                                this.muI.addView(inflate3);
                                            }
                                        }
                                        break;
                                    default:
                                        if (this.nnA != 2) {
                                            break;
                                        }
                                        ap.a(this.mContext, 10, 1002, anVar.ngX, aVar2.ndK.field_appId, this.ndn, ap.BY(anVar.nfK));
                                        break;
                                }
                            }
                        }
                    }
                    obj = 1;
                }
            }
        }
        if (obj != null) {
            g(this.muI);
        }
        if (!(aVar.ndJ == null || bh.ov(aVar.ndJ.nfe) || bh.ov(aVar.ndJ.nfg))) {
            inflate = this.nny.inflate(R.i.dkU, this, false);
            ((TextView) inflate.findViewById(R.h.text)).setText(aVar.ndJ.nfe);
            inflate.setTag(aVar.ndJ.nfg);
            inflate.setOnClickListener(new 1(this));
            this.muI.addView(inflate);
            g(this.muI);
        }
        if (obj != null) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    private void g(ViewGroup viewGroup) {
        viewGroup.addView((ImageView) this.nny.inflate(R.i.dkf, viewGroup, false));
    }

    private void e(ViewGroup viewGroup) {
        ImageView imageView = (ImageView) this.nny.inflate(R.i.dkf, viewGroup, false);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) imageView.getLayoutParams();
        marginLayoutParams.leftMargin = com.tencent.mm.bv.a.fromDPToPix(this.mContext, 15);
        imageView.setLayoutParams(marginLayoutParams);
        viewGroup.addView(imageView);
    }
}
