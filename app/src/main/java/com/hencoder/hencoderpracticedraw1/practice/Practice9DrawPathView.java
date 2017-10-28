package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    private int viewWidth;
    private int viewHeight;

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.viewWidth = getMeasuredWidth();
        this.viewHeight = getMeasuredHeight();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        paint.setAlpha(188);

        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.addArc(viewWidth/4-200,viewHeight/2-171,viewWidth/4,viewHeight/2-171+200,-225,225);
        path.arcTo(viewWidth/4,viewHeight/2-171,viewWidth/4+200,viewHeight/2-171+200,-180,225,false);
        path.lineTo(viewWidth/4,viewHeight/2+171);
        path.close();
        canvas.drawPath(path,paint);

        Path path1 = new Path();
        paint.setStyle(Paint.Style.FILL);
        path1.addArc(viewWidth/4 *3 -200,viewHeight/2-171,viewWidth/4*3,viewHeight/2-171+200,-225,225);
        path1.arcTo(viewWidth/4*3,viewHeight/2-171,viewWidth/4*3+200,viewHeight/2-171+200,-180,225,false);
        path1.lineTo(viewWidth/4*3,viewHeight/2+171);
        canvas.drawPath(path1,paint);

    }
}
