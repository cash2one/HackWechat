package com.tencent.mm.pluginsdk.ui.preference;

import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.widget.i;

class NormalUserHeaderPreference$5 implements OnLongClickListener {
    final /* synthetic */ NormalUserHeaderPreference vtY;

    NormalUserHeaderPreference$5(NormalUserHeaderPreference normalUserHeaderPreference) {
        this.vtY = normalUserHeaderPreference;
    }

    public final boolean onLongClick(View view) {
        if (!(NormalUserHeaderPreference.d(this.vtY).getText() == null || NormalUserHeaderPreference.e(this.vtY) == null)) {
            String charSequence = NormalUserHeaderPreference.d(this.vtY).getText().toString();
            int indexOf = charSequence.indexOf(58);
            if (indexOf >= 0 && indexOf < charSequence.length()) {
                charSequence = charSequence.substring(indexOf + 1).trim();
            }
            CharSequence spannableString = new SpannableString(NormalUserHeaderPreference.d(this.vtY).getText());
            spannableString.setSpan(new BackgroundColorSpan(NormalUserHeaderPreference.a(this.vtY).getResources().getColor(R.e.bsY)), indexOf + 1, NormalUserHeaderPreference.d(this.vtY).getText().length(), 33);
            NormalUserHeaderPreference.d(this.vtY).setText(spannableString);
            i iVar = new i(NormalUserHeaderPreference.a(this.vtY), NormalUserHeaderPreference.d(this.vtY));
            iVar.zum = new OnCreateContextMenuListener(this) {
                final /* synthetic */ NormalUserHeaderPreference$5 vtZ;

                {
                    this.vtZ = r1;
                }

                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    contextMenu.add(NormalUserHeaderPreference.a(this.vtZ.vtY).getString(R.l.dEs));
                }
            };
            iVar.rKD = new d(this) {
                final /* synthetic */ NormalUserHeaderPreference$5 vtZ;

                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    if (i == 0) {
                        NormalUserHeaderPreference.e(this.vtZ.vtY).setText(charSequence);
                        h.bt(NormalUserHeaderPreference.a(this.vtZ.vtY), NormalUserHeaderPreference.a(this.vtZ.vtY).getString(R.l.dEt));
                    }
                }
            };
            iVar.znd = new OnDismissListener(this) {
                final /* synthetic */ NormalUserHeaderPreference$5 vtZ;

                {
                    this.vtZ = r1;
                }

                public final void onDismiss() {
                    this.vtZ.vtY.cck();
                }
            };
            iVar.bQ(0, 0);
        }
        return true;
    }
}
