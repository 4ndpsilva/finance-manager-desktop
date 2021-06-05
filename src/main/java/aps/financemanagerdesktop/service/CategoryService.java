package aps.financemanagerdesktop.service;

import aps.financemanagerdesktop.dao.CategoryDAO;
import aps.financemanagerdesktop.dao.ConnectionFactory;
import aps.financemanagerdesktop.entity.Category;

import java.util.List;

public class CategoryService {
    private CategoryDAO dao;

    public CategoryService() {
        try{
            dao = new CategoryDAO(ConnectionFactory.getConnection());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void save(final Category entity) throws Exception {
        dao.save(entity);
    }

    public List<Category> listAll() throws Exception {
        return dao.listAll();
    }
}