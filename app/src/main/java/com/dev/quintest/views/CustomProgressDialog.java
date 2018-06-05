package com.dev.quintest.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.view.Window;
import android.widget.ImageView;

import com.dev.quintest.R;

public class CustomProgressDialog {

    private Context mContext;
    public Dialog mDialog;
    private AnimationDrawable Anim;
    //private ProgressBar mProgressBar;

    public CustomProgressDialog(Context context) {
        mContext = context;
    }

   /* public void showProgress() {
        try {
            if (mDialog == null && mContext != null
                    && !((Activity) mContext).isFinishing()) {
                mDialog = new Dialog(mContext, R.style.NewDialog);
                mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                mDialog.setContentView(R.layout.progress_dialog);
                ImageView imageViewProgress = (ImageView) mDialog
                        .findViewById(R.id.imageview_progress);

                BitmapDrawable frame1 = (BitmapDrawable) mContext
                        .getResources().getDrawable(R.drawable.brace_small);
                BitmapDrawable frame2 = (BitmapDrawable) mContext
                        .getResources().getDrawable(R.drawable.brace_middle);
                BitmapDrawable frame3 = (BitmapDrawable) mContext
                        .getResources().getDrawable(R.drawable.brace_big);
               *//*  BitmapDrawable frame4 = (BitmapDrawable) mContext
                        .getResources().getDrawable(R.drawable.page_loading_04);
                BitmapDrawable frame5 = (BitmapDrawable) mContext
                        .getResources().getDrawable(R.drawable.page_loading_05);
                BitmapDrawable frame6 = (BitmapDrawable) mContext
                        .getResources().getDrawable(R.drawable.page_loading_06);
                BitmapDrawable frame7 = (BitmapDrawable) mContext
                        .getResources().getDrawable(R.drawable.page_loading_07);
                BitmapDrawable frame8 = (BitmapDrawable) mContext
                        .getResources().getDrawable(R.drawable.page_loading_08);
                BitmapDrawable frame9 = (BitmapDrawable) mContext
                        .getResources().getDrawable(R.drawable.page_loading_09);
                BitmapDrawable frame10 = (BitmapDrawable) mContext
                        .getResources().getDrawable(R.drawable.page_loading_10);
                BitmapDrawable frame11 = (BitmapDrawable) mContext
                        .getResources().getDrawable(R.drawable.page_loading_11);
                BitmapDrawable frame12 = (BitmapDrawable) mContext
                        .getResources().getDrawable(R.drawable.page_loading_12);*//*

                Anim = new AnimationDrawable();
                Anim.addFrame(frame1, 500);
                Anim.addFrame(frame2, 500);
                Anim.addFrame(frame3, 500);
                *//*Anim.addFrame(frame4, 100);
                Anim.addFrame(frame5, 100);
                Anim.addFrame(frame6, 100);
                Anim.addFrame(frame7, 100);
                Anim.addFrame(frame8, 100);

                Anim.addFrame(frame9, 100);
                Anim.addFrame(frame10, 100);
                Anim.addFrame(frame11, 100);

                Anim.addFrame(frame12, 100);*//*

                Anim.setOneShot(false);
                imageViewProgress.setBackgroundDrawable(Anim);
                Anim.start();
                mDialog.setCanceledOnTouchOutside(true);
                mDialog.setCancelable(true);

                try {
                    mDialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public void dismissProgress() {
        try {
            if (mDialog != null) {
                if (Anim != null) {
                    Anim.stop();
                }
                if (mDialog.isShowing()) {
                    mDialog.dismiss();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
