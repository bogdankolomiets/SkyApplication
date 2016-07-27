package com.example.bogdan.skyapplication.view.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bogdan.skyapplication.R;
import com.example.bogdan.skyapplication.model.entity.CityWeatherVO;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Bogdan Kolomiets
 * @version 1
 * @date 27.07.16
 */
public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.Holder> {
  private Context mContext;
  private List<CityWeatherVO> mCities;

  public CitiesAdapter(Context context) {
    mContext = context;
    mCities = new ArrayList<>();
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new Holder(((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
        .inflate(R.layout.city_weather_row, parent, false));
  }

  @Override
  public void onBindViewHolder(Holder holder, int position) {
    CityWeatherVO city = mCities.get(position);

    Picasso.with(mContext)
        .load("")
        .into(holder.icon);
    holder.name.setText(city.getName());
    holder.description.setText(city.getDescription());
    holder.temperature.setText(city.getTemperature());
  }

  @Override
  public int getItemCount() {
    return mCities.size();
  }

  public void addCity(CityWeatherVO city) {
    mCities.add(city);
    notifyDataSetChanged();
  }

  class Holder extends RecyclerView.ViewHolder {
    @BindView(R.id.row_weather_icon)
    ImageView icon;

    @BindView(R.id.row_city_name)
    TextView name;

    @BindView(R.id.row_weather_description)
    TextView description;

    @BindView(R.id.row_weather_temperature)
    TextView temperature;

    public Holder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
