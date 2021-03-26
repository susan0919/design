package com.example.design.launcher.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.design.R;
import com.example.design.launcher.util.AppDrawableCache;
import com.example.design.launcher.util.AppTitleCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> implements AppDrawableCache.AppDrawGeneratedListener {

    public List<String> list;
    private AppDrawableCache appDrawableCache;
    private AppTitleCache appTitleCache;
    private HashMap<String, ViewHolder> holderHashMap = new HashMap<>();
    private Context context;
    private Handler uiHandler = new Handler();

    public AppListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.app_item_layout, parent, false);
        appDrawableCache = AppDrawableCache.getInstance(context);
        appTitleCache = AppTitleCache.getInstance(context);
        appDrawableCache.setListenerList(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (list == null) {
            return;
        }
        String packageName = list.get(position);
        if (packageName == null) {
            return;
        }
        holderHashMap.put(packageName, holder);
        String title;
        if (appTitleCache.contain(packageName)) {
            title = appTitleCache.getTitle(packageName);
        } else {
            title = appTitleCache.generateAppTitle(packageName, context);
        }
        holder.appTitle.setText(title);

        AppDrawableCache.AppDrawable appDrawable;
        if (appDrawableCache.containsAppDrawable(packageName)) {
            appDrawable = appDrawableCache.getAppDrawable(packageName);
            setAppDrawableToImageView(holder.appIcon, appDrawable);
        } else {
            appDrawableCache.generateAppDrawable(packageName);
        }

    }

    private void setAppDrawableToImageView(ImageView imageView,
                                           AppDrawableCache.AppDrawable appDrawable) {
        StateListDrawable drawable = new StateListDrawable();
        Drawable normal = appDrawable.getIconNormal();
        Drawable pressed = appDrawable.getIconPressed();
        drawable.addState(new int[]{android.R.attr.state_pressed}, pressed);
        drawable.addState(new int[]{-android.R.attr.state_pressed}, normal);
        imageView.setBackground(drawable);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void setAppList(List<String> list) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        } else {
            this.list.clear();
        }
        if (list != null) {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public void onAppDrawGenerated(final String packageName) {
        if (holderHashMap.get(packageName) == null) {
            return;
        }

        uiHandler.post(new Runnable() {
            @Override
            public void run() {
                setAppDrawableToImageView(holderHashMap.get(packageName).appIcon,
                        appDrawableCache.getAppDrawable(packageName));
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView appIcon;
        TextView appTitle;

        public ViewHolder(View view) {
            super(view);
            appIcon = view.findViewById(R.id.icon_img);
            appTitle = view.findViewById(R.id.icon_text);
        }

    }
}
