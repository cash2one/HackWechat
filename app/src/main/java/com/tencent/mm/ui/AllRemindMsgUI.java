package com.tencent.mm.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.c.bhf;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.y.g.a;
import com.tencent.mm.z.ar;
import java.util.Iterator;
import java.util.LinkedList;
import org.xwalk.core.R$styleable;

public class AllRemindMsgUI extends MMActivity implements e {
    private static final f<Integer, c> hdO = new f(32);
    private RecyclerView Va;
    private LinkedList<d> kPY;
    private ProgressBar lpy;
    private View xDD;
    private b xDE;
    private a xDF = new a(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(866, this.xDF);
        ar.CG().a(525, this);
        g.pQN.a(795, 3, 1, false);
        initView();
        com.tencent.mm.sdk.f.e.post(new a(this), "load remind data!");
    }

    protected void onDestroy() {
        super.onDestroy();
        ar.CG().b(866, this.xDF);
        ar.CG().b(525, this);
    }

    protected final void initView() {
        setMMTitle(R.l.eEy);
        this.Va = (RecyclerView) findViewById(R.h.bKa);
        this.lpy = (ProgressBar) findViewById(R.h.cDY);
        this.xDD = findViewById(R.h.coB);
        this.Va.setVisibility(8);
        RecyclerView recyclerView = this.Va;
        ActionBarActivity actionBarActivity = this.mController.xIM;
        recyclerView.a(new LinearLayoutManager());
        this.xDE = new b(this);
        this.Va.a(this.xDE);
        this.xDE.a(new RecyclerView.c(this) {
            final /* synthetic */ AllRemindMsgUI xDG;

            {
                this.xDG = r1;
            }

            public final void onChanged() {
                super.onChanged();
                x.i("MicroMsg.emoji.AllRemindMsgUI", "[onChanged] size:%s", new Object[]{Integer.valueOf(this.xDG.xDE.getItemCount())});
                if (this.xDG.xDE.getItemCount() == 0) {
                    this.xDG.xDD.setVisibility(0);
                    this.xDG.Va.setVisibility(8);
                    return;
                }
                this.xDG.xDD.setVisibility(8);
                this.xDG.Va.setVisibility(0);
            }
        });
        setBackBtn(new 2(this));
    }

    public void onBackPressed() {
        finish();
    }

    protected final int getLayoutId() {
        return R.i.daf;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.emoji.AllRemindMsgUI", "[onSceneEnd] errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            Toast.makeText(this.mController.xIM, bh.az(str, getString(R.l.ezu)), 0).show();
        } else if (kVar.getType() == 525) {
            bhf com_tencent_mm_protocal_c_bhf = (bhf) ((ah) kVar).hFi.hmg.hmo;
            Iterator listIterator = this.kPY.listIterator();
            while (listIterator.hasNext()) {
                if (((d) listIterator.next()).xDN == com_tencent_mm_protocal_c_bhf.wLc.wIn) {
                    listIterator.remove();
                }
            }
            this.xDE.UR.notifyChanged();
        }
    }

    public static String a(Context context, int i, String str, int i2) {
        String str2 = "";
        a fT = a.fT(str);
        switch (i) {
            case -1879048186:
                return context.getString(R.l.eCH, new Object[]{""});
            case -1879048185:
            case -1879048183:
            case -1879048176:
                return context.getString(R.l.eCx, new Object[]{""});
            case 1:
                return context.getString(R.l.dDR);
            case 3:
            case 23:
            case 33:
                return context.getString(R.l.dGj);
            case 34:
                n nVar = new n(str);
                return context.getString(R.l.eCK, new Object[]{Integer.valueOf((int) q.bv(nVar.time))});
            case 37:
                if (str == null || str.length() <= 0) {
                    return str2;
                }
                d Xu = d.Xu(str);
                if (Xu.rYX == null || Xu.rYX.length() <= 0) {
                    return str2;
                }
                switch (Xu.scene) {
                    case 18:
                        return context.getString(R.l.ejd, new Object[]{Xu.getDisplayName()});
                    case 22:
                    case 23:
                    case 24:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                        return context.getString(R.l.ejn, new Object[]{Xu.getDisplayName()});
                    case 25:
                        return context.getString(R.l.eip, new Object[]{Xu.getDisplayName()});
                    default:
                        return context.getString(R.l.ejt, new Object[]{Xu.getDisplayName()});
                }
            case R$styleable.AppCompatTheme_dialogTheme /*42*/:
                return context.getString(R.l.dFn);
            case R$styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
            case 62:
                return context.getString(62 == i ? R.l.dGH : R.l.dGX);
            case 47:
                return context.getString(R.l.dEG);
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                ar.Hg();
                com.tencent.mm.z.c.Fa().EL(str);
                return context.getString(R.l.eCC, new Object[]{""});
            case R$styleable.AppCompatTheme_actionButtonStyle /*49*/:
                if (fT != null) {
                    switch (fT.type) {
                        case 2:
                            return context.getString(R.l.dGj);
                        case 3:
                            return context.getString(R.l.eCD, new Object[]{""});
                        case 4:
                            return context.getString(R.l.eCJ, new Object[]{""});
                        case 5:
                        case 7:
                            return context.getString(R.l.eCI, new Object[]{""});
                        case 6:
                            return context.getString(R.l.eCB, new Object[]{fT.title});
                        case 8:
                            return context.getString(R.l.dEH);
                        case 15:
                        case 26:
                        case 27:
                            return context.getString(R.l.dEG);
                        case 17:
                            return context.getString(R.l.eCC, new Object[]{""});
                        case 19:
                            return context.getString(R.l.eCF, new Object[]{""});
                        case 24:
                            return context.getString(R.l.eCE, new Object[]{""});
                        case 25:
                            return context.getString(R.l.dEy);
                        case 33:
                            return context.getString(R.l.dDR);
                        default:
                            x.i("MicroMsg.emoji.AllRemindMsgUI", "default type:%s", new Object[]{Integer.valueOf(fT.type)});
                            break;
                    }
                }
                x.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                return "";
            case 369098801:
            case 452984881:
                return context.getString(R.l.eCz, new Object[]{""});
            case 419430449:
                return context.getString(R.l.eCG);
            case 436207665:
            case 469762097:
                if (fT == null) {
                    x.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                    return "";
                } else if (i2 == 1) {
                    return context.getString(R.l.eCy, new Object[]{fT.hcE, ""});
                } else {
                    return context.getString(R.l.eCy, new Object[]{fT.hcE, ""});
                }
            case 503316529:
                if (fT == null) {
                    x.e("MicroMsg.emoji.AllRemindMsgUI", "decode msg content failed");
                    return "";
                }
                return context.getString(R.l.eCy, new Object[]{fT.hcE, ""});
            case 520093745:
                return context.getString(R.l.eCz, new Object[]{""});
        }
        return context.getString(R.l.eye);
    }
}
