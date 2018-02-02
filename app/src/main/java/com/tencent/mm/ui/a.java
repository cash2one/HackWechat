package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.preference.i;

public abstract class a extends i implements l {
    private Bundle rxF;
    private boolean xDn;
    private boolean xDo;
    private boolean xDp;
    private boolean xDq;
    protected boolean xDr = false;
    protected boolean xDs = false;
    protected boolean xDt;

    protected abstract void clt();

    protected abstract void clu();

    protected abstract void clv();

    protected abstract void clw();

    protected abstract void clx();

    protected abstract void cly();

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.rxF = bundle;
        this.xDo = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void onResume() {
        super.onResume();
        clD();
        LauncherUI cmG = LauncherUI.cmG();
        if (cmG != null && cmG.xGW) {
            this.xDr = true;
            if (this.xDs) {
                clF();
                this.xDs = false;
            }
        }
    }

    public final void clC() {
        clA();
        this.xDp = true;
    }

    public final void clF() {
        if (this.xDr) {
            if (this.xDo) {
                clt();
                this.xDo = false;
            } else if (this.xDn) {
                cly();
                clt();
                x.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
                this.xDn = false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.xDp) {
                clB();
                this.xDp = false;
            }
            if (!this.yjv) {
                int XB = XB();
                if (XB != -1) {
                    this.yjd.addPreferencesFromResource(XB);
                    this.yjv = true;
                }
            }
            clu();
            x.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - currentTimeMillis));
            this.xDq = true;
            this.xDr = false;
        }
    }

    public final void clE() {
        this.xDs = true;
    }

    public void onPause() {
        super.onPause();
        this.xDt = true;
        if (!this.xDt) {
            return;
        }
        if (this.xDq) {
            long currentTimeMillis = System.currentTimeMillis();
            clw();
            x.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - currentTimeMillis));
            this.xDq = false;
            this.xDt = false;
            return;
        }
        this.xDt = false;
    }

    public void onStop() {
        super.onStop();
        clx();
    }

    public void onStart() {
        super.onStart();
        LauncherUI cmG = LauncherUI.cmG();
        if (cmG != null && cmG.xGW) {
            clv();
        }
    }

    public void onDestroy() {
        cly();
        super.onDestroy();
    }
}
