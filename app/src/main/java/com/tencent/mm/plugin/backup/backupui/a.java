package com.tencent.mm.plugin.backup.backupui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.backuppcmodel.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;

public final class a extends b {
    private static String TAG = "MicroMsg.BackupChatBanner";
    private View kpZ = null;
    private com.tencent.mm.plugin.backup.a.b.a kqa = new a(this);

    static /* synthetic */ boolean a(a aVar, int i) {
        switch (d.aoo()) {
            case 1:
                return aVar.mO(i);
            case 22:
                return aVar.mP(i);
            default:
                aVar.kpZ.setVisibility(8);
                return false;
        }
    }

    public a(Context context) {
        super(context);
        x.i(TAG, "BackupChatBanner.");
        com.tencent.mm.plugin.backup.backuppcmodel.b.aps().aol().kiJ = -100;
        com.tencent.mm.plugin.backup.c.b.aoR().aol().kiJ = -100;
        x.i(TAG, "initialize");
        if (this.view != null) {
            this.kpZ = this.view.findViewById(R.h.bMB);
            this.kpZ.setOnClickListener(new 1(this));
        }
        alg();
        com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apu().knQ = this.kqa;
        com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apv().knQ = this.kqa;
        com.tencent.mm.plugin.backup.c.b.aoR().aoU().kkV = this.kqa;
    }

    public final int getLayoutId() {
        return R.i.bMB;
    }

