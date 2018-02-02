package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.tencent.mm.R;
import com.tencent.mm.ay.k;
import com.tencent.mm.l.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public class SpecialCheckBoxPreference extends Preference {
    private boolean fzz;
    private String iQs;
    private boolean kTc = false;
    private boolean kZA;
    private x lFr;
    private Context mContext;
    private ToggleButton vuj;
    private ToggleButton vuk;
    private ToggleButton vul;
    private OnCheckedChangeListener vum = new 1(this);

    static /* synthetic */ void a(SpecialCheckBoxPreference specialCheckBoxPreference) {
        if (specialCheckBoxPreference.lFr != null) {
            ar.Hg();
            if (c.Fd().Xf(specialCheckBoxPreference.lFr.field_username)) {
                s.s(specialCheckBoxPreference.lFr.field_username, true);
            } else {
                s.r(specialCheckBoxPreference.lFr.field_username, true);
            }
        }
    }

    static /* synthetic */ void b(SpecialCheckBoxPreference specialCheckBoxPreference) {
        int i = 0;
        specialCheckBoxPreference.kTc = !specialCheckBoxPreference.kTc;
        if (specialCheckBoxPreference.fzz) {
            if (!specialCheckBoxPreference.kTc) {
                i = 1;
            }
            ar.Hg();
            c.EX().b(new k(specialCheckBoxPreference.iQs, i));
            specialCheckBoxPreference.lFr.eH(i);
            ar.Hg();
            c.EY().a(specialCheckBoxPreference.iQs, specialCheckBoxPreference.lFr);
        }
        specialCheckBoxPreference.ccp();
    }

    static /* synthetic */ void c(SpecialCheckBoxPreference specialCheckBoxPreference) {
        if (specialCheckBoxPreference.lFr == null) {
            return;
        }
        if (a.fZ(specialCheckBoxPreference.lFr.field_type)) {
            specialCheckBoxPreference.lFr.Ah();
            s.t(specialCheckBoxPreference.lFr);
            h.bu(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(R.l.eFR));
            return;
        }
        s.q(specialCheckBoxPreference.lFr);
        h.bu(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(R.l.eFZ));
    }

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.vuj = (ToggleButton) view.findViewById(R.h.cIo);
        this.vuk = (ToggleButton) view.findViewById(R.h.cIn);
        this.vul = (ToggleButton) view.findViewById(R.h.cIq);
        this.iQs = ((MMActivity) this.mContext).getIntent().getStringExtra("RoomInfo_Id");
        this.fzz = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
        this.kZA = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
        ar.Hg();
        this.lFr = c.EY().WO(this.iQs);
        if (this.lFr != null) {
            ToggleButton toggleButton = this.vuj;
            ar.Hg();
            toggleButton.setChecked(c.Fd().Xf(this.lFr.field_username));
            this.vul.setChecked(a.fZ(this.lFr.field_type));
            this.vuk.setChecked(ccp());
        }
        this.vuj.setOnCheckedChangeListener(this.vum);
        this.vuk.setOnCheckedChangeListener(this.vum);
        this.vul.setOnCheckedChangeListener(this.vum);
    }

    private boolean ccp() {
        if (this.fzz) {
            this.kTc = this.lFr.fWn == 0;
        } else if (!this.kZA) {
            this.kTc = this.lFr.AI();
        }
        if (!(this.mContext instanceof MMActivity)) {
            return false;
        }
        if (this.kTc) {
            ((MMActivity) this.mContext).setTitleMuteIconVisibility(0);
            return true;
        }
        ((MMActivity) this.mContext).setTitleMuteIconVisibility(8);
        return false;
    }
}
