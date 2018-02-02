package com.tencent.mm.plugin.luckymoney.particles;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public final class c {
    private long hLi;
    ValueAnimator jWC;
    private final b odU;
    private final d odV;
    final ViewGroup odW;
    final ConfettiView odX;
    final Queue<b> odY;
    final List<b> odZ;
    private Float oeA;
    public float oeB;
    public float oeC;
    long oea;
    int oeb;
    long oec;
    float oed;
    float oee;
    public Interpolator oef;
    private Rect oeg;
    private float oeh;
    private float oei;
    private float oej;
    private float oek;
    private float oel;
    private float oem;
    private float oen;
    private float oeo;
    private Float oep;
    private Float oeq;
    private Float oer;
    private Float oes;
    private int oet;
    private int oeu;
    private float oev;
    private float oew;
    private float oex;
    private float oey;
    private Float oez;
    final Random random;

    public c(Context context, b bVar, d dVar, ViewGroup viewGroup) {
        this(bVar, dVar, viewGroup, ConfettiView.da(context));
    }

    private c(b bVar, d dVar, ViewGroup viewGroup, ConfettiView confettiView) {
        this.random = new Random();
        this.odY = new LinkedList();
        this.odZ = new ArrayList(300);
        this.odU = bVar;
        this.odV = dVar;
        this.odW = viewGroup;
        this.odX = confettiView;
        this.odX.odZ = this.odZ;
        this.odX.addOnAttachStateChangeListener(new 1(this));
        this.hLi = -1;
        this.oeg = new Rect(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
    }

    public final c y(float f, float f2) {
        this.oeh = f / 1000.0f;
        this.oei = f2 / 1000.0f;
        return this;
    }

    public final c z(float f, float f2) {
        this.oej = f / 1000.0f;
        this.oek = f2 / 1000.0f;
        return this;
    }

    public final c aj(float f) {
        this.oel = f / 1000000.0f;
        this.oem = 0.0f;
        return this;
    }

    public final c ak(float f) {
        this.oen = f / 1000000.0f;
        this.oeo = 0.0f;
        return this;
    }

    public final c aXk() {
        this.oet = 180;
        this.oeu = 180;
        return this;
    }

    public final c aXl() {
        this.oex = 3.6E-4f;
        this.oey = 1.8E-4f;
        return this;
    }

    public final c aXm() {
        this.oez = Float.valueOf(0.36f);
        this.oeA = Float.valueOf(0.0f);
        return this;
    }

    public final void aXn() {
        if (this.jWC != null) {
            this.jWC.cancel();
        }
        this.odX.aXn();
    }

    final void z(int i, long j) {
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = (b) this.odY.poll();
            if (bVar == null) {
                bVar = this.odU.b(this.random);
            }
            d dVar = this.odV;
            Random random = this.random;
            bVar.oeQ = 0;
            bVar.oeS = 0.0f;
            bVar.oeR = 0.0f;
            bVar.oeU = 0.0f;
            bVar.oeT = 0.0f;
            bVar.oen = 0.0f;
            bVar.oel = 0.0f;
            bVar.oer = null;
            bVar.oep = null;
            bVar.oeW = null;
            bVar.oeV = null;
            bVar.oeX = 0.0f;
            bVar.oeY = 0.0f;
            bVar.oex = 0.0f;
            bVar.oez = null;
            bVar.oeZ = null;
            bVar.hLi = 0;
            bVar.ofa = 0.0f;
            bVar.ofb = 0.0f;
            bVar.oef = null;
            bVar.ofd = 0.0f;
            bVar.ofc = 0.0f;
            bVar.ofe = 0.0f;
            bVar.alpha = 255;
            bVar.off = false;
            bVar.terminated = false;
            bVar.oeQ = j;
            bVar.oeR = (random.nextFloat() * ((float) (dVar.oeG - dVar.oeE))) + ((float) dVar.oeE);
            bVar.oeS = (((float) (dVar.oeH - dVar.oeF)) * random.nextFloat()) + ((float) dVar.oeF);
            bVar.oeT = a(this.oeh, this.oei, random);
            bVar.oeU = a(this.oej, this.oek, random);
            bVar.oel = a(this.oel, this.oem, random);
            bVar.oen = a(this.oen, this.oeo, random);
            bVar.oep = this.oep == null ? null : Float.valueOf(a(this.oep.floatValue(), this.oeq.floatValue(), random));
            bVar.oer = this.oer == null ? null : Float.valueOf(a(this.oer.floatValue(), this.oes.floatValue(), random));
            bVar.oeX = a((float) this.oet, (float) this.oeu, random);
            bVar.oeY = a(this.oev, this.oew, random);
            bVar.oex = a(this.oex, this.oey, random);
            bVar.oez = this.oez == null ? null : Float.valueOf(a(this.oez.floatValue(), this.oeA.floatValue(), random));
            bVar.hLi = this.hLi;
            bVar.oef = this.oef;
            bVar.ofa = a(this.oeB, this.oeC, random);
            bVar.g(this.oeg);
            this.odZ.add(bVar);
        }
    }

    private static float a(float f, float f2, Random random) {
        return (((random.nextFloat() * 2.0f) - 1.0f) * f2) + f;
    }
}
