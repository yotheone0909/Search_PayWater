package com.example.yothin_error.search_paywater;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import java.util.ArrayList;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.ColorFilterTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.MaskTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


/**
 * Created by Yothin_Error on 27/2/2560.
 */
public class PayWaterAdapter extends BaseAdapter implements Filterable {
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<WaterList> mPayWaterList;
    ArrayList<WaterList> filterList;
    CustomFilter filter;


    public PayWaterAdapter(Activity activity, ArrayList<WaterList> mProductList) {
        this.mPayWaterList = mProductList;
        this.activity = activity;
        this.filterList = mProductList;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mPayWaterList.size();
    }

    @Override
    public Object getItem(int i) {
        return mPayWaterList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return Long.parseLong(mPayWaterList.get(i).getrenter_code());
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = view;

        v = inflater.inflate(R.layout.list_item_paywater, null);
        TextView tvSearchPayCode = (TextView) v.findViewById(R.id.tvSearchPayCode);
        ImageView IvSearchPayRenter = (ImageView) v.findViewById(R.id.IvSearchPayRenter);
        TextView tv_SearchPayName = (TextView) v.findViewById(R.id.tv_SearchPayName);
        TextView tv_SearchPayLastName = (TextView) v.findViewById(R.id.tv_SearchPayLastName);
        TextView tv_SearchPayStallName = (TextView) v.findViewById(R.id.tv_SearchPayStallName);
        TextView tv_SearchPayStatus = (TextView) v.findViewById(R.id.tv_SearchPayStatus);
        TextView tv_SearchPayPeriod = (TextView) v.findViewById(R.id.tv_SearchPayPeriod);

        WaterList waterList = mPayWaterList.get(position);
        tvSearchPayCode.setText(waterList.getrenter_code());
//        IvSearchPayRenter.setImageDrawable(Drawable.createFromPath(waterList.getRenter_image()));
        String Image = waterList.getRenter_image();
        Glide.with(activity).load("http://172.20.10.9/SC/admin/dist/img/"+Image)
                .placeholder(android.R.drawable.ic_menu_upload)
                .bitmapTransform(new BlurTransformation(activity,1),new CropCircleTransformation(activity),new CropSquareTransformation(activity))
                .error(android.R.drawable.stat_notify_error)
                .into(IvSearchPayRenter);
        tv_SearchPayName.setText(waterList.getRenter_name());
        tv_SearchPayLastName.setText(waterList.getRenter_lastname());
        tv_SearchPayStallName.setText(waterList.getStall_name());
        tv_SearchPayStatus.setText(waterList.getPayment_status());
        tv_SearchPayPeriod.setText(waterList.getPayment_period());


        return v;
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new CustomFilter();
        }


        return filter;
    }

    private class CustomFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                constraint = constraint.toString().toUpperCase();

                ArrayList<WaterList> filters = new ArrayList<>();
                for (int i = 0; i < filterList.size(); i++) {
                    if (filterList.get(i).getRenter_code().toUpperCase().contains(constraint)||filterList.get(i).getPayment_period().contains(constraint)||filterList.get(i).getPayment_status().contains(constraint)) {
                        WaterList u = new WaterList(filterList.get(i).getPayment_period()
                                , filterList.get(i).getPayment_status()
                                , filterList.get(i).getRenter_code()
                                , filterList.get(i).getRenter_name()
                                , filterList.get(i).getRenter_lastname()
                                , filterList.get(i).getRenter_image()
                                , filterList.get(i).getStall_name()
                        );
                        filters.add(u);
                    }
                }

                results.count = filters.size();
                results.values = filters;
            } else {
                results.count = filterList.size();
                results.values = filterList;
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults filterResults) {
            mPayWaterList = (ArrayList<WaterList>) filterResults.values;
            notifyDataSetChanged();

        }
    }
}

