package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

    private int viewWidth;
    private int viewHeight;

    private List<Integer> nums;
    //            {5f,30f,30f,60f,90f,100f,50f};
    private List<String> names;
    //        = {"Froyo","GB","ICS","JB","Kitkat","Long","M"};
    private int space = 20;
    private int end = 40;
    private int baseHeight = 5;
    private int rectWidth = 100;

    private int startX = 120;
    private int startY = 80;

    private int oX;
    private int oY;

    public Practice10HistogramView(Context context) {
        this(context, null);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initList();
    }

    private void initList() {
        nums = new ArrayList<>();
        nums.add(2);
        nums.add(10);
        nums.add(10);
        nums.add(60);
        nums.add(90);
        nums.add(100);
        nums.add(50);
//        {"Froyo","GB","ICS","JB","Kitkat","Long","M"};

        names = new ArrayList<>();
        names.add("Froyo");
        names.add("GB");
        names.add("ICS");
        names.add("JB");
        names.add("Kitkat");
        names.add("Long");
        names.add("M");
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

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        int maxValue = nums.get(0);
        for (int i = 0; i < nums.size(); i++) {
            if (maxValue < nums.get(i)) {
                maxValue = nums.get(i);
            }
        }

        oX = startX;
        oY = startY + maxValue * baseHeight + end;
        //画线
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(3);
        float[] lines = {startX, startY, startX, oY, startX, oY, startX + nums.size() * (space + rectWidth) + end, startY + maxValue * baseHeight + end};
        canvas.drawLines(lines, 0, 8, paint);

        //画矩形
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < nums.size(); i++) {
            int left = oX + (i + 1) * space + i * rectWidth;
            int top = oY - nums.get(i) * baseHeight;
            int right = oX + (i + 1) * space + (i + 1) * rectWidth;
            int bottom = oY;
            canvas.drawRect(left, top, right, bottom, paint);
        }

        paint.setStyle(Paint.Style.FILL);
        //画标签
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setTextSize(24);
        for (int i = 0; i < nums.size(); i++) {
            Rect rect = new Rect();
            String s = names.get(i);
            paint.getTextBounds(s, 0, s.length(), rect);
            int tX = oX + (i + 1) * space + (i * rectWidth) + (rectWidth / 2) - (rect.width() / 2);
            int tY = (int) (oY + paint.getTextSize() + 3);
            canvas.drawText(s, tX, tY, paint);

        }


        paint.setTextSize(34);
        String title = "直方图";
        Rect rect = new Rect();
        paint.getTextBounds(title, 0, title.length(), rect);
        canvas.drawText(title, viewWidth / 2 - rect.width() / 2, viewHeight - 70, paint);


    }
}
