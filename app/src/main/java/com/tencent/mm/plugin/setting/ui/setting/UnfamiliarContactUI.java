package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.ui.base.preference.CheckPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.TextButtonPreference;
import com.tencent.mm.ui.base.preference.f;

public class UnfamiliarContactUI extends MMPreference {
    private boolean qgj;
    private boolean qgk;
    private boolean qgl;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public final int XB() {
        return R.o.fcv;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        if (preference instanceof CheckPreference) {
            CheckPreference checkPreference = (CheckPreference) preference;
            boolean z2;
            if (preference.ibD.equals("settings_half_year_not_chat")) {
                checkPreference.tSw = !this.qgj;
                if (this.qgj) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.qgj = z2;
            } else if (preference.ibD.equals("settings_has_not_same_chatroom")) {
                if (this.qgl) {
                    r1 = false;
                } else {
                    r1 = true;
                }
                checkPreference.tSw = r1;
                if (this.qgl) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.qgl = z2;
            } else if (preference.ibD.equals("settings_half_year_not_response")) {
                if (this.qgk) {
                    r1 = false;
                } else {
                    r1 = true;
                }
                checkPreference.tSw = r1;
                if (this.qgk) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                this.qgk = z2;
            }
            TextButtonPreference textButtonPreference = (TextButtonPreference) fVar.YN("settings_next_step");
            if (this.qgj || this.qgl || this.qgk) {
                z = true;
            }
            textButtonPreference.setEnabled(z);
        } else if (preference.ibD.equals("settings_next_step")) {
            Intent intent = new Intent(this, UnfamiliarContactDetailUI.class);
            intent.putExtra("half_year_not_chat", this.qgj);
            intent.putExtra("half_year_not_response", this.qgk);
            intent.putExtra("has_not_same_chatroom", this.qgl);
            startActivityForResult(intent, JsApiCreateAudioInstance.CTRL_INDEX);
        }
        fVar.notifyDataSetChanged();
        return true;
    }

    protected final void initView() {
        super.initView();
        setMMTitle(R.l.eNL);
        setBackBtn(new 1(this));
        ((CheckPreference) this.yjd.YN("settings_half_year_not_chat")).yhW = 0;
        ((CheckPreference) this.yjd.YN("settings_has_not_same_chatroom")).yhW = 0;
        ((CheckPreference) this.yjd.YN("settings_half_year_not_response")).yhW = 0;
        ((TextButtonPreference) this.yjd.YN("settings_next_step")).setEnabled(false);
        this.yjd.notifyDataSetChanged();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }
}
