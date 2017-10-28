package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    private int viewWidth;
    private int viewHeight;

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(viewWidth/2 - 200,viewHeight/2-100,viewWidth/2 +200,viewHeight/2+100,-170,60,false,paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(viewWidth/2 - 200,viewHeight/2-100,viewWidth/2 +200,viewHeight/2+100,-100,90,true,paint);

        canvas.drawArc(viewWidth/2 - 200,viewHeight/2-50,viewWidth/2 +200,viewHeight/2+150,0,180,true,paint);



    }
}