package co.edu.unicauca.api_rest_conferencia.capaAccesoADatos.repositories;
import co.edu.unicauca.api_rest_conferencia.capaAccesoADatos.models.ArticleEntity;
import co.edu.unicauca.api_rest_conferencia.capaAccesoADatos.models.ConferenceEntity;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Repository
public class ConferenceRepository {
    private ArrayList<ConferenceEntity> listaConferencias;
    private int pos;

    public ConferenceRepository() {
        this.listaConferencias = new ArrayList<ConferenceEntity>();
        loadConferences();
        pos=this.listaConferencias.size()+1;
    }

    public ArrayList<ConferenceEntity> findAll() {
        System.out.println("Invocando a listarConferencias");
        return this.listaConferencias;
    }

    public ConferenceEntity findById(Integer id) {
        System.out.println("Invocando a consultar una conferencia");
        ConferenceEntity objConferencia = null;
        for (ConferenceEntity conferencia : listaConferencias) {
            if (conferencia.getId() == id) {
                System.out.println("Conferencia encontrada: " + conferencia.getName());
                objConferencia = conferencia;
                break;
            }
        }
        return objConferencia;
    }

    public ConferenceEntity save(ConferenceEntity conferencia) {
        System.out.println("Invocando a registrar conferencia");
        ConferenceEntity objConferencia = null;
        conferencia.setId(pos);
        if (this.listaConferencias.add(conferencia)) {
            objConferencia = conferencia;
            pos++;
        }
        return objConferencia;
    }

    public int getCantMaxArticulos(Integer id) {
        System.out.println("Invocando a consultar la cantidad maxima de articulos de una conferencia");
        int cantMaxArticulos = 0;
        for (ConferenceEntity conferencia : listaConferencias) {
            if (conferencia.getId() == id) {
                cantMaxArticulos = conferencia.getCantMaxArticles();
                break;
            }
        }
        return cantMaxArticulos;
    }

    public ConferenceEntity update(ConferenceEntity conferencia) {
        System.out.println("Invocando a actualizar conferencia");
        ConferenceEntity objConferencia = null;
        for (ConferenceEntity conferenciaAux : listaConferencias) {
            if (conferenciaAux.getId() == conferencia.getId()) {
                conferenciaAux.setName(conferencia.getName());
                conferenciaAux.setStartDate(conferencia.getStartDate());
                conferenciaAux.setEndDate(conferencia.getEndDate());
                conferenciaAux.setPlace(conferencia.getPlace());
                conferenciaAux.setCantMaxArticles(conferencia.getCantMaxArticles());
                conferenciaAux.setArticles(conferencia.getArticles());
                objConferencia = conferenciaAux;
                break;
            }
        }
        return objConferencia;
    }

    public List<ConferenceEntity> obtenerConferenciasDeArticulo(Integer idArticulo) {
        System.out.println("Invocando a obtener conferencias de un articulo");
        ArrayList<ConferenceEntity> listaConferenciasArticulo = new ArrayList<>();
        for(int i = 0; i < this.listaConferencias.size(); i++){
            List<ArticleEntity> listaArticulos = listaConferencias.get(i).getArticles();
            for(int j = 0; j < listaArticulos.size(); j++){
                if(listaArticulos.get(j).getId() == idArticulo){
                    listaConferenciasArticulo.add(this.listaConferencias.get(i));
                    System.out.println("Conferencia encontrada: " + this.listaConferencias.get(i).getName());
                    break;
                }
            }
        }
        System.out.println("Lista retornada: " + listaConferenciasArticulo.size());
        return listaConferenciasArticulo;
    }

    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar conferencia");
        ConferenceEntity objConferencia = null;
        for (ConferenceEntity conferencia : listaConferencias) {
            if (conferencia.getId() == id) {
                objConferencia = conferencia;
                break;
            }
        }
        if (objConferencia != null) {
            this.listaConferencias.remove(objConferencia);
            return true;
        }
        return false;
    }

    public boolean doesConferenceExist(Integer id) {
        System.out.println("Invocando a verificar si existe una conferencia");
        for (ConferenceEntity conferencia : listaConferencias) {
            if (conferencia.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public int getNumArticles(Integer id) {
        System.out.println("Invocando a consultar la cantidad de articulos de una conferencia");
        int numArticles = 0;
        for (ConferenceEntity conferencia : listaConferencias) {
            if (conferencia.getId() == id) {
                numArticles = conferencia.getArticles().size();
                break;
            }
        }
        return numArticles;
    }




    private void loadConferences() {
            try {
                System.out.println("Loading conferences...");
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                ArticleEntity articulo1 = new ArticleEntity(1);
                ArticleEntity articulo2 = new ArticleEntity(2);
                ArticleEntity articulo3 = new ArticleEntity(3);
                ArticleEntity articulo4 = new ArticleEntity(4);
                ArticleEntity articulo5 = new ArticleEntity(5);
                ArticleEntity articulo6 = new ArticleEntity(6);
                ArticleEntity articulo7 = new ArticleEntity(7);

                ArrayList<ArticleEntity> listaDeArticulosConferencia1 = new ArrayList<>();
                ArrayList<ArticleEntity> listaDeArticulosConferencia2 = new ArrayList<>();
                ArrayList<ArticleEntity> listaDeArticulosConferencia4 = new ArrayList<>();
                ArrayList<ArticleEntity> listaDeArticulosConferencia3 = new ArrayList<>();

                listaDeArticulosConferencia1.add(articulo1);
                listaDeArticulosConferencia1.add(articulo2);
                listaDeArticulosConferencia1.add(articulo4);
                
                listaDeArticulosConferencia2.add(articulo3);
                listaDeArticulosConferencia2.add(articulo7);

                listaDeArticulosConferencia3.add(articulo5);

                listaDeArticulosConferencia4.add(articulo6);

                this.listaConferencias.add(new ConferenceEntity(2, "Conferencia 2", formatter.parse("01/01/2024"), formatter.parse("01/02/2024"), "Popayan", 10, listaDeArticulosConferencia2));
                this.listaConferencias.add(new ConferenceEntity(1, "Conferencia 1", formatter.parse("01/01/2024"), formatter.parse("01/02/2024"), "Cali", 5, listaDeArticulosConferencia1));
                this.listaConferencias.add(new ConferenceEntity(3, "Conferencia 3", formatter.parse("01/01/2024"), formatter.parse("01/02/2024"), "Bucaramanga", 15, listaDeArticulosConferencia3));
                this.listaConferencias.add(new ConferenceEntity(4, "Conferencia 4", formatter.parse("01/01/2024"), formatter.parse("01/02/2024"), "Popayan", 20, listaDeArticulosConferencia4));
            } catch (ParseException e) {
            }
    }
}
