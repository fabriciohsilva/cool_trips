package br.com.fabriciohsilva.cooltrips.view.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.fabriciohsilva.cooltrips.model.Package;
import br.com.fabriciohsilva.cooltrips.util.DaysUtil;
import br.com.fabriciohsilva.cooltrips.util.CurrencyUtil;
import br.com.fabriciohsilva.cooltrips.R;
import br.com.fabriciohsilva.cooltrips.util.ResourceUtil;

public class PackageListAdapter extends BaseAdapter {

    private final List<Package> packages;
    private final Context context;

    public PackageListAdapter(List<Package> packages, Context context){
        this.packages = packages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return packages.size();
    }

    @Override
    public Package getItem(int position) {
        return packages.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View createdView = LayoutInflater.from(context)
                .inflate(R.layout.package_item, parent, false);

        Package packg = packages.get(position);

        showPlace(createdView, packg);
        showImage(createdView, packg);
        showDays(createdView, packg);
        showPrice(createdView, packg);

        return createdView;
    }

    private void showPrice(View createdView, Package packg) {
        TextView price = createdView.findViewById(R.id.package_item_price);
        String brasilianCurrency = CurrencyUtil
                .formatBrasilianString(packg.getPrice());
        price.setText(brasilianCurrency);
    }

    private void showDays(View createdView, Package packg) {
        TextView days = createdView.findViewById(R.id.package_item_days);
        String daysinString = DaysUtil.formatInText(packg.getDays());
        days.setText(daysinString);
    }

    private void showImage(View createdView, Package packg) {
        ImageView image = createdView.findViewById(R.id.package_item_image);
        Drawable drawablePackageImage = ResourceUtil
                .returnDrawable(context, packg.getImage());
        image.setImageDrawable(drawablePackageImage);
    }

    private void showPlace(View createdView, Package packg) {
        TextView local = createdView.findViewById(R.id.package_item_place);
        local.setText(packg.getPlace());
    }

}
