package aps.financemanagerdesktop.service;

import aps.financemanagerdesktop.dao.CategoryDAO;
import aps.financemanagerdesktop.dao.ConnectionFactory;
import aps.financemanagerdesktop.entity.Category;

import java.util.List;

public class CategoryService {
    private CategoryDAO dao;

    public CategoryService() throws Exception{
        dao = new CategoryDAO(ConnectionFactory.getConnection());
    }

    public void save(final Category entity) throws Exception {
        dao.save(entity);
    }

    public List<Category> listAll() throws Exception {
        return dao.listAll();
    }
}