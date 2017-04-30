package com.torkuds.nest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.torkuds.nest.R;

/**
 * des:显示网页的Fragment
 * Created by torkuds
 * on 2017/4/21 0021.
 */

public class WebFragment extends Fragment {

    private WebView webView;
    private String url = "http://www.baidu.com";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_web, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        webView = (WebView) view.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
//        webView.loadDataWithBaseURL(url, null, "text/html", "utf-8", null);
        webView.loadUrl(url);
    }
}
