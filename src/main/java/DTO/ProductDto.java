package DTO;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ProductDto {
    private Integer id;
    private String title;
    private Integer price;
    private String description;
    private Integer categoryId;
    private List<String> images;
}
