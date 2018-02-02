package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ai;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.l.a;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;

public interface u {
    void M(boolean z);

    void a(a aVar, f.a aVar2);

    void a(Menu menu, a aVar);

    void b(ai aiVar);

    void b(Callback callback);

    ai c(int i, long j);

    void collapseActionView();

    boolean dU();

    boolean dV();

    void dW();

    void dismissPopupMenus();

    void e(CharSequence charSequence);

    ViewGroup eH();

    Context getContext();

    View getCustomView();

    int getDisplayOptions();

    int getHeight();

    Menu getMenu();

    int getNavigationMode();

    CharSequence getTitle();

    int getVisibility();

    boolean hasExpandedActionView();

    boolean hideOverflowMenu();

    boolean isOverflowMenuShowing();

    void setBackgroundDrawable(Drawable drawable);

    void setCustomView(View view);

    void setDisplayOptions(int i);

    void setIcon(int i);

    void setLogo(Drawable drawable);

    void setNavigationContentDescription(int i);

    void setVisibility(int i);

    boolean showOverflowMenu();
}
