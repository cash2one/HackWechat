package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

public final class i extends o {
    final a aFA = new a(this, "monitoring", ((Long) aj.aIh.get()).longValue(), (byte) 0);
    SharedPreferences aFx;
    private long aFy;
    private long aFz = -1;

    protected i(q qVar) {
        super(qVar);
    }

    public final void aq(String str) {
        q.mY();
        mQ();
        Editor edit = this.aFx.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            ax("Failed to commit campaign data");
        }
    }

    protected final void mf() {
        this.aFx = this.aFo.mContext.getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final long ms() {
        q.mY();
        mQ();
        if (this.aFy == 0) {
            long j = this.aFx.getLong("first_run", 0);
            if (j != 0) {
                this.aFy = j;
            } else {
                j = this.aFo.aFD.currentTimeMillis();
                Editor edit = this.aFx.edit();
                edit.putLong("first_run", j);
                if (!edit.commit()) {
                    ax("Failed to commit first run time");
                }
                this.aFy = j;
            }
        }
        return this.aFy;
    }

    public final j mt() {
        return new j(this.aFo.aFD, ms());
    }

    public final long mu() {
        q.mY();
        mQ();
        if (this.aFz == -1) {
            this.aFz = this.aFx.getLong("last_dispatch", 0);
        }
        return this.aFz;
    }

    public final void mv() {
        q.mY();
        mQ();
        long currentTimeMillis = this.aFo.aFD.currentTimeMillis();
        Editor edit = this.aFx.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.aFz = currentTimeMillis;
    }

    public final String mw() {
        q.mY();
        mQ();
        CharSequence string = this.aFx.getString("installation_campaign", null);
        return TextUtils.isEmpty(string) ? null : string;
    }
}
