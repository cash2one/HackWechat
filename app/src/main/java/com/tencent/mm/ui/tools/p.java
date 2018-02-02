package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.os.IBinder;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.m;
import android.support.v4.view.m.e;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.j;
import com.tencent.mm.w.a.k;
import java.util.ArrayList;

public class p {
    final String TAG;
    af hae;
    MenuItem msY;
    boolean zmm;
    public boolean zmn;
    private boolean zmo;
    private boolean zmp;
    boolean zmq;
    public f zmr;
    public b zms;
    private com.tencent.mm.ui.tools.SearchViewNotRealTimeHelper.a zmt;
    private boolean zmu;
    private ArrayList<String> zmv;
    private boolean zmw;
    public int zmx;
    private int zmy;
    a zmz;

    public interface a {
        void collapseActionView();

        void cxY();
    }

    public interface b {
        void Xr();

        void Xs();

        void Xt();

        void Xu();

        boolean oK(String str);

        void oL(String str);
    }

    public p() {
        this.zmm = false;
        this.zmn = false;
        this.zmo = false;
        this.zmp = true;
        this.zmq = true;
        this.msY = null;
        this.hae = new af(Looper.getMainLooper());
        this.zmr = null;
        this.zmu = true;
        this.zmx = k.dEJ;
        this.zmy = 0;
        this.zmu = true;
        this.zmm = false;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
    }

    public p(boolean z, boolean z2) {
        this.zmm = false;
        this.zmn = false;
        this.zmo = false;
        this.zmp = true;
        this.zmq = true;
        this.msY = null;
        this.hae = new af(Looper.getMainLooper());
        this.zmr = null;
        this.zmu = true;
        this.zmx = k.dEJ;
        this.zmy = 0;
        this.zmu = true;
        this.zmm = true;
        this.TAG = "MicroMsg.SearchViewHelper-" + String.valueOf(System.currentTimeMillis());
    }

    public final String bUS() {
        if (this.zmr != null) {
            return this.zmr.bUS();
        }
        return "";
    }

    public final void ZR(String str) {
        if (this.zmr != null) {
            this.zmr.ZR(str);
        }
    }

    public final void setHint(CharSequence charSequence) {
        if (this.zmr != null) {
            this.zmr.setHint(charSequence);
        }
    }

    public final void clearFocus() {
        if (this.zmr != null) {
            this.zmr.cxw();
        }
    }

    public boolean ccM() {
        return false;
    }

    public void ccN() {
    }

    public void ccO() {
    }

