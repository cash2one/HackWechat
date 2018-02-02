package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import b.i;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.plugin.radar.ui.RadarViewController.b;
import com.tencent.mm.plugin.radar.ui.RadarViewController.c;
import com.tencent.mm.protocal.c.bao;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class RadarViewController$g implements com.tencent.mm.plugin.radar.ui.RadarSpecialGridView.a {
    final /* synthetic */ RadarViewController pzY;

    static final class a implements Runnable {
        final /* synthetic */ RadarViewController$g pAo;
        final /* synthetic */ View pAp;
        final /* synthetic */ e pAq;
        final /* synthetic */ bao pyr;

        a(RadarViewController$g radarViewController$g, View view, bao com_tencent_mm_protocal_c_bao, e eVar) {
            this.pAo = radarViewController$g;
            this.pAp = view;
            this.pyr = com_tencent_mm_protocal_c_bao;
            this.pAq = eVar;
        }

        public final void run() {
            RadarViewController.g(this.pAo.pzY).a(this.pAp, this.pyr, this.pAq);
            RadarViewController.f(this.pAo.pzY).bml();
        }
    }

    RadarViewController$g(RadarViewController radarViewController) {
        this.pzY = radarViewController;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(int i, View view) {
        int i2 = 0;
        b.c.b.e.i(view, "view");
        bao com_tencent_mm_protocal_c_bao = RadarViewController.d(this.pzY).pAa[i];
        if (com_tencent_mm_protocal_c_bao != null) {
            g gVar;
            CharSequence charSequence;
            int i3;
            Object tag;
            switch (h.pyQ[this.pzY.pzO.ordinal()]) {
                case 1:
                case 2:
                    View view2;
                    e a;
                    gVar = g.pzC;
                    String b = g.b(com_tencent_mm_protocal_c_bao);
                    if (com_tencent_mm_protocal_c_bao != null) {
                        charSequence = com_tencent_mm_protocal_c_bao.ksU;
                        if (charSequence == null || b.f.a.X(charSequence)) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (i3 != 0) {
                            charSequence = com_tencent_mm_protocal_c_bao.wcv;
                            if (charSequence != null && !b.f.a.X(charSequence)) {
                                i3 = 0;
                                break;
                            } else {
                                i3 = 1;
                                break;
                            }
                        }
                        if (i2 == 0) {
                            view2 = (View) RadarViewController.d(this.pzY).pAf.get(b);
                            a = com.tencent.mm.plugin.radar.b.e.a(RadarViewController.c(this.pzY), com_tencent_mm_protocal_c_bao);
                            if (view2 != null || a == e.pwH) {
                                RadarViewController.g(this.pzY).a(view, com_tencent_mm_protocal_c_bao, a);
                                RadarViewController.f(this.pzY).bml();
                                return;
                            }
                            tag = view2.getTag();
                            if (tag == null) {
                                throw new i("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
                            }
                            ((com.tencent.mm.plugin.radar.ui.RadarViewController.c.a) tag).pAj.blP();
                            af afVar = new af();
                            Runnable aVar = new a(this, view, com_tencent_mm_protocal_c_bao, a);
                            com.tencent.mm.plugin.radar.ui.RadarStateView.a aVar2 = RadarStateView.pyX;
                            afVar.postDelayed(aVar, (long) RadarStateView.blQ());
                            return;
                        }
                        return;
                    }
                    i2 = 1;
                    if (i2 == 0) {
                        view2 = (View) RadarViewController.d(this.pzY).pAf.get(b);
                        a = com.tencent.mm.plugin.radar.b.e.a(RadarViewController.c(this.pzY), com_tencent_mm_protocal_c_bao);
                        if (view2 != null) {
                            break;
                        }
                        RadarViewController.g(this.pzY).a(view, com_tencent_mm_protocal_c_bao, a);
                        RadarViewController.f(this.pzY).bml();
                        return;
                    }
                    return;
                case 3:
                    c d;
                    if (com_tencent_mm_protocal_c_bao != null) {
                        charSequence = com_tencent_mm_protocal_c_bao.ksU;
                        if (charSequence == null || b.f.a.X(charSequence)) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        if (i3 != 0) {
                            charSequence = com_tencent_mm_protocal_c_bao.wcv;
                            if (charSequence != null && !b.f.a.X(charSequence)) {
                                i3 = 0;
                                break;
                            } else {
                                i3 = 1;
                                break;
                            }
                        }
                        i3 = 0;
                        if (i3 == 0) {
                            d = RadarViewController.d(this.pzY);
                            if (com_tencent_mm_protocal_c_bao != null) {
                                gVar = g.pzC;
                                tag = g.b(com_tencent_mm_protocal_c_bao);
                                if (RadarViewController.c(d.pzY).pxi.containsKey(tag)) {
                                    tag = RadarViewController.c(d.pzY).pxi.get(tag);
                                    if (tag != null) {
                                        throw new i("null cannot be cast to non-null type kotlin.String");
                                    }
                                    tag = (String) tag;
                                }
                                if (d.pAb.containsKey(tag)) {
                                    i3 = 1;
                                    if (i3 != 0) {
                                        RadarViewController.d(this.pzY).d(com_tencent_mm_protocal_c_bao);
                                    } else {
                                        d = RadarViewController.d(this.pzY);
                                        if (com_tencent_mm_protocal_c_bao != null) {
                                            charSequence = com_tencent_mm_protocal_c_bao.ksU;
                                            i3 = (charSequence != null || b.f.a.X(charSequence)) ? 1 : 0;
                                            if (i3 != 0) {
                                                charSequence = com_tencent_mm_protocal_c_bao.wcv;
                                                if (charSequence == null && !b.f.a.X(charSequence)) {
                                                    i3 = 0;
                                                    break;
                                                } else {
                                                    i3 = 1;
                                                    break;
                                                }
                                            }
                                            i3 = 0;
                                            if (i3 == 0) {
                                                gVar = g.pzC;
                                                if (com_tencent_mm_protocal_c_bao == null) {
                                                    b.c.b.e.cJy();
                                                }
                                                tag = g.b(com_tencent_mm_protocal_c_bao);
                                                if (RadarViewController.c(d.pzY).pxi.containsKey(tag)) {
                                                    tag = RadarViewController.c(d.pzY).pxi.get(tag);
                                                    if (tag != null) {
                                                        throw new i("null cannot be cast to non-null type kotlin.String");
                                                    }
                                                    tag = (String) tag;
                                                }
                                                d.pAb.remove(tag);
                                            }
                                        }
                                        i3 = 1;
                                        if (i3 == 0) {
                                            gVar = g.pzC;
                                            if (com_tencent_mm_protocal_c_bao == null) {
                                                b.c.b.e.cJy();
                                            }
                                            tag = g.b(com_tencent_mm_protocal_c_bao);
                                            if (RadarViewController.c(d.pzY).pxi.containsKey(tag)) {
                                                tag = RadarViewController.c(d.pzY).pxi.get(tag);
                                                if (tag != null) {
                                                    tag = (String) tag;
                                                } else {
                                                    throw new i("null cannot be cast to non-null type kotlin.String");
                                                }
                                            }
                                            d.pAb.remove(tag);
                                        }
                                    }
                                }
                            }
                            i3 = 0;
                            if (i3 != 0) {
                                d = RadarViewController.d(this.pzY);
                                if (com_tencent_mm_protocal_c_bao != null) {
                                    charSequence = com_tencent_mm_protocal_c_bao.ksU;
                                    if (charSequence != null) {
                                        break;
                                    }
                                    if (i3 != 0) {
                                        charSequence = com_tencent_mm_protocal_c_bao.wcv;
                                        if (charSequence == null) {
                                            break;
                                        }
                                        i3 = 1;
                                    }
                                    i3 = 0;
                                    if (i3 == 0) {
                                        gVar = g.pzC;
                                        if (com_tencent_mm_protocal_c_bao == null) {
                                            b.c.b.e.cJy();
                                        }
                                        tag = g.b(com_tencent_mm_protocal_c_bao);
                                        if (RadarViewController.c(d.pzY).pxi.containsKey(tag)) {
                                            tag = RadarViewController.c(d.pzY).pxi.get(tag);
                                            if (tag != null) {
                                                throw new i("null cannot be cast to non-null type kotlin.String");
                                            }
                                            tag = (String) tag;
                                        }
                                        d.pAb.remove(tag);
                                    }
                                }
                                i3 = 1;
                                if (i3 == 0) {
                                    gVar = g.pzC;
                                    if (com_tencent_mm_protocal_c_bao == null) {
                                        b.c.b.e.cJy();
                                    }
                                    tag = g.b(com_tencent_mm_protocal_c_bao);
                                    if (RadarViewController.c(d.pzY).pxi.containsKey(tag)) {
                                        tag = RadarViewController.c(d.pzY).pxi.get(tag);
                                        if (tag != null) {
                                            tag = (String) tag;
                                        } else {
                                            throw new i("null cannot be cast to non-null type kotlin.String");
                                        }
                                    }
                                    d.pAb.remove(tag);
                                }
                            } else {
                                RadarViewController.d(this.pzY).d(com_tencent_mm_protocal_c_bao);
                            }
                        }
                        RadarViewController.c(this.pzY).a(com_tencent_mm_protocal_c_bao);
                        RadarViewController.bmi();
                        RadarViewController.d(this.pzY).blx();
                        return;
                    }
                    i3 = 1;
                    if (i3 == 0) {
                        d = RadarViewController.d(this.pzY);
                        if (com_tencent_mm_protocal_c_bao != null) {
                            gVar = g.pzC;
                            tag = g.b(com_tencent_mm_protocal_c_bao);
                            if (RadarViewController.c(d.pzY).pxi.containsKey(tag)) {
                                tag = RadarViewController.c(d.pzY).pxi.get(tag);
                                if (tag != null) {
                                    tag = (String) tag;
                                } else {
                                    throw new i("null cannot be cast to non-null type kotlin.String");
                                }
                            }
                            if (d.pAb.containsKey(tag)) {
                                i3 = 1;
                                if (i3 != 0) {
                                    RadarViewController.d(this.pzY).d(com_tencent_mm_protocal_c_bao);
                                } else {
                                    d = RadarViewController.d(this.pzY);
                                    if (com_tencent_mm_protocal_c_bao != null) {
                                        charSequence = com_tencent_mm_protocal_c_bao.ksU;
                                        if (charSequence != null) {
                                        }
                                        if (i3 != 0) {
                                            charSequence = com_tencent_mm_protocal_c_bao.wcv;
                                            if (charSequence == null) {
                                            }
                                            i3 = 1;
                                        }
                                        i3 = 0;
                                        if (i3 == 0) {
                                            gVar = g.pzC;
                                            if (com_tencent_mm_protocal_c_bao == null) {
                                                b.c.b.e.cJy();
                                            }
                                            tag = g.b(com_tencent_mm_protocal_c_bao);
                                            if (RadarViewController.c(d.pzY).pxi.containsKey(tag)) {
                                                tag = RadarViewController.c(d.pzY).pxi.get(tag);
                                                if (tag != null) {
                                                    throw new i("null cannot be cast to non-null type kotlin.String");
                                                }
                                                tag = (String) tag;
                                            }
                                            d.pAb.remove(tag);
                                        }
                                    }
                                    i3 = 1;
                                    if (i3 == 0) {
                                        gVar = g.pzC;
                                        if (com_tencent_mm_protocal_c_bao == null) {
                                            b.c.b.e.cJy();
                                        }
                                        tag = g.b(com_tencent_mm_protocal_c_bao);
                                        if (RadarViewController.c(d.pzY).pxi.containsKey(tag)) {
                                            tag = RadarViewController.c(d.pzY).pxi.get(tag);
                                            if (tag != null) {
                                                tag = (String) tag;
                                            } else {
                                                throw new i("null cannot be cast to non-null type kotlin.String");
                                            }
                                        }
                                        d.pAb.remove(tag);
                                    }
                                }
                            }
                        }
                        i3 = 0;
                        if (i3 != 0) {
                            d = RadarViewController.d(this.pzY);
                            if (com_tencent_mm_protocal_c_bao != null) {
                                charSequence = com_tencent_mm_protocal_c_bao.ksU;
                                if (charSequence != null) {
                                }
                                if (i3 != 0) {
                                    charSequence = com_tencent_mm_protocal_c_bao.wcv;
                                    if (charSequence == null) {
                                    }
                                    i3 = 1;
                                }
                                i3 = 0;
                                if (i3 == 0) {
                                    gVar = g.pzC;
                                    if (com_tencent_mm_protocal_c_bao == null) {
                                        b.c.b.e.cJy();
                                    }
                                    tag = g.b(com_tencent_mm_protocal_c_bao);
                                    if (RadarViewController.c(d.pzY).pxi.containsKey(tag)) {
                                        tag = RadarViewController.c(d.pzY).pxi.get(tag);
                                        if (tag != null) {
                                            throw new i("null cannot be cast to non-null type kotlin.String");
                                        }
                                        tag = (String) tag;
                                    }
                                    d.pAb.remove(tag);
                                }
                            }
                            i3 = 1;
                            if (i3 == 0) {
                                gVar = g.pzC;
                                if (com_tencent_mm_protocal_c_bao == null) {
                                    b.c.b.e.cJy();
                                }
                                tag = g.b(com_tencent_mm_protocal_c_bao);
                                if (RadarViewController.c(d.pzY).pxi.containsKey(tag)) {
                                    tag = RadarViewController.c(d.pzY).pxi.get(tag);
                                    if (tag != null) {
                                        tag = (String) tag;
                                    } else {
                                        throw new i("null cannot be cast to non-null type kotlin.String");
                                    }
                                }
                                d.pAb.remove(tag);
                            }
                        } else {
                            RadarViewController.d(this.pzY).d(com_tencent_mm_protocal_c_bao);
                        }
                    }
                    RadarViewController.c(this.pzY).a(com_tencent_mm_protocal_c_bao);
                    RadarViewController.bmi();
                    RadarViewController.d(this.pzY).blx();
                    return;
                default:
                    b bVar = RadarViewController.pzU;
                    x.d(RadarViewController.access$getTAG$cp(), "unknow status for grid view %s", new Object[]{this.pzY.pzO});
                    return;
            }
        }
    }
}
