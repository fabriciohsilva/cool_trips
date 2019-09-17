package br.com.fabriciohsilva.cooltrips.view.PurchaseSummary;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.fabriciohsilva.cooltrips.R;
import br.com.fabriciohsilva.cooltrips.model.Package;
import br.com.fabriciohsilva.cooltrips.util.CurrencyUtil;
import br.com.fabriciohsilva.cooltrips.util.DaysUtil;
import br.com.fabriciohsilva.cooltrips.util.ResourceUtil;

import static br.com.fabriciohsilva.cooltrips.Interfaces.Constants.KEY_PACKAGE;

public class PurchaseSummaryActivity extends AppCompatActivity {

    public static final String APPBARTITLE = "Resumo da Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_summary);

        setTitle(APPBARTITLE);

        getReceivedPckg();

    }

    private void getReceivedPckg() {
        Intent intent = getIntent();
        if (intent.hasExtra(KEY_PACKAGE)) {
            final Package pckg = (Package) intent.getSerializableExtra(KEY_PACKAGE);

            initView(pckg);
        }
    }

    private void initView(Package pckg) {
        showPlace(pckg);
        showImage(pckg);
        showDate(pckg);
        showPrice(pckg);
    }

    private void showPrice(Package pckg) {
        TextView price = findViewById(R.id.purchase_summary_pkg_price);
        String pkgPrice = CurrencyUtil.formatBrasilianString(pckg.getPrice());
        price.setText(pkgPrice);
    }

    private void showDate(Package pckg) {
        TextView date = findViewById(R.id.purchase_summary_pkg_date);
        String period = DaysUtil.periodInText(pckg.getDays());
        date.setText(period);
    }

    private void showImage(Package pckg) {
        ImageView image = findViewById(R.id.purchase_summary_pkg_img);
        Drawable pkgImage = ResourceUtil.returnDrawable(this, pckg.getImage());
        image.setImageDrawable(pkgImage);
    }

    private void showPlace(Package pckg) {
        TextView place = findViewById(R.id.purchase_summary_pkg_place);
        place.setText(pckg.getPlace());
    }
}
