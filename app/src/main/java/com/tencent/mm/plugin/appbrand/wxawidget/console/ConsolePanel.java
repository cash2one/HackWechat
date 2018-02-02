package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.plugin.appbrand.wxawidget.a;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.LinkedList;
import java.util.List;

public class ConsolePanel extends FrameLayout implements a {
    MRecyclerView jLT;
    a khA;
    int khB;
    String khC;
    final List<LogInfo> khq = new LinkedList();
    EditText khw;
    Button[] khx;
    Button khy;
    Button khz;

    static /* synthetic */ void a(ConsolePanel consolePanel) {
        consolePanel.khA.khq.clear();
        for (int i = 0; i < consolePanel.khq.size(); i++) {
            LogInfo logInfo = (LogInfo) consolePanel.khq.get(i);
            if ((consolePanel.khB <= 0 || logInfo.level == consolePanel.khB) && !consolePanel.vj(logInfo.message)) {
                consolePanel.khA.khq.add(logInfo);
            }
        }
        consolePanel.khA.UR.notifyChanged();
    }

    public ConsolePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize();
    }

    public ConsolePanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initialize();
    }

    private void initialize() {
        LayoutInflater.from(getContext()).inflate(c.kgy, this, true);
        this.khw = (EditText) findViewById(b.kgx);
        this.khw.clearFocus();
        this.khx = new Button[5];
        bZ(0, b.kgL);
        bZ(1, b.kgO);
        bZ(2, b.kgN);
        bZ(3, b.kgQ);
        bZ(4, b.kgM);
        this.khx[0].setSelected(true);
        this.khB = 0;
        this.khy = (Button) findViewById(b.kgr);
        this.khz = (Button) findViewById(b.kgZ);
        this.khz.setEnabled(false);
        this.khy.setOnClickListener(new 1(this));
        this.khz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ConsolePanel khD;

            {
                this.khD = r1;
            }

            public final void onClick(View view) {
            }
        });
        this.khw.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ ConsolePanel khD;

            {
                this.khD = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.khw.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ ConsolePanel khD;

            {
                this.khD = r1;
            }

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 66) {
                    return false;
                }
                this.khD.khC = this.khD.khw.getText().toString();
                ConsolePanel.a(this.khD);
                f.ch(view);
                return true;
            }
        });
        this.khw.setOnFocusChangeListener(new 5(this));
        findViewById(b.kgB).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ConsolePanel khD;

            {
                this.khD = r1;
            }

            public final void onClick(View view) {
                this.khD.khC = this.khD.khw.getText().toString();
                ConsolePanel.a(this.khD);
            }
        });
        setOnTouchListener(new 7(this));
        this.jLT = (MRecyclerView) findViewById(b.kgP);
        this.khA = new a(getContext());
        MRecyclerView mRecyclerView = this.jLT;
        getContext();
        mRecyclerView.a(new LinearLayoutManager());
        this.jLT.a(null);
        this.jLT.a(this.khA);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int i;
            View currentFocus = ((Activity) getContext()).getCurrentFocus();
            if (currentFocus != null && (currentFocus instanceof EditText)) {
                int[] iArr = new int[]{0, 0};
                currentFocus.getLocationInWindow(iArr);
                int i2 = iArr[0];
                i = iArr[1];
                int height = currentFocus.getHeight() + i;
                int width = currentFocus.getWidth() + i2;
                if (motionEvent.getX() <= ((float) i2) || motionEvent.getX() >= ((float) width) || motionEvent.getY() <= ((float) i) || motionEvent.getY() >= ((float) height)) {
                    i = 1;
                    if (i != 0) {
                        f.ch(currentFocus);
                    }
                }
            }
            i = 0;
            if (i != 0) {
                f.ch(currentFocus);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void bZ(int i, int i2) {
        Button button = (Button) findViewById(i2);
        button.setOnClickListener(new 8(this));
        this.khx[i] = button;
    }

    public final void ag(List<LogInfo> list) {
        if (list != null) {
            List linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                LogInfo logInfo = (LogInfo) list.get(i);
                this.khq.add(logInfo);
                if ((logInfo.level == this.khB || this.khB == 0) && !vj(logInfo.message)) {
                    linkedList.add(logInfo);
                }
            }
            if (!linkedList.isEmpty()) {
                com.tencent.mm.bz.a.Z(new 9(this, linkedList));
            }
        }
    }

    private boolean vj(String str) {
        return !bh.ov(this.khC) && (str == null || !str.toLowerCase().contains(this.khC.toLowerCase()));
    }
}
