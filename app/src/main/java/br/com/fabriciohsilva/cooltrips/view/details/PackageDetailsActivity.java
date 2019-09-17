package br.com.fabriciohsilva.cooltrips.view.details;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.fabriciohsilva.cooltrips.R;
import br.com.fabriciohsilva.cooltrips.model.Package;
import br.com.fabriciohsilva.cooltrips.util.CurrencyUtil;
import br.com.fabriciohsilva.cooltrips.util.DaysUtil;
import br.com.fabriciohsilva.cooltrips.util.ResourceUtil;
import br.com.fabriciohsilva.cooltrips.view.payment.PaymentActivity;

import static br.com.fabriciohsilva.cooltrips.Interfaces.Constants.KEY_PACKAGE;

public class PackageDetailsActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_details);

        setTitle(APPBAR_TITLE);

        getReceivedPckg();
    }

    private void getReceivedPckg() {
        Intent intent = getIntent();
        if (intent.hasExtra(KEY_PACKAGE)) {
            final Package pckg = (Package) intent.getSerializableExtra(KEY_PACKAGE);

            initView(pckg);
            configButton(pckg);
        }
    }

    private void configButton(final Package pckg) {
        Button btnPayment = findViewById(R.id.package_details_button_payment);
        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPayment(pckg);
            }
        });
    }

    private void goToPayment(Package pckg) {
        Intent intent = new Intent(PackageDetailsActivity.this, PaymentActivity.class);
        intent.putExtra(KEY_PACKAGE, pckg);
        startActivity(intent);
    }

    private void initView(Package pckg) {
        showPlace(pckg);
        showImage(pckg);
        showDays(pckg);
        showPrice(pckg);
        showDate(pckg);
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
