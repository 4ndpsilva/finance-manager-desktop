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
        if(entity.getId() != null && entity.getId() > 0){
            dao.update(entity);
        }
        else{
            dao.save(entity);
        }
    }

    public void delete(final Long id) throws Exception {
        dao.delete(id);
    }

    public List<Category> listAll() throws Exception {
        return dao.listAll();
    }
}