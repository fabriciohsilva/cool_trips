package br.com.fabriciohsilva.cooltrips.view.details;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.fabriciohsilva.cooltrips.R;
import br.com.fabriciohsilva.cooltrips.model.Package;
import br.com.fabriciohsilva.cooltrips.util.CurrencyUtil;
import br.com.fabriciohsilva.cooltrips.util.DaysUtil;
import br.com.fabriciohsilva.cooltrips.util.ResourceUtil;

public class PackageDetailsActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_details);

        setTitle(APPBAR_TITLE);

        Package pckgSP = new Package("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        showPlace(pckgSP);
        showImage(pckgSP);
        showDays(pckgSP);
        showPrice(pckgSP);
        showDate(pckgSP);

    }

    private void showDate(Package pckg) {
        TextView date = findViewById(R.id.package_details_date);
        String pckgDateFormated = DaysUtil.periodInText(pckg.getDays());
        date.setText(pckgDateFormated);
    }


    private void showPrice(Package pckg) {
        TextView price = findViewById(R.id.package_details_price);
        String brasilianCurrency = CurrencyUtil.formatBrasilianString(pckg.getPrice());
        price.setText(brasilianCurrency);
    }

    private void showDays(Package pckg) {
        TextView days = findViewById(R.id.package_details_days);
        String daysInString = DaysUtil.formatInText(pckg.getDays());
        days.setText(daysInString);
    }

    private void showImage(Package pckg) {
        ImageView image = findViewById(R.id.package_details_image);
        Drawable pckgDrawable = ResourceUtil.returnDrawable(this, pckg.getImage());
        image.setImageDrawable(pckgDrawable);
    }

    private void showPlace(Package pckg) {
        TextView place = findViewById(R.id.package_details_place);
        place.setText(pckg.getPlace());
    }
}
