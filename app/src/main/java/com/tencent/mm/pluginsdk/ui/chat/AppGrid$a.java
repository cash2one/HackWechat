package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.List;
import java.util.Map;

class AppGrid$a extends BaseAdapter {
    final /* synthetic */ AppGrid voK;
    List<f> voL;
    private int voM;
    private int voN;
    private Map<String, f> voO = null;

    class a {
        ImageView jMv;
        TextView jMw;
        TextView voP;
        View voQ;
        View voR;
        final /* synthetic */ AppGrid$a voS;

        a(AppGrid$a appGrid$a) {
            this.voS = appGrid$a;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return yg(i);
    }

    public AppGrid$a(AppGrid appGrid, Context context, List<f> list, Map<String, f> map) {
        this.voK = appGrid;
        this.voL = list;
        this.voO = map;
        this.voM = b.b(context, 56.0f);
        this.voN = b.b(context, 53.3f);
    }

    public final int getCount() {
        if (AppGrid.a(this.voK) == AppGrid.e(this.voK) - 1) {
            return AppGrid.f(this.voK) - (AppGrid.a(this.voK) * AppGrid.b(this.voK));
        }
        return AppGrid.b(this.voK);
    }

    public final f yg(int i) {
        if ((i < AppGrid.g(this.voK) && AppGrid.a(this.voK) == 0) || (AppGrid.a(this.voK) * AppGrid.b(this.voK)) + i < AppGrid.g(this.voK) || (i - AppGrid.g(this.voK)) + (AppGrid.a(this.voK) * AppGrid.b(this.voK)) >= this.voL.size()) {
            return null;
        }
        x.v("MicroMsg.AppGrid", "get item db pos: %d", new Object[]{Integer.valueOf((i - AppGrid.g(this.voK)) + (AppGrid.a(this.voK) * AppGrid.b(this.voK)))});
        return (f) this.voL.get((i - AppGrid.g(this.voK)) + (AppGrid.a(this.voK) * AppGrid.b(this.voK)));
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this);
            view = View.inflate(AppGrid.h(this.voK), R.i.dar, null);
            aVar.jMv = (ImageView) view.findViewById(R.h.bKt);
            aVar.voQ = view.findViewById(R.h.bKu);
            aVar.jMw = (TextView) view.findViewById(R.h.bKv);
            aVar.voP = (TextView) view.findViewById(R.h.bKw);
            aVar.voR = view.findViewById(R.h.bKx);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        x.v("MicroMsg.AppGrid", "pos:" + i + " page:" + AppGrid.a(this.voK));
        aVar.jMw.setVisibility(0);
        aVar.voR.setVisibility(8);
        aVar.voP.setVisibility(8);
        aVar.voQ.setVisibility(0);
        LayoutParams layoutParams = aVar.jMv.getLayoutParams();
        layoutParams.width = this.voM;
        layoutParams.height = this.voM;
        aVar.jMv.setLayoutParams(layoutParams);
        int a = (AppGrid.a(this.voK) * AppGrid.b(this.voK)) + i;
        int Ce = AppGrid.c(this.voK).Ce(a);
        if (a < AppGrid.g(this.voK)) {
            switch (Ce) {
                case 0:
                    aVar.jMv.setImageResource(R.k.dAd);
                    aVar.jMw.setText(AppGrid.h(this.voK).getString(R.l.dEY));
                    break;
                case 1:
                    if (!r.ien) {
                        aVar.jMv.setImageResource(R.k.dzW);
                        aVar.jMw.setText(AppGrid.h(this.voK).getString(R.l.dEW));
                        break;
                    }
                    aVar.jMv.setImageResource(R.k.dAf);
                    aVar.jMw.setText(AppGrid.h(this.voK).getString(R.l.dFc));
                    break;
                case 2:
                    aVar.jMv.setImageResource(R.k.dvK);
                    aVar.jMw.setText(AppGrid.h(this.voK).getString(R.l.dFg));
                    try {
                        ar.Hg();
                        if (!((Boolean) c.CU().get(54, Boolean.valueOf(false))).booleanValue()) {
                            aVar.voP.setVisibility(8);
                            break;
                        }
                        aVar.voP.setVisibility(0);
                        break;
                    } catch (Exception e) {
                        break;
                    }
                case 3:
                    aVar.jMv.setImageResource(R.k.dAc);
                    aVar.jMw.setText(AppGrid.h(this.voK).getString(R.l.dFh));
                    try {
                        ar.Hg();
                        if (!((Boolean) c.CU().get(81, Boolean.valueOf(false))).booleanValue()) {
                            aVar.voP.setVisibility(8);
                            break;
                        }
                        aVar.voP.setVisibility(0);
                        break;
                    } catch (Exception e2) {
                        break;
                    }
                case 4:
                    aVar.jMv.setImageResource(R.k.dAh);
                    aVar.jMw.setText(AppGrid.h(this.voK).getString(R.l.dFh));
                    try {
                        ar.Hg();
                        if (!((Boolean) c.CU().get(62, Boolean.valueOf(false))).booleanValue()) {
                            aVar.voP.setVisibility(8);
                            break;
                        }
                        aVar.voP.setVisibility(0);
                        break;
                    } catch (Exception e3) {
                        break;
                    }
                case 5:
                    aVar.jMv.setImageResource(R.k.dAi);
                    aVar.jMw.setText(AppGrid.h(this.voK).getString(R.l.dFd));
                    try {
                        ar.Hg();
                        if (!((Boolean) c.CU().get(67, Boolean.valueOf(false))).booleanValue()) {
                            aVar.voP.setVisibility(8);
                            break;
                        }
                        aVar.voP.setVisibility(0);
                        break;
                    } catch (Exception e4) {
                        break;
                    }
                case 6:
                    aVar.jMv.setImageResource(R.k.dAb);
                    aVar.jMw.setText(AppGrid.h(this.voK).getString(R.l.dEV));
                    try {
                        ar.Hg();
                        if (!((Boolean) c.CU().get(290817, Boolean.valueOf(false))).booleanValue()) {
                            aVar.voR.setVisibility(8);
                            break;
                        }
                        aVar.voR.setVisibility(0);
                        break;
                    } catch (Exception e5) {
                        break;
                    }
                case 7:
                    a(aVar, f.veh);
                    break;
                case 8:
                    a(aVar, f.vef);
                    break;
                case 9:
                    a(aVar, f.vei);
                    break;
                case 10:
                    aVar.jMv.setImageResource(R.k.dAg);
                    aVar.jMw.setText(AppGrid.h(this.voK).getString(R.l.eoQ));
                    try {
                        ar.Hg();
                        if (!((Boolean) c.CU().get(73, Boolean.valueOf(false))).booleanValue()) {
                            aVar.voP.setVisibility(8);
                            break;
                        }
                        aVar.voP.setVisibility(0);
                        break;
                    } catch (Exception e6) {
                        break;
                    }
                case 11:
                    aVar.jMv.setImageResource(R.k.dAa);
                    aVar.jMw.setText(AppGrid.h(this.voK).getString(R.l.dEQ));
                    break;
                case 12:
                    aVar.jMv.setImageResource(R.k.dzY);
                    aVar.jMw.setText(AppGrid.h(this.voK).getString(R.l.dET));
                    break;
                case 13:
                    aVar.jMv.setImageResource(R.k.dvJ);
                    aVar.jMw.setText(AppGrid.h(this.voK).getString(R.l.eaY));
                    try {
                        ar.Hg();
                        boolean booleanValue = ((Boolean) c.CU().get(208899, Boolean.valueOf(false))).booleanValue();
                        ar.Hg();
                        boolean booleanValue2 = ((Boolean) c.CU().get(208913, Boolean.valueOf(false))).booleanValue();
                        if (!booleanValue && !booleanValue2) {
                            aVar.voP.setVisibility(8);
                            break;
                        }
                        aVar.voP.setVisibility(0);
                        if (!booleanValue2) {
                            aVar.voP.setText(R.l.dFP);
                            break;
                        }
                        aVar.voP.setText(R.l.dFm);
                        break;
                    } catch (Exception e7) {
                        break;
                    }
                    break;
                case 14:
                    aVar.jMv.setImageResource(R.k.dAe);
                    aVar.jMw.setText(AppGrid.h(this.voK).getString(R.l.dFb));
                    try {
                        ar.Hg();
                        if (!((Boolean) c.CU().get(327744, Boolean.valueOf(true))).booleanValue()) {
                            aVar.voR.setVisibility(8);
                            break;
                        }
                        aVar.voR.setVisibility(0);
                        break;
                    } catch (Exception e8) {
                        break;
                    }
                case 15:
                    aVar.jMv.setImageResource(R.k.dzX);
                    aVar.jMw.setText(AppGrid.h(this.voK).getString(R.l.dES));
                    try {
                        aVar.voR.setVisibility(8);
                        break;
                    } catch (Exception e9) {
                        break;
                    }
                case 16:
                    aVar.jMv.setImageResource(R.k.dzZ);
                    aVar.jMw.setText(AppGrid.h(this.voK).getString(R.l.dEU));
                    break;
            }
        }
        layoutParams.width = this.voN;
        layoutParams.height = this.voN;
        aVar.jMv.setLayoutParams(layoutParams);
        f yg = yg(i);
        if (yg != null) {
            ar.Hg();
            if (c.isSDCardAvailable()) {
                Bitmap b;
                if (yg.field_status == 5) {
                    b = g.b(yg.field_appId, 3, com.tencent.mm.bv.a.getDensity(AppGrid.h(this.voK)));
                } else if (yg.bYD()) {
                    b = g.b(yg.field_appId, 4, com.tencent.mm.bv.a.getDensity(AppGrid.h(this.voK)));
                } else {
                    b = g.b(yg.field_appId, 1, com.tencent.mm.bv.a.getDensity(AppGrid.h(this.voK)));
                }
                if (b != null) {
                    aVar.jMv.setBackgroundDrawable(new BitmapDrawable(b));
                } else if (f.vef.equals(yg.field_appId)) {
                    aVar.jMv.setImageResource(R.g.bEA);
                } else if (f.veh.equals(yg.field_appId)) {
                    aVar.jMv.setImageResource(R.g.bEz);
                } else if (f.veg.equals(yg.field_appId)) {
                    aVar.jMv.setImageResource(R.g.bEy);
                } else if (f.vei.equals(yg.field_appId)) {
                    aVar.jMv.setImageResource(R.k.dzV);
                } else {
                    aVar.jMv.setBackgroundResource(R.g.byW);
                }
            } else {
                aVar.jMv.setBackgroundResource(R.g.bGe);
            }
            aVar.jMw.setText(g.a(AppGrid.h(this.voK), yg, null));
            if ((yg.bYD() && yg.bYE()) || yg.bYF()) {
                if (AppGrid.i(this.voK) == null) {
                    AppGrid.a(this.voK, AppGrid.h(this.voK).getSharedPreferences(ac.cfs(), 0));
                }
                if (AppGrid.i(this.voK).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + yg.field_appId, true)) {
                    aVar.voP.setVisibility(0);
                }
            }
        }
        f yg2 = yg(i);
        if (yg2 != null && g.j(yg2)) {
            aVar.voP.setVisibility(0);
        }
        return view;
    }

    private void a(a aVar, String str) {
        if (this.voO == null) {
            x.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
            return;
        }
        f fVar = (f) this.voO.get(str);
        if (fVar == null) {
            x.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
            return;
        }
        ar.Hg();
        if (c.isSDCardAvailable()) {
            Bitmap b;
            if (fVar.bYD()) {
                b = g.b(fVar.field_appId, 4, com.tencent.mm.bv.a.getDensity(AppGrid.h(this.voK)));
            } else {
                b = null;
            }
            if (b != null) {
                aVar.jMv.setBackgroundDrawable(new BitmapDrawable(b));
            } else if (f.vef.equals(fVar.field_appId)) {
                aVar.jMv.setImageResource(R.g.bEA);
            } else if (f.veh.equals(fVar.field_appId)) {
                aVar.jMv.setImageResource(R.g.bEz);
            } else if (f.veg.equals(fVar.field_appId)) {
                aVar.jMv.setImageResource(R.g.bEy);
            } else if (f.vei.equals(fVar.field_appId)) {
                aVar.jMv.setImageResource(R.k.dzV);
            } else {
                aVar.jMv.setImageResource(R.g.byW);
            }
        } else {
            aVar.jMv.setImageResource(R.g.bGe);
        }
        aVar.jMw.setText(g.a(AppGrid.h(this.voK), fVar, null));
        if (fVar.bYD() && fVar.bYE()) {
            if (AppGrid.i(this.voK) == null) {
                AppGrid.a(this.voK, AppGrid.h(this.voK).getSharedPreferences(ac.cfs(), 0));
            }
            if (AppGrid.i(this.voK).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + fVar.field_appId, true)) {
                aVar.voP.setVisibility(0);
            }
        }
        int intValue;
        if (f.vef.equals(fVar.field_appId)) {
            ar.Hg();
            intValue = ((Integer) c.CU().get(com.tencent.mm.storage.w.a.xrD, Integer.valueOf(0))).intValue();
            if (intValue > 1) {
                ar.Hg();
                if (!bh.F(((String) c.CU().get(com.tencent.mm.storage.w.a.xty, "")).split(";")).contains(String.valueOf(intValue))) {
                    aVar.voP.setVisibility(0);
                }
            }
        } else if (f.veh.equals(fVar.field_appId)) {
            ar.Hg();
            intValue = ((Integer) c.CU().get(com.tencent.mm.storage.w.a.xrD, Integer.valueOf(0))).intValue();
            if (intValue > 1) {
                ar.Hg();
                if (!bh.F(((String) c.CU().get(com.tencent.mm.storage.w.a.xtz, "")).split(";")).contains(String.valueOf(intValue))) {
                    aVar.voP.setVisibility(0);
                }
            }
        }
    }
}
