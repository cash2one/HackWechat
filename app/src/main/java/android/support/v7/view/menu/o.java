package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.c.a.a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;

class o extends c<a> implements Menu {
    o(Context context, a aVar) {
        super(context, aVar);
    }

    public MenuItem add(CharSequence charSequence) {
        return f(((a) this.KO).add(charSequence));
    }

    public MenuItem add(int i) {
        return f(((a) this.KO).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return f(((a) this.KO).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return f(((a) this.KO).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(((a) this.KO).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return a(((a) this.KO).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return a(((a) this.KO).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return a(((a) this.KO).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((a) this.KO).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = f(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public void removeItem(int i) {
        if (this.KM != null) {
            Iterator it = this.KM.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    break;
                }
            }
        }
        ((a) this.KO).removeItem(i);
    }

    public void removeGroup(int i) {
        if (this.KM != null) {
            Iterator it = this.KM.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
        ((a) this.KO).removeGroup(i);
    }

    public void clear() {
        if (this.KM != null) {
            this.KM.clear();
        }
        if (this.KN != null) {
            this.KN.clear();
        }
        ((a) this.KO).clear();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((a) this.KO).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((a) this.KO).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((a) this.KO).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((a) this.KO).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return f(((a) this.KO).findItem(i));
    }

    public int size() {
        return ((a) this.KO).size();
    }

    public MenuItem getItem(int i) {
        return f(((a) this.KO).getItem(i));
    }

    public void close() {
        ((a) this.KO).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((a) this.KO).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((a) this.KO).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((a) this.KO).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((a) this.KO).setQwertyMode(z);
    }
}
