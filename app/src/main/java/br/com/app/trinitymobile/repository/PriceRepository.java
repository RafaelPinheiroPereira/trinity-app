package br.com.app.trinitymobile.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import br.com.app.trinitymobile.AppDataBase;
import br.com.app.trinitymobile.model.dao.PriceDAO;
import br.com.app.trinitymobile.model.entity.Price;
import br.com.app.trinitymobile.model.entity.Product;
import br.com.app.trinitymobile.model.entity.Unity;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PriceRepository {
    private PriceDAO priceDAO;

    private LiveData<List<Price>> listLiveData;

    private AppDataBase appDataBase;

    public PriceRepository(Application application) {
        appDataBase = AppDataBase.getDatabase(application);
        priceDAO = appDataBase.priceDAO();
    }

    public Price findPriceByUnitAndProduct(final Product productSelected, final Unity unity) {
        return  this.priceDAO.findPriceByUnitAndProduct(productSelected.getId(),unity.getCode());
    }

    public LiveData<List<Price>> getAll() throws ExecutionException, InterruptedException {

        return priceDAO.getAll();
    }

    public void saveAll(final List<Price> prices) {

            this.priceDAO.save(prices.toArray(new Price[prices.size()]));

    }
}
