package co.edu.unicauca.correo.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleDTO {
    private Integer id;
    private String title;
    private String journal;
    private String keywords;
    private Integer cantAuthors;

    public ArticleDTO() {
    }
}
