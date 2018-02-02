package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.b;
import b.c.b.i;
import b.c.b.j;
import b.c.b.l;
import b.f.a;
import com.tencent.mm.plugin.radar.a.f;
import com.tencent.mm.plugin.radar.b.c$c;
import com.tencent.mm.plugin.radar.b.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bal;
import com.tencent.mm.protocal.c.bam;
import com.tencent.mm.protocal.c.bao;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class RadarViewController extends RelativeLayout implements c$c, com.tencent.mm.plugin.radar.b.e.d {
    private static final String TAG = TAG;
    static final /* synthetic */ b.e.d[] pxT = new b.e.d[]{j.a(new i(j.R(RadarViewController.class), "waveView", "getWaveView()Lcom/tencent/mm/plugin/radar/ui/RadarWaveView;")), j.a(new i(j.R(RadarViewController.class), "memberDetailView", "getMemberDetailView()Lcom/tencent/mm/plugin/radar/ui/RadarMemberView;")), j.a(new i(j.R(RadarViewController.class), "grid", "getGrid()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;")), j.a(new i(j.R(RadarViewController.class), "radarTips", "getRadarTips()Lcom/tencent/mm/plugin/radar/ui/RadarTipsView;")), j.a(new i(j.R(RadarViewController.class), "newRadarTip", "getNewRadarTip()Landroid/widget/TextView;")), j.a(new i(j.R(RadarViewController.class), "newRadarTipLoading", "getNewRadarTipLoading()Landroid/widget/ProgressBar;")), j.a(new i(j.R(RadarViewController.class), "quitBtn", "getQuitBtn()Landroid/widget/Button;")), j.a(new i(j.R(RadarViewController.class), "radarBgMask", "getRadarBgMask()Landroid/view/View;"))};
    public static final b pzU = new b((byte) 0);
    private final b pzD = b.c.b(new h(this));
    private final b pzE = i.C(this, com.tencent.mm.plugin.radar.a.c.pvC);
    private final b pzF = i.C(this, com.tencent.mm.plugin.radar.a.c.pvR);
    private final b pzG = i.C(this, com.tencent.mm.plugin.radar.a.c.pvT);
    private final b pzH = i.C(this, com.tencent.mm.plugin.radar.a.c.pvH);
    private final b pzI = i.C(this, com.tencent.mm.plugin.radar.a.c.pvI);
    private final b pzJ = i.C(this, com.tencent.mm.plugin.radar.a.c.pvL);
    private final b pzK = i.C(this, com.tencent.mm.plugin.radar.a.c.pvy);
    e pzL;
    com.tencent.mm.plugin.radar.b.c pzM;
    c pzN;
    e.e pzO = e.e.pxz;
    private final boolean pzP;
    final OnClickListener pzQ = new f(this);
    private final int pzR = 33554432;
    private final int pzS = (this.pzR + 1);
    private final int pzT = (this.pzR + 2);

    public final class c extends a {
        private final Context context;
        bao[] pAa = new bao[12];
        HashMap<String, String> pAb = new HashMap();
        HashMap<String, Integer> pAc = new HashMap();
        final a pAd;
        private int pAe;
        HashMap<String, View> pAf = new HashMap();
        private boolean pAg;
        final /* synthetic */ RadarViewController pzY;

        public c(RadarViewController radarViewController, RadarSpecialGridView radarSpecialGridView, Context context) {
            b.c.b.e.i(radarSpecialGridView, "radarGridView");
            b.c.b.e.i(context, "context");
            this.pzY = radarViewController;
            super(radarSpecialGridView, context);
            this.context = context;
            this.pAd = new a(radarViewController);
        }

        public final int getCount() {
            if (this.pAg) {
                return 0;
            }
            return ((Object[]) this.pAa).length;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void ac(LinkedList<bao> linkedList) {
            if ((linkedList == null || linkedList.size() != 0) && linkedList != null) {
                int i;
                c cVar = this;
                int length = ((Object[]) cVar.pAa).length;
                for (i = 0; i < length; i++) {
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        bao com_tencent_mm_protocal_c_bao = (bao) it.next();
                        g gVar = g.pzC;
                        Object c = g.c(com_tencent_mm_protocal_c_bao);
                        g gVar2 = g.pzC;
                        if (b.c.b.e.h(c, g.c(cVar.pAa[i]))) {
                            linkedList.remove(com_tencent_mm_protocal_c_bao);
                            break;
                        }
                    }
                }
                Iterator it2 = linkedList.iterator();
                while (it2.hasNext()) {
                    Object obj = (bao) it2.next();
                    int abs = Math.abs(((int) System.currentTimeMillis()) % 6);
                    int length2 = this.pAa.length;
                    for (i = 0; i < length2; i++) {
                        int i2 = (i + abs) % 12;
                        if (!(i2 == 4 || i2 == 7)) {
                            int i3;
                            HashMap hashMap;
                            g gVar3;
                            bao com_tencent_mm_protocal_c_bao2 = this.pAa[i2];
                            if (com_tencent_mm_protocal_c_bao2 != null) {
                                CharSequence charSequence = com_tencent_mm_protocal_c_bao2.ksU;
                                if (charSequence == null || a.X(charSequence)) {
                                    i3 = 1;
                                } else {
                                    i3 = 0;
                                }
                                if (i3 != 0) {
                                    charSequence = com_tencent_mm_protocal_c_bao2.wcv;
                                    if (charSequence == null || a.X(charSequence)) {
                                        i3 = 1;
                                    } else {
                                        i3 = 0;
                                    }
                                }
                                i3 = 0;
                                if (i3 != 0) {
                                    this.pAa[i2] = obj;
                                    hashMap = this.pAc;
                                    gVar3 = g.pzC;
                                    b.c.b.e.h(obj, "member");
                                    hashMap.put(g.b(obj), Integer.valueOf(0));
                                    break;
                                }
                            }
                            i3 = 1;
                            if (i3 != 0) {
                                this.pAa[i2] = obj;
                                hashMap = this.pAc;
                                gVar3 = g.pzC;
                                b.c.b.e.h(obj, "member");
                                hashMap.put(g.b(obj), Integer.valueOf(0));
                                break;
                            }
                        }
                    }
                }
                if (linkedList.size() > 0) {
                    blx();
                    com.tencent.mm.plugin.radar.b.d dVar = com.tencent.mm.plugin.radar.b.d.pxd;
                    int size = linkedList.size();
                    if (com.tencent.mm.plugin.radar.b.d.fzQ == 0 && size > 0) {
                        float bls = (((float) (com.tencent.mm.plugin.radar.b.d.bls() - com.tencent.mm.plugin.radar.b.d.pwZ)) * 1.0f) / 1000.0f;
                        x.d(com.tencent.mm.plugin.radar.b.d.TAG, "FoundFirstFriendTimeSpent %s", new Object[]{Float.valueOf(bls)});
                        g gVar4 = g.pQN;
                        l lVar = l.AuT;
                        Object format = String.format("%s", Arrays.copyOf(new Object[]{Float.valueOf(bls)}, 1));
                        b.c.b.e.h(format, "java.lang.String.format(format, *args)");
                        gVar4.k(10682, format);
                    }
                    com.tencent.mm.plugin.radar.b.d.fzQ += size;
                    com.tencent.mm.plugin.radar.b.d.pxa = size + com.tencent.mm.plugin.radar.b.d.pxa;
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final View A(View view, int i) {
            b bVar = RadarViewController.pzU;
            x.d(RadarViewController.TAG, "getview RadarStatus%s", new Object[]{this.pzY.pzO});
            bao com_tencent_mm_protocal_c_bao = this.pAa[i];
            if (com_tencent_mm_protocal_c_bao != null) {
                Object obj;
                g gVar;
                String b;
                e.e eVar;
                View inflate;
                View view2;
                View findViewById;
                ImageView imageView;
                View findViewById2;
                RadarStateView radarStateView;
                View findViewById3;
                TextView textView;
                View findViewById4;
                ImageView imageView2;
                View findViewById5;
                RadarStateChooseView radarStateChooseView;
                a aVar;
                b.a aVar2;
                Object findViewById6;
                RadarStateView radarStateView2;
                RadarStateChooseView radarStateChooseView2;
                com.tencent.mm.plugin.radar.b.c.e a;
                e c;
                String str;
                com.tencent.mm.plugin.radar.b.c.e a2;
                RadarStateView radarStateView3;
                RadarStateView.a aVar3;
                boolean z;
                RadarStateView.a aVar4;
                e c2;
                String str2;
                CharSequence charSequence = com_tencent_mm_protocal_c_bao.ksU;
                if (charSequence == null || a.X(charSequence)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    charSequence = com_tencent_mm_protocal_c_bao.wcv;
                    if (charSequence == null || a.X(charSequence)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        obj = 1;
                        if (obj == null) {
                            gVar = g.pzC;
                            b = g.b(com_tencent_mm_protocal_c_bao);
                            eVar = this.pzY.pzO;
                            if (view != null) {
                                inflate = View.inflate(this.context, com.tencent.mm.plugin.radar.a.d.pvZ, null);
                                if (inflate == null) {
                                    b.c.b.e.cJy();
                                }
                                inflate.setTag(this.pzY.pzS, Integer.valueOf(this.pAd.bmj()));
                                inflate.setTag(this.pzY.pzT, this.pAd.getInAnimation());
                                view2 = inflate;
                            } else {
                                view2 = view;
                            }
                            findViewById = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvM);
                            if (findViewById != null) {
                                throw new b.i("null cannot be cast to non-null type android.widget.ImageView");
                            }
                            imageView = (ImageView) findViewById;
                            findViewById2 = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvG);
                            if (findViewById2 != null) {
                                throw new b.i("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateView");
                            }
                            radarStateView = (RadarStateView) findViewById2;
                            findViewById3 = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvO);
                            if (findViewById3 != null) {
                                throw new b.i("null cannot be cast to non-null type android.widget.TextView");
                            }
                            textView = (TextView) findViewById3;
                            findViewById4 = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvN);
                            if (findViewById4 != null) {
                                throw new b.i("null cannot be cast to non-null type android.widget.ImageView");
                            }
                            imageView2 = (ImageView) findViewById4;
                            findViewById5 = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvF);
                            if (findViewById5 != null) {
                                throw new b.i("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateChooseView");
                            }
                            radarStateChooseView = (RadarStateChooseView) findViewById5;
                            imageView.setVisibility(0);
                            radarStateView.setVisibility(0);
                            textView.setVisibility(0);
                            imageView2.setVisibility(0);
                            if (eVar != e.e.pxz || eVar == e.e.pxA) {
                                radarStateView.setVisibility(0);
                                radarStateChooseView.setVisibility(8);
                            } else {
                                radarStateView.setVisibility(8);
                                radarStateChooseView.setVisibility(0);
                            }
                            view2.setTag(new a(this, textView, imageView, radarStateView, radarStateChooseView, imageView2));
                            if (i != 7 || i % 3 == 1) {
                                obj = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvu);
                                b.c.b.e.h(obj, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                                obj.setVisibility(0);
                                obj = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvY);
                                b.c.b.e.h(obj, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                                obj.setVisibility(8);
                            } else {
                                obj = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvY);
                                b.c.b.e.h(obj, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                                obj.setVisibility(0);
                                obj = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvu);
                                b.c.b.e.h(obj, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                                obj.setVisibility(8);
                            }
                            if (view == null || view2 != view) {
                                this.pAf.put(b, view2);
                            }
                            obj = view2.getTag();
                            if (obj != null) {
                                throw new b.i("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
                            }
                            aVar = (a) obj;
                            aVar.pAh.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.pzY.getContext(), com_tencent_mm_protocal_c_bao.kub, aVar.pAh.getTextSize()));
                            aVar2 = b.a.pxS;
                            b.a.a(aVar.pAi, b);
                            findViewById6 = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvw);
                            b.c.b.e.h(findViewById6, "view.findViewById(R.id.radar_avatar_container)");
                            findViewById6.setTag(new d(this.pzY, com_tencent_mm_protocal_c_bao));
                            if (this.pzY.pzO != e.e.pxz || this.pzY.pzO == e.e.pxA) {
                                aVar.pAl.setBackgroundResource(com.tencent.mm.plugin.radar.a.b.pvt);
                                radarStateView2 = aVar.pAj;
                                radarStateView2.pyT = true;
                                radarStateView2.blN();
                                radarStateChooseView2 = aVar.pAk;
                                radarStateChooseView2.pyN = false;
                                radarStateChooseView2.setVisibility(8);
                                a = RadarViewController.c(this.pzY).a(com_tencent_mm_protocal_c_bao, false);
                                if (a == null) {
                                    a = this.pzY.pzM.HZ(b);
                                    c = RadarViewController.c(this.pzY);
                                    b.c.b.e.i(com_tencent_mm_protocal_c_bao, "member");
                                    b.c.b.e.i(a, "state");
                                    str = com_tencent_mm_protocal_c_bao.ksU;
                                    b.c.b.e.h((Object) str, "member.UserName");
                                    c.b(str, a);
                                    str = com_tencent_mm_protocal_c_bao.wcv;
                                    b.c.b.e.h((Object) str, "member.EncodeUserName");
                                    c.b(str, a);
                                }
                                a2 = RadarViewController.c(this.pzY).a(com_tencent_mm_protocal_c_bao, true);
                                radarStateView3 = aVar.pAj;
                                if (a2 == null) {
                                    a2 = com.tencent.mm.plugin.radar.b.c.e.pwH;
                                }
                                b.c.b.e.i(a2, "state");
                                radarStateView3.init();
                                radarStateView3.pyU.removeMessages(0);
                                radarStateView3.clearAnimation();
                                radarStateView3.pxy = a2;
                                radarStateView3.pyK = false;
                                radarStateView3.blN();
                                radarStateView3 = aVar.pAj;
                                b.c.b.e.i(a, "state");
                                radarStateView3.init();
                                aVar3 = RadarStateView.pyX;
                                x.d(RadarStateView.access$getTAG$cp(), " turnToState : " + a);
                                z = false;
                                if (radarStateView3.pxy != a) {
                                    radarStateView3.blN();
                                } else {
                                    if ((radarStateView3.getVisibility() != 0 ? 1 : null) != null) {
                                        radarStateView3.blP();
                                        z = true;
                                    }
                                    aVar4 = RadarStateView.pyX;
                                    x.d(RadarStateView.access$getTAG$cp(), " delay : " + z);
                                    radarStateView3.pxy = a;
                                    if (radarStateView3.pxy != com.tencent.mm.plugin.radar.b.c.e.pwH) {
                                        if (z) {
                                            radarStateView3.pyU.sendEmptyMessage(0);
                                        } else {
                                            radarStateView3.pyU.sendEmptyMessageDelayed(0, (long) (RadarStateView.blQ() + 20));
                                        }
                                    }
                                }
                                c2 = RadarViewController.c(this.pzY);
                                b.c.b.e.i(com_tencent_mm_protocal_c_bao, "member");
                                str2 = com_tencent_mm_protocal_c_bao.ksU;
                                b.c.b.e.h((Object) str2, "member.UserName");
                                c2.a(str2, null);
                                str2 = com_tencent_mm_protocal_c_bao.wcv;
                                b.c.b.e.h((Object) str2, "member.EncodeUserName");
                                c2.a(str2, null);
                                if (i == 0) {
                                    this.pAe = this.pAc.size();
                                }
                                if (this.pAc.remove(b) != null) {
                                    return view2;
                                }
                                this.pAd.h(this.pAe - this.pAc.size(), view2);
                                return view2;
                            }
                            Map map = RadarViewController.c(this.pzY).pxi;
                            g gVar2 = g.pzC;
                            if (bh.ov((String) map.get(g.c(com_tencent_mm_protocal_c_bao)))) {
                                return B(view, i);
                            }
                            radarStateView2 = aVar.pAj;
                            radarStateView2.pyT = false;
                            radarStateView2.setVisibility(8);
                            radarStateChooseView2 = aVar.pAk;
                            radarStateChooseView2.pyN = true;
                            radarStateChooseView2.blN();
                            e c3 = RadarViewController.c(this.pzY);
                            if (com_tencent_mm_protocal_c_bao != null) {
                                gVar2 = g.pzC;
                                findViewById6 = (e.a) c3.pxm.get(g.b(com_tencent_mm_protocal_c_bao));
                                if (findViewById6 == null) {
                                    findViewById6 = e.a.pxv;
                                }
                            }
                            findViewById6 = e.a.pxv;
                            if (findViewById6 != e.a.pxv) {
                                aVar.pAl.setBackgroundDrawable(null);
                            }
                            RadarStateChooseView radarStateChooseView3 = aVar.pAk;
                            b.c.b.e.i(findViewById6, DownloadInfo.STATUS);
                            if ((b.c.b.e.h(radarStateChooseView3.pyO, findViewById6) ^ 1) != 0) {
                                radarStateChooseView3.pyO = findViewById6;
                                switch (e.pyQ[radarStateChooseView3.pyO.ordinal()]) {
                                    case 1:
                                        if (radarStateChooseView3.pyN) {
                                            radarStateChooseView3.blN();
                                            radarStateChooseView3.pyK = true;
                                            radarStateChooseView3.startAnimation((Animation) radarStateChooseView3.pyL.getValue());
                                            break;
                                        }
                                        break;
                                    case 2:
                                        if (radarStateChooseView3.pyN) {
                                            radarStateChooseView3.blN();
                                            radarStateChooseView3.startAnimation((Animation) radarStateChooseView3.pyM.getValue());
                                            break;
                                        }
                                        break;
                                }
                            }
                            if (i == 0) {
                                this.pAe = this.pAc.size();
                            }
                            HashMap hashMap = this.pAc;
                            g gVar3 = g.pzC;
                            if (hashMap.remove(g.c(com_tencent_mm_protocal_c_bao)) == null) {
                                return view2;
                            }
                            this.pAd.h(this.pAe - this.pAc.size(), view2);
                            return view2;
                        }
                    }
                }
                obj = null;
                if (obj == null) {
                    gVar = g.pzC;
                    b = g.b(com_tencent_mm_protocal_c_bao);
                    eVar = this.pzY.pzO;
                    if (view != null) {
                        view2 = view;
                    } else {
                        inflate = View.inflate(this.context, com.tencent.mm.plugin.radar.a.d.pvZ, null);
                        if (inflate == null) {
                            b.c.b.e.cJy();
                        }
                        inflate.setTag(this.pzY.pzS, Integer.valueOf(this.pAd.bmj()));
                        inflate.setTag(this.pzY.pzT, this.pAd.getInAnimation());
                        view2 = inflate;
                    }
                    findViewById = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvM);
                    if (findViewById != null) {
                        imageView = (ImageView) findViewById;
                        findViewById2 = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvG);
                        if (findViewById2 != null) {
                            radarStateView = (RadarStateView) findViewById2;
                            findViewById3 = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvO);
                            if (findViewById3 != null) {
                                textView = (TextView) findViewById3;
                                findViewById4 = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvN);
                                if (findViewById4 != null) {
                                    imageView2 = (ImageView) findViewById4;
                                    findViewById5 = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvF);
                                    if (findViewById5 != null) {
                                        radarStateChooseView = (RadarStateChooseView) findViewById5;
                                        imageView.setVisibility(0);
                                        radarStateView.setVisibility(0);
                                        textView.setVisibility(0);
                                        imageView2.setVisibility(0);
                                        if (eVar != e.e.pxz) {
                                        }
                                        radarStateView.setVisibility(0);
                                        radarStateChooseView.setVisibility(8);
                                        view2.setTag(new a(this, textView, imageView, radarStateView, radarStateChooseView, imageView2));
                                        if (i != 7) {
                                        }
                                        obj = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvu);
                                        b.c.b.e.h(obj, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                                        obj.setVisibility(0);
                                        obj = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvY);
                                        b.c.b.e.h(obj, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                                        obj.setVisibility(8);
                                        this.pAf.put(b, view2);
                                        obj = view2.getTag();
                                        if (obj != null) {
                                            aVar = (a) obj;
                                            aVar.pAh.setText(com.tencent.mm.pluginsdk.ui.d.i.b(this.pzY.getContext(), com_tencent_mm_protocal_c_bao.kub, aVar.pAh.getTextSize()));
                                            aVar2 = b.a.pxS;
                                            b.a.a(aVar.pAi, b);
                                            findViewById6 = view2.findViewById(com.tencent.mm.plugin.radar.a.c.pvw);
                                            b.c.b.e.h(findViewById6, "view.findViewById(R.id.radar_avatar_container)");
                                            findViewById6.setTag(new d(this.pzY, com_tencent_mm_protocal_c_bao));
                                            if (this.pzY.pzO != e.e.pxz) {
                                            }
                                            aVar.pAl.setBackgroundResource(com.tencent.mm.plugin.radar.a.b.pvt);
                                            radarStateView2 = aVar.pAj;
                                            radarStateView2.pyT = true;
                                            radarStateView2.blN();
                                            radarStateChooseView2 = aVar.pAk;
                                            radarStateChooseView2.pyN = false;
                                            radarStateChooseView2.setVisibility(8);
                                            a = RadarViewController.c(this.pzY).a(com_tencent_mm_protocal_c_bao, false);
                                            if (a == null) {
                                                a = this.pzY.pzM.HZ(b);
                                                c = RadarViewController.c(this.pzY);
                                                b.c.b.e.i(com_tencent_mm_protocal_c_bao, "member");
                                                b.c.b.e.i(a, "state");
                                                str = com_tencent_mm_protocal_c_bao.ksU;
                                                b.c.b.e.h((Object) str, "member.UserName");
                                                c.b(str, a);
                                                str = com_tencent_mm_protocal_c_bao.wcv;
                                                b.c.b.e.h((Object) str, "member.EncodeUserName");
                                                c.b(str, a);
                                            }
                                            a2 = RadarViewController.c(this.pzY).a(com_tencent_mm_protocal_c_bao, true);
                                            radarStateView3 = aVar.pAj;
                                            if (a2 == null) {
                                                a2 = com.tencent.mm.plugin.radar.b.c.e.pwH;
                                            }
                                            b.c.b.e.i(a2, "state");
                                            radarStateView3.init();
                                            radarStateView3.pyU.removeMessages(0);
                                            radarStateView3.clearAnimation();
                                            radarStateView3.pxy = a2;
                                            radarStateView3.pyK = false;
                                            radarStateView3.blN();
                                            radarStateView3 = aVar.pAj;
                                            b.c.b.e.i(a, "state");
                                            radarStateView3.init();
                                            aVar3 = RadarStateView.pyX;
                                            x.d(RadarStateView.access$getTAG$cp(), " turnToState : " + a);
                                            z = false;
                                            if (radarStateView3.pxy != a) {
                                                if (radarStateView3.getVisibility() != 0) {
                                                }
                                                if ((radarStateView3.getVisibility() != 0 ? 1 : null) != null) {
                                                    radarStateView3.blP();
                                                    z = true;
                                                }
                                                aVar4 = RadarStateView.pyX;
                                                x.d(RadarStateView.access$getTAG$cp(), " delay : " + z);
                                                radarStateView3.pxy = a;
                                                if (radarStateView3.pxy != com.tencent.mm.plugin.radar.b.c.e.pwH) {
                                                    if (z) {
                                                        radarStateView3.pyU.sendEmptyMessageDelayed(0, (long) (RadarStateView.blQ() + 20));
                                                    } else {
                                                        radarStateView3.pyU.sendEmptyMessage(0);
                                                    }
                                                }
                                            } else {
                                                radarStateView3.blN();
                                            }
                                            c2 = RadarViewController.c(this.pzY);
                                            b.c.b.e.i(com_tencent_mm_protocal_c_bao, "member");
                                            str2 = com_tencent_mm_protocal_c_bao.ksU;
                                            b.c.b.e.h((Object) str2, "member.UserName");
                                            c2.a(str2, null);
                                            str2 = com_tencent_mm_protocal_c_bao.wcv;
                                            b.c.b.e.h((Object) str2, "member.EncodeUserName");
                                            c2.a(str2, null);
                                            if (i == 0) {
                                                this.pAe = this.pAc.size();
                                            }
                                            if (this.pAc.remove(b) != null) {
                                                return view2;
                                            }
                                            this.pAd.h(this.pAe - this.pAc.size(), view2);
                                            return view2;
                                        }
                                        throw new b.i("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
                                    }
                                    throw new b.i("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateChooseView");
                                }
                                throw new b.i("null cannot be cast to non-null type android.widget.ImageView");
                            }
                            throw new b.i("null cannot be cast to non-null type android.widget.TextView");
                        }
                        throw new b.i("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarStateView");
                    }
                    throw new b.i("null cannot be cast to non-null type android.widget.ImageView");
                }
            }
            return B(view, i);
        }

        private final View B(View view, int i) {
            if (view == null) {
                view = View.inflate(this.context, com.tencent.mm.plugin.radar.a.d.pvZ, null);
                if (view == null) {
                    b.c.b.e.cJy();
                }
                view.setTag(this.pzY.pzS, Integer.valueOf(this.pAd.bmj()));
                view.setTag(this.pzY.pzT, this.pAd.getInAnimation());
            }
            Object findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pvM);
            b.c.b.e.h(findViewById, "anotherConvertView.findV…ar_result_item_avatar_iv)");
            findViewById.setVisibility(8);
            findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pvN);
            b.c.b.e.h(findViewById, "anotherConvertView.findV…sult_item_avatar_mask_iv)");
            findViewById.setVisibility(8);
            findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pvO);
            b.c.b.e.h(findViewById, "anotherConvertView.findV…_result_item_username_tv)");
            findViewById.setVisibility(4);
            findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pvG);
            b.c.b.e.h(findViewById, "anotherConvertView.findV….radar_member_state_view)");
            findViewById.setVisibility(4);
            findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pvF);
            b.c.b.e.h(findViewById, "anotherConvertView.findV…member_state_choose_view)");
            findViewById.setVisibility(4);
            if (i == 7 || i % 3 == 1) {
                findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pvu);
                b.c.b.e.h(findViewById, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                findViewById.setVisibility(0);
                findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pvY);
                b.c.b.e.h(findViewById, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                findViewById.setVisibility(8);
            } else {
                findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pvY);
                b.c.b.e.h(findViewById, "anotherConvertView.findV…ById<View>(R.id.top_stub)");
                findViewById.setVisibility(0);
                findViewById = view.findViewById(com.tencent.mm.plugin.radar.a.c.pvu);
                b.c.b.e.h(findViewById, "anotherConvertView.findV…d<View>(R.id.bottom_stub)");
                findViewById.setVisibility(8);
            }
            return view;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void d(bao com_tencent_mm_protocal_c_bao) {
            Object obj;
            if (com_tencent_mm_protocal_c_bao != null) {
                CharSequence charSequence = com_tencent_mm_protocal_c_bao.ksU;
                if (charSequence == null || a.X(charSequence)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    charSequence = com_tencent_mm_protocal_c_bao.wcv;
                    if (charSequence == null || a.X(charSequence)) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                }
                obj = null;
                if (obj != null) {
                    g gVar = g.pzC;
                    if (com_tencent_mm_protocal_c_bao == null) {
                        b.c.b.e.cJy();
                    }
                    obj = g.b(com_tencent_mm_protocal_c_bao);
                    if (RadarViewController.c(this.pzY).pxi.containsKey(obj)) {
                        obj = RadarViewController.c(this.pzY).pxi.get(obj);
                        if (obj != null) {
                            throw new b.i("null cannot be cast to non-null type kotlin.String");
                        }
                        obj = (String) obj;
                    }
                    this.pAb.put(obj, obj);
                }
            }
            obj = 1;
            if (obj != null) {
                g gVar2 = g.pzC;
                if (com_tencent_mm_protocal_c_bao == null) {
                    b.c.b.e.cJy();
                }
                obj = g.b(com_tencent_mm_protocal_c_bao);
                if (RadarViewController.c(this.pzY).pxi.containsKey(obj)) {
                    obj = RadarViewController.c(this.pzY).pxi.get(obj);
                    if (obj != null) {
                        obj = (String) obj;
                    } else {
                        throw new b.i("null cannot be cast to non-null type kotlin.String");
                    }
                }
                this.pAb.put(obj, obj);
            }
        }
    }

    public final class d {
        private bao pxx;
        final /* synthetic */ RadarViewController pzY;

        public d(RadarViewController radarViewController, bao com_tencent_mm_protocal_c_bao) {
            b.c.b.e.i(com_tencent_mm_protocal_c_bao, "member");
            this.pzY = radarViewController;
            this.pxx = com_tencent_mm_protocal_c_bao;
        }
    }

    private final TextView bme() {
        return (TextView) this.pzH.getValue();
    }

    private final ProgressBar bmf() {
        return (ProgressBar) this.pzI.getValue();
    }

    private final View bmh() {
        return (View) this.pzK.getValue();
    }

    final RadarWaveView bma() {
        return (RadarWaveView) this.pzD.getValue();
    }

    final RadarMemberView bmb() {
        return (RadarMemberView) this.pzE.getValue();
    }

    final RadarSpecialGridView bmc() {
        return (RadarSpecialGridView) this.pzF.getValue();
    }

    final RadarTipsView bmd() {
        return (RadarTipsView) this.pzG.getValue();
    }

    final Button bmg() {
        return (Button) this.pzJ.getValue();
    }

    public RadarViewController(Context context, AttributeSet attributeSet) {
        b.c.b.e.i(context, "mContext");
        super(context, attributeSet);
        com.tencent.mm.plugin.radar.b.e.d dVar = this;
        Object applicationContext = context.getApplicationContext();
        b.c.b.e.h(applicationContext, "mContext.getApplicationContext()");
        this.pzL = new e(dVar, applicationContext);
        this.pzM = new com.tencent.mm.plugin.radar.b.c(this, context);
    }

    public static final /* synthetic */ void bmi() {
    }

    public static final /* synthetic */ e c(RadarViewController radarViewController) {
        e eVar = radarViewController.pzL;
        if (eVar == null) {
            b.c.b.e.acv("radarManager");
        }
        return eVar;
    }

    public static final /* synthetic */ c d(RadarViewController radarViewController) {
        c cVar = radarViewController.pzN;
        if (cVar == null) {
            b.c.b.e.acv("adapter");
        }
        return cVar;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        b.c.b.e.i(keyEvent, "event");
        if (i != 4 || !bmb().isShowing()) {
            return false;
        }
        bmb().dismiss();
        return true;
    }

    private final void d(String str, com.tencent.mm.plugin.radar.b.c.e eVar) {
        e eVar2 = this.pzL;
        if (eVar2 == null) {
            b.c.b.e.acv("radarManager");
        }
        if (str == null) {
            b.c.b.e.cJy();
        }
        com.tencent.mm.plugin.radar.b.c.e Ia = eVar2.Ia(str);
        if (Ia != null && Ia != eVar) {
            eVar2 = this.pzL;
            if (eVar2 == null) {
                b.c.b.e.acv("radarManager");
            }
            eVar2.b(str, eVar);
            c cVar = this.pzN;
            if (cVar == null) {
                b.c.b.e.acv("adapter");
            }
            cVar.blx();
        }
    }

    public final void a(boolean z, boolean z2, String str, String str2, long j) {
        e eVar;
        if (z) {
            d(str2, com.tencent.mm.plugin.radar.b.c.e.pwJ);
        } else if (z2) {
            d(str2, com.tencent.mm.plugin.radar.b.c.e.pwI);
        } else {
            RadarTipsView bmd = bmd();
            if (str == null) {
                str = "";
            }
            bmd.Ib(str);
            eVar = this.pzL;
            if (eVar == null) {
                b.c.b.e.acv("radarManager");
            }
            com.tencent.mm.plugin.radar.b.e.c cVar = (com.tencent.mm.plugin.radar.b.e.c) eVar.pxl.get(Long.valueOf(j));
            if (cVar != null) {
                g gVar = g.pzC;
                d(g.b(cVar.pxx), cVar.pxy);
                gVar = g.pzC;
                d(g.c(cVar.pxx), cVar.pxy);
            }
        }
        eVar = this.pzL;
        if (eVar == null) {
            b.c.b.e.acv("radarManager");
        }
        eVar.pxl.remove(Long.valueOf(j));
    }

    public final void a(boolean z, String str, String str2, long j) {
        e eVar;
        if (z) {
            d(str2, com.tencent.mm.plugin.radar.b.c.e.pwJ);
        } else {
            RadarTipsView bmd = bmd();
            if (str == null) {
                str = "";
            }
            bmd.Ib(str);
            eVar = this.pzL;
            if (eVar == null) {
                b.c.b.e.acv("radarManager");
            }
            com.tencent.mm.plugin.radar.b.e.c cVar = (com.tencent.mm.plugin.radar.b.e.c) eVar.pxl.get(Long.valueOf(j));
            if (cVar != null) {
                g gVar = g.pzC;
                d(g.b(cVar.pxx), cVar.pxy);
            }
        }
        eVar = this.pzL;
        if (eVar == null) {
            b.c.b.e.acv("radarManager");
        }
        eVar.pxl.remove(Long.valueOf(j));
    }

    public final void J(com.tencent.mm.storage.x xVar) {
        b.c.b.e.i(xVar, "contact");
        e eVar = this.pzL;
        if (eVar == null) {
            b.c.b.e.acv("radarManager");
        }
        Object username = xVar.getUsername();
        b.c.b.e.h(username, "contact.username");
        if (eVar.Ia(username) == null) {
            eVar = this.pzL;
            if (eVar == null) {
                b.c.b.e.acv("radarManager");
            }
            username = xVar.vS();
            b.c.b.e.h(username, "contact.encryptUsername");
            if (eVar.Ia(username) == null) {
                LinkedList linkedList = new LinkedList();
                username = xVar.getUsername();
                b.c.b.e.h(username, "contact.username");
                Object vS = xVar.vS();
                b.c.b.e.h(vS, "contact.encryptUsername");
                Object vP = xVar.vP();
                b.c.b.e.h(vP, "contact.nickname");
                bao com_tencent_mm_protocal_c_bao = new bao();
                com_tencent_mm_protocal_c_bao.wEs = 100;
                com_tencent_mm_protocal_c_bao.ksU = username;
                com_tencent_mm_protocal_c_bao.kub = vP;
                com_tencent_mm_protocal_c_bao.wao = "";
                com_tencent_mm_protocal_c_bao.wcv = vS;
                linkedList.add(com_tencent_mm_protocal_c_bao);
                aa(linkedList);
            }
        }
        if (bmb().isShowing()) {
            RadarMemberView bmb = bmb();
            username = xVar.vS();
            b.c.b.e.h(username, "contact.encryptUsername");
            bmb.c(username, com.tencent.mm.plugin.radar.b.c.e.pwK);
        }
        d(xVar.getUsername(), com.tencent.mm.plugin.radar.b.c.e.pwK);
        d(xVar.vS(), com.tencent.mm.plugin.radar.b.c.e.pwK);
    }

    public final void I(com.tencent.mm.storage.x xVar) {
        b.c.b.e.i(xVar, "contact");
        if (bmb().isShowing()) {
            RadarMemberView bmb = bmb();
            Object vS = xVar.vS();
            b.c.b.e.h(vS, "contact.encryptUsername");
            bmb.c(vS, com.tencent.mm.plugin.radar.b.c.e.pwJ);
        }
        d(xVar.getUsername(), com.tencent.mm.plugin.radar.b.c.e.pwJ);
        d(xVar.vS(), com.tencent.mm.plugin.radar.b.c.e.pwJ);
    }

    public final void ht(boolean z) {
    }

    public final void a(int i, int i2, LinkedList<bao> linkedList) {
        if (i == 0 && i2 == 0) {
            aa(linkedList);
            return;
        }
        x.e(TAG, "radar member return error : %s, type : %s ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
        if (2 == i) {
            RadarTipsView bmd = bmd();
            Object string = getContext().getString(f.exE);
            b.c.b.e.h(string, "context.getString(R.string.net_warn_no_network)");
            bmd.Ib(string);
            return;
        }
        bmd = bmd();
        string = getContext().getString(f.pwp);
        b.c.b.e.h(string, "context.getString(R.string.radar_tips_network_err)");
        bmd.Ib(string);
    }

    public final void b(int i, int i2, LinkedList<bal> linkedList) {
        int i3 = 0;
        if (i == 0 && i2 == 0 && linkedList != null) {
            a(e.e.pxC);
            c cVar = this.pzN;
            if (cVar == null) {
                b.c.b.e.acv("adapter");
            }
            c(cVar.pzY).pxm.clear();
            c(cVar.pzY).pxi.clear();
            cVar.pAb.clear();
            cVar.pAc.clear();
            LinkedList linkedList2 = null;
            if (linkedList != null && linkedList.size() > 0) {
                int i4;
                LinkedList linkedList3 = new LinkedList();
                int size = linkedList.size();
                for (i4 = 0; i4 < size; i4++) {
                    bal com_tencent_mm_protocal_c_bal = (bal) linkedList.get(i4);
                    bam com_tencent_mm_protocal_c_bam = new bam();
                    com_tencent_mm_protocal_c_bam.wHg = com_tencent_mm_protocal_c_bal.ksU;
                    linkedList3.add(com_tencent_mm_protocal_c_bam);
                    Map map = c(cVar.pzY).pxi;
                    Object obj = com_tencent_mm_protocal_c_bal.wcv;
                    b.c.b.e.h(obj, "radarchatroomMember.EncodeUserName");
                    Object obj2 = com_tencent_mm_protocal_c_bal.ksU;
                    b.c.b.e.h(obj2, "radarchatroomMember.UserName");
                    map.put(obj, obj2);
                    HashMap hashMap = cVar.pAc;
                    g gVar = g.pzC;
                    hashMap.put(g.a(com_tencent_mm_protocal_c_bal), Integer.valueOf(0));
                }
                i4 = ((Object[]) cVar.pAa).length;
                while (i3 < i4) {
                    bao com_tencent_mm_protocal_c_bao = cVar.pAa[i3];
                    Map map2 = c(cVar.pzY).pxi;
                    g gVar2 = g.pzC;
                    if (!bh.ov((String) map2.get(g.c(com_tencent_mm_protocal_c_bao)))) {
                        d(cVar.pzY).d(com_tencent_mm_protocal_c_bao);
                        c(cVar.pzY).a(com_tencent_mm_protocal_c_bao);
                    }
                    i3++;
                }
                linkedList2 = linkedList3;
            }
            c(cVar.pzY).pxh = linkedList2;
            c cVar2 = this.pzN;
            if (cVar2 == null) {
                b.c.b.e.acv("adapter");
            }
            cVar2.blx();
            return;
        }
        a(e.e.pxz);
        RadarTipsView bmd = bmd();
        Object string = getContext().getString(f.pwp);
        b.c.b.e.h(string, "context.getString(R.string.radar_tips_network_err)");
        bmd.Ib(string);
    }

    private final void aa(LinkedList<bao> linkedList) {
        c cVar;
        if (linkedList == null) {
            b.c.b.e.cJy();
        }
        if (linkedList.size() == 0) {
            c cVar2 = this.pzN;
            if (cVar2 == null) {
                b.c.b.e.acv("adapter");
            }
            if (cVar2.getCount() == 0) {
                bmd().hv(true);
                x.d(TAG, "members got, size : " + linkedList.size());
                x.d(TAG, "has friend:%s", new Object[]{String.valueOf(ab(linkedList))});
                cVar = this.pzN;
                if (cVar == null) {
                    b.c.b.e.acv("adapter");
                }
                cVar.ac(linkedList);
                if (this.pzP && r0) {
                    a(e.e.pxA);
                    return;
                }
            }
        }
        bmd().hv(false);
        x.d(TAG, "members got, size : " + linkedList.size());
        x.d(TAG, "has friend:%s", new Object[]{String.valueOf(ab(linkedList))});
        cVar = this.pzN;
        if (cVar == null) {
            b.c.b.e.acv("adapter");
        }
        cVar.ac(linkedList);
        if (this.pzP) {
        }
    }

    private final boolean ab(LinkedList<bao> linkedList) {
        boolean z = false;
        if (linkedList == null) {
            b.c.b.e.cJy();
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.radar.b.c.e HZ;
            boolean z2;
            bao com_tencent_mm_protocal_c_bao = (bao) it.next();
            e eVar = this.pzL;
            if (eVar == null) {
                b.c.b.e.acv("radarManager");
            }
            b.c.b.e.h((Object) com_tencent_mm_protocal_c_bao, "member");
            com.tencent.mm.plugin.radar.b.c.e a = eVar.a(com_tencent_mm_protocal_c_bao, false);
            if (a == null) {
                g gVar = g.pzC;
                String b = g.b(com_tencent_mm_protocal_c_bao);
                HZ = this.pzM.HZ(b);
                e eVar2 = this.pzL;
                if (eVar2 == null) {
                    b.c.b.e.acv("radarManager");
                }
                eVar2.b(b, HZ);
            } else {
                HZ = a;
            }
            if (HZ == com.tencent.mm.plugin.radar.b.c.e.pwJ) {
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        return z;
    }

    private final void a(e.e eVar) {
        this.pzO = eVar;
        e eVar2;
        switch (h.pAn[eVar.ordinal()]) {
            case 1:
                bmh().setVisibility(8);
                bmg().setText(f.pwm);
                bmf().setVisibility(8);
                bme().setText("");
                bma().bmk();
                bma().setVisibility(0);
                eVar2 = this.pzL;
                if (eVar2 == null) {
                    b.c.b.e.acv("radarManager");
                }
                eVar2.blt();
                return;
            case 2:
                bmh().setVisibility(8);
                bmf().setVisibility(8);
                bme().setText("");
                return;
            case 3:
                if (bmh().getVisibility() != 0) {
                    bmh().setAnimation(AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.radar.a.a.pvk));
                    bmh().setVisibility(0);
                }
                bmg().setText(f.dEn);
                eVar2 = this.pzL;
                if (eVar2 == null) {
                    b.c.b.e.acv("radarManager");
                }
                eVar2.blu();
                bmf().setVisibility(0);
                bme().setText(f.pwn);
                bma().bml();
                bma().setVisibility(4);
                bmc().setVisibility(4);
                c cVar = this.pzN;
                if (cVar == null) {
                    b.c.b.e.acv("adapter");
                }
                cVar.pAc.clear();
                cVar.pAf.clear();
                for (String str : cVar.pAf.keySet()) {
                    Object obj = (View) cVar.pAf.get(str);
                    if (obj != null) {
                        a aVar = cVar.pAd;
                        b.c.b.e.h(obj, "it");
                        b.c.b.e.i(obj, "view");
                        int cq = aVar.cq(obj);
                        if (cq > 0) {
                            aVar.pzX.removeMessages(cq);
                        }
                        obj.clearAnimation();
                    }
                }
                cVar.blx();
                return;
            case 4:
                bmh().setVisibility(0);
                eVar2 = this.pzL;
                if (eVar2 == null) {
                    b.c.b.e.acv("radarManager");
                }
                eVar2.blu();
                bmf().setVisibility(8);
                bme().setText(f.pwj);
                bmc().setVisibility(0);
                return;
            case 5:
                bmh().setVisibility(8);
                eVar2 = this.pzL;
                if (eVar2 == null) {
                    b.c.b.e.acv("radarManager");
                }
                eVar2.blu();
                bmf().setVisibility(0);
                bme().setText(f.pwk);
                return;
            default:
                return;
        }
    }
}
