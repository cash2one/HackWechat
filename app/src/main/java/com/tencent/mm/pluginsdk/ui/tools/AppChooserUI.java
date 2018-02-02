package com.tencent.mm.pluginsdk.ui.tools;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.pluginsdk.model.v;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class AppChooserUI extends MMActivity {
    private OnDismissListener Gk = new 5(this);
    private PackageManager bgS;
    private String mimeType = null;
    private int scene = 0;
    a vvK;
    private Intent vvL = null;
    private int vvM;
    private String vvN = null;
    private Bundle vvO = null;
    private u vvP = null;
    private ArrayList<String> vvQ = null;
    private c vvR = null;
    private c vvS = new c(this);
    private List<c> vvT;
    private String vvU;
    private int vvV;
    private int vvW;
    private boolean vvX = false;
    private boolean vvY = false;
    private boolean vvZ = false;
    private long vwa;
    private e vwb;
    private OnItemClickListener vwc = new 1(this);
    private OnClickListener vwd = new 2(this);
    private OnClickListener vwe = new 3(this);
    private View.OnClickListener vwf = new 4(this);
    private o vwg = new o(this) {
        final /* synthetic */ AppChooserUI vwh;

        {
            this.vwh = r1;
        }

        public final void onTaskStarted(long j, String str) {
            this.vwh.vwa = j;
            ar.Hg();
            com.tencent.mm.z.c.CU().set(this.vwh.Cx(274560), Long.valueOf(this.vwh.vwa));
            x.d("MicroMsg.AppChooserUI", "onTaskStarted downloadId:%s savedFilePath:%s", String.valueOf(j), str);
        }

        public final void onTaskRemoved(long j) {
            x.d("MicroMsg.AppChooserUI", "onTaskRemove downloadId:%s", Long.valueOf(j));
        }

        public final void c(long j, String str, boolean z) {
            x.d("MicroMsg.AppChooserUI", "onTaskFinished downloadId: %d, savedPath: %s", Long.valueOf(j), str);
            if (!bh.ov(str) && e.bO(str)) {
                ar.Hg();
                com.tencent.mm.z.c.CU().set(this.vwh.Cx(274560), Long.valueOf(this.vwh.vwa));
                if (this.vwh.vvK != null && this.vwh.vwa == j) {
                    this.vwh.vvK.vwi = f.vwv;
                    this.vwh.vvK.notifyDataSetChanged();
                }
            }
        }

        public final void c(long j, int i, boolean z) {
            x.d("MicroMsg.AppChooserUI", "onTaskFailed downloadId:%s", Long.valueOf(j));
            ar.Hg();
            com.tencent.mm.z.c.CU().set(this.vwh.Cx(274560), Long.valueOf(0));
            if (this.vwh.vvK != null) {
                this.vwh.vvK.vwi = f.vwt;
                this.vwh.vvK.notifyDataSetChanged();
            }
        }

        public final void onTaskPaused(long j) {
            x.d("MicroMsg.AppChooserUI", "onTaskPaused downloadId:%s", Long.valueOf(j));
            ar.Hg();
            com.tencent.mm.z.c.CU().set(this.vwh.Cx(274560), Long.valueOf(0));
            if (this.vwh.vvK != null) {
                this.vwh.vvK.vwi = f.vwt;
                this.vwh.vvK.notifyDataSetChanged();
            }
        }

        public final void ck(long j) {
        }

        public final void k(long j, String str) {
        }
    };

    class a extends BaseAdapter {
        List<c> ltR = new ArrayList();
        final /* synthetic */ AppChooserUI vwh;
        int vwi = f.vwt;

        public final /* synthetic */ Object getItem(int i) {
            return Cy(i);
        }

        public a(AppChooserUI appChooserUI) {
            this.vwh = appChooserUI;
            appChooserUI.bgS = appChooserUI.getPackageManager();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            int i2 = 0;
            c Cy = Cy(i);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.vwh.mController.xIM).inflate(Cy.vwo ? R.i.dap : R.i.dao, null);
                b bVar2 = new b(this.vwh, view);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            if (Cy.vwn == null) {
                new d(this.vwh).execute(new c[]{Cy});
            }
            bVar.nuY.setImageDrawable(Cy.vwn);
            bVar.nuZ.setText(Cy.vwm);
            if (Cy == null || (!(!Cy.vwo || Cy.sgu || (Cy.vwo && Cy.nBi && this.vwh.vvV >= this.vwh.vvW)) || Cy.vwp)) {
                bVar.vwj.setVisibility(0);
                bVar.vwk.setVisibility(8);
                bVar.vwj.setOnClickListener(this.vwh.vwf);
                if (this.vwi == f.vwt) {
                    if (Cy.vwp) {
                        bVar.vwj.setText(R.l.dFO);
                    } else {
                        bVar.vwj.setText(R.l.dEz);
                    }
                    bVar.vwj.setEnabled(true);
                } else if (this.vwi == f.vwu) {
                    bVar.vwj.setText(R.l.dEE);
                    bVar.vwj.setEnabled(false);
                } else if (this.vwi == f.vwv) {
                    if (Cy.vwp) {
                        bVar.vwj.setText(R.l.dGQ);
                    } else {
                        bVar.vwj.setText(R.l.dGP);
                    }
                    bVar.vwj.setEnabled(true);
                }
            } else {
                boolean z;
                bVar.vwj.setVisibility(8);
                bVar.vwk.setVisibility(0);
                RadioButton radioButton = bVar.vwk;
                c c = this.vwh.vvR;
                if (c instanceof c) {
                    c = c;
                    if (!(c.vwl == null || Cy.vwl == null || !c.vwl.activityInfo.packageName.equals(Cy.vwl.activityInfo.packageName)) || (c.vwo && Cy.vwo)) {
                        z = true;
                        radioButton.setChecked(z);
                    }
                }
                z = false;
                radioButton.setChecked(z);
            }
            if (Cy.vwo) {
                if (this.vwh.scene == 4) {
                    bVar.nvb.setText(R.l.eBj);
                } else {
                    bVar.nvb.setText(bh.ou(this.vwh.vvN));
                }
                TextView textView = bVar.nvb;
                if (bh.ov(this.vwh.vvN)) {
                    i2 = 8;
                }
                textView.setVisibility(i2);
            } else {
                bVar.nvb.setVisibility(8);
            }
            if (!(this.vwh.scene == 6 || this.vwh.vvR == null || !this.vwh.vvR.equals(Cy))) {
                bVar.vwk.setChecked(true);
            }
            return view;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final c Cy(int i) {
            return this.ltR == null ? null : (c) this.ltR.get(i);
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            if (Cy(i).vwo) {
                return 1;
            }
            return 0;
        }

        public final int getCount() {
            return this.ltR == null ? 0 : this.ltR.size();
        }
    }

    class b {
        ImageView nuY;
        TextView nuZ;
        TextView nvb;
        final /* synthetic */ AppChooserUI vwh;
        TextView vwj;
        RadioButton vwk;

        public b(AppChooserUI appChooserUI, View view) {
            this.vwh = appChooserUI;
            this.nuY = (ImageView) view.findViewById(R.h.bKy);
            this.nuZ = (TextView) view.findViewById(R.h.app_name);
            this.nvb = (TextView) view.findViewById(R.h.bKs);
            this.vwj = (TextView) view.findViewById(R.h.bKK);
            this.vwk = (RadioButton) view.findViewById(R.h.bKI);
        }
    }

    class c {
        boolean nBi;
        boolean sgu;
        final /* synthetic */ AppChooserUI vwh;
        ResolveInfo vwl;
        CharSequence vwm;
        Drawable vwn;
        boolean vwo;
        boolean vwp;

        public c(AppChooserUI appChooserUI) {
            this.vwh = appChooserUI;
        }

        public c(AppChooserUI appChooserUI, ResolveInfo resolveInfo, CharSequence charSequence) {
            this.vwh = appChooserUI;
            this.vwl = resolveInfo;
            this.vwm = charSequence;
            this.vwo = false;
            this.sgu = true;
            this.vwp = false;
        }
    }

    public enum f {
        ;

        static {
            vwt = 1;
            vwu = 2;
            vwv = 3;
            vww = new int[]{vwt, vwu, vwv};
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        v.bYu();
        v.BC(this.vvM);
        ae.a(getWindow());
        Intent intent = getIntent();
        Parcelable parcelableExtra = intent.getParcelableExtra("targetintent");
        if (parcelableExtra instanceof Intent) {
            this.vvL = (Intent) parcelableExtra;
            CharSequence stringExtra = intent.getStringExtra("title");
            this.vvM = intent.getIntExtra(DownloadSettingTable$Columns.TYPE, 0);
            this.vvO = intent.getBundleExtra("transferback");
            this.vvQ = intent.getStringArrayListExtra("targetwhitelist");
            this.vvY = intent.getBooleanExtra("needupate", false);
            this.mimeType = intent.getStringExtra("mimetype");
            this.scene = intent.getIntExtra("scene", 0);
            if (ar.Hj()) {
                boolean z;
                ar.Hg();
                this.vvU = (String) com.tencent.mm.z.c.CU().get(Cx(274528), (Object) "");
                if (!TextUtils.isEmpty(this.vvU) && p.m(this.mController.xIM, this.vvU) && (this.vvQ == null || this.vvQ.isEmpty() || this.vvQ.contains(this.vvU))) {
                    Intent intent2 = new Intent(this.vvL);
                    intent2.setPackage(this.vvU);
                    if (bh.k(this, intent2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                if (!z || this.scene == 6) {
                    boolean z2;
                    this.bgS = getPackageManager();
                    this.vvK = new a(this);
                    v.bYu();
                    this.vvP = v.t(this.vvM, intent.getBundleExtra("key_recommend_params"));
                    this.vvX = this.vvP.ec(this.mController.xIM);
                    ar.Hg();
                    this.vvV = ((Integer) com.tencent.mm.z.c.CU().get(274496 + this.vvM, Integer.valueOf(0))).intValue();
                    v.bYu();
                    this.vvW = v.BB(this.vvM);
                    x.d("MicroMsg.AppChooserUI", "jiaminchen mRecommendAppAvailable is %s, mAppRecommendCount is %d", String.valueOf(this.vvX), Integer.valueOf(this.vvV));
                    this.vvZ = !intent.getBooleanExtra("not_show_recommend_app", false);
                    if (this.vvV >= this.vvW) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.vvT = a(this.vvL, cct(), this.vvQ);
                    if (!(z2 || this.vvX)) {
                        ar.Hg();
                        com.tencent.mm.z.c.CU().set(274496 + this.vvM, Integer.valueOf(this.vvV + 1));
                    }
                    if (this.vvX) {
                        v.bYu();
                        v.BE(this.vvM);
                    } else if (!z2) {
                        v.bYu();
                        v.BD(this.vvM);
                    }
                    if (this.vvT == null || this.vvT.size() != 1 || (cct() && !this.vvX)) {
                        setTitleVisibility(8);
                        if (this.vvT == null || this.vvT.isEmpty()) {
                            j(4097, null, false);
                            return;
                        }
                        this.vvK.ltR = this.vvT;
                        ar.Hg();
                        this.vwa = ((Long) com.tencent.mm.z.c.CU().get(Cx(274560), Long.valueOf(0))).longValue();
                        FileDownloadTaskInfo bY = com.tencent.mm.plugin.downloader.model.f.aAd().bY(this.vwa);
                        x.d("MicroMsg.AppChooserUI", "downloadId:" + this.vwa + ", status:" + bY.status);
                        if (3 == bY.status && e.bO(bY.path) && this.vvK != null) {
                            this.vvK.vwi = f.vwv;
                            this.vvK.notifyDataSetChanged();
                        }
                        this.vwb = new e(this, this.mController.xIM);
                        e eVar = this.vwb;
                        if (stringExtra != null) {
                            eVar.mTitle = stringExtra.toString();
                        } else {
                            eVar.mTitle = null;
                        }
                        this.vwb.vwr = this.vwc;
                        this.vwb.vwe = this.vwe;
                        this.vwb.vws = this.vwd;
                        this.vwb.kPo = this.vvK;
                        this.vwb.Gk = this.Gk;
                        e eVar2 = this.vwb;
                        if (eVar2.vwr != null) {
                            eVar2.vwq.setOnItemClickListener(eVar2.vwr);
                        }
                        if (eVar2.kPo != null) {
                            eVar2.vwq.setAdapter(eVar2.kPo);
                        }
                        eVar2.iol = h.a(eVar2.mContext, true, eVar2.mTitle, eVar2.vwq, eVar2.mContext.getString(R.l.dGW), eVar2.mContext.getString(R.l.dGV), eVar2.vwe, eVar2.vws, R.e.bsE);
                        eVar2.iol.setOnDismissListener(eVar2.Gk);
                        eVar2.iol.show();
                        if (!(this.vvY || !this.vvX || z2)) {
                            this.vvR = this.vvS;
                            this.vwb.lp(true);
                        }
                        com.tencent.mm.plugin.downloader.model.f.aAd();
                        com.tencent.mm.plugin.downloader.model.c.a(this.vwg);
                        return;
                    }
                    c cVar = (c) this.vvT.get(0);
                    if (cVar == null) {
                        j(4097, null, false);
                        return;
                    } else if (cVar.vwl != null) {
                        j(-1, cVar.vwl.activityInfo.packageName, false);
                        return;
                    } else {
                        j(4098, null, false);
                        return;
                    }
                }
                j(-1, this.vvU, true);
                return;
            }
            x.e("MicroMsg.AppChooserUI", "acc not ready");
            j(4097, null, false);
            return;
        }
        x.w("ChooseActivity", "Target is not an intent: " + parcelableExtra);
        j(0, null, false);
    }

    protected void onResume() {
        super.onResume();
        if (this.vvY && this.vvL != null && this.vvP.w(this, this.vvL)) {
            x.i("MicroMsg.AppChooserUI", "user installed lasted recommend app");
            this.vvY = false;
            this.vvS.vwp = false;
        }
        this.vvX = this.vvP.ec(this.mController.xIM);
        this.vvT = a(this.vvL, cct(), this.vvQ);
        if (this.vvX && this.vvR == null) {
            this.vvR = this.vvS;
            this.vwb.lp(true);
        }
        if (this.vvK != null) {
            this.vvK.ltR = this.vvT;
            this.vvK.notifyDataSetChanged();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.downloader.model.f.aAd();
        com.tencent.mm.plugin.downloader.model.c.b(this.vwg);
        if (this.vwb != null) {
            this.vwb.iol.dismiss();
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onBackPressed() {
        super.onBackPressed();
        j(0, null, false);
    }

    final int Cx(int i) {
        if (this.mimeType != null) {
            return (this.vvM + i) + this.mimeType.hashCode();
        }
        return this.vvM + i;
    }

    private void j(int i, String str, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("selectpkg", str);
        intent.putExtra("isalways", z);
        intent.putExtra("transferback", this.vvO);
        setResult(i, intent);
        finish();
    }

    private boolean cct() {
        x.d("MicroMsg.AppChooserUI", "mShouldShowRecommendApp %s | mAppRecommendCount %d | mAppMaxRecommendCount %d | isOverseasUser %s", Boolean.valueOf(this.vvZ), Integer.valueOf(this.vvV), Integer.valueOf(this.vvW), Boolean.valueOf(bh.PT()));
        if (!this.vvZ || this.vvV >= this.vvW || bh.PT() || com.tencent.mm.sdk.platformtools.f.fdS == 1) {
            return false;
        }
        return true;
    }

    private List<c> a(Intent intent, boolean z, ArrayList<String> arrayList) {
        List<c> arrayList2 = new ArrayList();
        List queryIntentActivities = this.bgS.queryIntentActivities(intent, 65536);
        com.tencent.mm.pluginsdk.model.v.a bYl = this.vvP.bYl();
        if (!bh.ov(bYl.vdS)) {
            this.vvN = bYl.vdS;
        } else if (bYl.vdR > 0) {
            this.vvN = getResources().getString(bYl.vdR);
        }
        if (bYl.vdQ > 0) {
            this.vvS.vwn = getResources().getDrawable(bYl.vdQ);
        }
        if (bYl.vdT > 0) {
            this.vvS.vwm = getResources().getString(bYl.vdT);
        } else {
            this.vvS.vwm = bYl.vdU;
        }
        this.vvS.vwo = true;
        this.vvS.sgu = this.vvX;
        if (this.vvX) {
            this.vvS.nBi = true;
        }
        if (this.vvY) {
            this.vvS.vwp = true;
        }
        Object obj = null;
        if (queryIntentActivities != null && queryIntentActivities.size() > 0) {
            int size = queryIntentActivities.size();
            int i = 0;
            while (i < size) {
                Object obj2;
                x.d("MicroMsg.AppChooserUI", "cpan name:%s", ((ResolveInfo) queryIntentActivities.get(i)).activityInfo.name);
                ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivities.get(i);
                if (resolveInfo != null) {
                    String str = resolveInfo.activityInfo.packageName;
                    if (arrayList == null || arrayList.isEmpty() || arrayList.contains(str)) {
                        if (this.vvP.Rq(str)) {
                            this.vvS.vwl = resolveInfo;
                            this.vvS.nBi = true;
                            if ((!z && this.vvX) || (!z && this.vvS.nBi)) {
                                arrayList2.add(0, this.vvS);
                                obj2 = 1;
                                i++;
                                obj = obj2;
                            }
                        } else {
                            arrayList2.add(new c(this, resolveInfo, this.vvP.a(this.mController.xIM, resolveInfo)));
                        }
                    }
                }
                obj2 = obj;
                i++;
                obj = obj2;
            }
        }
        if (z && r1 == null) {
            if (this.vvM != 0 || this.mimeType == null) {
                arrayList2.add(0, this.vvS);
            } else {
                arrayList2.add(0, this.vvS);
                if (this.vvY) {
                    g.pQN.h(11168, Integer.valueOf(2), Integer.valueOf(this.scene));
                } else {
                    g.pQN.h(11168, Integer.valueOf(1), Integer.valueOf(this.scene));
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            c cVar = (c) arrayList2.get(size2);
            if (cVar.vwl != null) {
                String str2 = cVar.vwl.activityInfo.packageName;
                if (!(bh.ov(str2) || hashSet.add(str2))) {
                    arrayList2.remove(size2);
                }
            }
        }
        return arrayList2;
    }

    private static Drawable a(Resources resources, int i) {
        try {
            return com.tencent.mm.bw.a.b(resources, i);
        } catch (NotFoundException e) {
            return null;
        }
    }

    private Drawable c(ResolveInfo resolveInfo) {
        try {
            Drawable a;
            if (!(resolveInfo.resolvePackageName == null || resolveInfo.icon == 0)) {
                a = a(this.bgS.getResourcesForApplication(resolveInfo.resolvePackageName), resolveInfo.icon);
                if (a != null) {
                    return a;
                }
            }
            int iconResource = resolveInfo.getIconResource();
            if (iconResource != 0) {
                a = a(this.bgS.getResourcesForApplication(resolveInfo.activityInfo.packageName), iconResource);
                if (a != null) {
                    return a;
                }
            }
        } catch (NameNotFoundException e) {
            x.e("MicroMsg.AppChooserUI", "Couldn't find resources for package", e);
        }
        return resolveInfo.loadIcon(this.bgS);
    }
}
