package cn.studyjams.s2.sj0147.huangkai.View;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;



public class Menu extends HorizontalScrollView {
    private ViewGroup mContent;
    private  ViewGroup mMenau;
    private LinearLayout mWapper;
    private int mWith;//屏幕宽度
    private int mMenuRightPad = 350 ;//dp
    private boolean once;
    private  int mMeanuwith;


    private GestureDetector mGestureDetector;

    public Menu(Context context, AttributeSet attrs) {
        super(context, attrs);
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        mWith = outMetrics.widthPixels;

        //把dp转换成xp
//       mMenuRightPad = (int) TypedValue.applyDimension(
//                TypedValue.COMPLEX_UNIT_DIP,50,context.getResources().getDisplayMetrics());

    }




    //设置子view的宽度 高度  设置自己的高宽
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
       if (!once){
           mWapper = (LinearLayout) getChildAt(0);
           mMenau = (ViewGroup) mWapper.getChildAt(0);
           mContent = (ViewGroup) mWapper.getChildAt(1);
           mMeanuwith = mMenau.getLayoutParams().width = mWith - mMenuRightPad;
           mContent.getLayoutParams().width = mWith;
           once = true;
       }



    }
//通过设置偏移量 隐藏menau
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        if (changed){
            this.scrollTo(mMeanuwith,0);
        }

        super.onLayout(changed, l, t, r, b);

    }
    // Up时，进行判断，如果显示区域大于菜单宽度一半则完全显示，否则隐藏
    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();//隐藏在左边的宽度
                if (scrollX>=mMeanuwith/2){
                    this.smoothScrollTo(mMeanuwith,0);

                }
                else {
                    this.smoothScrollTo(0,0);
                }


                return true;
        }

        return super.onTouchEvent(ev);
    }


//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return super.onInterceptTouchEvent(ev)
//                && mGestureDetector.onTouchEvent(ev);
//    }

    class YScrollDetector extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2,
                                float distanceX, float distanceY) {
            /**
             * 如果我们滚动更接近水平方向,返回false,让子视图来处理它
             */
            if (Math.abs(distanceY) > Math.abs(distanceX)) {
                return true;
            }
            return false;
        }
        }



    }

