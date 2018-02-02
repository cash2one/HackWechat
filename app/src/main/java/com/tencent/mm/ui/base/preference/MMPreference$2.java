package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.base.preference.DialogPreference.a;

class MMPreference$2 implements OnItemClickListener {
    final /* synthetic */ MMPreference yjh;

    MMPreference$2(MMPreference mMPreference) {
        this.yjh = mMPreference;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        final Preference preference = (Preference) adapterView.getAdapter().getItem(i);
        if (preference != null && preference.isEnabled() && preference.yjG && !(preference instanceof CheckBoxPreference)) {
            if (preference instanceof DialogPreference) {
                final DialogPreference dialogPreference = (DialogPreference) preference;
                dialogPreference.showDialog();
                dialogPreference.yid = new a(this) {
                    final /* synthetic */ MMPreference$2 yjj;

                    public final void cqm() {
                        MMPreference.c(this.yjj.yjh);
                        if (dialogPreference.yjI) {
                            MMPreference.b(this.yjj.yjh).edit().putString(preference.ibD, dialogPreference.getValue()).commit();
                        }
                        MMPreference.d(this.yjj.yjh).notifyDataSetChanged();
                    }
                };
            }
            if (preference instanceof EditPreference) {
                EditPreference editPreference = (EditPreference) preference;
                editPreference.showDialog();
                editPreference.yif = new 2(this, editPreference, preference);
            }
            if (preference.ibD != null) {
                this.yjh.a(MMPreference.d(this.yjh), preference);
            }
        }
    }
}