    public final void a(final FragmentActivity fragmentActivity, Menu menu) {
        x.v(this.TAG, "on create options menu");
        if (fragmentActivity == null) {
            x.w(this.TAG, "on add search menu, activity is null");
            return;
        }
        if (this.zmr == null) {
            if (this.zmu) {
                this.zmr = new ActionBarSearchView(fragmentActivity);
            } else {
                this.zmr = new SearchViewNotRealTimeHelper(fragmentActivity);
                this.zmr.a(this.zmt);
            }
            this.zmr.ns(this.zmw);
            this.zmr.ak(this.zmv);
        }
        this.zmr.a(new com.tencent.mm.ui.tools.ActionBarSearchView.b(this) {
            final /* synthetic */ p zmA;

            {
                this.zmA = r1;
            }

            public final void aWz() {
                if (this.zmA.zmn) {
                    this.zmA.ccN();
                } else {
                    x.v(this.zmA.TAG, "onVoiceSearchRequired, but not in searching");
                }
            }

            public final void aWy() {
                if (this.zmA.zms != null) {
                    this.zmA.zms.Xu();
                }
            }

            public final void DO(String str) {
                if (!this.zmA.zmn) {
                    x.v(this.zmA.TAG, "onSearchTextChange %s, but not in searching", str);
                } else if (this.zmA.zms != null) {
                    this.zmA.zms.oL(str);
                }
            }

            public final void Xt() {
                if (this.zmA.zms != null) {
                    this.zmA.zms.Xt();
                }
            }
        });
        this.zmr.no(ccM());
        this.zmr.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ p zmA;

            {
                this.zmA = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 != i || this.zmA.zms == null) {
                    return false;
                }
                return this.zmA.zms.oK(this.zmA.bUS());
            }
        });
        if (this.zmy != 0) {
            this.zmr.GJ(this.zmy);
        }
        this.msY = menu.add(0, g.cvP, 0, this.zmx);
        this.msY.setEnabled(this.zmp);
        this.msY.setIcon(j.dva);
        m.a(this.msY, (View) this.zmr);
        if (this.zmm) {
            m.a(this.msY, 9);
        } else {
            m.a(this.msY, 2);
        }
        if (this.zmm) {
            m.a(this.msY, new e(this) {
                final /* synthetic */ p zmA;

                public final boolean onMenuItemActionExpand(MenuItem menuItem) {
                    this.zmA.a(fragmentActivity, false);
                    return true;
                }

                public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
                    this.zmA.b(fragmentActivity, false);
                    return true;
                }
            });
        } else {
            this.zmz = new a(this) {
                final /* synthetic */ p zmA;

                public final void cxY() {
                    this.zmA.a(fragmentActivity, true);
                }

                public final void collapseActionView() {
                    this.zmA.b(fragmentActivity, true);
                }
            };
        }
        this.zmr.a(new com.tencent.mm.ui.tools.ActionBarSearchView.a(this) {
            final /* synthetic */ p zmA;

            {
                this.zmA = r1;
            }

            public final void aWA() {
                if (this.zmA.zmm) {
                    if (this.zmA.msY != null) {
                        m.c(this.zmA.msY);
                    }
                } else if (this.zmA.zmz != null) {
                    this.zmA.zmz.collapseActionView();
                }
            }
        });
    }

    public void a(Activity activity, Menu menu) {
        x.v(this.TAG, "on prepare options menu, searchViewExpand %B, triggerExpand %B, canExpand %B", Boolean.valueOf(this.zmn), Boolean.valueOf(this.zmo), Boolean.valueOf(this.zmp));
        if (activity == null) {
            x.w(this.TAG, "on hanle status fail, activity is null");
            return;
        }
        this.msY = menu.findItem(g.cvP);
        if (this.msY == null) {
            x.w(this.TAG, "can not find search menu, error");
            return;
        }
        this.msY.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
            final /* synthetic */ p zmA;

            {
                this.zmA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        b(activity, menu);
    }

    private void b(final Activity activity, Menu menu) {
        if (!this.zmp) {
            return;
        }
        if (this.zmn || this.zmo) {
            this.zmo = false;
            if (menu != null) {
                for (int i = 0; i < menu.size(); i++) {
                    MenuItem item = menu.getItem(i);
                    if (item.getItemId() != g.cvP) {
                        item.setVisible(false);
                    }
                }
            }
            this.hae.postDelayed(new Runnable(this) {
                final /* synthetic */ p zmA;

                public final void run() {
                    if (this.zmA.msY == null) {
                        x.w(this.zmA.TAG, "on post expand search menu, but item is null");
                        return;
                    }
                    x.i(this.zmA.TAG, "try to expand action view, searchViewExpand %B", Boolean.valueOf(this.zmA.zmn));
                    if (this.zmA.zmm) {
                        if (!this.zmA.zmn) {
                            m.b(this.zmA.msY);
                        }
                    } else if (this.zmA.zmz != null) {
                        this.zmA.zmz.cxY();
                    }
                    final View a = m.a(this.zmA.msY);
                    if (a != null && this.zmA.zmn) {
                        a.findViewById(g.cdj).requestFocus();
                        if (this.zmA.zmq) {
                            this.zmA.hae.postDelayed(new Runnable(this) {
                                final /* synthetic */ AnonymousClass10 zmD;

                                public final void run() {
                                    ((InputMethodManager) activity.getSystemService("input_method")).showSoftInput(a.findViewById(g.cdj), 0);
                                }
                            }, 128);
                        }
                    }
                }
            }, 128);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        x.v(this.TAG, "on key down, key code %d, expand %B", Integer.valueOf(i), Boolean.valueOf(this.zmn));
        if (4 != i || !this.zmn) {
            return false;
        }
        cxX();
        return true;
    }

    public final void nu(boolean z) {
        boolean z2 = false;
        String str = this.TAG;
        String str2 = "do expand, expanded[%B], search menu item null[%B]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.zmn);
        if (this.msY == null) {
            z2 = true;
        }
        objArr[1] = Boolean.valueOf(z2);
        x.d(str, str2, objArr);
        if (!this.zmn) {
            if (this.zmp) {
                this.zmq = z;
                if (this.msY != null) {
                    this.hae.post(new Runnable(this) {
                        final /* synthetic */ p zmA;

                        {
                            this.zmA = r1;
                        }

                        public final void run() {
                            if (this.zmA.msY == null) {
                                x.w(this.zmA.TAG, "post do expand search menu, but search menu item is null");
                            } else if (this.zmA.zmm) {
                                m.b(this.zmA.msY);
                            } else if (this.zmA.zmz != null) {
                                this.zmA.zmz.cxY();
                            }
                        }
                    });
                    return;
                } else {
                    this.zmo = true;
                    return;
                }
            }
            x.w(this.TAG, "can not expand now");
        }
    }

    public final void cxX() {
        x.d(this.TAG, "do collapse");
        if (this.zmn && this.msY != null) {
            if (this.zmm) {
                m.c(this.msY);
            } else if (this.zmz != null) {
                this.zmz.collapseActionView();
            }
        }
    }

    public final boolean cxx() {
        if (this.zmr != null) {
            return this.zmr.cxx();
        }
        return false;
    }

    public final boolean cxy() {
        if (this.zmr != null) {
            return this.zmr.cxy();
        }
        return false;
    }

    public final void a(final FragmentActivity fragmentActivity, final boolean z) {
        x.d(this.TAG, "doNewExpand, searchViewExpand " + this.zmn);
        if (!this.zmn) {
            this.zmn = true;
            b((Activity) fragmentActivity, null);
            this.hae.post(new Runnable(this) {
                final /* synthetic */ p zmA;

                public final void run() {
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        x.w(this.zmA.TAG, "want to expand search view, but activity status error");
                    } else if (z) {
                        fragmentActivity.supportInvalidateOptionsMenu();
                    }
                }
            });
            if (this.zms != null) {
                this.zms.Xs();
            }
        }
    }

    public final void b(final FragmentActivity fragmentActivity, final boolean z) {
        x.d(this.TAG, "doNewCollapse, searchViewExpand " + this.zmn);
        if (this.zmn) {
            this.zmn = false;
            ccO();
            if (this.zmr != null) {
                this.zmr.nr(false);
            }
            this.hae.post(new Runnable(this) {
                final /* synthetic */ p zmA;

                public final void run() {
                    if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                        x.w(this.zmA.TAG, "want to collapse search view, but activity status error");
                    } else if (z) {
                        fragmentActivity.supportInvalidateOptionsMenu();
                    }
                }
            });
            if (this.zms != null) {
                this.hae.post(new Runnable(this) {
                    final /* synthetic */ p zmA;

                    {
                        this.zmA = r1;
                    }

                    public final void run() {
                        this.zmA.zms.Xr();
                    }
                });
            }
        }
        this.hae.post(new Runnable(this) {
            final /* synthetic */ p zmA;

            public final void run() {
                if (this.zmA.msY == null) {
                    x.w(this.zmA.TAG, "want to collapse search view, but search menu item is null");
                    return;
                }
                if (!(fragmentActivity == null || fragmentActivity.isFinishing())) {
                    FragmentActivity fragmentActivity = fragmentActivity;
                    InputMethodManager inputMethodManager = (InputMethodManager) fragmentActivity.getSystemService("input_method");
                    if (inputMethodManager != null) {
                        View currentFocus = fragmentActivity.getCurrentFocus();
                        if (currentFocus != null) {
                            IBinder windowToken = currentFocus.getWindowToken();
                            if (windowToken != null) {
                                inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                            }
                        }
                    }
                }
                View a = m.a(this.zmA.msY);
                if (a != null) {
                    a.findViewById(g.cdj).clearFocus();
                }
            }
        });
    }
}
