package com.example.intent.hashmap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class ELAdapter extends BaseExpandableListAdapter {
private Context context;
List<String> title;
Map<String,List<String>> child;

    public ELAdapter(Context context, List<String> title, Map<String, List<String>> child) {
        this.context = context;
        this.title = title;
        this.child = child;
    }

    @Override
    public int getGroupCount() {
        return title.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return child.get(title.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return title.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return child.get(title.get(i)).get(i);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {


        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.parent_layout, null);
        }


        TextView textView = view.findViewById(R.id.ParentText);
        textView.setText(title.get(i));
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.child_layout, null);
        }


        TextView textView = view.findViewById(R.id.ChildText);
        textView.setText(child.get(title.get(i)).get(i1));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
