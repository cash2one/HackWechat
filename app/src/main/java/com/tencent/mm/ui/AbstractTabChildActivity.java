package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.x;

public abstract class AbstractTabChildActivity extends ActionBarActivity {

    public static abstract class a extends u implements l {
        private Bundle rxF;
        private boolean xDn;
        private boolean xDo;
        private boolean xDp;
        protected boolean xDq;
        protected boolean xDr = false;
        protected boolean xDs = false;
        protected boolean xDt;
        protected boolean xDu = false;

        public abstract void clA();

        public abstract void clB();

        public abstract void clt();

        public abstract void clu();

        public abstract void clv();

        public abstract void clw();

        public abstract void clx();

        public abstract void cly();

        public abstract void clz();

        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.xDo = true;
            this.rxF = bundle;
        }

        public int getLayoutId() {
            return 0;
        }

        public final void clC() {
            clA();
            this.xDp = true;
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0) {
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }

        public void onResume() {
            super.onResume();
            LauncherUI cmG = LauncherUI.cmG();
            if (cmG != null && cmG.xGW) {
                this.xDr = true;
                if (this.xDs) {
                    clF();
                    this.xDs = false;
                }
            }
        }

        public final void clD() {
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

        public final void clF() {
            if (this.xDr) {
                if (this.xDo) {
                    clt();
                    this.xDo = false;
                } else if (this.xDn) {
                    if (this.xDu) {
                        cly();
                    }
                    clt();
                    x.v("MicroMsg.INIT", "KEVIN tab onRecreate " + toString());
                    this.xDn = false;
                }
                this.xDu = true;
                long currentTimeMillis = System.currentTimeMillis();
                if (this.xDp) {
                    this.xDp = false;
                    clB();
                }
                clu();
                x.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - currentTimeMillis));
                this.xDq = true;
                this.xDr = false;
            }
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
            if (this.xDu) {
                cly();
            }
            super.onDestroy();
        }

        public boolean supportNavigationSwipeBack() {
            return false;
        }
    }
}
