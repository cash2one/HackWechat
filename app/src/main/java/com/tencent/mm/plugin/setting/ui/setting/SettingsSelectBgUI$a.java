package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.az.a;
import com.tencent.mm.az.m;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.o;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class SettingsSelectBgUI$a extends o<m> {
    private Context context;
    private int kYJ;
    final /* synthetic */ SettingsSelectBgUI qkZ;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (m) obj;
        if (obj == null) {
            obj = new m();
        }
        obj.b(cursor);
        return obj;
    }

    public SettingsSelectBgUI$a(SettingsSelectBgUI settingsSelectBgUI, Context context, int i) {
        this.qkZ = settingsSelectBgUI;
        super(context, new m());
        this.context = context;
        this.kYJ = i;
    }

    public final int getCount() {
        return getCursor().getCount() + 2;
    }

    protected final void Xz() {
        Xy();
    }

    public final void Xy() {
        n QH = r.QH();
        setCursor(QH.hhp.a(new StringBuilder("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=1").toString(), null, 0));
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.context, R.i.dsi, null);
            view.setLayoutParams(new LayoutParams(this.kYJ, this.kYJ));
            b bVar2 = new b();
            bVar2.qmF = (LinearLayout) view.findViewById(R.h.cKE);
            bVar2.qmG = (LinearLayout) view.findViewById(R.h.cKD);
            bVar2.qmH = (LinearLayout) view.findViewById(R.h.cKG);
            bVar2.qmI = (LinearLayout) view.findViewById(R.h.cKH);
            bVar2.qmJ = (LinearLayout) view.findViewById(R.h.cKC);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        ar.Hg();
        int a = bh.a((Integer) c.CU().get(12311, null), -2);
        a lM = r.QI().lM(SettingsSelectBgUI.f(this.qkZ));
        if (i != 0) {
            if (i != 1) {
                Bitmap UN;
                m mVar = (m) getItem(i - 2);
                r.QH();
                ar.Hg();
                if (c.isSDCardAvailable()) {
                    UN = d.UN(n.QE() + n.bf(mVar.id, mVar.fvM));
                } else {
                    UN = BitmapFactory.decodeResource(this.qkZ.getResources(), R.g.bEj);
                }
                if (UN != null) {
                    ((ImageView) view.findViewById(R.h.cKF)).setImageBitmap(d.a(UN, true, 10.0f));
                    switch (mVar.status) {
                        case 1:
                            if (!SettingsSelectBgUI.c(this.qkZ) && lM != null && lM.hJl != mVar.id) {
                                bVar.Jd("downloaded");
                                break;
                            }
                            bVar.Jd("using");
                            break;
                            break;
                        case 2:
                            if (!SettingsSelectBgUI.c(this.qkZ) && lM != null && lM.hJl == mVar.id) {
                                bVar.Jd("using");
                                break;
                            }
                            bVar.Jd("downloaded");
                            break;
                            break;
                        case 3:
                            bVar.Jd("downloading");
                            break;
                        case 4:
                            bVar.Jd("canceling");
                            break;
                        case 5:
                            bVar.Jd("undownloaded");
                            break;
                        default:
                            break;
                    }
                }
            }
            if (!(SettingsSelectBgUI.c(this.qkZ) && a == 0) && (!(!SettingsSelectBgUI.c(this.qkZ) && a == 0 && lM == null) && (lM == null || lM.hJl != 0))) {
                bVar.Jd("downloaded");
            } else {
                bVar.Jd("using");
            }
            ((ImageView) view.findViewById(R.h.cKF)).setImageBitmap(d.a(BitmapFactory.decodeResource(this.context.getResources(), R.g.bAZ), true, 10.0f));
        } else {
            if (!(SettingsSelectBgUI.c(this.qkZ) && a == -2) && (!(!SettingsSelectBgUI.c(this.qkZ) && a == -2 && lM == null) && (lM == null || lM.hJl != -2))) {
                bVar.Jd("downloaded");
            } else {
                bVar.Jd("using");
            }
            ((ImageView) view.findViewById(R.h.cKF)).setImageBitmap(d.a(BitmapFactory.decodeResource(this.context.getResources(), R.g.bBa), true, 10.0f));
        }
        return view;
    }
}
