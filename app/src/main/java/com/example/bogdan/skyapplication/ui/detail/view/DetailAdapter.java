package com.example.bogdan.skyapplication.ui.detail.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bogdan.skyapplication.Constants;
import com.example.bogdan.skyapplication.R;
import com.example.bogdan.skyapplication.model.entity.WeatherData;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 28.07.16
 */
public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.Holder> {
  private Context mContext;
  private List<WeatherData> mList;
  private OnItemClickListener mListener;

  public DetailAdapter(Context context, OnItemClickListener listener) {
    mContext = context;
    mListener = listener;
    mList = new ArrayList<>();
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new Holder(((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
        .inflate(R.layout.detail_row, parent, false));
  }

  @Override
  public void onBindViewHolder(Holder holder, int position) {
    WeatherData data = mList.get(position);

    Picasso.with(mContext)
        .load(Constants.HTTP.ICON_BASE_URL + data.getIcon() + ".png")
        .into(holder.icon);
    holder.day.setText(getDateText(data));
    holder.temperature.setText(getTempText(data));
  }

  @Override
  public int getItemCount() {
    return mList.size();
  }

  public void addData(List<WeatherData> data) {
    mList.addAll(data);
    notifyDataSetChanged();
  }

  public String getTempText(WeatherData data) {
    return data.getTemperature() > 0
        ? "+" + data.getTemperature() + " °C"
        : data.getTemperature() + " °C";
  }

  public String getDateText(WeatherData data) {
    Date date = new Date(data.getData());
    return new SimpleDateFormat("d MMMM", Locale.ENGLISH).format(date);
  }

  class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
    @BindView(R.id.detail_row_day)
    TextView day;

    @BindView(R.id.detail_row_image)
    ImageView icon;

    @BindView(R.id.detail_row_temperature)
    TextView temperature;

    public Holder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
      itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      view.setSelected(true);
      mListener.onClick(mList.get(getLayoutPosition()), getLayoutPosition());
    }
  }

  public interface OnItemClickListener {

    void onClick(WeatherData data, int position);
  }
}
