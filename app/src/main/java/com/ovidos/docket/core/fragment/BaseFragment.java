package com.ovidos.docket.core.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ovidos.docket.BuildConfig;
import com.ovidos.docket.R;
import com.ovidos.docket.core.activity.BaseActivity;
import com.ovidos.docket.helper.Networks;
import com.ovidos.docket.network.api.ApiService;
import com.ovidos.docket.widgets.ToastType;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by omral on 11.05.2017.
 */

public class BaseFragment extends Fragment {

    protected final static boolean DEBUG = BuildConfig.DEBUG;
    protected ApiService mApiService;

    private Toast mLastToast;
    private View mToastView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        mApiService = ((BaseActivity) getActivity()).getApiService();
    }

    protected void generalFailureHandler(String tag, Throwable t) {
        if (DEBUG) {
            t.printStackTrace();
            Log.d(tag, "generalFailureHandler: " + t.getMessage());
        }
        if (Networks.isNetworkConnected(getContext())) {
            showToast(R.string.general_error);
        } else {
            showToast(R.string.internet_error);
        }
    }

    protected void showToast(@StringRes int resId) {
        displayToastWithUIThread(getText(resId), ToastType.generalError);
    }


    protected void showToast(final CharSequence message) {
        displayToastWithUIThread(message ,ToastType.generalError);
    }

    protected void showToast(@StringRes int resId, ToastType type) {
        displayToastWithUIThread(getText(resId), type);
    }

    protected void showToast(final CharSequence message, ToastType type) {
        displayToastWithUIThread(message ,type);
    }

    private void displayToastWithUIThread(final CharSequence message, final ToastType type) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                createAndShowToast(message, type);
            }
        });
    }

    private void createAndShowToast(CharSequence message, ToastType type) {

        if (mLastToast != null) {
            mLastToast.cancel();
        }

        if (mToastView == null) {
            mToastView = getActivity().getLayoutInflater().inflate(R.layout.toast,
                    (ViewGroup) getActivity().findViewById(R.id.toastRoot));
        }

        switch (type) {
            case generalError:
                mToastView.setBackgroundResource(R.drawable.toast_shape_error);
                break;
            default:
                mToastView.setBackgroundResource(R.drawable.toast_shape_error);
        }

        TextView messageTextView = (TextView) mToastView.findViewById(R.id.messageTextView);
        messageTextView.setText(message);

        Toast toast = new Toast(getActivity().getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 150);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(mToastView);
        toast.show();
        mLastToast = toast;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
