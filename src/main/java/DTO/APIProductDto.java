package DTO;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class APIProductDto {
    private Integer id;
    private String title;
    private String slug;
    private Integer price;
    private String description;
    private APICategoryDto category;
    private List<String> images;
    private String creationAt;
    private String updatedAt;
}
