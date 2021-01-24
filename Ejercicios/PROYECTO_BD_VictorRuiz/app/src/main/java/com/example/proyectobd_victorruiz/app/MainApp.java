package com.example.proyectobd_victorruiz.app;

import android.app.Application;

import com.example.proyectobd_victorruiz.model.vo.LibroBD;

import java.util.concurrent.atomic.AtomicLong;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MainApp extends Application {

    public static AtomicLong LIBRO_ID = new AtomicLong();

    @Override
    public void onCreate() {
        super.onCreate();
        initRealm();
        Realm realm = Realm.getDefaultInstance();
        LIBRO_ID = getIdByTable(realm, LibroBD.class);
        realm.close();

    }

    private void initRealm() {
        Realm.init(getApplicationContext());
        RealmConfiguration mRealmConfiguration = new RealmConfiguration.Builder()
                .name("librosBD.realm")
                .schemaVersion(1) // skip if you are not managing
                .deleteRealmIfMigrationNeeded()
                .allowWritesOnUiThread(true)
                .build();

        Realm.getInstance(mRealmConfiguration);
        Realm.setDefaultConfiguration(mRealmConfiguration);
    }

    /**
     * @param realm
     * @param anyClass
     * @param <T>
     * @return
     */
    private <T extends RealmObject> AtomicLong getIdByTable(Realm realm, Class<T> anyClass) {
        RealmResults<T> results = realm.where(anyClass).findAll();
        return (results.size() > 0) ? new AtomicLong(results.max("id").intValue()) : new AtomicLong();
    }

}
