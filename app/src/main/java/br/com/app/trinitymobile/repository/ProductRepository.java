package br.com.app.trinitymobile.repository;

import android.app.Application;
import androidx.lifecycle.LiveData;
import br.com.app.trinitymobile.AppDataBase;
import br.com.app.trinitymobile.model.dao.ProductDAO;
import br.com.app.trinitymobile.model.entity.Product;
import java.util.List;

public class ProductRepository {
    private ProductDAO productDAO;

    private LiveData<List<Product>> listLiveData;

    private AppDataBase appDataBase;

    public ProductRepository(Application application) {
        appDataBase = AppDataBase.getDatabase(application);
        productDAO = appDataBase.productDAO();
    }

    public Product findProductById(final long productId) {
        return this.productDAO.findProductById(productId);
    }

    public List<Product> getAll() {

        return productDAO.getAll();
    }

    public void saveAll(final List<Product> products) {

            this.productDAO.save(products.toArray(new Product[products.size()]));

    }
}
