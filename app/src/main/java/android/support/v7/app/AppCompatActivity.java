package android.support.v7.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.an;
import android.support.v4.app.an.a;
import android.support.v4.app.v;
import android.support.v4.view.g;
import android.support.v7.view.b;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.database.SQLiteDatabase;

public class AppCompatActivity extends FragmentActivity implements a, d {
    private e mDelegate;
    private boolean mEatKeyUpEvent;
    private Resources mResources;
    private int mThemeId = 0;

    public void onCreate(Bundle bundle) {
        e delegate = getDelegate();
        delegate.cS();
        delegate.onCreate(bundle);
        if (delegate.cT() && this.mThemeId != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.mThemeId, false);
            } else {
                setTheme(this.mThemeId);
            }
        }
        super.onCreate(bundle);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.mThemeId = i;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().cR();
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().setSupportActionBar(toolbar);
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }

    public void setContentView(int i) {
        getDelegate().setContentView(i);
    }

    public void setContentView(View view) {
        getDelegate().setContentView(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        getDelegate().setContentView(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        getDelegate().addContentView(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getDelegate().onConfigurationChanged(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    protected void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    public View findViewById(int i) {
        return getDelegate().findViewById(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.getDisplayOptions() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    public void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().setTitle(charSequence);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().requestWindowFeature(i);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public void onSupportActionModeStarted(b bVar) {
    }

    public void onSupportActionModeFinished(b bVar) {
    }

    public b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    public b startSupportActionMode(b.a aVar) {
        return getDelegate().startSupportActionMode(aVar);
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    public void onCreateSupportNavigateUpTaskStack(an anVar) {
        Intent a;
        Intent intent = null;
        if (this instanceof a) {
            intent = getSupportParentActivityIntent();
        }
        if (intent == null) {
            a = v.a(this);
        } else {
            a = intent;
        }
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(anVar.tu.getPackageManager());
            }
            anVar.a(component);
            anVar.tt.add(a);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack(an anVar) {
    }

    public boolean onSupportNavigateUp() {
        int i = 0;
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            an l = an.l(this);
            onCreateSupportNavigateUpTaskStack(l);
            onPrepareSupportNavigateUpTaskStack(l);
            if (l.tt.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) l.tt.toArray(new Intent[l.tt.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            Context context = l.tu;
            int i2 = VERSION.SDK_INT;
            if (i2 >= 16) {
                context.startActivities(intentArr, null);
                i = 1;
            } else if (i2 >= 11) {
                context.startActivities(intentArr);
                i = 1;
            }
            if (i == 0) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                l.tu.startActivity(intent);
            }
            try {
                if (VERSION.SDK_INT >= 16) {
                    finishAffinity();
                } else {
                    finish();
                }
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
        }
        return true;
    }

    public Intent getSupportParentActivityIntent() {
        return v.a(this);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return v.a((Activity) this, intent);
    }

    public void supportNavigateUpTo(Intent intent) {
        v.b((Activity) this, intent);
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public a.a getDrawerToggleDelegate() {
        return getDelegate().getDrawerToggleDelegate();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().onSaveInstanceState(bundle);
    }

    public e getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = e.a((Activity) this, (d) this);
        }
        return this.mDelegate;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (g.a(keyEvent, Downloads.RECV_BUFFER_SIZE) && keyEvent.getUnicodeChar(keyEvent.getMetaState() & -28673) == 60) {
            int action = keyEvent.getAction();
            if (action == 0) {
                ActionBar supportActionBar = getSupportActionBar();
                if (supportActionBar != null && supportActionBar.isShowing() && supportActionBar.requestFocus()) {
                    this.mEatKeyUpEvent = true;
                    return true;
                }
            } else if (action == 1 && this.mEatKeyUpEvent) {
                this.mEatKeyUpEvent = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public Resources getResources() {
        if (this.mResources == null && ar.hc()) {
            this.mResources = new ar(this, super.getResources());
        }
        return this.mResources == null ? super.getResources() : this.mResources;
    }
}
