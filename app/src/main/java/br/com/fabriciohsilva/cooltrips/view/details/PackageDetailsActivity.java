package br.com.fabriciohsilva.cooltrips.view.details;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.fabriciohsilva.cooltrips.R;
import br.com.fabriciohsilva.cooltrips.model.Package;
import br.com.fabriciohsilva.cooltrips.util.CurrencyUtil;
import br.com.fabriciohsilva.cooltrips.util.DaysUtil;
import br.com.fabriciohsilva.cooltrips.util.ResourceUtil;

public class PackageDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_details);

        Package pckgSP = new Package("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        TextView place = findViewById(R.id.package_details_place);
        place.setText(pckgSP.getPlace());

        ImageView image = findViewById(R.id.package_details_image);
        Drawable pckgDrawable = ResourceUtil.returnDrawable(this, pckgSP.getImage());
        image.setImageDrawable(pckgDrawable);

        TextView days = findViewById(R.id.package_details_days);
        String daysInString = DaysUtil.formatInText(pckgSP.getDays());
        days.setText(daysInString);

        TextView price = findViewById(R.id.package_details_price);
        String brasilianCurrency = CurrencyUtil.formatBrasilianString(pckgSP.getPrice());
        price.setText(brasilianCurrency);

        TextView date = findViewById(R.id.package_details_date);


    }
}
