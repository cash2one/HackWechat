package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.z;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a.f;
import android.support.v7.app.b.AnonymousClass2;
import android.support.v7.app.b.AnonymousClass3;
import android.support.v7.app.b.AnonymousClass4;
import android.support.v7.app.b.AnonymousClass5;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class c extends j implements DialogInterface {
    private b GC = new b(getContext(), this, getWindow());

    public static class a {
        public final android.support.v7.app.b.a GD;
        public int pX;

        public a(Context context) {
            this(context, c.d(context, 0));
        }

        private a(Context context, int i) {
            this.GD = new android.support.v7.app.b.a(new ContextThemeWrapper(context, c.d(context, i)));
            this.pX = i;
        }
    }

    public c(Context context, int i) {
        super(context, d(context, i));
    }

    static int d(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.support.v7.a.a.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.GC.setTitle(charSequence);
    }

    protected final void onCreate(Bundle bundle) {
        int indexOfChild;
        super.onCreate(bundle);
        b bVar = this.GC;
        int i = (bVar.FS == 0 || bVar.FX != 1) ? bVar.FR : bVar.FS;
        bVar.Fs.setContentView(i);
        View findViewById = bVar.Ft.findViewById(f.parentPanel);
        View findViewById2 = findViewById.findViewById(f.topPanel);
        View findViewById3 = findViewById.findViewById(f.contentPanel);
        View findViewById4 = findViewById.findViewById(f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(f.customPanel);
        View inflate = bVar.mView != null ? bVar.mView : bVar.Fw != 0 ? LayoutInflater.from(bVar.mContext).inflate(bVar.Fw, viewGroup, false) : null;
        Object obj = inflate != null ? 1 : null;
        if (obj == null || !b.aH(inflate)) {
            bVar.Ft.setFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        }
        if (obj != null) {
            FrameLayout frameLayout = (FrameLayout) bVar.Ft.findViewById(f.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (bVar.FB) {
                frameLayout.setPadding(bVar.Fx, bVar.Fy, bVar.Fz, bVar.FA);
            }
            if (bVar.Fv != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById5 = viewGroup.findViewById(f.topPanel);
        inflate = viewGroup.findViewById(f.contentPanel);
        View findViewById6 = viewGroup.findViewById(f.buttonPanel);
        ViewGroup b = b.b(findViewById5, findViewById2);
        ViewGroup b2 = b.b(inflate, findViewById3);
        ViewGroup b3 = b.b(findViewById6, findViewById4);
        bVar.FL = (NestedScrollView) bVar.Ft.findViewById(f.scrollView);
        bVar.FL.setFocusable(false);
        bVar.FL.setNestedScrollingEnabled(false);
        bVar.jy = (TextView) b2.findViewById(16908299);
        if (bVar.jy != null) {
            if (bVar.Fu != null) {
                bVar.jy.setText(bVar.Fu);
            } else {
                bVar.jy.setVisibility(8);
                bVar.FL.removeView(bVar.jy);
                if (bVar.Fv != null) {
                    ViewGroup viewGroup2 = (ViewGroup) bVar.FL.getParent();
                    indexOfChild = viewGroup2.indexOfChild(bVar.FL);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(bVar.Fv, indexOfChild, new LayoutParams(-1, -1));
                } else {
                    b2.setVisibility(8);
                }
            }
        }
        indexOfChild = 0;
        bVar.FC = (Button) b3.findViewById(16908313);
        bVar.FC.setOnClickListener(bVar.FY);
        if (TextUtils.isEmpty(bVar.FD)) {
            bVar.FC.setVisibility(8);
        } else {
            bVar.FC.setText(bVar.FD);
            bVar.FC.setVisibility(0);
            indexOfChild = 1;
        }
        bVar.FF = (Button) b3.findViewById(16908314);
        bVar.FF.setOnClickListener(bVar.FY);
        if (TextUtils.isEmpty(bVar.FG)) {
            bVar.FF.setVisibility(8);
        } else {
            bVar.FF.setText(bVar.FG);
            bVar.FF.setVisibility(0);
            indexOfChild |= 2;
        }
        bVar.FI = (Button) b3.findViewById(16908315);
        bVar.FI.setOnClickListener(bVar.FY);
        if (TextUtils.isEmpty(bVar.FJ)) {
            bVar.FI.setVisibility(8);
        } else {
            bVar.FI.setText(bVar.FJ);
            bVar.FI.setVisibility(0);
            indexOfChild |= 4;
        }
        if ((indexOfChild != 0 ? 1 : null) == null) {
            b3.setVisibility(8);
        }
        if (bVar.FO != null) {
            b.addView(bVar.FO, 0, new LayoutParams(-1, -2));
            bVar.Ft.findViewById(f.title_template).setVisibility(8);
        } else {
            bVar.kP = (ImageView) bVar.Ft.findViewById(16908294);
            if ((!TextUtils.isEmpty(bVar.uU) ? 1 : null) != null) {
                bVar.FN = (TextView) bVar.Ft.findViewById(f.alertTitle);
                bVar.FN.setText(bVar.uU);
                if (bVar.FM != 0) {
                    bVar.kP.setImageResource(bVar.FM);
                } else if (bVar.jY != null) {
                    bVar.kP.setImageDrawable(bVar.jY);
                } else {
                    bVar.FN.setPadding(bVar.kP.getPaddingLeft(), bVar.kP.getPaddingTop(), bVar.kP.getPaddingRight(), bVar.kP.getPaddingBottom());
                    bVar.kP.setVisibility(8);
                }
            } else {
                bVar.Ft.findViewById(f.title_template).setVisibility(8);
                bVar.kP.setVisibility(8);
                b.setVisibility(8);
            }
        }
        Object obj2 = (viewGroup == null || viewGroup.getVisibility() == 8) ? null : 1;
        obj = (b == null || b.getVisibility() == 8) ? null : 1;
        Object obj3 = (b3 == null || b3.getVisibility() == 8) ? null : 1;
        if (obj3 == null && b2 != null) {
            findViewById = b2.findViewById(f.textSpacerNoButtons);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
        }
        if (!(obj == null || bVar.FL == null)) {
            bVar.FL.setClipToPadding(true);
        }
        if (obj2 == null) {
            inflate = bVar.Fv != null ? bVar.Fv : bVar.FL;
            if (inflate != null) {
                int i2 = (obj != null ? 1 : 0) | (obj3 != null ? 2 : 0);
                findViewById5 = bVar.Ft.findViewById(f.scrollIndicatorUp);
                findViewById = bVar.Ft.findViewById(f.scrollIndicatorDown);
                if (VERSION.SDK_INT >= 23) {
                    z.c(inflate, i2, 3);
                    if (findViewById5 != null) {
                        b2.removeView(findViewById5);
                    }
                    if (findViewById != null) {
                        b2.removeView(findViewById);
                    }
                } else {
                    if (findViewById5 != null && (i2 & 1) == 0) {
                        b2.removeView(findViewById5);
                        findViewById5 = null;
                    }
                    if (findViewById != null && (i2 & 2) == 0) {
                        b2.removeView(findViewById);
                        findViewById = null;
                    }
                    if (!(findViewById5 == null && findViewById == null)) {
                        if (bVar.Fu != null) {
                            bVar.FL.Dx = new AnonymousClass2(bVar, findViewById5, findViewById);
                            bVar.FL.post(new AnonymousClass3(bVar, findViewById5, findViewById));
                        } else if (bVar.Fv != null) {
                            bVar.Fv.setOnScrollListener(new AnonymousClass4(bVar, findViewById5, findViewById));
                            bVar.Fv.post(new AnonymousClass5(bVar, findViewById5, findViewById));
                        } else {
                            if (findViewById5 != null) {
                                b2.removeView(findViewById5);
                            }
                            if (findViewById != null) {
                                b2.removeView(findViewById);
                            }
                        }
                    }
                }
            }
        }
        ListView listView = bVar.Fv;
        if (listView != null && bVar.FP != null) {
            listView.setAdapter(bVar.FP);
            int i3 = bVar.FQ;
            if (i3 >= 0) {
                listView.setItemChecked(i3, true);
                listView.setSelection(i3);
            }
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        b bVar = this.GC;
        boolean z = bVar.FL != null && bVar.FL.executeKeyEvent(keyEvent);
        if (z) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        b bVar = this.GC;
        boolean z = bVar.FL != null && bVar.FL.executeKeyEvent(keyEvent);
        if (z) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
