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
@AllArgsConstructor
@NoArgsConstructor
@Component
@Builder

public class APICategoryDto {
    Integer id;
    String name;
    String slug;
    String image;
}
