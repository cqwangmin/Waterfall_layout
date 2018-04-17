package com.example.wangming.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Wm> wmList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWm();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        WmAdapter adapter = new WmAdapter(wmList);
        recyclerView.setAdapter(adapter);
    }
    private void initWm()
    {
        for (int i = 0;i<3 ;i++) {
            Wm one = new Wm("one", R.drawable.one);
            wmList.add(one);
            Wm two = new Wm("two", R.drawable.two);
            wmList.add(two);
            Wm three = new Wm("three", R.drawable.three);
            wmList.add(three);
            Wm four = new Wm("four", R.drawable.four);
            wmList.add(four);
            Wm five = new Wm("five", R.drawable.five);
            wmList.add(five);
            Wm six = new Wm("six", R.drawable.six);
            wmList.add(six);
        }
    }
    public class WmAdapter extends RecyclerView.Adapter<WmAdapter.ViewHolder>
    {
        private List<Wm> mWmLsit;
        class ViewHolder extends RecyclerView.ViewHolder
        {
            ImageView wmImage;
            TextView wmName;
            public ViewHolder(View view)
            {
                super(view);
                wmImage = (ImageView) view.findViewById(R.id.wm_image);
                wmName = (TextView) view.findViewById(R.id.wm_name);
            }
        }
        public WmAdapter(List<Wm> wmList)
        {
            mWmLsit = wmList;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
        {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.wm_item,parent,false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }
        @Override
        public void onBindViewHolder(ViewHolder holder,int position)
        {
            Wm wm = mWmLsit.get(position);
            holder.wmImage.setImageResource(wm.getImageId());
            holder.wmName.setText(wm.getName());
        }
        @Override
        public int getItemCount()
        {
            return mWmLsit.size();
        }
    }


    public class Wm
    {
        private String Name;
        private int imageId;
        public Wm(String name,int imageId)
        {
            this.Name = name;
            this.imageId = imageId;
        }
        public String getName()
        {
            return  Name;
        }
        public int getImageId()
        {
            return imageId;
        }
    }
}
