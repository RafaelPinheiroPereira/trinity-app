package br.com.app.trinitymobile.repository;

import br.com.app.trinitymobile.model.entity.Price;
import br.com.app.trinitymobile.utils.Constants;
import br.com.app.trinitymobile.utils.PriceFile;
import br.com.app.trinitymobile.utils.Singleton;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PriceFileRepository implements  IFileRepository {

    PriceFile priceFile;
    List<Price> prices;

    public PriceFileRepository() throws IllegalAccessException, InstantiationException {
        priceFile= Singleton.getInstance(PriceFile.class);
    }



    public List<Price> getPrices() {
        return prices;
    }



    private void setPrices(final List<Price> prices) {
        this.prices = prices;
    }

    @Override
    public void readFile() throws IOException, InstantiationException, IllegalAccessException {

        File file= priceFile.createFile(Constants.APP_DIRECTORY, Constants.INPUT_FILES[3]);
        priceFile.readFile(file);
        this.setPrices(priceFile.getPrices());

    }
}
