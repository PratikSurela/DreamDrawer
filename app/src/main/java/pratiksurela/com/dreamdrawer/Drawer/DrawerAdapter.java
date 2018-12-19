package pratiksurela.com.dreamdrawer.Drawer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import pratiksurela.com.dreamdrawer.R;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.DrawerViewHolder> {
    private Context context;
    private ArrayList<DrawerItem> drawerMenuList;
    private RecyclerViewClickListener mListener;
    private static int row_index = 0;

    DrawerAdapter(Context context, ArrayList<DrawerItem> drawerMenuList, RecyclerViewClickListener mListener) {
        this.context = context;
        this.drawerMenuList = drawerMenuList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public DrawerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_drawer, parent, false);

        return new DrawerViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull DrawerViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.txtTitle.setText(drawerMenuList.get(position).getTitle());

        /**
         row_index is used to manage default/previous selected item
         if row_index and position is same then drawer item is selected
         So we can set white icon and text here
         setColorFilter - is used to display dark grey icons and white -> You can set your desired color over here
         **/
        if (row_index == position) {
            //drawer icon tint set to white here
            holder.imgGreyIcon.setImageResource(drawerMenuList.get(position).getWhite_icon());
            holder.imgGreyIcon.setColorFilter(ContextCompat.getColor(context, R.color.white), PorterDuff.Mode.MULTIPLY);
            holder.txtTitle.setTextColor(context.getResources().getColor(R.color.white));
            holder.llMainLayout.setBackgroundResource(R.drawable.bg_drawer_item_shape);
        } else {
            //drawer icon tint set to dark grey here
            holder.imgGreyIcon.setImageResource(drawerMenuList.get(position).getIcon());
            holder.imgGreyIcon.setColorFilter(ContextCompat.getColor(context, R.color.dark_grey2), PorterDuff.Mode.MULTIPLY);
            holder.txtTitle.setTextColor(context.getResources().getColor(R.color.dark_grey2));
            holder.llMainLayout.setBackgroundResource(R.drawable.bg_drawer_item_shape_default);
        }
        holder.llMainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                row_index = position;
                mListener.onDrawerListClick(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return drawerMenuList.size();
    }

    class DrawerViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private ImageView imgGreyIcon;
        private LinearLayout llMainLayout;

        DrawerViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            imgGreyIcon = itemView.findViewById(R.id.imgGreyIcon);
            llMainLayout = itemView.findViewById(R.id.llMainLayout);
        }
    }

    public void drawerChangedSelection(int position) {
        row_index = position;
        mListener.onDrawerListClick(position);
        notifyDataSetChanged();
    }
}