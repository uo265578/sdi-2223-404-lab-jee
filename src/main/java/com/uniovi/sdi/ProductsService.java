package com.uniovi.sdi;
import java.util.LinkedList;
import java.util.List;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
public class ProductsService {
    public List<Product> getProducts() {
        List<Product> products = new LinkedList<Product>();
        ObjectContainer db = null;
        try {
            db = Db4oEmbedded.openFile("bdProducts");
            List<Product> response = db.queryByExample(Product.class);
            // NO RETORNAR LA MISMA LISTA DE LA RESPUESTA
            products.addAll(response);
        } finally {
            db.close();
        }
        return products;
    }
    public void setNewProduct(Product newProduct) {
        ObjectContainer db = null;
        try {
            db = Db4oEmbedded.openFile("bdProducts");
            db.store(newProduct);
        } finally {
            db.close();
        }
    }

    public List<Blog> getComments() {
        List<Blog> comments = new LinkedList<Blog>();
        ObjectContainer db = null;
        try {
            db = Db4oEmbedded.openFile("bdBlogs");
            List<Blog> response = db.queryByExample(Blog.class);
            // NO RETORNAR LA MISMA LISTA DE LA RESPUESTA
            comments.addAll(response);
        } finally {
            db.close();
        }
        return comments;
    }
    public void setNewComment(Blog newBlog) {
        ObjectContainer db = null;
        try {
            db = Db4oEmbedded.openFile("bdBlogs");
            db.store(newBlog);
        } finally {
            db.close();
        }
    }
}
