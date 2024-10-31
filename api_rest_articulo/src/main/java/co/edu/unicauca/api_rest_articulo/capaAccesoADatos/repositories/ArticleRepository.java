package co.edu.unicauca.api_rest_articulo.capaAccesoADatos.repositories;
import co.edu.unicauca.api_rest_articulo.capaAccesoADatos.models.ArticleEntity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
 
@Repository
public class ArticleRepository {
    private ArrayList<ArticleEntity> listaArticulos;
    private int pos;

    public ArticleRepository() {
        this.listaArticulos = new ArrayList<ArticleEntity>();
        loadArticles();
        pos=this.listaArticulos.size()+1;
    }

    public List<ArticleEntity> findAll() {
        System.out.println("Invocando a listarArticulos");
        return this.listaArticulos;
    }

    public ArticleEntity findById(Integer id) {
        System.out.println("Invocando a consultar un articulo");
        ArticleEntity objArticulo = null;
        for (ArticleEntity articulo : listaArticulos) {
            if (articulo.getId() == id) {
                objArticulo = articulo;
                break;
            }
        }
        return objArticulo;
    }

    public ArticleEntity save(ArticleEntity articulo) {
        System.out.println("Invocando a registrar articulo");
        ArticleEntity objArticulo = null;
        articulo.setId(pos);
        if (this.listaArticulos.add(articulo)) {
            objArticulo = articulo;
            pos++;
        }
        return objArticulo;
    }

    public ArticleEntity update(Integer id, ArticleEntity articulo) {
        System.out.println("Invocando a actualizar articulo");
        ArticleEntity objArticulo = null;
        for (ArticleEntity articuloTemp : listaArticulos) {
            if (articuloTemp.getId() == id) {
                articuloTemp.setTitle(articulo.getTitle());
                articuloTemp.setJournal(articulo.getJournal());
                articuloTemp.setKeywords(articulo.getKeywords());
                articuloTemp.setNumAuthors(articulo.getNumAuthors());
                objArticulo = articuloTemp;
                break;
            }
        }
        return objArticulo;
    }

    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar articulo");
        boolean result = false;
        ArticleEntity objArticulo = null;
        objArticulo = findById(id);
        if (objArticulo != null) {
            result = listaArticulos.remove(objArticulo);
        }
        return result;
    }

    public boolean articleExist(Integer id) {
        boolean result = false;
        for (ArticleEntity articulo : listaArticulos) {
            if (articulo.getId() == id) {
                result = true;
                break;
            }
        }
        return result;
    }

    private void loadArticles() {
        listaArticulos.add(new ArticleEntity(1, "Articulo 1", "Revista 1", "Politica, Articulo", 1));
        listaArticulos.add(new ArticleEntity(2, "Articulo 2", "Revista 2", "Ciencias, Articulo2", 3));
        listaArticulos.add(new ArticleEntity(3, "Articulo 3", "Revista 3", "IOT, Articulo3", 2));
    }
}
