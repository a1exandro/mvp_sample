package ru.wo0t.mvp_sample.repos;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import ru.wo0t.mvp_sample.models.GitHubRepo;

/**
 * Created by alex on 13.01.17.
 */

public class RepoAdapter extends BaseAdapter {

    private List<GitHubRepo> mList;
    private Context mContext;

    public RepoAdapter(Context context, List<GitHubRepo> list) {
        if (list == null) list = new ArrayList<>();
        this.mList = list;
        this.mContext = context;
    }

    public void setData(List<GitHubRepo> list) {
        mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mList.get(i).id;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = ((Activity) mContext).getLayoutInflater().inflate(android.R.layout.simple_list_item_1, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        GitHubRepo repo = (GitHubRepo) getItem(position);
        holder.text1.setText(String.format("%s - %d stars", repo.name, repo.stars));
        return view;
    }

    public static class ViewHolder {
        @Bind(android.R.id.text1)
        TextView text1;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
