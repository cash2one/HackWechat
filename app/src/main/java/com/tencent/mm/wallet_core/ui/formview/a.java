package com.tencent.mm.wallet_core.ui.formview;

import android.content.DialogInterface;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.g.a.ss;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.e;

public final class a {
    private static String TAG = "MicroMsg.CommonHintViewConfig";

    public static class a extends c {
        private int zJu;
        private WalletFormView zJv;

        public final /* bridge */ /* synthetic */ boolean bmH() {
            return super.bmH();
        }

        public final /* bridge */ /* synthetic */ boolean c(WalletFormView walletFormView, String str) {
            return super.c(walletFormView, str);
        }

        public final /* bridge */ /* synthetic */ boolean d(WalletFormView walletFormView, String str) {
            return super.d(walletFormView, str);
        }

        public final /* bridge */ /* synthetic */ String e(WalletFormView walletFormView, String str) {
            return super.e(walletFormView, str);
        }

        public a(WalletFormView walletFormView) {
            this(1, walletFormView);
        }

        public a(int i, WalletFormView walletFormView) {
            super((byte) 0);
            this.zJu = 1;
            this.zJv = walletFormView;
            this.zJu = 1;
            cCj();
        }

        public final void HG(int i) {
            this.zJu = i;
            cCj();
        }

        private void cCj() {
            if (this.zJu == 1) {
                if (this.zJv != null) {
                    this.zJv.setKeyListener(new 1(this));
                }
            } else if (this.zJv != null) {
                this.zJv.setInputType(1);
            }
        }

        public final boolean h(WalletFormView walletFormView) {
            return walletFormView.zJG == null ? false : walletFormView.zJG.isAreaIDCardNum(this.zJu);
        }
    }

    public static void a(EditHintPasswdView editHintPasswdView) {
        if (editHintPasswdView != null) {
            editHintPasswdView.zJB = 1;
        }
    }

    public static void a(EditHintPasswdView editHintPasswdView, boolean z) {
        if (editHintPasswdView != null) {
            editHintPasswdView.zJB = z ? -10 : 20;
        }
    }

    public static void a(WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
        } else {
            walletFormView.zJJ = new 1();
        }
    }

    public static void a(MMActivity mMActivity, WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
            return;
        }
        walletFormView.zJJ = new 4();
        b.f(mMActivity, walletFormView);
        walletFormView.r(new 5(walletFormView, mMActivity));
    }

    public static void b(MMActivity mMActivity, WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
        } else {
            walletFormView.r(new 6(walletFormView, mMActivity));
        }
    }

    public static void b(WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
        } else {
            walletFormView.zJJ = new a(1, walletFormView);
        }
    }

    public static void c(WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
            return;
        }
        walletFormView.zJJ = new a(walletFormView);
        "\\x20\\t\\r\\n".toCharArray();
    }

    public static void d(WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
        } else {
            walletFormView.zJJ = new 7();
        }
    }

    public static void c(final MMActivity mMActivity, WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
            return;
        }
        walletFormView.r(new OnClickListener() {
            public final void onClick(View view) {
                b.a(mMActivity, g.uFF, i.uQA);
            }
        });
        walletFormView.zJJ = new c() {
            public final boolean h(WalletFormView walletFormView) {
                return walletFormView.zJG == null ? false : walletFormView.zJG.isPhoneNum();
            }
        };
    }

    public static void d(final MMActivity mMActivity, WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
            return;
        }
        walletFormView.r(new OnClickListener() {
            public final void onClick(View view) {
                h.a(mMActivity, mMActivity.getString(i.uQx), mMActivity.getString(i.uQv), mMActivity.getString(i.uQw), mMActivity.getString(i.uQy), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass10 zJt;

                    {
                        this.zJt = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        e.l(mMActivity, "https://wx.tenpay.com/cgi-bin/mmpayweb-bin/payunregshow?operation=1", false);
                        com.tencent.mm.sdk.b.a.xef.m(new ss());
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass10 zJt;

                    {
                        this.zJt = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
            }
        });
        "\\x20\\t\\r\\n".toCharArray();
    }

    public static void e(final MMActivity mMActivity, WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
            return;
        }
        walletFormView.r(new OnClickListener() {
            public final void onClick(View view) {
                b.a(mMActivity, g.uFk, i.uQv);
            }
        });
        "\\x20\\t\\r\\n".toCharArray();
    }

    public static void e(WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
        } else {
            walletFormView.zJJ = new c() {
                public final boolean h(WalletFormView walletFormView) {
                    return walletFormView.zJG == null ? false : walletFormView.zJG.isMoneyAmount();
                }
            };
        }
    }

    public static void f(WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
        } else if (walletFormView.zJG != null) {
            walletFormView.zJG.setIsSecurityAnswerFormat(true);
        }
    }

    public static void g(final WalletFormView walletFormView) {
        if (walletFormView == null) {
            x.e(TAG, "hy: param error");
        } else {
            walletFormView.zJI = new b() {
                public final boolean a(WalletFormView walletFormView, MotionEvent motionEvent) {
                    if (!walletFormView.a(walletFormView.pEi, motionEvent) || motionEvent.getAction() != 1) {
                        return super.a(walletFormView, motionEvent);
                    }
                    x.d(a.TAG, "hy: click on info iv");
                    walletFormView.performClick();
                    return true;
                }
            };
        }
    }
}
