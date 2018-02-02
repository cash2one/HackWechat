package com.tencent.mm.plugin.setting.ui.setting;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$a;
import android.support.v7.widget.RecyclerView.t;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.g.b.af;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.setting.a.a.1;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.RealAlphabetScrollBar;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UnfamiliarContactDetailUI extends MMActivity implements e {
    public static final String ldS = new String(Character.toChars(123));
    private r jmO = null;
    private ArrayList<b> jpU = new ArrayList();
    private View ptG;
    private boolean qgj;
    private boolean qgk;
    private boolean qgl;
    private RecyclerView qlK;
    private TextView qlL;
    private View qlM;
    private View qlN;
    private View qlO;
    private TextView qlP;
    private a qlQ;
    private RealAlphabetScrollBar qlR;
    HashMap<String, Integer> qlS = new HashMap();
    private HashMap<Integer, String> qlT = new HashMap();
    private HashSet<Integer> qlU = new HashSet();
    private d qlV;
    private int qlW = -1;
    private HashSet<String> qlX = new HashSet();
    private com.tencent.mm.plugin.setting.a.a qlY;
    private boolean qlZ;

    static class f {
        static int qmA;
        static int qmB;
        static int qmC;
        static int qmD;
        static int qmy;
        static int qmz;
    }

    public interface h {
        void a(e eVar);

        void e(HashSet hashSet);

        void onError();

        void onSuccess();
    }

    class a extends RecyclerView$a {
        final /* synthetic */ UnfamiliarContactDetailUI qma;

        a(UnfamiliarContactDetailUI unfamiliarContactDetailUI) {
            this.qma = unfamiliarContactDetailUI;
        }

        public final t a(ViewGroup viewGroup, int i) {
            return new c(this.qma, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.dto, viewGroup, false));
        }

        public final void a(t tVar, int i) {
            if (tVar instanceof c) {
                int i2;
                c cVar = (c) tVar;
                cVar.qml.setTag(Integer.valueOf(i));
                cVar.VU.setTag(Integer.valueOf(i));
                b bVar = (b) this.qma.jpU.get(i);
                b.a((ImageView) cVar.ldx.view, bVar.jLe.field_username);
                cVar.qmh.setText(i.b(this.qma.mController.xIM, bVar.gBL, cVar.qmh.getTextSize()));
                cVar.qmk.setVisibility(bVar.jLe.AK() ? 0 : 8);
                ImageView imageView = cVar.qmj;
                String str = bVar.jLe.field_username;
                if (n.qQB != null && this.qma.qlX.size() == 0) {
                    this.qma.qlX.addAll(n.qQB.eo(5));
                }
                if (this.qma.qlX.contains(str)) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                imageView.setVisibility(i2);
                if (this.qma.qlT.containsKey(Integer.valueOf(i))) {
                    cVar.qmi.setVisibility(0);
                    cVar.qmi.setText((CharSequence) this.qma.qlT.get(Integer.valueOf(i)));
                } else {
                    cVar.qmi.setVisibility(8);
                }
                if (this.qma.qlZ) {
                    cVar.qmm.setPadding(cVar.qmm.getPaddingLeft(), cVar.qmm.getPaddingTop(), 0, cVar.qmm.getPaddingBottom());
                    if (this.qma.qlU.contains(Integer.valueOf(i))) {
                        cVar.mSc.setChecked(true);
                    } else {
                        cVar.mSc.setChecked(false);
                    }
                    cVar.qml.setVisibility(0);
                    return;
                }
                cVar.qmm.setPadding(cVar.qmm.getPaddingLeft(), cVar.qmm.getPaddingTop(), (int) this.qma.getResources().getDimension(R.f.bvy), cVar.qmm.getPaddingBottom());
                cVar.qml.setVisibility(8);
            }
        }

        public final int getItemCount() {
            return this.qma.jpU.size();
        }

        public final b vY(int i) {
            if (this.qma.jpU.size() > i) {
                return (b) this.qma.jpU.get(i);
            }
            return new b(this.qma, new x());
        }
    }

    static /* synthetic */ void a(UnfamiliarContactDetailUI unfamiliarContactDetailUI, HashSet hashSet) {
        unfamiliarContactDetailUI.jpU.clear();
        Object linkedList = new LinkedList();
        Iterator it = hashSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            linkedList.add((String) it.next());
            i++;
            if (i % 200 == 0 || i == hashSet.size()) {
                Cursor cI = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().cI(linkedList);
                if (cI != null) {
                    cI.moveToFirst();
                    while (!cI.isAfterLast()) {
                        af xVar = new x();
                        xVar.b(cI);
                        if (com.tencent.mm.l.a.fZ(xVar.field_type)) {
                            String str;
                            b bVar = new b(unfamiliarContactDetailUI, xVar);
                            af afVar = bVar.jLe;
                            if (afVar == null) {
                                str = null;
                            } else {
                                str = afVar.field_nickname;
                                if (!bh.ov(afVar.field_conRemark)) {
                                    str = afVar.field_conRemark;
                                } else if (bh.ov(str)) {
                                    str = afVar.AP();
                                }
                            }
                            String str2 = "";
                            if (TextUtils.isEmpty(str)) {
                                com.tencent.mm.sdk.platformtools.x.w("MicroMsg.UnfamiliarContactUI", "[%s:%s]", new Object[]{xVar.field_username, xVar.field_nickname});
                            } else {
                                str2 = SpellMap.g(str.charAt(0));
                            }
                            str2 = bh.ov(str2) ? ldS : !str2.matches("[a-zA-Z]+$") ? ldS : str2.toLowerCase().substring(0, 1);
                            bVar.qmg = str2;
                            bVar.gBL = str;
                            unfamiliarContactDetailUI.jpU.add(bVar);
                            cI.moveToNext();
                        } else {
                            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.UnfamiliarContactUI", "contact:%s username:%s", new Object[]{xVar.field_nickname, xVar.field_username});
                            cI.moveToNext();
                        }
                    }
                    cI.close();
                }
                linkedList.clear();
            }
        }
        Collections.sort(unfamiliarContactDetailUI.jpU, new Comparator<b>(unfamiliarContactDetailUI) {
            final /* synthetic */ UnfamiliarContactDetailUI qma;

            {
                this.qma = r1;
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((b) obj).qmg.compareTo(((b) obj2).qmg);
            }
        });
        unfamiliarContactDetailUI.bH(unfamiliarContactDetailUI.jpU);
    }

    static /* synthetic */ void a(UnfamiliarContactDetailUI unfamiliarContactDetailUI, final HashSet hashSet, final int i) {
        unfamiliarContactDetailUI.dY(true);
        if (i == 0) {
            f.qmB += hashSet.size();
        } else if (i == 1) {
            f.qmA += hashSet.size();
        }
        com.tencent.mm.sdk.f.e.post(new Runnable(unfamiliarContactDetailUI) {
            final /* synthetic */ UnfamiliarContactDetailUI qma;

            public final void run() {
                List linkedList = new LinkedList();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    b vY = this.qma.qlQ.vY(((Integer) it.next()).intValue());
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.UnfamiliarContactUI", "username:%s index:%s", new Object[]{vY.jLe.field_username, Integer.valueOf(i)});
                    com.tencent.mm.sdk.b.b qbVar;
                    if (i == 0) {
                        qbVar = new qb();
                        qbVar.fHH.fHJ = false;
                        qbVar.fHH.fHI = true;
                        qbVar.fHH.username = vY.jLe.field_username;
                        com.tencent.mm.sdk.b.a.xef.m(qbVar);
                        linkedList.add(vY.jLe.field_username);
                    } else if (i == 1) {
                        vY.jLe.Av();
                        qbVar = new qb();
                        qbVar.fHH.fHJ = true;
                        qbVar.fHH.fHI = false;
                        qbVar.fHH.username = vY.jLe.field_username;
                        com.tencent.mm.sdk.b.a.xef.m(qbVar);
                        s.j(vY.jLe);
                    }
                }
                if (linkedList.size() > 0) {
                    com.tencent.mm.sdk.b.b ltVar = new lt();
                    ltVar.fDg.list = linkedList;
                    ltVar.fDg.fut = 1;
                    ltVar.fDg.fDh = 5;
                    com.tencent.mm.sdk.b.a.xef.m(ltVar);
                    return;
                }
                this.qma.runOnUiThread(new 1(this));
            }
        }, "handleSnsSetting");
    }

    static /* synthetic */ void b(UnfamiliarContactDetailUI unfamiliarContactDetailUI, boolean z) {
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(unfamiliarContactDetailUI, R.a.bqo);
            loadAnimation.setAnimationListener(new AnimationListener(unfamiliarContactDetailUI) {
                final /* synthetic */ UnfamiliarContactDetailUI qma;

                {
                    this.qma = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.qma.ptG.setVisibility(0);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            unfamiliarContactDetailUI.ptG.startAnimation(loadAnimation);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(unfamiliarContactDetailUI, R.a.bqm);
            loadAnimation.setAnimationListener(new 12(unfamiliarContactDetailUI));
            unfamiliarContactDetailUI.ptG.startAnimation(loadAnimation);
        }
        unfamiliarContactDetailUI.qlZ = z;
        if (unfamiliarContactDetailUI.qlZ) {
            unfamiliarContactDetailUI.updateOptionMenuText(1, unfamiliarContactDetailUI.getString(R.l.eRG));
            return;
        }
        unfamiliarContactDetailUI.updateOptionMenuText(1, unfamiliarContactDetailUI.getString(R.l.eRK));
        ((CheckBox) unfamiliarContactDetailUI.qlO.findViewById(R.h.checkbox)).setChecked(false);
    }

    protected final int getLayoutId() {
        return R.i.dsn;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(JsApiCreateAudioInstance.CTRL_INDEX, this);
        this.qgj = getIntent().getBooleanExtra("half_year_not_chat", false);
        this.qgk = getIntent().getBooleanExtra("half_year_not_response", false);
        this.qgl = getIntent().getBooleanExtra("has_not_same_chatroom", false);
        initView();
        this.qlY = new com.tencent.mm.plugin.setting.a.a(this.qgj, this.qgk, this.qgl, new h(this) {
            final /* synthetic */ UnfamiliarContactDetailUI qma;
            long start = System.currentTimeMillis();

            {
                this.qma = r3;
            }

            public final void onSuccess() {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.UnfamiliarContactUI", "[onSuccess] size:%s cost:%sms", new Object[]{Integer.valueOf(this.qma.jpU.size()), Long.valueOf(System.currentTimeMillis() - this.start)});
                this.qma.qlL.setText(this.qma.getString(R.l.eRJ) + "(" + this.qma.jpU.size() + ")");
                if (this.qma.jpU.size() == 0) {
                    this.qma.findViewById(R.h.cRR).setVisibility(0);
                    this.qma.findViewById(R.h.cDY).setVisibility(8);
                    this.qma.findViewById(R.h.ctb).setVisibility(8);
                    this.qma.qlP.setText(this.qma.getString(R.l.esV));
                    return;
                }
                this.qma.findViewById(R.h.cRR).setVisibility(8);
                this.qma.findViewById(R.h.ctb).setVisibility(0);
                if (this.qma.qlQ != null) {
                    this.qma.qlQ.UR.notifyChanged();
                }
            }

            public final void onError() {
                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.UnfamiliarContactUI", "[onError]");
                this.qma.findViewById(R.h.cRR).setVisibility(0);
                this.qma.findViewById(R.h.cDY).setVisibility(8);
                this.qma.qlP.setText(this.qma.getString(R.l.eRN));
            }

            public final void a(e eVar) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.UnfamiliarContactUI", "[onLoading] type:%s", new Object[]{eVar.name()});
                this.qma.findViewById(R.h.cRR).setVisibility(0);
                this.qma.findViewById(R.h.cDY).setVisibility(0);
                if (eVar == e.qmw) {
                    this.qma.qlP.setText(this.qma.getString(R.l.ctB));
                } else if (eVar == e.qmv) {
                    this.qma.qlP.setText(this.qma.getString(R.l.eRO));
                }
            }

            public final void e(HashSet hashSet) {
                String str = "MicroMsg.UnfamiliarContactUI";
                String str2 = "[onResult] size:%s";
                Object[] objArr = new Object[1];
                objArr[0] = Integer.valueOf(hashSet == null ? 0 : hashSet.size());
                com.tencent.mm.sdk.platformtools.x.i(str, str2, objArr);
                if (hashSet != null) {
                    UnfamiliarContactDetailUI.a(this.qma, hashSet);
                }
            }
        });
        com.tencent.mm.plugin.setting.a.a aVar = this.qlY;
        aVar.mYz = System.currentTimeMillis();
        aVar.qgs.a(e.qmw);
        aVar.gQF.F(new 1(aVar));
    }

    protected void onResume() {
        super.onResume();
        if (-1 != this.qlW) {
            Object obj;
            if (-1 == this.qlW) {
                obj = null;
            } else {
                b bVar = (b) this.jpU.get(this.qlW);
                af afVar = bVar.jLe;
                af WO = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WO(afVar.field_username);
                if (com.tencent.mm.l.a.fZ(WO.field_type) || !com.tencent.mm.l.a.fZ(afVar.field_type)) {
                    bVar.jLe = WO;
                    obj = null;
                } else {
                    this.jpU.remove(this.qlW);
                    obj = 1;
                }
            }
            if (obj != null) {
                f.qmz++;
            }
            this.qlW = -1;
        }
        this.qlX.clear();
        if (this.qlQ != null) {
            this.qlQ.UR.notifyChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        int i = (this.qgk ? 4 : 0) | ((this.qgl ? 2 : 0) | (this.qgj ? 1 : 0));
        com.tencent.mm.plugin.report.service.g.pQN.h(14434, new Object[]{Integer.valueOf(i), Integer.valueOf(f.qmz), Integer.valueOf(f.qmy), Integer.valueOf(f.qmD), Integer.valueOf(f.qmA), Integer.valueOf(f.qmC), Integer.valueOf(f.qmB)});
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.UnfamiliarContactUI", "[%s:%s:%s:%s:%s:%s:%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(f.qmz), Integer.valueOf(f.qmy), Integer.valueOf(f.qmD), Integer.valueOf(f.qmA), Integer.valueOf(f.qmC), Integer.valueOf(f.qmB)});
        f.qmy = 0;
        f.qmz = 0;
        f.qmA = 0;
        f.qmB = 0;
        f.qmC = 0;
        f.qmD = 0;
        ar.CG().b(JsApiCreateAudioInstance.CTRL_INDEX, this);
        ar.CG().b(681, this.qlV);
        com.tencent.mm.plugin.setting.a.a aVar = this.qlY;
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.UnfamiliarContactEngine", "[onDestroy] [%s:%s:%s]", new Object[]{Boolean.valueOf(aVar.qgk), Boolean.valueOf(aVar.qgj), Boolean.valueOf(aVar.qgl)});
        if (aVar.qgr != null) {
            ar.CG().b(JsApiSetAudioState.CTRL_INDEX, aVar.qgr);
        }
        aVar.gQF.oAt.quit();
        com.tencent.mm.sdk.f.e.Q(aVar.mRunnable);
    }

    protected final void initView() {
        int i;
        int i2 = 0;
        super.initView();
        setMMTitle(R.l.eNL);
        addTextOptionMenu(1, getString(R.l.eRK), new 1(this));
        setBackBtn(new 5(this));
        findViewById(R.h.cMq).setVisibility(this.qgj ? 0 : 8);
        View findViewById = findViewById(R.h.cMs);
        if (this.qgl) {
            i = 0;
        } else {
            i = 8;
        }
        findViewById.setVisibility(i);
        View findViewById2 = findViewById(R.h.cMr);
        if (!this.qgk) {
            i2 = 8;
        }
        findViewById2.setVisibility(i2);
        this.qlK = (RecyclerView) findViewById(R.h.cTI);
        this.ptG = findViewById(R.h.bottom_bar);
        this.qlL = (TextView) findViewById(R.h.cvI);
        this.qlV = new d(this, this.qlU, new 6(this));
        this.qlM = findViewById(R.h.cTF);
        this.qlM.setOnClickListener(new 7(this));
        this.qlN = findViewById(R.h.cTG);
        this.qlN.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ UnfamiliarContactDetailUI qma;

            {
                this.qma = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(this.qma, com.tencent.mm.ui.widget.g.ztp, false);
                gVar.rKC = new 1(this);
                gVar.rKD = new 2(this);
                gVar.bUk();
            }
        });
        this.qlO = findViewById(R.h.cTH);
        this.qlO.setOnClickListener(new 9(this));
        this.qlP = (TextView) findViewById(R.h.cRV);
        this.qlK.a(new LinearLayoutManager());
        this.qlQ = new a(this);
        this.qlK.a(this.qlQ);
        this.qlR = (RealAlphabetScrollBar) findViewById(R.h.cTJ);
        this.qlR.yhE = new 10(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.UnfamiliarContactUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " " + kVar.getType());
        if (!(i == 0 && i2 == 0)) {
            Toast.makeText(this, getString(R.l.eRL), 1).show();
        }
        if (kVar.getType() == JsApiCreateAudioInstance.CTRL_INDEX) {
            dY(false);
            this.qlX.clear();
            this.qlQ.UR.notifyChanged();
        }
    }

    private void bH(List<b> list) {
        this.qlS.clear();
        this.qlT.clear();
        int i = 0;
        String str = null;
        for (b bVar : list) {
            if (ldS.equalsIgnoreCase(bVar.qmg)) {
                bVar.qmg = "#";
            }
            String str2 = bVar.qmg;
            if (!str2.equalsIgnoreCase(str)) {
                this.qlS.put(str2.toUpperCase(), Integer.valueOf(i));
                this.qlT.put(Integer.valueOf(i), str2.toUpperCase());
            }
            i++;
            str = str2;
        }
    }

    private void dY(boolean z) {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.UnfamiliarContactUI", "[setProgress] isVisible:%s", new Object[]{Boolean.valueOf(z)});
        if (z) {
            this.jmO = r.b(this, getString(R.l.eRI), true, 0, null);
        } else if (this.jmO != null && this.jmO.isShowing()) {
            this.jmO.dismiss();
            this.jmO = null;
        }
    }
}