    private void dK(boolean z) {
        x.i(TAG, "jumpToBackupPcUI");
        if (bh.bF((Context) this.voC.get())) {
            Intent className = new Intent().setClassName((Context) this.voC.get(), "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
            className.putExtra("isRecoverTransferFinishFromBanner", z);
            MMWizardActivity.A((Context) this.voC.get(), className);
        }
    }

    private void dL(boolean z) {
        x.i(TAG, "jumpToBackupMoveRecoverUI, isRecoverTransferFinishFromBanner[%b]", new Object[]{Boolean.valueOf(z)});
        if (bh.bF((Context) this.voC.get())) {
            Intent className = new Intent().setClassName((Context) this.voC.get(), "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
            className.putExtra("isRecoverTransferFinishFromBanner", z);
            MMWizardActivity.A((Context) this.voC.get(), className);
        }
    }

    public final boolean alg() {
        x.d(TAG, "refreshAndReturnIsVisible, backupMode[%d]", new Object[]{Integer.valueOf(d.aoo())});
        switch (d.aoo()) {
            case 1:
                return mO(com.tencent.mm.plugin.backup.backuppcmodel.b.aps().aol().kiJ);
            case 22:
                return mP(com.tencent.mm.plugin.backup.c.b.aoR().aol().kiJ);
            default:
                this.kpZ.setVisibility(8);
                return false;
        }
    }

    private boolean mO(int i) {
        x.i(TAG, "refreshPcState backupPcState[%d]", new Object[]{Integer.valueOf(i)});
        e aol = com.tencent.mm.plugin.backup.backuppcmodel.b.aps().aol();
        TextView textView;
        Context context;
        int i2;
        Object[] objArr;
        switch (i) {
            case -4:
                this.kpZ.setVisibility(0);
                if (1 == com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt().knD || 3 == com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt().knD) {
                    ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dvX);
                    ((TextView) this.view.findViewById(R.h.bMD)).setText(ac.getContext().getString(R.l.dIM));
                } else if (2 == com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt().knD || 4 == com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt().knD) {
                    ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dwb);
                    ((TextView) this.view.findViewById(R.h.bMD)).setText(ac.getContext().getString(R.l.dIN));
                }
                return true;
            case 4:
            case 5:
                this.kpZ.setVisibility(0);
                if (1 == com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt().knD || 3 == com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt().knD) {
                    ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dvX);
                    textView = (TextView) this.view.findViewById(R.h.bMD);
                    context = ac.getContext();
                    i2 = R.l.dJG;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aol.kiK);
                    objArr[1] = Integer.valueOf(aol.kiL);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt();
                    objArr[2] = c.apy();
                    textView.setText(context.getString(i2, objArr));
                } else if (2 == com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt().knD || 4 == com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt().knD) {
                    ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dwb);
                    textView = (TextView) this.view.findViewById(R.h.bMD);
                    context = ac.getContext();
                    i2 = R.l.dJp;
                    objArr = new Object[3];
                    objArr[0] = Integer.valueOf(aol.kiK);
                    objArr[1] = Integer.valueOf(aol.kiL);
                    com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt();
                    objArr[2] = c.apy();
                    textView.setText(context.getString(i2, objArr));
                }
                return true;
            case 12:
            case 22:
                this.kpZ.setVisibility(0);
                if (1 == com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt().knD || 3 == com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt().knD) {
                    ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dvX);
                } else if (2 == com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt().knD || 4 == com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt().knD) {
                    ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dwb);
                }
                ((TextView) this.view.findViewById(R.h.bMD)).setText(ac.getContext().getString(R.l.dJf));
                return true;
            case 14:
                this.kpZ.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dvX);
                textView = (TextView) this.view.findViewById(R.h.bMD);
                context = ac.getContext();
                i2 = R.l.dJG;
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(aol.kiK);
                objArr[1] = Integer.valueOf(aol.kiL);
                com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt();
                objArr[2] = c.apy();
                textView.setText(context.getString(i2, objArr));
                return true;
            case 15:
                this.kpZ.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dvX);
                ((TextView) this.view.findViewById(R.h.bMD)).setText(ac.getContext().getString(R.l.dIC));
                return true;
            case 23:
                this.kpZ.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dwb);
                textView = (TextView) this.view.findViewById(R.h.bMD);
                context = ac.getContext();
                i2 = R.l.dJp;
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(aol.kiK);
                objArr[1] = Integer.valueOf(aol.kiL);
                com.tencent.mm.plugin.backup.backuppcmodel.b.aps().apt();
                objArr[2] = c.apy();
                textView.setText(context.getString(i2, objArr));
                return true;
            case 24:
                dK(true);
                return true;
            case 25:
                this.kpZ.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dwb);
                ((TextView) this.view.findViewById(R.h.bMD)).setText(ac.getContext().getString(R.l.dJr));
                return true;
            case 26:
            case 27:
                this.kpZ.setVisibility(8);
                if (bh.bF((Context) this.voC.get())) {
                    dK(true);
                }
                return true;
            default:
                this.kpZ.setVisibility(8);
                return false;
        }
    }

    private boolean mP(int i) {
        x.i(TAG, "refreshMoveRecoverState backupMoveState[%d]", new Object[]{Integer.valueOf(i)});
        e aol = com.tencent.mm.plugin.backup.c.b.aoR().aol();
        switch (i) {
            case -4:
                this.kpZ.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dvQ);
                ((TextView) this.view.findViewById(R.h.bMD)).setText(ac.getContext().getString(R.l.dHB));
                return true;
            case 4:
            case 5:
            case 23:
                this.kpZ.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dvQ);
                TextView textView = (TextView) this.view.findViewById(R.h.bMD);
                Context context = ac.getContext();
                int i2 = R.l.dIq;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(aol.kiK);
                objArr[1] = Integer.valueOf(aol.kiL);
                com.tencent.mm.plugin.backup.c.b.aoR().aoU();
                objArr[2] = com.tencent.mm.plugin.backup.c.c.aoZ();
                textView.setText(context.getString(i2, objArr));
                return true;
            case 22:
                this.kpZ.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dvQ);
                ((TextView) this.view.findViewById(R.h.bMD)).setText(ac.getContext().getString(R.l.dIl));
                return true;
            case 24:
            case 52:
                if (bh.bF((Context) this.voC.get())) {
                    dL(true);
                }
                return true;
            case 25:
                this.kpZ.setVisibility(0);
                ((ImageView) this.view.findViewById(R.h.bMC)).setImageResource(R.k.dvQ);
                ((TextView) this.view.findViewById(R.h.bMD)).setText(ac.getContext().getString(R.l.dIs));
                return true;
            case 26:
            case 27:
                this.kpZ.setVisibility(8);
                if (bh.bF((Context) this.voC.get())) {
                    dL(true);
                }
                return true;
            default:
                this.kpZ.setVisibility(8);
                return false;
        }
    }

    public final void destroy() {
    }

    public final int getOrder() {
        return 3;
    }
}
