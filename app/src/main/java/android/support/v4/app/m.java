package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.Fragment.SavedState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class m {
    public abstract Fragment N(int i);

    public abstract void O(int i);

    public abstract void a(Bundle bundle, String str, Fragment fragment);

    public abstract q aS();

    public abstract List<Fragment> aT();

    public abstract Fragment c(Bundle bundle, String str);

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract SavedState e(Fragment fragment);

    public abstract boolean executePendingTransactions();

    public abstract int getBackStackEntryCount();

    public abstract boolean isDestroyed();

    public abstract Fragment p(String str);

    public abstract void popBackStack();

    public abstract boolean popBackStackImmediate();
}
