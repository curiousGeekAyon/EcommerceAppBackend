package DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
    String name;
    Integer id;
    String imageUrl;
}
