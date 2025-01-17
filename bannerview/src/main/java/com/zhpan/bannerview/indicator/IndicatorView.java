package com.zhpan.bannerview.indicator;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.zhpan.bannerview.indicator.drawer.BaseDrawer;
import com.zhpan.bannerview.indicator.drawer.DrawerProxy;
import com.zhpan.bannerview.manager.IndicatorOptions;

/**
 * <pre>
 *   Created by zhpan on 2019/11/23.
 *   Description:The Indicator in BannerViewPager，this include two indicator style,as below:
 *  {@link com.zhpan.bannerview.constants.IndicatorStyle#CIRCLE }
 *  {@link com.zhpan.bannerview.constants.IndicatorStyle#DASH}
 * </pre>
 */
public class IndicatorView extends BaseIndicatorView implements IIndicator {

    private DrawerProxy mDrawerProxy;

    public IndicatorView(Context context) {
        this(context, null);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IndicatorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDrawerProxy = new DrawerProxy(getIndicatorOptions());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        BaseDrawer.MeasureResult measureResult = mDrawerProxy.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureResult.getMeasureWidth(), measureResult.getMeasureHeight());
    }

    @Override
    public void setIndicatorOptions(IndicatorOptions indicatorOptions) {
        super.setIndicatorOptions(indicatorOptions);
        mDrawerProxy.setIndicatorOptions(indicatorOptions);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mDrawerProxy.onDraw(canvas);
    }
}
