package br.com.fabriciohsilva.cooltrips.view.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.fabriciohsilva.cooltrips.R;
import br.com.fabriciohsilva.cooltrips.dao.PackageDAO;
import br.com.fabriciohsilva.cooltrips.model.Package;
import br.com.fabriciohsilva.cooltrips.view.details.PackageDetailsActivity;

import static br.com.fabriciohsilva.cooltrips.Interfaces.Constants.KEY_PACKAGE;

public class PackageListActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Packages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_list);

        setTitle(APPBAR_TITLE);
        configList();

    }

    private void configList() {
        ListView packageList = findViewById(R.id.package_list_listview);
        final List<Package> packages = new PackageDAO().lista();
        packageList.setAdapter(new PackageListAdapter(packages, this));
        packageList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Package selectedPkg = packages.get(position);
                goToPckgDetails(selectedPkg);
            }
        });
    }

    private void goToPckgDetails(Package selectedPkg) {
        Intent intent = new Intent(PackageListActivity.this, PackageDetailsActivity.class);
        intent.putExtra(KEY_PACKAGE, selectedPkg);
        startActivity(intent);
    }
}
